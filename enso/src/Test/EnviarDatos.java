package Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.junit.Test;

import clases.AlmacenDatos;

public class EnviarDatos {
	@Test
	public void test1() {
		File file = new File("InfoSensores.csv");
		file.delete();
		AlmacenDatos almacen = new AlmacenDatos();
		assertThrows(Exception.class, () -> almacen.enviarDatos("12:00", "3", "55"));
	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	@Test
	public void test4() {

	}

	@Test
	public void test5() {

	}
}
