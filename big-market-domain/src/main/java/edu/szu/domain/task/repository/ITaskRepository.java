package edu.szu.domain.task.repository;

import edu.szu.domain.task.model.entity.TaskEntity;

import java.util.List;

public interface ITaskRepository {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);

}
