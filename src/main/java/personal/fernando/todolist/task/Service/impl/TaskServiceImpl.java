package personal.fernando.todolist.task.Service.impl;

import java.util.ArrayList;
import java.util.List;
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
    public TaskModel create(TaskModel taskModel, HttpServletRequest request) {
        if (taskModel == null) {
            throw new IllegalArgumentException();
        }
        var user = request.getAttribute("userId");
        taskModel.setUserId((Long) user);
        return repository.save(taskModel);
    }

    @Override
    public TaskModel update(TaskModel taskModel, Long id) {
        TaskModel task = repository.findById(id).get();
        task.setId(id);
        task.setUserId(taskModel.getUserId());
        task.setDescription(taskModel.getDescription());
        task.setCreatedAt(taskModel.getCreatedAt());
        return repository.save(task);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TaskModel> findAll() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }
 
}
