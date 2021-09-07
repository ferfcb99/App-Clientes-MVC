package Modelo;

import database.Database;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class ClienteModelDAO {
    // Operaciones CRUD -> CreateReadUpdateDelete

    // funcion que inserta un registro y verifica si no hubo errores: 1 - registrado, 0 - error
    public int insertaCliente(String nombre, String apellido, String f_compra, String h_compra, Double credito) {
        // query 
        String query = "{CALL sp_NuevoCliente(?, ?, ?, ?, ?)}";
        CallableStatement cs;
        Database db = new Database();
        int cRegistros = 0;
        try {
            cs = db.con.prepareCall(query);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setString(3, f_compra);
            cs.setString(4, h_compra);
            cs.setDouble(5, credito);

            cRegistros = cs.executeUpdate();

            return cRegistros;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cRegistros;
    }

    // Read - Leer
    // funcion que retorne una lista de objetos tipo Cliente
    public ArrayList<ClienteModel> listaClientes() {
        ArrayList<ClienteModel> clientes = new ArrayList();
        ClienteModel cliente;
        try {
            Database db = new Database();
            PreparedStatement ps;
            String query = "SELECT id, nombre, apellido, f_compra, h_compra, credito FROM Cliente";
            ps = db.con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            int columnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                cliente = new ClienteModel(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("f_compra"), rs.getString("h_compra"), rs.getDouble("credito"));
                clientes.add(cliente);
            }

            return clientes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int longitudDeFila() {
        Database db = new Database();
        PreparedStatement ps;
        String query = "SELECT id, nombre, apellido, f_compra, h_compra, credito FROM Cliente";
        try {
            ps = db.con.prepareStatement(query);
            return ps.executeQuery().getMetaData().getColumnCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
