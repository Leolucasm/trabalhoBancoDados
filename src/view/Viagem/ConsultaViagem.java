package view.Viagem;

import control.Funcoes;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaViagem extends javax.swing.JFrame {

    public ConsultaViagem() {
        initComponents();
        URL url = this.getClass().getResource("/arquivos/Icone.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        realizarConsulta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViagens = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btIncluir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Consulta de Viagens");
        setMinimumSize(new java.awt.Dimension(720, 600));
        setPreferredSize(new java.awt.Dimension(720, 600));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jTableViagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Tamanho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableViagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableViagensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableViagens);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(92, 33));

        btIncluir.setText("Incluir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(btIncluir);

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableViagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableViagensMouseClicked

        if (evt.getClickCount() == 2) {
            //
        }
    }//GEN-LAST:event_jTableViagensMouseClicked

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableViagens.getModel();
        String codigoPorto = model.getValueAt(jTableViagens.getSelectedRow(), 0).toString();
        try {
            Funcoes.excluirRegistro("viagem", codigoPorto);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Houve um erro ao excluir o registro! \nVerifique a mensagem: " + ex.getMessage());
        }
        realizarConsulta();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        CadastroViagem cadastroViagem = new CadastroViagem();
        cadastroViagem.show();
        cadastroViagem.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                realizarConsulta();
            }
        });
    }//GEN-LAST:event_btIncluirActionPerformed

    private void realizarConsulta() {              
        try {
            jTableViagens.setModel(Funcoes.getViagens(""));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaViagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableViagens;
    // End of variables declaration//GEN-END:variables
}
