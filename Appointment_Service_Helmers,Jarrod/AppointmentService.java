import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // Store appointments in a HashMap
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Method to add an appointment
    public void addAppointment(Appointment appointment) {
        // Check if the appointment ID already exists
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        // Check if the appointment ID exists
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        appointments.remove(appointmentId);
    }

    // Method to get an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        // Check if the appointment ID exists
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        return appointments.get(appointmentId);
    }
}
