package interfaces;

import java.util.List;
import clases.Alarma;

//Interfaz
public interface Alarmas {
	//M�todos
	public List<Alarma> enviarAlarmasActivas(String dni_paciente);
}
