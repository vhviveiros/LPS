package model;

import java.util.ArrayList;

public class ServicoDeFaxina extends Model{
    //Avaliacao avaliacao;
    private String informacoes;
    //Pagamento pagamento;
    private ArrayList<Insumo> insumosUtilizados;
    private Cliente cliente;
    private TipoDeServico<?> tipoDeServico;

    public ServicoDeFaxina(String informacoes, ArrayList<Insumo> insumosUtilizados, Cliente cliente, TipoDeServico<?> tipoDeServico) {
        this.informacoes = informacoes;
        this.insumosUtilizados = insumosUtilizados;
        this.cliente = cliente;
        this.tipoDeServico = tipoDeServico;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public ArrayList<Insumo> getInsumosUtilizados() {
        return insumosUtilizados;
    }

    public void setInsumosUtilizados(ArrayList<Insumo> insumosUtilizados) {
        this.insumosUtilizados = insumosUtilizados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoDeServico<?> getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(TipoDeServico<?> tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }
}
