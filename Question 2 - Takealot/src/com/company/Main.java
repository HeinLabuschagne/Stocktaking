package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage)  {

        primaryStage.setTitle("Takealot app");

        //labels
        Label lbl_PName = new Label();
        lbl_PName.setText("Enter product name");
        Label lbl_Title = new Label();
        lbl_Title.setText("Takealot stock taking app");
        TextField text_PName = new TextField();
        Label lbl_PType = new Label();
        lbl_PType.setText("Enter product type");
        TextField text_PType = new TextField();
        Label lbl_PPrice = new Label();
        lbl_PPrice.setText("Enter the product price");
        TextField text_PPrice = new TextField();

        //buttons
        Button btn_Save = new Button();
        btn_Save.setText("Save Details");
        Button btn_Retrieve = new Button();
        btn_Retrieve.setText("Retrieve Details");


        //creating the grid layout
        GridPane grid = new GridPane();
        //setting padding from sides
        grid.setPadding(new Insets(10,10,10,10));
        //setting vertical gap between nodes
        grid.setVgap(15);
        //setting horizontal gap between nodes
        grid.setHgap(8);

        //Laying nodes on grid
        GridPane.setConstraints(lbl_Title, 0,0);
        GridPane.setConstraints(lbl_PName , 0, 1);
        GridPane.setConstraints(text_PName,1,1);
        GridPane.setConstraints(lbl_PType, 0, 2);
        GridPane.setConstraints(text_PType,1,2);
        GridPane.setConstraints(lbl_PPrice, 0, 3);
        GridPane.setConstraints(text_PPrice,1,3);
        GridPane.setConstraints(btn_Retrieve, 1,4);
        GridPane.setConstraints(btn_Save,0,4);

        //adding nodes to grid
        grid.getChildren().addAll(lbl_Title, lbl_PPrice, lbl_PName, lbl_PType, text_PName,  text_PType, text_PPrice, btn_Save, btn_Retrieve);

        //creating scene
        Scene mainScene = new Scene(grid, 500, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();


        //creating events for button presses
        EventHandler <ActionEvent> evnt_Retrieve = (ActionEvent e) -> {
          /*  String sName = text_PName.getText();
            String sType = text_PType.getText();
            String sPrice = text_PPrice.getText();
            if (checkInputs(sName, sType, sPrice) == false)
            {
                System.out.println("One or more fields are empty");
                Alert emptyFields = new Alert(Alert.AlertType.ERROR);
                emptyFields.setTitle("Error");
                emptyFields.setHeaderText(null);
                emptyFields.setContentText("One or more fields are empty");
                emptyFields.showAndWait();
            }else {
                System.out.println("Retrieve");
            } */
        };

        EventHandler <ActionEvent> evnt_Save = (ActionEvent e) -> {
            String sName = text_PName.getText();
            String sType = text_PType.getText();
            String sPrice = text_PPrice.getText();
            if (checkInputs(sName, sType, sPrice) == false)
            {
                System.out.println("One or more fields are empty");
                Alert emptyFields = new Alert(Alert.AlertType.ERROR);
                emptyFields.setTitle("Error");
                emptyFields.setHeaderText(null);
                emptyFields.setContentText("One or more fields are empty");
                emptyFields.showAndWait();
            } else{
                System.out.println("Save");
                try
                {
                    //writing to text file
                    FileWriter writeFile = new FileWriter("Products.txt", true);
                    writeFile.write(sName + " " + sType + " " + sPrice + "\n");
                    writeFile.close();

                    //alert for success
                    Alert success = new Alert(Alert.AlertType.INFORMATION);
                    success.setTitle("Success");
                    success.setHeaderText(null);
                    success.setContentText("Product details saved sucessfully");
                    success.showAndWait();

                    //Clearing text fields
                    text_PName.clear();
                    text_PPrice.clear();
                    text_PType.clear();

                } catch (IOException exep) {
                    System.out.println("An error occurred");
                }

            }
        };


        //assigning events to buttons
        btn_Retrieve.setOnAction(evnt_Retrieve);
        btn_Save.setOnAction(evnt_Save);


    }

    private boolean checkInputs(String name, String type, String price) {
        if (name.length() == 0)
        {
            return false;
        }else
        if (type.length() == 0)
        {
            return false;
        }else
        if (price.length() == 0)
        {
            return false;
        }
        else return true;
    }


    public static void main(String[] args){
        Application.launch(args);
    }


}
