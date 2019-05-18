package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.*;
import clases.*;
import junit.framework.Assert;

public class EnviarEstadisticas {

	@Test
	void test04_001() {
		String DNI="45961900B";
		String fechaInicio="03/03/2019";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Estadistica> real = (ArrayList<Estadistica>)procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);
		
		System.out.println(real.size());
		assertEquals("0001", real.get(0).getIdxEstadistic());
		/*assertEquals("45961900B", real.get(0).getDni_paciente());
		assertEquals("02/04/2019", real.get(0).getFecha());
		assertEquals("14:00", real.get(0).getHora());
		assertEquals(38.5, real.get(0).getMaxTemp());
		assertEquals(36, real.get(0).getMinTemp());
		assertEquals(36.5, real.get(0).getMediaTemp());
		assertEquals(38, real.get(0).getQ1Temp());
		assertEquals(37, real.get(0).getQ2Temp());
		assertEquals(36, real.get(0).getQ3Temp());
		assertEquals(110, real.get(0).getMaxTen());
		assertEquals(70, real.get(0).getMinTen());
		assertEquals(85, real.get(0).getMediaTen());
		assertEquals(105, real.get(0).getQ1Ten());
		assertEquals(90, real.get(0).getQ2Ten());
		assertEquals(75, real.get(0).getQ3Ten());
		assertEquals(50, real.get(0).getMaxFreq());
		assertEquals(30, real.get(0).getMinFreq());
		assertEquals(40, real.get(0).getMediaFreq());
		assertEquals(45, real.get(0).getQ1Freq());
		assertEquals(40, real.get(0).getQ2Freq());
		assertEquals(35, real.get(0).getQ3Freq());*/
	}

	
	@Test
	void test04_002() {
		String DNI="4500B";
		String fechaInicio="03/03/2019";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	
	@Test
	void test04_003() {
		String DNI="45961900Ñ";
		String fechaInicio="03/03/2019";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_004() {
		String fechaInicio="03/03/2019";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(null,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_005() {
		String DNI="45961900B";
		String fechaInicio="2019/03/03";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_006() {
		String DNI="45961900B";
		String fechaInicio="54/03/2019";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_007() {
		String DNI="45961900B";
		String fechaInicio="03/43/2019";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_008() {
		String DNI="45961900B";
		String fechaInicio="03/03/1789";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_009() {
		String DNI="45961900B";
		String fechaFin="05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,null, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_010() {
		String DNI="45961900B";
		String fechaInicio="03/03/2019";
		String fechaFin="04/2019/05";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_011() {
		String DNI="45961900B";
		String fechaInicio="03/03/2019";
		String fechaFin="43/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_012() {
		String DNI="45961900B";
		String fechaInicio="03/03/2019";
		String fechaFin="05/54/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_013() {
		String DNI="45961900B";
		String fechaInicio="03/03/2019";
		String fechaFin="05/04/1812";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, fechaFin);	
		
		assertEquals(0, real.size());
	}
	
	@Test
	void test04_014() {
		String DNI="45961900B";
		String fechaInicio="03/03/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> real = procesador.enviarEstadisticas(DNI,fechaInicio, null);	
		
		assertEquals(0, real.size());
	}
}
