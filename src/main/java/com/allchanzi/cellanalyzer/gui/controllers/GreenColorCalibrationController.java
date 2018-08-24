package com.allchanzi.cellanalyzer.gui.controllers;

import com.allchanzi.cellanalyzer.gui.GuiManager;
import com.allchanzi.cellanalyzer.gui.view.WindowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author allchanzi
 * @project CellAnalyzer
 * @date 8/7/2018
 */

@Component
public class GreenColorCalibrationController {
    
    private final GuiManager guiManager;

    @Autowired 
    @Lazy
    public GreenColorCalibrationController(GuiManager guiManager){
        this.guiManager = guiManager;
    }
    
    public void   nextButtonClicked(){
        guiManager.switchScene(WindowView.MAIN);
    }
}
