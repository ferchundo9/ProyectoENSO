package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import clases.DatosPaciente;
import clases.GestorPacientes;
import clases.Paciente;
import clases.Sensores;

public class DarDeBajaBlanca {
	@Test
	public void test1() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		String DNI = "7456";
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
		gestorPacientes.darDeBaja(DNI);
		ArrayList<Paciente> pacientes = gestorPacientes.leerpacientes();
		boolean existe = false;
		for (Paciente paciente1 : pacientes) {
			if (paciente1.getDNI().equals(DNI)) {
				existe = true;
			}
		}
		assertTrue(!existe);
	}
	@Test
	public void test2() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		File file = new File("InfoPacientes.csv");
		File filePrueba=new File("Prueba.csv");
		String DNI = "2121";
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
		file.renameTo(filePrueba);
		assertThrows(Exception.class, () -> gestorPacientes.darDeBaja(DNI));
		filePrueba.renameTo(file);
		
	}
	@Test
	public void test3() {
		File file = new File("InfoPacientes.csv");
		File filePrueba=new File("Prueba.csv");
		filePrueba.renameTo(file);
		GestorPacientes gestorPacientes = new GestorPacientes();
		String DNI = "648578";
		String DNI2 = "45896";
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
		Paciente paciente2 = new Paciente(DNI2, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		gestorPacientes.darDeAlta(paciente);
		gestorPacientes.darDeAlta(paciente2);
		gestorPacientes.darDeBaja(DNI);
		ArrayList<Paciente> pacientes = gestorPacientes.leerpacientes();
		boolean existe = false;
		for (Paciente paciente1 : pacientes) {
			if (paciente1.getDNI().equals(DNI2)) {
				existe = true;
			}
		}
		assertTrue(existe);
	}
	@Test
	public void test4() {
		GestorPacientes gestorPacientes = new GestorPacientes();
		String DNI = "456987";
		assertDoesNotThrow(() -> gestorPacientes.darDeBaja(DNI));
		;
	}
}
