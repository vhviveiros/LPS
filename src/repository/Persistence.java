package repository;

import model.Cliente;
import model.TipoDeServico;
import model.Usuario;
import service.Service;
import service.endereco.EnderecoService;
import service.insumo.InsumoService;
import service.tipo_servico.OfertaServicoService;
import service.tipo_servico.ReservaServicoService;
import service.usuario.ClienteService;
import service.usuario.FaxineiroService;

public class Persistence {
    public static final ListaInsumos INSUMOS = new ListaInsumos();

    public static final InsumoService INSUMO_SERVICE = new InsumoService();

    private static final ListaReservasServicos RESERVAS_SERVICOS = new ListaReservasServicos();

    private static final ReservaServicoService RESERVA_SERVICO_SERVICE = new ReservaServicoService();

    private static final ListaOfertasServicos OFERTAS_SERVICOS = new ListaOfertasServicos();

    private static final OfertaServicoService OFERTA_SERVICO_SERVICE = new OfertaServicoService();

    public static Usuario usuario;

    public static final ClienteService CLIENTE_SERVICE = new ClienteService();

    public static final FaxineiroService FAXINEIRO_SERVICE = new FaxineiroService();

    public static final EnderecoService ENDERECO_SERVICE = new EnderecoService();

    public static <T extends TipoDeServico<?>> Service<T> getTipoDeServicoService() {
        if (usuario instanceof Cliente)
            return (Service<T>) RESERVA_SERVICO_SERVICE;
        else
            return (Service<T>) OFERTA_SERVICO_SERVICE;
    }

    public static <T extends TipoDeServico<?>> Repository<T> getTipoDeServicoRepository() {
        if (usuario instanceof Cliente)
            return (Repository<T>) RESERVAS_SERVICOS;
        else
            return (Repository<T>) OFERTAS_SERVICOS;
    }
}
