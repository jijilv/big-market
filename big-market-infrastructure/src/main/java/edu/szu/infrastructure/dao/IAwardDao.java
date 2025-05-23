package edu.szu.infrastructure.dao;

import edu.szu.infrastructure.dao.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

    String queryAwardConfigByAwardId(Integer awardId);

    String queryAwardKeyByAwardId(Integer awardId);

}

