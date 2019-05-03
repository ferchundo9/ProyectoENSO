package interfaces;

import java.util.List;
import clases.Alarma;

//Interfaz
public interface Alarmas {
	//Métodos
	public List<Alarma> enviarAlarmasActivas(String dni_paciente);
}
