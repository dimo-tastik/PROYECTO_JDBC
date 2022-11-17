package jdbcMySQL.PROYECTO_JDBC;

public class ProyectoException extends RuntimeException {
	
	public ProyectoException() {
		super("Proyecto incorrecto");
	}

	public ProyectoException(String mensa) {
		super("Proyecto incorrecto " + mensa);
	}
	
	public ProyectoException(long mensa) {
		super("Proyecto incorrecto " + mensa);
	}

}
