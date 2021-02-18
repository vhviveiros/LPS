package etc;

import model.Cliente;
import model.TipoDeServico;
import model.Usuario;
import repository.*;
import service.Service;
import service.insumo.InsumoService;
import service.tipo_servico.OfertaServicoService;
import service.tipo_servico.ReservaServicoService;

public class Persistence {
    public static final ListaInsumos INSUMOS = new ListaInsumos();

    public static final InsumoService INSUMO_SERVICE = new InsumoService();

    private static final ListaReservasServicos RESERVAS_SERVICOS = new ListaReservasServicos();

    private static final ReservaServicoService RESERVA_SERVICO_SERVICE = new ReservaServicoService();

    private static final ListaOfertasServicos OFERTAS_SERVICOS = new ListaOfertasServicos();

    private static final OfertaServicoService OFERTA_SERVICO_SERVICE = new OfertaServicoService();

    public static Usuario USUARIO;

    public static <T extends TipoDeServico<?>> Service<? extends T> getTipoDeServicoService() {
        if (USUARIO instanceof Cliente)
            return (Service<? extends T>) RESERVA_SERVICO_SERVICE;
        else
            return (Service<? extends T>) OFERTA_SERVICO_SERVICE;
    }

    public static <T extends TipoDeServico<?>> Repository<T> getTipoDeServicoRepository() {
        if (USUARIO instanceof Cliente)
            return (Repository<T>) RESERVAS_SERVICOS;
        else
            return (Repository<T>) OFERTAS_SERVICOS;
    }
}
