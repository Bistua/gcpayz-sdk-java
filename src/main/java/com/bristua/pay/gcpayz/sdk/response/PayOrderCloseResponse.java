package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.PayOrderCloseResModel;

/**
 * GcPayz支付 关闭订单响应实现
 *
 * @author xiaoyu
 * @site https://www.gcpayz.com
 * @date 2022/1/25 9:56
 */
public class PayOrderCloseResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public PayOrderCloseResModel get() {
        if(getData() == null) return new PayOrderCloseResModel();
        return getData().toJavaObject(PayOrderCloseResModel.class);
    }

}
