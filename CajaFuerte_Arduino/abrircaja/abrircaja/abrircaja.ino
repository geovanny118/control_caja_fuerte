#include <Servo.h>               // Incluímos la librería para poder controlar el servo

int Pin_Led = 13;                //pin del led
int Pin_Servo = 9;               //pin del servo motor
Servo servoMotor;                //Declaramos la variable para controlar el servo

void setup() {
    
  Serial.begin(9600);             // Iniciamos el monitor serie para mostrar el resultado

  pinMode(Pin_Led,OUTPUT);        // establecer que el pin 13 digital es una señal de salida
  servoMotor.attach(Pin_Servo);   // Iniciamos el servo para que empiece a trabajar con el pin 9
  servoMotor.write(0);            // Inicializamos al ángulo 0 el servomotor

}
void loop() {

    servoMotor.write(80);         //pone el servo motor en la posicion 90°
    digitalWrite(Pin_Led, HIGH);  // enciende el LED

  
}
