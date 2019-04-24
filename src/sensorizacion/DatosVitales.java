package sensorizacion;

public class DatosVitales {
	private Double FC;
	private Double Temperatura;
	
	public DatosVitales(double fC, double temperatura) {
		this.FC = fC;
		this.Temperatura = temperatura;
	}
	
	public Double getFC() {
		return FC;
	}
	public void setFC(Double fC) {
		FC = fC;
	}
	public Double getTemperatura() {
		return Temperatura;
	}
	public void setTemperatura(Double temperatura) {
		Temperatura = temperatura;
	}
	
}
