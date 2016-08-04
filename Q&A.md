# Questions and answers

#### Which share of web users will this implementation address? Should it be increased and how?

This implementation use WebSocket and of course, the client, webbrowser should be compatible with WebSocket.
According to [caniuse](http://caniuse.com/#feat=websockets), it's widely avalaible now.

Nevertheless, we could increase it using a Comet fallback mechanism with socket.io.

But, our purpose is webRTC, so we need it to be available in clients. When RTC is available, WebSocket is. So I think we're goot with WebSockets.

#### How many users can connect to one server?

We use 1 webSocket per user so the limit is the maximum number of alive webSocket on the machine, so the max tcp connection, so the max open filedescriptor.

#### How can the system support more systems?
I guess the question is about more users. More users means more machines and so load balancing.
A problem occur when A and B are on differents nodes (Node 1 and Node 2). Node 1 have no idea of peer B existence. A message queue could be an helpfull solution. Node 1 send the message for B in the queue and the other nodes will receive and have the opportnuity to treat the message.
#### How to reduce the attack surface of the systems?


#### Should an authentication mechanism be put in place and if yes, how?
