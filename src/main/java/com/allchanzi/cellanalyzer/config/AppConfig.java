/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allchanzi.cellanalyzer.config;

import com.allchanzi.cellanalyzer.core.ImageLoader;
import com.allchanzi.cellanalyzer.gui.GuiManager;
import com.allchanzi.cellanalyzer.gui.view.SpringFXMLLoader;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author kane
 */
@Configuration
public class AppConfig {
    @Autowired
    SpringFXMLLoader springFXMLLoader;
    
    @Bean
    public ResourceBundle resourceBundle(){
        return ResourceBundle.getBundle("Bundle");
    }
    
    @Bean
    @Lazy(value = true)
    public GuiManager guiManager(Stage stage){
        return new GuiManager(stage, springFXMLLoader);
    }
    
    @Bean 
    @Lazy(value = true)
    public Stage newStage(){
        return new Stage();
    }
    
    @Bean
    public ImageLoader imageLoader(){
        return new ImageLoader();
    }
}
