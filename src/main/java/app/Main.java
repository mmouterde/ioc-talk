package app;

import app.service.DrawMatrixServiceImpl;
import app.service.IHMServiceImpl;
import app.service.MatrixProducerServiceImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private DrawMatrixServiceImpl matrixDrawer;
    private IHMServiceImpl ihmService;
    private MatrixProducerServiceImpl matrixProducerService;

    public Main() {
        matrixDrawer = new DrawMatrixServiceImpl();
        ihmService = new IHMServiceImpl(matrixDrawer);
        matrixProducerService = new MatrixProducerServiceImpl();
    }

    public Pane functionnalBoostrap() {
        return ihmService.draw(matrixProducerService.getMatrix());
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
        launch(args);
    }

}
