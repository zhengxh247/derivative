package com.team.derivative.admin.exceptioin;

/**
 * @author zhengxh
 */
public interface BaseErrorInfoInterface {
    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}