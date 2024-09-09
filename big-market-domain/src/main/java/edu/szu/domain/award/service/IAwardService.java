package edu.szu.domain.award.service;

import edu.szu.domain.award.model.entity.DistributeAwardEntity;
import edu.szu.domain.award.model.entity.UserAwardRecordEntity;

public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

    /**
     * 配送发货奖品
     */
    void distributeAward(DistributeAwardEntity distributeAwardEntity);

}


