package monlau.dao;

import monlau.model.Alumno;

public interface AlumnoDAO {
    public void insert(Alumno alumno);
    public void update(Alumno alumno);
    public void delete(Alumno alumno);
    public Alumno read(Integer id);
}


