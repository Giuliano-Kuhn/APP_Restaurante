package Modelo;

import java.util.List;

public class Orden {
    public List<Item> Items;
    public int Estado;
    public int Mesa;
    public Double Total;

    public Orden(List<Item> Items, int Estado, int Mesa, Double Total) {
        this.Items = Items;
        this.Estado = Estado;
        this.Mesa = Mesa;
        this.Total = Total;
    }

    public List<Item> getItems() {
        return Items;
    }

    public int getEstado() {
        return Estado;
    }

    public int getMesa() {
        return Mesa;
    }
    
    
}
