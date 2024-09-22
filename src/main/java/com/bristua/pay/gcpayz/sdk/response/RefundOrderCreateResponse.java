package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.RefundOrderCreateResModel;

/**
 * GcPayz退款响应实现
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-18 09:00
 */
public class RefundOrderCreateResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public RefundOrderCreateResModel get() {
        if(getData() == null) return new RefundOrderCreateResModel();
        return getData().toJavaObject(RefundOrderCreateResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        if(super.isSuccess(apiKey)) {
            int state = get().getState();
            return state == 0 || state == 1 || state == 2;
        }
        return false;
    }

}
