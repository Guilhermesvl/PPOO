package mercado;
import java.util.ArrayList;
import series.SerieDados;
import series.Periodicidade;


public class SerieDadosMercado implements SerieDados {
    private String identificacao;
    private int periodoInicial;
    private int periodoFinal;
    private Periodicidade periodicidade;
    private ArrayList<Integer> dados;

    public SerieDadosMercado(String identificacao, int periodoInicial, int periodoFinal, Periodicidade periodicidade) {
        this.identificacao = identificacao;
        this.periodoInicial = periodoInicial;
        this.periodoFinal = periodoFinal;
        this.periodicidade = periodicidade;
        this.dados = new ArrayList<>();
    }

    @Override
    public String obterIdentificacaoSerie() {
        return identificacao;
    }

    @Override
    public int obterInicioPeriodo() {
        return periodoInicial;
    }

    @Override
    public int obterFimPeriodo() {
        return periodoFinal;
    }

    @Override
    public Periodicidade obterPeriodicidade() {
        return periodicidade;
    }

    @Override
    public int obterDado(int periodo) {
        if (trataPeriodicidade(periodo) && periodo >= periodoInicial && periodo <= periodoFinal) {
            return dados.get(periodo - periodoInicial);
        } else {
            System.out.println("Dado não encontrado");
            return 0;
        }
    }

    public boolean trataPeriodicidade(int periodo) {
        switch (this.periodicidade) {
            case DIARIA:
                return periodo >= 1 && periodo <= 30;
            case MENSAL:
                return periodo >= 1 && periodo <= 12;
            case HORARIA: 
                return periodo >= 1 && periodo <= 24;
            case SEMANAL:
                return periodo >= 1 && periodo <= 4;
            case ANUAL:
                return periodo >= 2023 && periodo <= 2025;

            default:
                return false; 
        }
    }

    public void adicionarDado(int periodo, int dado) {
        if (trataPeriodicidade(periodo)) {
            dados.add(dado);
        }
    }

}