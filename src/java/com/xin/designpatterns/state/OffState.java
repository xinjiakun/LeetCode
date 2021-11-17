package com.xin.designpatterns.state;


public class OffState implements State {
    // 吹风机对象的引用
    HairDryer hairDryer;

    OffState(HairDryer hairDryer) {
        super();
        this.hairDryer = hairDryer;
    }

    @Override
    public void turnOnOrOff() {
        this.hairDryer.setState(this.hairDryer.getHotState());
        System.out.println("关闭状态 => 开机热风状态");
    }

    @Override
    public void switchMode() {
        System.out.println("吹风机在关闭的状态下无法切换模式");
    }
}
