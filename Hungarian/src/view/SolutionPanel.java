/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SolutionPanel.java
 *
 * Created on May 11, 2011, 8:34:25 PM
 */

package view;

/**
 *
 * @author andre
 */
public class SolutionPanel extends javax.swing.JPanel
{
    int[][] costMatrix;
    
    /*
     * Liste de nom de taches
     */
    String tasks[];

    /*
     * Liste de nom de taches
     */
    String resources[];

    /** Creates new form SolutionPanel */
    public SolutionPanel() {
        initComponents();
    }

    public SolutionPanel(Integer[][] costMatrix)
    {
        this(costMatrix, null);
    }

    public SolutionPanel(Integer[][] costMatrix, String tasks[])
    {
        this();
        this.tasks = tasks;
        initTable(tasks.length);
    }

    /*
     * Init (size) an table to accept the given resources/tasks number
     * TODO: code cleaning, merging with displaySolutionFromBooleanSolutionMatrix()
     */
    public final void initTable(int numResources)
    {
        // 3 pour ressource, tache, cout total
        String[][] solutionMatrixForDisplay =
                new String[numResources][3];

        javax.swing.JTable rowTable = new RowNumberTable(jTable1);
        jScrollPane1.setRowHeaderView(rowTable);
        jScrollPane1.setCorner(javax.swing.JScrollPane.UPPER_LEFT_CORNER,
            rowTable.getTableHeader());


        // TODO: add total cost
        for(int i=0; i<numResources; i++)
        {
            solutionMatrixForDisplay[i][0] = "ressource" + (i+1);
            solutionMatrixForDisplay[i][1] = "task-?";
            solutionMatrixForDisplay[i][2] = "?";
        }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            solutionMatrixForDisplay,
            new String[] {"Resources", "Tasks", "Costs"}
        ));
    }
    

    // TODO: setup some tasks/resources by default if none where specified
    public void displaySolutionFromBooleanSolutionMatrix(Boolean[][] solutionMatrix)
    {
        // 3 pour ressource, tache, cout total
        String[][] solutionMatrixForDisplay =
                new String[solutionMatrix.length][3];

        javax.swing.JTable rowTable = new RowNumberTable(jTable1);
        jScrollPane1.setRowHeaderView(rowTable);
        jScrollPane1.setCorner(javax.swing.JScrollPane.UPPER_LEFT_CORNER,
            rowTable.getTableHeader());

        
        // TODO: add total cost
        for(int i=0; i<solutionMatrix.length; i++)
        {
          for(int j=0; j<solutionMatrix.length; j++)
          {
              if(solutionMatrix[i][j])
              {
                  solutionMatrixForDisplay[i][0] = "ressource" + (i+1);
                  solutionMatrixForDisplay[i][1] = getTaskNameFromIndex(j);
                  solutionMatrixForDisplay[i][2] =
                          String.valueOf(costMatrix[i][j]);
              }
          }
        }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            solutionMatrixForDisplay,
            new String[] {"Resources", "Tasks", "Costs"}
        ));
    }

    /*
     * Retourne le nom de la tache pour un index donne
     */
    private String getTaskNameFromIndex(int i)
    {
        return tasks[i];
    }



    public void setTasksNumber(int number)
    {
        this.resources = new String[number];
        initTable(number);
    }

    public void setResourcesNumber(int number)
    {
        setTasksNumber(number);
    }
    
    public void setResources(String[] resources)
    {
        this.resources = resources;
    }

    public void setTasks(String[] tasks)
    {
        this.tasks = tasks;
    }

    public void setCostMatrix(int[][] costMatrix)
    {
        this.costMatrix = costMatrix;
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

        setName("SolutionPanelForm"); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
