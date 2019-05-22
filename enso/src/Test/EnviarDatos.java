package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import clases.AlmacenDatos;
import clases.DatosPaciente;
import clases.Paciente;
import clases.Sensores;

public class EnviarDatos {
	@Test
	public void test1() {
		File file = new File("InfoSensores.csv");
		File filePrueba=new File("Prueba4.csv");
		file.renameTo(filePrueba);
		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class, () -> almacen.enviarDatos("12:00", "3", "55"));
		filePrueba.renameTo(file);
	}

	@Test
	public void test2() {
		AlmacenDatos almacen = new AlmacenDatos();
		String DNI = "1456";
		String DNI2 = "3698";
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
		Paciente paciente2 = new Paciente(DNI2, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		almacen.recibirDatos(paciente);
		almacen.recibirDatos(paciente2);
		List<DatosPaciente> datos= almacen.enviarDatos("00:00","23:59", DNI);
		assertTrue(datos.size()!=0);
		
	}

	@Test
	public void test3() {
		AlmacenDatos almacen = new AlmacenDatos();
		String DNI = "9999";
		List<DatosPaciente> datos= almacen.enviarDatos("00:00","23:59", DNI);
		assertTrue(datos.size()==0);
	}

	@Test
	public void test4() {
		AlmacenDatos almacen = new AlmacenDatos();
		String DNI = "1456";
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
		almacen.recibirDatos(paciente);
		List<DatosPaciente> datos= almacen.enviarDatos("12:01","23:59", DNI);
		assertTrue(datos.size()!=0);
	}

	
}
