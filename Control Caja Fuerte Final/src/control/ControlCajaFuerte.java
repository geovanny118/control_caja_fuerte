
package control;

import Formularios.Cargando2;
import Mensajes.validacion1;
import Mensajes.validacion2;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java_arduino.JavaTX;
import javax.swing.JOptionPane;
import modelo.*;

public abstract class ControlCajaFuerte {

    public static FileWriter fw;
    public static String cont = "";
    public static String key = "";
    public static String pass="";
    public static String email="";

    
    
    /*
    public static void crearContraseña(){
        cont=JOptionPane.showInputDialog("Por favor ingrese una contraseña: ");
        guardarContraseña();
    }
    */
    
    public static void guardarContraseña(String cont){
        try{
            fw = new FileWriter("contraseña.txt");
            fw.write(cont);  
            fw.close();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        //JOptionPane.showMessageDialog(null, "Contraseña creada con exito");
    }
    
    
    public static void leerContraseña(String c, AudioClip sonido1, AudioClip sonido2){
        
        try{ 
            FileReader fr = new FileReader("contraseña.txt");
           
            BufferedReader BR = new BufferedReader(fr);
            pass = BR.readLine();//guarda en variable pass la contraseña
            //JOptionPane.showMessageDialog(null,pass);
            //key=JOptionPane.showInputDialog("Por favor ingrese una contraseña: ");
            
            key = c;
            
            if(key.equals(pass)){
             //  JOptionPane.showMessageDialog(null, "Contraseña correcta caja abierta");
             // Cargando2 cargarlogin = new Cargando2();
             // cargarlogin.setVisible(true);
             validacion1 correcta = new validacion1();
             correcta.setVisible(true);
             sonido1.play();
             JavaTX.DesbloquearCaja();//envia 1 a arduino
               //JavaTX.abrirPuerta();
             
            }
            else{
                // JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                JavaTX.BloquearCaja();//envia 0 a arduino
                sonido2.play();
                //JavaTX.cerrarPuerta();       
                //Cargando2 cargarlogin = new Cargando2();
                //cargarlogin.setVisible(true);    
                validacion2 incorrecta = new validacion2();
                incorrecta.setVisible(true);
            }
            
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }    
    }
       
        public static boolean ConfirmarContraseña(String c){
        boolean estado = false;
        try{
            
            FileReader fr = new FileReader("contraseña.txt");
            BufferedReader BR = new BufferedReader(fr);
            pass = BR.readLine();//guarda en variable pass la contraseña
            //JOptionPane.showMessageDialog(null,pass);
            //key=JOptionPane.showInputDialog("Por favor ingrese una contraseña: ");
            
            key = c;
            
            if(key.equals(pass)){
                estado = true;
                return estado;
             
            }
            else{
              
                return estado;
            }
            
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } 
        return estado;
    }
        
    public static String ObtenerContraseña(){
        
        try{            
            FileReader fr = new FileReader("contraseña.txt");
            BufferedReader BR = new BufferedReader(fr);
            pass = BR.readLine();//guarda en variable pass la contraseña
            return pass;             
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } 
        return pass;
    }
     
    public static String ObtenerEmail(){
        
        try{            
            FileReader fr = new FileReader("correo.txt");
            BufferedReader BR = new BufferedReader(fr);
            email = BR.readLine();//guarda en variable pass la contraseña
            return email;             
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } 
        return email;
    }
        
}
