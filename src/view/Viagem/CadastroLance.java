package view.Viagem;

import control.Funcoes;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import model.Captura;
import model.Lance;

public class CadastroLance extends javax.swing.JFrame {

    Lance lance = new Lance();
    java.util.Date data_saida_viagem;
    java.util.Date data_chegada_viagem;

    public CadastroLance(java.util.Date data_saida, java.util.Date data_chegada) {
        initComponents();
        URL url = this.getClass().getResource("/arquivos/Icone.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.data_saida_viagem = data_saida;
        this.data_chegada_viagem = data_chegada;
        montaCampos();
    }

    private void montaCampos() {
        JSpinner.DateEditor data_editor = new JSpinner.DateEditor(jTextData, "dd/MM/yyyy");
        jTextData.setEditor(data_editor);

        JSpinner.DateEditor hora_inicial_editor = new JSpinner.DateEditor(jTextHoraInicial, "HH:mm");
        jTextHoraInicial.setEditor(hora_inicial_editor);

        JSpinner.DateEditor hora_final_editor = new JSpinner.DateEditor(jTextHoraFinal, "HH:mm");
        jTextHoraFinal.setEditor(hora_final_editor);

        jTextLatitudeInicial.setValue(0.00000);
        jTextLongitudeInicial.setValue(0.00000);
        jTextProfundidade.setValue(0.00000);
        jTextAlturaRede.setValue(0.00000);
        jTextComprimentoRede.setValue(0.00000);
        jTextTamanhoMalha.setValue(0.00000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextHoraFinal = new javax.swing.JSpinner();
        jTextProfundidade = new javax.swing.JFormattedTextField();
        jTextTamanhoMalha = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextAlturaRede = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextLongitudeInicial = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextHoraInicial = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextData = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jTextLatitudeInicial = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextComprimentoRede = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCapturas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButtonInserirCaptura = new javax.swing.JButton();
        jButtonRemoverCaptura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Lance");
        setMaximumSize(new java.awt.Dimension(807, 707));
        setMinimumSize(new java.awt.Dimension(807, 707));
        setPreferredSize(new java.awt.Dimension(807, 581));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações Gerais"));
        jPanel1.setMaximumSize(new java.awt.Dimension(763, 215));
        jPanel1.setMinimumSize(new java.awt.Dimension(763, 215));
        jPanel1.setPreferredSize(new java.awt.Dimension(763, 215));
        jPanel1.setLayout(null);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Profundidade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel9.setText("Hora Final");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(jLabel9, gridBagConstraints);

        jTextHoraFinal.setModel(new javax.swing.SpinnerDateModel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 10);
        jPanel5.add(jTextHoraFinal, gridBagConstraints);

        jTextProfundidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000"))));
        jTextProfundidade.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 10);
        jPanel5.add(jTextProfundidade, gridBagConstraints);

        jTextTamanhoMalha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000"))));
        jTextTamanhoMalha.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 18, 10);
        jPanel5.add(jTextTamanhoMalha, gridBagConstraints);

        jLabel7.setText("Tamanho da Malha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(jLabel7, gridBagConstraints);

        jTextAlturaRede.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000"))));
        jTextAlturaRede.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 18, 0);
        jPanel5.add(jTextAlturaRede, gridBagConstraints);

        jLabel5.setText("Altura da Rede");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(jLabel5, gridBagConstraints);

        jTextLongitudeInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000"))));
        jTextLongitudeInicial.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 0);
        jPanel5.add(jTextLongitudeInicial, gridBagConstraints);

