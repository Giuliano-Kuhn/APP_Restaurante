package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionesSQL {
    
    ConexionDB cx = new ConexionDB();
    int ultimoID;
    ResultSet resultado;
    public FuncionesSQL() {
    }
    

    
    public void insert_orden(Orden orden, Mozo mozo) throws SQLException{
        int Cod_mesa = orden.getMesa();
        int DNI_Mozo = mozo.getDNI();
        Double Total = orden.Total;
        try {
            String sql_insert = "INSERT INTO orden(Codigo_mesa, Mozo_DNI, Fecha, Total) VALUES ( ? , ? , current_timestamp(), ? );";
            PreparedStatement PS = cx.conectar().prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            PS.setInt(1, Cod_mesa);
            PS.setInt(2, DNI_Mozo);
            PS.setDouble(3, Total);
            PS.executeUpdate();
            resultado = PS.getGeneratedKeys();
            if(resultado.next()){
                ultimoID = resultado.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        insert_items_orden(orden);
    }
    
    
     public void insert_items_orden(Orden orden) throws SQLException{
        int Cantidad = 1;
        try {   

                
            for(Item it : orden.Items){
                PreparedStatement ps = cx.conectar().prepareStatement("SELECT ID_Item FROM item WHERE (ID_Item = ?)");
                ps.setString(1, String.valueOf(it.ID));
                ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                    int itemID = rs.getInt("ID_Item");         
               
                String sql_insert = "INSERT INTO Items_por_orden (ID_Orden, ID_Item, Cantidad) VALUES (?,?,?);";
                PreparedStatement PS = cx.conectar().prepareStatement(sql_insert);
                        System.out.println(ultimoID);
                PS.setInt(1, ultimoID);
                PS.setInt(2, itemID);
                PS.setInt(3, Cantidad);
                PS.executeUpdate();
                }
            }   
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
               
     
     public ArrayList<Integer> CargarMesas(ArrayList<Integer> Mesas){

        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM mesa")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        int aux;
                        aux = rs.getInt("Codigo_mesa");
                        Mesas.add(aux);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Mesas;
     }
     
     
     
     
     
     public List<Item> CargarDesayunos(List<Item> Desayunos){
            String nombre_Item;
            int Id;
            String descripcion;
            double precio;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 1")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id,nombre_Item, descripcion, 1, precio);
                        Desayunos.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Desayunos;
     }
     
     public List<Item> CargarBebidas(List<Item> Bebidas){
            String nombre_Item;
            String descripcion;
            double precio;
            int Id;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 3")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id,nombre_Item, descripcion, 1, precio);
                        Bebidas.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Bebidas;
     }
     
     public List<Item> CargarEntradas(List<Item> Entradas){
            String nombre_Item;
            String descripcion;
            double precio;
            int Id;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 2")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id, nombre_Item, descripcion, 1, precio);
                        Entradas.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Entradas;
     }
     
     public List<Item> CargarPastas(List<Item> Pastas){
            String nombre_Item;
            String descripcion;
            double precio;
            int Id;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 5")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id, nombre_Item, descripcion, 1, precio);
                        Pastas.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Pastas;
     }
     
     public List<Item> CargarCarnes(List<Item> Carnes){
            String nombre_Item;
            String descripcion;
            double precio;
            int Id;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 4")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id, nombre_Item, descripcion, 1, precio);
                        Carnes.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Carnes;
     }
     
     public List<Item> CargarGuarniciones(List<Item> Guarniciones){
            String nombre_Item;
            String descripcion;
            double precio;
            int Id;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 6")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id, nombre_Item, descripcion, 1, precio);
                        Guarniciones.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Guarniciones;
     }  
     
     public List<Item> CargarPostres(List<Item> Postres){
            String nombre_Item;
            String descripcion;
            double precio;
            int Id;
        try {
                try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT * FROM item WHERE ID_Categoria = 7")) {
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Id = rs.getInt("ID_Item");
                        nombre_Item = rs.getString("Nombre");
                        descripcion = rs.getString("Descripcion");
                        precio = rs.getDouble("Precio");
                        Item it = new Item(Id, nombre_Item, descripcion, 1, precio);
                        Postres.add(it);
                    }   }
            cx.desconectar(); 
        } catch (SQLException ex) {
            Logger.getLogger(FuncionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Postres;
     }
     
     
     
     
    
}
