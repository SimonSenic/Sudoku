package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    TextField[] textFields = new TextField[81];
    String field = "640070832021300740300008096090001378010706000437080500000000013060000200150027904";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(new Scene(pane, 380, 430));
        primaryStage.show();
        primaryStage.setResizable(false);

        int count=0, x=43, y=40;
        for (int i=0; i<81; i++) {
            TextField tf = new TextField(String.valueOf(field.charAt(i)));
            tf.setMaxSize(25, 25);
            if(i==0){
                tf.setLayoutX(x);
                tf.setLayoutY(y);
                count++;
            }else{
                if(count==9){
                    count = 0; x=43; y+=38;
                    tf.setLayoutX(x);
                    tf.setLayoutY(y);
                    count++;
                }else{
                    x+=33;
                    tf.setLayoutX(x);
                    tf.setLayoutY(y);
                    count++;
                }
            }
            textFields[i] = tf;
            pane.getChildren().add(tf);
        }

        Button btn_check = new Button("Check");
        btn_check.setLayoutX(163);
        btn_check.setLayoutY(383);
        btn_check.setOnAction(e -> {
            int[][] array = new int[9][9];
            array = fillArray(array);
            //lab_victory.setVisible(false);
            //lab_defeat.setVisible(false);
            for(int row=0; row<9; row++)
                for(int column=0; column<9; column++)
                    if(!checkValidity(array, array[row][column], row, column)){ System.out.println("nedobre"); /*lab_defeat.setVisible(true);*/ return; }

            //lab_victory.setVisible(true);
        });
        pane.getChildren().add(btn_check);

        Button btn_solve = new Button("Solve");
        btn_solve.setLayoutX(250);
        btn_solve.setLayoutY(383);
        btn_solve.setOnAction(e -> {
            int[][] array = new int[9][9];  int c = 0;
            array = fillArray(array);
            for(int row=0; row<9; row++)
                for(int column=0; column<9; column++){
                    for(int n=1; n<=9; n++)
                        if(array[row][column]==0 && checkValidity(array, n, row, column)){
                            //textFields[c].setText(String.valueOf(n));
                            array[row][column] = n;
                            break;
                        }

                    c++;
                }

            //
            c=0;
            for(int row=0; row<9; row++)
                for(int column=0; column<9; column++) {
                    textFields[c].setText(String.valueOf(array[row][column]));
                    c++;
                }
        });
        pane.getChildren().add(btn_solve);
    }

    private boolean checkValidity(int[][] array, int n, int row, int column){
        if(!checkRow(array, n, row) && !checkColumn(array, n, column) && !checkBox(array, n, row, column))
            return true;
        else return false;
    }

    private boolean checkRow(int[][] array, int n, int row){
        int count=0;
        for(int i=0; i<9; i++)
            if(array[row][i]<0 || array[row][i]>9) return true;
            else if(array[row][i]==n && count==1) return true;
            else if(array[row][i]==n) count++;

        return false;
    }

    private boolean checkColumn(int[][] array, int n, int column){
        int count=0;
        for(int i=0; i<9; i++)
            if(array[i][column]<0 || array[i][column]>9) return true;
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
        int a=0;
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++){ array[i][j] = Integer.valueOf(textFields[a].getText()); a++; }

        return array;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
