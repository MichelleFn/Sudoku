/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import testingsudoku.BacktrackingAlgorithm;
import testingsudoku.GeneratingPuzzle;

/**
 *
 * @author myrto
 */
public class NewJFrame extends javax.swing.JFrame {

    private JTextField textField[][] = new JTextField[9][9];
//        private static int board[][];

    private static int[][] sudoku;
    private static int[][] board;
   

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();

        sudoku = new int[9][9];

        panel2.setSize(1000, 1000);
        panel2.setLayout(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textField[i][j] = new JTextField(1);
                textField[i][j].setText("" + sudoku[i][j]);
                if (sudoku[i][j] == 0) {
                    textField[i][j].setEditable(true);
                }
                panel2.add(textField[i][j]);

            }
        }

    }

//    public int[][] returnBoard() {
////        BacktrackingAlgorithm ba = new BacktrackingAlgorithm();
////        board = ba.getBoard();
////        return board;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Solve1 = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        ShowPuzzle2 = new javax.swing.JButton();
        jPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Solve1.setText("Solve");
        Solve1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Solve1MouseClicked(evt);
            }
        });

        panel2.setBackground(new java.awt.Color(0, 163, 230));
        panel2.setForeground(new java.awt.Color(174, 55, 65));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        ShowPuzzle2.setText("Show Puzzle");
        ShowPuzzle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ShowPuzzle2MousePressed(evt);
            }
        });

        jPlay.setText("Play");
        jPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPlayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(ShowPuzzle2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPlay)
                            .addComponent(Solve1))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowPuzzle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPlay)
                        .addGap(10, 10, 10)
                        .addComponent(Solve1))
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Solve1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Solve1MouseClicked
        // board = returnBoard();BacktrackingAlgorithm ba = new BacktrackingAlgorithm();
        try {
            BacktrackingAlgorithm ba = new BacktrackingAlgorithm();
            ba.solve(board);
        } catch (Exception e) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                textField[i][j].setText("" + board[i][j]);
                if (board[i][j] != 0) {
                    textField[i][j].setEditable(false);
                }

            }
        }
    
    }//GEN-LAST:event_Solve1MouseClicked

    private void ShowPuzzle2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowPuzzle2MousePressed
        // board = returnBoard();
        GeneratingPuzzle generator = new GeneratingPuzzle();
        try {
            board = generator.finalGeneration();
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                textField[i][j].setText("" + board[i][j]);
                if (board[i][j] != 0) {
                    textField[i][j].setEditable(false);
                }

            }
        }

    }//GEN-LAST:event_ShowPuzzle2MousePressed

    private void jPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPlayMouseClicked
    
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == 0) {
                    textField[i][j].setEditable(true);
                
                }
            }
       }
    }//GEN-LAST:event_jPlayMouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ShowPuzzle2;
    private javax.swing.JButton Solve1;
    private javax.swing.JButton jPlay;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
