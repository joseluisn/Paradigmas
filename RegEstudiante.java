package paradigmas_programacion;

public class RegEstudiante {

    public Estudiante estudiante;
    public double[] notas;
    
    public RegEstudiante(Estudiante e){
        this.estudiante=e;
        notas= new double[3];
    }
    
    public boolean agregarNota(double n1, double n2, double n3) {
        notas[0] = n1;
        notas[1] = n2;
        notas[2] = n3;
        return true;
    }

    public double nota1() {
        double not1 = notas[0];
        return not1;
    }

    public double nota2() {
        double not2 = notas[1];
        return not2;
    }

    public double nota3() {
        double not3 = notas[2];
        return not3;
    }

    public double calcularnota() {
        double nf = 0;
        for (int i = 0; i < notas.length; i++) {
            nf = nf + notas[i] / 3;
        }
        return nf;
    }

    

}
