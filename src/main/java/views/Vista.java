package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextField textId;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textDireccion;
	public JTextField textDni;
	public JTextField textFecha;
	public JButton botonCreate;
	public JButton botonUpdate;
	public JButton botonDelete;
	public JButton botonRead;

	
	public Vista() {
		setTitle("CRUD Ejercicio 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonCreate = new JButton("Create");
		botonCreate.setBounds(28, 32, 85, 21);
		contentPane.add(botonCreate);
		
		botonUpdate = new JButton("Update");
		botonUpdate.setBounds(28, 75, 85, 21);
		contentPane.add(botonUpdate);
		
		botonDelete = new JButton("Delete");
		botonDelete.setBounds(28, 122, 85, 21);
		contentPane.add(botonDelete);
		
		botonRead = new JButton("Read");
		botonRead.setBounds(28, 165, 85, 21);
		contentPane.add(botonRead);
		
		textId = new JTextField();
		textId.setBounds(142, 33, 257, 19);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(142, 62, 257, 19);
		contentPane.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(142, 91, 257, 19);
		contentPane.add(textApellido);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(142, 123, 257, 19);
		contentPane.add(textDireccion);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(142, 152, 257, 19);
		contentPane.add(textDni);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(142, 181, 257, 19);
		contentPane.add(textFecha);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(407, 36, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(407, 65, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setBounds(407, 94, 45, 13);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("direccion");
		lblDireccion.setBounds(407, 126, 45, 13);
		contentPane.add(lblDireccion);
		
		JLabel lblDni = new JLabel("dni");
		lblDni.setBounds(409, 155, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setBounds(409, 184, 45, 13);
		contentPane.add(lblFecha);
		

	}
}
