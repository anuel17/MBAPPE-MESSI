
package ventanasblackymbappe;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



public class VideoClub{
    
    private List<Cliente> clientes;
    private List<Pelicula> peliculas;
    private Map<String, Pelicula> peliculasFavoritas;

    public VideoClub(){
        this.clientes = new ArrayList<>();
        this.peliculas = new ArrayList<>();
        this.peliculasFavoritas = new HashMap<>();
    }
    
    // Métodos getter
    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public Map<String, Pelicula> getPeliculasFavoritas() {
        return peliculasFavoritas;
    }

    public void agregarPelicula(Pelicula nuevaPelicula){
        peliculas.add(nuevaPelicula);
    }

    public void eliminarPelicula(String nombrePelicula) {
        Pelicula peliculaAEliminar = null;
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getNombre().equals(nombrePelicula)) {
                peliculaAEliminar = pelicula;
                break;
            }
        }

        if (peliculaAEliminar != null) {
            peliculas.remove(peliculaAEliminar);
            System.out.println("La película '" + nombrePelicula + "' ha sido eliminada con éxito.");
        } else {
            System.out.println("No se encontró la película '" + nombrePelicula + "'.");
        }
    }

    public void agregarUsuario(Cliente nuevoCliente){
        clientes.add(nuevoCliente);
    }

    public void mostrarPeliculas(){
        System.out.println("Listado de películas en el Video Club:");
        System.out.println("--------------------------------------");
        for(Pelicula pelicula : peliculas){
            System.out.println("Nombre: " + pelicula.getNombre());
            System.out.println("Estudio: " + pelicula.getStudio());
            System.out.println("Género: " + pelicula.getGenero());
            System.out.println("Fecha de lanzamiento: " + pelicula.getFechaLanzamiento());
            System.out.println("Disponible: " + (pelicula.isDisponible() ? "Sí" : "No"));
            System.out.println("--------------------------------------");
        }
    }

    public void mostrarHistorialPrestamos(String nombrePelicula){

        Pelicula pelicula = null;
        for(Pelicula p : peliculas){
            if(p.getNombre().equals(nombrePelicula)){
                pelicula = p;
                break;
            }
        }

        if(pelicula != null && !pelicula.getHistorial().isEmpty()){
            System.out.println("\nHistorial de préstamos de la película \"" + nombrePelicula + "\":");
            for (HistorialPrestamo prestamo : pelicula.getHistorial()){
                System.out.println("Cliente: " + prestamo.getRutCliente() + ", Fecha de préstamo: " + prestamo.getFechaPrestamo());
            }
        } 
        else{
            System.out.println("La película \"" + nombrePelicula + "\" no tiene historial de préstamos.");
        }
    }
    
    public void reservarPelicula(String nombrePelicula, String rutCliente, String fecha) throws PeliculaNoEncontradaEx{
        Pelicula pelicula = null;
        for(Pelicula p : peliculas){
            if(p.getNombre().equals(nombrePelicula)){
                pelicula = p;
                break;
            }
        }
        if(pelicula == null){
            throw new PeliculaNoEncontradaEx("La película \"" + nombrePelicula + "\" no se encontró en el Video Club.");
        }
        if(pelicula.isDisponible()){
            pelicula.setDisponible(false);
            pelicula.agregarHistorial(rutCliente, fecha);
            System.out.println("La película \"" + nombrePelicula + "\" ha sido reservada por el cliente con rut " + rutCliente);
        } 
        else{
            System.out.println("La película \"" + nombrePelicula + "\" no está disponible para ser reservada.");
        }
    }
    
    public void cancelarReserva(String nombrePelicula){
        Pelicula pelicula = null;
        for(Pelicula p : peliculas){
            if(p.getNombre().equals(nombrePelicula) && !p.isDisponible()){
                pelicula = p;
                break;
            }
        }

        if(pelicula != null){
            pelicula.setDisponible(true); 
            System.out.println("La película \"" + nombrePelicula + "\" ha sido devuelta.");
        } 
        else{
            System.out.println("La película \"" + nombrePelicula + "\" no está reservada.");
        }
    }

    // Método para agregar una película a las favoritas
    public void agregarPeliculaFavorita(String nombrePelicula, String rutCliente){
      Pelicula a = null;
      if(peliculasFavoritas.containsKey(nombrePelicula)){
          System.out.println("No se pudo encontrar la película \"" + nombrePelicula + "\".");
      }else{
          peliculasFavoritas.put(nombrePelicula, a);
          System.out.println("La película \"" + nombrePelicula + "\" se ha agregado a las favoritas del cliente con rut " + rutCliente);
      }
  }

    public void mostrarPeliculasFavoritas(String rutCliente){
      if(peliculasFavoritas.containsValue(rutCliente)){
          System.out.println("El cliente con rut " + rutCliente + " no tiene películas favoritas.");
      }
      else{
          System.out.println("Las películas favoritas del cliente con rut " + rutCliente + " son:");
          for(String nombrePelicula : peliculasFavoritas.keySet()){
              System.out.println("- " + nombrePelicula);
          }
      }
  }
    
    public void mostrarPeliculasFavoritas(String rutCliente,String genero){
      Pelicula peliculasFavoritasCliente = peliculasFavoritas.get(rutCliente);
      if(peliculasFavoritas.containsValue(rutCliente)){
          System.out.println("El cliente con rut " + rutCliente + " no tiene películas favoritas.");
      }else{
          System.out.println("Las películas favoritas del cliente con rut " + rutCliente + " son:");
          for(String nombrePelicula : peliculasFavoritas.keySet()){
              if((peliculasFavoritasCliente.getGenero()).equals(genero)){
                  System.out.println("- " + nombrePelicula);
              }
          }
      }
  }
    
}   
