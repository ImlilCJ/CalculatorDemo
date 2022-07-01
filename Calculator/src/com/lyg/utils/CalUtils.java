package com.lyg.utils;

import java.awt.*;

/**
 * @author 林奕耿
 * @version 1.0
 */
public class CalUtils {
    //窗口长宽
    public static final int FRAME_W = 500;
    public static final int FRAME_H = 500;
    //程序标题
    public static final String TITLE = "简易计算器";
    //获取屏幕大小尺寸，设置居中
    public static final int SCREEN_WIDTH= Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_HEIGHTH= Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int frame_x = (SCREEN_WIDTH - FRAME_W)/2;
    public static int frame_y = (SCREEN_HEIGHTH - FRAME_H)/2;
}
