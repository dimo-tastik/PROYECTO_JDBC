package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
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
			
			gp.c.setAutoCommit(false);
			
//			System.out.println(gp.NuevoEmpleado("39391056Z", "Dimitri"));
//			System.out.println(gp.NuevoEmpleado("02300652P", "Angel"));
////			
//			System.out.println(gp.nuevoProyecto(1, "proyecto 1", "39391056Z", LocalDate.of(2022, 11, 11), null));
//			System.out.println(gp.nuevoProyecto(2, "proyecto 2", "02300652P", null, null));
////			
//			gp.asignaEmpAProyecto("39391056Z", 1, LocalDate.of(2022, 11, 11), null);
//			gp.asignaEmpAProyecto("02300652P", 2, null, null);
//			
			gp.getMetaDatosTablas();
			
			Empleado e = new Empleado();
				e.setDni_nif("22222222U");
				e.setNombreEmpleado("Cristina");
			e.save();
			Proyecto p = new Proyecto();
				p.setNum_proy(1);
				p.setNombre("proyecto 1");
				p.setDni_nif_jefe_proy("39391056Z");
				p.setF_inicio(null);
				p.setF_fin(null);
			p.save();
			AsigProyectos ap = new AsigProyectos();
				ap.setDni_nif_emp("22222222U");
				ap.setNum_proy(1);
				ap.setF_inicio(LocalDate.of(2022, 11, 11));
				ap.setF_fin(null);
			ap.save();
			
			gp.c.commit();
			
			
		} catch (SQLException e) {
			try{
            	gp.c.rollback();
            	System.err.println("rollback");
            	e.printStackTrace();
            } catch (SQLException sqle) {
                System.err.println("ERROR haciendo ROLLBACK");
                sqle.printStackTrace(System.err);
              }			
		}

		
    }
}
