package edu.szu.infrastructure.dao;

import edu.szu.infrastructure.dao.po.UserCreditAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserCreditAccountDao {

    void insert(UserCreditAccount userCreditAccountReq);

    int updateAddAmount(UserCreditAccount userCreditAccountReq);

    UserCreditAccount queryUserCreditAccount(UserCreditAccount userCreditAccountReq);

    int updateSubtractionAmount(UserCreditAccount userCreditAccountReq);

}




