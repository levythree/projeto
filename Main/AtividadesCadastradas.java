package Main;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import Atividades.Atividade;
import Atividades.AtividadeDeTrabalho;
import Atividades.AtividadeFisica;

public class AtividadesCadastradas {
    public static void listarAtividades() {      
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);

        for (int index = 0; index < Atividade.getListaDeAtividades().size(); index++) {
            System.out.printf("[%s] - Descrição: %s | Data de realização: %s | Duração: %s | Satisfação: %s", index + 1, Atividade.getListaDeAtividades().get(index).getDescricao(),   Atividade.getListaDeAtividades().get(index).getDataDeRealizacao(), Atividade. getListaDeAtividades().get(index).getDuracao(), Atividade.getListaDeAtividades().get (index).getSatisfacao());

            if (Atividade.getListaDeAtividades().get(index).getTipo().equals("atividadeDeTrabalho")) {
                System.out.printf(" | Dificuldade %s", ((AtividadeDeTrabalho) Atividade. getListaDeAtividades().get(index)).getDificuldade());
            }

            else if (Atividade.getListaDeAtividades().get(index).getTipo().equals("atividadeFisica")) {
                System.out.printf(" | Intensidade: %s", ((AtividadeFisica) Atividade.    getListaDeAtividades().get(index)).getIntensidade());
            }

            System.out.printf(" | Gasto de energia: %s | Bem-estar: %s%n", Atividade.getListaDeAtividades().get(index).getGastoDeEnergia(), decimalFormat.format(Atividade.getListaDeAtividades().get(index).getBemEstar()));
        }
    }
}
