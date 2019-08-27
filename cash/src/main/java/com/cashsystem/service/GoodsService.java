package com.cashsystem.service;

import com.cashsystem.dao.GoodsDao;
import com.cashsystem.entity.Goods;

import java.util.List;

public class GoodsService {
    public GoodsDao goodsDao;

    public GoodsService() {
        this.goodsDao = new GoodsDao();
    }

    public List<Goods> quarryAllGoods() {
        return this.goodsDao.quarryAllGoods();
    }

    public boolean putAwayGoods(Goods goods) {
        return this.goodsDao.putAwayGoods(goods);
    }

    public Goods getGoods(int goodsid) {
        return this.goodsDao.getGoods(goodsid);
    }

    public boolean modifyGoods(Goods goods) {
        return this.goodsDao.modifyGoods(goods);
    }

    public boolean soldOutGoods(int goodId) {
        return this.goodsDao.soldOutGoods(goodId);
    }

    public boolean updateAfterPay(Goods goods, Integer buyGoodsNum) {
        return this.goodsDao.updateAfterPay(goods,buyGoodsNum);
    }
}
