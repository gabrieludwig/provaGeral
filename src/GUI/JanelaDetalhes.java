package GUI;
/**
 * Classe para os detalhes de um item selecionado
 *
 * @author Gabriel Ludwig
 */
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JFrame;

public class JanelaDetalhes extends javax.swing.JFrame {
    
    JanelaVisualizar janela03b = new JanelaVisualizar();
    private String Selecionado;
    
    public JanelaDetalhes(String selecionado) {
        initComponents();
        //Deixando tudo como false para que o usuário não possa editar
        jTFTitulo.setEditable(false);
        jTADescricao.setEditable(false);
        jTFCusto.setEditable(false);
        jTFDataPrevista.setEditable(false);
        
        
        this.Selecionado = selecionado;
        DesejoMaterial desejoMaterial = null;
        Desejo desejo = null;
        for (int i = 1; i <= janela03b.QuantidadeDeCadastros; i++)  
        {
            //Basicamente pegamos o arquivo e realizamos a leitura, jogando na tela do usuário
            try 
            {
                FileInputStream arquivo = new FileInputStream("cadastro" + i +".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);
                                     
                desejoMaterial = (DesejoMaterial)in.readObject();
   
                if(this.Selecionado.equals(desejoMaterial.getTitulo()))
                {
                    jTADescricao.setText(desejoMaterial.getDescricao());
                    jTFTitulo.setText(desejoMaterial.getTitulo());
                    jTFCusto.setText(desejoMaterial.getValorMaterial());
                    jTFDataPrevista.setText(desejoMaterial.getDataPrevista());
                    jTFCusto.setEnabled(true);
                }                                                     
                in.close();
                arquivo.close();
              
            } 
            catch (Exception e)
            {
                
            }                        
        }    
        for (int i = 1; i <= janela03b.QuantidadeDeCadastros; i++)  
        {
            //Mesma coisa do que o método acima, só que sem pegar o custo        
            try 
            {
                FileInputStream arquivo = new FileInputStream("cadastro" + i +".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);
                                     
                desejo = (Desejo)in.readObject();       
                if(this.Selecionado.equals(desejo.getTitulo()))
                {
                    jTADescricao.setText(desejo.getDescricao());
                    jTFTitulo.setText(desejo.getTitulo());                    
                    jTFDataPrevista.setText(desejo.getDataPrevista());       
                    jTFCusto.setEnabled(false);
                }                                                     
                in.close();
                arquivo.close();
              
            } 
            catch (Exception e)
            {
                
            }                        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jTFTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFDataPrevista = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFCusto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));

        jTADescricao.setEditable(false);
        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jTFTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTituloActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Título:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Data Prevista:");

        jLabel4.setText("Custo:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(jTFTitulo)
                    .addComponent(jTFDataPrevista)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFDataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTituloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Botão de voltar para a janela visualizar
        JFrame teste = new JanelaVisualizar();
        teste.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFCusto;
    private javax.swing.JTextField jTFDataPrevista;
    private javax.swing.JTextField jTFTitulo;
    // End of variables declaration//GEN-END:variables
}