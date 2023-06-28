import mercado.RegraNegocio;
import mercado.SerieDadosMercado;
import series.VisualizadorSeries;
import series.SerieDados;

import java.util.List;

import javax.swing.JFrame;

public class Principal {
    
    public void executar() {
        RegraNegocio regras = new RegraNegocio();
        List<SerieDados> series = regras.listarSeries();
        
        VisualizadorSeries teste = new VisualizadorSeries(series);
        teste.exibir();


        for (SerieDados serie : series) {
            System.out.println("Dados da Série "+ serie.obterIdentificacaoSerie() + " (" + serie.obterPeriodicidade()+") ");
            for (int periodoT = serie.obterInicioPeriodo() ; periodoT <= serie.obterFimPeriodo(); periodoT++) {
                int saida = serie.obterDado(periodoT);
                System.out.println("Semana " + periodoT + ": " + saida);
            }
            System.out.println();
        }
    }
}
