package com.zncm.dminter.mmhelper;

/**
 * Created by dminter on 2016/7/22.
 */

public class Constant {
    public static int MAX_DB_QUERY = 100;
    public static String DB_TAG_PRE_ = "DB_TAG_PRE_";
    public static String author_wx = "xm0ff255";
    public static String no_root = "打开失败~请检查root权限！！";
    public static String add_shortcut = "已添加快捷方式到桌面！！";
    public static String update_url = "http://www.coolapk.com/apk/com.zncm.dminter.mmhelper";
    public static final String wx_PYQ = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
    //    am start -n com.tencent.mm/com.tencent.mm.plugin.sns.ui.SnsTimeLineUI
    public static final String wx_am_action_pre = "am start -a android.intent.action.VIEW -d ";
    public static final String wx_am_pre = "am start -n com.tencent.mm/";
    //    am start -n com.tencent.mm/com.tencent.mm.ui.chatting.ChattingUI -e Chat_User wxid_6623726237612
    public static final String wx_ChattingUI = "com.tencent.mm.ui.chatting.ChattingUI -e Chat_User ";
    //zfb
    public static final String zfb_am_pre = "am start -n com.eg.android.AlipayGphone/";
    public static final String common_am_pre = "am start -n ";
    public static final String common_am_div = "/";
    public static final String common_pm_e = "pm list packages -e ";
    public static final String common_pm_all = "pm list packages";
    public static final String common_pm_d = "pm list packages -d ";
    public static final String common_pm_s = "-s";
    public static final String common_pm_3 = "-3";
    public static final String common_pm_e_p = "pm enable ";
    public static final String common_pm_d_p = "pm disable ";
    public static final int attempt = 3;
    public static final int open_ac_attempt = 2;
    public static final String zfb_OspTabHostActivity = "com.alipay.mobile.onsitepay9.payer.OspTabHostActivity";
    //    Error type 3
//    Error: Activity class {fm.qingting.qtradio/fm.qingting.qtradio.QTRadioActivity} does not exist.
//            Starting: Intent { cmp=fm.qingting.qtradio/.QTRadioActivity }
    public static final String app_is_disable_error = "Error type 3";
    public static final String share_content = "快速打开活动  http://www.coolapk.com/apk/com.zncm.dminter.mmhelper";

}
