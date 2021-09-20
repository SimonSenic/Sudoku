package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    Button btn_check;
    @FXML
    Label lab_victory, lab_defeat;
    @FXML
    TextField p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
    p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42,
    p43, p44, p45, p46, p47, p48, p49, p50, p51, p52, p53, p54, p55, p56, p57, p58, p59, p60, p61, p62, p63, p64,
    p65, p66, p67, p68, p69, p70, p71, p72, p73, p74, p75, p76, p77, p78, p79, p80;

    public String btn_check_click(ActionEvent actionEvent){
        int[][] array = new int[9][9];
        array = fillArray(array);
        lab_victory.setVisible(false);
        lab_defeat.setVisible(false);
        for(int row=0; row<9; row++)
            for(int column=0; column<9; column++)
                if(!checkValidity(array, array[row][column], row, column)){ lab_defeat.setVisible(true); return null;}

        lab_victory.setVisible(true);
        return null;

    }

    private boolean checkValidity(int[][] array, int n, int row, int column){
        if(!checkRow(array, n, row) && !checkColumn(array, n, column) && !checkBox(array, n, row, column))
            return true;
        else return false;
    }

    private boolean checkRow(int[][] array, int n, int row){
        int count=0;
        for(int i=0; i<9; i++)
            if(array[row][i]<1 || array[row][i]>9) return true;
            else if(array[row][i]==n && count==1) return true;
            else if(array[row][i]==n) count++;

        return false;
    }

    private boolean checkColumn(int[][] array, int n, int column){
        int count=0;
        for(int i=0; i<9; i++)
            if(array[i][column]<1 || array[i][column]>9) return true;
            else if(array[i][column]==n && count==1) return true;
            else if(array[i][column]==n) count++;

        return false;
    }

    private boolean checkBox(int[][] array, int n, int row, int column){
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        int count=0;
        for(int i=boxRow; i<boxRow+3; i++)
            for(int j=boxColumn; j<boxColumn+3; j++)
                if(array[i][j]==n && count==1) return true;
                else if(array[i][j]==n) count++;

        return false;
    }

    private int[][] fillArray(int[][] array){
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(p0.getText())); list.add(Integer.valueOf(p1.getText())); list.add(Integer.valueOf(p2.getText()));
        list.add(Integer.valueOf(p3.getText())); list.add(Integer.valueOf(p4.getText())); list.add(Integer.valueOf(p5.getText()));
        list.add(Integer.valueOf(p6.getText())); list.add(Integer.valueOf(p7.getText())); list.add(Integer.valueOf(p8.getText()));
        list.add(Integer.valueOf(p9.getText())); list.add(Integer.valueOf(p10.getText())); list.add(Integer.valueOf(p11.getText()));
        list.add(Integer.valueOf(p12.getText())); list.add(Integer.valueOf(p13.getText())); list.add(Integer.valueOf(p14.getText()));
        list.add(Integer.valueOf(p15.getText())); list.add(Integer.valueOf(p16.getText())); list.add(Integer.valueOf(p17.getText()));
        list.add(Integer.valueOf(p18.getText())); list.add(Integer.valueOf(p19.getText())); list.add(Integer.valueOf(p20.getText()));
        list.add(Integer.valueOf(p21.getText())); list.add(Integer.valueOf(p22.getText())); list.add(Integer.valueOf(p23.getText()));
        list.add(Integer.valueOf(p24.getText())); list.add(Integer.valueOf(p25.getText())); list.add(Integer.valueOf(p26.getText()));
        list.add(Integer.valueOf(p27.getText())); list.add(Integer.valueOf(p28.getText())); list.add(Integer.valueOf(p29.getText()));
        list.add(Integer.valueOf(p30.getText())); list.add(Integer.valueOf(p31.getText())); list.add(Integer.valueOf(p32.getText()));
        list.add(Integer.valueOf(p33.getText())); list.add(Integer.valueOf(p34.getText())); list.add(Integer.valueOf(p35.getText()));
        list.add(Integer.valueOf(p36.getText())); list.add(Integer.valueOf(p37.getText())); list.add(Integer.valueOf(p38.getText()));
        list.add(Integer.valueOf(p39.getText())); list.add(Integer.valueOf(p40.getText())); list.add(Integer.valueOf(p41.getText()));
        list.add(Integer.valueOf(p42.getText())); list.add(Integer.valueOf(p43.getText())); list.add(Integer.valueOf(p44.getText()));
        list.add(Integer.valueOf(p45.getText())); list.add(Integer.valueOf(p46.getText())); list.add(Integer.valueOf(p47.getText()));
        list.add(Integer.valueOf(p48.getText())); list.add(Integer.valueOf(p49.getText())); list.add(Integer.valueOf(p50.getText()));
        list.add(Integer.valueOf(p51.getText())); list.add(Integer.valueOf(p52.getText())); list.add(Integer.valueOf(p53.getText()));
        list.add(Integer.valueOf(p54.getText())); list.add(Integer.valueOf(p55.getText())); list.add(Integer.valueOf(p56.getText()));
        list.add(Integer.valueOf(p57.getText())); list.add(Integer.valueOf(p58.getText())); list.add(Integer.valueOf(p59.getText()));
        list.add(Integer.valueOf(p60.getText())); list.add(Integer.valueOf(p61.getText())); list.add(Integer.valueOf(p62.getText()));
        list.add(Integer.valueOf(p63.getText())); list.add(Integer.valueOf(p64.getText())); list.add(Integer.valueOf(p65.getText()));
        list.add(Integer.valueOf(p66.getText())); list.add(Integer.valueOf(p67.getText())); list.add(Integer.valueOf(p68.getText()));
        list.add(Integer.valueOf(p69.getText())); list.add(Integer.valueOf(p70.getText())); list.add(Integer.valueOf(p71.getText()));
        list.add(Integer.valueOf(p72.getText())); list.add(Integer.valueOf(p73.getText())); list.add(Integer.valueOf(p74.getText()));
        list.add(Integer.valueOf(p75.getText())); list.add(Integer.valueOf(p76.getText())); list.add(Integer.valueOf(p77.getText()));
        list.add(Integer.valueOf(p78.getText())); list.add(Integer.valueOf(p79.getText())); list.add(Integer.valueOf(p80.getText()));
        int a=0;
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++){ array[i][j] = list.get(a); a++; }

        return array;
    }

}
