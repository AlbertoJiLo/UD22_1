package views;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextField textIdCliente;
	public JTextField textNombreCliente;
	public JTextField textApellidoCliente;
	public JTextField textDireccionCliente;
	public JTextField textDniCliente;
	public JTextField textFechaCliente;
	public JButton botonCreate;
	public JButton botonUpdate;
	public JButton botonDelete;
	public JButton botonRead;


	
	public Vista() {
		setTitle("CRUD Ejercicio 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonCreate = new JButton("Create");
		botonCreate.setBounds(21, 31, 85, 21);
		contentPane.add(botonCreate);
		
		botonUpdate = new JButton("Update");
		botonUpdate.setBounds(21, 74, 85, 21);
		contentPane.add(botonUpdate);
		
		botonDelete = new JButton("Delete");
		botonDelete.setBounds(21, 121, 85, 21);
		contentPane.add(botonDelete);
		
		botonRead = new JButton("Read");
		botonRead.setBounds(21, 164, 85, 21);
		contentPane.add(botonRead);
		
		textIdCliente = new JTextField();
		textIdCliente.setBounds(135, 32, 177, 19);
		contentPane.add(textIdCliente);
		textIdCliente.setColumns(10);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setColumns(10);
		textNombreCliente.setBounds(135, 61, 177, 19);
		contentPane.add(textNombreCliente);
		
		textApellidoCliente = new JTextField();
		textApellidoCliente.setColumns(10);
		textApellidoCliente.setBounds(135, 90, 177, 19);
		contentPane.add(textApellidoCliente);
		
		textDireccionCliente = new JTextField();
		textDireccionCliente.setColumns(10);
		textDireccionCliente.setBounds(135, 122, 177, 19);
		contentPane.add(textDireccionCliente);
		
		textDniCliente = new JTextField();
		textDniCliente.setColumns(10);
		textDniCliente.setBounds(135, 151, 177, 19);
		contentPane.add(textDniCliente);
		
		textFechaCliente = new JTextField();
		textFechaCliente.setColumns(10);
		textFechaCliente.setBounds(135, 180, 177, 19);
		contentPane.add(textFechaCliente);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(322, 38, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(322, 67, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setBounds(322, 96, 57, 13);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("direccion");
		lblDireccion.setBounds(322, 128, 57, 13);
		contentPane.add(lblDireccion);
		
		JLabel lblDni = new JLabel("dni");
		lblDni.setBounds(324, 157, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setBounds(324, 186, 45, 13);
		contentPane.add(lblFecha);
		
		

	}
}
