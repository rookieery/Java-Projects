package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import org.apache.commons.codec.digest.DigestUtils;

@CommandMeta(
        name = "CZMM",
        desc = "重置密码",
        group = "账号信息"
)
@AdminCommand
public class AccountPasswordResetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("重置密码");
        System.out.println("请输出你的旧密码：");
        String oldPassword1 = scanner.next();
        String oldPassword2 = subject.getAccount().getPassword();
        if (!DigestUtils.md5Hex(oldPassword1).equals(oldPassword2)) {
            System.out.println("旧密码输入有误！");
            return;
        }
        System.out.println("请输入你的新密码：");
        String password1 = scanner.next();
        System.out.println("请再次输入你的新密码：");
        String password2 = scanner.next();
        if (!password1.equals(password2)) {
            System.out.println("两次密码输入不一致！");
            return;
        }
        boolean flag = this.accountService.updatePassword(subject.getAccount().getId(), password1);
        if (flag) {
            System.out.println("密码重置成功！");
        } else {
            System.out.println("密码重置失败！");
        }
    }
}
