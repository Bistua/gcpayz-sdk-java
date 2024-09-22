package com.bristua.pay.gcpayz.sdk;

import com.bristua.pay.gcpayz.sdk.exception.GcPayzException;
import com.bristua.pay.gcpayz.sdk.model.ChannelUserReqModel;
import com.bristua.pay.gcpayz.sdk.model.TransferOrderCreateReqModel;
import com.bristua.pay.gcpayz.sdk.model.TransferOrderQueryReqModel;
import com.bristua.pay.gcpayz.sdk.request.ChannelUserRequest;
import com.bristua.pay.gcpayz.sdk.request.TransferOrderCreateRequest;
import com.bristua.pay.gcpayz.sdk.request.TransferOrderQueryRequest;
import com.bristua.pay.gcpayz.sdk.response.TransferOrderCreateResponse;
import com.bristua.pay.gcpayz.sdk.response.TransferOrderQueryResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class TransferOrderTest {

    final static Logger _log = LoggerFactory.getLogger(TransferOrderTest.class);

    @BeforeAll
    public static void initApiKey() {
        GcPayzSDK.setApiBase(GcPayzTestData.getApiBase());
        GcPayzSDK.apiKey = GcPayzTestData.getApiKey();
        GcPayzSDK.mchNo = GcPayzTestData.getMchNo();
        GcPayzSDK.appId = GcPayzTestData.getAppId();
    }

    @Test
    public void testTransferOrderCreate() {
        GcPayzClient gcPayzClient = GcPayzClient.getInstance(GcPayzSDK.appId, GcPayzSDK.apiKey,
            GcPayzSDK.getApiBase());
        TransferOrderCreateRequest request = new TransferOrderCreateRequest();
        TransferOrderCreateReqModel model = new TransferOrderCreateReqModel();
        model.setMchNo(GcPayzSDK.mchNo);                       // 商户号
        model.setAppId(gcPayzClient.getAppId());            // 应用ID
        model.setMchOrderNo("mho" + new Date().getTime());                // 商户转账单号
        model.setAmount(1L);
        model.setCurrency("CNY");
        model.setIfCode("wxpay");
        model.setEntryType("WX_CASH");
        model.setAccountNo("a6BcIwtTvIqv1zXZohc61biryWok");
        model.setAccountName("");
        model.setTransferDesc("测试转账");
        model.setClientIp("192.166.1.132");                 // 发起转账请求客户端的IP地址
        request.setBizModel(model);

        try {
            TransferOrderCreateResponse response = gcPayzClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(GcPayzSDK.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if (response.isSuccess(GcPayzSDK.apiKey)) {
                String transferId = response.get().getTransferId();
                _log.info("transferId：{}", transferId);
                _log.info("mchOrderNo：{}", response.get().getMchOrderNo());
            } else {
                _log.info("下单失败：mchOrderNo={}, msg={}", model.getMchOrderNo(), response.getMsg());
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (GcPayzException e) {
            _log.error(e.getMessage());
        }

    }

    @Test
    public void testTransferOrderQuery() {
        GcPayzClient gcPayzClient = GcPayzClient.getInstance(GcPayzSDK.appId, GcPayzSDK.apiKey,
            GcPayzSDK.getApiBase());
        TransferOrderQueryRequest request = new TransferOrderQueryRequest();
        TransferOrderQueryReqModel model = new TransferOrderQueryReqModel();
        model.setMchNo(GcPayzSDK.mchNo);                                          // 商户号
        model.setAppId(gcPayzClient.getAppId());                               // 应用ID
        model.setTransferId("T202108121543441860003");                         // 转账单号
        request.setBizModel(model);
        try {
            TransferOrderQueryResponse response = gcPayzClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(GcPayzSDK.apiKey));
            if (response.isSuccess(GcPayzSDK.apiKey)) {
                _log.info("订单信息：{}", response);
                _log.info("转账状态：{}", response.get().getState());
                _log.info("转账金额：{}", response.get().getAmount());
            }
        } catch (GcPayzException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void getChannelUserIdUrl() {
        GcPayzClient gcPayzClient = GcPayzClient.getInstance(GcPayzSDK.appId, GcPayzSDK.apiKey,
            GcPayzSDK.getApiBase());
        ChannelUserRequest request = new ChannelUserRequest();
        ChannelUserReqModel model = new ChannelUserReqModel();
        model.setAppId(gcPayzClient.getAppId());
        model.setMchNo(GcPayzSDK.mchNo);
        model.setRedirectUrl("https://httpdump.io/30cbe");
        model.setIfCode("AUTO");
        request.setBizModel(model);

        try {
            String url = gcPayzClient.getRequestUrl(request);
            _log.info("跳转 URL: {}", url);
        } catch (GcPayzException e) {
            e.printStackTrace();
        }

    }
}
