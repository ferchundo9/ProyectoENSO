package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class RecibirDatosInstantaneos {
	
	@Test
	void test_02_0001() {
		String DNI = "34567898B";
		String Nombre = "Unai";
		String Apellidos = "Vázquez Vázquez";
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
		DatosPaciente dato = new DatosPaciente(35, 39.5, "12/17", "14:00");
		datospacientes.add(dato);
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		
		ProcesadorDatos es = new ProcesadorDatos();
		es.recibirDatos(paciente);
		List<Alarma> array =es.enviarAlarmasActivas(DNI);
		assertNotEquals(0, array.size());
		assertEquals("14:00", array.get(array.size()-1).getHora());
		assertEquals("moderada", array.get(array.size()-1).getGravedad());
		
	}

	@Test
	void test_02_0002() {
		String DNI = "11111111B";
		String Nombre = "NoRegistrado";
		String Apellidos = "NoRegistrado";
		String FechaNacimiento = "10/02/1998";
		String Descripcion = "NoRegistrado";
		String enfermedad = "NoRegistrado";
		String tratamiento = "NoRegistrado";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		
		ProcesadorDatos es = new ProcesadorDatos();
		
		assertThrows(Exception.class, ()->es.recibirDatos(paciente));
	}

	@Test
	void test_02_0003() {
		ProcesadorDatos es = new ProcesadorDatos();
		assertThrows(Exception.class, ()->es.recibirDatos(null));
	}
}
