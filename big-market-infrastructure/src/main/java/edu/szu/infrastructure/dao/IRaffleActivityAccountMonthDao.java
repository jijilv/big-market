package edu.szu.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import edu.szu.infrastructure.dao.po.RaffleActivityAccountMonth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRaffleActivityAccountMonthDao {

    @DBRouter
    RaffleActivityAccountMonth queryActivityAccountMonthByUserId(RaffleActivityAccountMonth raffleActivityAccountMonthReq);

    int updateActivityAccountMonthSubtractionQuota(RaffleActivityAccountMonth raffleActivityAccountMonth);

    void insertActivityAccountMonth(RaffleActivityAccountMonth raffleActivityAccountMonth);

    void addAccountQuota(RaffleActivityAccountMonth raffleActivityAccountMonth);

}
