package sensorizacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import almacenDatos.ImplementacionAlmacen;
import almacenDatos.InterfazDatosSimulados;
import gestionPacientes.Paciente;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SensorDatos{
	private HashMap<String, DatosVitales> mapa;
	private ArrayList<Paciente> pacientes;
	private ImplementacionAlmacen almacen;
	
	public SensorDatos(ArrayList<Paciente> pacientes) {
		this.pacientes=pacientes;
		mapa=new HashMap<String/*id*/, DatosVitales>();
	}
	
	public void CrearDatos() {
		throw new NotImplementedException();
	}
	
	public void EnviarDatos() {
		almacen.EnviarDatos(mapa);
	}
}
