package Modelo;

public class Producto {
// atributos    
    private String nombre;
    private int id;
    private int cantExistente;
    private String fechaVenc;
    
// metodos

    public Producto(int id, String nombre,int cantExistente, String fechaVenc){
        this.id=id;
        this.nombre=nombre;
        this.fechaVenc=fechaVenc;
        this.cantExistente=cantExistente;
    }
  
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
  
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
  
    public String getFechaVenc(){
        return fechaVenc;
    }
    
    public void setFechaVenc(String fechaVenc){
        this.fechaVenc=fechaVenc;
    }
  
    public int getCantExistente(){
        return cantExistente;
    }
    
    public void setCantExistente(int cantExistente){
        this.cantExistente=cantExistente;
    }
    
   
    
    
}
