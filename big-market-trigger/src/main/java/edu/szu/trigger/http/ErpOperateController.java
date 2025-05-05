package edu.szu.trigger.http;

import edu.szu.querys.adapter.repository.IESUserRaffleOrderRepository;
import edu.szu.querys.model.valobj.ESUserRaffleOrderVO;
import edu.szu.trigger.api.IErpOperateService;
import edu.szu.trigger.api.dto.ESUserRaffleOrderResponseDTO;
import edu.szu.trigger.api.response.Response;
import edu.szu.types.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController()
@CrossOrigin("${app.config.cross-origin}")
@RequestMapping("/api/${app.config.api-version}/raffle/erp/")
@DubboService(version = "1.0")
public class ErpOperateController implements IErpOperateService {

    @Resource
    private IESUserRaffleOrderRepository userRaffleOrderRepository;

    /**
     * 查询运营数据，用户抽奖单列表
     * curl --request GET --url 'http://localhost:8098/api/v1/raffle/erp/query_user_raffle_order'
     */
    @RequestMapping(value = "query_user_raffle_order", method = RequestMethod.GET)
    @Override
    public Response<List<ESUserRaffleOrderResponseDTO>> queryUserRaffleOrder() {
        try {
            log.info("查询运营数据，用户抽奖单列表");
            List<ESUserRaffleOrderVO> userRaffleOrderVOList = userRaffleOrderRepository.queryESUserRaffleOrderVOList();

            List<ESUserRaffleOrderResponseDTO> userRaffleOrderResponseDTOS = new ArrayList<>();
            for (ESUserRaffleOrderVO esUserRaffleOrderVO : userRaffleOrderVOList) {
                ESUserRaffleOrderResponseDTO esUserRaffleOrderResponseDTO = new ESUserRaffleOrderResponseDTO();
                esUserRaffleOrderResponseDTO.setUserId(esUserRaffleOrderVO.getUserId());
                esUserRaffleOrderResponseDTO.setActivityId(esUserRaffleOrderVO.getActivityId());
                esUserRaffleOrderResponseDTO.setActivityName(esUserRaffleOrderVO.getActivityName());
                esUserRaffleOrderResponseDTO.setStrategyId(esUserRaffleOrderVO.getStrategyId());
                esUserRaffleOrderResponseDTO.setOrderId(esUserRaffleOrderVO.getOrderId());
                esUserRaffleOrderResponseDTO.setOrderTime(esUserRaffleOrderVO.getOrderTime());
                esUserRaffleOrderResponseDTO.setOrderState(esUserRaffleOrderVO.getOrderState());
                esUserRaffleOrderResponseDTO.setCreateTime(esUserRaffleOrderVO.getCreateTime());
                esUserRaffleOrderResponseDTO.setUpdateTime(esUserRaffleOrderVO.getUpdateTime());
                userRaffleOrderResponseDTOS.add(esUserRaffleOrderResponseDTO);
            }

            return Response.<List<ESUserRaffleOrderResponseDTO>>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .data(userRaffleOrderResponseDTOS)
                    .build();
        } catch (Exception e) {
            log.error("查询运营数据，用户抽奖单列表", e);
            return Response.<List<ESUserRaffleOrderResponseDTO>>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

}
