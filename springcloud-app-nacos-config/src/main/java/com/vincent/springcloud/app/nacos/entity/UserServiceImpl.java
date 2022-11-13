package com.vincent.springcloud.app.nacos.entity;

/**
 * @author vincent.li
 * @date 2022/11/14 00:01
 */

import com.vincent.springcloud.app.nacos.dao.UserMapper;
import com.vincent.springcloud.app.nacos.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vincent.li
 * @description 用户信息表
 * @date 2022-11-13
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Long insert(User user) {

        Assert.notNull(user, "入参不能为空");
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public Boolean delete(int id) {
        int ret = userMapper.delete(id);
        return ret > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean update(User user) {
        int ret = userMapper.update(user);
        return ret > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public User load(int id) {
        return userMapper.load(id);
    }

    @Override
    public Map<String, Object> pageList(int offset, int pagesize) {

        List<User> pageList = userMapper.pageList(offset, pagesize);
        int totalCount = userMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

}
