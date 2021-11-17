package com.xin.designpatterns.state;


public class Test {
    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        // 打开吹风机
        hairDryer.turnOnOrOff();
        // 切换模式
        hairDryer.switchMode();
        // 切换模式
        hairDryer.switchMode();
        // 切换模式
        hairDryer.switchMode();
        // 关闭吹风机
        hairDryer.turnOnOrOff();
        // 吹风机在关闭的状态下无法切换模式
        hairDryer.switchMode();
    }

}
