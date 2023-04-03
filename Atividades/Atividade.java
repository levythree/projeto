package Atividades;

import java.util.List;
import java.util.ArrayList;
import Excecoes.ValorInvalidoException;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Atividade {
    // propriedades
    private String descricao;
    private Date dataDeRealizacao;
    private int duracao;
    private int satisfacao;
    private int gastoDeEnergia;
    private double bemEstar;

    // lista contendo todas as atividades
    private static List<Atividade> listaDeAtividades = new ArrayList<>();

    // construtor
    public Atividade(String descricao, Date dataDeRealizacao, int duracao, int satisfacao) {
        // aqui optei por usar os métodos de set() ao invés do clássico this.atributo = atributo
        // isso porque da última forma o programa só está atribuindo valor às propriedades, sem fazer mais nada
        // só que durante o desenvolvimento do projeto percebi que poderia fazer diversas coisas já na atribuição do valor à propriedade, por isso optei fazer dessa maneira
        setDescricao(descricao);
        setDataDeRealizacao(dataDeRealizacao);
        setSatisfacao(satisfacao);
        setDuracao(duracao);
    }

    // getters e setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDataDeRealizacao(Date dataDeRealizacao) {
        this.dataDeRealizacao = dataDeRealizacao;
    }

    public Date getDataDeRealizacao() {
        return dataDeRealizacao;
    }
    
    public void setDuracao(int duracao) {
        // para o método setDuracao(), automaticamente já é feita a validação para ver se a duração é valida, isto é, maior igual a 1
        try {
            ValorInvalidoException.validarDuracao(duracao);

            this.duracao = duracao;

            // também já é feito automaticamente o cálculo do gasto de energia
            // porque eu fiz a atualiazação de dados com os métodos set(), faz sentido já calcular o gasto de energia e fazer algumas outras coisas
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
        // assim como na duração, aqui também é feita a validação dentro do próprio método de set()
        try {
            ValorInvalidoException.validarSatisfacao(satisfacao);

            this.satisfacao = satisfacao;

            // diferente da duração, aqui na satisfação somente o cálculo do bem-estar é feito
            // isso porque a satisfação não influencia em nada no gasto de energia, mas influencia no bem-estar
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

    // método abstrato, já que em cada tipo de atividade diferente o cálculo do gasto de energia também será diferente
    public abstract void calcularGastoDeEnergia();

    // o cálculo do bem-estar é o mesmo independentemente do tipo da atividade
    public void calcularBemEstar() {
        setBemEstar((getGastoDeEnergia() * getSatisfacao()) / 360.0);
    }

    public static List<Atividade> getListaDeAtividades() {
        return listaDeAtividades;
    }

    // método para listar todas as propriedades de uma atividade
    // decidi criar um método especificamente pra isso porque durante a execução do programa as atividades são listadas
    // na maioria dos casos todas as atividades serão listadas, mas em relação à pequisa de atividades, somente algumas das atividades serão listadas
    // então faz mais sentido ter um método dentro da própria classe Atividade, para listar uma atividade de maneira individual
    public void listar() {
        // na hora de printar a data de realização, se printar a data em si, o print é feito com um monte de informações adicionais
        // então, decidi que na hora de printar a data, ela fosse convertida para string pra poder formatar
        // escolhi o formato de dd/MM/yyyy porque esse é o formato que o programa pede pro usuário informar, então faz sentido mostrar a data nesse formato também
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("Descrição: %s | ", getDescricao());
        System.out.printf("Data de realização: %s | ", simpleDateFormat.format(dataDeRealizacao));
        System.out.printf("Duração: %s | ", getDuracao());
        System.out.printf("Satisfação: %s | ", getSatisfacao());
    }

    // esse método é puramente pras propriedades serem exibidas na ordem que eu quero
    // pra mim faz mais sentido primeiro mostrar as propriedades que constituem o cálculo do gasto de energia e do bem-estar antes de printar eles
    // então no caso das atividades de trabalho e nas atividades físicas, primeiro será mostrado a dificuldade ou a intensidade e depois o gasto de energia e o bem-estar
    public void listarGastoDeEnergiaEBemEstar() {
        System.out.printf("Gasto de energia: %s | ", getGastoDeEnergia());
        System.out.printf("Bem-estar: %.2f%n", getBemEstar());
    }
}
