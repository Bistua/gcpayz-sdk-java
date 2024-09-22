package com.bristua.pay.gcpayz.sdk.request;

import com.bristua.pay.gcpayz.sdk.model.GcPayzObject;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.response.GcPayzResponse;

/**
 * GcPayz请求接口
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public interface GcPayzRequest<T extends GcPayzResponse> {

    /**
     * 获取当前接口的路径
     * @return
     */
    String getApiUri();

    /**
     * 获取当前接口的版本
     * @return
     */
    String getApiVersion();

    /**
     * 设置当前接口的版本
     * @return
     */
    void setApiVersion(String apiVersion);

    RequestOptions getRequestOptions();

    void setRequestOptions(RequestOptions options);

    GcPayzObject getBizModel();

    void setBizModel(GcPayzObject bizModel);

    Class<T> getResponseClass();

}
