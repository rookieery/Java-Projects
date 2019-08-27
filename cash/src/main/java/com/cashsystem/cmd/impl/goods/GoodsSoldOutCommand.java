package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "XJSP",
        desc = "下架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsSoldOutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入下架商品编号：");
        int goodId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodId);
        if (goods==null) {
            System.out.println("此商品不存在！");
            return;
        }
        System.out.println("下架商品如下：");
        System.out.println(goods);
        System.out.println("确认是否下架此商品（y/n）：");
        String confirm = scanner.next();
        if ("y".equalsIgnoreCase(confirm)) {
            boolean effect = this.goodsService.soldOutGoods(goodId);
            if (effect) {
                System.out.println("商品下架成功！");
            } else {
                System.out.println("商品下架失败！");
            }
        } else {
            System.out.println("您选择了不下架此商品");
        }
    }
}
