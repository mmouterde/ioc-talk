package app.service;

import net.mixioc.annotation.Service;

@Service
public class MatrixProducerServiceImpl2 implements MatrixProducerService {

    public MatrixProducerServiceImpl2() {
    }

    /**
     * Produce a 5x5 matrix of double
     *
     * @return 5x5 matrix of double in [0,1]
     */
    @Override
    public double[][] getMatrix() {
        double[][] matrix = {
                {1.0, 0.5, 0.75, 1, 0.3},
                {0.5, 1, 0.75, 0.63, 0.25},
                {0.33, 0.76, 0.9, 0.12, 0.6},
                {0.67, 0.1, 0.7, 0.83, 0.99},
                {0.22, 0.56, 0.72, 0.45, 0.14}
        };
        return matrix;
    }

}
