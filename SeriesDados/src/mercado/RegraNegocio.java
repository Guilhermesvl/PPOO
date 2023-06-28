package mercado;
import series.SerieDados;
import series.Periodicidade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RegraNegocio {
    private List<SerieDados> seriesCriadas;

    public RegraNegocio() {
        seriesCriadas = new ArrayList<>();
        
        SerieDadosMercado serie1 = new SerieDadosMercado("Quantidade de Arroz", 1, 4, Periodicidade.SEMANAL);
        serie1.adicionarDado(1, 30);
        serie1.adicionarDado(2, 25);
        serie1.adicionarDado(3, 15);
        serie1.adicionarDado(4, 5);
        seriesCriadas.add(serie1);


        SerieDadosMercado serie2 = new SerieDadosMercado("Quantidade de Feijão", 1, 4, Periodicidade.SEMANAL);
        serie2.adicionarDado(1, 30);
        serie2.adicionarDado(2, 15);
        serie2.adicionarDado(3, 5);
        serie2.adicionarDado(4, 0);
        seriesCriadas.add(serie2);
    }

   
    public List<SerieDados> listarSeries() {
        return Collections.unmodifiableList(seriesCriadas);
    }
}