

run log:

```shell
====================
hello, world   sync
hello, world   sync
hello, world   sync
hello, world   sync
hello, world   sync
Cost: 5512ms
====================


====================
send: world   async
send: world   async
send: world   async
send: world   async
send: world   async
get: hello, world   async
get: hello, world   async
get: hello, world   async
get: hello, world   async
get: hello, world   async
Cost: 1165ms
====================


====================
send: world   async future
send: world   async future
send: world   async future
send: world   async future
send: world   async future
get: hello, world   async
get: hello, world   async
get: hello, world   async
get: hello, world   async
get: hello, world   async
Cost: 1124ms
====================
```
