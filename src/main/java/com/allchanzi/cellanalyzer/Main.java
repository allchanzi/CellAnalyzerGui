package com.allchanzi.cellanalyzer; /**
 * @author allchanzi
 * @project CellAnalyzer
 * @date 7/18/2018
 */


import com.allchanzi.cellanalyzer.gui.GuiManager;
import com.allchanzi.cellanalyzer.gui.view.WindowView;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import nu.pattern.OpenCV;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext springContext;
    private GuiManager guiManager;
    
    public static void main(String[] args) throws IOException{
        OpenCV.loadShared();
        launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       guiManager = springContext.getBean(GuiManager.class, primaryStage);
       displayInitialView();
        
    }
    
    @Override
    public void init() throws Exception {
        springContext = bootstrapSpringApplicationContext();
    }
    
    @Override
    public void stop(){
        springContext.stop();
    }
    
    protected void displayInitialView(){
       guiManager.switchScene(WindowView.MAIN);
    }
    
    /////////PRIVATE/////////
    
    private ConfigurableApplicationContext bootstrapSpringApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        builder.headless(false); //needed for TestFX integration testing or eles will get a java.awt.HeadlessException during tests
        return builder.run(args);
    }
}


