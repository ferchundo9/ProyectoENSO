package analisis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVWriter;

import sensorizacion.DatosVitales;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Analizador implements InterfazAlarmas,InterfazDatosInstantaneos,InterfazEstadisticas{
	private HashMap<String, Alarma> alarmas;
	private HashMap<String,Estadisticas> estadisticas;	// !FIXME PLEASE!!
	
	private Analizador() {
		this.alarmas =new HashMap<>();
		this.estadisticas=new HashMap<>();
	}
	
	public void GuardarEstadisticas() {
		String archCSV = "";
		ArrayList<String[]> documento=new ArrayList<>();
		String[] fila;
		Set<String> ids=estadisticas.keySet();
		for(String id:ids) {
			fila= new String[8];
			fila[0]=id;
			fila[1]=estadisticas.get(id).getMaximo();
			fila[2]=estadisticas.get(id).getMinimo();
			fila[3]=estadisticas.get(id).getMedia();
			fila[4]=estadisticas.get(id).getAlarmasFC();
			fila[5]=estadisticas.get(id).getAlarmasTem();
			fila[6]=estadisticas.get(id).getTensionAlarmaFC();
			fila[7]=estadisticas.get(id).getTensionAlarmaTem();
			documento.add(fila);
		}
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(archCSV),';');
			writer.writeAll(documento);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void CrearAlarma(String name) {
		Alarma alarma=new Alarma(name);
		alarmas.put(alarma.getNombre(),alarma);
	}
	
	public void EliminarAlarma(String name) {
		alarmas.remove(name);
	}
	public void generarEstadisticas() {
		throw new NotImplementedException();////////////////////////////////////////
	}
	
	public void recuperarEstadisticas() {
		throw new NotImplementedException();//////////////////////////////////////////
	}

	@Override
	public HashMap<String, Alarma> recibirAlarmas() {
		return new HashMap<>(alarmas);
	}

	@Override
	public void EnviarDatosInstantaneos(HashMap<String, DatosVitales> datos) {
		throw new NotImplementedException();///////////////////////////////
	}

	@Override
	public HashMap<String,Estadisticas> recibirEstadisticas() {
		// TODO Auto-generated method stub
		return new HashMap<>(estadisticas);
	}

	
}
