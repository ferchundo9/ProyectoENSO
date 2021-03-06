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
	void CP_08_0001() {
		String DNI = "45961900B";
		GestorPacientes gestor=new GestorPacientes();
		gestor.darDeBaja(DNI);
		
		//Iterar los pacientes del archivo para ver si se elimin� el paciente que busc�bamos
		ArrayList<Paciente> array =gestor.leerpacientes();
		for(int i=0; i<array.size(); i++) {
			assertNotEquals(DNI, array.get(i).getDNI());
		}

	}

	@Test
	void CP_08_0002() {
		String DNI = "459B";
		GestorPacientes gestor=new GestorPacientes();
		gestor.darDeBaja(DNI);

		assertThrows(Exception.class,() -> gestor.darDeBaja(DNI));
	}

	@Test
	void CP_08_0003() {
		String DNI = "45961900�";
		GestorPacientes gestor=new GestorPacientes();

		assertThrows(Exception.class,() -> gestor.darDeBaja(DNI));
	}
	
	
	@Test
	void CP_08_0004() {
		GestorPacientes gestor=new GestorPacientes();

		assertThrows(Exception.class,() -> gestor.darDeBaja(null));
	}
}
