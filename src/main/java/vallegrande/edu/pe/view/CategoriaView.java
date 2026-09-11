package vallegrande.edu.pe.view;


public class CategoriaView {
    //TITULO
    public void mostrarName(){
        System.out.println("=================");
        System.out.println("SISTEMA DE CATEGORIAS VG");
        System.out.println("=================");
    }
    //MENU
    public void mostrarMenu(){
        System.out.println("1. Registrar la descripcion de Categoria");
        System.out.println("2. Listar Categoria");
        System.out.println("3. Buscar Categoria");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opcion");
    }
    //MENSAJE
    public void mostrarMensaje( String mensaje){
        System.out.println(mensaje);
    }
}