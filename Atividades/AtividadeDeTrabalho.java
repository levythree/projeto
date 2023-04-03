package Atividades;

import java.util.Date;
import Excecoes.ValorInvalidoException;

public class AtividadeDeTrabalho extends Atividade {
    // propriedade dificuldade, exclusiva dessa classe
    private int dificuldade;

    // construtor
    public AtividadeDeTrabalho(String descricao, Date dataDeRealizacao, int duracao, int satisfacao, int dificuldade) {
        super(descricao, dataDeRealizacao, duracao, satisfacao);
        setDificuldade(dificuldade);
    }

    // assim como em outros métodos na classe mãe, aqui também é feita a checagem pra ver se a propriedade é válida e também para atualizar o gasto de energia
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

    @Override
    public void listar() {
        super.listar();

        System.out.printf("Dificuldade: %s | ", getDificuldade());

        listarGastoDeEnergiaEBemEstar();
    }
}
