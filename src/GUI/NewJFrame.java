/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import testingsudoku.BacktrackingAlgorithm;

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
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        sudoku = new int[9][9];

        frame.setVisible(true);
        panel2.setSize(500, 500);
        panel2.setLayout(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textField[i][j] = new JTextField(1);
                textField[i][j].setText("" + sudoku[i][j]);
                if (sudoku[i][j] != 0) {
                    textField[i][j].setEditable(false);
                }
                panel2.add(textField[i][j]);

            }
        }

    }
    public int[][] returnBoard(){
    BacktrackingAlgorithm ba= new BacktrackingAlgorithm();
    board=ba.getBoard();
    return board;
    }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Solve1.setText("Solve");
        Solve1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Solve1MouseClicked(evt);
            }
        });

        panel2.setBackground(new java.awt.Color(0, 163, 230));
        panel2.setEnabled(false);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Solve1)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ShowPuzzle2)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ShowPuzzle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Solve1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Solve1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Solve1MouseClicked
           
    }//GEN-LAST:event_Solve1MouseClicked

    private void ShowPuzzle2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowPuzzle2MousePressed
       
        board=returnBoard();
     
        //JFrame frame = new JFrame();
        //frame.setSize(500, 500);
        //sudoku = new int[9][9];

        //frame.setVisible(true);
        panel2.setSize(500, 500);
        panel2.setLayout(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textField[i][j] = new JTextField(1);
                textField[i][j].setText("" + board[i][j]);
                if (board[i][j] != 0) {
                    textField[i][j].setEditable(false);
                }
                panel2.add(textField[i][j]);
            }
        }
    }//GEN-LAST:event_ShowPuzzle2MousePressed

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
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
