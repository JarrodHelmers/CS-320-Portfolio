import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // In-memory data structure to store tasks
    private Map<String, Task> tasks;

    // Constructor to initialize the task service
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Method to add a task
    public void addTask(Task task) {
        // Check if task ID already exists
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Method to delete a task by task ID
    public void deleteTask(String taskId) {
        // Check if task ID exists
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskId);
    }

    // Method to update the name of a task by task ID
    public void updateTaskName(String taskId, String name) {
        Task task = tasks.get(taskId);
        // Check if task ID exists
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setName(name);
    }

    // Method to update the description of a task by task ID
    public void updateTaskDescription(String taskId, String description) {
        Task task = tasks.get(taskId);
        // Check if task ID exists
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setDescription(description);
    }

    // Method to get a task by task ID
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}