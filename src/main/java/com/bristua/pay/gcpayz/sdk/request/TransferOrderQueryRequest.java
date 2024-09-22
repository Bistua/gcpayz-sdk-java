package com.bristua.pay.gcpayz.sdk.request;

import com.bristua.pay.gcpayz.sdk.GcPayzSDK;
import com.bristua.pay.gcpayz.sdk.model.GcPayzObject;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.response.TransferOrderQueryResponse;

/***
* GcPayz转账查询请求实现
*
* @author terrfly
* @site https://www.gcpayz.com
* @date 2021/8/16 16:26
*/
public class TransferOrderQueryRequest implements GcPayzRequest<TransferOrderQueryResponse> {

    private String apiVersion = GcPayzSDK.VERSION;
    private String apiUri = "api/transfer/query";
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
    public Class<TransferOrderQueryResponse> getResponseClass() {
        return TransferOrderQueryResponse.class;
    }

}
