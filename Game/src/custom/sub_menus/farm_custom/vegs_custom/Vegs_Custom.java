package custom.sub_menus.farm_custom.vegs_custom;

import custom.sub_menus.farm_custom.Farm_Custom;
import graphic.Handle.Graphic_Handler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.IOException;

public class Vegs_Custom extends Farm_Custom {
    public static void vegsCustomMenu() {
        customMunu();

        Label nameLable = new Label("Choose a name for your plant: ");
        nameLable.setLayoutX(100);
        nameLable.setLayoutY(150);
        nameLable.setTextFill(Color.WHITE);

        TextField nameInput = new TextField();
        nameInput.setLayoutX(300);
        nameInput.setLayoutY(145);

        Label typeLabel = new Label("Choose the type of your plant: ");
        typeLabel.setLayoutX(100);
        typeLabel.setLayoutY(200);
        typeLabel.setTextFill(Color.WHITE);

        ChoiceBox<String> typeChoice = new ChoiceBox<>();
        typeChoice.getItems().addAll("Tree", "Shrub");
        typeChoice.setLayoutX(300);
        typeChoice.setLayoutY(195);

        Label numberLabel = new Label("Number of fruits each time: ");
        numberLabel.setLayoutY(275);
        numberLabel.setLayoutX(100);
        numberLabel.setTextFill(Color.WHITE);
        numberLabel.setOpacity(0);

        TextField numberInput = new TextField();
        numberInput.setLayoutX(300);
        numberInput.setLayoutY(270);
        numberInput.setOpacity(0);
        numberInput.setDisable(true);

        Label timesLabel = new Label("Number of harvest times: ");
        timesLabel.setLayoutY(275);
        timesLabel.setLayoutX(100);
        timesLabel.setTextFill(Color.WHITE);
        timesLabel.setOpacity(0);

        TextField timesInput = new TextField();
        timesInput.setLayoutX(300);
        timesInput.setLayoutY(270);
        timesInput.setOpacity(0);
        timesInput.setDisable(true);

        Label healthLabel = new Label("Health addition:");
        healthLabel.setLayoutX(100);
        healthLabel.setLayoutY(350);
        healthLabel.setTextFill(Color.WHITE);
        healthLabel.setOpacity(0);

        TextField healthInput = new TextField();
        healthInput.setLayoutX(250);
        healthInput.setLayoutY(345);
        healthInput.setOpacity(0);
        healthInput.setDisable(true);

        Label maxHealthLabel = new Label("Max health addition:");
        maxHealthLabel.setLayoutX(100);
        maxHealthLabel.setLayoutY(400);
        maxHealthLabel.setTextFill(Color.WHITE);
        maxHealthLabel.setOpacity(0);

        TextField maxHealthInput = new TextField();
        maxHealthInput.setLayoutX(250);
        maxHealthInput.setLayoutY(395);
        maxHealthInput.setOpacity(0);
        maxHealthInput.setDisable(true);

        Label energyLabel = new Label("Energy addition:");
        energyLabel.setLayoutX(550);
        energyLabel.setLayoutY(350);
        energyLabel.setTextFill(Color.WHITE);
        energyLabel.setOpacity(0);

        TextField energyInput = new TextField();
        energyInput.setLayoutX(700);
        energyInput.setLayoutY(345);
        energyInput.setOpacity(0);
        energyInput.setDisable(true);

        Label maxEnergyLabel = new Label("Max energy addition:");
        maxEnergyLabel.setLayoutX(550);
        maxEnergyLabel.setLayoutY(400);
        maxEnergyLabel.setTextFill(Color.WHITE);
        maxEnergyLabel.setOpacity(0);

        TextField maxEnergyInput = new TextField();
        maxEnergyInput.setLayoutX(700);
        maxEnergyInput.setLayoutY(395);
        maxEnergyInput.setOpacity(0);
        maxEnergyInput.setDisable(true);

        Label staminaLabel = new Label("Stamina addition:");
        staminaLabel.setLayoutX(100);
        staminaLabel.setLayoutY(450);
        staminaLabel.setTextFill(Color.WHITE);
        staminaLabel.setOpacity(0);

        TextField staminaInput = new TextField();
        staminaInput.setLayoutX(250);
        staminaInput.setLayoutY(445);
        staminaInput.setOpacity(0);
        staminaInput.setDisable(true);

        Label maxStaminaLabel = new Label("Max stamina addition:");
        maxStaminaLabel.setLayoutX(100);
        maxStaminaLabel.setLayoutY(500);
        maxStaminaLabel.setTextFill(Color.WHITE);
        maxStaminaLabel.setOpacity(0);

        TextField maxStaminaInput = new TextField();
        maxStaminaInput.setLayoutX(250);
        maxStaminaInput.setLayoutY(495);
        maxStaminaInput.setOpacity(0);
        maxStaminaInput.setDisable(true);

        Label satietyLabel = new Label("Satiety addition:");
        satietyLabel.setLayoutX(550);
        satietyLabel.setLayoutY(450);
        satietyLabel.setTextFill(Color.WHITE);
        satietyLabel.setOpacity(0);

        TextField satietyInput = new TextField();
        satietyInput.setLayoutX(700);
        satietyInput.setLayoutY(445);
        satietyInput.setOpacity(0);
        satietyInput.setDisable(true);

        Label maxSatietyLabel = new Label("Max satiety addition:");
        maxSatietyLabel.setLayoutX(550);
        maxSatietyLabel.setLayoutY(500);
        maxSatietyLabel.setTextFill(Color.WHITE);
        maxSatietyLabel.setOpacity(0);

        TextField maxSatietyInput = new TextField();
        maxSatietyInput.setLayoutX(700);
        maxSatietyInput.setLayoutY(495);
        maxSatietyInput.setOpacity(0);
        maxSatietyInput.setDisable(true);

        confirm.setOnMouseClicked(event -> {
            String name = nameInput.getText();
            String type = typeChoice.getValue();
            int fruit = 0, times = 0;
            if (type.equals("Tree")) {
                fruit = Integer.valueOf(numberInput.getText());
            }
            else {
                times = Integer.valueOf(timesInput.getText());
            }
            int health = Integer.valueOf(healthInput.getText());
            int maxHealth = Integer.valueOf(maxHealthInput.getText());
            int energy = Integer.valueOf(energyInput.getText());
            int maxEnergy = Integer.valueOf(maxEnergyInput.getText());
            int stamina = Integer.valueOf(staminaInput.getText());
            int maxStamina = Integer.valueOf(maxStaminaInput.getText());
            int satiety = Integer.valueOf(satietyInput.getText());
            int maxSatiety = Integer.valueOf(maxSatietyInput.getText());
            try {
                FileWriter fileWriter = new FileWriter("/Users/parsa/Desktop/Uni/Project/team_25/Game/src/custom/saved_custom/" + name + ".txt", true);
                fileWriter.append(name).append("\n");
                fileWriter.append(type).append("\n");
                fileWriter.append(type.equals("Tree") ? Integer.toString(fruit) : Integer.toString(times)).append("\n");
                fileWriter.append(Integer.toString(health)).append("\n");
                fileWriter.append(Integer.toString(maxHealth)).append("\n");
                fileWriter.append(Integer.toString(energy)).append("\n");
                fileWriter.append(Integer.toString(maxEnergy)).append("\n");
                fileWriter.append(Integer.toString(stamina)).append("\n");
                fileWriter.append(Integer.toString(maxStamina)).append("\n");
                fileWriter.append(Integer.toString(satiety)).append("\n");
                fileWriter.append(Integer.toString(maxSatiety)).append("\n");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        typeChoice.setOnAction(event -> {
            if (typeChoice.getSelectionModel().getSelectedItem().equals("Tree")) {
                timesLabel.setOpacity(0);
                timesInput.setOpacity(0);
                timesInput.setDisable(true);
                numberLabel.setOpacity(1);
                numberInput.setOpacity(1);
                numberInput.setDisable(false);

                healthLabel.setOpacity(1);
                maxHealthLabel.setOpacity(1);
                energyLabel.setOpacity(1);
                maxEnergyLabel.setOpacity(1);
                staminaLabel.setOpacity(1);
                maxStaminaLabel.setOpacity(1);
                satietyLabel.setOpacity(1);
                maxSatietyLabel.setOpacity(1);

                healthInput.setOpacity(1);
                maxHealthInput.setOpacity(1);
                energyInput.setOpacity(1);
                maxEnergyInput.setOpacity(1);
                staminaInput.setOpacity(1);
                maxStaminaInput.setOpacity(1);
                satietyInput.setOpacity(1);
                maxSatietyInput.setOpacity(1);

                healthInput.setDisable(false);
                maxHealthInput.setDisable(false);
                energyInput.setDisable(false);
                maxEnergyInput.setDisable(false);
                staminaInput.setDisable(false);
                maxStaminaInput.setDisable(false);
                satietyInput.setDisable(false);
                maxSatietyInput.setDisable(false);
            }
            else {
                timesLabel.setOpacity(1);
                timesInput.setOpacity(1);
                timesInput.setDisable(false);
                numberLabel.setOpacity(0);
                numberInput.setOpacity(0);
                numberInput.setDisable(true);

                healthLabel.setOpacity(1);
                maxHealthLabel.setOpacity(1);
                energyLabel.setOpacity(1);
                maxEnergyLabel.setOpacity(1);
                staminaLabel.setOpacity(1);
                maxStaminaLabel.setOpacity(1);
                satietyLabel.setOpacity(1);
                maxSatietyLabel.setOpacity(1);

                healthInput.setOpacity(1);
                maxHealthInput.setOpacity(1);
                energyInput.setOpacity(1);
                maxEnergyInput.setOpacity(1);
                staminaInput.setOpacity(1);
                maxStaminaInput.setOpacity(1);
                satietyInput.setOpacity(1);
                maxSatietyInput.setOpacity(1);

                healthInput.setDisable(false);
                maxHealthInput.setDisable(false);
                energyInput.setDisable(false);
                maxEnergyInput.setDisable(false);
                staminaInput.setDisable(false);
                maxStaminaInput.setDisable(false);
                satietyInput.setDisable(false);
                maxSatietyInput.setDisable(false);
            }
        });

        root.getChildren().addAll(nameLable, nameInput, typeLabel, typeChoice, numberLabel, numberInput, timesLabel, timesInput, healthLabel, healthInput, maxHealthLabel, maxHealthInput, energyLabel, energyInput, maxEnergyLabel, maxEnergyInput, staminaLabel, staminaInput, maxStaminaLabel, maxStaminaInput, satietyLabel, satietyInput, maxSatietyLabel, maxSatietyInput);

        Graphic_Handler.game.setScene(scene);
    }
}
