package me.tristanhoermann.pandaboard.controller;

import me.tristanhoermann.pandaboard.repository.task.TaskModel;
import me.tristanhoermann.pandaboard.service.TaskHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class TaskRequests {

    @GetMapping("/getTaskByTitle")
    ResponseEntity<TaskModel> getTaskByTitle(@RequestParam("title") final String title) {
        return ResponseEntity.ok()
                .body(TaskHandler.getTaskByTitle(title));
    }

    @GetMapping("/getAllTasks")
    ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.ok()
                .body(TaskHandler.getTasks());
    }

    @GetMapping("/createTask")
    ResponseEntity<Object> createTask(@RequestParam("title") final String title,
                                         @RequestParam("content") final String content) {
        final TaskModel task = TaskHandler.createTask(title, content);
        if (task.isEmpty()) {
            return ResponseEntity.status(419)
                    .body("There is already a task with this title");
        } else {
            return ResponseEntity.ok()
                    .body(task);
        }
    }

    @DeleteMapping("/deleteTask")
    ResponseEntity<String> deleteTask(@RequestParam("title") final String title) {
        if (TaskHandler.deleteTaskByTitle(title) < 1.0) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            return ResponseEntity.ok()
                    .build();
        }
    }
}
