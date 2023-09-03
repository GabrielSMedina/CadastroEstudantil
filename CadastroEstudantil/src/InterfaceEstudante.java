import java.util.Scanner;

public class InterfaceEstudante {

    private final Scanner scanner;
    private final ControladorEstudante controladorEstudante;

    public InterfaceEstudante(){
        scanner = new Scanner(System.in);
        controladorEstudante = new ControladorEstudante();
    }

    // Bloco loop de execução
    public void executar(){
        int opcao;

        do {
            opcao = capturarOpcoes();

        // Chamada das funções seguindo a escolha do usuario
            switch (opcao) {
                case 1 -> adicionarEstudante();

                case 2 -> removerEstudante();

                case 3 -> obterEstudantePorNome();

                case 4 -> obterEstudantePorMatricula();

                case 5 -> exibirEstudantes();

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção invalida! \n");
            }
        } while (opcao != 0);
    }

    // Exibição do texto e captura de opção
    private int capturarOpcoes(){
        System.out.println("""
                Selecione a opção:\s
                1- Adicionar
                2- Remover
                3- Buscar por nome
                4- Buscar por matrícula
                5- Listar todos estudantes
                0- sair
                Opção:\s""");

        return scanner.nextInt();
    }

    private void adicionarEstudante(){
        int matricula;
        String nome, email, telefone, endereco;

        System.out.println("Informe os seguintes dados:");
        System.out.println("Matrícula: ");
        matricula = scanner.nextInt();
        System.out.println("Nome(separado por _): ");
        nome = scanner.next();
        System.out.println("Email: ");
        email = scanner.next();
        System.out.println("Telefone: ");
        telefone = scanner.next();
        System.out.println("Endereço: ");
        endereco = scanner.next();

        // Instanciando um estudante para manda-lo para o controlador
        Estudante estudante = new Estudante(matricula, nome, email, telefone, endereco);
        controladorEstudante.adicionarEstudante(estudante);
    }

    private void removerEstudante(){
        System.out.println("Informe a matricula para efetuar a remoção:");
        System.out.println("Matrícula: ");

        // Chamando função de remoção e passando parametro informado pelo usuario
        controladorEstudante.removerEstudante(scanner.nextInt());
    }

    private void obterEstudantePorNome(){
        System.out.println("Informe o nome do estudante desejado: ");
        System.out.println("Nome: ");
        Estudante estudante = controladorEstudante.obterEstudantePorNome(scanner.next());

        // Verificando existencia do estudante
        if (estudante != null){
            formataStringDadosEstudante(estudante);
        }else{
            System.out.println("Estudante Inexistente!");
        }
    }

    private void obterEstudantePorMatricula(){
        System.out.println("Informe a matrícula do estudante desejado: ");
        System.out.println("Matrícula: ");
        Estudante estudante = controladorEstudante.obterEstudantePorMatricula(scanner.nextInt());

        // Verificando existencia do estudante
        if (estudante != null){
            formataStringDadosEstudante(estudante);
        }else{
            System.out.println("Estudante Inexistente!");
        }
    }

    private void exibirEstudantes(){
        System.out.println("Listando Estudantes...\n-------------------------------------");

        // Listando TODOS os estudantes cadastrados no sistema
        for (Estudante estudante : controladorEstudante.listarTodosEstudantes()){
            formataStringDadosEstudante(estudante);
            System.out.println("-------------------------------------");
        }
        System.out.println("\n\n");
    }

    // Funçao destinada a formatação do texto de informações do aluno
    private void formataStringDadosEstudante(Estudante estudante){
        System.out.println("\nNome: " + estudante.getNome() +
                "\nMatrícula: " + estudante.getMatricula() +
                "\nEmail: " + estudante.getEmail() +
                "\nTelefone: " + estudante.getTelefone() +
                "\nEndereço: " + estudante.getEndereco());
    }
}
