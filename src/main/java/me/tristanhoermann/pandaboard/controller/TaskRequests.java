package me.tristanhoermann.pandaboard.controller;

import me.tristanhoermann.pandaboard.repository.task.TaskModel;
import me.tristanhoermann.pandaboard.service.TaskHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskRequests {

    @GetMapping("/getTaskById")
    TaskModel getTaskById(@RequestParam("id") final int id){
        return TaskHandler.getTaskById(id);
    }

    @GetMapping("/getAllTasks")
    List<TaskModel> getAllTasks(){
        return TaskHandler.getTasks();
    }

    @GetMapping("/createTask")
    void createTask(@RequestParam("title") final String title,
                    @RequestParam("content") final String content){
        TaskHandler.createTask(title, content);
    }

    @DeleteMapping("/deleteTask")
    ResponseEntity<String> deleteTask(@RequestParam("id") final int id){
        if( TaskHandler.deleteTaskById(id)){
            return new ResponseEntity<>("Task not found!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
