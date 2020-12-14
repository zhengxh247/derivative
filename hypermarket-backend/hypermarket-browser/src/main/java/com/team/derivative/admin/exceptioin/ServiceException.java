package com.team.derivative.admin.exceptioin;


/**
 * @author zhengxh
 * 异彩类
 */
public class ServiceException extends RuntimeException {



    private static final long serialVersionUID = 1L;

    private static final String ID_ERROR = "用户需要注册: ";
    private static final String ID_EXIST = "手机用户已注册: ";
    private static final String FILE_UPLOAD_ERROR = "文件上传失败: ";

    private static final String CODE_ERROR = "1000404";
    private static final String CODE_EXIST= "1000400";
    private static final String FILE_ERROR= "1200400";
    private String errCode;
    private String errMessage;

    public ServiceException(String errCode, String errMessage) {

        super(errMessage);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public static ServiceException notExistMobile(String mobile) {
        return new ServiceException(CODE_ERROR, ID_ERROR + mobile);
    }

    public static ServiceException isExistMobile(String mobile) {
        return new ServiceException(CODE_EXIST,ID_EXIST+ mobile);
    }

    public static ServiceException fileUploadError(String fileName) {
        return new ServiceException(FILE_ERROR,FILE_UPLOAD_ERROR+ fileName);
    }


    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
