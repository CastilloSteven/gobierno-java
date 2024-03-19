
package Modelo;

import Vista.InOut;
import java.util.ArrayList;


public class Gobierno {
    //atributos de la clase 
    //Familia familias_post[]=new Familia[100];//se define vector de familias postuladas
    ArrayList <Familia> familias_post=new ArrayList <Familia>();
    ArrayList <Familia> familias_ayu=new ArrayList <Familia>();
    Ayuda Ay;
    InOut oe=new InOut();//crea el objeto para acceder a InOut
    Validaciones v=new Validaciones();
     
    public Gobierno(int cant_Dinero,int cproductos ) {//constructor 
        Ay=new Ayuda(cant_Dinero,cproductos);
    }
     
    public void crearProds(){
        int id,cant;
        String nombre,fv;
        Producto productos[]=new Producto[Ay.getCProds()];//definir el vector con la cantidad de productos que va a entregar el gobierno
        for(int i=0;i<Ay.getCProds(); i++){
            int j=i+1;
            oe.mostraDatos("Producto " + j);
            id=oe.pedirEntero("ingrese el id");
            nombre=oe.pedirString("ingrese el nombre");
            fv=oe.pedirString("Ingrese la fecha de vencimiento");
            cant=oe.pedirEntero("Ingrese la cantidad");
            Producto obp=new Producto(id,nombre,cant,fv);
            productos[i]=obp;// envia el objeto al vector
            oe.mostraDatos("Producto creado con exito");
        }
        Ay.setProds(productos);
    }  
     
    public void crearFamilias(){
        int ind=0,res,edad,est,ced,cpf=0,rol;;
        String nom="",asds="";
        Persona personasF[];
        Persona cf;
        Familia fam=null;
        res=oe.pedirEntero("Crear familia\n1. Ingresar Nueva familia\nOtro numero para salir");
        while(res==1){
            ced=oe.pedirEntero("ingrese cedula cabeza de familia");
            nom=oe.pedirString("Ingrese nombre completo");
            do{
                edad=oe.pedirEntero("ingrese la edad");
            }while(!v.evaluarEdadC(edad));
            do{
                est=oe.pedirEntero("Ingrese el estrato");
            }while(!v.evaluarEst(est));
            cf=new Persona(ced,nom,edad);
            cf.setEstrato(est);
            cf.setRol(0);
            cpf=oe.pedirEntero("Cantidad de integrantes de la familia");
            personasF=new Persona [cpf];//sirve pára guardar las personas de esa familia
           
            for(int i=0; i<cpf;i++){
                int j=i+1;
                oe.mostraDatos("Integrante "+ j);
                ced=oe.pedirEntero("ingrese id");
                nom=oe.pedirString("Ingrese nombre completo");
               
                rol=oe.pedirEntero("Ingrese su rol: 1.hijo, 2.conyugue, 3 padre"); 
                switch (rol) {
                    case 1:
                        do{
                           edad=oe.pedirEntero("ingrese la edad hijo");
                        }while(!v.evaluared(edad) || edad>cf.getEdad()-15);
                    break;
                    case 2:
                        do{
                            edad=oe.pedirEntero("ingrese la edad conyuge");
                        }while(!v.evaluared(edad));
                    break;
                    case 3:
                        do{
                            edad=oe.pedirEntero("ingrese la edad padre");
                        }while(!v.evaluared(edad) || edad<cf.getEdad()+15);
                    break;
                }
               
                Persona Integ=new Persona(ced,nom,edad);
                Integ.setRol(rol);
                personasF[i]=Integ;
            }
            fam=new Familia(cf, personasF,cpf); 
            fam.setEstadoAyu(false);
            familias_post.add(fam);
               
            oe.mostraDatos("Familia creada con exito");
            res=oe.pedirEntero("Crear familia\n1. Ingresar Nueva familia\nOtro numero para salir");

        }  
    }
    
   public void evaluarFamilia(){
        boolean esApta=false;
        Persona[] inteFam;
        Producto prodsAyu[];
       
        for(Familia famPos:familias_post){
            if(famPos.getEstadoAyu()==false){
                String mensaje = "";
                if(famPos.getP().getEstrato()>=4){
                    mensaje="Familia no apta para recibir ayuda";
                    esApta=false;
                    break;
                }
                mensaje+="Familia de "+famPos.getP().getNombre()+"\n";
                if(famPos.getP().getEstrato()==1 || famPos.getP().getEstrato()==2){
                    if(Ay.getCdinero()>=1000000){
                        Ay.setCdinero(Ay.getCdinero()-1000000);
                        esApta=true;
                        mensaje+="1000000$\n";
                    }
                }
                if(famPos.getP().getEstrato()==3){
                    if(Ay.getCdinero()>=500000){
                        Ay.setCdinero(Ay.getCdinero()-500000);
                        esApta=true;
                        mensaje+="500000$\n";
                    }
                }
                    for(Persona cadaInt:famPos.getPersonas()){ 
                        if(cadaInt.getEdad()<=5){
                            prodsAyu=Ay.getProds();
                            for(Producto prod:prodsAyu){
                                if(prod.getCantExistente()>0){
                                prod.setCantExistente(prod.getCantExistente()-1);
                                mensaje+=prod.getNombre()+"\n";
                                famPos.setEstadoAyu(true);
                                }
                            }
                        }
                    }

               oe.mostraDatos(mensaje);
               famPos.setEstadoAyu(esApta);
               familias_ayu.add(famPos);
            }
        }
   }
     
     
}
                       