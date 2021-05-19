#include <Servo.h>               // Incluímos la librería para poder controlar el servo

int Pin_Servo = 2;               //pin del servo motor
Servo servoMotor;                //Declaramos la variable para controlar el servo

int input;

void setup() {
  pinMode(13, OUTPUT); // Declaramos que utilizaremos el pin 13 como salida
  Serial.begin(9600); //Se inicia la comunicación serie

  servoMotor.attach(Pin_Servo);   // Iniciamos el servo para que empiece a trabajar con el pin 2
  servoMotor.write(0);            // Inicializamos al ángulo 0 el servomotor
  
}

void loop() {
  if (Serial.available() > 0) {

    input = Serial.read();
    
    if (input == '0'){
      digitalWrite(13, HIGH); //Si el valor de input es 1, se enciende el LED, esto significa que hay conexion con java
    }

    else if (input == '1'){  //abrir la puerta - desbloquear
      servoMotor.write(120);         //pone el servo motor en la posicion 90°
      delay(2000);                  // Hacemos una pausa de 2 seg
      //digitalWrite(13, HIGH); //Si el valor de input es 1, se enciende el LED
    }
    else if (input == '2') //cerrar la puerta - bloquear
    {
      servoMotor.write(0);          //pone el servo motor en la posicion 0°
      delay(2000);                  // Hacemos una pausa de 2 seg
      //digitalWrite(13, LOW); //Si el valor de input es diferente de 1, se apaga el LED
    }

  }
}
