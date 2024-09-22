package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.PayOrderCreateResModel;

/**
 * GcPayz支付下单响应实现
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
public class PayOrderCreateResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public PayOrderCreateResModel get() {
        if(getData() == null) return new PayOrderCreateResModel();
        return getData().toJavaObject(PayOrderCreateResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        if(super.isSuccess(apiKey)) {
            int orderState = get().getOrderState();
            return orderState == 0 || orderState == 1 || orderState == 2;
        }
        return false;
    }

}
