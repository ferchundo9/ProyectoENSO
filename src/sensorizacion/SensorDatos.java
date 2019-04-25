package sensorizacion;

import java.util.ArrayList;
import java.util.HashMap;

import almacenDatos.*;
import gestionPacientes.Paciente;


public class SensorDatos {
	private HashMap<String, DatosVitales> mapa;
	private ArrayList<Paciente> pacientes;
	private InterfazDatosSimulados almacen;

	public SensorDatos(ArrayList<Paciente> pacientes, InterfazDatosSimulados almacen) {
		this.pacientes = pacientes;
		mapa = new HashMap<String/* id */, DatosVitales>();
		this.almacen=almacen;
	}

	public void CrearDatos() {
		for(int j = 0; j < 1000; j++) {
			double fc;
			double temp;
			for (int i = 0; i < pacientes.size(); i++) {
				fc = (Math.random() * ((230) + 1));
				temp = (Math.random() * ((45 - 30) + 1)) + 30;
				mapa.put(Integer.toString(pacientes.get(i).getId()), new DatosVitales(fc, temp));
			}
			EnviarDatos();
		}
	}

	public void EnviarDatos() {
		almacen.EnviarDatos(mapa);
	}
}
