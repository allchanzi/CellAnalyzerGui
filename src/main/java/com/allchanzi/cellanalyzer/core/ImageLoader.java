/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allchanzi.cellanalyzer.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import javafx.scene.image.Image;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Component;

/**
 *
 * @author kane
 */

@Component
public class ImageLoader {
    
    private File file;
    private Mat mat;
    
    public void setFile(File file){
        this.file = file;
        setMat(file);
    }
    
    public void setMat(File file){
        this.mat = Imgcodecs.imread(file.getAbsolutePath());
    }
    
    public Image getImageFromFile(File file){
        setMat(file);
        MatOfByte byteMap = new MatOfByte();
        Imgcodecs.imencode(".bmp", this.mat, byteMap);
        return new Image(new ByteArrayInputStream(byteMap.toArray()));
    }        
       
    public Mat getMat(){
        return this.mat;
    }
}
