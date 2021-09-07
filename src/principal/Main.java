package principal;
import Modelo.ClienteModelDAO;
import vista.VistaClientes;
import controlador.ClienteController;

public class Main {
    public static void main(String[] args) {
        VistaClientes vistaCliente = new VistaClientes();
        ClienteModelDAO cmDAO = new ClienteModelDAO();
        
        ClienteController controlador = new ClienteController(vistaCliente, cmDAO);
        
        vistaCliente.setVisible(true);
        vistaCliente.setLocationRelativeTo(null);
        vistaCliente.setResizable(false);
        
    }
}
