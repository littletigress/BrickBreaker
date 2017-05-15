package brickbreaker;

/**
 *
 * @author Ludy Farhan
 */
public class BrickFrame extends javax.swing.JFrame implements Runnable{

    Thread thread;
    private boolean exit = false;
    private boolean back = false;
    
    public BrickFrame() {
        initComponents();
        thread = new Thread(playPanel);
    }

    @Override
    public void run() {
        while (!exit) {
            back = false;
            while(!back) {
                if (playPanel.lose) {
                    rematchLosePanel.setVisible(true);
                    rematchLosePanel.setEnabled(true);
                    playPanel.running = false;
                    synchronized(playPanel){
                        try {
                            playPanel.wait();
                        } catch(InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        playGame = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        backgroundMenu = new javax.swing.JLabel();
        playPanel = new brickbreaker.PlayPanel();
        rematchLosePanel = new javax.swing.JPanel();
        rematchButton = new javax.swing.JButton();
        exitToMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPanel.setLayout(null);

        playGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brickbreaker/Image/Play_1.png"))); // NOI18N
        playGame.setBorderPainted(false);
        playGame.setContentAreaFilled(false);
        playGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playGameActionPerformed(evt);
            }
        });
        menuPanel.add(playGame);
        playGame.setBounds(20, 350, 148, 99);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brickbreaker/Image/Option.png"))); // NOI18N
        jButton1.setActionCommand("optionButton");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        menuPanel.add(jButton1);
        jButton1.setBounds(200, 350, 150, 100);

        backgroundMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brickbreaker/Image/Tampilan_Utama.jpg"))); // NOI18N
        menuPanel.add(backgroundMenu);
        backgroundMenu.setBounds(0, 0, 720, 500);

        rematchLosePanel.setBackground(new java.awt.Color(153, 0, 0));
        rematchLosePanel.setEnabled(false);
        rematchLosePanel.setVisible(false);

        rematchButton.setText("Rematch");
        rematchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rematchButtonActionPerformed(evt);
            }
        });

        exitToMenuButton.setText("Exit");
        exitToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitToMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rematchLosePanelLayout = new javax.swing.GroupLayout(rematchLosePanel);
        rematchLosePanel.setLayout(rematchLosePanelLayout);
        rematchLosePanelLayout.setHorizontalGroup(
            rematchLosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rematchLosePanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(rematchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(exitToMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        rematchLosePanelLayout.setVerticalGroup(
            rematchLosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rematchLosePanelLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(rematchLosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rematchButton)
                    .addComponent(exitToMenuButton))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(playPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(rematchLosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(playPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(rematchLosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void playGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playGameActionPerformed
        menuPanel.setVisible(false);
        playPanel.setVisible(true);
        playPanel.running = true;
        if (back) {
            back = false;
            synchronized(playPanel){
                playPanel.notify();
            }
        }
        else {
            thread.start();
        }
    }//GEN-LAST:event_playGameActionPerformed

    private void rematchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rematchButtonActionPerformed
        rematchLosePanel.setVisible(false);
        rematchLosePanel.setEnabled(false);
        back = true;
        playPanel.running = true;
        synchronized(playPanel){
            playPanel.notify();
        }
    }//GEN-LAST:event_rematchButtonActionPerformed

    private void exitToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitToMenuButtonActionPerformed
        playPanel.setVisible(false);
        menuPanel.setVisible(true);
        rematchLosePanel.setVisible(false);
        rematchLosePanel.setEnabled(false);
        back = true;
    }//GEN-LAST:event_exitToMenuButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundMenu;
    private javax.swing.JButton exitToMenuButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton playGame;
    private brickbreaker.PlayPanel playPanel;
    private javax.swing.JButton rematchButton;
    private javax.swing.JPanel rematchLosePanel;
    // End of variables declaration//GEN-END:variables

}
