package jdbcMySQL.PROYECTO_JDBC;

public class NombreEmpleadoException extends RuntimeException {
	
	public NombreEmpleadoException() {
		super("Nombre incorrecto ");
	}
	
	public NombreEmpleadoException(String mensa) {
		super("Nombre incorrecto " + mensa);
	}

}
