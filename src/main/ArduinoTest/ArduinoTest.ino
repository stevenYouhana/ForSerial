
void setup() {
  Serial.begin(9600);
  pinMode(13, OUTPUT);
}

void loop() {
 if (Serial.available() > 0) {
  int inByte = Serial.read();
  switch (inByte) {
    case 'a': Serial.write('O'); digitalWrite(13, HIGH);
      break;
    case 'b': Serial.write('O'); digitalWrite(13, LOW);
      break;
    default: ;
  }
 }  
}
