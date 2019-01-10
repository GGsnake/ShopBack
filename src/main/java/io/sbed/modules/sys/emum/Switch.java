package io.sbed.modules.sys.emum;

/**
 * Created by liujupeng on 2019/1/10.
 */
public class Switch {

    /**
     * 获取每一个USER的性别
     *
     * @param sex
     * @return
     */
    public static String getGrend(Integer sex) {
        switch (sex) {
            case 0:
                return "男";
            case 1:
                return "女";
            default:
                return "咦？我是谁呢？";
        }
    }

    /**
     * 获取身份
     *
     * @param rid
     * @return
     */
    public static String getRole(Integer rid) {
        switch (rid) {
            case 1:
                return "运营商";
            case 2:
                return "代理商";
            case 3:
                return "粉丝";
            default:
                return "咦？我是谁呢？";
        }
    }
    /**
     * 删除状态
     *
     * @param st
     * @return
     */
    public static String getStatus(Integer st) {
        switch (st) {
            case 0:
                return "激活";
            case 1:
                return "封禁";
            default:
                return "咦？我是谁呢？";
        }
    }

}
