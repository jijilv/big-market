package edu.szu.domain.activity.service.rule;

import edu.szu.domain.activity.model.entity.ActivityCountEntity;
import edu.szu.domain.activity.model.entity.ActivityEntity;
import edu.szu.domain.activity.model.entity.ActivitySkuEntity;

public interface IActionChain extends IActionChainArmory {

    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}
