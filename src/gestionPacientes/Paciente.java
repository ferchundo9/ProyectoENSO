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
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
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
