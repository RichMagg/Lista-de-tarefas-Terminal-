package richmagg;

import java.text.NumberFormat.Style;
import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    private final static void limparTerminal() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (final Exception e) {

        }
    }

    public static void main(String[] args) {
        LinkedList<Tarefa> tarefas = new LinkedList<>();

        boolean rodando = true;
        Scanner sc = new Scanner(System.in);

        String tarefa_nome;
        int tarefa_concluida;
        int contador = 0;

        while (rodando) {
            limparTerminal();

            System.out.println("1. Listar Tarefas");
            System.out.println("2. Adicionar Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Sair do programa");

            System.out.print("> ");

            int opcao = sc.nextInt();
            sc.nextLine();

            limparTerminal();

            switch (opcao) {
                case 1:
                    if (!tarefas.isEmpty()) {
                        for (Tarefa tarefa : tarefas) {
                            System.out.printf("%s - %s\n", tarefa.getNome(), tarefa.getConcluidoAsString());
                        }
                    }else {
                        System.out.println("A Lista está vazia.");
                    }

                    sc.nextLine();
                    break;
                case 2:
                    // Adicionar tarefa ...

                    while (true) {
                        System.out.println("Escreva o nome da tarefa.");
                        System.out.print("> ");
                        tarefa_nome = sc.nextLine().trim();
                        
                        limparTerminal();

                        if (!tarefa_nome.isEmpty()) break;
                    }

                    while (true) {
                        System.out.println("A tarefa está concluída?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");

                        System.out.print("> ");
                        tarefa_concluida = sc.nextInt();
                        sc.nextLine();
                        
                        limparTerminal();

                        if (tarefa_concluida != 1 && tarefa_concluida != 2) continue;

                        tarefas.add(new Tarefa(tarefa_nome, (tarefa_concluida == 1)));
                        break;
                    }
                    break;

                case 3:                    
                    while (true) {
                        System.out.println("Escreva o nome da tarefa a ser removida.");
                        System.out.print("> ");
                        tarefa_nome = sc.nextLine().trim();
                        
                        limparTerminal();

                        if (!tarefa_nome.isEmpty()) break;
                    }

                    for (Tarefa t : tarefas) {
                        if (t.getNome().equalsIgnoreCase(tarefa_nome)) {
                            tarefas.remove(contador);
                            break;
                        }
                        contador++;
                    }
                    contador = 0;

                    break;
                case 4:
                    limparTerminal();
                    rodando = false;
                    break;
            }
        }

        sc.close();
    }
}