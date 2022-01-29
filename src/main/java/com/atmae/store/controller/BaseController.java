package com.atmae.store.controller;

import com.atmae.store.controller.ex.*;
import com.atmae.store.service.ex.*;
import com.atmae.store.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制层类的基类
 *
 * @author Mae
 */
public class BaseController {
    /**
     * 操作成功的状态码
     */
    public static final int OK = 200;

    /**
     * 请求处理方法
     * 当前项目产生了异常 被统一拦截到此方法中，
     * 这个方法就充当了请求处理的方法，方法的返回值直接返回到前端
     */
    @ExceptionHandler(value = {ServiceException.class, FileUploadException.class})  //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4001);
            result.setMessage("用户收货地址超出上限异常");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4002);
            result.setMessage("非法访问异常");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4003);
            result.setMessage("收货地址没有发现异常");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4004);
            result.setMessage("商品没有被发现异常");
        } else if (e instanceof CartNotFoundException) {
            result.setState(4005);
            result.setMessage("购物车商品没有找到");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户没有找到的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("用户名的密码不匹配的异常");
        } else if (e instanceof UpdateException) {
            result.setState(5003);
            result.setMessage("更新数据时产生未知的异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6001);
            result.setMessage("文件为空异常");
        } else if (e instanceof FileSizeException) {
            result.setState(6002);
            result.setMessage("文件大小异常");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("文件状态异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("文件加载IO异常");
        } else if (e instanceof FileTypeException) {
            result.setState(6005);
            result.setMessage("文件类型异常");
        }
        return result;
    }

    /**
     * 获取Session对象中的Uid
     *
     * @param session session对象
     * @return 当前对象的Uid
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("userId")
                .toString());
    }

    /**
     * 获取Session对象的用户名
     *
     * @param session
     * @return
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
