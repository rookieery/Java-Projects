package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntraceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
@CommandMeta(
        name = "GYXT",
        desc = "关于系统",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntraceCommand
public class AboutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("*******字符界面收银系统********");
        System.out.println("*******作者：rookie************");
        System.out.println("*******时间：2019-08-04********");
        System.out.println("*******************************");
    }
}
