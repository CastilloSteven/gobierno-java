
package Modelo;

import Vista.InOut;


public class Gobierno {
    //atributos de la clase 
     Familia familias_post[]=new Familia[100];//se define vector de familias postuladas
     Familia familias_ayu[]=new Familia[100];
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
       int ind=0,res,edad,est,ced,cpf=0,rol;
       String nom;
       Persona personasF[];
       Persona cf;
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
           cpf=oe.pedirEntero("Cuantas personas componen su familia");
           personasF=new Persona [cpf];//sirve pára guardar las personas de esa familia
           for(int i=0; i<cpf;i++){
               oe.mostraDatos("Integrante"+(i+1));
               ced=oe.pedirEntero("ingrese identificacion");
               nom=oe.pedirString("Ingrese nombre");
               
               do{
                   edad=oe.pedirEntero("ingrese la edad");
               }while(!v.evaluared(edad));
               
               rol=oe.pedirEntero("Ingrese su rol 1.hijo, 2.conyugue, 3 padre"); 
               //validar la edad segun el rol
               switch(rol){
                  case 1:
                        while(edad>=cf.getEdad()+15 || !v.evaluared(edad)){
                            edad=oe.pedirEntero("ingrese la edad");
                        };
                    break;
                  case 2:
                        while(!v.evaluared(edad)){
                            edad=oe.pedirEntero("ingrese la edad");
                        }; 
                    break;
                  case 3:
                        while(edad<=cf.getEdad()+15 || !v.evaluared(edad)){
                            edad=oe.pedirEntero("ingrese la edad");
                        };
                    break;
               }
               Persona Integ=new Persona(ced,nom,edad);
                Integ.setRol(rol);
                personasF[i]=Integ;
        }
               Familia fam=new Familia(cf, personasF,cpf); 
               familias_post[ind]=fam;
               res=oe.pedirEntero(" si llega familia a postularse 1 sino otro valor");

        }  
     }

     public void ayudaFamilia(){
         
     }
     
     public void mostrarFamilia(){
         int cedula=oe.pedirEntero("buscar cedula");
         String mensaje="";
         
         for(int i=0;i<familias_post.length;i++){
             if (familias_post[i].getP().getId() == cedula) {
                 mensaje += "Cabeza de familia: " + familias_post[i].getP().getNombre() + " rol: " + familias_post[i].getP().getRol();
                 break;
             }
         }
         oe.mostraDatos(mensaje);
     }
     
    public void ifFamiliaApta(){
        for(int i=0;i<familias_post.length;i++){
             
         }
    }
     
     
}
                       