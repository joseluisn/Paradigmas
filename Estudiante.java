package paradigmas_programacion;

import java.text.SimpleDateFormat;

public class Estudiante {
	public String nombre;
	private long numIdentificacion;
	public String estadoCivil;
	
	public Estudiante() {
		
	}

	public Estudiante(String nombres, long numIdentificacion) {
		this.nombre = nombres;
		this.numIdentificacion = numIdentificacion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(long numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		// String p=formater.format(fechaDeNacimiento);
		String a = "Nombres:" + nombre + " " + "Identificacion:" + getNumIdentificacion() + " " + " Estado civil "
				+ estadoCivil + " ";

		return a;
	}

}
