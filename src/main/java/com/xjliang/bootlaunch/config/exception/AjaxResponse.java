package com.xjliang.bootlaunch.config.exception;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AjaxResponse {

    @ApiModelProperty("是否请求成功")
    private boolean isok;

    private int code;

    private String message;

    private Object data;

    private AjaxResponse() {

    }

    //请求出现异常时的响应数据封装
    public static AjaxResponse error(CustomException e) {

        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：1375610xxxx进行处理!");
        }else{
            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108xxx进行处理!");
        }
        return resultBean;
    }

    public static AjaxResponse success() {
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("success");
        return response;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse response = new AjaxResponse();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("success");
        response.setData(data);
        return response;
    }
}
