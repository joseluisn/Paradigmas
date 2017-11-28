package paradigmas_programacion;

import java.util.ArrayList;

public class Grupo {

	 public int codGrupo;
	    private int numEstudiantes;
	    public Profesor profesorGrupo;
	    public ArrayList<RegEstudiante> registros;
	    public Estudiante[] estudiante;
	    public Materia materia;

	    public Grupo(Profesor profesor, Materia materia) {
	        this.profesorGrupo = profesor;
	        this.materia = materia;
	        this.registros = new ArrayList<>();

	        numEstudiantes = 0;

	    }

	    public String toString() {
	        String a = "Materia" + materia.nombreMateria + "Profesor" + profesorGrupo.toString() + "\n";
	        String m = " ";
	        for (int i = 0; i < numEstudiantes; i++) {
	            int j = i + 1;
	            m += "estudiante" + j + ": " + estudiante[i].toString();
	        }
	        return a;
	    }

	 
	    
	    public boolean agregarEstudiante(Estudiante e) {
	        if (this.registros.size() < 0) {

	            System.out.println("Debe haber por lo menos un estudiante");
	        } else if (contieneEstudiante(e) == false) {
	            RegEstudiante reg1 = new RegEstudiante(e);
	            registros.add(reg1);

	        }
	        {
	            return true;
	        }
	    }

	    public boolean contieneEstudiante(Estudiante c) {

	        for (int i = 0; i < numEstudiantes; i++) {
	            if (registros.get(i).equals(c)) {
	                return true;
	            }
	        }
	        return false;
	    }


	   
}
