package com.userServer.vo;

/**
 * 这个类用途是给前端页面返回统一的信息
 */
public class ResultVO {

    private Integer code;//用数字表示业务的成功与否，0表示成功，其他均为失败
    private String msg;//对code进行解释的信息(文案)
    private Object data;//数据信息（List、Array[]等）

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVO success() {
        ResultVO res = new ResultVO(200, "成功");
        return res;
    }

    public static ResultVO success(String msg) {
        ResultVO res = new ResultVO(200, msg);
        return res;
    }

    public static ResultVO success(Object data) {
        ResultVO res = new ResultVO(200, "成功", data);
        return res;
    }

    public static ResultVO success(String msg, Object data) {
        ResultVO res = new ResultVO(200, msg, data);
        return res;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO res = new ResultVO(code, msg);
        return res;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
