package me.tristanhoermann.pandaboard.repository.database;

import lombok.Getter;
import me.tristanhoermann.pandaboard.repository.task.TaskModel;

import java.util.LinkedList;

public class DatabaseStub {

    @Getter
    private static final LinkedList<TaskModel> tasks = new LinkedList<>();

    /**
     * Adds a task to the database.
     */
    public static void addTask(TaskModel task){
        tasks.add(task);
    }

    /**
     * Returns a task with the given ID. Returns an empty task, when there is none.
     */
    public static TaskModel getTaskById(int id){
        for (TaskModel task : tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return TaskModel.getEmptyTask();
    }

    /**
     * Counts existing tasks and returns count+1 for a new ID.
     */
    public static int getNewTaskId(){
        return tasks.size();
    }

}
