package edu.szu.domain.activity.service.quota.policy;

import edu.szu.domain.activity.model.aggregate.CreateQuotaOrderAggregate;

public interface ITradePolicy {

    void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate);

}

