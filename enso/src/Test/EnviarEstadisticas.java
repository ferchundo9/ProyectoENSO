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
	void CP_04_0001() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		ArrayList<Estadistica> real = (ArrayList<Estadistica>) procesador.enviarEstadisticas(DNI, fechaInicio,
				fechaFin);

		assertNotEquals(0, real.size());
		assertEquals("0001", real.get(0).getIdxEstadistic());
		assertEquals("45961900B", real.get(0).getDni_paciente());
		assertEquals("02/04/2019", real.get(0).getFecha());
		assertEquals("14:00", real.get(0).getHora());
		assertEquals(38.5, real.get(0).getMaxTemp(), 0.001);
		assertEquals(36, real.get(0).getMinTemp(), 0.001);
		assertEquals(36.5, real.get(0).getMediaTemp(), 0.001);
		assertEquals(38, real.get(0).getQ1Temp(), 0.001);
		assertEquals(37, real.get(0).getQ2Temp(), 0.001);
		assertEquals(36, real.get(0).getQ3Temp(), 0.001);
		assertEquals(110, real.get(0).getMaxTen());
		assertEquals(70, real.get(0).getMinTen());
		assertEquals(85, real.get(0).getMediaTen());
		assertEquals(105, real.get(0).getQ1Ten());
		assertEquals(90, real.get(0).getQ2Ten());
		assertEquals(75, real.get(0).getQ3Ten());
		assertEquals(50, real.get(0).getMaxFreq(), 0.001);
		assertEquals(30, real.get(0).getMinFreq(), 0.001);
		assertEquals(40, real.get(0).getMediaFreq(), 0.001);
		assertEquals(45, real.get(0).getQ1Freq(), 0.001);
		assertEquals(40, real.get(0).getQ2Freq(), 0.001);
		assertEquals(35, real.get(0).getQ3Freq(), 0.001);

	}

	@Test
	void CP_04_0002() {
		String DNI = "4500B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0003() {
		String DNI = "45961900�";
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0004() {
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(null, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0005() {
		String DNI = "45961900B";
		String fechaInicio = "2019/03/03";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0006() {
		String DNI = "45961900B";
		String fechaInicio = "54/03/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()->procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0007() {
		String DNI = "45961900B";
		String fechaInicio = "03/43/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0008() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/1789";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0009() {
		String DNI = "45961900B";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, null, fechaFin));
	}

	@Test
	void CP_04_0010() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "04/2019/05";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()->procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0011() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "43/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0012() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/54/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0013() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/04/1812";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()-> procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin));
	}

	@Test
	void CP_04_0014() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		assertThrows(Exception.class, ()->procesador.enviarEstadisticas(DNI, fechaInicio, null));
	}
	
	@Test
	void CP_04_0015() {
		String DNI = "45961900B";
		String fechaInicio = "03/03/2019";
		String fechaFin = "05/04/2019";
		ProcesadorDatos procesador = new ProcesadorDatos();
		List<Estadistica> array = procesador.enviarEstadisticas(DNI, fechaInicio, fechaFin);
		
		int contador=0;
		
		assertNotEquals(0, array.size());
		for(int i=0; i<array.size(); i++) {
			for(int j=0; j<array.size(); j++) {
				if(array.get(i).getIdxEstadistic().equals(array.get(j).getIdxEstadistic())) {
					contador++;
				}
			}
		}
		
		assertEquals(contador, array.size());
		
	}
}
