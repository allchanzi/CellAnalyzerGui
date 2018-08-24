package com.allchanzi.cellanalyzer.gui.controllers;


import com.allchanzi.cellanalyzer.core.ImageLoader;
import com.allchanzi.cellanalyzer.gui.GuiManager;
import com.allchanzi.cellanalyzer.gui.view.WindowView;
import java.io.File;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 * @author allchanzi
 * @project CellAnalyzer
 * @date 8/8/2018
 */


@Component
public class MainWindowController {

    @FXML private Button calibrateButton;
    @FXML private Button loadButton;
    @FXML private Button showParamsButton;
    @FXML private Button formatOutputButton;
    @FXML private Button analyzeButton;
    @FXML private Button saveButton;
    @FXML private ToggleButton menuButton;
    @FXML private VBox mainMenuBox;
    @FXML private ImageView originalImageView;
    @FXML private ImageView analyzedImageView;
    private final GuiManager guiManager;
    private final ImageLoader imageLoader;
    private List<File> files;

  
    @Autowired 
    @Lazy
    public MainWindowController(GuiManager guiManager, ImageLoader imageLoader){
        this.guiManager = guiManager;
        this.imageLoader = imageLoader;
    }
    
    public void loadButtonClicked() {
        files = guiManager.loadDialog();
        if(files != null){
            files.forEach((file) -> {
                System.out.println(file.getAbsolutePath());
            });
        } else {
            System.out.println("No file has been loaded");
        }
        
    }

    public void calibrateButtonClicked(){
        guiManager.popupScene(WindowView.GREEN_CALIBRATION);
    }
    
    public void menuButtonClicked() {
        if (mainMenuBox.isVisible()) {
            mainMenuBox.setVisible(false);
        } else {
            mainMenuBox.setVisible(true);
        }
    }

    /////////PRIVATE/////////
    
    private void showOrigImage(File file){
        originalImageView.setImage(imageLoader.getImageFromFile(file));
    }

}
