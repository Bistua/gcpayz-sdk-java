package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.PayOrderDivisionExecResModel;


/***
* 发起分账响应实现
*
* @author terrfly
* @site https://www.gcpayz.com
* @date 2021/8/27 10:22
*/
public class PayOrderDivisionExecResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public PayOrderDivisionExecResModel get() {
        if(getData() == null) return new PayOrderDivisionExecResModel();
        return getData().toJavaObject(PayOrderDivisionExecResModel.class);
    }

    @Override
    public boolean isSuccess(String apiKey) {
        if(super.isSuccess(apiKey)) {
            int state = get().getState();
            return state == 1;
        }
        return false;
    }

}
