package sensorizacion;

public class DatosVitales {
	public double FC;
	public double Temperatura;
	
	private DatosVitales(double fC, double temperatura) {
		super();
		FC = fC;
		Temperatura = temperatura;
	}
	
	public double getFC() {
		return FC;
	}
	public void setFC(double fC) {
		FC = fC;
	}
	public double getTemperatura() {
		return Temperatura;
	}
	public void setTemperatura(double temperatura) {
		Temperatura = temperatura;
	}
	
}
