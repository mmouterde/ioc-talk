package app.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * Cette classe est responsable de l'affichage de plusieurs matrices sous forme d'un carrer
 * Sa méthode drawMatrix peut être appelée plusieurs fois pour remplir le canvas
 */
public class DrawMatrixServiceImpl {

    private final int canvasWidth = 600;
    private final int matrixSize = (int) Math.sqrt(25);
    private final int matrixByRow = 5;
    private final int rectangleSize;

    private Canvas canvas;
    private int nbMatrix = 0;


    public DrawMatrixServiceImpl() {
        this.rectangleSize = (int) Math.round((Math.sqrt((canvasWidth * canvasWidth) / 25) / matrixSize));
    }

    private void drawRectange(Canvas canvas, int x, int y, double value) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(200, 200, 200, value));
        gc.fillRect(x, y, rectangleSize, rectangleSize);
    }

    private void drawAMatrix(Canvas canvas, double[][] matrix, int matrixIndex) {
        int xoffset = (matrixIndex % matrixByRow) * matrixSize;
        int yoffset = (Math.round(nbMatrix / matrixByRow) % matrixByRow) * matrixSize;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                drawRectange(canvas, (x + xoffset) * rectangleSize, (y + yoffset) * rectangleSize, matrix[x][y]);
            }
        }
    }

    public Canvas drawMatrix(double[][] matrix) {
        if (canvas == null) {
            canvas = new Canvas(canvasWidth, canvasWidth);
        }
        drawAMatrix(canvas, matrix, nbMatrix);
        nbMatrix++;
        return canvas;
    }

}
