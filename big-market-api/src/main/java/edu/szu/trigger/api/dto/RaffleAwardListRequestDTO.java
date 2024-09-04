package edu.szu.trigger.api.dto;

import lombok.Data;


@Data
public class RaffleAwardListRequestDTO {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}

