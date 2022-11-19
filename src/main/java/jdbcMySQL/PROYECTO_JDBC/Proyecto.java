package jdbcMySQL.PROYECTO_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Proyecto {

	private long num_proy;
	private String nombre;
	private String dni_nif_jefe_proy;
	private LocalDate f_inicio;
	private LocalDate f_fin;

	public Proyecto(long num_proy, String nombre, String dni_nif_jefe_proy, LocalDate f_inicio, LocalDate f_fin)
			throws SQLException {
		setNum_proy(num_proy);
		setNombre(nombre);
		setDni_nif_jefe_proy(dni_nif_jefe_proy);
		setF_inicio(f_inicio);
		setF_fin(f_fin);
	}

	public Proyecto() {
		super();
	}

	public long getNum_proy() {
		return num_proy;
	}

	public void setNum_proy(long num_proy) {
		this.num_proy = num_proy;
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
		if (f_inicio == null) {
			f_inicio = f_inicio.now();
		}
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

		long num_proy = getNum_proy();
		String nombre = getNombre();
		String dni_nif_jefe_proy = getDni_nif_jefe_proy();
		LocalDate f_inicio = getF_inicio(); //*
		LocalDate f_fin = getF_fin();

		if (num_proy == 0 || nombre == null || dni_nif_jefe_proy == null) {
			throw new ProyectoException(num_proy);
		} else {
			String query = "SELECT * FROM proyectos WHERE num_proy like ?;";
			PreparedStatement ps1 = c.prepareStatement(query);
			ps1.setLong(1, num_proy);
			ResultSet rs = ps1.executeQuery();
			
			if (rs.next()) {
				String update = "UPDATE proyectos SET nombre = ?, dni_nif_jefe_proy = ?, f_inicio = ?, f_fin = ? WHERE num_proy like ?;";
				PreparedStatement ps2 = c.prepareStatement(update);
				ps2.setString(1, nombre);
				ps2.setString(2, dni_nif_jefe_proy);
				if (f_inicio == null) {
					f_inicio = f_inicio.now();
				}
				ps2.setDate(3, java.sql.Date.valueOf(f_inicio));

				if (f_fin == null) {
					ps2.setDate(4, null);
				} else {
					ps2.setDate(4, java.sql.Date.valueOf(f_fin));
				}
				
				ps2.setLong(5, num_proy);
				
				ps2.executeUpdate();

				ps2.close();
				
				System.out.println("Proyecto Actualizado");
				
			}else {
				String insert = "INSERT INTO proyectos VALUES (?, ?, ?, ?, ?);";
				PreparedStatement ps2 = c.prepareStatement(insert);
				ps2.setLong(1, num_proy);
				ps2.setString(2, nombre);
				ps2.setString(3, dni_nif_jefe_proy);
				if (f_inicio == null) {
					f_inicio = f_inicio.now();
				}
				ps2.setDate(4, java.sql.Date.valueOf(f_inicio));

				if (f_fin == null) {
					ps2.setDate(5, null);
				} else {
					ps2.setDate(5, java.sql.Date.valueOf(f_fin));
				}
				
				ps2.executeUpdate();
				
				ps2.close();
				
				System.out.println("Nuevo Proyecto Insertado");
				
			}

			rs.close();
			ps1.close();
			
		}

	}

	@Override
	public String toString() {
		return "Proyecto [num_proy=" + num_proy + ", nombre=" + nombre + ", dni_nif_jefe_proy=" + dni_nif_jefe_proy
				+ ", f_inicio=" + f_inicio + ", f_fin=" + f_fin + "]";
	}

}
