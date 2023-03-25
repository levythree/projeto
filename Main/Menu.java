package Projeto.Main;

import java.util.Scanner;
import Projeto.Exceções.ValorInvalidoException;

public class Menu {
    public static void menu() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                              MENU                    
            ----------------------------------------
            [1] - Cadastrar atividade
            [2] - Listar todas as atividades
            [3] - Pesquisar atividade
            [4] - Atualizar atividade
            [5] - Remover atividade
            [6] - Sair
            ----------------------------------------
            """);

            System.out.printf("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine());
                ValorInvalidoException.validarOpcao(opcao, 6);

                if (opcao == 1) {
                    CadastroDeAtividade.cadastrarAtividade();
                }

                else if (opcao == 2) {
                    System.out.printf("""
                ----------------------------------------
                         ATIVIDADES CADASTRADAS          
                ---------------------------------------- 
                """);

                    AtividadesCadastradas.listarAtividades();
                }

                else if (opcao == 3) {
                    ;
                }

                else if (opcao == 4) {
                    AtualizacaoDeAtividade.atualizarAtividade();
                }

                else if (opcao == 5) {
                    RemocaoDeAtividade.removerAtividade();
                }

                else if (opcao == 6) {
                    break;
                }
            }

            catch (ValorInvalidoException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }

            catch (NumberFormatException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }
        }
    }
}
