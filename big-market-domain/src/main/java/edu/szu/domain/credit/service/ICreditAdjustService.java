package edu.szu.domain.credit.service;

import edu.szu.domain.credit.model.model.TradeEntity;

public interface ICreditAdjustService {

    /**
     * 创建增加积分额度订单
     * @param tradeEntity 交易实体对象
     * @return 单号
     */
    String createOrder(TradeEntity tradeEntity);

}

