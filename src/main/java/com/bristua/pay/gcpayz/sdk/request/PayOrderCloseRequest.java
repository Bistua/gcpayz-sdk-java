package com.bristua.pay.gcpayz.sdk.request;

import com.bristua.pay.gcpayz.sdk.GcPayzSDK;
import com.bristua.pay.gcpayz.sdk.model.GcPayzObject;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.response.PayOrderCloseResponse;

/**
 * GcPayz支付 订单关闭请求实现
 *
 * @author xiaoyu
 * @site https://www.gcpayz.com
 * @date 2022/1/25 9:56
 */
public class PayOrderCloseRequest implements GcPayzRequest<PayOrderCloseResponse> {

    private String apiVersion = GcPayzSDK.VERSION;
    private String apiUri = "api/pay/close";
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
    public Class<PayOrderCloseResponse> getResponseClass() {
        return PayOrderCloseResponse.class;
    }

}
