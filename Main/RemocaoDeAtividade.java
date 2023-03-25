package Projeto.Main;

import java.util.Scanner;
import Projeto.Atividades.Atividade;
import Projeto.Exceções.ValorInvalidoException;

public class RemocaoDeAtividade {
    public static void removerAtividade() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                      REMOÇÃO DE ATIVIDADE          
            ---------------------------------------- 
            """);

            AtividadesCadastradas.listarAtividades();

            System.out.printf("[%s] - Voltar.%n", Atividade.getListaDeAtividades().size() + 1);

            System.out.printf("----------------------------------------%nEscolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine());

                try {
                    ValorInvalidoException.validarOpcao(opcao, Atividade.getListaDeAtividades().size() + 1);

                    if (opcao == Atividade.getListaDeAtividades().size() + 1) {
                        break;
                    }
        
                    else {
                        Atividade.getListaDeAtividades().remove(opcao -1);
                    }
                }

                catch (ValorInvalidoException erro) {
                    System.out.printf("----------------------------------------%n%s%n", erro);
                }
            }

            catch (NumberFormatException erro) {
                System.out.printf("----------------------------------------%n%s%n", erro);
            }
        } 
    }
}
