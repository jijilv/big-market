package edu.szu.domain.activity.service.partake;

import com.alibaba.fastjson.JSON;
import edu.szu.domain.activity.model.aggregate.CreatePartakeOrderAggregate;
import edu.szu.domain.activity.model.entity.ActivityEntity;
import edu.szu.domain.activity.model.entity.PartakeRaffleActivityEntity;
import edu.szu.domain.activity.model.entity.UserRaffleOrderEntity;
import edu.szu.domain.activity.model.valobj.ActivityStateVO;
import edu.szu.domain.activity.repository.IActivityRepository;
import edu.szu.domain.activity.service.IRaffleActivityPartakeService;
import edu.szu.types.enums.ResponseCode;
import edu.szu.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


@Slf4j
public abstract class AbstractRaffleActivityPartake implements IRaffleActivityPartakeService {

    protected final IActivityRepository activityRepository;

    public AbstractRaffleActivityPartake(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public UserRaffleOrderEntity createOrder(String userId, Long activityId) {
        return createOrder(PartakeRaffleActivityEntity.builder()
                .userId(userId)
                .activityId(activityId)
                .build());
    }

    @Override
    public UserRaffleOrderEntity createOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity) {
        // 0. 基础信息
        String userId = partakeRaffleActivityEntity.getUserId();
        Long activityId = partakeRaffleActivityEntity.getActivityId();
        Date currentDate = new Date();
        log.info("创建活动抽奖单开始 userId:{} activityId:{}", userId, activityId);
        // 1. 活动查询
        ActivityEntity activityEntity = activityRepository.queryRaffleActivityByActivityId(activityId);

        // 校验；活动状态
        if (!ActivityStateVO.open.equals(activityEntity.getState())) {
            log.error("创建活动抽奖单失败，活动状态未开启 activityId:{} state:{}", activityId, activityEntity.getState());
            throw new AppException(ResponseCode.ACTIVITY_STATE_ERROR.getCode(), ResponseCode.ACTIVITY_STATE_ERROR.getInfo());
        }
        // 校验；活动日期「开始时间 <- 当前时间 -> 结束时间」
        if (activityEntity.getBeginDateTime().after(currentDate) || activityEntity.getEndDateTime().before(currentDate)) {
            throw new AppException(ResponseCode.ACTIVITY_DATE_ERROR.getCode(), ResponseCode.ACTIVITY_DATE_ERROR.getInfo());
        }

        // 2. 查询未被使用的活动参与订单记录
        UserRaffleOrderEntity userRaffleOrderEntity = activityRepository.queryNoUsedRaffleOrder(partakeRaffleActivityEntity);
        if (null != userRaffleOrderEntity) {
            log.info("创建参与活动订单存在 userId:{} activityId:{} userRaffleOrderEntity:{}", userId, activityId, JSON.toJSONString(userRaffleOrderEntity));
            return userRaffleOrderEntity;
        }

        // 3. 额度账户过滤&返回账户构建对象
        CreatePartakeOrderAggregate createPartakeOrderAggregate = this.doFilterAccount(userId, activityId, currentDate);

        // 4. 构建订单
        UserRaffleOrderEntity userRaffleOrder = this.buildUserRaffleOrder(userId, activityId, currentDate);

        // 5. 填充抽奖单实体对象
        createPartakeOrderAggregate.setUserRaffleOrderEntity(userRaffleOrder);

        // 6. 保存聚合对象 - 一个领域内的一个聚合是一个事务操作
        activityRepository.saveCreatePartakeOrderAggregate(createPartakeOrderAggregate);
        log.info("创建活动抽奖单完成 userId:{} activityId:{} orderId:{}", userId, activityId, userRaffleOrder.getOrderId());
        // 7. 返回订单信息
        return userRaffleOrder;
    }

    protected abstract CreatePartakeOrderAggregate doFilterAccount(String userId, Long activityId, Date currentDate);

    protected abstract UserRaffleOrderEntity buildUserRaffleOrder(String userId, Long activityId, Date currentDate);

}


