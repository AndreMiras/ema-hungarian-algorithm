/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import hungarian.HungarianView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MatrixPanel;
import view.SolutionPanel;

/**
 *
 * @author andre
 */
public class MainController
{

    private HungarianView hungarianView;
    private MatrixController matrixController;
    private SolutionController solutionxController;

    public MainController(HungarianView hungarianView)
    {
        this.hungarianView = hungarianView;

        /*
         * Ressource/Job Matrix View and controller
         */
        MatrixPanel matrixPanel = hungarianView.getMatrixPanel();
        this.matrixController = new MatrixController(matrixPanel);

        SolutionPanel solutionPanel = hungarianView.getSolutionPanel();
        this.solutionxController = new SolutionController(solutionPanel);
        
        addListeners();
    }

    private void addListeners()
    {
        hungarianView.addResolveButtonListener(
                new ResolveButtonListener());
    }

    class ResolveButtonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            int matrix[][] = matrixController.getIntMatrix();
            
            HungarianAlgorithmController hungarianAlgorithmController =
                    new HungarianAlgorithmController(matrix);

            // Getting the first solution for testing
            boolean resolvedMatrix[][] =
                    hungarianAlgorithmController.resolve().firstElement();

            System.out.println("resolved:");
            hungarianAlgorithmController.affiche(resolvedMatrix);

            /*
             * After resolving the matrix[][] had been altered by the Algorithm
             * Reinit one.
             */
            matrix = matrixController.getIntMatrix();

            solutionxController.setTasks(matrixController.getTasks());
            solutionxController.setCostMatrix(matrix);
            solutionxController.setSolutionMatrix(resolvedMatrix);
        }
    }
}