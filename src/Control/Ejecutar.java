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
        menu+="2. Ingresar productos \n";
        menu+="3. Ingresar Familias \n";
        menu+="4. Mostrar Familias Ayudadas\n";
        menu+="5. Salir \n";
        return vista.pedirEntero(menu);
    }    
    
    public static void ejecutarMenu(int accion){
        int cantDinero=0, cantProds=0;
     //   boolean gobCargado=true, prodsCargado=true, famCargado=true;
        switch(accion){
            case 1:
                do{
                    cantDinero=vista.pedirEntero("Ingrese el fondo de dinero");
                    cantProds=vista.pedirEntero("Ingrese la cantidad de Productos");
                }while(cantDinero<=0 || cantProds<=0);
            //    gobCargado=false;
                gobierno=new Gobierno(cantDinero,cantProds);
              /*  String a=""+gobCargado;
                vista.mostraDatos(a);*/
            break;
            case 2:
             //   if(gobCargado==false){                
                    gobierno.crearProds();
            /*   //     prodsCargado=false;
                //a=""+gobCargado;
                //vista.mostraDatos(a);
                //}else{
                    vista.mostraDatos("Debe ingresar primero los fondos y cantidad de ayudas");
                a=""+gobCargado;
                vista.mostraDatos(a);
                }*/
            break;
            case 3:
            //    if(gobCargado==false && prodsCargado==false){
                gobierno.crearFamilias();
              /*  }else{
                    vista.mostraDatos("Debe ingresar primero los fondos, cantidad de ayudas y cargar los productos");
                }*/
            break;
            case 4:
             //   if(gobCargado==false && prodsCargado==false && famCargado==false){
                gobierno.evaluarFamilia();
               /* }else{
                    vista.mostraDatos("Dege ingresar primero las familias");
                }*/
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
