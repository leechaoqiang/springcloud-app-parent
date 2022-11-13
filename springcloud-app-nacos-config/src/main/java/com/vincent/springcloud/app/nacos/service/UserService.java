package com.vincent.springcloud.app.nacos.service;

import com.vincent.springcloud.app.nacos.entity.User;

import java.util.Map;

/**
 * @description 用户信息表
 * @author vincent.li
 * @date 2022-11-13
 */
public interface UserService {

    /**
     * 新增
     */
    public Long insert(User user);

    /**
     * 删除
     */
    public Boolean delete(int id);

    /**
     * 更新
     */
    public Boolean update(User user);

    /**
     * 根据主键 id 查询
     */
    public User load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}
