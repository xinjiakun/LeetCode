package com.xin.designpatterns.Command;

public class Client {
    public static void main(String[] args) {
        Barbecuer barbecuer=new Barbecuer();
        Command BakeMuttonCommand1=new BakeMuttonCommand(barbecuer);
        Command BakeMuttonCommand2=new BakeMuttonCommand(barbecuer);
        Command BakeChickenWingCommand=new BakeChickenWingCommand(barbecuer);
        Watter watter=new Watter();

        watter.setOrder(BakeMuttonCommand1);

        watter.setOrder(BakeMuttonCommand2);

        watter.setOrder(BakeChickenWingCommand);
        watter.Notify();

    }
}
