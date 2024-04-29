
package ventanasblackymbappe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportePeliculas {

    public static void generarReporte(List<Pelicula> peliculas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("VIDEOCLUB_REPORTE.txt"))) {
            for (Pelicula pelicula : peliculas) {
                writer.write(pelicula.toString());
                writer.newLine();
            }
            System.out.println("El reporte de películas ha sido generado con éxito.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el reporte de películas.");
            e.printStackTrace();
        }
    }
}



