package personal.fernando.todolist.task.Service;

import personal.fernando.todolist.task.TaskModel;

public interface TaskService {
    
    public TaskModel create(TaskModel taskModel);
    public TaskModel alter(Long id);
    public void delete(Long id);
}