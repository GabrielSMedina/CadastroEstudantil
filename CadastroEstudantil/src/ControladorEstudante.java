import java.util.ArrayList;

public class ControladorEstudante {

    private final ArrayList<Estudante> estudantes;

    public ControladorEstudante(){
        estudantes = new ArrayList<Estudante>();
    }

    public void adicionarEstudante(Estudante estudante){
        estudantes.add(estudante);
    }

    public void removerEstudante(int matricula){
        estudantes.remove(obterEstudantePorMatricula(matricula));
    }

    public Estudante obterEstudantePorNome(String nome){
        return null;
    }

    public Estudante obterEstudantePorMatricula(int matricula){
        for (Estudante valor : estudantes){
            if (valor.getMatricula() == matricula){
                return valor;
            }
        }
        return null;
    }

    public ArrayList<Estudante> listarTodosEstudantes() {
        return estudantes;
    }

}
