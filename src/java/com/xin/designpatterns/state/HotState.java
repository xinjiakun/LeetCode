package com.xin.designpatterns.state;


public class HotState implements State {
    // 吹风机对象的引用
    HairDryer hairDryer;

    HotState(HairDryer hairDryer) {
        super();
        this.hairDryer = hairDryer;
    }

    @Override
    public void turnOnOrOff() {
        this.hairDryer.setState(this.hairDryer.getOffState());
        System.out.println("开机热风状态 => 关闭状态");
    }

    @Override
    public void switchMode() {
        this.hairDryer.setState(this.hairDryer.getColdState());
        System.out.println("开机热风状态 => 开机冷风状态");
    }
}
