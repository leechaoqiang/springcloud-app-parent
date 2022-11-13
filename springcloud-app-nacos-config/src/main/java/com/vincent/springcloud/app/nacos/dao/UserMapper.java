package com.vincent.springcloud.app.nacos.dao;

/**
 * 用户mapper
 *
 * @author vincent.li
 * @date 2022/11/13 23:51
 */

import com.vincent.springcloud.app.nacos.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 用户信息表
 * @author vincent.li
 * @date 2022-11-13
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增
     * @author vincent.li
     * @date 2022/11/13
     **/
    int insert(User user);

    /**
     * 刪除
     * @author vincent.li
     * @date 2022/11/13
     **/
    int delete(int id);

    /**
     * 更新
     * @author vincent.li
     * @date 2022/11/13
     **/
    int update(User user);

    /**
     * 查询 根据主键 id 查询
     * @author vincent.li
     * @date 2022/11/13
     **/
    User load(int id);

    /**
     * 查询 分页查询
     * @author vincent.li
     * @date 2022/11/13
     **/
    List<User> pageList(int offset,int pagesize);

    /**
     * 查询 分页查询 count
     * @author vincent.li
     * @date 2022/11/13
     **/
    int pageListCount(int offset,int pagesize);

}
