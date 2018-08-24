/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allchanzi.cellanalyzer.gui.view;

import java.util.ResourceBundle;

/**
 *
 * @author kane
 */
public enum WindowView {
    MAIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("main.title");
        }

        @Override
        public String getSourceFile() {
            return "/fxml/MainWindow.fxml";
        }    
    }, CALIBRATION {
        @Override
        public String getTitle() {
            return "None";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/CalibrationWindow.fxml";
        }     
    }, RED_CALIBRATION {
        @Override
        public String getTitle() {
            return "Red Calibration";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/RedCalibrationWindow.fxml";
        }     
    }, YELLOW_CALIBRATION {
        @Override
        public String getTitle() {
            return "Yellow Calibration";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/YellowCalibrationWindow.fxml";
        }      
    }, GREEN_CALIBRATION {
        @Override
        public String getTitle() {
            return "Green Calibration";        
        }

        @Override
        public String getSourceFile() {
            return "/fxml/GreenColorCalibration.fxml";
        }      
    }, SNAKE_CALIBRATION {
        @Override
        public String getTitle() {
            return "Snake Calibration";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/SnakeCalibrationWindow";
        }     
    }, THRESHOLD_CALIBRATION {
        @Override
        public String getTitle() {
            return "Threshold Calibration";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/ThresholdCalibrationWindow.fxml";
        }     
    }, PROTOCOL {
        @Override
        public String getTitle() {
            return "Protocol";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/ProtocolWindow.fxml";
        }      
    }, PARAMETERS {
        @Override
        public String getTitle() {
            return "Parameters";
        }

        @Override
        public String getSourceFile() {
            return "/fxml/ParametersWindow.fxml";
        }    
    };
    
    abstract public String getTitle();
    abstract public String getSourceFile();
    
    public String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    };
}
