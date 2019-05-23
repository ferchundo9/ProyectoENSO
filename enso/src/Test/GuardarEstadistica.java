package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import clases.Estadistica;
import clases.ProcesadorDatos;

class GuardarEstadistica {

	@Test
	void test05_001() {
		String id = "0002";
		String dni_paciente = "12345678A";
		String fecha = "02/03/2019";
		String hora = "14:00";
		Double maxTemp = 37.5;
		Double minTemp = 36.5;
		Double mediaTemp = 37.0;
		Double q1Temp = 37.1;
		Double q2Temp = 37.1;
		Double q3Temp = 37.1;
		String maxTen = "110";
		String minTen = "110";
		String mediaTen = "110";
		String q1Ten = "110";
		String q2Ten = "110";
		String q3Ten = "110";
		Integer maxFreq = 110;
		Integer minFreq = 110;
		Integer mediaFreq = 110;
		Integer q1Freq = 110;
		Integer q2Freq = 110;
		Integer q3Freq = 110;
		
		Estadistica est = new Estadistica(id, dni_paciente, fecha, hora, maxTemp, minTemp, mediaTemp, q1Temp, q2Temp, q3Temp,
				maxTen, minTen, mediaTen, q1Ten, q2Ten, q3Ten, maxFreq, minFreq, mediaFreq, q1Freq, q2Freq, q3Freq);
		ProcesadorDatos procesador = new ProcesadorDatos();
		
		try {
			procesador.guardarEstadistica(est);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader reader;
		List<String> lines = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader("InfoEstadisticas.csv"));
			String line = null;
			while ((line = reader.readLine()) != null) {
			    lines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).equals("0002,12345678A,02/03/2019,14:00,110,110,110,110,110,110,37.5,36.5,37.0,37.1,37.1,37.1,110,110,110,110,110,110")) {
				assertEquals("id,dni,fecha,hora,maxfreq,minfreq,mediafreq,q1freq,q1freq,q2freq,maxtemp,mintemp,mediatemp,q1temp,q2temp,q3temp,maxten,minten,mediaten,q1ten,q2ten,q3ten",
						lines.get(i - 1));
				assertEquals("0002,12345678A,02/03/2019,14:00,110,110,110,110,110,110,37.5,36.5,37.0,37.1,37.1,37.1,110,110,110,110,110,110", lines.get(i));
			}
		}
		
	}
	
	
	// Este test no es definitivo, todavía no está acabado, falta decidir si se puede hacer una prueba o no
	@Test
	void test05_002() {
		/*
		String id = "0002";
		String dni_paciente = "12345678A";
		String fecha = "02/03/2019";
		String hora = "14:00";
		Double maxTemp = 37.5;
		Double minTemp = 36.5;
		Double mediaTemp = 37.0;
		Double q1Temp = 37.1;
		Double q2Temp = 37.1;
		Double q3Temp = 37.1;
		String maxTen = "110";
		String minTen = "110";
		String mediaTen = "110";
		String q1Ten = "110";
		String q2Ten = "110";
		String q3Ten = "110";
		Integer maxFreq = 110;
		Integer minFreq = 110;
		Integer mediaFreq = 110;
		Integer q1Freq = 110;
		Integer q2Freq = 110;
		Integer q3Freq = 110;
		
		Estadistica est = new Estadistica(id, dni_paciente, fecha, hora, maxTemp, minTemp, mediaTemp, q1Temp, q2Temp, q3Temp,
				maxTen, minTen, mediaTen, q1Ten, q2Ten, q3Ten, maxFreq, minFreq, mediaFreq, q1Freq, q2Freq, q3Freq);
		ProcesadorDatos procesador = new ProcesadorDatos();
		
		try {
			procesador.guardarEstadistica(est);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader reader;
		List<String> lines = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader("InfoEstadisticas.csv"));
			String line = null;
			while ((line = reader.readLine()) != null) {
			    lines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean seHaVueltoAEscribir = false;
		
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).equals("0002,12345678A,02/03/2019,14:00,110,110,110,110,110,110,37.5,36.5,37.0,37.1,37.1,37.1,110,110,110,110,110,110")) {
				assertEquals("id,dni,fecha,hora,maxfreq,minfreq,mediafreq,q1freq,q1freq,q2freq,maxtemp,mintemp,mediatemp,q1temp,q2temp,q3temp,maxten,minten,mediaten,q1ten,q2ten,q3ten",
						lines.get(i - 1));
				assertEquals("0002,12345678A,02/03/2019,14:00,110,110,110,110,110,110,37.5,36.5,37.0,37.1,37.1,37.1,110,110,110,110,110,110", lines.get(i));
				assertEquals(seHaVueltoAEscribir, false);
				seHaVueltoAEscribir = true;
			}
		}*/
		}
		
		@Test
		void test05_003() {
			Estadistica estadistica = new Estadistica();
			ProcesadorDatos procesador = new ProcesadorDatos();

			assertThrows(Exception.class, ()->procesador.guardarEstadistica(null));
		}
}
