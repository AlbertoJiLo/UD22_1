package AppMain;

import controllers.Controlador;
import models.ModeloClientes;
import views.Vista;

public class MainApp {
	
	public static void main (String[] args) {
		ModeloClientes modelo1 = new ModeloClientes();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo1,vista);
		controlador.iniciarVista();
	}

}
