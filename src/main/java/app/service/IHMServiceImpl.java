package app.service;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class IHMServiceImpl {

    private final DrawMatrixServiceImpl matrixDrawer;

    public IHMServiceImpl(DrawMatrixServiceImpl matrixDrawer) {
        this.matrixDrawer = matrixDrawer;
    }

    private ImageView drawImage(String url) {
        Image image = new Image(url);
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        return iv2;
    }

    public Pane draw(double[][] matrix) {
        Pane pane = new Pane();
        pane.getChildren().add(drawImage("file:src/main/resources/rhino-silhouette-clipart2.png"));
        pane.getChildren().add(matrixDrawer.drawMatrix(matrix));
        return pane;
    }

}
