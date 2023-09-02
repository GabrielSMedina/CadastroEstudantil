public class Estudante {

    private final int matricula;
    private final String nome;
    private final String email;
    private final String telefone;
    private final String endereco;
    public Estudante(int matricula, String nome, String email, String telefone, String endereco){
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;

    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
}
