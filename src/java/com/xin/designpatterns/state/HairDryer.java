package com.xin.designpatterns.state;


public class HairDryer {
    // 吹风机的状态
    private State state;
    // 关机状态
    private State offState;
    // 开机热风状态
    private State hotState;
    // 开机冷风状态
    private State coldState;

    HairDryer() {
        this.offState = new OffState(this);
        this.hotState = new HotState(this);
        this.coldState = new ColdState(this);
        // 默认是关机状态
        this.state = this.offState;

    }

    // 设置吹风机的状态
    void setState(State state) {
        this.state = state;
    }

    // 开关机按钮
    void turnOnOrOff() {
        this.state.turnOnOrOff();
    }

    // 切换模式按钮
    void switchMode() {
        this.state.switchMode();
    }

    // 获取吹风机的关机状态
    State getOffState() {
        return this.offState;
    }

    // 获取吹风机的开机热风状态
    State getHotState() {
        return this.hotState;
    }

    // 获取吹风机的开机冷风状态
    State getColdState() {
        return this.coldState;
    }
}
