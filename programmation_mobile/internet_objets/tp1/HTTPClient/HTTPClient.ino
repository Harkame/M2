/***************************************************************************
 * Point d'accès avec un NodeMCU (ESP-12E) pour commander une LED
 * *************************************************************************
 * Ce programme permet de configurer un ESP8266 en borne wifi (Access Point)
 * pour permettre à des clients de s'y connecter et d'allumer et d'éteindre
 * une LED (sur la led intégrée).
 *
 * Ce programme inclut un style CSS pour des boutons jolis
 * Pour d'autres modèles de boutons, aller sur le site : http://www.bestcssbuttongenerator.com/
 *
 * Ce programme peut servir de base pour des objets connectés (IoT)
 *
 *                           Par : Yassine HADDAB
 *                           Date : Mai 2016
 *                          
 * *************************************************************************
 */

/* les librairies nécessaires */
#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
//#include <WiFiClient.h>
/* remarque : la librairie WiFiClient.h n'est pas utilisée dans cet exemple car
 * le module ne sert que de serveur wifi. Il faudra l'utiliser si le module se
 * connecte en tant que client à un point d'accès wifi.
 */

/* Définition des paramètres de connexion au point d'accès wifi créé */
const char *ssid = "UneCarteArduino";
const char *password = "12345677";


char temp[4000]; /* une chaîne de caractères qui sera utilisée pour composer les pages html
                    J'ai choisi ici une longueur suffisante pour inclure le style css */


//192.168.4.1
ESP8266WebServer server(80);

void handleRoot() {
  server.send(200, "text/html", "<h1>You are connected</h1>"); // On envoie la page html en réponse à la requête.
}

void Allumer() {
  digitalWrite(2, LOW);

 // On compose la page html en réponse à cette requête et on la met dans la chaîne temp.
 snprintf ( temp, 4000, "<center><h1>LA LED EST ALLUMEE</h1></center> "
                                 
                                  "<br />"
                                  "<style>"
".myButton {"
 " -moz-box-shadow:inset 0px 1px 0px 0px #54a3f7;"
  "-webkit-box-shadow:inset 0px 1px 0px 0px #54a3f7;"
  "box-shadow:inset 0px 1px 0px 0px #54a3f7;"
  "background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #007dc1), color-stop(1, #0061a7));"
  "background:-moz-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:-webkit-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:-o-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:-ms-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);"
  "filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#007dc1', endColorstr='#0061a7',GradientType=0);"
  "background-color:#007dc1;"
  "-moz-border-radius:3px;"
  "-webkit-border-radius:3px;"
  "border-radius:3px;"
  "border:1px solid #124d77;"
  "display:inline-block;"
  "cursor:pointer;"
  "color:#ffffff;"
  "font-family:Arial;"
  "font-size:50px;"
  "padding:6px 24px;"
  "text-decoration:none;"
  "text-shadow:0px 1px 0px #154682;"
"}"
".myButton:hover {"
"  background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0061a7), color-stop(1, #007dc1));"
"  background:-moz-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
"  background:-webkit-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
 " background:-o-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
 " background:-ms-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
 " background:linear-gradient(to bottom, #0061a7 5%, #007dc1 100%);"
 " filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0061a7', endColorstr='#007dc1',GradientType=0);"
 " background-color:#0061a7;"
"}"
".myButton:active {"
"  position:relative;"
"  top:1px;"
"}"
"</style>"
"<body>"
                                 
                                  
                                 
                                  "<br /> <hr /> <br />"
                                  "<center><a href=\"ON\" class=\"myButton\">Allumer la LED</a></center>"
                                  "<br /> <hr /> <br />"
                                  "<center><a href=\"OFF\" class=\"myButton\">Eteindre la LED</a></center>"
                                  "<br /> <hr /> <br />"
                                  "<body>");
                                  /* remarque : en langage Arduino, on peut découper une chaîne longue
                                   * en plusieurs lignes en mettant des " au début et à la fin de
                                   * chaque ligne comme ce qui est fait ici
                                   */
     
  server.send(200, "text/html", temp); // on envoie la page.
}

void Eteindre()
{
  digitalWrite(2, HIGH);

// On compose la page html en réponse à cette requête et on la met dans la chaîne temp.
  snprintf ( temp, 4000, "<center><h1>LA LED EST ETEINTE</h1></center> "
                                 
                                  "<br />"
                                  "<style>"
".myButton {"
 " -moz-box-shadow:inset 0px 1px 0px 0px #54a3f7;"
  "-webkit-box-shadow:inset 0px 1px 0px 0px #54a3f7;"
  "box-shadow:inset 0px 1px 0px 0px #54a3f7;"
  "background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #007dc1), color-stop(1, #0061a7));"
  "background:-moz-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:-webkit-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:-o-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:-ms-linear-gradient(top, #007dc1 5%, #0061a7 100%);"
  "background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);"
  "filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#007dc1', endColorstr='#0061a7',GradientType=0);"
  "background-color:#007dc1;"
  "-moz-border-radius:3px;"
  "-webkit-border-radius:3px;"
  "border-radius:3px;"
  "border:1px solid #124d77;"
  "display:inline-block;"
  "cursor:pointer;"
  "color:#ffffff;"
  "font-family:Arial;"
  "font-size:50px;"
  "padding:6px 24px;"
  "text-decoration:none;"
  "text-shadow:0px 1px 0px #154682;"
"}"
".myButton:hover {"
"  background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0061a7), color-stop(1, #007dc1));"
"  background:-moz-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
"  background:-webkit-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
 " background:-o-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
 " background:-ms-linear-gradient(top, #0061a7 5%, #007dc1 100%);"
 " background:linear-gradient(to bottom, #0061a7 5%, #007dc1 100%);"
 " filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0061a7', endColorstr='#007dc1',GradientType=0);"
 " background-color:#0061a7;"
"}"
".myButton:active {"
"  position:relative;"
"  top:1px;"
"}"
"</style>"
"<body>"
                                 
                                  
                                 
                                  "<br /> <hr /> <br />"
                                  "<center><a href=\"ON\" class=\"myButton\">Allumer la LED</a></center>"
                                  "<br /> <hr /> <br />"
                                  "<center><a href=\"OFF\" class=\"myButton\">Eteindre la LED</a></center>"
                                  "<br /> <hr /> <br />"
                                  "<body>");
                                  /* remarque : en langage Arduino, on peut découper une chaîne longue
                                   * en plusieurs lignes en mettant des " au début et à la fin de
                                   * chaque ligne comme ce qui est fait ici
                                   */
                                 
   server.send(200, "text/html", temp); // on envoie la page.
}

void setup() {
 
 pinMode(2, OUTPUT); // on fait de la broche 2 (GPIO2) de l'ESP8266 une sortie.
  delay(1000); // délai d'une seconde.
 
  WiFi.mode(WIFI_AP);
  WiFi.softAP(ssid, password); // on démarre le point d'accès wifi avec le ssid et le mot de passe définis

  IPAddress myIP = WiFi.softAPIP(); // Pas utilisé mais montre comment on peut récupérer l'adresse IP du serveur
 
  server.on("/", handleRoot); // si le client lance une requête 192.168.4.1 on lance la fonction handleRoot
  server.on("/ON", Allumer); // si le client lance une requête 192.168.4.1/ON on lance la fonction Allumer
  server.on("/OFF", Eteindre); // si le client lance une requête 192.168.4.1/OFF on lance la fonction Etteindre

  server.begin(); // on démarre le serveur web
 
}

void loop()
{
  server.handleClient(); //on gère les clients conformément à ce qui a été défini
}

