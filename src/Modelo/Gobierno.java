
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
            oe.mostraDatos("Ayuda "+ i+1);
            id=oe.pedirEntero("ingrese id");
            nombre=oe.pedirString("ingrese nombre");
            fv=oe.pedirString("Ingrese fecha vencimiento");
            cant=oe.pedirEntero("cantidad");
            Producto obp=new Producto(id,nombre,cant,fv);
            productos[i]=obp;// envia el objeto al vector
        }
        Ay.setProds(productos);
    }  
     
    public void crearFamilias(){
        int ind=0,res,edad,est,ced,cpf=0,rol;;
        String nom="",asds="";
        Persona personasF[];
        Persona cf;
        Familia fam=null;
        res=oe.pedirEntero(" si llega familia a postularse 1 sino otro valor");
        while(res==1){
            ced=oe.pedirEntero("ingrese cedula");
            nom=oe.pedirString("Ingrese nombre");
            do{
                edad=oe.pedirEntero("ingrese edad");
            }while(!v.evaluarEdadC(edad));
            do{
                est=oe.pedirEntero("Ingrese estrato");
            }while(!v.evaluarEst(est));
            cf=new Persona(ced,nom,edad);
            cf.setEstrato(est);
            cf.setRol(0);
            cpf=oe.pedirEntero("Cuantas personas componen su familia");
            personasF=new Persona [cpf];//sirve pára guardar las personas de esa familia
           
            for(int i=0; i<cpf;i++){
                oe.mostraDatos("Integrante "+ i+1);
                ced=oe.pedirEntero("ingrese identificacion");
                nom=oe.pedirString("Ingrese nombre");
               
                rol=oe.pedirEntero("Ingrese su rol 1.hijo, 2.conyugue, 3 padre"); 
                //validar la edad segun el rol
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
                String m="";
                m+="\nIntegrante "+0+ "\nNombre: "+personasF[i].getNombre()+"\ncedula: "+personasF[i].getId()+"\nrol: "+personasF[i].getRol();
            m+="\nEdad: "+personasF[i].getEdad();
            m+="\n longitud: "+personasF.length;
            oe.mostraDatos(m);
            }
            asds+="longitud 2: "+personasF.length;
            oe.mostraDatos(asds);
            fam=new Familia(cf, personasF,cpf); 
            familias_post.add(fam);
            String asd="tamano: "+fam.getPersonas()[1].getNombre();
            oe.mostraDatos(asd);
         /*       String m="";
                m+="\nIntegrante "+0+ "\nNombre: "+familias_post.get(0).getPersonas()[0].getNombre()+"\ncedula: "+familias_post.get(0).getPersonas()[0].getId()+"\nrol: "+familias_post.get(0).getPersonas()[0].getRol();
            m+="\nEdad: "+familias_post.get(0).getPersonas()[0].getEdad();
            oe.mostraDatos(m);*/
               
            //res=oe.pedirEntero(" si llega familia a postularse 1 sino otro valor");

            mostrarFam(familias_post.get(0));
        }  
    }
     
    public void mostrarFam(Familia fam){
        String m="";
        m+="cabeza de familia: "+fam.getP().getNombre()+"\ncedula: "+fam.getP().getId()+"\nrol: "+fam.getP().getRol();
        for(int i=0;i<fam.getPersonas().length;i++){
            m+="\nIntegrante "+i+ "\nNombre: "+fam.getPersonas()[i].getNombre()+"\ncedula: "+fam.getPersonas()[i].getId()+"\nrol: "+fam.getPersonas()[i].getRol();
            m+="\nEdad: "+fam.getPersonas()[i].getEdad();
        }
        oe.mostraDatos(m);
    }
    
   public void evaluarFamilia(){
        boolean esApta=false;
        Persona inteFam[];
        Producto prodsAyu[];
       
        for(Familia famPos:familias_post){
            String mensaje = "Ayuda: ";
            if(famPos.getP().getEstrato()>=4){
                mensaje="Familia no apta para recibir ayuda";
                esApta=false;
                break;
            }
            if(famPos.getP().getEstrato()==1 || famPos.getP().getEstrato()==2){
                if(Ay.getCdinero()>=1000000){
                    Ay.setCdinero(Ay.getCdinero()-1000000);
                    esApta=true;
                    mensaje+="1000000$, ";
                }
            }
            if(famPos.getP().getEstrato()==3){
                if(Ay.getCdinero()>=500000){
                    Ay.setCdinero(Ay.getCdinero()-500000);
                    esApta=true;
                    mensaje+="500000$, ";
                }
            }
            if(famPos.getCp()>0){
                for(Persona cadaInt:famPos.getPersonas()){ 
                    if(cadaInt.getEdad()<=5){
                        prodsAyu=Ay.getProds();
                        for(Producto prod:prodsAyu){
                            if(prod.getCantExistente()>0){
                            prod.setCantExistente(prod.getCantExistente()-1);
                            mensaje+="recibe 1 "+ prod.getNombre()+" ";
                            famPos.setEstadoAyu(true);
                            }
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
                       