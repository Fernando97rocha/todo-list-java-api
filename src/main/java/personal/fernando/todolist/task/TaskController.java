package personal.fernando.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        var user = request.getAttribute("userId");
        taskModel.setUserId((Long) user);
        service.create(taskModel);
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

    

}
