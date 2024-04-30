
package ventanasblackymbappe;

public class ClienteModifica2 extends Cliente {

    public ClienteModifica2(String nombre, String rut, int edad){
        super(nombre,rut,edad);
    }

    @Override
    public void setRut(String r) {
        if(esRutValido(r)){
            super.setRut(r);
            System.out.println("El rut ha sido cambiado con exito!");
        }
        else{
            System.out.println("El rut no se ha podido cambiar!");
        }
    }
}
