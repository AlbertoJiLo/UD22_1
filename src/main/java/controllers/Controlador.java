package controllers;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Conexion.ConexionClientes;
import models.ModeloClientes;
import views.Vista;

public class Controlador implements ActionListener, WindowListener {

	private ModeloClientes modeloClientes;
	private Vista vista;
	private ConexionClientes conexionClientes;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;

	// Constructor

	public Controlador(ModeloClientes modelo1, Vista vista) {
		this.modeloClientes = modelo1;
		this.vista = vista;
		this.vista.botonDelete.addActionListener(this);
		this.vista.botonCreate.addActionListener(this);
		this.vista.botonUpdate.addActionListener(this);
		this.vista.botonRead.addActionListener(this);
		this.conexionClientes = new ConexionClientes();

	}

	// Método para cerrar la conexión al cerrar la ventana.

	@Override
	public void windowClosed(WindowEvent e) {
		conexionClientes.cerrarCon();
	}

	// Método para manejar todos los eventos de los botones.

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (vista.botonDelete == evento.getSource()) {
			borrarUser();
		} else if (vista.botonCreate == evento.getSource()) {
			addUser();
		} else if (vista.botonRead == evento.getSource()) {
			readUser();
		} else if (vista.botonUpdate == evento.getSource()) {
			updateUser();
		}
	}

	// Método para añadir una fila a una tabla con los datos

	public void addUser() {
		try {
		nombre = vista.textNombreCliente.getText();
		apellido = vista.textApellidoCliente.getText();
		direccion = vista.textDireccionCliente.getText();
		dni = Integer.parseInt(vista.textDniCliente.getText());
		fecha = vista.textFechaCliente.getText();
		modeloClientes = new ModeloClientes(nombre, apellido, direccion, dni, fecha);
		modeloClientes.createUser();
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"No se han podido introducir los datos. Asegurate de que tienen un formato correcto"
							+ "\nRecuerda que DNI son solo números y el formato de la fecha es year-month-day");
		}
	}

	// Método para añadir borrar la fila de una tabla.

	public void borrarUser() {
		try {
		id = Integer.parseInt(vista.textIdCliente.getText());
		modeloClientes = new ModeloClientes(id);
		modeloClientes.borrarUsuario();
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"ID vacia");
		}
	}

	// Método para seleccionar los campos de una fila y rellenar visualmente los de
	// la interfaz a partir de la id.

	public void readUser() {
		try {
		id = Integer.parseInt(vista.textIdCliente.getText());
		modeloClientes = new ModeloClientes(id, nombre, apellido, direccion, dni, fecha);
		String datos = modeloClientes.readUsuario();
		System.out.println(datos);
			if (datos != "") {
				String[] partes = datos.split("__");
				String id = partes[0];
				vista.textIdCliente.setText(id);
				String nombre = partes[1];
				vista.textNombreCliente.setText(nombre);
				String apellido = partes[2];
				vista.textApellidoCliente.setText(apellido);
				String direccion = partes[3];
				vista.textDireccionCliente.setText(direccion);
				String dni = partes[4];
				vista.textDniCliente.setText(dni);
				String fecha = partes[5];
				vista.textFechaCliente.setText(fecha);
			} else {
				JOptionPane.showMessageDialog(null, "ID no encontrada");
			}
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"ID vacia");
		}

	}

	// Método para modificar una fila de datos. Necesaria la id.

	public void updateUser() {
		try {
			id = Integer.parseInt(vista.textIdCliente.getText());
			nombre = vista.textNombreCliente.getText();
			apellido = vista.textApellidoCliente.getText();
			direccion = vista.textDireccionCliente.getText();
			dni = Integer.parseInt(vista.textDniCliente.getText());
			fecha = vista.textFechaCliente.getText();
			modeloClientes = new ModeloClientes(id, nombre, apellido, direccion, dni, fecha);
			modeloClientes.editarUsuario();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"No se han podido modificar los datos. Asegurate de que tienen un formato correcto"
							+ "\nRecuerda que DNI son solo números y el formato de la fecha es year-month-day");
		}
	}

	// Método para cerrar la conexión.

	public void cerrarCon() {
		conexionClientes.cerrarCon();
	}

	// Método para iniciar la interfaz gráfica, la conexión, la BBDD y la tablas iniciales.

	public void iniciarVista() {
		conexionClientes.establecerCon();
		conexionClientes.crearDB();
		conexionClientes.crearTabla();
		vista.setTitle("Ejercicio 1");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}

	// Métodos para realizar acciones en caso de interactuar con la ventana de
	// distintas maneras.

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}