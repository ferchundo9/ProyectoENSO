package gestionPacientes;

import java.util.HashMap;

public interface InterfazDatosPacientes {
	public Paciente registarPaciente(String nombre,String apellidos,String FechaNacimiento,String Descripcion);
	public void EliminarPaciente(String id);
	public void ModificarPaciente(String nombreViejo,String nombreNuevo,String apellidos,String FechaNacimiento,String Descripcion);
}
