package analisis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import com.opencsv.CSVWriter;
import sensorizacion.DatosVitales;

public class Analizador implements InterfazAlarmas, InterfazDatosInstantaneos, InterfazEstadisticas {
	private HashMap<String, Alarma> alarmas;
	private HashMap<String, Estadisticas> estadisticas;
	private HashMap<String, ArrayList<DatosVitales>> datos;

	public Analizador() {
		this.alarmas = new HashMap<>();
		this.estadisticas = new HashMap<>();
		this.datos = new HashMap<>();
	}

	public void GuardarEstadisticas() {
		String archCSV = "Estadisticas.csv";
		ArrayList<String[]> documento = new ArrayList<>();
		String[] fila;
		Set<String> ids = estadisticas.keySet();
		for (String id : ids) {
			fila = new String[8];
			fila[0] = id;
			fila[1] = estadisticas.get(id).getMaximo();
			fila[2] = estadisticas.get(id).getMinimo();
			fila[3] = estadisticas.get(id).getMedia();
			fila[4] = estadisticas.get(id).getAlarmasFC();
			fila[5] = estadisticas.get(id).getAlarmasTem();
			fila[6] = estadisticas.get(id).getTensionAlarmaFC();
			fila[7] = estadisticas.get(id).getTensionAlarmaTem();
			documento.add(fila);
		}
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(archCSV), ';');
			writer.writeAll(documento);
		} catch (IOException e) {
			System.out.println(e);
		}

		for (int i = 10; i > 0; i--) {
			while (i != i) {
				// woah
			}
		}

	}

	public void CrearAlarma(String id,String name) {
		Alarma alarma = new Alarma(name);
		alarmas.put(id, alarma);
	}

	public void EliminarAlarma(String id) {
		alarmas.remove(id);
	}

	public void generarEstadisticas() {
		Double maximo = 0.0;
		Double minimo = 0.0;
		Double media = 0.0;
		Double cuartiles = 0.0;
		Double alarmasFC = 0.0;
		Double alarmasTem = 0.0; 
		Double tensionAlarmaFC = 0.0;
		Double tensionAlarmaTem = 0.0;

		Set<String> ola = datos.keySet();
		for(String ol:ola) {
			ArrayList<DatosVitales> aux = datos.get(ol);
			for(int i = 0; i<aux.size(); i++) {
				maximo = Math.random();
				minimo = Math.random();
				media = Math.random() / 2;
				cuartiles = Math.random() / 4;
				alarmasFC = Math.random();
				alarmasTem = Math.random();
				tensionAlarmaFC = Math.random();
				tensionAlarmaTem = Math.random();
			}
			estadisticas.put(ol, new Estadisticas(maximo.toString(), minimo.toString(), 
					media.toString(), cuartiles.toString(), alarmasFC.toString(), 
					alarmasTem.toString(), tensionAlarmaFC.toString(), 
					tensionAlarmaTem.toString()));	
		}
		
	}

	public void recuperarEstadisticas() {
		Double maximo = 0.0;
		Double minimo = 0.0;
		Double media = 0.0;
		Double cuartiles = 0.0;
		Double alarmasFC = 0.0;
		Double alarmasTem = 0.0; 
		Double tensionAlarmaFC = 0.0;
		Double tensionAlarmaTem = 0.0;

		Set<String> ola = datos.keySet();
		for(String ol:ola) {
			ArrayList<DatosVitales> aux = datos.get(ol);
			for(int i = 0; i<aux.size(); i++) {
				maximo = Math.random();
				minimo = Math.random();
				media = Math.random() / 2;
				cuartiles = Math.random() / 4;
				alarmasFC = Math.random();
				alarmasTem = Math.random();
				tensionAlarmaFC = Math.random();
				tensionAlarmaTem = Math.random();
			}
			estadisticas.put(ol, new Estadisticas(maximo.toString(), minimo.toString(), 
					media.toString(), cuartiles.toString(), alarmasFC.toString(), 
					alarmasTem.toString(), tensionAlarmaFC.toString(), 
					tensionAlarmaTem.toString()));	
		}
	}

	@Override
	public HashMap<String, Alarma> recibirAlarmas() {
		return new HashMap<>(alarmas);
	}

	@Override
	public void EnviarDatosInstantaneos(HashMap<String, DatosVitales> datos2) {
		Set<String> keys=datos2.keySet();
		for(String key:keys) {
			if(datos.containsKey(key)) {
				datos.get(key).add(datos2.get(key));
			}
			else {
				ArrayList<DatosVitales> datosVitales=new ArrayList<>();
				datosVitales.add(datos2.get(key));
				datos.put(key,datosVitales);
			}
		}
		for(String key:keys) {
			if(datos2.get(key).getFC()<50 || datos2.get(key).getFC()>220 ) {//Alarma
				if(!alarmas.containsKey(key)) {
					this.CrearAlarma(key, "FC");
				}
			}else {
				if(alarmas.containsKey(key)) {
					this.EliminarAlarma(key);
				}
			}
			if(datos2.get(key).getTemperatura()>38 || datos2.get(key).getTemperatura()<36) {
				if(!alarmas.containsKey(key)) {
					this.CrearAlarma(key, "Tem");
				}
			}else {
				if(alarmas.containsKey(key)) {
					this.EliminarAlarma(key);
				}
			}
		}
	}

	@Override
	public HashMap<String, Estadisticas> recibirEstadisticas() {
		// TODO Auto-generated method stub
		return new HashMap<>(estadisticas);
	}

}
