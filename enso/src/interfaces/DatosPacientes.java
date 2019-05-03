package interfaces;

import clases.Paciente;

//Interfaz
public interface DatosPacientes {
	//Métodos
	public void darDeAlta(Paciente paciente);
	public void darDeBaja(String dni_paciente);
	public void modificarDatos(Paciente paciente);
}
