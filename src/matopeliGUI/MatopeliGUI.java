package matopeliGUI;

/**
 *
 * @author lammenoj
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import matopeli.Logiikka;

public class MatopeliGUI extends javax.swing.JFrame {

    Logiikka peli = new Logiikka();
    Timer kello;
    Kuuntelija kuuntelija = new Kuuntelija();
    BufferedImage bf;

    private class Kuuntelija implements ActionListener {

        private String kentta;
        private int nopeus;
        private int pelimuoto;
        private int delay;

        public Kuuntelija() {
            kentta = "classic";
            nopeus = 100;
            pelimuoto = 0;
            delay = 0;
        }

        public void asetaKentta(String nimi) {
            this.kentta = nimi;
            peli.reset(nimi);
        }

        public void reset() {
            peli.reset(kentta);
        }

        public void asetaNopeus(int nopeus) {
            kello.setDelay(nopeus);
            pelimuoto = 0;
        }

        public void asetaKasvavaNopeus() {
            nopeus = 200;
            kello.setDelay(nopeus);
            pelimuoto = 1;
            delay = 0;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (peli.etene() == true) {
                repaint();
                if (pelimuoto == 1) {
                    delay = delay + 1;
                    if (delay == 5 && nopeus > 20) {
                        nopeus = nopeus - 1;
                        delay = 0;
                    }
                    kello.setDelay(nopeus);
                }
            } else {
                kello.stop();
                showScore();
                peli.reset(kentta);

                if (pelimuoto == 1) {
                    this.asetaKasvavaNopeus();
                }
                repaint();
            }
        }
    }

    /**
     * Creates new form matopeliGUI2
     */
    public MatopeliGUI() {

        initComponents();
        kello = new Timer(100, kuuntelija);
        this.setSize(280, 330);
        bf = new BufferedImage(560, 630, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreLabel = new javax.swing.JLabel();
        TopScoreLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matopeli");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(280, 330));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        scoreLabel.setBackground(new java.awt.Color(255, 255, 255));
        scoreLabel.setLabelFor(this);
        scoreLabel.setText("Score");
        scoreLabel.setMaximumSize(new java.awt.Dimension(37, 20));
        scoreLabel.setMinimumSize(new java.awt.Dimension(37, 20));
        scoreLabel.setPreferredSize(new java.awt.Dimension(37, 20));

        TopScoreLabel.setBackground(new java.awt.Color(255, 255, 255));
        TopScoreLabel.setText("TopScore");
        TopScoreLabel.setMaximumSize(new java.awt.Dimension(60, 20));
        TopScoreLabel.setMinimumSize(new java.awt.Dimension(60, 20));
        TopScoreLabel.setPreferredSize(new java.awt.Dimension(60, 20));

        jMenu1.setText("level");

        jMenuItem1.setText("classic");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("no walls");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("cross");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("speed");

        jMenuItem4.setText("fast");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("normal");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("slow");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator1);

        jMenuItem7.setText("increasing");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("help");

        jMenuItem9.setText("abaut");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TopScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TopScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int nappain = evt.getKeyCode();

        if (nappain == 38 && kello.isRunning() == true) {  // ylänuoli
            peli.asetaSuunta("ylös");
        } else if (nappain == 40 && kello.isRunning() == true) {  // alanuoli
            peli.asetaSuunta("alas");
        } else if (nappain == 37 && kello.isRunning() == true) { // vasennuoli
            peli.asetaSuunta("vasemmalle");
        } else if (nappain == 39 && kello.isRunning() == true) { // oikeanuoli
            peli.asetaSuunta("oikealle");
        } else if (nappain == 32 && kello.isRunning() == true) { //Space
            kello.stop();
        } else if (nappain == 32 && kello.isRunning() == false) { //Space
            kello.start();
        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        kuuntelija.asetaKentta("classic");
        this.setSize(280, 330);
        repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        kuuntelija.asetaKentta("nowalls");
        this.setSize(280, 330);
        repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        kuuntelija.asetaKentta("cross");
        this.setSize(280, 330);
        repaint();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        kello.setDelay(50);
        kuuntelija.asetaNopeus(50);
        kuuntelija.reset();
        repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        kello.setDelay(100);
        kuuntelija.asetaNopeus(100);
        kuuntelija.reset();
        repaint();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        kello.setDelay(150);
        kuuntelija.asetaNopeus(150);
        kuuntelija.reset();
        repaint();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        kuuntelija.asetaKasvavaNopeus();
        kuuntelija.reset();
        repaint();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_formMouseClicked

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        about();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MatopeliGUI().setVisible(true);
            }
        });
    }

    public void animation(Graphics g) {
        super.paint(g);

        scoreLabel.setText("Score: " + peli.pisteet());
        TopScoreLabel.setText("Top Score: " + peli.pisteetMax());

        int[][] alue = peli.getKentta();

        for (int i = 0; i < alue.length; i++) {
            for (int j = 0; j < alue[i].length; j++) {
                if (alue[i][j] == 0) {
                    g.setColor(Color.WHITE);
                } else if (alue[i][j] == 1) {
                    g.setColor(Color.BLACK);
                } else if (alue[i][j] == 3) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.pink);
                }
                g.fillRect(j * 10 + 30, i * 10 + 80, 9, 9);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        animation(bf.getGraphics()); //bf is the BufferedImage object
        g.drawImage(bf, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    //Popup ikkunat
    //----------------------------------------------------------
    public void showScore() {
        JOptionPane.showMessageDialog(this, "Game Over!!");
    }
    
    public void about(){
        JOptionPane.showMessageDialog(this, "not done yet");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TopScoreLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
