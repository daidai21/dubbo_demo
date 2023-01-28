package com.example.demo.server;

import com.example.demo.api.Consts;
import com.example.demo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;


@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        String result;

        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        String clientIP = RpcContext.getContext().getRemoteHost();
        String remoteApplication = RpcContext.getContext().getRemoteApplicationName();
        String application = RpcContext.getContext().getUrl().getParameter("application");

        result = "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress() +
                ", client: " + clientIP + ", local: " + application + ", remote: " + remoteApplication +
                ", isProviderSide: " + isProviderSide;


        result += "\n" + Consts.TraceName + " { " + RpcContext.getContext().getAttachment(Consts.TraceName) + " }";

        System.out.println("req " + Consts.TraceName + " :  " + RpcContext.getContext().getAttachment(Consts.TraceName));

        return result;
    }
}
