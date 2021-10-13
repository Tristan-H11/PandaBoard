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

    @GetMapping("/getTaskByTitle")
    TaskModel getTaskByTitle(@RequestParam("title") final String title) {
        return TaskHandler.getTaskByTitle(title);
    }

    @GetMapping("/getAllTasks")
    List<TaskModel> getAllTasks() {
        return TaskHandler.getTasks();
    }

    @GetMapping("/createTask")
    ResponseEntity<TaskModel> createTask(@RequestParam("title") final String title,
                                         @RequestParam("content") final String content) {
        return TaskHandler.createTask(title, content);
    }

    @DeleteMapping("/deleteTask")
    ResponseEntity<String> deleteTask(@RequestParam("title") final String title) {
        if (TaskHandler.deleteTaskByTitle(title) < 1.0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
