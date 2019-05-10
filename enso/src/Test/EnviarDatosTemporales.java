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
	void test03_001() {
		String DNI="45961900B";
		String horaInicio="12:00";
		String horaFin="12:45";
		AlmacenDatos procesador = new AlmacenDatos();
		List<DatosPaciente> real = procesador.enviarDatos(DNI, horaInicio, horaFin);
		
		assertEquals(100, real.get(0).getFrecuenciaCardiaca());
		assertEquals(25.0, real.get(0).getTemperatura());
		assertEquals("90", real.get(0).getTension());
		assertEquals("12:00", real.get(0).getHora());
		
	}
	
	void test03_002() {
		String DNI="450B";
		String horaInicio="12:00";
		String horaFin="12:45";
		AlmacenDatos procesador = new AlmacenDatos();
		List<DatosPaciente> real = procesador.enviarDatos(DNI, horaInicio, horaFin);
		
		assertEquals(0, real.size());
	}

}
