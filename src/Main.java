import edu.princeton.cs.stdlib.StdDraw;
import java.awt.*;
/**
 * Dibujar 1 linea que rebote en la pantalla junto a otras 5 lineas que imiten su comportamiento
 *
 * @author: Christopher Cortes
 * */
public class Main {
    /**
    * Main
    */
    public static void main(String[] args) {
        double[] OrigenLinea = new double[ 4 ];
        double[] desplazamiento = new double[ 4 ];

        //rango del lienzo
        double min = -1.0;
        double max = 1.0;

        //escala del lienzo
        StdDraw.setXscale (min , max);
        StdDraw.setYscale (min , max);

        DatosLinea (OrigenLinea , desplazamiento , min , max);

        //evitar el parpadeo de las lineas
        StdDraw.enableDoubleBuffering ();

        Funcionamiento (OrigenLinea , desplazamiento);
    }

    private static void Funcionamiento(double[] OrigenLinea , double[] desplazamiento) {
        //ciclo infinito
        while (true) {
            MovLinea (OrigenLinea , desplazamiento);
            GenLinea (OrigenLinea);
            StdDraw.show ();
            StdDraw.clear (Color.BLACK);

        }
    }/**
     *funcion que usa todos los datos declarados para mostrar el movimiento de las lineas generadas
     **/

    private static void MovLinea(double[] OrigenLinea , double[] desplazamiento) {
        //colision
        for (int i = 0 ; i < 4 ; i++) {
            if (Math.abs (OrigenLinea[ i ] + desplazamiento[ i ]) > 1) {
                desplazamiento[ i ] = -desplazamiento[ i ];
                OrigenLinea[ i ] += desplazamiento[ i ];
            }
        }
        //movimiento de la linea
        for (int c = 0 ; c < 4 ; c++) {
            OrigenLinea[ c ] += desplazamiento[ c ];
        }
    }/**
     *Funcion con las operaciones matematicas ligadas al movimiento de la linea dentro del lienzo
     **/
    private static void DatosLinea(double[] OrigenLinea , double[] desplazamiento , double min , double max) {
        for (int i = 0 ; i < 4 ; i++) {
            desplazamiento[ i ] = (0.01) * Math.random ();
            OrigenLinea[ i ] = min + (max - min) * Math.random ();
        }
    }/**
     *Funcion con las operaciones matematicas ligadas al punto de origen de la linea y la velocidad de desplazamiento
     **/
    private static void GenLinea(double[] origenLinea) {
        double pos=0;
        Color[] colores = {Color.RED , Color.ORANGE , Color.YELLOW , Color.GREEN , Color.BLUE , Color.MAGENTA};
        //ciclo finito que genera lineas
        for (int i = 0 ; i < 6 ; i++) {
            StdDraw.setPenColor (colores[ i ]);
            StdDraw.line (origenLinea[ 0 ] + pos , origenLinea[ 1 ] + pos , origenLinea[ 2 ] + pos , origenLinea[ 3 ] + pos);
            pos -= 0.02;
        }
    }/**
     *Funcion destinada a la generacion de lineas en el lienzo
     **/
}