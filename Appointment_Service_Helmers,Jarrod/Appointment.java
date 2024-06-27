import java.util.Date;

public class Appointment {
    private final String appointmentId;  // Unique ID for the appointment
    private final Date appointmentDate;  // Date of the appointment
    private final String description;    // Description of the appointment

    // Constructor for creating an appointment
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        // Validate appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter for appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Getter for appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}
