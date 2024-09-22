package com.bristua.pay.gcpayz.sdk.model;

/**
 * 关闭订单响应结果
 *
 * @author xiaoyu
 * @site https://www.gcpayz.com
 * @date 2022/1/25 9:55
 */
public class PayOrderCloseResModel extends GcPayzObject {

    /**
     * 支付渠道错误码
     */
    private String errCode;

    /**
     * 支付渠道错误信息
     */
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
