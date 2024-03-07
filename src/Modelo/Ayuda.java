package Modelo;

public class Ayuda {
    private int cdinero;
    private Producto prods[];
    private int cp;
    
    public Ayuda(int cdinero, int cp){
        this.cdinero=cdinero;
        prods=new Producto[cp];
        this.cp=cp;
    }

    public int getCdinero() {
        return cdinero;
    }

    public Producto[] getProds() {
        return prods;
    }

    public int getCProds() {
        return cp;
    }

    public void setCdinero(int cdinero) {
        this.cdinero = cdinero;
    }

    public void setProds(Producto[] prods) {
        this.prods = prods;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    
    
    
    
    
    
}
