package com.bristua.pay.gcpayz.sdk.request;

import com.bristua.pay.gcpayz.sdk.GcPayzSDK;
import com.bristua.pay.gcpayz.sdk.model.GcPayzObject;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.response.RefundOrderCreateResponse;

/**
 * GcPayz退款请求实现
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-18 09:00
 */
public class RefundOrderCreateRequest implements GcPayzRequest<RefundOrderCreateResponse> {

    private String apiVersion = GcPayzSDK.VERSION;
    private String apiUri = "api/refund/refundOrder";
    private RequestOptions options;
    private GcPayzObject bizModel = null;

    @Override
    public String getApiUri() {
        return this.apiUri;
    }

    @Override
    public String getApiVersion() {
        return this.apiVersion;
    }

    @Override
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public RequestOptions getRequestOptions() {
        return this.options;
    }

    @Override
    public void setRequestOptions(RequestOptions options) {
        this.options = options;
    }

    @Override
    public GcPayzObject getBizModel() {
        return this.bizModel;
    }

    @Override
    public void setBizModel(GcPayzObject bizModel) {
        this.bizModel = bizModel;
    }

    @Override
    public Class<RefundOrderCreateResponse> getResponseClass() {
        return RefundOrderCreateResponse.class;
    }

}
