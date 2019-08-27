package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

@CommandMeta(
        name = "SJSP",
        desc = "上架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsPutAwayCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("上架商品");
        System.out.println("请输入商品的名称：");
        String name = scanner.next();
        System.out.println("商品简介：");
        String introduce = scanner.next();
        System.out.println("商品库存：");
        Integer stock = scanner.nextInt();
        System.out.println("商品单位：包，个，箱.....");
        String unit = scanner.next();
        System.out.println("商品价格：单位（元）");
        Integer price = new Double(100 * scanner.nextDouble()).intValue();
        System.out.println("商品折扣：75表示75折");
        Integer discount = scanner.nextInt();
        Goods goods = new Goods();
        goods.setName(name);
        goods.setIntroduce(introduce);
        goods.setStock(stock);
        goods.setUnit(unit);
        goods.setPrice(price);
        goods.setDiscount(discount);
        boolean effect = this.goodsService.putAwayGoods(goods);
        if (effect) {
            System.out.println("上架成功");
        } else {
            System.out.println("上架失败");
        }
    }
}
