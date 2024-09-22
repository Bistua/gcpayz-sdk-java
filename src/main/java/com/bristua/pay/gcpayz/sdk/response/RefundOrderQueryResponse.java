package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.RefundOrderQueryResModel;

/**
 * GcPayz退款查单响应实现
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-18 12:00
 */
public class RefundOrderQueryResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7654172640802954221L;

    public RefundOrderQueryResModel get() {
        if(getData() == null) return new RefundOrderQueryResModel();
        return getData().toJavaObject(RefundOrderQueryResModel.class);
    }

}
