package GUI;
/**
 * Classe do desejo material. Contém os gets e sets necessários para o programa
 *
 * @author Gabriel Ludwig
 */
import java.io.Serializable;

public class QuantidadeCadastrada implements Serializable {

    int quantidade;

    public QuantidadeCadastrada(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}