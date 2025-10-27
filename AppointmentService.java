import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) throw new IllegalArgumentException("Appointment cannot be null");
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Duplicate Appointment ID");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public boolean deleteAppointment(String appointmentId) {
        return appointments.remove(appointmentId) != null;
    }

    public void updateAppointmentDate(String appointmentId, Date newDate) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) throw new IllegalArgumentException("Appointment not found");
        appointment.setAppointmentDate(newDate);
    }

    public void updateAppointmentDescription(String appointmentId, String newDescription) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) throw new IllegalArgumentException("Appointment not found");
        appointment.setDescription(newDescription);
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
