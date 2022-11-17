package jdbcMySQL.PROYECTO_JDBC;

public class Empleado {
	
	private String dni_nif;
	private String nombreEmpleado;
	
	public Empleado(String dni_nif, String nombreEmpleado) {
		super();
		setDni_nif(dni_nif);
		setNombreEmpleado(nombreEmpleado);
	}

	public String getDni_nif() {
		return dni_nif;
	}

	public void setDni_nif(String dni_nif) {
		if (dni_nif == null || dni_nif.isBlank() || dni_nif.length() > 9) {
			throw new EmpleadoException(dni_nif);
		}else {
			this.dni_nif = dni_nif;
		}
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		if (nombreEmpleado == null ||nombreEmpleado.isBlank() || nombreEmpleado.length() > 32) {
			throw new EmpleadoException(nombreEmpleado);
		}else {
			this.nombreEmpleado = nombreEmpleado;
		}
	}

	@Override
	public String toString() {
		return "Empleado [dni_nif=" + dni_nif + ", nombreEmpleado=" + nombreEmpleado + "]";
	}
	
	
}
