import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskTest {

    // Test creating a task with valid data
    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        assertEquals("1", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task.", task.getDescription());
    }

    // Test creating a task with invalid task ID
    @Test
    public void testTaskCreationInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Test Task", "This is a test task."));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Test Task", "This is a test task."));
    }

    // Test creating a task with invalid name
    @Test
    public void testTaskCreationInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "This is a test task."));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "This is a very long name that exceeds the limit", "This is a test task."));
    }

    // Test creating a task with invalid description
    @Test
    public void testTaskCreationInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Test Task", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Test Task", "This description is way too long and exceeds the fifty character limit."));
    }

    // Test setting a valid name
    @Test
    public void testTaskSetName() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        task.setName("New Task Name");
        assertEquals("New Task Name", task.getName());
    }

    // Test setting a valid description
    @Test
    public void testTaskSetDescription() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    // Test setting an invalid name
    @Test
    public void testTaskSetNameInvalid() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("This is a very long name that exceeds the limit"));
    }

    // Test setting an invalid description
    @Test
    public void testTaskSetDescriptionInvalid() {
        Task task = new Task("1", "Test Task", "This is a test task.");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("This description is way too long and exceeds the fifty character limit."));
    }
}