package Controlador;

import Modelo.FuncionesSQL;
import Modelo.Item;
import Modelo.Mozo;
import Modelo.MEMO;
import Modelo.Orden;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Generar_Orden_BACK {
    private Double Total = 0.0;
    
    public void Crear_Orden(List<Item> T_Pedidos, int N_mesa) throws SQLException{
        //System.out.println("antes de crear la orden");            //DEBUG para ubicar en que parte se esta ejecutando
        //System.out.println(MEMO.List_Ordenes);                    //DEBUG muestra la lista completa de ordenes
       
        for(Item Item : T_Pedidos){
             Total = Total + Item.precio; 
        }

        Orden orden = new Orden(T_Pedidos, 0, N_mesa, Total);          //Crea una orden con la lista de items T_Pedidos, el estado de la orden y el numero de mesa
        //System.out.println("Orden creada");                       //DEBUG 
        Encolar_Orden(orden, MEMO.List_Ordenes);                //llama a Encolar_Orden
    }
    
    public void Encolar_Orden(Orden orden, List <Orden> List_Ordenes) throws SQLException{
        //System.out.println("encolacion de Orden");                //DEBUG
        MEMO.List_Ordenes.add(orden);                           //Se añade la orden creada a la lista de ordenes
        //System.out.println("Lista de Ordenes despues");           //DEBUG
        System.out.println(MEMO.List_Ordenes);                    //DEBUG
        Asignar_mozo(orden);                                    //llama a Asignar_mozo
    }
    
    public void Asignar_mozo(Orden orden) throws SQLException{
        Mozo Menor = MEMO.Mozos.get(0);                         //Se toma al primer mozo de la lista de mozos activa como el menor
        //System.out.println("++++++++++++++++++++++++++++");         //DEBUG
        //System.out.println(Menor.getNombre() + "   "+ Menor.N_mesas);    //DEBUG muestra el nombre y numero de mesa del menor, en este caso el primer mozo de la lista
        for(Mozo N_m : MEMO.Mozos){                             //Itera la lista de Mozos para ver quien tiene la menor cantidad de mesas
            if(N_m.N_mesas < Menor.N_mesas){
                Menor = N_m;
            }
        }
        //System.out.println("El menor es:" + Menor.getNombre() + " Nº de mesas antes " + Menor.N_mesas);    //DEBUG
               // System.out.println(Menor.Mozo_Ordenes);                                               //DEBUG muestra las ordenes correspondientes al mozo que es el de menor mesas
        Menor.N_mesas = Menor.N_mesas+1;                        //Se suma 1 al numero de mesas del mozo
        Menor.Mozo_Ordenes.add(orden);                          //Se añade la orden a la lista de ordenes al mozo correspondiente
        FuncionesSQL fsql = new FuncionesSQL();
        fsql.insert_orden(orden, Menor);
        //System.out.println("El menor es:" + Menor.getNombre() + " Nº de mesas actual " + Menor.N_mesas);   //DEBUG
               // System.out.println(Menor.Mozo_Ordenes);                                                 //DEBUG
    }  
    
}
