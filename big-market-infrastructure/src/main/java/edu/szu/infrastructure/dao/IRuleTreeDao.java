package edu.szu.infrastructure.dao;

import edu.szu.infrastructure.dao.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}
