package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class EnviarDatosTemporales {

	@Test
	void CP_03_0001() {
		String DNI = "45961900B";
		String horaInicio = "12:00";
		String horaFin = "13:00";
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(110, real.get(0).getFrecuenciaCardiaca());
		assertEquals(25.0, real.get(0).getTemperatura());
		assertEquals("90", real.get(0).getTension());			
		assertEquals("12:15", real.get(0).getHora());
		assertEquals(110, real.get(1).getFrecuenciaCardiaca());
		assertEquals(24.0, real.get(1).getTemperatura());
		assertEquals("80", real.get(1).getTension());			
		assertEquals("12:30", real.get(1).getHora());

	}

	@Test
	void CP_03_0002() {
		String DNI = "450B";
		String horaInicio = "12:00";
		String horaFin = "13:00";
		AlmacenDatos almacen = new AlmacenDatos();

		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0003() {
		String DNI = "45961900Ñ";
		String horaInicio = "12:00";
		String horaFin = "13:00";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, DNI));

	}

	@Test
	void CP_03_0004() {
		String horaInicio = "12:00";
		String horaFin = "13:00";

		AlmacenDatos almacen = new AlmacenDatos();

		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, null));
	}

	@Test
	void CP_03_0005() {
		String DNI = "45961900B";
		String horaInicio = "12:24:45";
		String horaFin = "13:00";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() ->almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0006() {
		String DNI = "45961900B";
		String horaInicio = "32:34";
		String horaFin = "13:00";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0007() {
		String DNI = "45961900B";
		String horaInicio = "12:69";
		String horaFin = "13:00";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() ->almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0008() {
		String DNI = "45961900B";
		String horaFin = "13:00";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(null, horaFin, DNI));
	}

	@Test
	void CP_03_0009() {
		String horaInicio = "12:00";
		String horaFin = "13:42:54:34";
		String DNI = "45961900B";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0010() {
		String horaInicio = "12:00";
		String horaFin = "53:42";
		String DNI = "45961900B";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0011() {
		String horaInicio = "12:00";
		String horaFin = "13:89";
		String DNI = "45961900B";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, horaFin, DNI));
	}

	@Test
	void CP_03_0012() {
		String horaInicio = "12:00";
		String DNI = "45961900B";

		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class,() -> almacen.enviarDatos(horaInicio, null, DNI));
	}
	
	@Test
	void CP_03_0013() {
		String horaInicio = "12:00";
		String horaFin = "13:00";
		String DNI = "45961900B";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> array = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		int contador=0;
		
		for(int i=0; i<array.size(); i++) {
			for(int j=0; j<array.size();j++) {
				if(array.get(i).getHora().equals(array.get(j).getHora())) {
					contador++;
				}
			}
		}
		//Si las concidencias de dos datos iguales solo son igual al tamaño del array
		//quiere decir que no hay datos duplicados, ya que los datos duplicados encontrados
		//son los mismos al recorrer dos veces el array
		assertEquals(contador, array.size());
	}

}
