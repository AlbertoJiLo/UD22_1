package models;

import Conexion.Conexion;

public class Modelo {

	private Conexion conexion;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int DNI;
	private String fecha;
	
	
	
	
	public Modelo() {

	}



	public Modelo(String nombre, String apellido, String direccion, int dNI, String fecha) {
		this.conexion =  new Conexion();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.DNI = dNI;
		this.fecha = fecha;
	}



	public void createUser() {
		conexion.establecerCon();
		conexion.crearUsuario(nombre, apellido, direccion, DNI, fecha);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
