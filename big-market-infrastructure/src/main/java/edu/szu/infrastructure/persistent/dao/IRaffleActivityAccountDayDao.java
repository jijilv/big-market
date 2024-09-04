package edu.szu.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import edu.szu.infrastructure.persistent.po.RaffleActivityAccountDay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRaffleActivityAccountDayDao {

    @DBRouter
    RaffleActivityAccountDay queryActivityAccountDayByUserId(RaffleActivityAccountDay raffleActivityAccountDayReq);

    int updateActivityAccountDaySubtractionQuota(RaffleActivityAccountDay raffleActivityAccountDay);

    void insertActivityAccountDay(RaffleActivityAccountDay raffleActivityAccountDay);

    @DBRouter
    Integer queryRaffleActivityAccountDayPartakeCount(RaffleActivityAccountDay raffleActivityAccountDay);

}

