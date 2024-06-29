package Controlador;

import Modelo.MEMO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {             //Declara que la clase Main hereda metodos de HttpServlet

    @Override
    public void init (ServletConfig config) throws ServletException{    //Sobreescribe el metodo init del servlet para realizar la inicializacion especifica al servlet.
        MEMO.CrearListas();             //llama al metodo CrearListas de la clase MEMO para crear las listas que van a mantener la informacion de ordenes, y mozos "activos".
        MEMO.iniciarlizarListas();     //llama al metodo que inicializa las listas
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  //Sobreescribe el metodo diGet para manejar las solicitudes HTTP `GET` de la parte web de la aplicacion
            throws ServletException, IOException {
          try {   //se hace un try para capturar algun error que pueda pasar.
                response.sendRedirect("index.jsp"); //Redirige la respuesta HTTP a la pagina index.jsp
            } catch (IOException ex) {
                processRequest(request, response);//Maneja la excepcion imprimiendo un mensaje de error
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
            out.println("<h1> Ocurrió un error en mostrar la pagina inicial </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }      
}