package com.nio02.filter;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        String body = response.content().toString(CharsetUtil.UTF_8);
        //返回体压缩，加密，签名等
    }
}
