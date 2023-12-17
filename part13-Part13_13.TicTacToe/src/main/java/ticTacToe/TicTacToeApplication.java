package ticTacToe;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import java.util.Arrays;

public class TicTacToeApplication extends Application {

    private Boolean isPlayerX;
    private Boolean gameInProgress;
    private Label gameInfoLabel;
    private String[][] gameBoard;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) {
        isPlayerX = true;
        gameInProgress = true;
        BorderPane rootLayout = new BorderPane();
        gameInfoLabel = new Label("Turn: X");
        GridPane gameLayout = initGameLayout();
        gameBoard = initGameBoard(gameLayout);

        rootLayout.setCenter(gameLayout);
        rootLayout.setTop(gameInfoLabel);
        Scene mainScene = new Scene(rootLayout, 600, 600);

        stage.setScene(mainScene);
        stage.show();
    }

    //Function for starting the game - places buttons and such
    public GridPane initGameLayout() {
        GridPane gameLayout = new GridPane();
        for (int row = 0; row < 3; row++) { //for every row
            for (int col = 0; col < 3; col++) { //for every column in said row
                Button gameButton = new Button("");
                gameButton.setOnAction(event -> {
                    if (gameButton.textProperty().get().isEmpty()) {
                        playerAction(gameButton, gameLayout);
                    }
                });
                gameLayout.add(gameButton, row, col); //place a new interactive game button
            }
        }
        return gameLayout;
    }

    //Function for when a player presses a button
    public void playerAction(Button buttonPressed, GridPane gameLayout) {
        if (buttonPressed.textProperty().isEmpty().get()) {
            if (isPlayerX) {
                buttonPressed.textProperty().set("X");
                isPlayerX = false;
                gameInfoLabel.setText("Turn: O");
                System.out.println(calcGameWin());
            } else {
                buttonPressed.textProperty().set("O");
                isPlayerX = true;
                gameInfoLabel.setText("Turn: X");
                System.out.println(calcGameWin());
            }
            Integer colIndex = GridPane.getColumnIndex(buttonPressed);
            Integer rowIndex = GridPane.getRowIndex(buttonPressed);
            gameBoard[rowIndex][colIndex] = buttonPressed.getText();

            if (!Arrays.stream(gameBoard).flatMap(Arrays::stream).anyMatch(text -> text.equals(""))) {
                System.out.println(Arrays.toString(Arrays.stream(gameBoard).flatMap(Arrays::stream).toArray()));
                gameInfoLabel.setText("The end!");
                System.out.println("No buttons left!");
            }
            if (calcGameWin()) {
                gameInfoLabel.setText("The end!");
                System.out.println("Game over!");
            }
            if (gameInfoLabel.getText().equals("The end!")) {
                for (Node node : gameLayout.getChildren()) {
                    if (node instanceof Button) {
                        ((Button) node).setDisable(true);
                    }
                }
            }

        }
    }

    public String[][] initGameBoard(GridPane gameLayout) {
        //making a 2d array of the gameBoard
        gameBoard = new String[3][3];
        for (Node node : gameLayout.getChildren()) {
            Button button = (Button) node;
            int row = GridPane.getRowIndex(button);
            int col = GridPane.getColumnIndex(button);
            gameBoard[row][col] = button.getText();
        }
        return gameBoard;
    }

    public boolean calcGameWin() {
        for (int row = 0; row < 3; row++) { //checking each row
            if (!gameBoard[row][0].isEmpty()) {
                if (gameBoard[row][0].equals(gameBoard[row][1])
                        && gameBoard[row][0].equals(gameBoard[row][2])) {
                    return true;
                }
            }
        }
        for (int col = 0; col < 3; col++) { //checking each column
            if (!gameBoard[0][col].isEmpty()) {
                if (gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[0][col].equals(gameBoard[2][col])) {
                    return true;
                }
            }
        }
        if (!gameBoard[0][0].isEmpty()) { // checking first diagonal
            if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[0][0].equals(gameBoard[2][2])) {
                return true;
            }
        }
        if (!gameBoard[0][2].isEmpty()) { //checking second diagonal
            if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[0][2].equals(gameBoard[2][0])) {
                return true;
            }
        }
        return false;
    }
}
