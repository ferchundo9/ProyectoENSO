package interfaces;

import java.util.List;
import clases.DatosPaciente;

//Interfaz
public interface SeriesTemporales {
	//M�todos
	public List<DatosPaciente> enviarDatos(String horaInicio, String horaFin, String dni_paciente );
	
}
