package app.service;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class IHMServiceImpl {

    private final String backgroundImg;
    private final DrawMatrixServiceImpl matrixDrawer;

    public IHMServiceImpl(DrawMatrixServiceImpl matrixDrawer, String backgroundImg) {
        this.backgroundImg = backgroundImg;
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
        pane.getChildren().add(drawImage(backgroundImg));
        pane.getChildren().add(matrixDrawer.drawMatrix(matrix));
        return pane;
    }

}
