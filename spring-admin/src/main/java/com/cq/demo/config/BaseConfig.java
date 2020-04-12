package com.cq.demo.config;

/**
 * @Author: ChengYangChang
 */
public class BaseConfig {
    public static final String TOKEN = "token";// TOKEN

    public static final String DICT_INI_PASSWORD = "INI_PASSWORD";// 字典-初始化密码
    public static final String DICT_TRUE_FALSE = "TRUE_FALSE";// 字典-是否
    public static final String DICT_SEX = "SEX";// 字典-性别
    public static final String DICT_NATION = "NATION";// 字典-民族
    public static final String DICT_FAITH = "FAITH";// 字典-信仰
    public static final String DICT_FACE = "FACE";// 字典-政治面貌
    public static final String DICT_MARITAL = "MARITAL";// 字典-婚姻状况
    public static final String DICT_EDUCATION = "EDUCATION";// 字典-文化程度
    public static final String DICT_MONEY_TYPE = "MONEY_TYPE";// 字典-村账明细-事件类型
    public static final String DICT_AMOUNT_TYPE = "AMOUNT_TYPE";// 字典-村账明细-金额类型
    public static final String DICT_SUBSIDY_TYPE = "SUBSIDY_TYPE";// 字典-补贴明细-补贴类型
    public static final String DICT_SUBSIDY_USER = "SUBSIDY_USER";// 字典-补贴明细-村民状态

    public static final String INI_PASSWORD = "123456";// 字典-初始化密码
    public static final int TRUE = 1;// 字典-是否
    public static final int FALSE = 0;// 字典-是否
    public static final int MAN = 1;// 字典-男
    public static final int WOMAN = 2;// 字典-女
    public static final int MODEL_TYPE_ARTICLE = 1;// 字典-栏目类型-文章
    public static final int AREA_LEVEL_PROVINCE = 1;// 字典-区域级别-省级
    public static final int AREA_LEVEL_CITY = 2;// 字典-区域级别-市级
    public static final int AREA_LEVEL_DISTRICT = 3;// 字典-区域级别-区县级
    public static final int AREA_LEVEL_TOWN = 4;// 字典-区域级别-乡镇级
    public static final int AREA_LEVEL_VILLAGE = 5;// 字典-区域级别-村级
    public static final int ROLE_MEMBER = 1;// 角色-党员
    public static final int ROLE_CADRE = 2;// 角色-干部
    public static final int ROLE_DEFORMITY = 3;// 角色-残疾人员
    public static final int ROLE_FIVE_PROTECT = 4;// 角色-五保户
    public static final int ROLE_LOW_PROTECT = 5;// 角色-低保户
    public static final int ROLE_OVERSEAS = 6;// 角色-华侨
    public static final int ROLE_ARMY = 7;// 角色-退役军人
    public static final int ROLE_VILLAGER = 8;// 角色-村民
    public static final int ROLE_FARMER = 9;// 角色-惠农

    public static final String USER_NULL = "无效的用户，请重新登录";// 用户缺失
    public static final String PARAMS_NULL = "不能为空";// 参数缺失
    public static final String ERROR = "系统出现未知错误";// 程序异常
    public static final String DO_FAIL = "存储失败";// 入库失败
    public static final String DO_SUCCESS = "操作成功";// 操作成功
    public static final String DO_CHECK = "当前操作需要确认，请等待结果";// 等待审核
    public static final String SIGN_FAIL = "签名认证失败";// 签名认证失败

    public static final String MODEL_NAME = "modelName";// 发布内容元素-栏目名称

    public static final int CODE_ERROR = 500;// 程序异常
    public static final int CODE_FAIL = 401;// 错误提示
    public static final int CODE_FAIL_USER = 402;// 登录失效
    public static final int CODE_SUCCESS = 200;// 操作成功

}
