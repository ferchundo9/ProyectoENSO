package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import clases.Estadistica;
import clases.ProcesadorDatos;

public class EnviarEstadisticasBlanca {
	@Test
	public void test1() {
		ProcesadorDatos procesador=new ProcesadorDatos();
		File file = new File("InfoEstadisticas.csv");
		File filePrueba=new File("Prueba5.csv");
		file.renameTo(filePrueba);	
		assertThrows(FileNotFoundException.class, () -> procesador.enviarEstadisticas("63","25/03/1956", "25/03/1956"));
		filePrueba.renameTo(file);	
	}
	@Test
	public void test2() {
		//Arreglar el nombre del archivo de la anterior prueba
		File file = new File("InfoEstadisticas.csv");
		File filePrueba=new File("Prueba5.csv");
		filePrueba.renameTo(file);
		//Aqui empieza la prueba 2
		ProcesadorDatos procesador=new ProcesadorDatos();
		List<Estadistica> estadisticas=procesador.enviarEstadisticas("63","01/03/2018","01/03/2020");
		assertTrue(estadisticas.size()==0);
		
	}
	@Test
	public void test3() {
		ProcesadorDatos procesador=new ProcesadorDatos();
		List<Estadistica> estadisticas=procesador.enviarEstadisticas("45961900B","01/03/2018","01/03/2020");
		assertTrue(estadisticas.size()!=0);
	}
	@Test
	public void test4() {
		ProcesadorDatos procesador=new ProcesadorDatos();
		List<Estadistica> estadisticas=procesador.enviarEstadisticas("45961901B","01/03/2018","01/03/2020");
		assertTrue(estadisticas.size()!=0);
	}
}
