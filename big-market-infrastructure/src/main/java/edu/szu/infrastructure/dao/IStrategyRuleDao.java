package edu.szu.infrastructure.dao;

import edu.szu.infrastructure.dao.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface IStrategyRuleDao {

    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);

    String queryStrategyRuleValue(StrategyRule strategyRule);

}


