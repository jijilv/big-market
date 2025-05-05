package edu.szu.infrastructure.dao;

import edu.szu.infrastructure.dao.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IRaffleActivityCountDao {

    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);

}
