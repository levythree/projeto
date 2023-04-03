package Atividades;

import Excecoes.ValorInvalidoException;
import java.util.Date;

public class AtividadeFisica extends Atividade {
    // propriedade intensidade, exclusiva dessa classe
    private int intensidade;

    // construtor
    public AtividadeFisica(String descricao, Date dataDeRealizacao, int duracao, int satisfacao, int intensidade) {
        super(descricao, dataDeRealizacao, duracao, satisfacao);
        setIntensidade(intensidade);
    }

    // assim como em outros métodos na classe mãe, aqui também é feita a checagem pra ver se a propriedade é válida e também para atualizar o gasto de energia
    public void setIntensidade(int intensidade) {
        try {
            ValorInvalidoException.validarIntensidade(intensidade);

            this.intensidade = intensidade;

            calcularGastoDeEnergia();
        }

        catch (ValorInvalidoException erro) {
            System.out.printf("----------------------------------------%n%s%n", erro);
        }
    }

    public int getIntensidade() {
        return intensidade;
    }

    @Override
    public void calcularGastoDeEnergia() {
        setGastoDeEnergia(getDuracao() * getIntensidade() * 3);

        calcularBemEstar();
    }

    @Override
    public void listar() {
        super.listar();

        System.out.printf("Intensidade: %s | ", getIntensidade());

        listarGastoDeEnergiaEBemEstar();
    }
}
