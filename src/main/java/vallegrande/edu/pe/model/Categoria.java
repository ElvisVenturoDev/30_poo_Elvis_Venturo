package vallegrande.edu.pe.model;

public class Categoria {
    private int id;
    private String name;
    private String description;

    public Categoria(int id, String name, String description){
        this.id = id;
        this.name= name;
        this.description = description;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void mostrarCategoria(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("------------------------------------");
    }
}