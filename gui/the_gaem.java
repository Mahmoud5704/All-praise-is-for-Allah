package gui;

import adapter.Controllable;
import adapter.ControllerAdapter;
import adapter.UserAction;
import control_sided.GameController;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class the_gaem extends javax.swing.JPanel {

    private JFrame frame;
    private int[][] puzzle;
    private Controllable Adapter;

    public the_gaem(int[][] puzzle, Controllable Adapter) {
        initComponents();
        this.puzzle = puzzle;
        loadPuzzleIntoTable();
        this.Adapter = Adapter;
    }

    private void loadPuzzleIntoTable() {
        DefaultTableModel model = new DefaultTableModel(9, 9);
        state.setModel(model);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int tableRow = r;
                ////////////////////
                if (c < 9) {
                    if (puzzle[r][c] != 0) {
                        state.setRowHeight(30);
                        state.setValueAt(puzzle[r][c], tableRow, c);
                    } else {
                        state.setValueAt("", tableRow, c);
                    }
                }
            }
        }
    }

    @Override
    public void setVisible(boolean f) {
        if (f) {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateButton = new javax.swing.JButton();
        EDIT_TABLE = new javax.swing.JScrollPane();
        state = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        updateButton1 = new javax.swing.JButton();
        Undo = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        updateButton.setBackground(new java.awt.Color(102, 102, 102));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("verify");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        state.setBackground(new java.awt.Color(102, 102, 102));
        state.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        state.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        state.setForeground(new java.awt.Color(255, 255, 255));
        state.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        state.setToolTipText("MMM");
        state.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        state.setFillsViewportHeight(true);
        state.setGridColor(new java.awt.Color(255, 255, 255));
        state.setShowGrid(true);
        state.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                statePropertyChange(evt);
            }
        });
        EDIT_TABLE.setViewportView(state);

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("BACK");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel11.setText("game");

        updateButton1.setBackground(new java.awt.Color(102, 102, 102));
        updateButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton1.setForeground(new java.awt.Color(255, 255, 255));
        updateButton1.setText("solve");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(EDIT_TABLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(updateButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Undo)
                        .addGap(29, 29, 29)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EDIT_TABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Undo)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int[][] board = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                Object value = state.getValueAt(r, c);
                try {
                    board[r][c] = Integer.parseInt(value.toString());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "you must complete first",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        boolean[][] b = Adapter.verifyGame(board);
        boolean hasFalse = false;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (!b[r][c]) {
                    hasFalse = true;
                }
            }
        }
        if (hasFalse)
            new verifyy(board, b).setVisible(true);
        else {
            JOptionPane.showMessageDialog(this,
                    "bravo you are abkari!",
                    "Valid",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        frame.dispose();
        new besmallah().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        try {
            Adapter.undo(puzzle);
            loadPuzzleIntoTable();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Nothing to undo",
                    "Undo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_UndoActionPerformed
    
    private UserAction getAction(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int val;
                try{
                    val = Integer.parseInt(state.getValueAt(i, j).toString());
                }
                catch(java.lang.NumberFormatException e){ //means a cell is empty
                    continue;
                }
                if(val != puzzle[i][j]){
                    return new UserAction(i, j, val, puzzle);
                }
            }
        }
        return null; //nothing changed
    }
    private void statePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statePropertyChange
        // TODO add your handling code here:
        if(!evt.getPropertyName().equals("tableCellEditor")) //make sure that the property change is editing a cell
            return;
        UserAction action = this.getAction();
        if (action != null) { //make sure the user actually changed the value
            ControllerAdapter adapter = new ControllerAdapter(new GameController());
            try {
                System.out.println("calling the adapter");
                adapter.logUserAction(action);
                //update puzzle:
                this.puzzle = action.getNewBoard();
            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "error saving changes! please restart the game");
            }
        }
    }//GEN-LAST:event_statePropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane EDIT_TABLE;
    private javax.swing.JButton Undo;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JTable state;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
