package jdbcMySQL.PROYECTO_JDBC;

public class DniEmpleadoException extends RuntimeException {
	
	public DniEmpleadoException() {
		super("DNI incorrecto");
	}

	public DniEmpleadoException(String mensa) {
		super("DNI incorrecto " + mensa);
	}

}
