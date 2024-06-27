import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {
    // Test creating a valid appointment
    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 100000), "Valid Description");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertNotNull(appointment.getAppointmentDate());
        assertEquals("Valid Description", appointment.getDescription());
    }

    // Test creating an appointment with an invalid ID
    @Test
    public void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "Description");
        });
    }

    // Test creating an appointment with an invalid date
    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(System.currentTimeMillis() - 100000), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Description");
        });
    }

    // Test creating an appointment with an invalid description
    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), "A".repeat(51));
        });
    }
}
