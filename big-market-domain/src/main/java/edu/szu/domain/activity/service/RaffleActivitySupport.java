package edu.szu.domain.activity.service;

import edu.szu.domain.activity.model.entity.ActivityCountEntity;
import edu.szu.domain.activity.model.entity.ActivityEntity;
import edu.szu.domain.activity.model.entity.ActivitySkuEntity;
import edu.szu.domain.activity.repository.IActivityRepository;
import edu.szu.domain.activity.service.rule.factory.DefaultActivityChainFactory;

public class RaffleActivitySupport {

    protected DefaultActivityChainFactory defaultActivityChainFactory;

    protected IActivityRepository activityRepository;

    public RaffleActivitySupport(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory) {
        this.activityRepository = activityRepository;
        this.defaultActivityChainFactory = defaultActivityChainFactory;
    }

    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }

}
