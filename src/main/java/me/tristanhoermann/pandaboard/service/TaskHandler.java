package me.tristanhoermann.pandaboard.service;

import me.tristanhoermann.pandaboard.repository.task.TaskModel;
import me.tristanhoermann.pandaboard.repository.database.DatabaseStub;

import java.util.List;

public class TaskHandler {

    public static TaskModel getTaskById(int id){
        return DatabaseStub.getTaskById(id);
    }

    public static void createTask(String title, String content){
        TaskModel task = new TaskModel(DatabaseStub.getNewTaskId(), title, content);
        DatabaseStub.addTask(task);
    }

    public static List<TaskModel> getTasks(){
        return DatabaseStub.getTasks();
    }

}
