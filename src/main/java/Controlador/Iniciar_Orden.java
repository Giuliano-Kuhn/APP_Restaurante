package Controlador;

import Modelo.FuncionesSQL;
import Modelo.Item;
import Modelo.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Iniciar_Orden", urlPatterns = {"/Iniciar_Orden"})
public class Iniciar_Orden extends HttpServlet {
    public Menu menuM; //Declara una instancia de la clase Menu 
    public List menu;  //Declara una Lista para el menu
    private ArrayList<Integer> mesas = new ArrayList<>(); // Este arreglo lo que hace es simular una consulta a una base de datos para ver los codigos existentes de mesas
    private boolean verificacion_codigo;
    private int codigo;
    
    @Override   //Sobreescrime el metodo doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Codigo = request.getParameter("COD");    //se trae del formulario anterior el codigo(COD) que se introduzco y se lo asigna a la variable Codigo para un mejor manejo y legibilidad
        codigo = Integer.parseInt(Codigo);              //Se pasa a int la varable Codigo para una comparacion futura
        verificacion_codigo = Verificar_Codigo(mesas);       //Se llama al metodo Verificar_Codigo() y el resultado se lo asigna a la variable
        if(verificacion_codigo){                        //Se consulta si el codigo es valido
            Recuperar_Menu();                           
            HttpSession misesion = request.getSession();//Se trae la sesion Actual
            misesion.setAttribute("Menu", menu);        //Guarda en la sesion el menu
            misesion.setAttribute("Nmesa",codigo);      //Guarda en la sesion el codigo de mesa
            Mostrar_Menu(request, response);            //llama a Mostrar_Menu()

        }        
    }

    
    
     public boolean Verificar_Codigo(ArrayList<Integer> mesas){
       boolean verificacion_codigo = false;
       FuncionesSQL fsql = new FuncionesSQL();
       fsql.CargarMesas(mesas);
       for(Integer elemento : mesas){   //for each para iterar en el arreglo de mesas
           if(elemento == codigo){  //compara para ver si existe el codigo en el arreglo de mesas
               verificacion_codigo = true;
               break;
           }
       }
        return verificacion_codigo;}//devuelve el valor de verificacion_codigo
     
   public void Mandar_a_Cartel_por_pedir(){
   }

   public void Recuperar_Menu(){
        menuM = new Menu(); //crea un objeto para poder acceder al menu 
        menu = menuM.Menu;  //Se asigna a la variable menu, el menu del local
   }
   
   public void Mostrar_Menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            try {
                response.sendRedirect("MostrarMenu.jsp");
            } catch (IOException ex) {
                processRequest(request, response);
            }
   }
   
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ERROR</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Ocurrió un error en iniciar la orden </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }   
}

     




