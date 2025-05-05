package edu.szu.infrastructure.dao;

import edu.szu.infrastructure.dao.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IRaffleActivityDao {

    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

    Long queryStrategyIdByActivityId(Long activityId);

    Long queryActivityIdByStrategyId(Long strategyId);

}




