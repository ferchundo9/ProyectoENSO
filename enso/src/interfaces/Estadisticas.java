package interfaces;

import java.io.IOException;
import java.util.List;
import clases.Estadistica;

//Interfaz
public interface Estadisticas {
	//Métodos
	public List<Estadistica> enviarEstadisticas(String dni_paciente, String fechaInicio, String fechaFin);
	public void guardarEstadistica(Estadistica estadis) throws IOException;
	
}
