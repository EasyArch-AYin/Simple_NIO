package http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HandlerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //向管道加入处理器

        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //加入一个netty提供的httpServerCodec codec=>[coder - decoder]
        //HttpServerCodec 说明---HttpServerCodec是netty提供的处理http的编-解码器
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        //增加一个自定义的handler
        pipeline.addLast("MyTestServerHandler",new ServerHandler());
    }
}
