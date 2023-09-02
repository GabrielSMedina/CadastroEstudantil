import java.util.Scanner;

public class InterfaceEstudante {

    private final Scanner scanner;
    private final ControladorEstudante controladorEstudante;

    public InterfaceEstudante(){
        scanner = new Scanner(System.in);
        controladorEstudante = new ControladorEstudante();
    }

    public void executar(){
        int opcao;

        do {
            opcao = capturarOpcoes();

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

        Estudante estudante = new Estudante(matricula, nome, email, telefone, endereco);
        controladorEstudante.adicionarEstudante(estudante);
    }

    private void removerEstudante(){
        System.out.println("Informe a matricula para efetuar a remoção:");
        System.out.println("Matrícula: ");

        controladorEstudante.removerEstudante(scanner.nextInt());
    }

    private void obterEstudantePorNome(){
        System.out.println("Informe o nome do estudante desejado: ");
        System.out.println("Nome: ");
        Estudante estudante = controladorEstudante.obterEstudantePorNome(scanner.next());
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
        if (estudante != null){
            formataStringDadosEstudante(estudante);
        }else{
            System.out.println("Estudante Inexistente!");
        }
    }

    private void exibirEstudantes(){
        System.out.println("Listando Estudantes...\n-------------------------------------");
        for (Estudante estudante : controladorEstudante.listarTodosEstudantes()){
            formataStringDadosEstudante(estudante);
            System.out.println("-------------------------------------");
        }
        System.out.println("\n\n");
    }

    private void formataStringDadosEstudante(Estudante estudante){
        System.out.println("\nNome: " + estudante.getNome() +
                "\nMatrícula: " + estudante.getMatricula() +
                "\nEmail: " + estudante.getEmail() +
                "\nTelefone: " + estudante.getTelefone() +
                "\nEndereço: " + estudante.getEndereco());
    }
}
