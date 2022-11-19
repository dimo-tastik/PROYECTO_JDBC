package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AsigProyectos {

	private String dni_nif_emp;
	private long num_proy;
	private LocalDate f_inicio;
	private LocalDate f_fin;

	public AsigProyectos(String dni_nif_emp, long num_proy, LocalDate f_inicio, LocalDate f_fin) throws SQLException {
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

	public void save() throws SQLException, EmpleadoException {
		Connection c = DBC.getConexion();

		String dni_nif_emp = getDni_nif_emp();
		long num_proy = getNum_proy();
		LocalDate f_inicio = getF_inicio();
		LocalDate f_fin = getF_fin();

		if (dni_nif_emp == null || num_proy == 0) {
			throw new AsigProyectoException(dni_nif_emp, num_proy);
		} else {
			String query = "SELECT * FROM asig_proyectos WHERE dni_nif_emp = ? AND num_proy = ?;";
			PreparedStatement ps1 = c.prepareStatement(query);
			ps1.setString(1, dni_nif_emp);
			ps1.setLong(2, num_proy);
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				String update = "UPDATE asig_proyectos SET f_inicio = ?, f_fin = ? WHERE dni_nif_emp = ? AND num_proy = ?;";
				PreparedStatement ps2 = c.prepareStatement(update);
				if (f_inicio == null) {
					f_inicio = f_inicio.now();
				}
				ps2.setDate(1, java.sql.Date.valueOf(f_inicio));

				if (f_fin == null) {
					ps2.setDate(2, null);
				} else {
					ps2.setDate(2, java.sql.Date.valueOf(f_fin));
				}
				ps2.setString(3, dni_nif_emp);
				ps2.setLong(4, num_proy);
				
				ps2.executeUpdate();

				ps2.close();
				
				System.out.println("Asignación Actualizada");
			}else {
				String insert = "INSERT INTO asig_proyectos VALUES (?, ?, ?, ?);";
				PreparedStatement ps2 = c.prepareStatement(insert);
				ps2.setString(1, dni_nif_emp);
				ps2.setLong(2, num_proy);
				if (f_inicio == null) {
					f_inicio = f_inicio.now();
				}
				ps2.setDate(3, java.sql.Date.valueOf(f_inicio));

				if (f_fin == null) {
					ps2.setDate(4, null);
				} else {
					ps2.setDate(4, java.sql.Date.valueOf(f_fin));
				}
				
				ps2.executeUpdate();
				
				ps2.close();
				
				System.out.println("Nueva Asignación Insertada");

				
			}
		}

	}

	@Override
	public String toString() {
		return "AsigProyectos [dni_nif_emp=" + dni_nif_emp + ", num_proy=" + num_proy + ", f_inicio=" + f_inicio
				+ ", f_fin=" + f_fin + "]";
	}

}
