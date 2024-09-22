package com.bristua.pay.gcpayz.sdk;

import com.bristua.pay.gcpayz.sdk.exception.GcPayzException;
import com.bristua.pay.gcpayz.sdk.model.DivisionReceiverBindReqModel;
import com.bristua.pay.gcpayz.sdk.request.DivisionReceiverBindRequest;
import com.bristua.pay.gcpayz.sdk.response.DivisionReceiverBindResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DivisionReceiverBindTest {

    final static Logger _log = LoggerFactory.getLogger(DivisionReceiverBindTest.class);

    @BeforeAll
    public static void initApiKey() {
        GcPayzSDK.setApiBase(GcPayzTestData.getApiBase());
        GcPayzSDK.apiKey = GcPayzTestData.getApiKey();
        GcPayzSDK.mchNo = GcPayzTestData.getMchNo();
        GcPayzSDK.appId = GcPayzTestData.getAppId();
    }

    @Test
    public void testDivisionReceiverBind() {
        GcPayzClient gcPayzClient = GcPayzClient.getInstance(GcPayzSDK.appId, GcPayzSDK.apiKey, GcPayzSDK.getApiBase());
        DivisionReceiverBindRequest request = new DivisionReceiverBindRequest();
        DivisionReceiverBindReqModel model = new DivisionReceiverBindReqModel();
        model.setMchNo(GcPayzSDK.mchNo);                       // 商户号
        model.setAppId(gcPayzClient.getAppId());            // 应用ID
        model.setIfCode("shengpay");
        model.setReceiverAlias("hee");
        model.setReceiverGroupId(100003L);
        model.setAccType((byte)1);
        model.setAccNo("32617592");
        model.setAccName("骏易科技");
        model.setRelationType("SERVICE_PROVIDER");
        model.setRelationTypeName("服务商");
        model.setDivisionProfit("0.10");
        request.setBizModel(model);

        try {
            DivisionReceiverBindResponse response = gcPayzClient.execute(request);
            _log.info("验签结果：{}", response.checkSign(GcPayzSDK.apiKey));
            // 判断转账发起是否成功（并不代表转账成功）
            if(response.isSuccess(GcPayzSDK.apiKey)) {
                _log.info("accNo：{}， 绑定成功", response.get().getAccNo());
            }else {
                _log.info("绑定失败：accNo：{}", model.getAccNo());
                _log.info("通道错误码：{}", response.get().getErrCode());
                _log.info("通道错误信息：{}", response.get().getErrMsg());
            }
        } catch (GcPayzException e) {
            _log.error(e.getMessage());
        }

    }

}
