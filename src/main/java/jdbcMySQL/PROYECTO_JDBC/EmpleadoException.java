package jdbcMySQL.PROYECTO_JDBC;

public class EmpleadoException extends RuntimeException {
	
	public EmpleadoException() {
		super("Empleado incorrecto");
	}

	public EmpleadoException(String mensa) {
		super("Empleado incorrecto " + mensa);
	}

}
