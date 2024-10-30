import java.sql.*;

public class ConexionMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "mzf2casa18";

    // Método para establecer la conexión
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar un empleado
    public static void insertarEmpleado(String nombre, String paSurname, String maSurname, String email, double salario) {
        String sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, paSurname);
            pstmt.setString(3, maSurname);
            pstmt.setString(4, email);
            pstmt.setDouble(5, salario);
            pstmt.executeUpdate();
            System.out.println("Empleado insertado correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para consultar empleados
    public static void consultarEmpleados() {
        String sql = "SELECT * FROM employees";
        try (Connection conexion = getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nombre: %s, Apellido Paterno: %s, Apellido Materno: %s, Email: %s, Salario: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("pa_surname"),
                        rs.getString("ma_surname"),
                        rs.getString("email"),
                        rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un empleado
    public static void actualizarEmpleado(int id, String nombre, String paSurname, String maSurname, String email, double salario) {
        String sql = "UPDATE employees SET first_name = ?, pa_surname = ?, ma_surname = ?, email = ?, salary = ? WHERE id = ?";
        try (Connection conexion = getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, paSurname);
            pstmt.setString(3, maSurname);
            pstmt.setString(4, email);
            pstmt.setDouble(5, salario);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            System.out.println("Empleado actualizado correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un empleado
    public static void eliminarEmpleado(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conexion = getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Empleado eliminado correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
