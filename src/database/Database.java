package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String nombreDB = "mvc";
    private String usuario = "root";
    private String clave = "12345";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/" + nombreDB;

    public Connection con = null;

    public Database() {
        try{
        Class.forName(driver);

        this.con = DriverManager.getConnection(url, usuario, clave);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }        
}
