import java.util.ArrayList;

public class ControladorEstudante {

    // Array de armazenamento de estudantes
    private final ArrayList<Estudante> estudantes;

    // Instanciação de Array de estudantes no construtor
    public ControladorEstudante(){
        estudantes = new ArrayList<Estudante>();
    }

    // Função destinada para adicionar novos estudantes no sistema
    public void adicionarEstudante(Estudante estudante){
        estudantes.add(estudante);
    }

    // Função destinada para remoção de estudantes do sistema
    public void removerEstudante(int matricula){
        estudantes.remove(obterEstudantePorMatricula(matricula));
    }

    // Função destinada para busca de estudantes através do nome
    public Estudante obterEstudantePorNome(String nome){
        for (Estudante valor : estudantes){
            if (valor.getNome().equals(nome)){
                return valor;
            }
        }
        return null;
    }

    // Função destinada para busca de estudantes através da matrícula
    public Estudante obterEstudantePorMatricula(int matricula){
        for (Estudante valor : estudantes){
            if (valor.getMatricula() == matricula){
                return valor;
            }
        }
        return null;
    }

    // Função destinada a retornar o Array de estudantes
    public ArrayList<Estudante> listarTodosEstudantes() {
        return estudantes;
    }

}
