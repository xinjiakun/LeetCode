package com.xin.designpatterns.Command;

public abstract class Command {
    Barbecuer receiver;
    public Command(Barbecuer receiver){
        this.receiver=receiver;
    }

    abstract public void ExcuteCommand();
}
