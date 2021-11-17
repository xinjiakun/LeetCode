package com.xin.designpatterns.Command;

public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    public void ExcuteCommand() {
        receiver.BakeChickenWing();
    }
}
