package GUI;

/**
 * Classe para exibir o que já foi concluído
 *
 * @author Gabriel Ludwig
 */
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JFrame;

public class JanelaConcluidos extends javax.swing.JFrame {

    public String Selecionado = null;

    JanelaCadastro controle = new JanelaCadastro();

    JanelaVisualizar janela03b = new JanelaVisualizar();

    public JanelaConcluidos() {
        initComponents();
        addDesejosMateriasConcluidosNoComboBox();
        addDesejosConcluidosNoComboBox();
    }

    //método para adicionar desejos concluidos para o combobox
    private void addDesejosConcluidosNoComboBox() {
        for (int i = 1; i <= janela03b.QuantidadeDeCadastros; i++) {
            Desejo desejo = null;
            try {
                FileInputStream arquivo = new FileInputStream("cadastro" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);

                desejo = (Desejo) in.readObject();
                if (desejo.isConcluido()) {
                    jCbDesejos.addItem(desejo.getTitulo());
                }
                in.close();
                arquivo.close();
            } catch (Exception e) {
            }
        }
    }

    //mesmo método mas para adicionar desejos materiais concluidos para o combobox
    private void addDesejosMateriasConcluidosNoComboBox() {
        for (int i = 1; i <= janela03b.QuantidadeDeCadastros; i++) {
            DesejoMaterial desejoMaterial = null;
            try {
                FileInputStream arquivo = new FileInputStream("cadastro" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);

                desejoMaterial = (DesejoMaterial) in.readObject();
                if (desejoMaterial.isConcluido()) {
                    jCbDesejos.addItem(desejoMaterial.getTitulo());
                }
                in.close();
                arquivo.close();

            } catch (Exception e) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCbDesejos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));

        jCbDesejos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbDesejosActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbImprimir.setText("Visualizar_Detalhes");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jCbDesejos, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jCbDesejos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbImprimir))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbDesejosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbDesejosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbDesejosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //botão para voltar a janela de detalhes
        this.setVisible(false);
        JFrame teste = new JanelaVisualizar();
        teste.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        // botão para imprimir os detalhes do item selecionado
        this.Selecionado = jCbDesejos.getSelectedItem().toString();
        JFrame teste = new JanelaDetalhes(this.Selecionado);
        teste.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCbDesejos;
    public javax.swing.JButton jbImprimir;
    // End of variables declaration//GEN-END:variables
}
