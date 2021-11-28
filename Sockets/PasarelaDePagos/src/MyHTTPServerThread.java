
import java.lang.Exception;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static netutils.CustomNetUtils.*;

public class MyHTTPServerThread extends Thread {

    private Socket skHttp;
    private int controllerPort;
    private String controllerHostname;

    private final static String rootpath = "/home/bonnaroo/Desktop/workspace/claseSD/res/html";
    private final static String index = "/index.html";

    public MyHTTPServerThread(Socket sk_hilo, String controllerHostname, int controllerPort) {
        this.controllerHostname = controllerHostname;
        this.controllerPort = controllerPort;
        this.skHttp = sk_hilo;
    }

    @Override
    public void run() {
        BufferedReader input = null;
        String line;

        try {
            input = new BufferedReader(new InputStreamReader(skHttp.getInputStream()));
            line = input.readLine();

            // procesamos una sola peticion por hilo
            procesaPeticion(line, skHttp);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                skHttp.close();
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(MyHTTPServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void negociaRecursosDinamicos(String peticion, BufferedOutputStream dataOutput, PrintWriter webboutput) {

        Socket skControlador = null;
        String response = "";
        PrintWriter output = null;
        BufferedReader inputSkContr = null;
        InputStream isSkContr = null;
        int bytesRead;

        byte[] datos = new byte[1024 * 10];

        try {
            skControlador = new Socket(InetAddress.getByName(this.controllerHostname), this.controllerPort);
            output = new PrintWriter(skControlador.getOutputStream());
            inputSkContr = new BufferedReader(new InputStreamReader(skControlador.getInputStream()));

            System.out.println("Estoy solicitando un recurso ");

            if (startOutgoingConnection(skControlador, inputSkContr, output)) {

                output.println(peticion); // envia los datos al controlador
                System.out.println(peticion);
                output.flush();
                response = endOutgoingConnection(skControlador, inputSkContr, output);

                sleep(50);
                isSkContr = skControlador.getInputStream();
                bytesRead = isSkContr.read(datos, 0, datos.length);
                System.out.println(response);

                webboutput.println("HTTP/1.1 200 OK");
                webboutput.println("Server: Java HTTP Server 1.1");
                webboutput.println("Date: " + new Date());
                webboutput.println("Content-type: ");
                webboutput.println("Content-length: " + bytesRead);
                webboutput.println(); // blank line between headers and content
                webboutput.flush();

                dataOutput.write(datos, 0, bytesRead);
                dataOutput.flush();

            } else { // la conexion ha fallado por el protocolo
                System.out.println("Algo ha fallado en la conexion.");
            }

            isSkContr.close();
            inputSkContr.close();
            output.close();
            skControlador.close();

        } catch (ConnectException cex) {
            System.out.println("Error de conexion al controlador ");
            PrintWriter pw = new PrintWriter(dataOutput);
            pw.println("Error de conexion al controlador ");
            pw.flush();

        } catch (IOException ioex) {
            System.out.println("No se pudo abrir un canal, ¿Error de conexion (probablemente)?");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void negociaRecursosEstaticos(String request, BufferedOutputStream dataOutput, PrintWriter output) {
        File file;
        FileInputStream fileIn;
        int fileLength;
        byte[] fileData = null;

        try {

            if (request.equals("/")) {
                System.out.println();
                file = new File(rootpath, index);
            } else {
                file = new File(rootpath, request);
            }

            fileLength = (int) file.length();

            fileData = new byte[fileLength];

            fileIn = new FileInputStream(file);

            // leemos el contenido de file y se copia a fileData
            fileIn.read(fileData);
            fileIn.close();

            output.println("HTTP/1.1 200 OK");
            output.println("Server: Java HTTP Server 1.1");
            output.println("Date: " + new Date());
            output.println("Content-type: ");
            output.println("Content-length: " + file.length());
            output.println(); // blank line between headers and content
            output.flush();
            dataOutput.write(fileData, 0, fileLength); // write file
            dataOutput.flush();
        } catch (FileNotFoundException fnfex) {
            System.out.println("No se ha podido leer el fichero solicitado");
            fileNotFound(output, request);
        } catch (IOException ioex) {
            System.out.println("No se pudo escribir en el canal, ¿Error de conexion (probablemente)?");
        }
    }

    public void procesaPeticion(String peticion, Socket skHttp) {

        StringTokenizer parse = null;
        String method = "";
        String request = "";

        PrintWriter output = null;
        BufferedOutputStream dataOutput = null;

        try {
            // GET
            // /gatewaysd/auth?name=AngelFuentes&card=4000100020003000&amount=100&cvv=123&exp=0224
            // HTTP/1.1
            System.out.println(peticion);
            parse = new StringTokenizer(peticion);
            method = parse.nextToken().toUpperCase();
            request = parse.nextToken().toLowerCase();

            output = new PrintWriter(skHttp.getOutputStream());
            dataOutput = new BufferedOutputStream(skHttp.getOutputStream());

            if (method.equals("GET")) { // el metodo solicitado es Get
                if (request.contains("gatewaysd")) {

                    negociaRecursosDinamicos(request, dataOutput, output);

                } else { // RECURSO ESTATICO
                    negociaRecursosEstaticos(request, dataOutput, output);
                }
            } else {
                methodNotImplemented(output, method);
            }

            output.close();
            dataOutput.close();
            System.out.println("--Cliente Servido--");

        } catch (IOException e) {
            System.out.println("No se pudo abrir un canal con el navegador, ¿Error de conexion (probablemente)?");
        }
    }

    private void fileNotFound(PrintWriter out, String file) {
        // send file not found HTTP headers
        out.println("HTTP/1.1 404 File Not Found");
        out.println("Server: Java HTTP Server 1.0");
        out.println("Date: " + new Date());
        out.println("Content-Type: text/html");
        out.println();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>File Not Found</TITLE>" + "</HEAD>");
        out.println("<BODY>");
        out.println("<H2>404 File Not Found: " + file + "</H2>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();

        System.out.println("404 File Not Found: " + file);

    }

    private void methodNotImplemented(PrintWriter output, String method) {
        System.out.println("501 Not Implemented: " + method + " method.");
        output.println("HTTP/1.1 501 Not Implemented");
        output.println("Server: Java HTTP Server 1.0");
        output.println("Date: " + new Date());
        output.println("Content-Type: text/html");
        output.println(); // blank line between headers and content
        output.println("<HTML>");
        output.println("<HEAD><TITLE>Not Implemented</TITLE>" + "</HEAD>");
        output.println("<BODY>");
        output.println("<H2>501 Not Implemented: " + method + " method.</H2>");
        output.println("</BODY></HTML>");
        output.flush();
        System.out.println("501 Not Implemented: " + method + " method.");
    }

}
