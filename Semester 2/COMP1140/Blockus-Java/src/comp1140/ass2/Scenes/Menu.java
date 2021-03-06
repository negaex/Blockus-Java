package comp1140.ass2.Scenes;

import comp1140.ass2.Blokus;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Created on 25/09/15
 */
public class Menu extends Scene {

    public Button options;


    /**
     * Creates a new Menu scene
     * @param root required by Scene
     * @param width required by Scene
     * @param height required by Scene
     * @param parent to access scene changing methods
     */
    public Menu(Group root, double width, double height, Blokus parent) {
        super(root, width, height, Color.LIGHTBLUE);
        getStylesheets().add("comp1140/ass2/Assets/main.css");
        parent.setTitle("Blokus: Main Menu");


        final ImageView imv = new ImageView();
        final Image image2 = new Image(Blokus.class.getResourceAsStream("Assets/blokusbg3.png"));
        imv.setImage(image2);
        imv.setLayoutX(0); imv.setLayoutY(0);
        imv.setFitWidth(700);
        imv.setPreserveRatio(true);
        root.getChildren().add(imv);

        final ImageView imv1 = new ImageView();
        final Image image3 = new Image(Blokus.class.getResourceAsStream("Assets/Blokus.png"));
        imv1.setImage(image3);
        imv1.setFitWidth(400);
        imv1.setPreserveRatio(true);
        imv1.setLayoutX(350-imv1.getFitWidth()/2); imv1.setLayoutY(40);
        root.getChildren().add(imv1);



        Button button2 = new Button("Play");
        button2.setOnAction(e -> parent.toGameOptions());
        button2.setMinSize(160, 60);
        button2.setLayoutX(150 - button2.getMinWidth() / 2); button2.setLayoutY(600);
        button2.getStyleClass().add("button1");
        root.getChildren().add(button2);

        Button button0 = new Button("Instructions");
        button0.setOnAction(e -> parent.toInstructions(this));
        button0.setMinSize(160, 60);
        button0.setLayoutX(345 - button0.getMinWidth() / 2); button0.setLayoutY(600);
        button0.getStyleClass().add("button1");
        root.getChildren().add(button0);

        options = new Button("Options");
        options.setOnAction(e -> parent.toOptions());
        options.setMinSize(160, 60);
        options.setLayoutX(550 - options.getMinWidth() / 2); options.setLayoutY(600);
        options.getStyleClass().add("button1");
        root.getChildren().add(options);




    }
}
