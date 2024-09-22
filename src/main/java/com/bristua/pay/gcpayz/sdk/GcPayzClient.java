package com.bristua.pay.gcpayz.sdk;

import com.alibaba.fastjson.JSONObject;
import com.bristua.pay.gcpayz.sdk.exception.GcPayzException;
import com.bristua.pay.gcpayz.sdk.net.APIGcPayzRequest;
import com.bristua.pay.gcpayz.sdk.net.APIResource;
import com.bristua.pay.gcpayz.sdk.net.RequestOptions;
import com.bristua.pay.gcpayz.sdk.request.GcPayzRequest;
import com.bristua.pay.gcpayz.sdk.response.GcPayzResponse;
import com.bristua.pay.gcpayz.sdk.util.JSONWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * GcPayzSDK sdk客户端
 *
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public class GcPayzClient extends APIResource {

    private static final Map<String, GcPayzClient> clientMap = new HashMap<String, GcPayzClient>();

    private String appId;
    private String signType = GcPayzSDK.DEFAULT_SIGN_TYPE;
    private String apiKey = GcPayzSDK.apiKey;
    private String apiBase = GcPayzSDK.getApiBase();

    public GcPayzClient(String apiBase, String signType, String apiKey) {
        this.apiBase = apiBase;
        this.signType = signType;
        this.apiKey = apiKey;
    }

    public GcPayzClient(String apiBase, String apiKey) {
        this.apiBase = apiBase;
        this.apiKey = apiKey;
    }

    public GcPayzClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public GcPayzClient() {
    }

    public static synchronized GcPayzClient getInstance(String appId, String apiKey,
                                                        String apiBase) {
        GcPayzClient client = clientMap.get(appId);
        if (client != null) {
            return client;
        }
        client = new GcPayzClient();
        clientMap.put(appId, client);
        client.appId = appId;
        client.apiKey = apiKey;
        client.apiBase = apiBase;
        return client;
    }

    public static synchronized GcPayzClient getInstance(String appId, String apiKey) {
        GcPayzClient client = clientMap.get(appId);
        if (client != null) {
            return client;
        }
        client = new GcPayzClient();
        clientMap.put(appId, client);
        client.appId = appId;
        client.apiKey = apiKey;
        return client;
    }

    public static synchronized GcPayzClient getInstance(String appId) {
        GcPayzClient client = clientMap.get(appId);
        if (client != null) {
            return client;
        }
        client = new GcPayzClient();
        clientMap.put(appId, client);
        client.appId = appId;
        return client;
    }

    public String getAppId() {
        return appId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiBase() {
        return apiBase;
    }

    public void setApiBase(String apiBase) {
        this.apiBase = apiBase;
    }

    public <T extends GcPayzResponse> T execute(GcPayzRequest<T> request) throws GcPayzException {

        // 支持用户自己设置RequestOptions
        if (request.getRequestOptions() == null) {
            RequestOptions options = RequestOptions.builder()
                .setVersion(request.getApiVersion())
                .setUri(request.getApiUri())
                .setAppId(this.appId)
                .setApiKey(this.apiKey)
                .build();
            request.setRequestOptions(options);
        }

        return execute(request, RequestMethod.POST, this.apiBase);
    }


    public String getRequestUrl(GcPayzRequest request) throws GcPayzException {
        // 支持用户自己设置RequestOptions
        if (request.getRequestOptions() == null) {
            RequestOptions options = RequestOptions.builder()
                .setVersion(request.getApiVersion())
                .setUri(request.getApiUri())
                .setAppId(this.appId)
                .setApiKey(this.apiKey)
                .build();
            request.setRequestOptions(options);
        }
        String jsonParam = new JSONWriter().write(request.getBizModel(), true);

        JSONObject params = JSONObject.parseObject(jsonParam);
        request.getRequestOptions();

        return APIGcPayzRequest.buildURLWithSign(this.apiBase, params, request.getRequestOptions()).toString();
    }
}
