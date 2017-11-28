package paradigmas_programacion;

public class Materia {
	public String codMateria;
	public String nombreMateria;
	public Grupo[] grupo;
	public Profesor[] profesor;
	public Estudiante[] estudiante;

	public Materia(String codMateria, String nombreMateria) {
		this.codMateria = codMateria;
		this.nombreMateria = nombreMateria;
	}
}
