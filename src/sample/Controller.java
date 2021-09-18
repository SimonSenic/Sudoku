package sample;

import javafx.scene.control.TextField;

public class Controller {
    public TextField t00;
    public TextField t01;

    private boolean checkValidity(int[][] array, int n, int row, int column){
        if(!checkRow(array, n, row) && !checkColumn(array, n, column) && !checkBox(array, n, row, column))
            return true;
        else return false;
    }

    private boolean checkRow(int[][] array, int n, int row){
        for(int i=0; i<9; i++)
            if(array[row][i]==n) return true;

        return false;
    }

    private boolean checkColumn(int[][] array, int n, int column){
        for(int i=0; i<9; i++)
            if(array[i][column]==n) return true;

        return false;
    }

    private boolean checkBox(int[][] array, int n, int row, int column){
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for(int i=boxRow; i<boxRow+3; i++)
            for(int j=boxColumn; j<boxColumn+3; j++)
                if(array[i][j]==n) return true;

        return false;
    }

}
