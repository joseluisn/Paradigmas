package paradigmas_programacion;

public class Profesor {
	public String primerNombre;
	public String segundoNombre;
	public String primerApellido;
	public String segundoApellido;
	public long numIdentificacion;

	public Profesor(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;

	}

	public String toString() {
		String a = "Nombres:" + primerNombre + " " + segundoNombre + " Apellidos:" + primerApellido + " "
				+ segundoApellido;

		return a;
	}
}
