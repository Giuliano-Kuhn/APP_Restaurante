package Modelo;

import java.util.LinkedList;
import java.util.List;

public class MEMO { //Esta clase se crea para mantener las Listas 
        public static List<Orden> List_Ordenes;
        public static List<Mozo> Mozos;

    public static void iniciarlizarListas() { 
        Mozo mozo1 = new Mozo(16520122,"Maria", "Balmaceda");    //Se crean Mozos simulando que iniciaron sesion en el sistema
        Mozo mozo2 = new Mozo(22411714,"Jose", "Lerda");
        Mozo mozo3 = new Mozo(33455213,"Juan", "Rodriguez");
        Mozos.add(mozo1);                               //Se añaden los mozos creados a la Lista de mozos activos
        Mozos.add(mozo2);
        Mozos.add(mozo3);
    }
    
    public static void CrearListas(){
        List_Ordenes = new LinkedList<>();              //inicializa las listas
        Mozos = new LinkedList<>();
    }
    
    public void MostrarLISTA(){
       System.out.println(List_Ordenes);
    }
}
