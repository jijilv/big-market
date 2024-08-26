package edu.szu.test;

import com.alibaba.fastjson.JSON;
import edu.szu.trigger.api.dto.RaffleAwardListRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApiTest {

    @Test
    public void test() {
        RaffleAwardListRequestDTO requestDTO = new RaffleAwardListRequestDTO();
        requestDTO.setStrategyId(1000001L);
        log.info(JSON.toJSONString(requestDTO));
    }

    private double convert(double min){
        double current = min;
        double max = 1;
        while (current < 1){
            current = current * 10;
            max = max * 10;
        }
        return max;
    }

}



