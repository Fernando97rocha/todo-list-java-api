package personal.fernando.todolist.task.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import personal.fernando.todolist.task.TaskModel;
import personal.fernando.todolist.task.TaskRepository;
import personal.fernando.todolist.task.Service.TaskService;

public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository repository;

    @Override
    public TaskModel create(TaskModel taskModel) {
        if (taskModel == null) {
            throw new IllegalArgumentException();
        }
        return repository.save(taskModel);
    }



    @Override
    public TaskModel alter(Long id) {
        var taskToAlter = repository.findById(id);
        

    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
