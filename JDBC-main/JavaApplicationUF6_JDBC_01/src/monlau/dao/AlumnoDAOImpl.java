package monlau.dao;

import monlau.model.Alumno;
import java.sql.*;

public class AlumnoDAOImpl implements AlumnoDAO {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/monlau?useSSL=false";
    static final String DB_USR = "root";
    static final String DB_PWD = "";

    private void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: failed to load MySQL JDBC Driver");
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Alumno alumno) {
        Connection conn = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO alumnos (id, nombre, edad) VALUES ("
                    + alumno.getId() + ",'"
                    + alumno.getNombre() + "',"
                    + alumno.getEdad() + ");");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Alumno alumno) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
             PreparedStatement ps = conn.prepareStatement("UPDATE alumnos SET nombre = ?, edad = ? WHERE id = ?")) {
            registerDriver();
            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getEdad());
            ps.setInt(3, alumno.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Alumno alumno) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
             PreparedStatement ps = conn.prepareStatement("DELETE FROM alumnos WHERE id = ?")) {
            registerDriver();
            ps.setInt(1, alumno.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Alumno read(Integer id) {
        Connection conn = null;
        Alumno alumno = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM alumnos WHERE id = ?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        alumno = new Alumno(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getInt("edad")
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return alumno;
    }
}
