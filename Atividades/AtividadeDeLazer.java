package Atividades;

public class AtividadeDeLazer extends Atividade {
    public AtividadeDeLazer(String descricao, String dataDeRealizacao, int duracao, int satisfacao) {
        super(descricao, dataDeRealizacao, duracao, satisfacao);
    }

    @Override
    public void calcularGastoDeEnergia() {
        setGastoDeEnergia(getDuracao() * 1);

        calcularBemEstar();
    }

    @Override
    public void listar() {
        super.listar();

        listarGastoDeEnergiaEBemEstar();
    }
}
