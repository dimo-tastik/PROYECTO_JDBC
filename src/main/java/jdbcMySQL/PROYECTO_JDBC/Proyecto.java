package jdbcMySQL.PROYECTO_JDBC;

import java.time.LocalDate;

public class Proyecto {
	
	private Integer num_proy;
	private String nombre;
	private String dni_nif_jefe_proy;
	private LocalDate f_inicio;
	private LocalDate f_fin;
	
	public Proyecto(Integer num_proy, String nombre, String dni_nif_jefe_proy, LocalDate f_inicio, LocalDate f_fin) {
		super();
		setNum_proy(num_proy);
		setNombre(nombre);
		setDni_nif_jefe_proy(dni_nif_jefe_proy);
		setF_inicio(f_inicio);
		setF_fin(f_fin);
	}

	public Proyecto() {
		super();
		setNum_proy(null);
		setNombre(null);
		setDni_nif_jefe_proy(null);
		setF_inicio(LocalDate.now());
		setF_fin(null);
	}

	public Integer getNum_proy() {
		return num_proy;
	}

	public void setNum_proy(Integer num_proy) {
		if (num_proy == null) {
			//
		}else {
			this.num_proy = num_proy;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni_nif_jefe_proy() {
		return dni_nif_jefe_proy;
	}

	public void setDni_nif_jefe_proy(String dni_nif_jefe_proy) {
		this.dni_nif_jefe_proy = dni_nif_jefe_proy;
	}

	public LocalDate getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(LocalDate f_inicio) {
		this.f_inicio = f_inicio;
	}

	public LocalDate getF_fin() {
		return f_fin;
	}

	public void setF_fin(LocalDate f_fin) {
		this.f_fin = f_fin;
	}

	@Override
	public String toString() {
		return "Proyecto [num_proy=" + num_proy + ", nombre=" + nombre + ", dni_nif_jefe_proy=" + dni_nif_jefe_proy
				+ ", f_inicio=" + f_inicio + ", f_fin=" + f_fin + "]";
	}
	
	
}
