package Controlador;

import Modelo.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Generar_Orden", urlPatterns = {"/Generar_Orden"})
public class Generar_Orden extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //processRequest(request, response);
        String[] values = request.getParameterValues("items");              //Se traen los items seleccionados de la session y se almacenan en un array
        List<List> MENU = (List) request.getSession().getAttribute("Menu"); //Se trae el menu de la sesion
        int N_mesa = (int) request.getSession().getAttribute("Nmesa");      //Se trae el numero de mesa
        List<Item> T_Pedidos= new LinkedList<>();                           //Se inicializa la lista T_Pedidos para almacenar los items seleccionado en modo de objetos de la clase Item
        //System.out.println(values.length);                                  //DEBUG muestra cuantos items son
        //System.out.println(N_mesa);                                         //DEBUG muestra el numero de la mesa
        if(values != null){                                                   //Pregunta si existen items o esta vacio
          try {
            for(List<Item> categorias : MENU){                              //Itera el MENU
                for(Item item : categorias){                                //Itera las categorias del menu
                    for(int i = 0; i < values.length; i++) {                //Itera los items seleccionados
                        if (item.ID ==Integer.parseInt(values[i])) {           //Compara los items seleccionados con los de las categorias
                            T_Pedidos.add(item);                            //Para luego añadir los objetos Item a la lista de T_Pedidos
                            //System.out.println(item.nombre_Item);           //DEBUG muestra el nombre de los items añadidos
                           
                        }
                    }
                }
            }
            Generar_Orden_BACK GOB = new Generar_Orden_BACK();                  //Declara e inicializa una instancia de Generar_Orden_BACK, esta clase es para "separar" la parte "servlets" de los procesos exclusivos del Sistema
            GOB.Crear_Orden(T_Pedidos, N_mesa);                                 //llama a Crear_Orden para crear la orden en el sistema
            processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Generar_Orden.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> La Orden fue creada con exito, Muchas gracias</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    
}
