package Control;

import Vista.InOut;
import Modelo.Gobierno;

public class Ejecutar {
// atributos
    static InOut vista=new InOut();
    static Gobierno gobierno;
    
    public static void main(String[] args){
        devolverMenu();
    }
    
    public static int mostrarMenu(){
        String menu="SISTEMA DE AYUDAS DEL GOBIERNO \n";
        menu+="1. Ingresar cantidad dinero y ayudas \n";
        menu+="2. Ingresar Familias \n";
        menu+="3. Ingresar Consultas \n";
        menu+="4. Ingresar productos \n";
        menu+="5. Salir \n";
        return vista.pedirEntero(menu);
    }    
    
    public static void ejecutarMenu(int accion){
        int cantDinero=0, cantProds=0;
        switch(accion){
            case 1:
                do{
                    cantDinero=vista.pedirEntero("Ingrese el fondo de dinero");
                    cantProds=vista.pedirEntero("Ingrese la cantidad de ayudas ");
                }while(cantDinero<=0 || cantProds<=0);
                gobierno=new Gobierno(cantDinero,cantProds);
            break;
            case 2:
                gobierno.crearFamilias();
            break;
            case 3:
                
                gobierno.mostrarFamilia();
            break;
            case 4:
                gobierno=new Gobierno(1,1);
                gobierno.crearProds();
            break;
            case 5:
            break;
            
        }
    }
    
    public static void devolverMenu(){
        int opcion=0;
        do{
            opcion=mostrarMenu();
            ejecutarMenu(opcion);
        }while(opcion!=5);
    }
}
