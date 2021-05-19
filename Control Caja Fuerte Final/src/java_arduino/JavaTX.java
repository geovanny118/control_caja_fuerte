
package java_arduino;

//libreria necesarias para conectar java con arduino
import Mensajes.ArduinoConectado;
import Mensajes.ArduinoNO;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


//clase para Transmisión en Java – Recepción en Arduino
public abstract class JavaTX {
    
    //Se crea una instancia de la librería PanamaHitek_Arduino
    public static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    
    public static boolean contectarConArduino() throws ArduinoException{
        try{
            //se inicia la comunicación con el puerto serie
            ino.arduinoTX("COM9", 9600);
            //JOptionPane.showMessageDialog(null, "Arduino conectado con exito");
            
            ArduinoConectado arduino = new ArduinoConectado();
            arduino.setVisible(true);
            int hola=0;
            
            //envia 0 a arduino para enceder led y comprobar conexion con java
            ino.sendData("0");
            return true;
            
        }catch (ArduinoException | SerialPortException ex){
            Logger.getLogger(JavaTX.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "No se pudo conectar el Arduino");
            
            ArduinoNO noconectado = new ArduinoNO();
            noconectado.setVisible(true);
            return false;
        }
        
    }
    
    public static void DesbloquearCaja(){
        //se hace el envio del string "1"
        try{
            ino.sendData("1");
        }catch(ArduinoException | SerialPortException ex){
            Logger.getLogger(JavaTX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void BloquearCaja(){
        //se hace el envio del string ""
        try{
            ino.sendData("2");
        }catch(ArduinoException | SerialPortException ex){
            Logger.getLogger(JavaTX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        /*
            public static void enviarUnoArduino(){
        //se hace el envio del string "1"
        try{
            ino.sendData("1");
        }catch(ArduinoException | SerialPortException ex){
            Logger.getLogger(JavaTX.class.getName()).log(Level.SEVERE, null, ex);
        }  
         
 
    }
    
        public static void enviarCeroArduino(){
        //se hace el envio del string ""
        try{
            ino.sendData("0");
        }catch(ArduinoException | SerialPortException ex){
            Logger.getLogger(JavaTX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        */
        
          
        

}
