import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double[][] Lineas = new double[ 2 ][ 4 ];
        double min = -1.0;   //se asignan variables, destinadas a escalar el lienzo
        double max = 1.0;

        StdDraw.setXscale (min, max);
        StdDraw.setYscale (min, max); //se escala el lienzo usando las variables previamente definidas

        DatosLinea (Lineas, min, max);

        StdDraw.enableDoubleBuffering (); // esta funcion evita el parpadeo de las lineas

        while (true) {

            desplazamiento (Lineas);
            genLineas (Lineas[ 1 ][ 0 ], Lineas[ 1 ][ 1 ], Lineas[ 1 ][ 2 ], Lineas[ 1 ][ 3 ]);//generacion de las 6 lineas, se definen colores para cada una en relacion a los colores del arcoiris
            StdDraw.pause ((int) Math.random ());    //
            StdDraw.show ();

            StdDraw.clear (Color.BLACK);                                         //se define el fondo de color negro y elimina las lineas anteriores

        }
    }

    private static void DatosLinea(double[][] Lineas, double min, double max) {
        Lineas[ 0 ][ 0 ] = (0.01) * Math.random ();
        Lineas[ 0 ][ 1 ] = (0.01) * Math.random ();
        Lineas[ 0 ][ 2 ] = (0.01) * Math.random ();
        Lineas[ 0 ][ 3 ] = (0.01) * Math.random ();

        Lineas[ 1 ][ 0 ] = min + (max - min) * Math.random ();
        Lineas[ 1 ][ 1 ] = min + (max - min) * Math.random ();

        Lineas[ 1 ][ 2 ] = min + (max - min) * Math.random ();
        Lineas[ 1 ][ 3 ] = min + (max - min) * Math.random ();
    } // operaciones para generar los datos iniciales de la linea 1 (velocidad y punto de inicio)

    private static void desplazamiento(double[][] Lineas) {
        if (Math.abs (Lineas[ 1 ][ 0 ] + Lineas[ 0 ][ 0 ]) > 1) {
            Lineas[ 0 ][ 0 ] = -Lineas[ 0 ][ 0 ];
        }
        if (Math.abs (Lineas[ 1 ][ 1 ] + Lineas[ 0 ][ 1 ]) > 1) {
            Lineas[ 0 ][ 1 ] = -Lineas[ 0 ][ 1 ];
        }
        if (Math.abs (Lineas[ 1 ][ 2 ] + Lineas[ 0 ][ 0 ]) > 1) {
            Lineas[ 0 ][ 2 ] = -Lineas[ 0 ][ 2 ];
        }
        if (Math.abs (Lineas[ 1 ][ 3 ] + Lineas[ 0 ][ 1 ]) > 1) {
            Lineas[ 0 ][ 3 ] = -Lineas[ 0 ][ 3 ];
        }

        Lineas[ 1 ][ 0 ] += Lineas[ 0 ][ 0 ];
        Lineas[ 1 ][ 1 ] += Lineas[ 0 ][ 1 ];
        Lineas[ 1 ][ 3 ] += Lineas[ 0 ][ 3 ];
        Lineas[ 1 ][ 2 ] += Lineas[ 0 ][ 2 ];
    } // operaciones para limitar el tipo de movimiento que tendra la linea 1

    private static void genLineas(double x0, double y0, double x1, double y1) {
        StdDraw.setPenColor (StdDraw.RED);
        StdDraw.line (x0, y0, x1, y1);
        StdDraw.setPenColor (StdDraw.ORANGE);
        StdDraw.line (x0 - 0.02, y0 - 0.02, x1 - 0.02, y1 - 0.02);
        StdDraw.setPenColor (StdDraw.YELLOW);
        StdDraw.line (x0 - 0.04, y0 - 0.04, x1 - 0.04, y1 - 0.04);
        StdDraw.setPenColor (StdDraw.GREEN);
        StdDraw.line (x0 - 0.06, y0 - 0.06, x1 - 0.06, y1 - 0.06);
        StdDraw.setPenColor (StdDraw.BLUE);
        StdDraw.line (x0 - 0.08, y0 - 0.08, x1 - 0.08, y1 - 0.08);
        StdDraw.setPenColor (StdDraw.MAGENTA);
        StdDraw.line (x0 - 0.10, y0 - 0.10, x1 - 0.10, y1 - 0.10);
    }
}
