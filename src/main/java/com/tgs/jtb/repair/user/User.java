package com.tgs.jtb.repair.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    /** ID */
    private String id;

    /** 手机号 */
    private String mobile;

    /** 账号 */
    private String account;

    /** 密码 */
    private String password;

    /** 昵称 */
    private String nickName;

    /** 0：禁用；1：启用 */
    private Integer status;

    /** 身份证号码 */
    private String idCardNo;

    /** 手持身份证图片 */
    private String idCardHandImg;

    /** 正面身份证图片 */
    private String idCardFrontImg;

    /** 背面身份证图片 */
    private String idCardBackImg;

    /** 行驶证 */
    private String drivingLicense;

    /** 提交实名认证时间 */
    private Date authTime;

    /** 注册时间 */
    private Date registerTime;

    /** 真实姓名 */
    private String realName;

    /** 0:保密;1:男;2:女 */
    private Integer gender;

    /** 审核认证时间 */
    private Date auditTime;

    /** 审核人 */
    private String auditPerson;

    /** 认证状态:0:未认证；1：提交申请;2:审核通过;3:审核不通过 */
    private Integer authStatus;

    /** 认证审核意见 */
    private String auditRemark;

    /** 注册来源 0:web;1:andriod;2:ios;3:运营平台 4：永兴元 */
    private Integer registerSource;

    /** 头像图片 */
    private String userImg;

    /** 明文密码 */
    private String mwPwd;

    /** 11:个人用户 14：企业用户 */
    private Integer userType;

    private static final long serialVersionUID = 1L;

    /**
     * 返回ID
     *
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 返回手机号
     *
     * @return MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 返回账号
     *
     * @return ACCOUNT
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 返回密码
     *
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 返回昵称
     *
     * @return NICK_NAME
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 返回0：禁用；1：启用
     *
     * @return STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：禁用；1：启用
     *
     * @param status 0：禁用；1：启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 返回身份证号码
     *
     * @return ID_CARD_NO
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置身份证号码
     *
     * @param idCardNo 身份证号码
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 返回手持身份证图片
     *
     * @return ID_CARD_HAND_IMG
     */
    public String getIdCardHandImg() {
        return idCardHandImg;
    }

    /**
     * 设置手持身份证图片
     *
     * @param idCardHandImg 手持身份证图片
     */
    public void setIdCardHandImg(String idCardHandImg) {
        this.idCardHandImg = idCardHandImg;
    }

    /**
     * 返回正面身份证图片
     *
     * @return ID_CARD_FRONT_IMG
     */
    public String getIdCardFrontImg() {
        return idCardFrontImg;
    }

    /**
     * 设置正面身份证图片
     *
     * @param idCardFrontImg 正面身份证图片
     */
    public void setIdCardFrontImg(String idCardFrontImg) {
        this.idCardFrontImg = idCardFrontImg;
    }

    /**
     * 返回背面身份证图片
     *
     * @return ID_CARD_BACK_IMG
     */
    public String getIdCardBackImg() {
        return idCardBackImg;
    }

    /**
     * 设置背面身份证图片
     *
     * @param idCardBackImg 背面身份证图片
     */
    public void setIdCardBackImg(String idCardBackImg) {
        this.idCardBackImg = idCardBackImg;
    }

    /**
     * 返回行驶证
     *
     * @return DRIVING_LICENSE
     */
    public String getDrivingLicense() {
        return drivingLicense;
    }

    /**
     * 设置行驶证
     *
     * @param drivingLicense 行驶证
     */
    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    /**
     * 返回提交实名认证时间
     *
     * @return AUTH_TIME
     */
    public Date getAuthTime() {
        return authTime;
    }

    /**
     * 设置提交实名认证时间
     *
     * @param authTime 提交实名认证时间
     */
    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    /**
     * 返回注册时间
     *
     * @return REGISTER_TIME
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 返回真实姓名
     *
     * @return REAL_NAME
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 返回0:保密;1:男;2:女
     *
     * @return GENDER
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置0:保密;1:男;2:女
     *
     * @param gender 0:保密;1:男;2:女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 返回审核认证时间
     *
     * @return AUDIT_TIME
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核认证时间
     *
     * @param auditTime 审核认证时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 返回审核人
     *
     * @return AUDIT_PERSON
     */
    public String getAuditPerson() {
        return auditPerson;
    }

    /**
     * 设置审核人
     *
     * @param auditPerson 审核人
     */
    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    /**
     * 返回认证状态:0:未认证；1：提交申请;2:审核通过;3:审核不通过
     *
     * @return AUTH_STATUS
     */
    public Integer getAuthStatus() {
        return authStatus;
    }

    /**
     * 设置认证状态:0:未认证；1：提交申请;2:审核通过;3:审核不通过
     *
     * @param authStatus 认证状态:0:未认证；1：提交申请;2:审核通过;3:审核不通过
     */
    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * 返回认证审核意见
     *
     * @return AUDIT_REMARK
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * 设置认证审核意见
     *
     * @param auditRemark 认证审核意见
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    /**
     * 返回注册来源 0:web;1:andriod;2:ios;3:运营平台 4：永兴元
     *
     * @return REGISTER_SOURCE
     */
    public Integer getRegisterSource() {
        return registerSource;
    }

    /**
     * 设置注册来源 0:web;1:andriod;2:ios;3:运营平台 4：永兴元
     *
     * @param registerSource 注册来源 0:web;1:andriod;2:ios;3:运营平台 4：永兴元
     */
    public void setRegisterSource(Integer registerSource) {
        this.registerSource = registerSource;
    }

    /**
     * 返回头像图片
     *
     * @return USER_IMG
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * 设置头像图片
     *
     * @param userImg 头像图片
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    /**
     * 返回明文密码
     *
     * @return MW_PWD
     */
    public String getMwPwd() {
        return mwPwd;
    }

    /**
     * 设置明文密码
     *
     * @param mwPwd 明文密码
     */
    public void setMwPwd(String mwPwd) {
        this.mwPwd = mwPwd;
    }

    /**
     * 返回11:个人用户 14：企业用户
     *
     * @return USER_TYPE
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置11:个人用户 14：企业用户
     *
     * @param userType 11:个人用户 14：企业用户
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"id\":\"").append(id == null ? "" : id);
        sb.append("\",\"mobile\":\"").append(mobile == null ? "" : mobile);
        sb.append("\",\"account\":\"").append(account == null ? "" : account);
        sb.append("\",\"password\":\"").append(password == null ? "" : password);
        sb.append("\",\"nickName\":\"").append(nickName == null ? "" : nickName);
        sb.append("\",\"status\":\"").append(status == null ? "" : status);
        sb.append("\",\"idCardNo\":\"").append(idCardNo == null ? "" : idCardNo);
        sb.append("\",\"idCardHandImg\":\"").append(idCardHandImg == null ? "" : idCardHandImg);
        sb.append("\",\"idCardFrontImg\":\"").append(idCardFrontImg == null ? "" : idCardFrontImg);
        sb.append("\",\"idCardBackImg\":\"").append(idCardBackImg == null ? "" : idCardBackImg);
        sb.append("\",\"drivingLicense\":\"").append(drivingLicense == null ? "" : drivingLicense);
        sb.append("\",\"authTime\":\"").append(authTime == null ? "" : authTime);
        sb.append("\",\"registerTime\":\"").append(registerTime == null ? "" : registerTime);
        sb.append("\",\"realName\":\"").append(realName == null ? "" : realName);
        sb.append("\",\"gender\":\"").append(gender == null ? "" : gender);
        sb.append("\",\"auditTime\":\"").append(auditTime == null ? "" : auditTime);
        sb.append("\",\"auditPerson\":\"").append(auditPerson == null ? "" : auditPerson);
        sb.append("\",\"authStatus\":\"").append(authStatus == null ? "" : authStatus);
        sb.append("\",\"auditRemark\":\"").append(auditRemark == null ? "" : auditRemark);
        sb.append("\",\"registerSource\":\"").append(registerSource == null ? "" : registerSource);
        sb.append("\",\"userImg\":\"").append(userImg == null ? "" : userImg);
        sb.append("\",\"mwPwd\":\"").append(mwPwd == null ? "" : mwPwd);
        sb.append("\",\"userType\":\"").append(userType == null ? "" : userType);
        sb.append("\"}");
        return sb.toString();
    }
}