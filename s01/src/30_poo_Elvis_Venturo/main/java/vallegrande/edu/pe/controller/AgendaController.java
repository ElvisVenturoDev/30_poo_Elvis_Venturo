package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;
import java.security.PublicKey;


public class AgendaController {

    //Lista Contactos
    private ArrayList <Contacto> contactos;

    //Constructor
    public AgendaController(){
        contactos = new ArrayList<>();
    }
    //Agregar Contacto
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
        System.out.println("Contacto agregado correctamente");
    }

    //Listar Contactos
    public void listarContactos(){
        System.out.println("LISTA DE CONTACTOS");
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        for ( Contacto contacto : contactos){
            contacto.mostrarContacto();
        }
    }
    // Buscar contacto
    public void buscarContacto(String nombre) {

        boolean encontrado = false;

        for (Contacto contacto : contactos) {

            if (contacto.getNombres().toLowerCase()
                    .contains(nombre.toLowerCase())) {

                contacto.mostrarContacto();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro el contacto.");
        }
    }

    // Eliminar contacto por ID
    public void eliminarContacto(int id) {

        for (Contacto contacto : contactos) {

            if (contacto.getId() == id) {

                contactos.remove(contacto);

                System.out.println("Contacto eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontro un contacto con ese ID.");
    }
}