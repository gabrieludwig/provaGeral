package GUI;
/**
 * Classe para conectar com o BD
 *
 * @author Gabriel Ludwig
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConectaBD {

    private String url;
    private String usuario;
    private String senha;
    private Connection con;

   /*public ConectaBD() {
        url = "jdbc:postgresql://localhost:5432/provaProgramacao";
        usuario = "postgres";
        senha = "admin"; 

        try {
            //fazendo a conexão do banco
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace(); // se der algum erro já mostra na tela
        }
    }

    public int executaSQL(String sql) {
        try {
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }*/
   
    public static ConectaBD conectaBD;
   
    public static ConectaBD getInstance (){
        if (conectaBD == null){
            conectaBD = new ConectaBD ();           
        }
        return conectaBD;
    }

    public Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/provaProgramacao", "postgres", "admin");
    }
    
    public static void main (String[]args){
        try{
        System.out.println(getInstance().getConnection());
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JFrame teste = new JanelaCadastro();
        teste.setVisible(true);
        ConectaBD con = new ConectaBD();
    }
}
