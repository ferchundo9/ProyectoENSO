package analisis;

import java.util.HashMap;

import sensorizacion.DatosVitales;

public interface InterfazDatosInstantaneos {
	public void EnviarDatosInstantaneos(HashMap<String, DatosVitales> datos);
}
