package com.nettychat.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class MyFriends implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 我的ID
     */
    private String myUserId;

    /**
     * 朋友的ID
     */
    private String myFriendUserId;

    private static final long serialVersionUID = 1L;
}