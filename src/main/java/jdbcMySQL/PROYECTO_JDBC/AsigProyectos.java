package jdbcMySQL.PROYECTO_JDBC;

import java.time.LocalDate;

public class AsigProyectos {
	
	private String dni_nif_emp;
	private long num_proy;
	private LocalDate f_inicio;
	private LocalDate f_fin;
	
	public AsigProyectos(String dni_nif_emp, long num_proy, LocalDate f_inicio, LocalDate f_fin) {
		super();
		setDni_nif_emp(dni_nif_emp);
		setNum_proy(num_proy);
		setF_inicio(f_inicio);
		setF_fin(f_fin);
	}
	
	public AsigProyectos() {
		super();
	}
	
	public String getDni_nif_emp() {
		return dni_nif_emp;
	}
	public void setDni_nif_emp(String dni_nif_emp) {
		this.dni_nif_emp = dni_nif_emp;
	}
	public long getNum_proy() {
		return num_proy;
	}
	public void setNum_proy(long num_proy) {
		this.num_proy = num_proy;
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
		return "AsigProyectos [dni_nif_emp=" + dni_nif_emp + ", num_proy=" + num_proy + ", f_inicio=" + f_inicio
				+ ", f_fin=" + f_fin + "]";
	}
	
}
