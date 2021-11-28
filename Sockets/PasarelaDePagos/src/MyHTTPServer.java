
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyHTTPServer {

    public static void main(String[] args) {
        int port;
        ServerSocket serversocket;
        MyHTTPServer sr;
        Socket incRequestSocket = null;

        sr = new MyHTTPServer();
        port = sr.solicitaPuerto();

        int controllerPort;
        String controllerHostname;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es la direccion de controlador?");
        controllerHostname=sc.nextLine();
        //controllerHostname = "127.0.0.1";
        System.out.println("¿En que puerto esta escuchando?");
        controllerPort= sc.nextInt();
        //controllerPort = 2002;



        try {
            serversocket = new ServerSocket(port);

            while (true) {
                System.out.println("Escuchando en el puerto " + port);
                incRequestSocket = serversocket.accept();
                System.out.println("Sirviendo Cliente...");
                Thread t;
                t = new MyHTTPServerThread(incRequestSocket, controllerHostname, controllerPort);
                t.start();
                // a partir de aqui debe ser concurrente

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            sc.close();
        }
    }

    public int solicitaPuerto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzco el puerto de escucha del servidor");
        int puerto=sc.nextInt();
        //int puerto = 2000;
        return puerto;
    }

}
