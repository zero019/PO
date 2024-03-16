package com.zeronly.po.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResResult<T> {
     private Integer code;
     private String msg;
     private T data;

    public ResResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
   public ResResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static ResResult fail(Integer code, String msg) {
    	return new ResResult(code,msg);
    }
    public static ResResult fail() {
        return new ResResult(500,"fail");
    }
    public static ResResult ok(Integer code, String msg) {
    	return new ResResult(code,msg);
    }

    public static ResResult ok() {
        return new ResResult(200,"OK");
    }

    public static <T> ResResult<T> ok(T data) {
        ResResult<T> result = new ResResult<>();
        result.setCode(200);
        result.setData(data);
        return result;
    }
}

