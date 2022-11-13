package com.vincent.springcloud.app.nacos.controller;

import com.vincent.springcloud.app.nacos.entity.User;
import com.vincent.springcloud.app.nacos.service.UserService;
import com.vincent.springcloud.common.model.vo.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description 用户信息表
 * @author vincent.li
 * @date 2022-11-13
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增
     * @author vincent.li
     * @date 2022/11/13
     **/
    @RequestMapping("/insert")
    public Response insert(User user){
        return Response.buildSuccess(userService.insert(user));
    }

    /**
     * 刪除
     * @author vincent.li
     * @date 2022/11/13
     **/
    @RequestMapping("/delete")
    public Response<Boolean> delete(int id){
        return Response.buildSuccess(userService.delete(id));
    }

    /**
     * 更新
     * @author vincent.li
     * @date 2022/11/13
     **/
    @RequestMapping("/update")
    public Response<Boolean> update(User user){
        return Response.buildSuccess(userService.update(user));
    }

    /**
     * 查询 根据主键 id 查询
     * @author vincent.li
     * @date 2022/11/13
     **/
    @RequestMapping("/load")
    public Response load(int id){
        return Response.buildSuccess(userService.load(id));
    }

    /**
     * 查询 分页查询
     * @author vincent.li
     * @date 2022/11/13
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);
    }

}
