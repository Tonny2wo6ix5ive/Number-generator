/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txy;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static javafx.scene.control.TextField.positionInArea;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.Modality;

import static javafx.stage.Modality.APPLICATION_MODAL;

import javafx.stage.Window;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.text.Text;


/**
 * @author USER
 */
public class TXY extends Application {


    Label label = new Label("Guess a Number:");
    TextField userInput = new TextField();
    private String C;

    @Override
    public void start(Stage stage) {

        VBox roots = new VBox();
        GridPane root = new GridPane();


        label.setLabelFor(userInput);
        label.setMnemonicParsing(true);
        userInput.setPrefColumnCount(5);

        Button checkButton = new Button("Check");
        checkButton.setOnAction(e -> setnum(stage, APPLICATION_MODAL));
        checkButton.setMinSize(50, 50);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());
        exitButton.setMaxSize(50, 50);

        Button helpButton = new Button("Help");
        helpButton.setOnAction(e -> instruct(stage, APPLICATION_MODAL));
        helpButton.setMaxSize(50, 50);


        //Layingout scene nodes
        root.addRow(0, checkButton, helpButton, exitButton);
        root.setVgap(10); //Set verticle gap between nodes
        root.setHgap(10);// Set horizontal gaps between nodes

        roots.getChildren().addAll(label, new Group(userInput), root);

        //setting style on stage
        roots.setStyle("-fx-padding: 30;" + "-fx-align: center;");
        userInput.setStyle("-fx-font-size: 30;");
        label.setStyle("-fx-font-size:15;");
        userInput.setMinSize(50, 50);
        root.setStyle("-fx-color: orange;");

        stage.setResizable(false);
        Scene scene = new Scene(roots, 270, 200);
        stage.getIcons().add(new Image("/icon/5-five-number-icon-8.png"));
        stage.setScene(scene);
        stage.setTitle("Lucky Number");
        stage.show();
    }

    public void setnum(Window own, Modality mod) {
        Stage stage = new Stage();
        stage.initModality(mod);
        stage.initOwner(own);
        VBox root = new VBox();
        GridPane roots = new GridPane();
        Text head = new Text();
        Text result = new Text();
        Button close = new Button("Close");
        close.setOnAction(e -> stage.close());
        result.getText();

        double luck = Math.floor(Math.random() * 11);
        int lucks = (int) luck;
        String contxt = userInput.getText().trim();
        int con = Integer.parseInt(contxt);
        result.getText();
        if (con == lucks) {
            head.setText("You hava won!!");
            result.setText("Your number was: " + con + "\nLucky number is: " + lucks);

            head.setStyle("-fx-font-weight: bolder;" + "-fx-font-size: xx-large;" +
                    "-fx-text-fill: blue;");
        } else if (con > 10 || con < 0) {
            head.setText("Oops!!");
            result.setText("Invalid input, please check the guide\n"
                    + "on how to play this game.");

            head.setStyle("-fx-font-weight: bolder;" + "-fx-font-size: xx-large;" +
                    "-fx-text-fill: red;");
        } else {
            head.setText("Loser lol");
            result.setText("Your number was: " + con + "\nLucky number is: " + lucks);

            head.setStyle("-fx-font-weight: bolder;" + "-fx-font-size: xx-large;" +
                    "-fx-text-fill: red;");
        }

        root.setStyle("-fx-padding: 10;");
        roots.setStyle("-fx-background-color: white;" + "-fx-border-style: solid;" +
                "-fx-border-color: grey;" + "-fx-border-radius: 5;");
        result.setStyle("-fx-font-size: large;");
        close.setMinSize(50, 50);
        close.setStyle("-fx-color: orange;");

        roots.addRow(0, result);

        root.getChildren().addAll(head, roots, close);
        Scene scene = new Scene(root, 270, 200);
        stage.setResizable(false);
        stage.getIcons().add(new Image("/icon/5-five-number-icon-8.png"));
        stage.setScene(scene);
        stage.setTitle("Lucky Number");
        stage.show();
    }

    public void instruct(Window owner, Modality modal) {
        Stage stage = new Stage();
        stage.initModality(modal);
        stage.initOwner(owner);

        VBox root = new VBox();

        Text help = new Text("Welcome to TXY Lucky Number."
                + " \nAll you have to do is to enter a number between" +
                "\n0-10 and check if your number is lucky, if it is" +
                "\nthen good lucky if it isn't well, you can try again." +
                "\nBTW don't you ever enter anything that isn't" +
                "\nbetween 0-10, ok? If you have any suggestion" +
                "\ndon't hesitate to tell me, Otherwise good lucky!!");

        Button close = new Button("Close");
        close.setOnAction(e -> stage.close());
        close.setMaxSize(50, 50);

        close.setStyle("-fx-color:;");
        help.setStyle("-fx-background-color: white" + "-fx-font-weight: bolder");
        root.setStyle("-fx-padding: 10;" + "-fx-background-color: orange;");
        root.getChildren().addAll(help, close);

        Scene scene = new Scene(root, 270, 200);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/icon/5-five-number-icon-8.png"));
        stage.setTitle("Lucky Number");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
