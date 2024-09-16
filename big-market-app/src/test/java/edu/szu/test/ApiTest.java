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
    public void test_integer(){
        System.out.println(Integer.parseInt("aaa"));
    }

    @Test
    public void test() {
        RaffleAwardListRequestDTO requestDTO = new RaffleAwardListRequestDTO();
        requestDTO.setUserId("xiaofuge");
        requestDTO.setActivityId(100301L);
        log.info(JSON.toJSONString(requestDTO));
    }

    public static void main(String[] args) {
        double convert = convert(0.0018);
        System.out.println(convert);
    }

    private static double convert(double min){
        double current = min;
        double max = 1;
        while (current % 1 != 0){
            current = current * 10;
            max = max * 10;
        }
        return max;
    }

}



