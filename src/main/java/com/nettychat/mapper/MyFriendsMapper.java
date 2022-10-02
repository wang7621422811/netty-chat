package com.nettychat.mapper;

import com.nettychat.entity.MyFriends;
import com.nettychat.utils.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * MyFriendsMapper继承基类
 */
@Mapper
public interface MyFriendsMapper extends BaseMapper<MyFriends> {
}