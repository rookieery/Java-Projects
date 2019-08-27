package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

import java.util.List;

@CommandMeta(
        name = "LLSP",
        desc = "游览商品",
        group = "商品信息"
)
@AdminCommand
@CustomerCommand
public class GoodsBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("浏览商品");
        List<Goods> goodsList = this.goodsService.quarryAllGoods();
        if (!goodsList.isEmpty()) {
            for (Goods goods : goodsList) {
                System.out.println(goods);
            }
        }
    }
}
