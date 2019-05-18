package clases;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import interfaces.Alarmas;
import interfaces.DatosInstantaneos;
import interfaces.Estadisticas;

public class ProcesadorDatos implements DatosInstantaneos, Alarmas, Estadisticas {
	// Atributos
	List<Alarma> alarmas;
	List<Estadistica> estadisticas;

	// Añadir interfaz datos instantaneos
	// Constructor
	public ProcesadorDatos() {
		this.alarmas = new ArrayList<Alarma>();
		this.alarmas = this.leeralarmas();
		this.estadisticas = new ArrayList<Estadistica>();
		this.estadisticas = this.leerestadisticas();
	}

	// Getters setters
	public List<Alarma> getAlarmas() {
		return alarmas;
	}

	public void setAlarmas(List<Alarma> alarmas) {
		this.alarmas = alarmas;
	}

	public List<Estadistica> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(List<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	// Métodos
	public void calcularEstadisticas(Paciente paciente) {
		//

	}

	public void detectarAlarma(Paciente paciente) {
		//
		String gravedad = "sin datos";
		for (int i = 0; i < paciente.getDatospacientes().size(); i++) {
			if (paciente.getDatospacientes().get(i).getTemperatura() < 33
					|| paciente.getDatospacientes().get(i).getTemperatura() > 37
					|| paciente.getDatospacientes().get(i).getFrecuenciaCardiaca() < 50
					|| paciente.getDatospacientes().get(i).getFrecuenciaCardiaca() > 100) {
				gravedad = "leve";
			}
			if (paciente.getDatospacientes().get(i).getTemperatura() < 31
					|| paciente.getDatospacientes().get(i).getTemperatura() > 39
					|| paciente.getDatospacientes().get(i).getFrecuenciaCardiaca() < 40
					|| paciente.getDatospacientes().get(i).getFrecuenciaCardiaca() > 120) {
				gravedad = "moderada";
			}
			if (paciente.getDatospacientes().get(i).getTemperatura() < 29
					|| paciente.getDatospacientes().get(i).getTemperatura() > 42
					|| paciente.getDatospacientes().get(i).getFrecuenciaCardiaca() < 30
					|| paciente.getDatospacientes().get(i).getFrecuenciaCardiaca() > 150) {
				gravedad = "grave";
			}
		}
		// Hora
		Calendar calendario = Calendar.getInstance();
		Calendar fecha = new GregorianCalendar();
		int hora, minutos, segundos;
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		String lahora = hora + "/" + minutos;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int mes = fecha.get(Calendar.MONTH);
		int ano = fecha.get(Calendar.YEAR);
		String cadenafecha = dia + "/" + mes + "/" + ano;
		try {
			// Abro o archivo
			CsvWriter writer = new CsvWriter(new FileWriter("InfoAlarmas.csv", true), ',');
			writer.write("dni");
			writer.write("fecha");
			writer.write("hora");
			writer.write("gravedad");
			writer.endRecord(); // linea

			//
			writer.write(paciente.getDNI());
			writer.write(cadenafecha);
			writer.write(lahora);
			writer.write(gravedad);

			writer.endRecord(); // linea

			writer.close(); // Cerra o archivo
			System.out.println("Alarma detectada con éxito");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

	}

	@Override
	public List<Estadistica> enviarEstadisticas(String dni_paciente, String fechaInicio, String fechaFin) {
		ArrayList<Estadistica> vector = new ArrayList<Estadistica>();
		try {
			CsvReader leer = new CsvReader("InfoEstadisticas.csv");
			leer.readHeaders();
			while (leer.readRecord()) {
				String id = leer.get(0);
				String dni = leer.get(1);
				String fecha = leer.get(2);
				String hora = leer.get(3);
				Integer Maxfreq = Integer.parseInt(leer.get(4));
				Integer MinFreq = Integer.parseInt(leer.get(5));
				Integer MediaFreq = Integer.parseInt(leer.get(6));
				Integer Q1Freq = Integer.parseInt(leer.get(7));
				Integer Q2Freq = Integer.parseInt(leer.get(8));
				Integer Q3Freq = Integer.parseInt(leer.get(9));
				Double MaxTemp = Double.parseDouble(leer.get(10));
				Double MinTemp = Double.parseDouble(leer.get(11));
				Double MediaTemp = Double.parseDouble(leer.get(12));
				Double Q1Temp = Double.parseDouble(leer.get(13));
				Double Q2Temp = Double.parseDouble(leer.get(14));
				Double Q3Temp = Double.parseDouble(leer.get(15));
				String MaxTen = leer.get(16);
				String MinTen = leer.get(17);
				String MediaTen = leer.get(18);
				String Q1Ten = leer.get(19);
				String Q2Ten = leer.get(20);
				String Q3Ten = leer.get(21);
				String[] partsfechaInicio = fechaInicio.split(":");
				String[] partsfechaFin = fechaFin.split(":");
				String[] partsfecha = fecha.split(":");
				if ((dni_paciente.equals(dni))) {
					if (((Integer.parseInt(partsfecha[2]) == Integer.parseInt(partsfechaInicio[2])
							&& Integer.parseInt(partsfecha[2]) == Integer.parseInt(partsfechaFin[2])
							&& Integer.parseInt(partsfecha[1]) > Integer.parseInt(partsfechaInicio[1])
							&& Integer.parseInt(partsfecha[1]) < Integer.parseInt(partsfechaFin[1]))
							|| (Integer.parseInt(partsfecha[2]) == Integer.parseInt(partsfechaInicio[2])
									&& Integer.parseInt(partsfecha[2]) == Integer.parseInt(partsfechaFin[2])
									&& Integer.parseInt(partsfecha[1]) == Integer.parseInt(partsfechaFin[1])
									&& Integer.parseInt(partsfecha[1]) >= Integer.parseInt(partsfechaInicio[1])
									&& Integer.parseInt(partsfecha[0]) > Integer.parseInt(partsfechaFin[0])))) {
						vector.add(new Estadistica(id, dni, fecha, hora, MaxTemp, MinTemp, MediaTemp, Q1Temp, Q2Temp,
								Q3Temp, MaxTen, MinTen, MediaTen, Q1Ten, Q2Ten, Q3Ten, Maxfreq, MinFreq, MediaFreq,
								Q1Freq, Q2Freq, Q3Freq));
					} else if ((Integer.parseInt(partsfecha[2]) == Integer.parseInt(partsfechaInicio[2])
							&& Integer.parseInt(partsfecha[2]) == Integer.parseInt(partsfechaFin[2])
							&& Integer.parseInt(partsfecha[1]) == Integer.parseInt(partsfechaInicio[1])
							&& Integer.parseInt(partsfecha[1]) <= Integer.parseInt(partsfechaFin[1])
							&& Integer.parseInt(partsfecha[0]) > Integer.parseInt(partsfechaInicio[0]))) {
						vector.add(new Estadistica(id, dni, fecha, hora, MaxTemp, MinTemp, MediaTemp, Q1Temp, Q2Temp,
								Q3Temp, MaxTen, MinTen, MediaTen, Q1Ten, Q2Ten, Q3Ten, Maxfreq, MinFreq, MediaFreq,
								Q1Freq, Q2Freq, Q3Freq));
					}
				}
			}
			leer.close(); // Cerrase o archivo
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
		return (vector);
	}

	@Override
	public void guardarEstadistica(Estadistica estadis) throws IOException {
		// TODO Auto-generated method stub
		try {
			// Abro o archivo
			CsvWriter writer = new CsvWriter(new FileWriter("InfoEstadisticas.csv", true), ',');
			writer.write("id");
			writer.write("dni");
			writer.write("fecha");
			writer.write("hora");
			writer.write("maxfreq");
			writer.write("minfreq");
			writer.write("mediafreq");
			writer.write("q1freq");
			writer.write("q1freq");
			writer.write("q2freq");
			writer.write("maxtemp");
			writer.write("mintemp");
			writer.write("mediatemp");
			writer.write("q1temp");
			writer.write("q2temp");
			writer.write("q3temp");
			writer.write("maxten");
			writer.write("minten");
			writer.write("mediaten");
			writer.write("q1ten");
			writer.write("q2ten");
			writer.write("q3ten");

			writer.endRecord(); // Deixaa de escribir no archivo

			//
			writer.write(estadis.getIdxEstadistic());
			writer.write(estadis.getDni_paciente());
			writer.write(estadis.getFecha());
			writer.write(estadis.getHora());
			writer.write(String.valueOf(estadis.getMaxFreq()));
			writer.write(String.valueOf(estadis.getMinFreq()));
			writer.write(String.valueOf(estadis.getMediaFreq()));
			writer.write(String.valueOf(estadis.getQ1Freq()));
			writer.write(String.valueOf(estadis.getQ2Freq()));
			writer.write(String.valueOf(estadis.getQ3Freq()));
			writer.write(String.valueOf(estadis.getMaxTemp()));
			writer.write(String.valueOf(estadis.getMinTemp()));
			writer.write(String.valueOf(estadis.getMediaTemp()));
			writer.write(String.valueOf(estadis.getQ1Temp()));
			writer.write(String.valueOf(estadis.getQ2Temp()));
			writer.write(String.valueOf(estadis.getQ3Temp()));
			writer.write(estadis.getMaxTen());
			writer.write(estadis.getMinTen());
			writer.write(estadis.getMediaTen());
			writer.write(estadis.getQ1Ten());
			writer.write(estadis.getQ2Ten());
			writer.write(estadis.getQ3Ten());

			writer.endRecord(); // linea

			writer.close(); // Cerra o archivo
			System.out.println("Estadística guardada con éxito");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

	}

	@Override
	public List<Alarma> enviarAlarmasActivas(String dni_paciente) {
		// TODO Auto-generated method stub
		ArrayList<Alarma> vector = new ArrayList<Alarma>();

		try {
			CsvReader leer = new CsvReader("InfoAlarmas.csv");
			leer.readHeaders();
			while (leer.readRecord()) {
				if (leer.get(0).equals(dni_paciente)) {
					vector.add(new Alarma(leer.get(0), leer.get(2), leer.get(3)));
				}
			}
			leer.close();

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
		return (vector);
	}

	@Override
	public void recibirDatos(Paciente paciente) {
		// TODO Auto-generated method stub
		// Chamo a detectar alarmas con ese paciente pa que comprobe se hai algunha
		this.detectarAlarma(paciente);

	}

	// recuperanse as alarmas do archivo para metelas en un array
	public ArrayList<Alarma> leeralarmas() {
		ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
		try {

			CsvReader leer = new CsvReader("InfoAlarmas.csv");
			leer.readHeaders();

			// Mentras haxa lineas obtemos os datos do archivo
			while (leer.readRecord()) {
				String dni = leer.get(0);
				String fecha = leer.get(1);
				String hora = leer.get(2);
				String gravedad = leer.get(3);

				alarmas.add(new Alarma(dni, hora, gravedad));
			}

			leer.close(); // Cerrase o archivo

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

		return (alarmas);
	}

	// recuperanse as estadisticas do archivo para metelas en un array
	public ArrayList<Estadistica> leerestadisticas() {
		ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
		try {

			CsvReader leer = new CsvReader("InfoEstadisticas.csv");
			leer.readHeaders();

			// Mentras haxa lineas obtemos os datos do archivo
			while (leer.readRecord()) {
				String id = leer.get(0);
				String dni = leer.get(1);
				String fecha = leer.get(2);
				String hora = leer.get(3);
				Integer Maxfreq = Integer.parseInt(leer.get(4));
				Integer MinFreq = Integer.parseInt(leer.get(5));
				Integer MediaFreq = Integer.parseInt(leer.get(6));
				Integer Q1Freq = Integer.parseInt(leer.get(7));
				Integer Q2Freq = Integer.parseInt(leer.get(8));
				Integer Q3Freq = Integer.parseInt(leer.get(9));
				Double MaxTemp = Double.parseDouble(leer.get(10));
				Double MinTemp = Double.parseDouble(leer.get(11));
				Double MediaTemp = Double.parseDouble(leer.get(12));
				Double Q1Temp = Double.parseDouble(leer.get(13));
				Double Q2Temp = Double.parseDouble(leer.get(14));
				Double Q3Temp = Double.parseDouble(leer.get(15));
				String MaxTen = leer.get(16);
				String MinTen = leer.get(17);
				String MediaTen = leer.get(18);
				String Q1Ten = leer.get(19);
				String Q2Ten = leer.get(20);
				String Q3Ten = leer.get(21);

				estadisticas.add(new Estadistica(id, dni, fecha, hora, MaxTemp, MinTemp, MediaTemp, Q1Temp, Q2Temp,
						Q3Temp, MaxTen, MinTen, MediaTen, Q1Ten, Q2Ten, Q3Ten, Maxfreq, MinFreq, MediaFreq, Q1Freq,
						Q2Freq, Q3Freq));
			}

			leer.close(); // Cerrase o archivo

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

		return (estadisticas);
	}

}
