package edu.szu.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import edu.szu.infrastructure.dao.po.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITaskDao {

    void insert(Task task);

    @DBRouter
    void updateTaskSendMessageCompleted(Task task);

    @DBRouter
    void updateTaskSendMessageFail(Task task);

    List<Task> queryNoSendMessageTaskList();

}
