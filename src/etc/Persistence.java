package etc;

import model.Usuario;
import repository.ListaClientes;
import repository.ListaInsumos;
import repository.ListaReservasServicos;
import service.insumo.InsumoService;
import service.reserva_servico.ReservaServicoService;

public class Persistence {
    public static final ListaInsumos INSUMOS = new ListaInsumos();

    public static final InsumoService INSUMO_SERVICE = new InsumoService();

    public static final ListaClientes CLIENTES = new ListaClientes();

    public static final ListaReservasServicos RESERVAS_SERVICOS = new ListaReservasServicos();

    public static final ReservaServicoService RESERVA_SERVICO_SERVICE = new ReservaServicoService();

    public static Usuario USUARIO;
}
