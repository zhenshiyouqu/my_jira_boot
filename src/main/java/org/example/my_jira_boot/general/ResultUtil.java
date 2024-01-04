package org.example.my_jira_boot.general;

public class ResultUtil {
    public static <T> Result<T>  defineSuccess(Integer code, T data) {
        Result result = new Result<>();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.code);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.code) ;
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> defineFail(int code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> define(int code, String msg, T data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
