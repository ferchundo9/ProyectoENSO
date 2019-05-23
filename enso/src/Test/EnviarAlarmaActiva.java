package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class EnviarAlarmaActiva {

	@Test
	void test06_001() {
		String DNI = "45961900B";
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Alarma> real = (ArrayList<Alarma>) procesador.enviarAlarmasActivas(DNI);

		assertNotEquals(0, real.size());
		assertEquals("45961900B", real.get(0).getDniPaciente());
		assertEquals("Alta", real.get(0).getGravedad());
		assertEquals("14:00", real.get(0).getHora());

	}

	@Test
	void test06_002() {
		String DNI = "Ola3647282812";
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Alarma> real = (ArrayList<Alarma>) procesador.enviarAlarmasActivas(DNI);

		assertEquals(0, real.size());
	}

	@Test
	void test06_003() {
		String DNI = "45958207U";
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Alarma> real = (ArrayList<Alarma>) procesador.enviarAlarmasActivas(DNI);

		assertEquals(0, real.size());
	}
	
	@Test
	void test06_004() {
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Alarma> real = (ArrayList<Alarma>) procesador.enviarAlarmasActivas(null);

		assertEquals(0, real.size());
	}
	
}
