package Main;

import Atividades.Atividade;

public class AtividadesCadastradas {
    // método pra listar todas as atividades
    public static void listarAtividades() {
        // vai percorrer toda a lista de atividades, usando o método listar() de cada atividade
        for (int index = 0; index < Atividade.getListaDeAtividades().size(); index++) {
            // esse print aqui vai servir pra mostrar qual é o index daquela atividade printada na lista
            // não é exatamente o index porque aqui o valor tá aumentado em 1, por questões de estética mesmo
            System.out.printf("[%s] - ", index + 1);
            Atividade.getListaDeAtividades().get(index).listar();
        }
    }
}
