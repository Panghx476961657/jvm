package com.nio02.filter;

import com.common.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        HttpHeaders headers = fullRequest.headers();
        log.debug("HttpHeaders:{}", headers);
        //通过header参数进行一些签名校验，解压，登录校验等操作
        String accept_encoding = headers.get(Constant.HeaderKey.ACCEPT_ENCODING);
        //参数解析
        ByteBuf content = fullRequest.content();
        String body = content.toString(CharsetUtil.UTF_8);
        log.debug("body:{}", body);
        fullRequest.headers().set("mao", "soul");
    }
}
