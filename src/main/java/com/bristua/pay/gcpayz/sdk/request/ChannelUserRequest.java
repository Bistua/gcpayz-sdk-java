package com.bristua.pay.gcpayz.sdk.request;

import com.bristua.pay.gcpayz.sdk.model.GcPayzObject;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.response.ChannelUserResponse;

/**
 * 仅仅用于查询渠道用户信息，编译出具体 URL 并不会产生实际请求
 */
public class ChannelUserRequest implements GcPayzRequest<ChannelUserResponse> {

    private final String apiUri = "api/channelUserId/jump";
    private String apiVersion = "1.0";
    private RequestOptions options;
    private GcPayzObject bizModel = null;

    public ChannelUserRequest() {
    }

    public String getApiUri() {
        return this.apiUri;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public RequestOptions getRequestOptions() {
        return this.options;
    }

    public void setRequestOptions(RequestOptions options) {
        this.options = options;
    }

    public GcPayzObject getBizModel() {
        return this.bizModel;
    }

    public void setBizModel(GcPayzObject bizModel) {
        this.bizModel = bizModel;
    }

    public Class<ChannelUserResponse> getResponseClass() {
        return ChannelUserResponse.class;
    }
}
