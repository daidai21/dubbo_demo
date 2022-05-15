#!/usr/bin/env bash


# #############################################################################
# File Name   : start.sh
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 日  5/15 21:35:40 2022
# #############################################################################

# 拉取镜像 && 后台启动服务
docker-compose up -d

# 查看运行中的服务
docker-compose ps

# 停止服务
# docker-compose down
