package com.zncm.dminter.mmhelper.data;

/**
 * Created by dminter on 2016/7/23.
 * 枚举类型
 */

public class EnumInfo {
    /**
     * 批量添加活动的枚举
     */
    public enum typeShortcut {
        //三方+少，三方+多，全部+少，全部+多 【less的活动有bug】
        THREE_MORE(1, "安装的应用"),  ALL_MORE(2 ,"系统应用");
//        THREE_MORE(1, "应用全部活动"), THREE_LESS(2, "应用注册活动"), ALL_MORE(3, "系统全部活动"), ALL_LESS(4, "系统注册活动");
        private int value;
        public String strName;

        private typeShortcut(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }
    }

    /**
     * T9分类，不同查询条件
     */
    public enum typeT9 {
        APP(1, "应用"), ACTIVITY(2, "活动"), APP_ACTIVITY(3, "应用+活动");
        private int value;
        public String strName;

        private typeT9(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }

        public static typeT9 getTypeT9(int value) {
            for (typeT9 tab : typeT9.values()) {
                if (tab.value == value) {
                    return tab;
                }
            }
            return APP;
        }
    }

    public enum typeBatStop {
        DISABLE_LESS(1, "冻结"), DISABLE_ALL(2, "彻底冻结"), ENABLE_ALL(3, "全部解冻");
        private int value;
        public String strName;

        private typeBatStop(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }

        public static typeBatStop getTypeBatStop(int value) {
            for (typeBatStop tab : typeBatStop.values()) {
                if (tab.value == value) {
                    return tab;
                }
            }
            return DISABLE_LESS;
        }
    }

    /**
     * 数据状态，正常，删除
     */
    public enum cStatus {

        NORMAL(1, "NORMAL"), DELETE(2, "DELETE");
        private int value;
        public String strName;

        private cStatus(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }


    }

    /**
     *刷新配合eventbus
     */
    public enum RefreshEnum {

        BAT_STOP(-1, "BAT_STOP"), FZ(1, "FZ"), APPS(2, "APPS"), ALL(3, "ALL"), LIKE(4, "LIKE"), APPSINIT(5, "APPSINIT");
        private int value;
        private String strName;

        private RefreshEnum(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }

    }

    /**
     *应用状态
     */
    public enum pkStatus {

        DELETE(-1, "DELETE"), NORMAL(0, "NORMAL");
        private int value;
        private String strName;

        private pkStatus(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }

    }

    /**
     *主页TAB枚举
     */
    public enum homeTab {
        SUGGEST_ACTIVITY(-1, "suggest_activity", "建议活动"),  BAT_STOP(0, "bat_stop", "冷冻室"), APPS(1, "enable", "应用"), LIKE(2, "like", "收藏"), ALL(3, "all", "所有");
        private String value;
        private int position;
        public String strName;

        private homeTab(int position, String value, String strName) {
            this.position = position;
            this.value = value;
            this.strName = strName;
        }

        public String getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }

        public int getPosition() {
            return position;
        }

        public static homeTab getHomeTab(String value) {
            for (homeTab tab : homeTab.values()) {
                if (tab.value.equals(value)) {
                    return tab;
                }
            }
            return null;
        }

        public static homeTab getHomeTab(int position) {
            for (homeTab tab : homeTab.values()) {
                if (tab.position == position) {
                    return tab;
                }
            }
            return null;
        }
    }


    /**
     *活动类型
     */
    public enum cType {
        WX(1, "微信聊天"), TO_ACTIVITY(2, "TO_ACTIVITY"), JUST_TIPS(3, "JUST_TIPS"), START_APP(4, "START_APP"), QQ(5, "QQ聊天"), URL(6, "书签"), CMD(7, "CMD"), SHORT_CUT_SYS(8, "快捷方式");

        private int value;
        public String strName;

        private cType(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }


    }

    /**
     *应用状态，是否冻结
     */
    public enum appStatus {

        ENABLE(1, "启用"), DISABLED(2, "停用");

        private int value;
        public String strName;

        private appStatus(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }


    }

    /**
     *应用类型，是否第三方
     */
    public enum appType {

        SYSTEM(1, "SYSTEM"), THREE(2, "THREE");

        private int value;
        public String strName;

        private appType(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }


    }

    /**
     *card类型-弃用
     */
    public enum cardType {
        material_basic_buttons_card(1, "微信聊天"),
        material_basic_image_buttons_card_layout(2, "微信聊天"),
        material_big_image_card_layout(3, "微信聊天"),
        material_image_with_buttons_card(4, "微信聊天"),
        material_list_card_layout(5, "微信聊天"),
        material_small_image_card(6, "微信聊天"),
        material_welcome_card_layout(7, "微信聊天"),;
        private int value;
        public String strName;

        private cardType(int value, String strName) {
            this.value = value;
            this.strName = strName;
        }

        public int getValue() {
            return value;
        }

        public String getStrName() {
            return strName;
        }


    }
}
