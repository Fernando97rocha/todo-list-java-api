package personal.fernando.todolist.task.Service;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import personal.fernando.todolist.task.TaskModel;

public interface TaskService {
    
    public TaskModel create(TaskModel taskModel, HttpServletRequest request);
    public TaskModel update(TaskModel taskModel, Long id);
    public void delete(Long id);
    public List<TaskModel> findAll();
}