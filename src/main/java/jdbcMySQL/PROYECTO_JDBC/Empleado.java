package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleado {

	private String dni_nif;
	private String nombreEmpleado;

	public Empleado(String dni_nif, String nombreEmpleado) throws SQLException {
		setDni_nif(dni_nif);
		setNombreEmpleado(nombreEmpleado);
	}

	public Empleado() {
		super();
	}

	public String getDni_nif() {
		return dni_nif;
	}

	public void setDni_nif(String dni_nif) {
		this.dni_nif = dni_nif;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public void save() throws SQLException, EmpleadoException {
		Connection c = DBC.getConexion();

		String id = getDni_nif();
		String nombre = getNombreEmpleado();

		if (id == null || nombre == null) {
			throw new EmpleadoException(id);
		} else {
			String query = "SELECT * FROM empleados WHERE dni_nif like ?;";
			PreparedStatement ps1 = c.prepareStatement(query);
			ps1.setString(1, id);
			ResultSet rs = ps1.executeQuery();
			
			if (rs.next()) {
				String update = "UPDATE empleados SET nombre = ? WHERE nombre like ?;";
				PreparedStatement ps2 = c.prepareStatement(update);
				ps2.setString(1, nombre);
				ps2.setString(2, rs.getString("nombre"));

				ps2.executeUpdate();

				ps2.close();
				
				System.out.println("Empleado Actualizado");
				
			}else {
				String insert = "INSERT INTO empleados VALUES (?, ?);";
				PreparedStatement ps2 = c.prepareStatement(insert);
				ps2.setString(1, id);
				ps2.setString(2, nombre);
				
				ps2.executeUpdate();
				
				ps2.close();
				
				System.out.println("Nuevo Empleado Insertado");
				
			}

			rs.close();
			ps1.close();
		}

	}

	@Override
	public String toString() {
		return "Empleado [dni_nif=" + dni_nif + ", nombreEmpleado=" + nombreEmpleado + "]";
	}

}
