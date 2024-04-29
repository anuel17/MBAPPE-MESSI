
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
    public static void main(String[] args)throws IOException,PeliculaNoEncontradaEx,FormatoRutIncorrectoEx {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaIniciarSesion().setVisible(true);
            }
        });
    }
    
}
