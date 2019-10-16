package com.stylefeng.guns.user.common.persistence.dao;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.user.common.persistence.model.CsUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wxf
 * @since 2019-10-14
 */
public interface CsUserMapper extends BaseMapper<CsUser> {

    int queryByUsername(@Param("username") String username);

    CsUser queryPwdByUser(@Param("username") String username);

    void updateUser(UserInfoModel userInfoModel);

    UserInfoModel selectByUuid(int uuid);
}
