package Modelo;

class Personal {
   private int DNI;
   private String Nombre;
   private String Apellido;
   private int Numero_de_Contacto;
   private String Email;
   private int ROL;
   private String Usuario;
   private String Contrasena;

    public Personal() {             //Esta clase va a ser una clase padre porque va a servir para el registrar personal, como para los mozos activos en el sistema
    }

   
    public Personal(int DNI, String Nombre, String Apellido) {  //Contructor
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getNumero_de_Contacto() {
        return Numero_de_Contacto;
    }

    public void setNumero_de_Contacto(int Numero_de_Contacto) {
        this.Numero_de_Contacto = Numero_de_Contacto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getROL() {
        return ROL;
    }

    public void setROL(int ROL) {
        this.ROL = ROL;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    
}
