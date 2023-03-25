package Projeto.Main;

import java.util.Scanner;

import Projeto.Atividades.Atividade;
import Projeto.Atividades.AtividadeDeLazer;
import Projeto.Atividades.AtividadeDeTrabalho;
import Projeto.Atividades.AtividadeFisica;
import Projeto.Exceções.ValorInvalidoException;

public class CadastroDeAtividade {
    public static void cadastrarAtividade() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                            CADASTRO                
            ----------------------------------------
            [1] - Atividade de lazer
            [2] - Atividade de trabalho
            [3] - Atividade física
            [4] - Voltar
            ----------------------------------------
            """);

            // o uso do Integer.parseInt(input.nextLine()) se dá por conta de um problema ao usar os métodos nextInt() e nextLine() em sequência
            // portanto a solução encontrada foi utilizar o nextLine() e então transformar para um valor int
            System.out.printf("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine());
                ValorInvalidoException.validarOpcao(opcao, 6);
                
                if (opcao == 4) {
                    break;
                }
    
                else {
                    System.out.printf("----------------------------------------%nInforme a descrição daatividade: ");
                    String descricao = input.nextLine();
    
                    System.out.printf("Informe a data de realização da atividade: ");
                    String dataDeRealizacao = input.nextLine();
    
                    System.out.printf("Informe a duração da atividade (em minutos): ");
                    int duracao = Integer.parseInt(input.nextLine());
                    ValorInvalidoException.validarDuracao(duracao);
                    System.out.printf("Informe a satisfação da atividade (1 parasatisfatória, - 1 paranão satisfatória): ");
                    int satisfacao = Integer.parseInt(input.nextLine());
                    ValorInvalidoException.validarSatisfacao(satisfacao);

                    if (opcao == 1) {
                        Atividade atividadeDeLazer = new AtividadeDeLazer(descricao,dataDeRealizacao, duracao,satisfacao);
                        
                        Atividade.getListaDeAtividades().add(atividadeDeLazer);
                    }

                    else if (opcao == 2) {
                        System.out.printf("Informe a dificuldade da atividade (1 parafácil, 2  paramédio, 3 para difícil): ");
                        int dificuldade = Integer.parseInt(input.nextLine());
                        ValorInvalidoException.validarDificuldade(dificuldade);
                    
                        Atividade atividadeDeTrabalho = new AtividadeDeTrabalho(descricao,dataDeRealizacao,duracao, satisfacao, dificuldade);
                    
                        Atividade.getListaDeAtividades().add(atividadeDeTrabalho);
                    }
                
                    else if (opcao == 3) {
                        System.out.printf("Informe a intensidade da atividade (2 parafraco, 3  paraintenso, 4 para vigoroso): ");
                        int intensidade = Integer.parseInt(input.nextLine());
                        
                        ValorInvalidoException.validarIntensidade(intensidade);
                        Atividade atividadeFisica = new AtividadeFisica(descricao,dataDeRealizacao, duracao,satisfacao, intensidade);
                    
                        Atividade.getListaDeAtividades().add(atividadeFisica);
                    }
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
