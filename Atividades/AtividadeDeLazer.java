package Atividades;

import java.util.Date;

public class AtividadeDeLazer extends Atividade {
    // construtor
    public AtividadeDeLazer(String descricao, Date dataDeRealizacao, int duracao, int satisfacao) {
        super(descricao, dataDeRealizacao, duracao, satisfacao);
    }

    // redeclaração de métodos
    @Override
    public void calcularGastoDeEnergia() {
        setGastoDeEnergia(getDuracao() * 1);

        // o bem-estar depende do gasto de energia
        // se o gasto de energia muda, o bem-estar também muda
        // então, sempre que o gasto de energia for calculado, o bem-estar também será
        calcularBemEstar();
    }

    @Override
    public void listar() {
        super.listar();

        listarGastoDeEnergiaEBemEstar();
    }
}
