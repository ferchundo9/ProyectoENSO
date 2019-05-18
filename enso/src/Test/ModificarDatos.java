package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.Test;

import clases.DatosPaciente;
import clases.GestorPacientes;
import clases.Paciente;
import clases.Sensores;

public class ModificarDatos {
	@Test
	public void test1() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		String DNI = "777";
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
		ArrayList<Paciente> pacientes = gestorPacientes.leerpacientes();
		boolean existe = false;
		for (Paciente paciente1 : pacientes) {
			if (paciente1.getDNI().equals("777")) {
				existe = true;
			}
		}
		assertTrue(!existe);
	}

	@Test
	public void test2() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		assertThrows(Exception.class, () -> gestorPacientes.modificarDatos(null));
	}

	@Test
	public void test3() {

	}

	@Test
	public void test4() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		String DNI = "123";
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
		gestorPacientes.darDeAlta(paciente);
		paciente.setEnfermedad("Sucio");
		gestorPacientes.modificarDatos(paciente);
		ArrayList<Paciente> pacientes = gestorPacientes.leerpacientes();
		Paciente pacienteModificado = null;
		for (Paciente paciente1 : pacientes) {
			if (paciente1.getDNI().equals("123")) {
				pacienteModificado = paciente1;
			}
		}
		assertEquals(pacienteModificado.getEnfermedad(), "Sucio");
	}

	@Test
	public void test5() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		String DNI = "456";
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
		Paciente paciente2 = new Paciente("789", Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad,
				tratamiento, bolFeq, bolTemp, bolTen, sensores, datospacientes);
		gestorPacientes.darDeAlta(paciente);
		gestorPacientes.darDeAlta(paciente2);
		paciente.setEnfermedad("Sucio");
		gestorPacientes.modificarDatos(paciente);
		ArrayList<Paciente> pacientes = gestorPacientes.leerpacientes();
		Paciente pacienteModificado = null;
		for (Paciente paciente1 : pacientes) {
			if (paciente1.getDNI().equals("456")) {
				pacienteModificado = paciente1;
			}
		}
		assertEquals(pacienteModificado.getEnfermedad(), "Sucio");
	}
}
