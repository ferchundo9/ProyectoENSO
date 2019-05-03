package almacenDatos;

import java.util.ArrayList;
import java.util.HashMap;
import sensorizacion.DatosVitales;

public interface InterfazDatosSimulados {
	public void EnviarDatos(HashMap<String, DatosVitales> datos);
}
