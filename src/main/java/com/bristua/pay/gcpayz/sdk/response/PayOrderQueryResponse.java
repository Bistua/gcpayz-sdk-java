package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.PayOrderQueryResModel;

/**
 * GcPayz支付查单响应实现
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public class PayOrderQueryResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public PayOrderQueryResModel get() {
        if(getData() == null) return new PayOrderQueryResModel();
        return getData().toJavaObject(PayOrderQueryResModel.class);
    }

}
