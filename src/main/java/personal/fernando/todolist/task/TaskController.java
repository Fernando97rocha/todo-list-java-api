package personal.fernando.todolist.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import personal.fernando.todolist.task.Service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService service;

    @PostMapping("/")
    public HttpStatus create(@RequestBody TaskModel taskModel, HttpServletRequest request) {  
        service.create(taskModel, request);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus update(@ResquestBody TaskModel taskModel, @PathVariable Long id) {
        service.update(taskModel, id);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/list")
    public List<TaskModel> findByUserId() {
        return service.findAll();
    }

}
