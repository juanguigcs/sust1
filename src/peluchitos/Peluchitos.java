/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluchitos;

import java.util.Scanner;

/**
 *
 * @author El Memo
 */
public class Peluchitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner lector= new Scanner(System.in);
        Producto[] pro= new Producto[100];
        int opcion, contpro=0, f1=0;
        String name;
        double prec, cant, total=0;
               
        
        do{
            System.out.println("\n Digite la opción deseada");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Relaizar Venta");
            System.out.println("6. Mostrar ganacias totales");
            System.out.println("7. Salir");
            opcion = lector.nextInt();

            switch (opcion){
                
                case 1: 
                        pro[contpro]= new Producto();
                        System.out.println("1. Agregar Producto ");
                        System.out.print("Ingrese el nombre ");
                        name=lector.next();
                        System.out.print("Ingrese la cantidad ");
                        cant=lector.nextDouble();
                        System.out.print("Ingrese el precio ");
                        prec=lector.nextDouble();
                        pro[contpro].setCant(cant);
                        pro[contpro].setName(name);
                        pro[contpro].setPrec(prec);   
                        //pro[contpro].getName()
                        //pro[contpro].getPrec()
                        //pro[contpro].getCant()
                        
                        contpro ++;
                    break;
                case 2: 
                        System.out.println("2. Buscar Producto");
                        System.out.print("Ingrese el nombre ");
                        name=lector.next();
                        for(int i=0;i<contpro;i++){
                            if(name.equals(pro[i].getName())){
                                System.out.println("Nombre: "+pro[i].getName()+"\n"+
                                                    "cantidad: "+pro[i].getCant()+"\n"+
                                                    "precio: "+pro[i].getPrec()+"\n");
                                break;
                            }
                        }
                        System.out.println("Producto no existe \n"); 
                    break;
                case 3: 
                        System.out.println("3. Eliminar Producto");
                        System.out.print("Ingrese el nombre ");
                        name=lector.next();
                        for(int i=0;i<contpro;i++){
                            if(name.equals(pro[i].getName())){
                                for(int j=i;j<contpro;j++){
                                    pro[j]=pro[j+1];                                    
                                }
                                contpro --;
                            }
                        }   
                        System.out.println("Producto no existe \n"); 
                    break;
                case 4:
                        System.out.println("4. Mostrar Inventario");
                        for(int i=0;i<contpro;i++){
                            System.out.println("Nombre: "+pro[i].getName()+"\n"+
                                                "cantidad: "+pro[i].getCant()+"\n"+
                                                "precio: "+pro[i].getPrec()+"\n");
                            }
                    break;
                case 5: 
                        System.out.println("5. Relaizar Venta");
                        System.out.print("Ingrese el nombre ");
                        name=lector.next();
                        for(int i=0;i<contpro;i++){
                            if(name.equals(pro[i].getName())){
                                f1 ++;
                                System.out.print("Ingrese la cantidad a vender ");
                                cant=lector.nextDouble();
                                if(cant<=pro[i].getCant()){
                                    pro[i].setCant(pro[i].getCant()-cant);
                                    pro[i].setVend(pro[i].getVend()+cant);
                                    f1=1;
                                break;    
                                }
                                else
                                    System.out.print("Cantidad insuficiente \n");
                                break;
                            }
                        }
                        if(f1!=1)
                        System.out.println("Producto no existe \n");  
                    break;
                case 6: 
                    total=0;
                        System.out.println("6. Mostrar ganacias totales");
                            for(int i=0;i<contpro;i++){
                                System.out.println("Nombre: "+pro[i].getName()+"\n"+
                                                    "cantidad vendida: "+pro[i].getVend()+"\n"+
                                                    "total vendido: "+pro[i].getVend()*pro[i].getPrec()+"\n");
                                total=(pro[i].getVend()*pro[i].getPrec())+total;
                            }
                            System.out.println("el total total total es "+total+"\n");
                    break; 
                case 7: System.out.println("Hasta luego");
                    break;  
                 
                default: System.out.println("Opción invalida \n");
            }
        }while(opcion!=7);
          
    }
    
}
