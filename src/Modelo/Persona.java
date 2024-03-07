
package Modelo;

public class Persona {
// Atributos
    private int id;
    private String nombre;
    private int rol;
    private int estrato;
    private int edad;
    
// Metodos

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRol() {
        return rol;
    }

    public int getEstrato() {
        return estrato;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
}
