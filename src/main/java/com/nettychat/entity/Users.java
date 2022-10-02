package com.nettychat.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Users implements Serializable {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名登陆名
     */
    private String username;

    /**
     * 密码，加密保存
     */
    private String password;

    /**
     * 用户头像
     */
    private String faceImage;

    /**
     * 大头像
     */
    private String faceImageBig;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 手机设备ID，用作消息推送使用
     */
    private String cid;

    private static final long serialVersionUID = 1L;
}