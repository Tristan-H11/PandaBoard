package me.tristanhoermann.pandaboard.controller;

import me.tristanhoermann.pandaboard.repository.database.DatabaseStub;
import me.tristanhoermann.pandaboard.repository.task.TaskModel;
import me.tristanhoermann.pandaboard.service.TaskHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskRequests {

    @GetMapping("/getTaskById")
    TaskModel getTaskById(@RequestParam("id") int id){
        return TaskHandler.getTaskById(id);
    }

    @GetMapping("/getAllTasks")
    List<TaskModel> getAllTasks(){
        return TaskHandler.getTasks();
    }


    @GetMapping("/createTask")
    void createTask(@RequestParam("title") String title,
                    @RequestParam("content") String content){
        TaskHandler.createTask(title, content);
    }

}
