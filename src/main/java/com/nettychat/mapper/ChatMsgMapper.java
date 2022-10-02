package com.nettychat.mapper;

import com.nettychat.entity.ChatMsg;
import com.nettychat.utils.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * ChatMsgMapper继承基类
 */
@Mapper
public interface ChatMsgMapper extends BaseMapper<ChatMsg> {
}