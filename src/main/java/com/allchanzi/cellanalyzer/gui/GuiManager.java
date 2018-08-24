package com.allchanzi.cellanalyzer.gui;

import com.allchanzi.cellanalyzer.gui.view.SpringFXMLLoader;
import com.allchanzi.cellanalyzer.gui.view.WindowView;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author allchanzi
 * @project CellAnalyzer
 * @date 8/14/2018
 * 
 * Manages scenes and switching on primaryStage
 */



public class GuiManager {

    @Autowired
    private Stage newStage;
    
    private final Stage primaryStage;
    private final SpringFXMLLoader springFXMLLoader;
    
    @Autowired
    public GuiManager(Stage primaryStage, SpringFXMLLoader springFXMLLoader) {
        this.primaryStage = primaryStage;
        this.springFXMLLoader = springFXMLLoader;
    }
    
    /**
     * Get root from view and show required view on the primary stage
     * @param view 
     */
    public void switchScene(final WindowView view){
        Parent viewRootNodeHierarchy = loadRootNodeHierarchy(view.getSourceFile());
        show(viewRootNodeHierarchy, view.getTitle());
    }
    
    /**
     * Make and show pop up window use newStage to display
     * @param view 
     */
    public void popupScene(final WindowView view) {
        Parent viewRootNodeHierarchy = loadRootNodeHierarchy(view.getSourceFile());
        showPopup(viewRootNodeHierarchy, view.getTitle());
        destroyPopup();
        switchScene(WindowView.MAIN);
        
    }
    
    /**
     * Make loading dialog to load files
     * @return - list of chosen files
     */
    public List<File> loadDialog(){
        List<File> files;
        final FileChooser fileChooser = new FileChooser();
        files = fileChooser.showOpenMultipleDialog(newStage);
        return files;    
    }
    
    /////////PRIVATE/////////
    
    /**
     * Builds scene from Parent root node 
     * @param root - root node of FXML hierarchy
     * @return 
     */
    private Scene buildScene(Parent root){
        Scene scene = primaryStage.getScene();
        
        if(scene == null){
            scene = new Scene(root);
        }
        scene.setRoot(root);
        return scene;
    }
    
    /**
     * Create a pop up dialog
     * @param root
     * @param title 
     */
    private void showPopup(final Parent root, String title){
        Scene scene = buildScene(root);
        newStage.setScene(scene);
        //newStage.initModality(Modality.WINDOW_MODAL);
        newStage.showAndWait();
    }
    
    private void destroyPopup(){
        newStage.hide();
    }
    
    
    /**
     * Shows builded scene on the primary stage 
     * @param root
     * @param title 
     */
    private void show(final Parent root, String title){
        Scene scene = buildScene(root);
        
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        
        try {
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Unable to show scene");
        }
    }
    
    /**
     * load root node from FXML file
     * @param filePath
     * @return 
     */
    private Parent loadRootNodeHierarchy(String filePath){
        Parent root = null;
        try {
            root = springFXMLLoader.load(filePath);
            Objects.requireNonNull(root);
        } catch (IOException e) {
            System.out.println("Unable to load file");
        }
        return root;
    }
    
    
}
