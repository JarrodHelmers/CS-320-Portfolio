import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
    // Test adding a valid appointment
    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 100000), "Description");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("1234567890"));
    }

    // Test adding a duplicate appointment
    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("1234567890", new Date(System.currentTimeMillis() + 100000), "Description");
        Appointment appointment2 = new Appointment("1234567890", new Date(System.currentTimeMillis() + 100000), "Another Description");
        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    // Test deleting an appointment
    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 100000), "Description");
        service.addAppointment(appointment);
        service.deleteAppointment("1234567890");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointment("1234567890");
        });
    }

    // Test deleting a non-existent appointment
    @Test
    public void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("nonexistent");
        });
    }
}
