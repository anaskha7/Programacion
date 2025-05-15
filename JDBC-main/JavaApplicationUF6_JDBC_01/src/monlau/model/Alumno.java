package monlau.model;

public class Alumno {
    private Integer id;
    private String nombre;
    private Integer edad;

    public Alumno() {}

    public Alumno(Integer id, String nombre, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno(id=" + id + ", nombre=" + nombre + ", edad=" + edad + ")";
    }
}
