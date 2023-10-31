package personal.fernando.todolist.task.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import personal.fernando.todolist.task.TaskModel;
import personal.fernando.todolist.task.TaskRepository;
import personal.fernando.todolist.task.Service.TaskService;

@Service
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
    public TaskModel update(TaskModel taskModel, Long id, HttpServletRequest request) {
        taskModel.setId(id);
        return repository.save(taskModel);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<TaskModel> findById(Long id) {
        return repository.findById(id);
        
    }

    
    
}
