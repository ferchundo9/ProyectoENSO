package interfaces;

import clases.Paciente;

//Interfaz
public interface DatosPacientes {
	//M�todos
	public void darDeAlta(Paciente paciente);
	public void darDeBaja(String dni_paciente);
	public void modificarDatos(Paciente paciente);
}
