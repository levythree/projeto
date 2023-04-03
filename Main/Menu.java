package Main;

import java.util.Scanner;

import Excecoes.ValorInvalidoException;

public class Menu {
    // menu principal do programa
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
                // essas primeiras duas linhas vão ser a validação
                // se der erro na primeira, cai no NumberFormatException
                // se der erro na segunda, cai no ValorInvalidoException
                int opcao = Integer.parseInt(input.nextLine());
                ValorInvalidoException.validarOpcao(opcao, 6);

                // pro código não ficar tão grande num arquivo só, dividi ele em vários arquivos e métodos
                // o menu vai simplesmente chamar métodos estáticos de outras classes e rodar eles
                if (opcao == 1) {
                    CadastroDeAtividade.cadastrarAtividade();
                }

                else if (opcao == 2) {
                    // esse print aqui é pra se adequar esteticamente com o resto dos métodos
                    // não dava pra colocar esse print dentro do método de listarAtividades() porque esse print aconteceria toda vez que esse método rodasse, que acontece em outras partes do programa também
                    System.out.printf("""
                ----------------------------------------
                         ATIVIDADES CADASTRADAS          
                ---------------------------------------- 
                """);

                    AtividadesCadastradas.listarAtividades();
                }

                else if (opcao == 3) {
                    PesquisaDeAtividade.pesquisarAtividade();
                }

                else if (opcao == 4) {
                    AtualizacaoDeAtividade.atualizarAtividadeMenu();
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
