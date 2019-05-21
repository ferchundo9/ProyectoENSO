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
		
		try {
			es.recibirDatos(paciente);
			fail("No ha lanzado excepción");
		} catch (Exception e) {
			assertEquals(1, 1);	// Se lanzó excepción = éxito
		}
	}

	@Test
	void test_02_0003() {
		ProcesadorDatos es = new ProcesadorDatos();
		Paciente paciente = null;

		try {
			es.recibirDatos(paciente);
			fail("No ha lanzado excepción");
		} catch (Exception e) {
			assertEquals(1, 1);	// Se lanzó excepción = éxito
		}
	}
}
