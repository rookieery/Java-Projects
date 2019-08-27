package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntraceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
@CommandMeta(
        name = "TCCX",
        desc = "退出程序",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntraceCommand
public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("退出系统，欢迎下次再用！");
        scanner.close();
        System.exit(0);
    }
}
