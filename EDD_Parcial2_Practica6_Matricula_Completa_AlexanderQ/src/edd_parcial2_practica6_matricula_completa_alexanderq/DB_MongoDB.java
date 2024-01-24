package edd_parcial2_practica6_matricula_completa_alexanderq;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Quizhpe
 */
public class DB_MongoDB {
    //DB - CONSTRUCTOR
    public MongoDatabase ConnectDB (){
        MongoDatabase database = null;
        int puerto = 27017;
        String server = "localhost";
        
        try {
            MongoClient query = new MongoClient(server, puerto);
            database = query.getDatabase("Gestion_Matriculas_AMQC");
            System.out.println("MONGODB-CONNECT");
            return database;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al conectar.");
        }
        return database;
    }
}
