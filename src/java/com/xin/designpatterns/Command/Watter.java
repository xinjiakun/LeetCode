package com.xin.designpatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class Watter {

    private List<Command> list=new ArrayList<Command>();
    public void setOrder(Command command){
        if(command instanceof BakeChickenWingCommand){
            System.out.println("服务员，鸡翅没了");
        }else {
            list.add(command);
        }
    }
    public void CancelOrder(Command command){
        list.remove(command);
    }

    public void Notify(){
        for (Command cmd:list) {
            cmd.ExcuteCommand();
        }
    }
}
