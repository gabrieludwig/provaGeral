package GUI;

/**Classe para execução e criação dos objetos gerais
 *  @author Gabriel Ludwig
 * @version 1.0
 * @since Release 1 da aplicação
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    //criação dos objetos gerais
    public static void main(String[] args) {
        JFrame teste = new JanelaCadastro();
        teste.setVisible(true);
        Locale locale = new Locale ("pt", "BR");
        ConectaBD con = new ConectaBD();
        
    }
}