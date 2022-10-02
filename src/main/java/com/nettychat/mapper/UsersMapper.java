package com.nettychat.mapper;

import com.nettychat.entity.Users;
import com.nettychat.utils.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * UsersMapper继承基类
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}