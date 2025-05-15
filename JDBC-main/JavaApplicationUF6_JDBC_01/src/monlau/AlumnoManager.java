
package monlau;

import monlau.dao.AlumnoDAO;
import monlau.dao.AlumnoDAOImpl;
import monlau.model.Alumno;

public class AlumnoManager {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAOImpl();

        // Agregar nuevo alumno
        alumnoDAO.insert(new Alumno(200, "Juan Pérez", 18));

        // Obtener el alumno con ID = 200
        Alumno a = alumnoDAO.read(200);
        System.out.println(a);
    }
}
