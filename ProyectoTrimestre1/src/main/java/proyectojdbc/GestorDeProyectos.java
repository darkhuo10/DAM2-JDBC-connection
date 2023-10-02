package proyectojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorDeProyectos {
	// Sin objetos
	public static boolean creaEmpleado(String dniNif, String nombre) throws SQLException {
		String insertar = "INSERT INTO EMPLEADOS VALUES(?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);
				st.setString(1, dniNif);
				st.setString(2, nombre);
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
		return true;
	}

	public static Integer creaProyecto(Integer numero, String nombre, String jefe, Date inicio, Date fin)
			throws SQLException {
		String insertar = "INSERT INTO PROYECTOS VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);

				st.setInt(1, numero);
				st.setString(2, nombre);
				st.setString(3, jefe);
				if (inicio == null) {
					st.setDate(4, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(4, inicio);
				}
				st.setDate(5, fin);
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
		return numero;
	}

	public static boolean asignaEmpleadoProyecto(String dniEmpleado, Integer numProyecto, Date fInicio, Date fFin)
			throws SQLException {
		String insertar = "INSERT INTO ASIG_PROYECTOS VALUES(?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);

				st.setString(1, dniEmpleado);
				st.setInt(2, numProyecto);
				if (fInicio == null) {
					st.setDate(3, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(3, fInicio);
				}
				st.setDate(4, fFin);
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
			return true;
		}
	}

	// Con objetos
	public static boolean creaEmpleado(Empleado em) throws SQLException {
		String insertar = "INSERT INTO EMPLEADOS VALUES(?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);
				st.setString(1, em.getDniNif());
				st.setString(2, em.getNomrbe());
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
		return true;
	}

	public static Integer creaProyecto(Proyecto p) throws SQLException {
		String insertar = "INSERT INTO PROYECTOS VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);

				st.setInt(1, p.getNumero());
				st.setString(2, p.getNombre());
				st.setString(3, p.getDniNifJefe());
				if (p.getInicio() == null) {
					st.setDate(4, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(4, p.getInicio());
				}
				st.setDate(5, p.getFin());
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
		return p.getNumero();
	}

	public static boolean asignaEmpleadoProyecto(AsignacionProyecto as) throws SQLException {
		String insertar = "INSERT INTO ASIG_PROYECTOS VALUES(?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);

				st.setString(1, as.getDniEmpleado());
				st.setInt(2, as.getNumProyecto());
				if (as.getfInicio() == null) {
					st.setDate(3, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(3, as.getfInicio());
				}
				st.setDate(4, as.getfFin());
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
			return true;
		}
	}
	// Save
	public static void saveEmpleado(Empleado em) throws SQLException {
		String insertar = "INSERT INTO EMPLEADOS VALUES(?, ?) ON DUPLICATE KEY UPDATE NOMBRE = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);
				st.setString(1, em.getDniNif());
				st.setString(2, em.getNomrbe());
				
				st.setString(3, em.getNomrbe());
				
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
	}
	
	public static void saveProyecto(Proyecto p) throws SQLException {
		String insertar = "INSERT INTO PROYECTOS VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE NOMBRE = ?, DNI_NIF_JEFE_PROY = ?,"
				+ "F_INICIO = ?, F_FIN = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);

				st.setInt(1, p.getNumero());
				st.setString(2, p.getNombre());
				st.setString(3, p.getDniNifJefe());
				if (p.getInicio() == null) {
					st.setDate(4, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(4, p.getInicio());
				}
				st.setDate(5, p.getFin());
				
				st.setString(6, p.getNombre());
				st.setString(7, p.getDniNifJefe());
				if (p.getInicio() == null) {
					st.setDate(8, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(8, p.getInicio());
				}
				st.setDate(9, p.getFin());
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
	}
	
	public static void saveAsignacion(AsignacionProyecto as) throws SQLException {
		String insertar = "INSERT INTO ASIG_PROYECTOS VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE F_FIN = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root",
				"");) {
			try (PreparedStatement st = conn.prepareStatement(insertar);) {
				conn.setAutoCommit(false);

				st.setString(1, as.getDniEmpleado());
				st.setInt(2, as.getNumProyecto());
				if (as.getfInicio() == null) {
					st.setDate(3, Date.valueOf(LocalDate.now()));
				} else {
					st.setDate(3, as.getfInicio());
				}
				st.setDate(4, as.getfFin());
			
				st.setDate(5, as.getfFin());
				
				st.executeUpdate();
			} catch (SQLException sql) {
				try {
					conn.rollback();
				} catch (Exception e) {
					System.err.println("Error haciendo el ROLLBACK");
					e.printStackTrace(System.err);
				}
				throw new SQLException(sql);
			}
			conn.commit();
		}
	}

	public static void obtenerMetadatos() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados_proyectos", "root", "");
		String empleados = "SELECT * FROM EMPLEADOS";
		String proyectos = "SELECT * FROM PROYECTOS";
		String asignacion = "SELECT * FROM ASIG_PROYECTOS";
		try (PreparedStatement stEmp = conn.prepareStatement(empleados);
				PreparedStatement stPro = conn.prepareStatement(proyectos);
				PreparedStatement stAsi = conn.prepareStatement(asignacion)) {
			
			ResultSet rsEmp = stEmp.executeQuery();
			ResultSet rsPro = stPro.executeQuery();
			ResultSet rsAsi = stAsi.executeQuery();

			ResultSetMetaData mdEmp = rsEmp.getMetaData();
			int colEmp = mdEmp.getColumnCount();

			ResultSetMetaData mdPro = rsPro.getMetaData();
			int colPro = mdPro.getColumnCount();
			ResultSetMetaData mdAsi = rsAsi.getMetaData();
			int colAsi = mdAsi.getColumnCount();

			System.out.println("Tabla: " + mdEmp.getTableName(1));
			for (int i = 1; i <= colEmp; i++) {
				System.out.println("Columna: " + mdEmp.getColumnName(i) + "\nTipo de dato: " + mdEmp.getColumnTypeName(i));
				System.out.println("- - - - - - - - - -");
			}
			System.out.println();
			System.out.println("Tabla: " + mdPro.getTableName(1));
			for (int i = 1; i <= colPro; i++) {
				System.out.println("Columna: " + mdPro.getColumnName(i) + "\nTipo de dato: " + mdPro.getColumnTypeName(i));
				System.out.println("- - - - - - - - - -");
			}
			System.out.println();
			System.out.println("Tabla: " + mdAsi.getTableName(1));
			for (int i = 1; i <= colAsi; i++) {
				System.out.println("Columna: " + mdAsi.getColumnName(i) + "\nTipo de dato: " + mdAsi.getColumnTypeName(i));
				System.out.println("- - - - - - - - - -");
			}
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}

		conn.commit();
	}
	

	public static void main(String[] args) {
		try {
			// Sin objetos
			creaEmpleado("47227448R", "Pedro"); 
			creaProyecto(1, "Proyecto impresión", "47227448R", null, null);
			asignaEmpleadoProyecto("47227448R", 1, Date.valueOf("2022-10-20"), null);
			
			// Con objetos
			creaEmpleado(new Empleado("54399876S", "Juan"));
			creaProyecto(new Proyecto(2, "Proyecto reducción", "54399876S", null, null));
			asignaEmpleadoProyecto(new AsignacionProyecto("54399876S", 2, null, null));
			
			// Save -> Probar después de insertar los datos
//			saveEmpleado(new Empleado("47227448R", "Mario"));
//			saveProyecto(new Proyecto(1, "Proyecto impresión", "54399876S", Date.valueOf("2022-10-20"), null));
//			saveAsignacion(new AsignacionProyecto("47227448R", 1, Date.valueOf("2022-10-20"), Date.valueOf("2023-10-20")));
			
			
			// Metadatos
			obtenerMetadatos();
						
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}

}
