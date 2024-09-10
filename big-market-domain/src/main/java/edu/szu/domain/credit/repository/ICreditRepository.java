package edu.szu.domain.credit.repository;

import edu.szu.domain.credit.model.aggregate.TradeAggregate;

public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

}

