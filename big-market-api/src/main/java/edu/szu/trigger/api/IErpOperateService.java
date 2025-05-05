package edu.szu.trigger.api;

import edu.szu.trigger.api.dto.ESUserRaffleOrderResponseDTO;
import edu.szu.trigger.api.response.Response;

import java.util.List;


public interface IErpOperateService {

    Response<List<ESUserRaffleOrderResponseDTO>> queryUserRaffleOrder();

}

