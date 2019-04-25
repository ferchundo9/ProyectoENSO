package main;

import gestionPacientes.*;
import analisis.*;
import almacenDatos.*;
import sensorizacion.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		InterfazDatosPacientes gestorP = new GestorPacientes();
		Paciente p1=gestorP.registarPaciente("Gonzalo", "Sanin Raña", "23/11/1996", "Muy solidario");
		Paciente p2=gestorP.registarPaciente("Zalo", "Maria Pepe", "12/12/2012", "Adios");
		ArrayList<Paciente> arrayP = new ArrayList<>();
		arrayP.add(p1);
		arrayP.add(p2);
		
		InterfazDatosInstantaneos analizador = new Analizador();
		InterfazDatosSimulados almacen = new ImplementacionAlmacen(analizador);
	
		SensorDatos sensor = new SensorDatos(arrayP, almacen);
		
		sensor.CrearDatos();
		
		gestorP.EliminarPaciente(p1.getId().toString());
		
		gestorP.ModificarPaciente("Zalo", "Sanchez", "Carla", "12/12/2012", "Adios");
		
		
	}

}
