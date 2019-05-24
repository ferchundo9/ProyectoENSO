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
		assertEquals("14:00", real.get(0).getHora());
		assertEquals("Alta", real.get(0).getGravedad());

	}

	@Test
	void test06_002() {
		String DNI = "Ola3647282812";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()->procesador.enviarAlarmasActivas(DNI));
	}

	@Test
	void test06_003() {
		String DNI = "45958207U";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()->procesador.enviarAlarmasActivas(DNI));
	}
	
	@Test
	void test06_004() {
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()->procesador.enviarAlarmasActivas(null));
	}
	
	@Test
	void test06_005() {
		
		String DNI = "45961900B";
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Alarma> array = (ArrayList<Alarma>) procesador.enviarAlarmasActivas(DNI);
		
		int contador=0;
		
		assertNotEquals(0, array.size());
		for(int i=0; i<array.size(); i++) {
			for(int j=0; j<array.size(); j++) {
				if(array.get(i).getHora().equals(array.get(j).getHora()) && array.get(i).getGravedad().equals(array.get(j).getGravedad())) {
					contador++;
				}
			}
		}
		
		assertEquals(contador, array.size());
		
	}
	
}
