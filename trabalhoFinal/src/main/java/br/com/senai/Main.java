package br.com.senai;

import br.com.senai.dao.ClienteDAO;
import br.com.senai.model.Cliente;
import br.com.senai.util.HibernateUtil;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- SISTEMA DE CADASTRO DE CLIENTES ---");
            System.out.println("1: Cadastrar Cliente"); // [cite: 4]
            System.out.println("2: Listar Clientes"); // [cite: 4]
            System.out.println("3: Atualizar Cliente"); // [cite: 5]
            System.out.println("4: Excluir Cliente"); // [cite: 5]
            System.out.println("0: Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Por favor, digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    // Cadastrar
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nome, email, telefone);
                    clienteDAO.salvar(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    // Listar
                    List<Cliente> clientes = clienteDAO.listarTodos();
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("\n--- LISTA DE CLIENTES ---");
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    // Atualizar
                    System.out.print("Digite o ID do cliente que deseja atualizar: ");
                    try {
                        int idAtualizar = Integer.parseInt(scanner.nextLine());
                        Cliente clienteAtualizar = clienteDAO.buscarPorId(idAtualizar);
                        if (clienteAtualizar != null) {
                            System.out.print("Digite o novo nome (atual: " + clienteAtualizar.getNome() + "): ");
                            clienteAtualizar.setNome(scanner.nextLine());
                            System.out.print("Digite o novo email (atual: " + clienteAtualizar.getEmail() + "): ");
                            clienteAtualizar.setEmail(scanner.nextLine());
                            System.out.print("Digite o novo telefone (atual: " + clienteAtualizar.getTelefone() + "): ");
                            clienteAtualizar.setTelefone(scanner.nextLine());
                            clienteDAO.atualizar(clienteAtualizar);
                            System.out.println("Cliente atualizado com sucesso!");
                        } else {
                            System.out.println("Cliente nao encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID invalido.");
                    }
                    break;
                case 4:
                    // Excluir
                    System.out.print("Digite o ID do cliente que deseja excluir: ");
                    try {
                        int idExcluir = Integer.parseInt(scanner.nextLine());
                        if (clienteDAO.buscarPorId(idExcluir) != null) {
                            clienteDAO.excluir(idExcluir);
                        } else {
                            System.out.println("Cliente com ID " + idExcluir + " nao encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID invalido.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }
        scanner.close();
        HibernateUtil.shutdown();
    }
}