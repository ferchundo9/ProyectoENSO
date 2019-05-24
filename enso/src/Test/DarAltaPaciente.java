package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;


public class DarAltaPaciente {
	
	@Test
	void CP_07_0001() {
		
		String DNI = "34567898B";
		String Nombre = "Unai";
		String Apellidos = "V�zquez V�zquez";
		String FechaNacimiento = "16/02/1998";
		String Descripcion = "Gran deportista";
		String enfermedad = "Insuficiencia respiratoria";
		String tratamiento = "Bombona de oxigeno";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		GestorPacientes gestor=new GestorPacientes();
		gestor.darDeAlta(paciente);
		
		ArrayList<Paciente> pacientes =gestor.leerpacientes();
		
		assertEquals(paciente.getDNI(), pacientes.get(pacientes.size()-1).getDNI());
		
	}
	
	@Test
	void CP_07_0002() {
		String DNI = "34567898B";
		String Nombre = "Unai";
		String Apellidos = "V�zquez V�zquez";
		String FechaNacimiento = "16/02/1998";
		String Descripcion = "Gran deportista";
		String enfermedad = "Insuficiencia respiratoria";
		String tratamiento = "Bombona de oxigeno";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		GestorPacientes gestor=new GestorPacientes();
		assertThrows(Exception.class, ()->gestor.darDeAlta(paciente));
		
		
	}
	
	@Test
	void CP_07_0003() {
		
		GestorPacientes gestor=new GestorPacientes();
		assertThrows(Exception.class, ()->gestor.darDeAlta(null));
	}

}
