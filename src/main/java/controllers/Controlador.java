package controllers;

import java.awt.EventQueue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Conexion.ConexionClientes;
import models.ModeloClientes;
import views.Vista;

public class Controlador implements ActionListener{
	
	private ModeloClientes modeloClientes;
	private Vista vista;
	private ConexionClientes conexionClientes;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;


	public Controlador(ModeloClientes modelo1, Vista vista) {
		this.modeloClientes = modelo1;
		this.vista = vista;
		this.vista.botonDelete.addActionListener(this);
		this.vista.botonCreate.addActionListener(this);
		this.vista.botonUpdate.addActionListener(this);
		this.vista.botonRead.addActionListener(this);
		this.conexionClientes = new ConexionClientes();
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(vista.botonDelete == evento.getSource()) {
			borrarUser();
		}else if(vista.botonCreate== evento.getSource()) {
			addUser();
		}else if(vista.botonRead== evento.getSource()) {
			readUser();
		}else if(vista.botonUpdate == evento.getSource()) {
			updateUser();
		}
	}
	
	public void addUser() {
			nombre = vista.textNombreCliente.getText();
			apellido = vista.textApellidoCliente.getText();
			direccion = vista.textDireccionCliente.getText();
			dni = Integer.parseInt(vista.textDniCliente.getText());
			fecha = vista.textFechaCliente.getText();
			modeloClientes = new ModeloClientes(nombre, apellido, direccion, dni, fecha);
			modeloClientes.createUser();
	}
	
	
	public void borrarUser() {
			id = Integer.parseInt(vista.textIdCliente.getText());
			modeloClientes = new ModeloClientes(id);
			modeloClientes.borrarUsuario();
	}
	
	public void readUser() {
			id = Integer.parseInt(vista.textIdCliente.getText());
			modeloClientes = new ModeloClientes(id,nombre, apellido, direccion, dni, fecha);
			String datos = modeloClientes.readUsuario();
			System.out.println(datos);
			String[] partes = datos.split("__");
			String id = partes[0];
			vista.textIdCliente.setText(id);
			String nombre = partes[1];
			vista.textNombreCliente.setText(nombre);
			String apellido = partes[2];
			vista.textApellidoCliente.setText(apellido);
			String direccion= partes[3];
			vista.textDireccionCliente.setText(direccion);
			String dni = partes[4];
			vista.textDniCliente.setText(dni);
			String fecha = partes[5];
			vista.textFechaCliente.setText(fecha);
	}
	
	public void updateUser() {
		id = Integer.parseInt(vista.textIdCliente.getText());
		nombre = vista.textNombreCliente.getText();
		apellido = vista.textApellidoCliente.getText();
		direccion = vista.textDireccionCliente.getText();
		dni = Integer.parseInt(vista.textDniCliente.getText());
		fecha = vista.textFechaCliente.getText();
		modeloClientes = new ModeloClientes(id,nombre, apellido, direccion, dni, fecha);
		modeloClientes.editarUsuario();
	}
	
	public void cerrarCon() {
		conexionClientes.cerrarCon();
	}
	
	public void iniciarVista() {
		conexionClientes.establecerCon();
		conexionClientes.crearDB();
		conexionClientes.crearTabla();
		vista.setTitle("Conversor");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		 
	}

}
