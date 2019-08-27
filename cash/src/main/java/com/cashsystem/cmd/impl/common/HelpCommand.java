package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Command;
import com.cashsystem.cmd.Commands;
import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntraceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

import java.util.*;

@CommandMeta(
        name = "BZXX",
        desc = "帮助信息",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntraceCommand
public class HelpCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        if (account == null) {
            entranceHelp();
        } else {
            switch (account.getAccountType()) {
                case ADMIN:
                    adminHelp();
                    break;
                case CUSTOMER:
                    customerHelp();
                    break;
                default:
            }
        }
    }

    //Map.values()方法，返回所有的value集合
    public void entranceHelp() {
        prinf("欢迎", Commands.ENTRANCE_COMMAND.values());
    }

    public void customerHelp() {
        prinf("客户端", Commands.CUSTOMER_COMMAND.values());
    }

    public void adminHelp() {
        prinf("管理端", Commands.ADMIN_COMMAND.values());
    }

    public void prinf(String title, Collection<Command> collection) {
        System.out.println("*******************" + (title) + "********************");
        Map<String, List<String>> helpInfo = new HashMap<>();
        for (Command command : collection) {
            CommandMeta commandMeta = command.getClass().getDeclaredAnnotation(CommandMeta.class);
            String group = commandMeta.group();//key
            List<String> func = helpInfo.get(group);
            if (func == null) {
                func = new ArrayList<>();
                helpInfo.put(group, func);
            }
            func.add(commandMeta.desc() + "(" + commandMeta.name() + ")");
        }
        int i = 0;
        for (Map.Entry<String, List<String>> entry : helpInfo.entrySet()) {
            i++;
            System.out.println(i + "." + entry.getKey());
            int j = 0;
            for (String item : entry.getValue()) {
                j++;
                System.out.println("\t" + (i) + "." + (j) + " " + item);
            }
        }
        System.out.println("输入菜单后括号后面的编号（忽略大小写），进行下一步操作");
        System.out.println("******************************************************");
    }
}
