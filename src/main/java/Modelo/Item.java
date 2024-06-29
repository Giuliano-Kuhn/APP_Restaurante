package Modelo;


public class Item {
    public String nombre_Item;
    public String descripcion;
    public int categoria;
    public double precio;
    public int ID;

    public Item(String nombre_Item, double precio) {
        this.nombre_Item = nombre_Item;
        this.precio = precio;
    }
    
    public Item(int ID, String nombre_Item,String descripcion, int categoria, double precio) {
        this.ID = ID;
        this.nombre_Item = nombre_Item;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre_Item() {
        return nombre_Item;
    }

    public double getPrecio() {
        return precio;
    }   
    
}
