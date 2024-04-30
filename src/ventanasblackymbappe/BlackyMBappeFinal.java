
package ventanasblackymbappe;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class BlackyMBappeFinal {
    private static VideoClub videoClubAux;
    public static void main(String[] args)throws IOException,PeliculaNoEncontradaEx,FormatoRutIncorrectoEx {
        
        VideoClub videoClubAux = new VideoClub();
        List<Pelicula> peliculas = videoClubAux.getPeliculas();
        peliculas = ParaLeer.leerPeliculas("C:\\Users\\Javier\\Documents\\NetBeansProjects\\VentanasBlackyMBappe\\src\\ventanasblackymbappe\\peliculas.txt");
        for(Pelicula pelicula : peliculas){
            videoClubAux.agregarPelicula(pelicula);
        }
        new VentanaIniciarSesion(videoClubAux).setVisible(true);
    }
    
}
