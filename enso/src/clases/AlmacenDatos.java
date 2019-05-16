package clases;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import com.csvreader.*;

import interfaces.DatosInstantaneos;
import interfaces.DatosSimulados;
import interfaces.SeriesTemporales;

public class AlmacenDatos implements DatosSimulados, SeriesTemporales {
	// Atributos
	DatosInstantaneos procesador;

	// Constructor
	public AlmacenDatos() {
		this.procesador = new ProcesadorDatos();
	}

	// Getters e setters
	public DatosInstantaneos getProcesador() {
		return procesador;
	}

	public void setProcesador(DatosInstantaneos procesador) {
		this.procesador = procesador;
	}

	// Métodos
	public void guardarDatos(Paciente paciente) throws IOException {
		String archCSV = "InfoSensores.csv";
		try {
			// archivo
			CsvWriter writer = new CsvWriter(new FileWriter(archCSV, true), ',');
			writer.write("dni");
			writer.write("fecha");
			writer.write("hora");
			writer.write("tension");
			writer.write("frecuencia cardiaca");
			writer.write("temperatura");
			// Siguiente linea
			writer.endRecord();

			// fecha
			Calendar fecha = new GregorianCalendar();
			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			int mes = fecha.get(Calendar.MONTH);
			int ano = fecha.get(Calendar.YEAR);
			String cadenafecha = dia + "/" + mes + "/" + ano;
			for (int i = 0; i < paciente.getDatospacientes().size(); i++) {
				// Escribese no archivo os datos dos sensores do paciente
				writer.write(paciente.getDNI());
				writer.write(cadenafecha);
				writer.write(paciente.getDatospacientes().get(i).getHora());
				writer.write(paciente.getDatospacientes().get(i).getTension());
				writer.write(String.valueOf(paciente.getDatospacientes().get(i).getFrecuenciaCardiaca()));
				writer.write(String.valueOf(paciente.getDatospacientes().get(i).getTemperatura()));

				// Siguiente linea
				writer.endRecord();
			}

			// Cerrase o archivo
			writer.close();
			System.out.println("Datos guardados");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

	}

	@Override
	public List<DatosPaciente> enviarDatos(String horaInicio, String horaFin, String dni_paciente) {
		// TODO Auto-generated method stub
		ArrayList<DatosPaciente> datos = new ArrayList<DatosPaciente>();
		// Leese o ficheiro csv de sensores
		try {
			CsvReader leer = new CsvReader("InfoSensores.csv");
			leer.readHeaders();
			// Mentras haxa lineas obtemos os datos
			while (leer.readRecord()) {

				String dni = leer.get(0);
				String dia = leer.get(1);
				String hora = leer.get(2);
				String tension = leer.get(3);
				String frecuencia = leer.get(4);
				String temperatura = leer.get(5);
				// horas hh:mm
				String[] partshoraInicio = horaInicio.split(":");
				String[] partshoraFin = horaFin.split(":");
				String[] partshora = hora.split(":");
				// Se o dni coincide e está entre esas horas
				if ((dni_paciente.equals(dni))) {
					if (((Integer.parseInt(partshora[0]) > Integer.parseInt(partshoraInicio[0])
							&& Integer.parseInt(partshora[0]) < Integer.parseInt(partshoraFin[0]))							
							|| (Integer.parseInt(partshora[0]) == Integer.parseInt(partshoraFin[0])
									&& Integer.parseInt(partshora[1]) < Integer.parseInt(partshoraFin[1])
									&& Integer.parseInt(partshora[0]) > Integer.parseInt(partshoraInicio[0]))
							|| (Integer.parseInt(partshora[0]) == Integer.parseInt(partshoraInicio[0])
									&& Integer.parseInt(partshora[1]) > Integer.parseInt(partshoraInicio[1])
									&& Integer.parseInt(partshora[0]) == Integer.parseInt(partshoraFin[0])
									&& Integer.parseInt(partshora[1]) < Integer.parseInt(partshoraFin[1])))) {
						datos.add(new DatosPaciente(Integer.parseInt(frecuencia), Double.parseDouble(temperatura),
								tension, hora));
						System.out.println("enviarDatos realizado");
					}else if((Integer.parseInt(partshora[0]) == Integer.parseInt(partshoraInicio[0])
							&& Integer.parseInt(partshora[1]) > Integer.parseInt(partshoraInicio[1])
							&& Integer.parseInt(partshora[0]) < Integer.parseInt(partshoraFin[0]))) {
						datos.add(new DatosPaciente(Integer.parseInt(frecuencia), Double.parseDouble(temperatura),
								tension, hora));
						System.out.println("enviarDatos realizado");
					}
					else if(dni=="-1"){
						System.out.println("Algo");
					}
					else {
						System.out.println("Algo");
					}

				}
			}

			leer.close(); // Cerra o archivo

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

		return (datos);
	}

	@Override
	public void recibirDatos(Paciente paciente) {
		// TODO Auto-generated method stub
		// Chamase a gardar
		try {
			this.guardarDatos(paciente);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception " + e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception " + e);
		}
		// E chamase a recibir datos de datos instantaneos que fai procesador datos
		this.procesador.recibirDatos(paciente);
	}
}
