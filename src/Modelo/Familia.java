package Modelo;

public class Familia{
    private Persona p;
    private Persona personas[];
    private int cp;
    private boolean estadoAyu;
    
    
    public Familia(Persona p, Persona personas[], int cp){
        this.p=p;
        personas = new Persona[cp];
    }

    public Persona getP() {
        return p;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public int getCp() {
        return cp;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
    
    public void setEstadoAyu(Boolean estadoAyu){
        this.estadoAyu=estadoAyu;
    }
    
    public boolean getEstadoAyu(){
        return estadoAyu;
    }
    
    
    
}