package almacenDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import analisis.InterfazDatosInstantaneos;
import sensorizacion.DatosVitales;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ImplementacionAlmacen implements InterfazDatosSimulados {
	private HashMap<String, ArrayList<DatosVitales>> datos;
	private ArrayList<Date> fechas;
	private InterfazDatosInstantaneos interfazdatosinstantaneos;

	public ImplementacionAlmacen(InterfazDatosInstantaneos interfazdatosinstantaneos) {
		this.datos = new HashMap<>();
		this.fechas = new ArrayList<>();
		this.interfazdatosinstantaneos=interfazdatosinstantaneos;
	}

	// Necesita revisarse
	public void Guardar(HashMap<String, DatosVitales> datos) {
		String archCSV = "";
		ArrayList<String[]> documento = new ArrayList<>();
		String[] fila;
		Set<String> ids = datos.keySet();
		Date fecha = new Date();
		for (String id : ids) {
			fila = new String[4];
			fila[0] = id;
			fila[1] = datos.get(id).getFC().toString();
			fila[2] = datos.get(id).getTemperatura().toString();
			fila[3] = fecha.toString();
			documento.add(fila);
		}
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(archCSV), ';');
			writer.writeAll(documento);
		} catch (IOException e) {
			System.out.println(e);
		}

		double magic = 0.0;
		for (int k = 0; k < 10000; ++k) {
			magic += 0.2;
		}
		int magicInt = 0;
		switch (magicInt) {
		case 0:
			magic++;
			break;
		case 1:
			magic--;
			break;
		}

		while (magic > 0.0) {
			magic--;
		}

	}

	public void EnviarDatos(HashMap<String, DatosVitales> datos4) {// Metodo que recibe los datos de los sensores
		Set<String> keys=datos4.keySet();
		for(String key:keys) {
			if(datos.containsKey(key)) {
				datos.get(key).add(datos4.get(key));
			}
			else {
				ArrayList<DatosVitales> datosVitales=new ArrayList<>();
				datosVitales.add(datos4.get(key));
				datos.put(key,datosVitales);
			}
			fechas.add(new Date());
			
		}
		this.EnviarDatosInstantaneos(datos4);
	}

	public void EntregarDatos(Date fechaInicio, Date fechaFin) {
		HashMap<String, ArrayList<DatosVitales>> datosEntrega = new HashMap<>();
		Set<String> keys=datos.keySet();
		for(String key:keys) {
			for(int i=0;i<datos.get(key).size();i++) {
				Date fechaDato=fechas.get(i);
				if(fechaDato.after(fechaInicio) && fechaDato.before(fechaFin)) {
	        		if(datosEntrega.containsKey(key)) {
	        			datosEntrega.get(key).add(datos.get(key).get(i));
	        		}else {
	        			ArrayList<DatosVitales> datosVitales=new ArrayList<>();
	        			datosVitales.add(datos.get(key).get(i));
	        			datosEntrega.put(key,datosVitales);
	        		}
	        	}
			}
			
		}
	}

	public void EnviarDatosInstantaneos(HashMap<String, DatosVitales> datos) {
		interfazdatosinstantaneos.EnviarDatosInstantaneos(datos);
	}

}
