package com.codedotorg;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetSelectionScene extends PetApp {

    /** The name of the pet provided by the user */
    private String petName;

    /** The type of pet chosen by the user */
    private String petType;

    /**
     * This class represents a scene for selecting a pet. It extends the Scene class and
     * provides a constructor for initializing the pet name and type.
     */
    public PetSelectionScene(Stage window, int width, int height) {
        super(window, width, height);

        petName = "";
        petType = "";
    }

    /**
     * This method starts the application by creating a VBox layout for pet selection
     * and setting it as the scene to be displayed.
     */
    public void startApp() {
        VBox petSelectionLayout = createPetSelectionLayout();
        setAndShowScene(petSelectionLayout);
    }

    /**
     * Sets petName to the name entered by the user
     */
    public void setPetName(String name) {
        petName = name;

        

    }

    /**
     * Sets petType to the type of pet chosen by the user
     */
    public void setPetType(String type) {
        petType = type;


    }

    /**
     * Creates the main layout for the PetSelection scene
     * 
     * @return the VBox layout for the PetSelection scene
     */
    public VBox createPetSelectionLayout() {

        VBox layout = new VBox();
        RadioButton dogButton = new RadioButton("Dog");
        RadioButton catButton = new RadioButton("Cat");

        ToggleGroup group = new ToggleGroup();
        dogButton.setToggleGroup(group);
        catButton.setToggleGroup(group);
        
        dogButton.setOnAction(e -> {
            if (dogButton.isSelected()) {
                setPetType("Dog");
            }
        });
        
        catButton.setOnAction(e -> {
            if (catButton.isSelected()) {
                setPetType("Cat");
            }
        });
        
        TextField petNameField = new TextField();
        petNameField.setPromptText("Enter pet name");

        petNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            setPetName(newValue);
        });
        
        layout.getChildren().addAll(petNameField, dogButton, catButton, createSubmitButton());

        return layout;
    }

    /**
     * Creates a submit button that, when clicked, creates a new MainScene object with
     * the given pet name and type, and displays it.
     *
     * @return the submit button
     */
    public Button createSubmitButton() {
        Button tempButton = new Button("Submit");

        tempButton.setOnAction(event -> {
            MainScene mainScene = new MainScene(getWindow(), getWidth(), getHeight(), petName, petType);
            mainScene.showMainScene();
        });

        return tempButton;
    }

}