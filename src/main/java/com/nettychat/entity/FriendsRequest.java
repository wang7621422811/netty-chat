package com.nettychat.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class FriendsRequest implements Serializable {
    private String id;

    /**
     * 发送用户ID
     */
    private String sendUserId;

    /**
     * 接收用户ID
     */
    private String acceptUserId;

    /**
     * 请求时间
     */
    private Date requestDateTime;

    private static final long serialVersionUID = 1L;
}