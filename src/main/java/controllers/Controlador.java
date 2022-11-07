package controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Conexion.Conexion;
import models.Modelo;
import views.Vista;

public class Controlador implements ActionListener{
	
	private Modelo modelo;
	private Vista vista;
	private Conexion conexion;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.botonDelete.addActionListener(this);
		this.vista.botonCreate.addActionListener(this);
		this.vista.botonDelete.addActionListener(this);
		this.vista.botonRead.addActionListener(this);
		this.conexion = new Conexion();
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(vista.botonDelete == evento.getSource()) {
			borrarUser();
		}else if(vista.botonCreate== evento.getSource()) {
			addUser();
		}else if(vista.botonRead== evento.getSource()) {
			addUser();
		}
	}
	
	public void addUser() {
		nombre = vista.textNombre.getText();
		apellido = vista.textApellido.getText();
		direccion = vista.textDireccion.getText();
		dni = Integer.parseInt(vista.textDni.getText());
		fecha = vista.textFecha.getText();
		modelo = new Modelo(nombre, apellido, direccion, dni, fecha);
		modelo.createUser();
	}
	
	
	public void borrarUser() {
		id = Integer.parseInt(vista.textId.getText());
		conexion.borrarTabla(id);
	}
	
	public void cerrarCon() {
		conexion.cerrarCon();
	}
	
	public void iniciarVista() {
		conexion.establecerCon();
		conexion.crearDB();
		conexion.crearTabla();
		vista.setTitle("Conversor");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		 
	}

}