        jLabel2.setText("Longitude Inicial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(jLabel2, gridBagConstraints);

        jTextHoraInicial.setModel(new javax.swing.SpinnerDateModel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 0);
        jPanel5.add(jTextHoraInicial, gridBagConstraints);

        jLabel8.setText("Hora Inicial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(jLabel8, gridBagConstraints);

        jLabel6.setText("Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel5.add(jLabel6, gridBagConstraints);

        jTextData.setModel(new javax.swing.SpinnerDateModel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel5.add(jTextData, gridBagConstraints);

        jLabel1.setText("Latitude Inicial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel5.add(jLabel1, gridBagConstraints);

        jTextLatitudeInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000"))));
        jTextLatitudeInicial.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jPanel5.add(jTextLatitudeInicial, gridBagConstraints);

        jLabel4.setText("Comprimento da Rede");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel5.add(jLabel4, gridBagConstraints);

        jTextComprimentoRede.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000"))));
        jTextComprimentoRede.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 18, 0);
        jPanel5.add(jTextComprimentoRede, gridBagConstraints);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(6, 16, 416, 192);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel2.add(btGravar);

        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Capturas"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jTableCapturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Especie", "Peso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCapturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCapturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCapturas);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 200));

        jButtonInserirCaptura.setText("Inserir");
        jButtonInserirCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirCapturaActionPerformed(evt);
            }
        });

        jButtonRemoverCaptura.setText("Remover");
        jButtonRemoverCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverCapturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRemoverCaptura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInserirCaptura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButtonInserirCaptura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoverCaptura)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        try {
            if (valida()) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                //Formata data
                java.util.Date data_formatada = formato.parse(Funcoes.dataSQL((SpinnerDateModel) jTextData.getModel()));
                java.sql.Date sql = new java.sql.Date(data_formatada.getTime());

                //Formata hora
                formato = new SimpleDateFormat("HH:mm");
                java.util.Date hora = formato.parse(Funcoes.horaSQL((SpinnerDateModel) jTextHoraInicial.getModel()));
                java.sql.Time hora_inicial = new java.sql.Time(hora.getTime());

                hora = formato.parse(Funcoes.horaSQL((SpinnerDateModel) jTextHoraFinal.getModel()));
                java.sql.Time hora_final = new java.sql.Time(hora.getTime());

                //Formata casas decimais
                String latitude = Funcoes.formatarDouble(jTextLatitudeInicial.getText());
                String longitude = Funcoes.formatarDouble(jTextLongitudeInicial.getText());
                String profundidade = Funcoes.formatarDouble(jTextProfundidade.getText());
                String comprimento_rede = Funcoes.formatarDouble(jTextComprimentoRede.getText());
                String altura_rede = Funcoes.formatarDouble(jTextAlturaRede.getText());
                String tamanho_malha = Funcoes.formatarDouble(jTextTamanhoMalha.getText());

                lance.setData(sql);
                lance.setHora_inicial(hora_inicial);
                lance.setHora_final(hora_final);
                lance.setLatitude_inicial(Double.parseDouble(latitude));
                lance.setLongitude_inicial(Double.parseDouble(longitude));
                lance.setProfundidade(Double.parseDouble(profundidade));
                lance.setComprimento_rede(Double.parseDouble(comprimento_rede));
                lance.setAltura_rede(Double.parseDouble(altura_rede));
                lance.setTamanho_malha(Double.parseDouble(tamanho_malha));

                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gravar o lance! \nVerifique: " + ex.getMessage());
        }
    }//GEN-LAST:event_btGravarActionPerformed

    private boolean valida() throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date data = formato.parse(Funcoes.dataSQL((SpinnerDateModel) jTextData.getModel()));

        //Formata hora
        formato = new SimpleDateFormat("HH:mm");
        java.util.Date hora = formato.parse(Funcoes.horaSQL((SpinnerDateModel) jTextHoraInicial.getModel()));
        java.sql.Time hora_inicial = new java.sql.Time(hora.getTime());

        hora = formato.parse(Funcoes.horaSQL((SpinnerDateModel) jTextHoraFinal.getModel()));
        java.sql.Time hora_final = new java.sql.Time(hora.getTime());

        if ((data.after(data_chegada_viagem)) || (data.before(data_saida_viagem))) {
            jTextData.setFocusable(true);
            throw new Exception("A data deve estar entre a data de saída e a data de chegada da viagem.");
        }
        
        if (hora_inicial.after(hora_final)){
            jTextHoraFinal.setFocusable(true);
            throw new Exception("A hora final deve ser posterior à hora inicial.");
        }

        if ((Double.parseDouble(Funcoes.formatarDouble(jTextLatitudeInicial.getText())) < -90) || (Double.parseDouble(Funcoes.formatarDouble(jTextLatitudeInicial.getText())) > 90)) {
            jTextLatitudeInicial.setFocusable(true);
            throw new Exception("Latitude deve estar entre -90° e 90°.");
        }

        if ((Double.parseDouble(Funcoes.formatarDouble(jTextLongitudeInicial.getText())) < 0) || (Double.parseDouble(Funcoes.formatarDouble(jTextLongitudeInicial.getText())) > 180)) {
            jTextLongitudeInicial.setFocusable(true);
            throw new Exception("Longitude deve estar entre 0° e 180°.");
        }

        if (Double.parseDouble(Funcoes.formatarDouble(jTextProfundidade.getText())) <= 0) {
            jTextProfundidade.setFocusable(true);
            throw new Exception("Profundidade deve ser maior que zero.");
        }

        if (Double.parseDouble(Funcoes.formatarDouble(jTextComprimentoRede.getText())) <= 0) {
            jTextComprimentoRede.setFocusable(true);
            throw new Exception("Comprimento da rede deve ser maior que zero.");
        }

        if (Double.parseDouble(Funcoes.formatarDouble(jTextAlturaRede.getText())) <= 0) {
            jTextAlturaRede.setFocusable(true);
            throw new Exception("Tamanho da rede deve ser maior que zero.");
        }

        if (Double.parseDouble(Funcoes.formatarDouble(jTextTamanhoMalha.getText())) <= 0) {
            jTextTamanhoMalha.setFocusable(true);
            throw new Exception("Tamanho da malha deve ser maior que zero.");
        }

        return true;
    }

    public Lance getLance() {
        return this.lance;
    }

    private void jTableCapturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCapturasMouseClicked

        if (evt.getClickCount() == 2) {
            //
        }
    }//GEN-LAST:event_jTableCapturasMouseClicked

    private void jButtonInserirCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirCapturaActionPerformed
        CadastroCaptura cadastroCaptura = new CadastroCaptura();
        cadastroCaptura.setVisible(true);
        cadastroCaptura.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                Captura captura = cadastroCaptura.getCaptura();
                String especie = cadastroCaptura.getEspecie();

                if (captura.getPeso() > 0) {
                    lance.inserirCaptura(captura);

                    //Insere na lista
                    DefaultTableModel model = (DefaultTableModel) jTableCapturas.getModel();
                    model.addRow(new Object[]{especie, captura.getPeso()});
                    jTableCapturas.setModel(model);
                }
            }
        });
    }//GEN-LAST:event_jButtonInserirCapturaActionPerformed

    private void jButtonRemoverCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCapturaActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableCapturas.getModel();
        lance.removerCaptura(jTableCapturas.getSelectedRow());
        model.removeRow(jTableCapturas.getSelectedRow());
        jTableCapturas.setModel(model);
    }//GEN-LAST:event_jButtonRemoverCapturaActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroLance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CadastroLance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton jButtonInserirCaptura;
    private javax.swing.JButton jButtonRemoverCaptura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCapturas;
    private javax.swing.JFormattedTextField jTextAlturaRede;
    private javax.swing.JFormattedTextField jTextComprimentoRede;
    private javax.swing.JSpinner jTextData;
    private javax.swing.JSpinner jTextHoraFinal;
    private javax.swing.JSpinner jTextHoraInicial;
    private javax.swing.JFormattedTextField jTextLatitudeInicial;
    private javax.swing.JFormattedTextField jTextLongitudeInicial;
    private javax.swing.JFormattedTextField jTextProfundidade;
    private javax.swing.JFormattedTextField jTextTamanhoMalha;
    // End of variables declaration//GEN-END:variables
}
