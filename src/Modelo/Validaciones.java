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
   
   public void evaluarCadena(String cadena, String nombre){
       
       boolean sePuedeEscribir = true;
       for(int i=0;i<nombre.length();i++){
           int contador=0;
           for(int j=0;j<cadena.length();j++){
               if(nombre.toLowerCase().charAt(i)==cadena.toLowerCase().charAt(j)){
                   contador++;
               }
            }
           if(contador==0){
            
            sePuedeEscribir=false;
           }
       }
       if(sePuedeEscribir==false){
               
            oe.mostraDatos("no se puede escribir el nombre con la cadena ingresada");
           }else{
               
          oe.mostraDatos("se puede escribir el nombre con la cadena ingresada");
           }
       
   }
   
   public void alfabeticos(Familia familia){
       
       int contador = familia.getPersonas().length;
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (familia.getPersonas()[j].getNombre().compareToIgnoreCase(familia.getPersonas()[j + 1].getNombre()) > 0) {
                    // Intercambiar arr[j] y arr[j+1]
                    Persona aux = familia.getPersonas()[j];
                    familia.getPersonas()[j] = familia.getPersonas()[j+1];
                    familia.getPersonas()[j + 1] = aux;
                }
            }
        }
        String mensaje="";
            mensaje+="Integrantes por orden alfabetico \n";
        for(int i=0;i<contador;i++){
            mensaje+=familia.getPersonas()[i].getNombre()+" \n";
        }
       oe.mostraDatos(mensaje);
       
   }
}
