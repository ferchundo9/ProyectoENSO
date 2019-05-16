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
		String horaFin="13:00";
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(110, real.get(0).getFrecuenciaCardiaca());
		assertEquals(25.0, real.get(0).getTemperatura());
		assertEquals("90", real.get(0).getTension());
		assertEquals("12:15", real.get(0).getHora());
		
	}
	
	@Test
	void test03_002() {
		String DNI="450B";
		String horaInicio="12:00";
		String horaFin="13:00";
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_003() {
		String DNI="45961900�";
		String horaInicio="12:00";
		String horaFin="13:00";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(0, real.size());
		
	}
	
	@Test
	void test03_004() {
		String horaInicio="12:00";
		String horaFin="13:00";
		
		AlmacenDatos almacen = new AlmacenDatos();
		
		List<DatosPaciente> real=almacen.enviarDatos(horaInicio, horaFin, null);
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_005() {
		String DNI="45961900B";
		String horaInicio="12:24:45";
		String horaFin="13:00";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_006() {
		String DNI="45961900B";
		String horaInicio="32:34";
		String horaFin="13:00";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_007() {
		String DNI="45961900B";
		String horaInicio="12:69";
		String horaFin="13:00";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(horaInicio, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_008() {
		String DNI="45961900B";
		String horaFin="13:00";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(null, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_009() {
		String horaInicio="12:00";
		String horaFin="13:42:54:34";
		String DNI="45961900B";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(null, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_010() {
		String horaInicio="12:00";
		String horaFin="53:42";
		String DNI="45961900B";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(null, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_011() {
		String horaInicio="12:00";
		String horaFin="13:89";
		String DNI="45961900B";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(null, horaFin, DNI);
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test03_012() {
		String horaInicio="12:00";
		String DNI="45961900B";
		
		AlmacenDatos almacen = new AlmacenDatos();
		List<DatosPaciente> real = almacen.enviarDatos(null, null, DNI);
		
		assertEquals(0, real.size());
	}

}
