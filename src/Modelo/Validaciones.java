package Modelo;
import Vista.InOut;
import java.util.ArrayList;


public class Validaciones {
    InOut oe=new InOut();
    
    public boolean evaluarEdadC(int edad){
        return edad>=18 & edad<120;
    }
    
   public boolean evaluarEst(int est){
        return est>=1 & est<=7;
    } 
          
   public boolean evaluared(int ed){
        return ed>=1 & ed<=120;
    } 
   
   public boolean evaluarNombre(String cadena){
        boolean valido = true;
        for(int i=0; i<cadena.length();i++){
            char c = cadena.charAt(i);
            int ascii = (int) c;
            if(!((ascii>=65 && ascii<=90)||(ascii>=97 && ascii<=122)||(ascii==164 || ascii==165)||ascii==32)){
                valido = false;
            }
        }
        if(!valido){
            oe.mostraDatos("Nombre invalido.");
        }
        return valido;
   }
   
   public boolean evaluarIdPersona(ArrayList<Integer> idsExistentes, int nuevoId){
        boolean valido = true;
        for (int i=0; i<idsExistentes.size();i++){
            if(nuevoId == idsExistentes.get(i)){
                valido = false;
            }
        }
       return valido;
   }
   
   public boolean evaluarIdProds(ArrayList<Integer> idsExistentes, int nuevoId){
        boolean valido = true;
        for (int i=0; i<idsExistentes.size();i++){
            if(nuevoId == idsExistentes.get(i)){
                valido = false;
            }
        }
       return valido;
   }
}
