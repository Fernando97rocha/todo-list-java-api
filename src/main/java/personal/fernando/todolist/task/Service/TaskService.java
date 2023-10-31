package personal.fernando.todolist.task.Service;

import java.util.Optional;

import personal.fernando.todolist.task.TaskModel;

public interface TaskService {
    
    public TaskModel create(TaskModel taskModel);
    public TaskModel update(TaskModel taskModel, Long id);
    public void delete(Long id);
    public Optional<TaskModel> findById(Long id);
}