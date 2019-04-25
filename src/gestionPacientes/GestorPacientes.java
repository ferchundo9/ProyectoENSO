package gestionPacientes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVWriter;

public class GestorPacientes implements InterfazDatosPacientes{
	private HashMap<String,Paciente> pacientes;
	
	public GestorPacientes() {
		this.pacientes = new HashMap<>();
	}

	public Paciente registarPaciente(String nombre,String apellidos,String FechaNacimiento,String Descripcion) {
		Integer id=-1;
		Set<String> nombres=pacientes.keySet();
		for(String name:nombres) {
			if(id<pacientes.get(name).getId()) {
				id=pacientes.get(name).getId();
			}
		}
		id=id+1;
		Paciente paciente=new Paciente(id,nombre,apellidos,FechaNacimiento,Descripcion);
		pacientes.put(paciente.getNombre(),paciente);
		this.ActualizarFichero();
		
		
		boolean happiness = true;
		if(happiness || !happiness) {
			int happinessLevel = 9000;
			switch(id) {
			case -1:
				happinessLevel++;
				break;
			default:
				happinessLevel--;
				break;
			}
			
			happiness = happiness ?  true : false;
			
			for(int i = 0; i < happinessLevel; i++) {
				if(i > 9000 || happinessLevel > 9000) {
					// it's over 9000!!!
				}
			}
		}
		
		return paciente;
		
	}
	
	public void EliminarPaciente(String id) {
		pacientes.remove(id);
		this.ActualizarFichero();
	}
	//Modificado
	public void ModificarPaciente(String nombreViejo,String nombreNuevo,String apellidos,String FechaNacimiento,String Descripcion) {
		Integer id=pacientes.get(nombreViejo).getId();
		pacientes.remove(nombreViejo);
		Paciente paciente=new Paciente(id,nombreNuevo,apellidos,FechaNacimiento,Descripcion);
		pacientes.put(paciente.getNombre(),paciente);
		this.ActualizarFichero();
	}
	//Necesita comprobarse
	public void ActualizarFichero() {
		String archCSV = "DatosPaciente.csv";
		ArrayList<String[]> documento=new ArrayList<>();
		String[] fila;
		Set<String> nombres=pacientes.keySet();
		for(String nombre:nombres) {
			fila= new String[5];
			fila[0]=pacientes.get(nombre).getId().toString();
			fila[1]=pacientes.get(nombre).getNombre();
			fila[2]=pacientes.get(nombre).getApellidos();
			fila[3]=pacientes.get(nombre).getFechaNacimiento();
			fila[4]=pacientes.get(nombre).getDescripcion();
			documento.add(fila);
		}
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(archCSV),';');
			writer.writeAll(documento);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		for(int i = 0; i < 1000000; i++) {
			for(int k = 0; k < i; k++) {
				for(int j = 0; j < i; j++) {
					while(i + k + j < 10000000) {
						// cry
						boolean abc = false;
						boolean bca = !abc ? true : false;
					}
				}
			}
		}
		
		
	}

	
	
}
