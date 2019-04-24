package analisis;

public class Estadisticas {
	private String maximo;
	private String minimo;
	private String media;
	private String cuartiles;
	private String alarmasFC;
	private String alarmasTem;
	private String tensionAlarmaFC;
	private String tensionAlarmaTem;
	
	public Estadisticas(String maximo, String minimo, String media, String cuartiles, String alarmasFC,
			String alarmasTem,String tensionAlarmaFC,String tensionAlarmaTem) {
		this.maximo = maximo;
		this.minimo = minimo;
		this.media = media;
		this.cuartiles = cuartiles;
		this.alarmasFC = alarmasFC;
		this.alarmasTem = alarmasTem;
		this.tensionAlarmaFC = tensionAlarmaFC;
		this.tensionAlarmaTem = tensionAlarmaTem;
	}
	public Estadisticas(Estadisticas estadistica){
		this.maximo = estadistica.getMaximo();
		this.minimo = estadistica.getMinimo();
		this.media = estadistica.getMedia();
		this.cuartiles = estadistica.getCuartiles();
		this.alarmasFC = estadistica.getAlarmasFC();
		this.tensionAlarmaFC = estadistica.getTensionAlarmaFC();
		this.tensionAlarmaTem = estadistica.getTensionAlarmaTem();
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
	public String getAlarmasFC() {
		return alarmasFC;
	}
	public void setAlarmasFC(String alarmasFC) {
		this.alarmasFC = alarmasFC;
	}
	public String getAlarmasTem() {
		return alarmasTem;
	}
	public void setAlarmasTem(String alarmasTem) {
		this.alarmasTem = alarmasFC;
	}
	public String getTensionAlarmaFC() {
		return tensionAlarmaFC;
	}
	public void setTensionAlarmaFC(String tensionAlarmaFC) {
		this.tensionAlarmaFC = tensionAlarmaFC;
	}
	public String getTensionAlarmaTem() {
		return tensionAlarmaTem;
	}
	public void setTensionAlarmaTem(String tensionAlarmaTem) {
		this.tensionAlarmaTem = tensionAlarmaTem;
	}
	
}
