package com.stylefeng.guns.user.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.api.bean.steve.SteveUserforUserInfo;
import com.stylefeng.guns.user.common.persistence.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-23
 */
public interface UserMapper extends BaseMapper<User> {

    SteveUserforUserInfo getUserInfo(@Param("username") String username);

}
