package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

@CommandMeta(
        name = "ZHSZ",
        desc = "账户设置",
        group = "账号信息"
)
@AdminCommand
public class AccountStatusSetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("请选择您想要进行的操作：");
        System.out.println("QTZH(启停账户)/QYZH(启用账户)");
        String input = scanner.next();
        if (input.equalsIgnoreCase("qtzh")) {
            System.out.println("启停账户");
            System.out.println("请输入您想要启停账户的用户名：");
            String userName = scanner.next();
            System.out.println("请输入您想要启停账户的密码：");
            String passWord = scanner.next();
            Account account = accountService.login(userName, passWord);
            if (account == null) {
                System.out.println("输入有误，不存在此用户！");
                return;
            }
            if (account.getAccountStatus().getFlg() == 2) {
                System.out.println("该账户已被启停，此操作无效！");
            }
            if (account.getAccountType().getFlg() == 1) {
                System.out.println("您无权执行该操作");
                return;
            }
            Integer id = account.getId();
            boolean flag = accountService.updateAccountStatus1(id);
            if (flag) {
                System.out.println("用户" + account.getName() + "启停成功!");
            } else {
                System.out.println("启停失败！");
            }
        } else if (input.equalsIgnoreCase("qyzh")) {
            System.out.println("启用账户");
            System.out.println("请输入您想要启用账户的用户名：");
            String userName = scanner.next();
            System.out.println("请输入您想要启用账户的密码：");
            String passWord = scanner.next();
            Account account = accountService.login(userName, passWord);
            if (account == null) {
                System.out.println("输入有误，不存在此用户！");
                return;
            }
            if (account.getAccountStatus().getFlg() == 1) {
                System.out.println("该账户正在启用，此为无效操作！");
            }
            if (account.getAccountType().getFlg() == 1) {
                System.out.println("您无权执行该操作");
                return;
            }
            Integer id = account.getId();
            boolean flag = accountService.updateAccountStatus2(id);
            if (flag) {
                System.out.println("用户" + account.getName() + "启用成功!");
            } else {
                System.out.println("启停失败！");
            }
        } else {
            System.out.println("输入格式有误！");
        }
    }
}
