package Atividades;

import java.util.List;
import java.util.ArrayList;
import Excecoes.ValorInvalidoException;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;

public abstract class Atividade {
    // PROPRIEDADES
    private String descricao;
    private String dataDeRealizacao;
    private int duracao;
    private int satisfacao;
    private int gastoDeEnergia;
    private double bemEstar;

    private static List<Atividade> listaDeAtividades = new ArrayList<>();

    // CONSTRUTOR
    public Atividade(String descricao, String dataDeRealizacao, int duracao, int satisfacao) {
        setDescricao(descricao);
        setDataDeRealizacao(dataDeRealizacao);
        setSatisfacao(satisfacao);
        setDuracao(duracao);
    }

    // GETTERS E SETTERS
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDataDeRealizacao(String dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    public String getDataDeRealizacao() {
        return dataDeRealizacao;
    }
    
    public void setDuracao(int duracao) {
        try {
            ValorInvalidoException.validarDuracao(duracao);

            this.duracao = duracao;

            calcularGastoDeEnergia();
        }

        catch (ValorInvalidoException erro) {
            System.out.printf("----------------------------------------%n%s%n", erro);
        }
    }

    public int getDuracao() {
        return duracao;
    }

    public void setSatisfacao(int satisfacao) {
        try {
            ValorInvalidoException.validarSatisfacao(satisfacao);

            this.satisfacao = satisfacao;

            calcularBemEstar();
        }

        catch (ValorInvalidoException erro) {
            System.out.printf("----------------------------------------%n%s%n", erro);
        }
    }

    public int getSatisfacao() {
        return satisfacao;
    }

    public void setGastoDeEnergia(int gastoDeEnergia) {
        this.gastoDeEnergia = gastoDeEnergia;
    }

    public int getGastoDeEnergia() {
        return gastoDeEnergia;
    }

    public void setBemEstar(double bemEstar) {
        this.bemEstar = bemEstar;
    }

    public double getBemEstar() {
        return bemEstar;
    }

    public abstract void calcularGastoDeEnergia();

    public void calcularBemEstar() {
        setBemEstar((getGastoDeEnergia() * getSatisfacao()) / 360.0);
    }

    public static List<Atividade> getListaDeAtividades() {
        return listaDeAtividades;
    }

    public void listar() {
        System.out.printf("Descrição: %s | ", getDescricao());
        System.out.printf("Data de realização: %s | ", getDataDeRealizacao());
        System.out.printf("Duração: %s | ", getDuracao());
        System.out.printf("Satisfação: %s | ", getSatisfacao());
    }

    public void listarGastoDeEnergiaEBemEstar() {
        System.out.printf("Gasto de energia: %s | ", getGastoDeEnergia());
        System.out.printf("Bem-estar: %.2f%n", getBemEstar());
    }
}
