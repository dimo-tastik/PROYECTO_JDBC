package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		GestordeProyectos gp = new GestordeProyectos();

		try {
//			gp.NuevoEmpleado("39391056Z", "Dimitri");
//			gp.NuevoEmpleado("02300652P", "Angel");
//			
//			gp.nuevoProyecto(1, "proyecto 1", "39391056Z", null, null);
//			gp.nuevoProyecto(2, "proyecto 2", "02300652P", null, null);
//			
//			gp.asignaEmpAProyecto("39391056Z", 1, null, null);
//			gp.asignaEmpAProyecto("02300652P", 2, null, null);
			
			gp.getMetaDatosTablas();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
    }
}
