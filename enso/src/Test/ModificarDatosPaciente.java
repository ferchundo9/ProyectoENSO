package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class ModificarDatosPaciente {

	@Test
	void test08_001() {

		String DNI = "34567898B";
		String Nombre = "Unai";
		String Apellidos = "Vázquez Vázquez";
		String FechaNacimiento = "16/02/1998";
		String Descripcion = "Deportista mediocre";
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
		gestor.modificarDatos(paciente);
		
		ArrayList<Paciente> array =gestor.leerpacientes();
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).getDNI().equals(DNI)) {
				assertEquals("Unai", array.get(i).getNombre());
				assertEquals("Vázquez Vázquez", array.get(i).getApellidos());
				assertEquals("16/02/1998", array.get(i).getFechaNacimiento());
				assertEquals("Insuficiencia respiratoria", array.get(i).getEnfermedad());
				assertEquals("Bombona de oxigeno", array.get(i).getTratamiento());
				assertEquals("Deportista mediocre", array.get(i).getDescripcion());
			}
		}
		

	}

	@Test
	void test08_002() {
		
		String DNI = "34567898V";
		String Nombre = "Xose";
		String Apellidos = "Castelao Vázquez";
		String FechaNacimiento = "16/02/1998";
		String Descripcion = "Deportista mediocre";
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
		assertThrows(Exception.class, ()->gestor.modificarDatos(paciente));
		
	}

	@Test
	void test08_003() {
		GestorPacientes gestor=new GestorPacientes();
		assertThrows(Exception.class, ()->gestor.modificarDatos(null));
	}
	

}
