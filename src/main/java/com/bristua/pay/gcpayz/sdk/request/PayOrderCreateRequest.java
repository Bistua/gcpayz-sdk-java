package com.bristua.pay.gcpayz.sdk.request;

import com.bristua.pay.gcpayz.sdk.GcPayzSDK;
import com.bristua.pay.gcpayz.sdk.model.GcPayzObject;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.response.PayOrderCreateResponse;

/**
 * GcPayz支付下单请求实现
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public class PayOrderCreateRequest implements GcPayzRequest<PayOrderCreateResponse> {

    private String apiVersion = GcPayzSDK.VERSION;
    private String apiUri = "api/pay/unifiedOrder";
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
    public Class<PayOrderCreateResponse> getResponseClass() {
        return PayOrderCreateResponse.class;
    }

}
