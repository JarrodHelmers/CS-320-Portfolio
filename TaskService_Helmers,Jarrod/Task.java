public class Task {
    // Task ID, final as it should not be updatable
    private final String taskId;
    // Name of the task
    private String name;
    // Description of the task
    private String description;

    // Constructor to initialize task object
    public Task(String taskId, String name, String description) {
        // Validate taskId
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and must be less than or equal to 10 characters.");
        }
        // Validate name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and must be less than or equal to 20 characters.");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be less than or equal to 50 characters.");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getter for taskId
    public String getTaskId() {
        return taskId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and must be less than or equal to 20 characters.");
        }
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be less than or equal to 50 characters.");
        }
        this.description = description;
    }
}