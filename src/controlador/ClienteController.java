package controlador;

import Modelo.ClienteModel;
import Modelo.ClienteModelDAO;
import Modelo.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.VistaClientes;

public class ClienteController implements ActionListener {

    VistaClientes vistaCliente = new VistaClientes();
    ClienteModelDAO clienteDAO = new ClienteModelDAO();
    private int id;

    public ClienteController(VistaClientes vistaCliente, ClienteModelDAO clienteDao) {
        this.vistaCliente = vistaCliente;
        this.clienteDAO = clienteDao;

        // escucha el evento
        this.vistaCliente.btn_registrar.addActionListener(this);
        this.vistaCliente.btn_mostrar.addActionListener(this);
        this.vistaCliente.btn_eliminar.addActionListener(this);
        this.vistaCliente.btn_actualizar.addActionListener(this);
        this.vistaCliente.btn_editar.addActionListener(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    // elemento.addEventListener('click', function(e){});
    public void actionPerformed(ActionEvent evento) {
        // verificando si se dio click al boton 
        if (evento.getSource() == vistaCliente.btn_registrar) {
            Utilidades utilidad = new Utilidades();
            String nombre = vistaCliente.jtf_nombre.getText();
            String apellido = vistaCliente.jtf_apellido.getText();
            double credito = Double.parseDouble(vistaCliente.jtf_credito.getText());

            int registrados = clienteDAO.insertaCliente(nombre, apellido, utilidad.getFecha(), utilidad.getHora(), credito);

            if (registrados > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso, se registraron: " + registrados);
            } else {
                JOptionPane.showMessageDialog(null, "No se hizo ningun registro");
            }
        } else if (evento.getSource() == vistaCliente.btn_mostrar) {
            // aqui se pondra el codigo para mostrar los clientes
            DefaultTableModel tabla = (DefaultTableModel) vistaCliente.table_clientes.getModel();
            tabla.setRowCount(0);
            ArrayList<ClienteModel> clientes = clienteDAO.listaClientes();
            int columnas = clienteDAO.longitudDeFila(); // 6
            clientes.forEach(cliente -> {
                Object[] fila = new Object[columnas];
                fila[0] = cliente.id;
                fila[1] = cliente.nombre;
                fila[2] = cliente.apellido;
                fila[3] = cliente.f_compra;
                fila[4] = cliente.h_compra;
                fila[5] = cliente.credito;
                tabla.addRow(fila);
            });
            clienteDAO.llenaIds(vistaCliente.jc_ids);
        } else if (evento.getSource() == vistaCliente.btn_eliminar) {
            int id = Integer.parseInt(String.valueOf(vistaCliente.jc_ids.getSelectedItem()));
            int eliminados = clienteDAO.eliminaCliente(id);

            if (eliminados > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminaron: " + eliminados);
            } else {
                JOptionPane.showMessageDialog(null, "No entro al try");
            }
        } else if (evento.getSource() == vistaCliente.btn_actualizar) {

            int actualizados = clienteDAO.actualizaCliente(vistaCliente.jtf_nombre.getText(),
                    vistaCliente.jtf_apellido.getText(), Double.parseDouble(vistaCliente.jtf_credito.getText()), getId());

            if (actualizados > -1) {
                JOptionPane.showMessageDialog(null, "Se actualizaron: " + actualizados);
            } else {
                JOptionPane.showConfirmDialog(null, "No entro al try");
            }

        } else if (evento.getSource() == vistaCliente.btn_editar) {
            setId(Integer.parseInt(String.valueOf(vistaCliente.jc_ids.getSelectedItem())));
            Object[] datos;
            datos = clienteDAO.capturaDatos(id);
            vistaCliente.jtf_nombre.setText(String.valueOf(datos[0]));
            vistaCliente.jtf_apellido.setText(String.valueOf(datos[1]));
            vistaCliente.jtf_credito.setText(String.valueOf(datos[2]));
        }
    }

}
