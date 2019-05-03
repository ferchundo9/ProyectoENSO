package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import clases.AlmacenDatos;
import clases.DatosPaciente;
import clases.Paciente;
import clases.Sensores;
import junit.framework.Assert;

class RecibirDatosSimultaneos {

	@Test
	void testDatosGuardados() {
		String DNI="63";
		String Nombre="Santiago";
		String Apellidos="Abascal";
		String FechaNacimiento="14/04/1976";
		String Descripcion="Nada de nah";
		String enfermedad="Limipio";
		String tratamiento="Agua potable";
		boolean bolFeq=true;
		boolean bolTemp=true;
		boolean bolTen=true;
		Sensores sensor=new Sensores();
		ArrayList<Sensores> sensores=new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes=new ArrayList<>();
		DatosPaciente datosPacientes=new DatosPaciente(110,25.0,"90","12:00");
		datospacientes.add(datosPacientes);
		AlmacenDatos almacen=new AlmacenDatos();
		Paciente paciente=new Paciente(DNI,Nombre,Apellidos,
				FechaNacimiento,Descripcion,enfermedad,tratamiento,
				bolFeq,bolTemp,bolTen,sensores,datospacientes);
		almacen.recibirDatos(paciente);
		List<DatosPaciente> datosRecibidos=almacen.enviarDatos("0:0", "23:59","63");
		assertDoesNotThrow(()->datosRecibidos.get(0));
	}
	@Test
	void testDatosBienGuardados() {
		String DNI="63";
		String Nombre="Santiago";
		String Apellidos="Abascal";
		String FechaNacimiento="14/04/1976";
		String Descripcion="Nada de nah";
		String enfermedad="Limipio";
		String tratamiento="Agua potable";
		boolean bolFeq=true;
		boolean bolTemp=true;
		boolean bolTen=true;
		Sensores sensor=new Sensores();
		ArrayList<Sensores> sensores=new ArrayList<>();
		sensores.add(sensor);
		ArrayList<DatosPaciente> datospacientes=new ArrayList<>();
		DatosPaciente datosPacientes=new DatosPaciente(110,25.0,"90","12:00");
		datospacientes.add(datosPacientes);
		AlmacenDatos almacen=new AlmacenDatos();
		Paciente paciente=new Paciente(DNI,Nombre,Apellidos,
				FechaNacimiento,Descripcion,enfermedad,tratamiento,
				bolFeq,bolTemp,bolTen,sensores,datospacientes);
		almacen.recibirDatos(paciente);
		List<DatosPaciente> datosRecibidos=almacen.enviarDatos("0:0", "23:59","63");
		DatosPaciente datos=datosRecibidos.get(0);
		assertEquals(datos.getFrecuenciaCardiaca(),110);
		assertEquals(datos.getTemperatura(),25.0);
		assertEquals(datos.getTension(),"90");
		assertEquals(datos.getHora(),"12:00");
	}
	@Test
	void PacienteNull() {
		
		AlmacenDatos almacen=new AlmacenDatos();
		Paciente paciente=null;
		assertThrows(Exception.class,()->almacen.recibirDatos(paciente));
	}

}
