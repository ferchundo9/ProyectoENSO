package clases;

import java.util.ArrayList;
import java.util.List;

import interfaces.DatosPacientes;

//Paciente
public class Paciente {
	//Atributos
	String DNI;
	String Nombre;
	String Apellidos;
	String FechaNacimiento;
	String Descripcion;
	String enfermedad;
	String tratamiento;
	boolean bolFeq;
	boolean bolTemp;
	boolean bolTen;
	ArrayList<Sensores> sensores;
	ArrayList<DatosPaciente> datospacientes;
	//Constructores
	public Paciente() {
		this.DNI = new String();
		this.Nombre = new String();
		this.Apellidos = new String();
		this.FechaNacimiento = new String();
		this.Descripcion = new String();
		this. enfermedad=new String();
		this.tratamiento=new String();
		this.bolFeq = false;
		this.bolTemp = false;
		this.bolTen = false;
		this.sensores = new ArrayList<Sensores>();
		this.datospacientes = new ArrayList<DatosPaciente>();
	}
	public Paciente(String dNI, String nombre, String apellidos, String fechaNacimiento, String descripcion,
			String enfermedad,String tratamiento,boolean bolFeq, boolean bolTemp, boolean bolTen) {
		this.DNI = dNI;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.FechaNacimiento = fechaNacimiento;
		this.Descripcion = descripcion;
		this.enfermedad=enfermedad;
		this.tratamiento=tratamiento;
		this.bolFeq = bolFeq;
		this.bolTemp = bolTemp;
		this.bolTen = bolTen;
		this.sensores = new ArrayList<Sensores>();
		this.datospacientes = new ArrayList<DatosPaciente>();
	}
	public Paciente(String dNI, String nombre, String apellidos, String fechaNacimiento, String descripcion,
			String enfermedad,String tratamiento,boolean bolFeq, boolean bolTemp,
			boolean bolTen, ArrayList<Sensores> sensores,ArrayList<DatosPaciente> datospacientes) {
		this.DNI = dNI;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.FechaNacimiento = fechaNacimiento;
		this.Descripcion = descripcion;
		this.enfermedad=enfermedad;
		this.tratamiento=tratamiento;
		this.bolFeq = bolFeq;
		this.bolTemp = bolTemp;
		this.bolTen = bolTen;
		this.sensores = sensores;
		this.datospacientes = datospacientes;
	}

	//Getters Setters
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public boolean isBolFeq() {
		return bolFeq;
	}
	public void setBolFeq(boolean bolFeq) {
		this.bolFeq = bolFeq;
	}
	public boolean isBolTemp() {
		return bolTemp;
	}
	public void setBolTemp(boolean bolTemp) {
		this.bolTemp = bolTemp;
	}
	public boolean isBolTen() {
		return bolTen;
	}
	public void setBolTen(boolean bolTen) {
		this.bolTen = bolTen;
	}

	public ArrayList<Sensores> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensores> sensores) {
		this.sensores = sensores;
	}

	public ArrayList<DatosPaciente> getDatospacientes() {
		return datospacientes;
	}

	public void setDatospacientes(ArrayList<DatosPaciente> datospacientes) {
		this.datospacientes = datospacientes;
	}
	
	
}
