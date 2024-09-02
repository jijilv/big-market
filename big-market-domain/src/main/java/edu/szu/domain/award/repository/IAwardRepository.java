package edu.szu.domain.award.repository;

import edu.szu.domain.award.model.aggregate.UserAwardRecordAggregate;

public interface IAwardRepository {

    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

}

