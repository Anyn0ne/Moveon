# Moveon

Moveon is a simple application that allows you to control your blinds remotely. To use the application, you must compile and run the supplied c++ server on a raspberry pi. You also need to solder transistors on the remote control of your blinds. This project is still experimental, if you want to make your contribution, you are welcome! Have fun!

## Security

Moveon does not currently offer an authentication system, which is why it is imperative to deploy the server only locally. Authentication will be done in a future release.

## Adapting the code

You can change gpio you want to use in server.cpp

## Compiling the server 

Make sur you compile the server with theses libs : threads, wiring pi and cpp-httplib

## /!\ BREAKING OF WARRANTY

I AM IN NO CASE RESPONSIBLE IF YOU BREAK THE WARRANTY OF YOUR BLINDS BY ADDING MODIFICATIONS TO THEM

I juste hope this tiny app will help ;)
