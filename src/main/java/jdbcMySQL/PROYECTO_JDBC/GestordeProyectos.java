package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/*
 * Esta clase contiene métodos para almacenar datos de empleados,
 * proyectos y asignaciones de empleados a proyectos.
 * 
 */

public class GestordeProyectos {

	static Connection c = DBC.getConexion();

	public static boolean NuevoEmpleado(String dni_nif, String nombre) throws EmpleadoException, SQLException {
		boolean se_creo_correctamente;
		String insert = "INSERT INTO empleados VALUES (?, ?);";

		PreparedStatement ps = c.prepareStatement(insert);

		if (dni_nif == null || dni_nif.isBlank() || dni_nif.length() > 9) {
			se_creo_correctamente = false;
			throw new EmpleadoException(dni_nif);

		}
		if (nombre == null || nombre.isBlank() || nombre.length() > 32) {
			se_creo_correctamente = false;
			throw new EmpleadoException(nombre);

		}

		ps.setString(1, dni_nif);
		ps.setString(2, nombre);

		ps.executeUpdate();

		ps.close();

		se_creo_correctamente = true;
		return se_creo_correctamente;
	}

	public static long nuevoProyecto(long num_proy, String nombre, String dni_nif_jefe_proy, LocalDate f_inicio,
			LocalDate f_fin) throws ProyectoException, SQLException {
		long n = num_proy;
		String insert = "INSERT INTO proyectos VALUES (?, ?, ?, ?, ?);";

		PreparedStatement ps = c.prepareStatement(insert);

		if (num_proy == 0) {
			throw new ProyectoException(num_proy);
		}
		if (nombre == null || nombre.isBlank() || nombre.length() > 32) {
			throw new ProyectoException(nombre);
		}
		if (dni_nif_jefe_proy == null || dni_nif_jefe_proy.isBlank() || dni_nif_jefe_proy.length() > 9) {
			throw new ProyectoException(dni_nif_jefe_proy);
		}

		ps.setLong(1, num_proy);
		ps.setString(2, nombre);
		ps.setString(3, dni_nif_jefe_proy);
		if (f_inicio == null) {
			f_inicio = f_inicio.now();
		}
		ps.setDate(4, java.sql.Date.valueOf(f_inicio));

		if (f_fin == null) {
			ps.setDate(5, null);
		} else {
			ps.setDate(5, java.sql.Date.valueOf(f_fin));
		}
		ps.executeUpdate();

		ps.close();

		return n;
	}

	public static void asignaEmpAProyecto(String dni_nif_emp, long num_proy, LocalDate f_inicio, LocalDate f_fin)
			throws SQLException {
		String insert = "INSERT INTO asig_proyectos VALUES (?, ?, ?, ?);";

		PreparedStatement ps = c.prepareStatement(insert);

		ps.setString(1, dni_nif_emp);
		ps.setLong(2, num_proy);
		if (f_inicio == null) {
			f_inicio = f_inicio.now();
		}
		ps.setDate(3, java.sql.Date.valueOf(f_inicio));

		if (f_fin == null) {
			ps.setDate(4, null);
		} else {
			ps.setDate(4, java.sql.Date.valueOf(f_fin));
		}
		ps.executeUpdate();

		ps.close();

	}

	public static void getMetaDatosTablas() throws SQLException {
		String tabla1 = "SELECT * FROM empleados;";
		String tabla2 = "SELECT * FROM proyectos;";
		String tabla3 = "SELECT * FROM asig_proyectos;";

		Statement st = c.createStatement();

		ResultSet rs1 = st.executeQuery(tabla1);
		ResultSetMetaData rsmd1 = rs1.getMetaData();
		while (rs1.next()) {
			for (int i = 1; i <= rsmd1.getColumnCount(); i++) {
				System.out.print(rsmd1.getColumnName(i) + " ");
			}
			System.out.println("\n"+rs1.getObject(1) + " " + rs1.getObject(2));
		}

		ResultSet rs2 = st.executeQuery(tabla2);
		ResultSetMetaData rsmd2 = rs2.getMetaData();
		System.out.println(rsmd2);
		System.out.println();

		ResultSet rs3 = st.executeQuery(tabla3);
		ResultSetMetaData rsmd3 = rs3.getMetaData();
		System.out.println(rsmd3);
		System.out.println();

		rs3.close();
		rs2.close();
		rs1.close();
		st.close();

	}

}
