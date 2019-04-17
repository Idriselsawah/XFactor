import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
    
public class MainOld {
    public static void main (String[] args) {
    String message = "";
    // stringa per connettersi al database
    String connURL = "jdbc:sqlserver://213.140.22.237\\SQLEXPRESS:1433;databaseName=XFactor;user=gottardo.joshua;password=xxx123#";
    // abbreviata
    // String connURL = "jdbc:sqlserver://213.140.22.237; databaseName=###;user=###;password=###";
    try { // Load SQL Server JDBC driver and establish connection.
        Connection connection = DriverManager.getConnection(connURL); 
        message += "connection OK\n";
        // creazione di un oggetto per effettuare la richiesta al DB 
        Statement stmt = connection.createStatement(); // istruzione SQL da eseguire
        String sql = "SELECT * FROM Giudice";
        // esecuzione dell’istruzione: il risultato viene inserito nell’oggetto rs
        // per essere elaborato 
        ResultSet rs = stmt.executeQuery(sql);
        // ciclo per prendere tutte i record prelevati dalla tabella del database 
        while(rs.next()){
            String first = rs.getString("Nome");
            String last = rs.getString("Cognome");
            String alias = rs.getString("Soprannome");
            message += first + " | " + last + " | " + alias + "\n";
        }
        rs.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(message); }
}