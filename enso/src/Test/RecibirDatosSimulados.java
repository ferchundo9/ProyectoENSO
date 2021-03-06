package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import clases.AlmacenDatos;
import clases.DatosPaciente;
import clases.Paciente;
import clases.Sensores;
import interfaces.DatosPacientes;
import junit.framework.Assert;

class RecibirDatosSimulados {

	@Test
	void CP_01_0004() {
		String DNI = "23415463F";
		String Nombre = "Santiago";
		String Apellidos = "Abascal";
		String FechaNacimiento = "14/04/1976";
		String Descripcion = "Vasco";
		String enfermedad = "Arritmia cardiaca";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(110, 25.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		AlmacenDatos almacen = new AlmacenDatos();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		almacen.recibirDatos(paciente);
		List<DatosPaciente> datosRecibidos = almacen.enviarDatos("0:00", "23:59", "23415463F");
		assertDoesNotThrow(() -> datosRecibidos.get(0));
	}

	
	/*void testDatosBienGuardados() {
		String DNI = "63";
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
		DatosPaciente datosPacientes = new DatosPaciente(110, 25.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		AlmacenDatos almacen = new AlmacenDatos();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		almacen.recibirDatos(paciente);
		List<DatosPaciente> datosRecibidos = almacen.enviarDatos("0:0", "23:59", "63");
		DatosPaciente datos = datosRecibidos.get(0);
		assertEquals(datos.getFrecuenciaCardiaca(), 110);
		assertEquals(datos.getTemperatura(), 25.0);
		assertEquals(datos.getTension(), "90");
		assertEquals(datos.getHora(), "12:00");
	}*/

	@Test
	void CP_01_0001() {
		String DNI = "45961900B";
		String Nombre = "Diego";
		String Apellidos = "Varela Seijas";
		String FechaNacimiento = "03/09/1998";
		String Descripcion = "Poco solidario";
		String enfermedad = "Limipio";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(110, 25.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		AlmacenDatos almacen = new AlmacenDatos();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		almacen.recibirDatos(paciente);
		String horaInicio = "11:01";
		String horaFin = "13:30";
		List<DatosPaciente> obtenido = almacen.enviarDatos(horaInicio, horaFin, DNI);
		assertEquals(datospacientes.get(0).getFrecuenciaCardiaca(), obtenido.get(0).getFrecuenciaCardiaca());
		assertEquals(datospacientes.get(0).getTemperatura(), obtenido.get(0).getTemperatura());
		assertEquals(datospacientes.get(0).getTension(), obtenido.get(0).getTension());
		assertEquals(datospacientes.get(0).getHora(), obtenido.get(0).getHora());
	}

	@Test
	void CP_01_0002() {
		String DNI = "35567878D";
		String Nombre = "Gonzalo";
		String Apellidos = "Varela Seijas";
		String FechaNacimiento = "03/09/1998";
		String Descripcion = "Poco solidario";
		String enfermedad = "Limipio";
		String tratamiento = "Agua potable";
		boolean bolFeq = true;
		boolean bolTemp = true;
		boolean bolTen = true;
		Sensores sensor = new Sensores();
		ArrayList<Sensores> sensores = new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes = new ArrayList<>();
		DatosPaciente datosPacientes = new DatosPaciente(110, 25.0, "90", "12:00");
		datospacientes.add(datosPacientes);
		AlmacenDatos almacen = new AlmacenDatos();
		Paciente paciente = new Paciente(DNI, Nombre, Apellidos, FechaNacimiento, Descripcion, enfermedad, tratamiento,
				bolFeq, bolTemp, bolTen, sensores, datospacientes);
		almacen.recibirDatos(paciente);
		String horaInicio = "11:01";
		String horaFin = "13:30";

		assertThrows(Exception.class, ()->almacen.enviarDatos(horaInicio, horaFin, DNI));

	}
	
	@Test
	void CP_01_0003() {

		AlmacenDatos almacen = new AlmacenDatos();
		Paciente paciente = null;
		assertThrows(Exception.class, () -> almacen.recibirDatos(paciente));
	}

}
