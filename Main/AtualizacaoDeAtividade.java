package Projeto.Main;

import java.util.Scanner;
import Projeto.Atividades.Atividade;
import Projeto.Atividades.AtividadeDeTrabalho;
import Projeto.Atividades.AtividadeFisica;
import Projeto.Exceções.ValorInvalidoException;

public class AtualizacaoDeAtividade {
    public static void atualizarAtividade() {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.printf("""
            ----------------------------------------
                    ATUALIZAÇÃO DE ATIVIDADE          
            ----------------------------------------
            """);

            AtividadesCadastradas.listarAtividades();

            System.out.printf("[%s] - Voltar.%n", Atividade.getListaDeAtividades().size() + 1);

            System.out.printf("----------------------------------------%nEscolha uma opção: ");

            try {
                int opcao = Integer.parseInt(input.nextLine()) - 1;

                try {
                    ValorInvalidoException.validarOpcao(opcao + 1, Atividade.getListaDeAtividades().size() + 1);

                    if (opcao + 1 == Atividade.getListaDeAtividades().size() + 1) {
                        break;
                    }
        
                    else {
                        while (true) {
                            int voltar;

                            if (Atividade.getListaDeAtividades().get(opcao).getTipo().equals("atividadeDeLazer")) {
                                voltar = 5;
                            }

                            else {
                                voltar = 6;
                            }
        
                            System.out.printf("""
                            ----------------------------------------
                                    ATUALIZAÇÃO DE ATIVIDADE        
                            ----------------------------------------
                            [1] - Descrição
                            [2] - Data de realização
                            [3] - Duração
                            [4] - Satisfação
                            """);
        
                            if (Atividade.getListaDeAtividades().get(opcao).getTipo().equals    ("atividadeDeTrabalho")) {
                                System.out.printf("[5] - Dificuldade.%n");
                            }
        
                            else if (Atividade.getListaDeAtividades().get(opcao).getTipo().equals   ("atividadeFisica")) {
                                System.out.printf("[5] - Intensidade.%n");
                            }
        
                            System.out.printf("[%s] - Voltar.%n", voltar);
        
                            System.out.printf("----------------------------------------%nEscolha uma opção: ");
                            int segundaOpcao = Integer.parseInt(input.nextLine());

                            try {
                                ValorInvalidoException.validarOpcao(segundaOpcao, voltar);

                                System.out.printf("----------------------------------------%n");
        
                                if (segundaOpcao == voltar) {
                                    break;
                                }
                            
                                if (segundaOpcao == 1) {
                                    System.out.printf("Informe a nova descrição da atividade: ");
                                    String descricao = input.nextLine();
                                
                                    Atividade.getListaDeAtividades().get(opcao).setDescricao(descricao);
                                }
                            
                                else if (segundaOpcao == 2) {
                                    System.out.printf("Informe a nova data de realização da atividade:  ");
                                    String dataDeRealizacao = input.nextLine();
                                
                                    Atividade.getListaDeAtividades().get(opcao).setDataDeRealizacao (dataDeRealizacao);
                                }
                            
                                else if (segundaOpcao == 3) {
                                    System.out.printf("Informe a nova duração da atividade (em minutos) : ");
                                    int duracao = Integer.parseInt(input.nextLine());
                                
                                    Atividade.getListaDeAtividades().get(opcao).setDuracao(duracao);
                                }
                            
                                else if (segundaOpcao == 4) {
                                    System.out.printf("Informe a nova satisfação da atividade (1 para satisfatória, -1 para não satisfatória): ");
                                    int satisfacao = Integer.parseInt(input.nextLine());
                                
                                    Atividade.getListaDeAtividades().get(opcao).setSatisfacao(satisfacao);
                                }
                            
                                else if (segundaOpcao == 5 && Atividade.getListaDeAtividades().get(opcao).  getTipo().equals("atividadeDeTrabalho")) {
                                    System.out.printf("Informe a nova dificuldade da atividade (1 para fácil, 2 para médio, 3 para difícil): ");
                                    int dificuldade = Integer.parseInt(input.nextLine());
                                
                                    ((AtividadeDeTrabalho) Atividade.getListaDeAtividades().get(opcao)).    setDificuldade(dificuldade);
                                }
                            
                                else if (segundaOpcao == 5 && Atividade.getListaDeAtividades().get(opcao).  getTipo().equals("atividadeFisica")) {
                                    System.out.printf("Informe a nova intensidade da atividade (2 para fraco, 3 para intenso, 4 para vigoroso): ");
                                    int intensidade = Integer.parseInt(input.nextLine());
                                
                                    ((AtividadeFisica) Atividade.getListaDeAtividades().get(opcao)).    setIntensidade(intensidade);
                                }
                            }

                            catch (ValorInvalidoException erro) {
                                System.out.printf("----------------------------------------%n%s%n", erro);
                            }
                        }
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
