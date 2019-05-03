package clases;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import interfaces.DatosSimulados;

//Sensores
public class Sensores {
	//Atributos
	String nombre;
	Paciente paciente;
	DatosSimulados almacen;
	//Constructores
	public Sensores() {
		this.nombre = new String();
		this.paciente =new Paciente();
		this.almacen=new AlmacenDatos();
	}
	public Sensores(String nombre) {
		this.nombre = nombre;
		this.paciente =new Paciente();
		this.almacen=new AlmacenDatos();
	}
	public Sensores(String nombre, Paciente paciente) {
		this.nombre = nombre;
		this.paciente = paciente;
		this.almacen=new AlmacenDatos();
	}
	public Sensores(String nombre, Paciente paciente, AlmacenDatos almacen) {
		super();
		this.nombre = nombre;
		this.paciente = paciente;
		this.almacen= almacen;
	}
	//Getters setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public DatosSimulados getAlmacen() {
		return almacen;
	}
	public void setAlmacen(DatosSimulados almacen) {
		this.almacen = almacen;
	}
	//Métodos
	//Creanse datos para o paciente
	public DatosPaciente crearDatos(){
		//Creo esos datos pacientes
		Random aleatorio = new Random(System.currentTimeMillis());
		//Frecuencia
		Integer frecuencia = aleatorio.nextInt(201)+20;
		//Temperatura
		Double temperatura = (aleatorio.nextDouble()*33)+15;
		//Tension
		Integer ten1 = aleatorio.nextInt(120)+40;
		Integer ten2 = aleatorio.nextInt(120)+40;
		String tension=ten1+"/"+ten2;//sistolica diastolica
		//Hora
		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos;
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		String lahora=hora+":"+minutos;
		
		//Crease o dato e metese no paciente
		DatosPaciente datos=new DatosPaciente(frecuencia,temperatura,tension,lahora);
		this.paciente.getDatospacientes().add(datos);
		
		//devolvese ese dato
		return(datos);
	}
	
}
