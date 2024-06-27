import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;

    // Setup before each test
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    // Test adding a task
    @Test
    public void testAddTask() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1"));
    }

    // Test adding a task with duplicate ID
    @Test
    public void testAddTaskDuplicateId() {
        Task task1 = new Task("1", "Test Task 1", "This is a test task 1.");
        Task task2 = new Task("1", "Test Task 2", "This is a test task 2.");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    // Test deleting a task
    @Test
    public void testDeleteTask() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    // Test deleting a task with non-existent ID
    @Test
    public void testDeleteTaskNonExistentId() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("1"));
    }

    // Test updating task name
    @Test
    public void testUpdateTaskName() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        taskService.addTask(task);
        taskService.updateTaskName("1", "New Task Name");
        assertEquals("New Task Name", taskService.getTask("1").getName());
    }

    // Test updating task description
    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        taskService.addTask(task);
        taskService.updateTaskDescription("1", "New Description");
        assertEquals("New Description", taskService.getTask("1").getDescription());
    }

    // Test updating task name with non-existent ID
    @Test
    public void testUpdateTaskNameNonExistentId() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("1", "New Task Name"));
    }

    // Test updating task description with non-existent ID
    @Test
    public void testUpdateTaskDescriptionNonExistentId() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("1", "New Description"));
    }
}
