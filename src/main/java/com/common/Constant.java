package com.common;

/**
 * 系统常量
 */
public class Constant {

    /**
     * 系统字符集
     */
    static final public String CHAR_SET = "UTF-8";
    /**
     * 自定义异步非阻塞客户端
     */
    static final public String CUSTOM_CLIENT_ASYNC = "CUSTOM_CLIENT_ASYNC";
    /**
     * 第三方异步非阻塞客户端
     */
    static final public String THIRD_CLIENT_ASYNC = "THIRD_CLIENT_ASYNC";

    static final public String REQUEST_METHOD = "method";
    static final public String REQUEST_URI = "uri";
    static final public String REQUEST_VERSION = "version";
    static final public String CHANNEL_HASH_CODE = "hashCode";

    public static class HeaderKey{
        static final public String ACCEPT_ENCODING = "Accept-Encoding";
    }

}