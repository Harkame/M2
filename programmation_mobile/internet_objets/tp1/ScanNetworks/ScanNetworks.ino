#include "ESP8266WiFi.h"

void setup()
{
  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.disconnect();
  delay(100);
}

void loop()
{
  int networksCounter = WiFi.scanNetworks();
  
  if (networksCounter == 0)
    Serial.println("no networks found");
  else
  {
    for (int index = 0; index < networksCounter; index++)
    {
      Serial.print(index);
      Serial.print(" : ");
      Serial.print(WiFi.SSID(index));
      Serial.print(" (");
      Serial.print(WiFi.RSSI(index));
      Serial.print(")");
      Serial.println((WiFi.encryptionType(index) == ENC_TYPE_NONE)?" ":"*");
      delay(10);
    }
  }
  Serial.println("");

  delay(5000);
}
