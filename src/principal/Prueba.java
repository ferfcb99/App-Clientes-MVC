package principal;

import Modelo.ClienteModel;
import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Prueba {

    public ArrayList<Integer> ids_clientes() {
        try {
            Database db = new Database();
            PreparedStatement ps;
            String query = "SELECT id FROM Cliente";
            ps = db.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            ArrayList<Integer> ids = new ArrayList<>();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }
            return ids;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        ArrayList<Integer> ids = new ArrayList<>();
        ids = p.ids_clientes();
        ids.forEach(id -> {
            System.out.println(id);
        });
        
    }

}
