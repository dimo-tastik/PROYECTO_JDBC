package jdbcMySQL.PROYECTO_JDBC;

public class AsigProyectoException extends RuntimeException {
	
	public AsigProyectoException() {
		super("Asignación inválida");
	}

	public AsigProyectoException(String dni_nif_emp, long num_proy) {
		super("Asignación inválida" + dni_nif_emp + " " + num_proy);
	}

}
