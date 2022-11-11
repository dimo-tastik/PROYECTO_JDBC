package jdbcMySQL.PROYECTO_JDBC;

import java.time.LocalDate;

/*
 * Esta clase contiene métodos para almacenar datos de empleados,
 * proyectos y asignaciones de empleados a proyectos.
 * 
 */

public class GestordeProyectos {

	public static boolean NuevoEmpleado(String dni_nif, String nombre) throws DniEmpleadoException, NombreEmpleadoException{
		Empleado e;
		e = new Empleado(dni_nif, nombre);
		return true;
	}
	public static int nuevoProyecto(Integer num_proy, String nombre, String dni_nif_jefe_proy, LocalDate f_inicio, LocalDate f_fin) {
		Proyecto p;
		p = new Proyecto(num_proy, nombre, dni_nif_jefe_proy, f_inicio, f_fin);
		return p.getNum_proy();
	}
}
