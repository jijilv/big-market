package edu.szu.infrastructure.elasticsearch;


import edu.szu.infrastructure.elasticsearch.po.UserRaffleOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IElasticSearchUserRaffleOrderDao {

    List<UserRaffleOrder> queryUserRaffleOrderList();

}
