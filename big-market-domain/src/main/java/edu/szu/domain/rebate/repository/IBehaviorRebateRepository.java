package edu.szu.domain.rebate.repository;

import edu.szu.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import edu.szu.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import edu.szu.domain.rebate.model.valobj.BehaviorTypeVO;
import edu.szu.domain.rebate.model.valobj.DailyBehaviorRebateVO;

import java.util.List;


public interface IBehaviorRebateRepository {

    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);

}


