package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Utilidades {
    

    // funcion que setea La fecha
    public String getFecha(){
        LocalDateTime objDate = LocalDateTime.now(); // 2021-08-09 T08:14:53:123
        // yyyy-MM-dd
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.valueOf(objDate.format(dtf));
    }
    
    public String getHora(){
        LocalDateTime objHour = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.valueOf(objHour.format(dtf));
    }    
    
    

}
