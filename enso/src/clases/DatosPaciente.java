package clases;

//Datos do paciente
public class DatosPaciente {
	//Atributos
	Integer FrecuenciaCardiaca;
	Double Temperatura;
	String tension;
	String Hora;
	//Constructores
	public DatosPaciente() {
		this.FrecuenciaCardiaca = new Integer(0);
		this.Temperatura = new Double(0.0);
		this.tension = new String();
		this.Hora = new String();
	}
	public DatosPaciente(Integer frecuenciaCardiaca, Double temperatura, String tension, String hora) {
		this.FrecuenciaCardiaca = frecuenciaCardiaca;
		this.Temperatura = temperatura;
		this.tension = tension;
		this.Hora = hora;
	}
	//Getters setters
	public Integer getFrecuenciaCardiaca() {
		return FrecuenciaCardiaca;
	}
	public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
		FrecuenciaCardiaca = frecuenciaCardiaca;
	}
	public Double getTemperatura() {
		return Temperatura;
	}
	public void setTemperatura(Double temperatura) {
		Temperatura = temperatura;
	}
	public String getTension() {
		return tension;
	}
	public void setTension(String tension) {
		this.tension = tension;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	
	
}
