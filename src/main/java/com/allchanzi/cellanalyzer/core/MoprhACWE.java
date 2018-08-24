/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allchanzi.cellanalyzer.core;

import org.opencv.core.Mat;

/**
 *
 * @author kane
 */


public class MoprhACWE {

    private final Mat inputImage;
    private Integer smoothing;
    private Integer lambda1;
    private Integer lambda2;
    
    public MoprhACWE(Mat inputImage){
        this.inputImage = inputImage;
    }
    
    public MoprhACWE(Mat inputImage, Integer smoothing){
        this.inputImage = inputImage;
    }
    
    public MoprhACWE(Mat inputImage, Integer smoothing, Integer lambda1, Integer lambda2){
        this.inputImage = inputImage;
    }
    
    public Integer getSmoothing() {
        return smoothing;
    }

    public void setSmoothing(Integer smoothing) {
        this.smoothing = smoothing;
    }

    public Integer getLambda1() {
        return lambda1;
    }

    public void setLambda1(Integer lambda1) {
        this.lambda1 = lambda1;
    }

    public Integer getLambda2() {
        return lambda2;
    }

    public void setLambda2(Integer lambda2) {
        this.lambda2 = lambda2;
    }
    
    
    
}
