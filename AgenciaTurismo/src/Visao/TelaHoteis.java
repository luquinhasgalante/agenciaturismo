/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Visao;

import Modelo.CadHotel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class TelaHoteis extends javax.swing.JPanel {

    private CadHotel h;
    private Image fundo;
    /**
     * Creates new form TelaHoteis
     */
    public TelaHoteis(CadHotel h) {
        this.h = h;
        initComponents();
        escolherFundo();
        lblNome.setText(h.getNome());
        lblCidade.setText(h.getCidade());
        lblPreco.setText("" + h.getPreco());
    }
    
    public void escolherFundo() {
        String estado = this.h.getEstado();
        try{
        switch (estado) {
            case "Acre":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/acre.jpg")).getImage();
                break;

            case "Alagoas":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/alagoas.jpg")).getImage();
                break;

            case "Amapá":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/amapa.jpg")).getImage();
                break;

            case "Amazonas":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/amazonas.jpg")).getImage();
                break;

            case "Bahia":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/bahia.jpg")).getImage();
                break;

            case "Ceará":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/ceara.jpg")).getImage();
                break;

            case "Distrito Federal":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/df.jpg")).getImage();
                break;

            case "Espírito Santo":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/espiritosanto.jpg")).getImage();
                break;

            case "Goiás":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/goias.jpg")).getImage();
                break;

            case "Maranhão":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/maranhao.jpg")).getImage();
                break;

            case "Mato Grosso":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/matogrosso.jpg")).getImage();
                break;

            case "Mato Grosso do Sul":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/matogrossodosul.jpg")).getImage();
                break;

            case "Minas Gerais":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/minasgerais.jpg")).getImage();
                break;

            case "Pará":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/para.jpg")).getImage();
                break;

            case "Paraíba":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/paraiba.jpg")).getImage();
                break;

            case "Paraná":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/parana.jpg")).getImage();
                break;

            case "Pernambuco":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/pernambuco.jpg")).getImage();
                break;

            case "Piauí":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/piaui.jpg")).getImage();
                break;

            case "Rio de Janeiro":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/riodejaneiro.jpg")).getImage();
                break;

            case "Rio Grande do Norte":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/riograndedonorte.jpg")).getImage();
                break;

            case "Rio Grande do Sul":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/riograndedosul.jpg")).getImage();
                break;

            case "Rondônia":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/rondonia.jpg")).getImage();
                break;

            case "Roraima":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/roraima.jpg")).getImage();
                break;

            case "Santa Catarina":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/santacatarina.jpeg")).getImage();
                break;

            case "São Paulo":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/saopaulo.jpg")).getImage();
                break;

            case "Sergipe":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/sergipe.jpg")).getImage();
                break;

            case "Tocantins":
                this.fundo = new ImageIcon(getClass().getResource("/Imagens/tocantins.jpg")).getImage();
                break;

                case "Selecione":
                    JOptionPane.showMessageDialog(null, "Nenhum estado selecionado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Estado não encontrado.");
        }
        }
        catch(Exception e) {
            this.fundo = new ImageIcon(getClass().getResource("/Imagens/Palmeiras.png")).getImage();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        g.drawString(lblPreco.getText(), lblPreco.getX(), lblPreco.getY());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        btnAlugar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Cidade:");

        jLabel2.setText("Nome do hotel:");

        jLabel3.setText("Preço por noite:");

        lblPreco.setForeground(new java.awt.Color(255, 0, 0));

        btnAlugar.setText("Reservar");
        btnAlugar.addActionListener(this::btnAlugarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(btnAlugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlugar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        // TODO add your handling code here:
        new FormReservar(this.h);
    }//GEN-LAST:event_btnAlugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    // End of variables declaration//GEN-END:variables
}
