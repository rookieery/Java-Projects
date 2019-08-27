package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
@CommandMeta(
        name = "CKZH",
        desc = "查看账户",
        group = "账号信息"
)
@AdminCommand
public class AccountBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
