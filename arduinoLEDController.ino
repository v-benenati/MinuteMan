#include <Wire.h>

void setup()
{
  const int ADDRESS = 4;
  pinMode (13, OUTPUT);
  Wire.begin(ADDRESS);                // join i2c bus with address #ADDRESS
  Wire.onReceive(receiveEvent); // register event
}

void loop()
{
  delay(100);
}

// function that executes whenever data is received from master
// this function is registered as an event, see setup()
void receiveEvent(int howMany)
{
  String LED = "";//LED color
 
  while ( Wire.available() > 0 )
  {
    char n=(char)Wire.read();
    if(((int)n)>((int)(' '))){
      LED += n;
    }
  }
  
  if (LED == "go") 
  {
    
    digitalWrite (13, HIGH);
  
    
  }
}
