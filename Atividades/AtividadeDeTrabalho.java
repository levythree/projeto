package Projeto.Atividades;

import Projeto.Exceções.ValorInvalidoException;

public class AtividadeDeTrabalho extends Atividade {
    private int dificuldade;

    public AtividadeDeTrabalho(String descricao, String dataDeRealizacao, int duracao, int satisfacao, int dificuldade) {
        super(descricao, dataDeRealizacao, duracao, satisfacao);
        setDificuldade(dificuldade);

        setTipo("atividadeDeTrabalho");
    }

    public void setDificuldade(int dificuldade) {
        try {
            ValorInvalidoException.validarDificuldade(dificuldade);

            this.dificuldade = dificuldade;

            calcularGastoDeEnergia();
        }

        catch (ValorInvalidoException erro) {
            System.out.printf("----------------------------------------%n%s%n", erro);
        }
    }

    public int getDificuldade() {
        return dificuldade;
    }

    @Override
    public void calcularGastoDeEnergia() {
        setGastoDeEnergia(getDuracao() * getDificuldade() * 2);

        calcularBemEstar();
    }
}