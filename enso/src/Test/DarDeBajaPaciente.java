package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class DarDeBajaPaciente {

	@Test
	void test08_001() {
		String DNI = "45961900B";
		GestorPacientes gestor=new GestorPacientes();
		gestor.darDeBaja(DNI);
		
		//Iterar los pacientes del archivo para ver si se elimin� el paciente que busc�bamos

	}

	@Test
	void test08_002() {
		String DNI = "459B";
		GestorPacientes gestor=new GestorPacientes();
		gestor.darDeBaja(DNI);

		assertThrows(Exception.class,() -> gestor.darDeBaja(DNI));
	}

	@Test
	void test08_003() {
		String DNI = "45961900�";
		GestorPacientes gestor=new GestorPacientes();

		assertThrows(Exception.class,() -> gestor.darDeBaja(DNI));
	}
	
	
	@Test
	void test08_004() {
		GestorPacientes gestor=new GestorPacientes();

		assertThrows(Exception.class,() -> gestor.darDeBaja(null));
	}
}
