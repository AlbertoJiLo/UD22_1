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
	private String dni;
	private String fecha;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.botonDelete.addActionListener(this);
		this.conexion = new Conexion();
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(vista.botonDelete == evento.getSource()) {
			borrarUser();
		}else if(vista.botonCreate== evento.getSource()) {
			
		}
	}
	
	public void addUser() {
		id = Integer.parseInt(vista.textId.getText());
		nombre = vista.textNombre.getText();
		apellido = vista.textApellido.getText();
		direccion = vista.textDireccion.getText();
		dni = vista.textDni.getText();
		fecha = vista.textFecha.getText();
		conexion.establecerCon();
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
