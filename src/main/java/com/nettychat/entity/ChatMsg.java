package com.nettychat.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class ChatMsg implements Serializable {
    private String id;

    /**
     * 发送者ID
     */
    private String sendUserId;

    /**
     * 接受者ID
     */
    private String acceptUserId;

    /**
     * 消息体
     */
    private String msg;

    /**
     * 是否已读
     */
    private Integer signFlag;

    /**
     * 创建时间 
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}