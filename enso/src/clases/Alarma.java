package clases;

//Alarma
public class Alarma {
	//Atributos
	String dniPaciente;
	String Hora;
	String Gravedad;
	//Constructores
	public Alarma() {
		this.dniPaciente = new String();
		this.Hora = new String();
		this.Gravedad = new String();
	}
	public Alarma(String dniPaciente, String hora, String gravedad) {
		this.dniPaciente = dniPaciente;
		this.Hora = hora;
		this.Gravedad = gravedad;
	}
	//Getters Setters
	public String getDniPaciente() {
		return dniPaciente;
	}
	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	public String getGravedad() {
		return Gravedad;
	}
	public void setGravedad(String gravedad) {
		Gravedad = gravedad;
	}
	
}
