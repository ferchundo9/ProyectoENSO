package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import clases.DatosPaciente;
import clases.Paciente;
import clases.ProcesadorDatos;
import clases.Sensores;

public class DetectarAlarmasBlanca {
	@Test
	public void test1() {
		String DNI = "1";
		String Nombre = "Santiago";
		String Apellidos = "Abascal";
		String FechaNacimiento = "14/04/1976";
		String Descripcion = "Nada de nah";
		String enfermedad = "Limipio";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(49, 32.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		ProcesadorDatos procesadorDatos = new ProcesadorDatos();
		procesadorDatos.detectarAlarma(paciente);
		assertEquals(procesadorDatos.enviarAlarmasActivas("1").get(0).getGravedad(), "leve");
	}

	@Test
	public void test2() {
		String DNI = "2";
		String Nombre = "Santiago";
		String Apellidos = "Abascal";
		String FechaNacimiento = "14/04/1976";
		String Descripcion = "Nada de nah";
		String enfermedad = "Limipio";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(39, 30.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		ProcesadorDatos procesadorDatos = new ProcesadorDatos();
		procesadorDatos.detectarAlarma(paciente);
		assertEquals(procesadorDatos.enviarAlarmasActivas("2").get(0).getGravedad(), "moderada");
	}

	@Test
	public void test3() {
		String DNI = "3";
		String Nombre = "Santiago";
		String Apellidos = "Abascal";
		String FechaNacimiento = "14/04/1976";
		String Descripcion = "Nada de nah";
		String enfermedad = "Limipio";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(29, 28.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		ProcesadorDatos procesadorDatos = new ProcesadorDatos();
		procesadorDatos.detectarAlarma(paciente);
		assertEquals(procesadorDatos.enviarAlarmasActivas("3").get(0).getGravedad(), "grave");
	}

	@Test
	public void test4() {
		ProcesadorDatos procesadorDatos = new ProcesadorDatos();
		assertThrows(Exception.class, () -> procesadorDatos.detectarAlarma(null));
	}

	@Test
	public void test5() {
		String DNI = "5";
		String Nombre = "Santiago";
		String Apellidos = "Abascal";
		String FechaNacimiento = "14/04/1976";
		String Descripcion = "Nada de nah";
		String enfermedad = "Limipio";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(29, 28.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		ProcesadorDatos procesadorDatos = new ProcesadorDatos();
		procesadorDatos.detectarAlarma(paciente);
		assertTrue(procesadorDatos.enviarAlarmasActivas("5").size()!=0);
	}
}
