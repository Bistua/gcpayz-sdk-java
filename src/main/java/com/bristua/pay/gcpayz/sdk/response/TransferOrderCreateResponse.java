package com.bristua.pay.gcpayz.sdk.response;

import com.bristua.pay.gcpayz.sdk.model.TransferOrderCreateResModel;

/***
* GcPayz转账响应实现
*
* @author terrfly
* @site https://www.gcpayz.com
* @date 2021/8/13 16:25
*/
public class TransferOrderCreateResponse extends GcPayzResponse {

    private static final long serialVersionUID = 7419683269497002904L;

    public TransferOrderCreateResModel get() {
        if(getData() == null) {
            return new TransferOrderCreateResModel();
        }
        return getData().toJavaObject(TransferOrderCreateResModel.class);
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
