/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allchanzi.cellanalyzer.core;

import java.io.File;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author kane
 */
public class ImageProcessor {
    
    private List<File> files;
    private List<Mat> images;
    
   
    public void setFiles(List<File> files){
        this.files = files;
    }
    
    
    /////////PRIVATE/////////
    
    private List<Mat> convertFilesToMats(List<File> files){
        this.images.clear();
        files.forEach((file) -> {
            images.add(Imgcodecs.imread(file.getAbsolutePath()));
        });
        return images;
    }
 
    
}
