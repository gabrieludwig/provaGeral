package GUI;

/**
 * Classe para visualização geral dos desejos, também para concluí-los
 *
 * @author Gabriel Ludwig
 */
import static GUI.JanelaCadastro.clienteLista;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JanelaVisualizar extends javax.swing.JFrame {

    JanelaCadastro janela03 = new JanelaCadastro();
    ArrayList<DesejoMaterial> clienteLista = JanelaCadastro.clienteLista;

    public int QuantidadeDeCadastros = janela03.verificaQuantidadeDeCadastros();

    public String Selecionado = null;

    public JanelaVisualizar() {
        initComponents();
        jRBAll.setSelected(true);
        jRBMaterial.setSelected(false);
        jRBMaterial.setSelected(false);
        jCbDesejos.removeAllItems();
        addDesejosMateriasNoComboBox();
        addDesejosNoComboBox();
    }

    //Método para concluir desejos
    private void setDesejoConcluido(String selecionado) {
        for (int i = 1; i <= janela03.verificaQuantidadeDeCadastros(); i++) {
            Desejo desejo = null;
            try {
                FileInputStream arquivo = new FileInputStream("cadastro" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);

                desejo = (Desejo) in.readObject();
                //if pra dizer se o desejo já foi concluído ou para cadastrar
                if (desejo.getTitulo().equals(selecionado)) {
                    if (desejo.isConcluido()) {
                        JOptionPane.showMessageDialog(null, "Este desejo já foi concluido", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Desejo Concluido com sucesso! Parabens!");
                    }
                    desejo.setConcluido(true);
                }

                in.close();
                arquivo.close();

                if (desejo.getTitulo().equals(selecionado)) {
                    try {
                        FileOutputStream arquivoParaAtualizar = new FileOutputStream("cadastro" + i + ".ser");
                        ObjectOutputStream out = new ObjectOutputStream(arquivoParaAtualizar);
                        //escreve no arquivo com out a quantidade cadastrada
                        out.writeObject(desejo);
                        //fechar o meio de comunicação
                        out.close();
                        //fechar arquivo
                        arquivo.close();

                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {

            }
        }
    }

    private void setDesejoMaterialConcluido(String selecionado) {
        for (int i = 1; i <= janela03.verificaQuantidadeDeCadastros(); i++) {
            DesejoMaterial desejoMaterial = null;
            try {
                FileInputStream arquivo = new FileInputStream("cadastro" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);

                desejoMaterial = (DesejoMaterial) in.readObject();

                if (desejoMaterial.getTitulo().equals(selecionado)) {
                    if (desejoMaterial.isConcluido()) {
                        JOptionPane.showMessageDialog(null, "Este desejo já foi concluido", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Desejo Concluido com sucesso! Parabens!");
                    }
                    desejoMaterial.setConcluido(true);
                }

                in.close();
                arquivo.close();

                if (desejoMaterial.getTitulo().equals(selecionado)) {
                    try {
                        FileOutputStream arquivoParaAtualizar = new FileOutputStream("cadastro" + i + ".ser");
                        ObjectOutputStream out = new ObjectOutputStream(arquivoParaAtualizar);
                        //escreve no arquivo com out a quantidade cadastrada
                        out.writeObject(desejoMaterial);
                        //fechar o meio de comunicação
                        out.close();
                        //fechar arquivo
                        arquivo.close();

                    } catch (Exception e) {

                    }
                }

            } catch (Exception e) {

            }
        }
    }

    private void addDesejosNoComboBox() {
        for (int i = 1; i <= janela03.verificaQuantidadeDeCadastros(); i++) {
            Desejo desejo = null;
            try {
                FileInputStream arquivo = new FileInputStream("cadastro" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);

                desejo = (Desejo) in.readObject();

                if (!desejo.isConcluido()) {
                    jCbDesejos.addItem(desejo.getTitulo());
                }

                in.close();
                arquivo.close();

            } catch (Exception e) {

            }
        }
    }

    private void addDesejosMateriasNoComboBox() {
        for (int i = 1; i <= janela03.verificaQuantidadeDeCadastros(); i++) {
            DesejoMaterial desejoMaterial = null;
            try {
                FileInputStream arquivo = new FileInputStream("cadastro" + i + ".ser");
                ObjectInputStream in = new ObjectInputStream(arquivo);

                desejoMaterial = (DesejoMaterial) in.readObject();

                if (!desejoMaterial.isConcluido()) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCbDesejos = new javax.swing.JComboBox();
        jbImprimir = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        voltarLista = new javax.swing.JButton();
        jRBMaterial = new javax.swing.JRadioButton();
        jRBNotMaterial = new javax.swing.JRadioButton();
        jRBAll = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Desejos");

        jCbDesejos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbDesejosActionPerformed(evt);
            }
        });

        jbImprimir.setText("Visualizar Detalhes");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jbRemover.setText("Concluir");
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        voltarLista.setText("Voltar");
        voltarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarListaActionPerformed(evt);
            }
        });

        jRBMaterial.setText("Desejos Materias");
        jRBMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMaterialActionPerformed(evt);
            }
        });

        jRBNotMaterial.setText("Desejos");
        jRBNotMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNotMaterialActionPerformed(evt);
            }
        });

        jRBAll.setText("Todos Desejos");
        jRBAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBAllActionPerformed(evt);
            }
        });

        jButton1.setText("Visualizar Concluidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRBMaterial)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRBNotMaterial)
                                        .addGap(89, 89, 89)
                                        .addComponent(jRBAll))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbRemover)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbImprimir)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addGap(28, 28, 28)
                                        .addComponent(voltarLista)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCbDesejos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBMaterial)
                    .addComponent(jRBNotMaterial)
                    .addComponent(jRBAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCbDesejos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRemover)
                    .addComponent(jbImprimir)
                    .addComponent(jButton1)
                    .addComponent(voltarLista))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        //botão que concluí o desejo
        this.Selecionado = jCbDesejos.getSelectedItem().toString();
        setDesejoConcluido(this.Selecionado);
        setDesejoMaterialConcluido(this.Selecionado);
        jCbDesejos.removeAllItems();
        addDesejosMateriasNoComboBox();
        addDesejosNoComboBox();
    }//GEN-LAST:event_jbRemoverActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        //botão para mostrar detalhes do desejo
        this.Selecionado = jCbDesejos.getSelectedItem().toString();
        JFrame teste = new JanelaDetalhes(this.Selecionado);
        teste.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jCbDesejosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbDesejosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbDesejosActionPerformed

    private void voltarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarListaActionPerformed
        //Botão para voltar para a janela de cadastro
        this.setVisible(false);
        JFrame teste = new JanelaCadastro();
        teste.setVisible(true);
    }//GEN-LAST:event_voltarListaActionPerformed

    private void jRBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAllActionPerformed
        //Botão para selecionar todos os desejos 
        jRBMaterial.setSelected(false);
        jRBNotMaterial.setSelected(false);
        jCbDesejos.removeAllItems();
        addDesejosMateriasNoComboBox();
        addDesejosNoComboBox();
    }//GEN-LAST:event_jRBAllActionPerformed

    private void jRBNotMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNotMaterialActionPerformed
        //Botão para selecionar apenas os desejos 
        jRBAll.setSelected(false);
        jRBMaterial.setSelected(false);
        jCbDesejos.removeAllItems();
        addDesejosNoComboBox();
    }//GEN-LAST:event_jRBNotMaterialActionPerformed

    private void jRBMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMaterialActionPerformed
        //Botão para selecionar apenas os desejos materiais
        jRBAll.setSelected(false);
        jRBNotMaterial.setSelected(false);
        jCbDesejos.removeAllItems();
        addDesejosMateriasNoComboBox();
    }//GEN-LAST:event_jRBMaterialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //botão para mostrar concluídos
        JFrame teste = new JanelaConcluidos();
        teste.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCbDesejos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBAll;
    private javax.swing.JRadioButton jRBMaterial;
    private javax.swing.JRadioButton jRBNotMaterial;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton voltarLista;
    // End of variables declaration//GEN-END:variables
}
