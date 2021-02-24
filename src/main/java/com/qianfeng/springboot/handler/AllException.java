package com.qianfeng.springboot.handler;


import com.qianfeng.springboot.Exceptions.MyException;
import com.qianfeng.springboot.enums.MyEnum;
import com.qianfeng.springboot.page.Message;
import com.qianfeng.springboot.page.Result;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllException {

    @ResponseBody
    @ExceptionHandler(value = {MyException.class})
    public Result resultException(MyException e){
        e.printStackTrace();
        Result result = new Result();
        Message message = new Message();
        message.setCode(e.getCode());
        message.setMessage(e.getMessage());
        result.setMessage(message);
        return result;
    }

    /**
     * 添加shiro认证
     */
    @ResponseBody
    @ExceptionHandler(value = {RuntimeException.class})
    public Result resultMyException(RuntimeException e){
        e.printStackTrace();
        Result result1 = new Result();
        Message message = new Message(MyEnum.OTHER_ERROR);
        result1.setMessage(message);
        if (e instanceof UnauthenticatedException){
            Result result = new Result();
            message = new Message(MyEnum.AUTHENTICATION_ERROR);
            result.setMessage(message);
            return result;
        }
        if (e instanceof UnauthorizedException){
             Result result = new Result();
             message = new Message(MyEnum.AUTHORIZATION_ERROR);
             result.setMessage(message);
        }
        return result1;
    }
}
