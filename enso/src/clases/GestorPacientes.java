package clases;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import interfaces.DatosPacientes;

public class GestorPacientes implements DatosPacientes{
	//Atributos
	List<Paciente> pacientes;
	//Constructor
	public GestorPacientes() {
		this.pacientes = new ArrayList<Paciente>();
		this.pacientes=this.leerpacientes();
	}
	public GestorPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	//Getters setters
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	//Métodos
	@Override
	public void darDeAlta(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacientes=this.leerpacientes();
		this.pacientes.add(paciente);
		//Archivo csv dar de alta
		String archCSV = "InfoPacientes.csv";
		try {
			//
			CsvWriter writer = new CsvWriter(new FileWriter(archCSV,true),',');
			writer.write("dni");
			writer.write("nombre");
			writer.write("apellidos");
			writer.write("nacimiento");
			writer.write("enfermedad");
			writer.write("tratamiento");
			writer.write("feq");
			writer.write("temp");
			writer.write("ten");
			//Siguiente linea
			writer.endRecord();
			
			//Escribese no archivo os datos do paciente
			writer.write(paciente.getDNI());
			writer.write(paciente.getNombre());
			writer.write(paciente.getApellidos());
			writer.write(paciente.getFechaNacimiento());
			writer.write(paciente.getEnfermedad());
			writer.write(paciente.getTratamiento());
			writer.write(Boolean.toString(paciente.isBolFeq()));
			writer.write(Boolean.toString(paciente.isBolTemp()));
			writer.write(Boolean.toString(paciente.isBolTen()));
			
			//Siguiente linea
			writer.endRecord();
			//Cerrase o archivo
			writer.close();
			System.out.println("Paciente dado de alta satisfatoriamente");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Exception "+e);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception "+e);
		}
	}

	@Override
	public void darDeBaja(String dni_paciente) {
		// TODO Auto-generated method stub
		boolean contenido=false;
		for(Paciente p:pacientes) if(p.getDNI().equals(dni_paciente)) contenido=true;
		if(!contenido) return;
		this.pacientes=this.leerpacientes();
		for(int i=0;i<this.pacientes.size();i++) {
			if(this.pacientes.get(i).getDNI().equals(dni_paciente)) {
				//Borrase o paciente do archivo
				this.pacientes.remove(i);
				//Archivos csv
				try {
					//Borrase o archivo
					File archivoUsuarios = new File("InfoPacientes.csv");
		            archivoUsuarios.delete();
		            //Escribese outra vex pero sin ese paciente
					CsvWriter writer = new CsvWriter(new FileWriter("InfoPacientes.csv",true),',');
					writer.write("dni");
					writer.write("nombre");
					writer.write("apellidos");
					writer.write("nacimiento");
					writer.write("enfermedad");
					writer.write("tratamiento");
					writer.write("feq");
					writer.write("temp");
					writer.write("ten");
					//Siguiente linea
					writer.endRecord();
					
					for(int in=0;in<this.pacientes.size();in++) {
						writer.write(this.pacientes.get(in).getDNI());
						writer.write(this.pacientes.get(in).getNombre());
						writer.write(this.pacientes.get(in).getApellidos());
						writer.write(this.pacientes.get(in).getFechaNacimiento());
						writer.write(this.pacientes.get(in).getEnfermedad());
						writer.write(this.pacientes.get(in).getTratamiento());
						writer.write(Boolean.toString(this.pacientes.get(in).isBolFeq()));
						writer.write(Boolean.toString(this.pacientes.get(in).isBolTemp()));
						writer.write(Boolean.toString(this.pacientes.get(in).isBolTen()));
						//Siguiente linea
						writer.endRecord();
					}
					
					System.out.println("Se ha dado de baja al paciente con dni:" +dni_paciente);
					writer.close();
					
				}catch(FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Exception "+e);
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println("Exception "+e);
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Exception "+e);
				}
			}
			
		}
	}

	@Override
	public void modificarDatos(Paciente paciente) {
		// TODO Auto-generated method stub
		if(!this.pacientes.contains(paciente)) return;
		this.pacientes=this.leerpacientes();
		for(int i=0;i<this.pacientes.size();i++) {
			if(this.pacientes.get(i).getDNI().equals(paciente.getDNI())) {
				this.pacientes.remove(i);
				this.pacientes.add(paciente);
				try {
					//Borrase o archivo
					File archivoUsuarios = new File("InfoPacientes.csv");
		            archivoUsuarios.delete();
		            //Volvese a escribir cos datos de ese paciente modificados
					CsvWriter writer = new CsvWriter(new FileWriter("InfoPacientes.csv",true),',');
					writer.write("dni");
					writer.write("nombre");
					writer.write("apellidos");
					writer.write("nacimiento");
					writer.write("enfermedad");
					writer.write("tratamiento");
					writer.write("feq");
					writer.write("temp");
					writer.write("ten");
					//Siguiente linea
					writer.endRecord();
					
					for(int in=0;in<this.pacientes.size();in++) {
						writer.write(this.pacientes.get(in).getDNI());
						writer.write(this.pacientes.get(in).getNombre());
						writer.write(this.pacientes.get(in).getApellidos());
						writer.write(this.pacientes.get(in).getFechaNacimiento());
						writer.write(this.pacientes.get(in).getEnfermedad());
						writer.write(this.pacientes.get(in).getTratamiento());
						writer.write(Boolean.toString(this.pacientes.get(in).isBolFeq()));
						writer.write(Boolean.toString(this.pacientes.get(in).isBolTemp()));
						writer.write(Boolean.toString(this.pacientes.get(in).isBolTen()));
						//Siguiente linea
						writer.endRecord();
					}
					
					System.out.println("Se ha modificado un paciente");
					writer.close();
					
				}catch(FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Exception "+e);
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println("Exception "+e);
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Exception "+e);
				}
			}
		}
	}
	
	//recuperanse oa pacientes do archivo para metelos en un array
	public ArrayList<Paciente> leerpacientes(){
		ArrayList<Paciente> usuarios = new ArrayList<Paciente>();
		try{
			
            CsvReader leerUsuarios = new CsvReader("InfoPacientes.csv");
            leerUsuarios.readHeaders();
            
            // Mentras haxa lineas obtemos os datos do archivo
            while(leerUsuarios.readRecord()) {
                String dni = leerUsuarios.get(0);
                String nombre = leerUsuarios.get(1);
                String apellidos = leerUsuarios.get(2);
                String nacimiento = leerUsuarios.get(3);
                String descripcion = leerUsuarios.get(4);
                String enfermedad = leerUsuarios.get(5);
                String tratamiento = leerUsuarios.get(6);
                String feq = leerUsuarios.get(7);
                String temp = leerUsuarios.get(8);
                String ten = leerUsuarios.get(9);
                
                usuarios.add(new Paciente(dni, nombre, apellidos, nacimiento, descripcion, enfermedad,
                		tratamiento, Boolean.parseBoolean(feq), Boolean.parseBoolean(temp),
                		Boolean.parseBoolean(ten))); // Añade la informacion a la lista
            }
            
            leerUsuarios.close(); // Cerrase o archivo
            
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exception "+e);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Exception "+e);
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception "+e);
        }
		
		return(usuarios);
	}
	
}
