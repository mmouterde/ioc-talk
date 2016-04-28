package app.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import net.mixioc.annotation.Inject;
import net.mixioc.annotation.Service;

@Service
public class IHMServiceImpl implements IHMService {

    @Inject
    private DrawMatrixService matrixDrawer;

    @Inject
    private Iterable<MatrixProducerService> matrixProducerServices;

    public IHMServiceImpl() {
    }

    private ImageView drawImage(String url) {
        Image image = new Image(url);
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        return iv2;
    }

    public Pane draw() {
        Pane pane = new Pane();
        pane.getChildren().add(drawImage("file:src/main/resources/rhino-silhouette-clipart2.png"));
        boolean firstLoop = true;
        for (MatrixProducerService producer : matrixProducerServices) {
            Canvas firstCanvas = matrixDrawer.drawMatrix(producer.getMatrix());
            if (firstLoop) {
                pane.getChildren().add(firstCanvas);
            }
            firstLoop = false;
        }
        return pane;
    }

}
