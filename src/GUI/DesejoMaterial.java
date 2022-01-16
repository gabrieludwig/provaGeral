package GUI;
/**
 * Classe do desejo comum. Contém os gets e sets necessários para o programa
 *
 * @author Gabriel Ludwig
 */
import java.io.Serializable;

public class DesejoMaterial extends AbstractDesejo {

    public String valorMaterial;

    public DesejoMaterial(String valorMaterial, String titulo, String descricao, String dataPrevista, boolean concluido) {
        super(titulo, descricao, dataPrevista, concluido);
        this.valorMaterial = valorMaterial;
    }

    public DesejoMaterial(String valorMaterial) {
        this.valorMaterial = valorMaterial;
    }

    DesejoMaterial() {
        
    }

    public String getValorMaterial() {
        return valorMaterial;
    }

    public void setValorMaterial(String valorMaterial) {
        this.valorMaterial = valorMaterial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }   
}