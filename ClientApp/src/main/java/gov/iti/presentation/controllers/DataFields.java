package gov.iti.presentation.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DataFields extends BorderPane {

    protected final TextField idTextField;
    protected final Label idLabel;
    protected final TextField fNameTextField;
    protected final Label fNameLabel;
    protected final TextField mNameTextField;
    protected final Label mNameLabel;
    protected final TextField lNameTextField;
    protected final Label lNameLabel;
    protected final TextField emailTextField;
    protected final Label emailLabel;
    protected final TextField phoneTextField;
    protected final Label phoneLabel;
    protected final TextField ageTextField;
    protected final Label ageLabel;

    protected final Label titleLabel;
    protected final Pane pane;
    protected final Button homeButton;
    protected final Pane titlePane;
    protected final Button exitIcon;

    Image myHomeImage,exitImage;
    ImageView myImageView,exitView;

    public DataFields() {
        pane = new Pane();
        titleLabel = new Label();
        titlePane = new Pane();

        idTextField = new TextField();
        idLabel = new Label();
        fNameTextField = new TextField();
        fNameLabel = new Label();
        mNameTextField = new TextField();
        mNameLabel = new Label();
        lNameTextField = new TextField();
        lNameLabel = new Label();
        emailTextField = new TextField();
        emailLabel = new Label();
        phoneTextField = new TextField();
        phoneLabel = new Label();
        ageTextField = new TextField();
        ageLabel = new Label();
        homeButton = new Button();
        exitIcon = new Button();

        myHomeImage = new Image("homeIcon.png");//getClass().getClassLoader().getResource("homeIcon.png")
        myImageView = new ImageView(myHomeImage);

        exitImage = new Image("closeIcon.png");
        exitView = new ImageView(exitImage);
    }

    

    
}
