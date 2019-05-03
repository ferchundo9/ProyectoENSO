package clases;

import java.util.ArrayList;
import java.util.List;

//Estadistica
public class Estadistica {
	//Atributos
	String idxEstadistic;
	String dni_paciente;
	String fecha;
	String hora;
	Double maxTemp;
	Double minTemp;
	Double mediaTemp;
	Double q1Temp;
	Double q2Temp;
	Double q3Temp;
	String maxTen;
	String minTen;
	String mediaTen;
	String q1Ten;
	String q2Ten;
	String q3Ten;
	Integer maxFreq;
	Integer minFreq;
	Integer mediaFreq;
	Integer q1Freq;
	Integer q2Freq;
	Integer q3Freq;
	//Constructores
	public Estadistica() {
		super();
		this.idxEstadistic= new String();
		this.dni_paciente= new String();
		this.fecha = new String();
		this.hora = new String();
		this.maxTemp = new Double(0.0);
		this.minTemp = new Double(0.0);
		this.mediaTemp = new Double(0.0);
		this.q1Temp = new Double(0.0);
		this.q2Temp = new Double(0.0);
		this.q3Temp = new Double(0.0);
		this.maxTen = new String();
		this.minTen = new String();
		this.mediaTen = new String();
		this.q1Ten = new String();
		this.q2Ten = new String();
		this.q3Ten = new String();
		this.maxFreq = new Integer(0);
		this.minFreq = new Integer(0);
		this.mediaFreq = new Integer(0);
		this.q1Freq = new Integer(0);
		this.q2Freq = new Integer(0);
		this.q3Freq = new Integer(0);
	}
	public Estadistica(String idxEstadistic, String dni_paciente, String fecha, String hora, Double maxTemp,
			Double minTemp, Double mediaTemp, Double q1Temp, Double q2Temp, Double q3Temp, String maxTen, String minTen,
			String mediaTen, String q1Ten, String q2Ten, String q3Ten, Integer maxFreq, Integer minFreq,
			Integer mediaFreq, Integer q1Freq, Integer q2Freq, Integer q3Freq) {
		super();
		this.idxEstadistic = idxEstadistic;
		this.dni_paciente = dni_paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.mediaTemp = mediaTemp;
		this.q1Temp = q1Temp;
		this.q2Temp = q2Temp;
		this.q3Temp = q3Temp;
		this.maxTen = maxTen;
		this.minTen = minTen;
		this.mediaTen = mediaTen;
		this.q1Ten = q1Ten;
		this.q2Ten = q2Ten;
		this.q3Ten = q3Ten;
		this.maxFreq = maxFreq;
		this.minFreq = minFreq;
		this.mediaFreq = mediaFreq;
		this.q1Freq = q1Freq;
		this.q2Freq = q2Freq;
		this.q3Freq = q3Freq;
	}
	//Getters setters
	public String getIdxEstadistic() {
		return idxEstadistic;
	}
	public void setIdxEstadistic(String idxEstadistic) {
		this.idxEstadistic = idxEstadistic;
	}
	public String getDni_paciente() {
		return dni_paciente;
	}
	public void setDni_paciente(String dni_paciente) {
		this.dni_paciente = dni_paciente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public Double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}
	public Double getMediaTemp() {
		return mediaTemp;
	}
	public void setMediaTemp(Double mediaTemp) {
		this.mediaTemp = mediaTemp;
	}
	public Double getQ1Temp() {
		return q1Temp;
	}
	public void setQ1Temp(Double q1Temp) {
		this.q1Temp = q1Temp;
	}
	public Double getQ2Temp() {
		return q2Temp;
	}
	public void setQ2Temp(Double q2Temp) {
		this.q2Temp = q2Temp;
	}
	public Double getQ3Temp() {
		return q3Temp;
	}
	public void setQ3Temp(Double q3Temp) {
		this.q3Temp = q3Temp;
	}
	public String getMaxTen() {
		return maxTen;
	}
	public void setMaxTen(String maxTen) {
		this.maxTen = maxTen;
	}
	public String getMinTen() {
		return minTen;
	}
	public void setMinTen(String minTen) {
		this.minTen = minTen;
	}
	public String getMediaTen() {
		return mediaTen;
	}
	public void setMediaTen(String mediaTen) {
		this.mediaTen = mediaTen;
	}
	public String getQ1Ten() {
		return q1Ten;
	}
	public void setQ1Ten(String q1Ten) {
		this.q1Ten = q1Ten;
	}
	public String getQ2Ten() {
		return q2Ten;
	}
	public void setQ2Ten(String q2Ten) {
		this.q2Ten = q2Ten;
	}
	public String getQ3Ten() {
		return q3Ten;
	}
	public void setQ3Ten(String q3Ten) {
		this.q3Ten = q3Ten;
	}
	public Integer getMaxFreq() {
		return maxFreq;
	}
	public void setMaxFreq(Integer maxFreq) {
		this.maxFreq = maxFreq;
	}
	public Integer getMinFreq() {
		return minFreq;
	}
	public void setMinFreq(Integer minFreq) {
		this.minFreq = minFreq;
	}
	public Integer getMediaFreq() {
		return mediaFreq;
	}
	public void setMediaFreq(Integer mediaFreq) {
		this.mediaFreq = mediaFreq;
	}
	public Integer getQ1Freq() {
		return q1Freq;
	}
	public void setQ1Freq(Integer q1Freq) {
		this.q1Freq = q1Freq;
	}
	public Integer getQ2Freq() {
		return q2Freq;
	}
	public void setQ2Freq(Integer q2Freq) {
		this.q2Freq = q2Freq;
	}
	public Integer getQ3Freq() {
		return q3Freq;
	}
	public void setQ3Freq(Integer q3Freq) {
		this.q3Freq = q3Freq;
	}
	
	
	
	
	
}
