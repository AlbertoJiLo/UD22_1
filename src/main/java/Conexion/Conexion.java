package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import models.Modelo;

public class Conexion {

	private Connection conexion;

	// Método para establecer conexión

	public void establecerCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// conexion =
			// DriverManager.getConnection("jdbc:mysql://192.168.1.38:3306?useTimezone=true&serverTimezone=UTC",
			// "alberto","Z001349ebeadr@");
			conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.172:3306?useTimezone=true&serverTimezone=UTC", "remote", "Kappa323232!");
			System.out.println(" Server connected ");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			ex.printStackTrace();
			System.out.println(ex);
		}
	}

	// Método para cerrar la conexión

	public void cerrarCon() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el server");
		} catch (SQLException ex) {
			Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Método que elimina las bases de datos que les introducimos en caso de existir
	// y crea una con dicho nombre

	public void crearDB() {
		try {
			String Query = "DROP DATABASE IF EXISTS clientes;";
			String Query2 = "CREATE DATABASE clientes;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			st.executeUpdate(Query2);
			System.out.println(" Server connected ");
		} catch (SQLException ex) {
			System.out.println("No se ha podido conectar con la base de datos o ya existe");
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

		}

	}

	public void borrarTabla(int id) {
		try {
			System.out.println(" ID  :" + id);
			String Querydb = "USE clientes;";
			String Query = "DELETE FROM cliente WHERE id = " + id + " ;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void crearUsuario(String nombre, String apellido, String direccion, int dni, String fecha) {
		try {
			System.out.println(" ID  :" + nombre);
			String Querydb = "USE clientes;";
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
}
