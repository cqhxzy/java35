package com.hxzy.vo;

/**
 * 专门响应ajax请求的数据
 */
public class AjaxResult {
    private boolean flag = false; //请求执行结果，true为成功，false失败
    private Object data; //如果成功，向客户端响应的数据

    public AjaxResult() {
    }

    public AjaxResult(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
