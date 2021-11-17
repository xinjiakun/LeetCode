package com.xin.designpatterns.Command;

public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    public void ExcuteCommand() {
        receiver.BakeMutton();
    }
}
