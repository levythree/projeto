package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Atividades.Atividade;
import Atividades.AtividadeDeLazer;
import Atividades.AtividadeDeTrabalho;
import Atividades.AtividadeFisica;
import Excecoes.ValorInvalidoException;

public class PesquisaDeAtividade {
    // método principal, vai chamar os outros
    public static void pesquisarAtividade() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                            PESQUISA
            ----------------------------------------
            [1] - Pesquisar por tipo
            [2] - Pesquisar por data
            [3] - Top 3 atividades com maior gasto de energia
            [4] - Voltar
            ----------------------------------------
            """);

            System.out.printf("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine());
                ValorInvalidoException.validarOpcao(opcao, 4);

                if (opcao == 1) {
                    pesquisarAtividadePorTipo();
                }

                else if (opcao == 2) {
                    pesquisarAtividadePorData();
                }

                else if (opcao == 3) {
                    listarAtividadesComMaiorGasto();
                }

                else if (opcao == 4) {
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

                // originalmente eu tinha criado uma propriedade chamada tipo, e, dentro dos construtores das classes tinha colocado, por exemplo, no construtor da classe AtividadeFisica, this.tipo = "atividadeFisica"
                // então para saber se o tipo da atividade era física era só checar se o tipo dela era "atividadeFisica"
                // mas aí eu descobri o instanceof, que elimina completamente a necessidade de uma propriedade de tipo
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
        Scanner input = new Scanner(System.in);

        System.out.printf("""
        ----------------------------------------
                   PESQUISAR POR DATA           
        ----------------------------------------
        """);

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            int gastoDeEnergiaDoPeriodo = 0;

            // inicialmente eu pretendia fazer a pesquisa por data com o usuário informando uma data exata, um mês e um ano ou somente um mês
            // por exemplo: o usuário informaria 2023 e todas as atividades que possuem 2023 como ano seriam listadas
            // mas o problema estava na pesquisa por semana, não fazia ideia de como determinar isso
            // a solução de fazer o usuário informar uma data inicial e uma data final não só é bem mais fácil de fazer como até permite que o usuário tenha infinitas opções de procurar atividades por data
            System.out.printf("Informe a data inicial: ");
            Date dataInicial = simpleDateFormat.parse(input.nextLine());

            System.out.printf("Informe a data final: ");
            Date dataFinal = simpleDateFormat.parse(input.nextLine());

            System.out.printf("----------------------------------------%n");

            // a classe Date já ter um método compareTo() implementado já ajuda demais também
            for (Atividade atividade : Atividade.getListaDeAtividades()) {
                if (atividade.getDataDeRealizacao().compareTo(dataInicial) >= 0 &&
                atividade.getDataDeRealizacao().compareTo(dataFinal) <= 0) {
                    atividade.listar();
                    gastoDeEnergiaDoPeriodo += atividade.getGastoDeEnergia();
                }
            }

            System.out.printf("%nGasto de energia total do período (%s - %s): %s%n", simpleDateFormat.format(dataInicial), simpleDateFormat.format(dataFinal), gastoDeEnergiaDoPeriodo);
        }

        catch (ParseException erro) {
            System.out.printf("----------------------------------------%n%s%n", erro);
        }
    }

    public static void listarAtividadesComMaiorGasto() {
        // essa listaDeAtividadesCopia serve somente para a ordem da lista original não ser alterada
        List<Atividade> listaDeAtividadesCopia = new ArrayList(Atividade.getListaDeAtividades());

        Collections.sort(listaDeAtividadesCopia, Collections.reverseOrder());

        System.out.printf("----------------------------------------%n");

        // a condição é i < listaDeAtividadesCopia.size() ao invés de i < 3 porque podem existir casos onde o usuário não cadastrou 3 ou mais atividades
        // se o usuário só cadastrou 1 atividade e a condição é i < 3, o que aconteceria seria que o programa tentaria achar a index 1 da lista, sendo que a lista só vai até a index 0 (somente 1 elemento)
        for (int i = 0; i < listaDeAtividadesCopia.size(); i++) {
            // e esse if com um break serve justamente para caso o usuário tenha cadastro mais de 3 atividades, não permitir que mais que 3 atividades sejam printadas
            if (i == 3) {
                break;
            }

            listaDeAtividadesCopia.get(i).listar();
        }
    }
}
