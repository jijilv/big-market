package edu.szu.domain.credit.repository;

import edu.szu.domain.credit.model.aggregate.TradeAggregate;
import edu.szu.domain.credit.model.model.CreditAccountEntity;

public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

    CreditAccountEntity queryUserCreditAccount(String userId);



}

