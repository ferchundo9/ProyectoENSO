package analisis;

public class Estadisticas {
	private String maximo;
	private String minimo;
	private String media;
	private String cuartiles;
	private String alarmas;
	private String tensionAlarma;
	
	private Estadisticas(String maximo, String minimo, String media, String cuartiles, String alarmas,
			String tensionAlarma) {
		super();
		this.maximo = maximo;
		this.minimo = minimo;
		this.media = media;
		this.cuartiles = cuartiles;
		this.alarmas = alarmas;
		this.tensionAlarma = tensionAlarma;
	}
	
	public String getMaximo() {
		return maximo;
	}
	public void setMaximo(String maximo) {
		this.maximo = maximo;
	}
	public String getMinimo() {
		return minimo;
	}
	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getCuartiles() {
		return cuartiles;
	}
	public void setCuartiles(String cuartiles) {
		this.cuartiles = cuartiles;
	}
	public String getAlarmas() {
		return alarmas;
	}
	public void setAlarmas(String alarmas) {
		this.alarmas = alarmas;
	}
	public String getTensionAlarma() {
		return tensionAlarma;
	}
	public void setTensionAlarma(String tensionAlarma) {
		this.tensionAlarma = tensionAlarma;
	}
	
}
