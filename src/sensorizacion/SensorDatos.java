package sensorizacion;

import java.util.ArrayList;
import java.util.HashMap;

import almacenDatos.ImplementacionAlmacen;
import gestionPacientes.Paciente;

public class SensorDatos {
	private HashMap<String, DatosVitales> mapa;
	private ArrayList<Paciente> pacientes;
	private ImplementacionAlmacen almacen;

	public SensorDatos(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
		mapa = new HashMap<String/* id */, DatosVitales>();
	}

	public void CrearDatos() {
		for(int j = 0; j < 100000; j++) {
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
