package Modelo;

import java.util.LinkedList;
import java.util.List;

public class Menu {
    public List<List> Menu;
    public List<Item> List_Desayunos;
    public List<Item> List_Bebidas;
    public List<Item> List_Entradas;
    public List<Item> List_Pastas;
    public List<Item> List_Carnes;
    public List<Item> List_Guarniciones;
    public List<Item> List_Postres;

    public Menu() {
        Menu = new LinkedList<>();
        List_Desayunos = new LinkedList<>();
        List_Bebidas = new LinkedList<>();
        List_Entradas = new LinkedList<>();
        List_Pastas = new LinkedList<>();
        List_Carnes = new LinkedList<>();
        List_Guarniciones = new LinkedList<>();
        List_Postres = new LinkedList<>();
        
        Menu.add(List_Desayunos);
        Menu.add(List_Bebidas);
        Menu.add(List_Entradas);
        Menu.add(List_Pastas);
        Menu.add(List_Carnes);
        Menu.add(List_Guarniciones);
        Menu.add(List_Postres);
        
        CargarDesayunos(List_Desayunos);
        CargarBebidas(List_Bebidas);
        CargarEntradas(List_Entradas);
        CargarPastas(List_Pastas);
        CargarCarnes(List_Carnes);
        CargarGuarniciones(List_Guarniciones);
        CargarPostres(List_Postres);
        
        Retornar_Menu(Menu);
    };
        
    private void CargarDesayunos(List<Item> Desayunos){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarDesayunos(Desayunos);
        Desayunos = aux;
    };  
    
    private void CargarBebidas(List<Item> Bebidas){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarBebidas(Bebidas);
        Bebidas = aux;
    };
        
    private void CargarEntradas(List<Item> Entradas){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarEntradas(Entradas);
        Entradas = aux;
    }; 
    
    private void CargarPastas(List<Item> Pastas){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarPastas(Pastas);
        Pastas = aux;
    };
   
    private void CargarCarnes(List<Item> Carnes){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarCarnes(Carnes);
        Carnes = aux;
    };
    
    private void CargarGuarniciones(List<Item> Guarniciones){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarGuarniciones(Guarniciones);
        Guarniciones = aux;
    };
    
    private void CargarPostres(List<Item> Postres){
        FuncionesSQL fsql = new FuncionesSQL();
        List<Item> aux = new LinkedList<>();
        aux = fsql.CargarPostres(Postres);
        Postres = aux;
    };   

    private List<List> Retornar_Menu(List<List> Menu) {
        return Menu;
    }
}
