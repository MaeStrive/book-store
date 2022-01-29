package com.atmae.store.controller;

import com.atmae.store.controller.ex.*;
import com.atmae.store.entity.User;
import com.atmae.store.service.IUserService;
import com.atmae.store.util.JsonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author Mae
 */
@RestController
/** 等效于: @Controller+@ResponseBody()  //此方法的响应结果以Json格式进行数据的响应 给到前端*/
@RequestMapping("/users")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    @RequestMapping("/register")
    public JsonResult<Void> register(User user) {
        userService.register(user);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        // 向session对象中完成数据的绑定
        session.setAttribute("img", data.getAvatar());
        session.setAttribute("userId", data.getUserId());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/changePassword")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession httpSession) {
        Integer userId = getUidFromSession(httpSession);
        String username = getUsernameFromSession(httpSession);
        userService.changePassword(userId, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    @GetMapping("/getByUserId")
    public JsonResult<User> getByUserId(HttpSession session) {
        User data = userService.getInfoByUserId(getUidFromSession(session));
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/changeInfo")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        /** User 对象有四部分数据 username、phone、email、gender
         * userID 需要再次封装到 user 对象中
         */
        Integer userId = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(userId, username, user);
        return new JsonResult<>(OK);
    }

    /**
     * 上传文件的最大值
     */
    private static final long AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    /**
     * 限制上传文件的类型
     */
    private static final List<String> AVATAR_TYPE = new ArrayList<>();

    /** 静态块给集合初始化*/
    static {
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping("/changeAvatar")
    public JsonResult<String> changeAvatar(HttpServletResponse response, HttpSession session, MultipartFile file) throws FileNotFoundException {
        /** 判断文件是否为空*/
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        /** 判断文件是否超出大小*/
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        /** 判断文件类型是否是规定的和后缀类型*/
        String contentType = file.getContentType();
        /** 如何集合包含某个元素则返回true*/
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }
        /** 上传的文件放在 .../assets/img/avatar/  .(后缀)下*/
        String property = System.getProperty("user.dir");
        String path = property + "\\store\\src\\main\\resources\\static\\assets\\img\\avatar";
        /** File对象指向这个路径，File是否存在*/
        File dir = new File(path);
        /** 检测目录是否存在*/
        if (!dir.exists()) {
            /** 创建当前的目录*/
            dir.mkdirs();
        }
        /** 获取到这个文件名称 UUID工具来将生成一个新的字符串作为文件名*/
        String originalFilename = file.getOriginalFilename();
        /** 文件后缀*/
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        /** 这是一个空文件*/
        File dest = new File(dir, filename);
        /** 参数file中数据写入到这个空文件中*/
        try {
            /** 将file文件中的数据写入到dest文件中*/
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        } catch (FileStateException e) {
            throw new FileSizeException("文件状态异常");
        }
        Integer userId = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        /** 返回头像的路径*/
        String avatar = "assets/img/avatar/" + filename;
        userService.changeAvatar(userId, avatar, username);
        /** 存储cookie 响应给客户端*/
        Cookie cookie = new Cookie("img", avatar);
        response.addCookie(cookie);
        /** 返回用户头像的路径给前端页面，将来用于头像展示使用*/
        return new JsonResult<>(OK, avatar);
    }
}
