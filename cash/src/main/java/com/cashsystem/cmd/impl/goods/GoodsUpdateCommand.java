package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "GXSP",
        desc = "更新商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsUpdateCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("更新商品");
        System.out.println("请输入更新商品编号：");
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if (goods == null) {
            System.out.println("没有此编号的货物");
            return;
        } else {
            System.out.println("商品信息如下：");
            System.out.println(goods);
        }
        System.out.println("请输入需要更新的商品简介：");
        String introduce = scanner.next();
        System.out.println("请输入需要更新的商品库存：");
        Integer stock = scanner.nextInt();
        System.out.println("请输入需要更新的商品单位：");
        String unit = scanner.next();
        System.out.println("请输入需要更新的商品价格：");
        Integer price = new Double(100 * scanner.nextDouble()).intValue();
        System.out.println("请输入需要更新的商品折扣：");
        Integer discount = scanner.nextInt();
        System.out.println("请确认是否更新：y/n");
        String flg = scanner.next();
        if ("y".equalsIgnoreCase(flg)) {
            goods.setIntroduce(introduce);
            goods.setStock(stock);
            goods.setUnit(unit);
            goods.setPrice(price);
            goods.setDiscount(discount);
            boolean effect = this.goodsService.modifyGoods(goods);
            if (effect) {
                System.out.println("商品更新成功");
            } else {
                System.out.println("商品更新失败");
            }
        } else {
            System.out.println("您选择了不更新此商品！");
        }
    }
}
