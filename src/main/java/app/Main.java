package app;

import app.service.IHMService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.mixioc.ServiceManager;
import net.mixioc.annotation.Inject;

public class Main extends Application {

    @Inject
    private IHMService ihmService;

    public Main() {
    }

    public Pane functionnalBoostrap() {
        return ihmService.draw();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        Group root = new Group();
        root.getChildren().add(new Main().functionnalBoostrap());
        stage.setScene(new Scene(root));
        stage.setWidth(610);
        stage.setHeight(640);
        stage.setTitle("ioc-talk");
        stage.show();
    }

    public static void main(String[] args) {
        ServiceManager.init("app");
        launch(args);
    }

}
