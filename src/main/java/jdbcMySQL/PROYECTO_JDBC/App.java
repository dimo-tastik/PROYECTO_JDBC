package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Connection c = DBC.getConexion();
    }
}
