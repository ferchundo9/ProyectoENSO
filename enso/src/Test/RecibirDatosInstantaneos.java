package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class RecibirDatosInstantaneos {

	@Test
	void test_02_0002() {

	}

	@Test
	void test_02_0003() {
		ProcesadorDatos es = new ProcesadorDatos();
		Paciente p = null;

		try {
			es.recibirDatos(p);
			fail("No ha lanzado excepción");
		} catch (Exception e) {
			assertEquals(1, 1);
		}
	}
}
