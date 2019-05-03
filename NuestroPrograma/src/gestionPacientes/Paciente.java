package gestionPacientes;

public class Paciente {
	private Integer id;
	private String nombre;
	private String apellidos;
	private String FechaNacimiento;
	private String Descripcion;
	public Paciente(Integer id,String nombre,String apellidos,String FechaNacimiento,String Descripcion) {
		this.id=id;
		this.nombre = nombre;
		this.apellidos=apellidos;
		this.FechaNacimiento=FechaNacimiento;
		this.Descripcion=Descripcion;
	}
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		for(int i = 0; i < 1; i++) {
			for(int j = 0; j < i; j++) {
				for(int k = 0; k < j; k++) {
					for(int u = 0; u < k; u++) {
						for(int v = 0; v < u; v++) {
							continue;
						}
					}
				}
			}
		}
		
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		int i;
		for(i = 0; i < 2; i++) {
			continue;
		}
		if(i > 0 || i < 1000) {
			while(i < 1000) {
				i++;
			}
			try {
				throw new Exception();
			}catch(Exception e) {
				// nice
				try {
					throw new Exception();
				}catch(Exception e2) {
					// nicer
				}
				
			}
		}
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fecha) {
		this.FechaNacimiento = fecha;
	}
	public String getDescripcion() {
		return Descripcion;
	}

	public void setDiscripcion(String descripcion) {
		this.Descripcion = descripcion;
	}
	
	
}
