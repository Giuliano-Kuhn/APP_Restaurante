package Modelo;

import java.util.LinkedList;
import java.util.List;

public class Mozo extends Personal{                         //hereda metodos y atributos de la clase personal
    public int N_mesas;
    public List<Orden> Mozo_Ordenes = new LinkedList<>();          //Inicializa la lista de ordenes del mozo
        
    public Mozo(int DNI, String Nombre, String Apellido){   //Constructor
        super(DNI, Nombre, Apellido);                       //llama al constructor de la superclase/clase padre
        N_mesas = 0;                                        //inicializa el numero de mesas del mozo en 0
    }
}
