package GUI;
/**
 * Classe do desejo comum. Contém os gets e sets necessários para o programa
 *
 * @author Gabriel Ludwig
 */
public class Desejo extends AbstractDesejo{

    public Desejo(String titulo, String descricao, String dataPrevista, boolean concluido) {
        super(titulo, descricao, dataPrevista, concluido);
    }

    public Desejo() {
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