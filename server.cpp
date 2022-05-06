/*
 * server.c:
 *	Server wich listens for get request and switch the state of rpi gpio depending on theses requests.
 *
 * Copyright (c) 2022 Anyn0ne.
 ***********************************************************************
 */

#include <stdio.h>
#include <wiringPi.h>
#include "cpp-httplib/httplib.h"

#define CPPHTTPLIB_OPENSSL_SUPPORT

#define	UP	4
#define DOWN	5
int main (void)
{
  printf ("Raspberry Pi blink\n") ;

  wiringPiSetup () ;
  pinMode (UP, OUTPUT) ;
  pinMode(DOWN, OUTPUT);
/*  */
  httplib::Server svr;
//httplib::SSLServer svr;

svr.Get("/up", [](const httplib::Request &, httplib::Response &res) {
  res.set_content("OK", "text/plain");
    digitalWrite(DOWN, LOW);
    digitalWrite (UP, HIGH) ;	// On
    delay (100) ;		// mS
    digitalWrite (UP, LOW) ;	// Off
    delay (100) ;
});
svr.Get("/down", [](const httplib::Request &, httplib::Response &res) {
  res.set_content("Hello World!", "text/plain");


    digitalWrite(UP, LOW);
    digitalWrite (DOWN, HIGH) ;	// On
    delay (100) ;		// mS
    digitalWrite (DOWN, LOW) ;	// Off
    delay (100) ;

});


svr.listen("0.0.0.0", 8080);

  return 0 ;
}
