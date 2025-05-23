package edu.szu.test.infrastructure.elasticsearch;

import com.alibaba.fastjson.JSON;
import edu.szu.infrastructure.elasticsearch.IElasticSearchUserRaffleOrderDao;
import edu.szu.infrastructure.elasticsearch.po.UserRaffleOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchUserRaffleOrderDaoTest {

    @Resource
    private IElasticSearchUserRaffleOrderDao elasticSearchUserRaffleOrderDao;

    @Test
    public void test_queryUserRaffleOrderList() {
        List<UserRaffleOrder> userRaffleOrders = elasticSearchUserRaffleOrderDao.queryUserRaffleOrderList();
        log.info("测试结果：{}", JSON.toJSONString(userRaffleOrders));
    }

}

