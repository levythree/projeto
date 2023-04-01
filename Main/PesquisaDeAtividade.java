package Main;

import java.util.Scanner;

import Atividades.Atividade;
import Atividades.AtividadeDeLazer;
import Atividades.AtividadeDeTrabalho;
import Atividades.AtividadeFisica;
import Excecoes.ValorInvalidoException;

public class PesquisaDeAtividade {
    public static void pesquisarAtividade() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                            PESQUISA
            ----------------------------------------
            [1] - Pesquisar por tipo
            [2] - Pesquisar por data
            [3] - Voltar
            ----------------------------------------
            """);

            System.out.printf("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine());
                ValorInvalidoException.validarOpcao(opcao, 3);

                if (opcao == 1) {
                    pesquisarAtividadePorTipo();
                }

                else if (opcao == 2) {
                    pesquisarAtividadePorData();
                }

                else if (opcao == 3) {
                    break;
                }
            }

            catch (NumberFormatException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }

            catch (ValorInvalidoException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }
        }
    }

    public static void pesquisarAtividadePorTipo() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                       PESQUISAR POR TIPO           
            ----------------------------------------
            [1] - Atividade de lazer
            [2] - Atividade de trabalho
            [3] - Atividade física
            [4] - Voltar
            ----------------------------------------
            """);

            System.out.printf("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine());
                ValorInvalidoException.validarOpcao(opcao, 4);

                if (opcao == 4) {
                    break;
                }

                System.out.printf("----------------------------------------%n");

                for (Atividade atividade : Atividade.getListaDeAtividades()) {
                    if (opcao == 1 && atividade instanceof AtividadeDeLazer) {
                        atividade.listar();
                    }

                    else if (opcao == 2 && atividade instanceof AtividadeDeTrabalho) {
                        atividade.listar();
                    }

                    else if (opcao == 3 && atividade instanceof AtividadeFisica) {
                        atividade.listar();
                    }
                }
            }

            catch (NumberFormatException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }

            catch (ValorInvalidoException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }
        }
    }

    public static void pesquisarAtividadePorData() {

    }
}
