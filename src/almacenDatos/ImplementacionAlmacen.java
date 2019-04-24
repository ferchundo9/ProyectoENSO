package almacenDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.opencsv.CSVWriter;

import analisis.InterfazDatosInstantaneos;
import sensorizacion.DatosVitales;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ImplementacionAlmacen implements InterfazDatosSimulados{
	private ArrayList<HashMap<String,DatosVitales>> datos;
	private ArrayList<Date> fechas;
	private InterfazDatosInstantaneos interfazdatosinstantaneos;
	public ImplementacionAlmacen() {
		this.datos=new ArrayList<HashMap<String,DatosVitales>>();
		this.fechas=new ArrayList<>();
	}
	//Necesita revisarse
	public void Guardar(HashMap<String, DatosVitales> datos) {
		String archCSV = "";
		ArrayList<String[]> documento=new ArrayList<>();
		String[] fila;
		Set<String> ids=datos.keySet();
		Date fecha=new Date();
		for(String id:ids) {
			fila= new String[4];
			fila[0]=id;
			fila[1]=datos.get(id).getFC().toString();
			fila[2]=datos.get(id).getTemperatura().toString();
			fila[3]=fecha.toString();
			documento.add(fila);
		}
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(archCSV),';');
			writer.writeAll(documento);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void EnviarDatos(HashMap<String, DatosVitales> datos) {//Metodo que recibe los datos de los sensores
		this.datos.add(datos);
		fechas.add(new Date());
		
	}
	
	public void EntregarDatos(Date fechaInicio, Date fechaFin) {
		throw new NotImplementedException();
	}
	
	public void EnviarDatosInstantaneos(HashMap<String, DatosVitales> datos) {
		interfazdatosinstantaneos.EnviarDatosInstantaneos(datos);
	}
	
}
