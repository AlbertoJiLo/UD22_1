package Conexion;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ModeloClientes;

public class ConexionClientes {

	private Connection conexion;

	// Método para establecer conexión

	public void establecerCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.38:3306?useTimezone=true&serverTimezone=UTC",
			"alberto","Z001349ebeadr@");
			System.out.println(" Server connected ");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Hubo un error al conectar con el servidor");
		}
	}

	// Método para cerrar la conexión

	public void cerrarCon() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el server");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloClientes.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Método que elimina las bases de datos que les introducimos en caso de existir
	// y crea una con dicho nombre

	public void crearDB() {
		try {
			String Query = "CREATE DATABASE clientes;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println(" Server connected ");
		} catch (SQLException ex) {
			
			System.out.println(ex);
			System.out.println("No se ha podido conectar crear la BBDD o ya existe");
			
		}

	}

	// Método para crear las tablas

	public void crearTabla() {

		try {

			String Querydb = "USE clientes;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE cliente (\r\n" + "id int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "nombre varchar(250) DEFAULT NULL,\r\n" + "apellido varchar(250) DEFAULT NULL,\r\n"
					+ "direccion varchar(250) DEFAULT NULL,\r\n" + "dni int(11) DEFAULT NULL,\r\n"
					+ "fecha date DEFAULT NULL,\r\n" + "PRIMARY KEY (id)\r\n" + ");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla cliente creada correctamente");

		} catch (Exception ex) {

			System.out.println(ex);
			System.out.println("No se ha podido crear la tabla o ya existe");

		}

	}
	
	//Método para hacer DELETE y poder borrar una fila de la tabla cliente dependiendo de la id que le pasamos.
	
	public void borrarTabla(int id) {
        try {
            String Querydb = "USE clientes";
            String Query = "DELETE FROM cliente "
                    + " WHERE id = '" + id + "'; ";
            System.out.println(Query);
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);
            stdb.executeUpdate(Query);
 
        }catch (Exception ex) {
        	System.out.println(ex);
        } 
    }
	
	//Método para hacer INSERTS en la tabla cliente.
	
	public void crearUsuario(String nombre, String apellido, String direccion, int dni, String fecha) {
		try {
            String Querydb = "USE clientes";
			String Query = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES ('" + nombre + "','"
					+ apellido + "','" + direccion + "','" + dni + "','" + fecha + "');";
			System.out.println(Query);
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	//Método para hacer UPDATE de una fila de la tabla cliente.
	
	public void editarUsuario(int id, String nombre, String apellido, String direccion, int dni, String fecha) {
        try {
            String Querydb = "USE clientes";
            String Query = "UPDATE cliente SET nombre = '" + nombre + "', apellido =  '" + apellido + "', direccion = '" + direccion + "', dni =  '" + dni + "', fecha = '" + fecha + "'"
                    + "WHERE id = '" + id + "'; ";
            System.out.println(Query);
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);
            stdb.executeUpdate(Query);
        }catch (Exception ex) {
        	System.out.println(ex);
        }
    }

	//Método para rellenar los campos con los valores de una fila en la tabla cliente.
	
	public String leerUsuario(int id) {
		String datos="";
		try {
            String Querydb = "USE clientes";
			String Query = "SELECT * FROM cliente WHERE id ='"+id+"'";
			Statement stmt = conexion.createStatement(
				      ResultSet.TYPE_FORWARD_ONLY,
				      ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(Querydb);			
			ResultSet rs = stmt.executeQuery(Query);
			if(rs.getFetchSize() == 0) {
				while(rs.next()) {
					int id1 = rs.getInt("id");
					String nombre1 = rs.getString("nombre");
					String apellido1 = rs.getString("apellido");
					String direccion1 = rs.getString("direccion");
					int dni1 = rs.getInt("dni");
					String fecha1 = rs.getString("fecha");
					datos=id1+"__"+nombre1+"__"+apellido1+"__"+direccion1+"__"+dni1+"__"+fecha1;
				}
			}
			else {
				throw new Exception("No existe ningun registro con esa id");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return datos;
	}
}
