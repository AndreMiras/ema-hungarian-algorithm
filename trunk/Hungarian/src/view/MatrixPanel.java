/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MatrixPanel.java
 *
 * Created on May 6, 2011, 2:14:33 PM
 */

package view;

/**
 *
 * @author andre
 */
public class MatrixPanel extends javax.swing.JPanel {

    /* ordre de la matrice */
    private static final int DEFAULT_MATRIX_ORDER = 5;
    private int matrixOrder = DEFAULT_MATRIX_ORDER;

    /** Creates new form MatrixPanel */
    public MatrixPanel() {
        initComponents();

        setTableModel(matrixOrder); // TODO: hardcoded value
    }

    /*
     * returns an int matrix from the JTable values
     */
    public int[][] getIntMatrix()
    {
        int rowCount = jTable1.getModel().getRowCount();
        int columnCount = jTable1.getModel().getColumnCount();
        
        int matrix[][] = new int[columnCount][rowCount];
        // Object matrix[][] = new Object[columnCount][rowCount];

        for(int row_index=0; row_index<rowCount; row_index++)
        {
            for(int col_index=0; col_index<columnCount; col_index++)
            {
                matrix[row_index][col_index] =
                        Integer.parseInt(
                                jTable1.getModel().getValueAt(row_index, col_index).toString());
            }
        }

        return matrix;
    }

    /*
     * Set the JTable Matrix to zero
     */
    private void clearTableMatrix(javax.swing.JTable jTableMatrix)
    {
        int rowCount = jTableMatrix.getModel().getRowCount();
        int columnCount = jTableMatrix.getModel().getColumnCount();
        
        for(int row_index=0; row_index<rowCount; row_index++)
        {
            for(int col_index=0; col_index<columnCount; col_index++)
            {
                jTableMatrix.getModel().setValueAt(0, row_index, col_index);
            }
        }
    }
    
    private void setTableModel(int matrixOrder)
    {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Integer [matrixOrder][matrixOrder],
            new String [matrixOrder]
        ));
        // clearTableMatrix(jTable1);
    }

    /*
     * Set matrixOrder et update les vues concernees
     */
    private void setMatrixOrder(int matrixOrder)
    {
        this.matrixOrder = matrixOrder;
        setTableModel(matrixOrder);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hungarian.HungarianApp.class).getContext().getResourceMap(MatrixPanel.class);
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setName("addButton"); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(addButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButtonActionPerformed
    {//GEN-HEADEREND:event_deleteButtonActionPerformed
        /*
         * TODO: we could later use an observer that will automatically update
         * the table by calling setTableModel
         * 
         */
        setMatrixOrder(matrixOrder-1);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addButtonActionPerformed
    {//GEN-HEADEREND:event_addButtonActionPerformed
        /*
         * TODO: we could later use an observer that will automatically update
         * the table by calling setTableModel
         *
         */
        setMatrixOrder(matrixOrder+1);
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
