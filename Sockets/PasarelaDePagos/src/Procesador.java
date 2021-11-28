
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import static netutils.CustomNetUtils.*;

public class Procesador {

    private ServerSocket server;
    private int port;

    private final static String rootpath = "/home/bonnaroo/Desktop/workspace/claseSD/res/";
    private String configFileName = "txt/Config.txt";
    private String tempFileName = "txt/temp.txt";

    public Procesador() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el puerto de escucha");
        port = sc.nextInt();

        try {
            server = new ServerSocket(port);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        sc.close();

        run();
    }

    // Respuesta: Aceptada. Código de Autorización:0010. 10-02-2020. 10€
    private String montaRespuestaPago(boolean paymentState, int amount) {
        String response;

        String state, code, date, cause;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        if (paymentState) {
            state = "OK";
            code = String.valueOf((int) Math.random() * 100);
            LocalDateTime now = LocalDateTime.now();
            date = dtf.format(now);
            response = state + "#" + code + "#" + date + "#" + amount;

        } else {
            state = "KO";
            cause = "You don't fulfil the requirements.";
            response = state + "#" + cause;
        }

        return response;
    }

    private String processPayment(int amount) {

        boolean paymentState = false;
        String response = "";
        File file;
        Scanner reader;
        int floor, upper;
        String paymentStateline;

        try {

            file = new File(rootpath + configFileName);
            reader = new Scanner(file);
            reader.nextLine();
            paymentStateline = reader.nextLine();
            System.out.println(paymentStateline);

            if (paymentStateline.split("=")[1].equals("ON") || paymentStateline.split("=")[1].equals("on")) {

                floor = Integer.parseInt(reader.nextLine().split("=")[1]);

                upper = Integer.parseInt(reader.nextLine().split("=")[1]);

                if (amount >= floor && amount <= upper)
                    paymentState = true;
                else
                    paymentState = false;

            } else { // la estacion esta fuera de servicio
                paymentState = false;
            }
            reader.close();

            System.out.println("Montando respuesta de pago...");

            response = montaRespuestaPago(paymentState, amount);

            response = CODOP_AUTH + "#" + response;

        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido leer el fichero solicitado");
        }

        return response;
    }

    private String setResource(String resource, String newValue) {
        String response = "";
        String line;

        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;

        File file;
        File newFile;
        Scanner reader;

        switch (resource) {
            case "status":
                resource = "Estado";
                break;
            case "fl":
                resource = "Floor";
                break;
            case "ul":
                resource = "Upper";
                break;
        }

        try {
            fw = new FileWriter(rootpath + tempFileName);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            file = new File(rootpath + configFileName);
            newFile = new File(rootpath + tempFileName);
            reader = new Scanner(file);

            String item;
            while (reader.hasNextLine()) {
                item = reader.nextLine();
                if (item.contains(resource)) {
                    pw.println(resource + "=" + newValue);
                } else {
                    pw.println(item);
                }
            }

            pw.flush();
            pw.close();
            reader.close();
            file.delete();
            File dump = new File(rootpath + configFileName);
            newFile.renameTo(dump);

            response = "SETOK#" + newValue;
            response = CODOP_SET + "#" + response;

        } catch (Exception e) {
            response = "SETKO";
        }

        return response;
    }

    private String getResource(String resource) {
        String response = "";
        String line;
        File file;
        Scanner reader;

        switch (resource) {
            case "status":
                resource = "Estado";
                break;
            case "fl":
                resource = "Floor";
                break;
            case "ul":
                resource = "Upper";
                break;
        }

        try {

            file = new File(rootpath + configFileName);
            reader = new Scanner(file);
            line = reader.nextLine();
            while (!line.contains(resource)) {
                line = reader.nextLine();
            }

            response = line.split("=")[1];

            reader.close();

            response = CODOP_GET + "#" + response;

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el fichero de configuracion");
        }

        return response;
    }

    private String  tramitaPeticion(BufferedReader input, PrintWriter output) {

        char currResponse;
        String respuesta = "";
        String request = "";
        String resource;
        String newValue;
        int amount;

        String[] requestTokens;

        System.out.println("Tramitando");

        try {
            request = input.readLine();
            System.out.println(request);

            if (request != "") {

                output.println(ACK);
                output.flush();

                System.out.println("Request " + ACK);

                requestTokens = request.split("#");

                if (requestTokens[0].equals(CODOP_AUTH)) { // solicitud de pago
                    amount = Integer.parseInt(requestTokens[3]);
                    respuesta = processPayment(amount);

                } else { // otras solicitudes
                    resource = requestTokens[1];

                    if (requestTokens[0].equals(CODOP_SET)) {
                        newValue = requestTokens[2];
                        respuesta = setResource(resource, newValue);

                    } else if (requestTokens[0].equals(CODOP_GET)) {
                        respuesta = getResource(resource);
                    }
                }

            } else {
                output.println(NACK);
                output.flush();
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer o escribir del canal, ¿Error de conexion (probablemente)?");
        }

        return respuesta;
    }

    public void run() {

        Socket petitionSocket;
        String respuesta;
        BufferedReader input = null;
        PrintWriter output = null;

        System.out.println("Estoy escuchando en el puerto " + port);
        System.out.println("Esperando solicitudes de recurso dinámico");
        try {
            while (true) {
                petitionSocket = server.accept();
                System.out.println("Sirviendo al Controlador...");
                try {

                    input = new BufferedReader(new InputStreamReader(petitionSocket.getInputStream()));
                    output = new PrintWriter(petitionSocket.getOutputStream());

                    if (startIncomingConnection(petitionSocket, input, output)) {
                        respuesta = tramitaPeticion(input, output);
                        endIncomingConnection(petitionSocket, input, output, respuesta);
                    }

                    System.out.println("--Controlador Servido--");
                } catch (IOException ex) {
                    System.out.println("No se pudo abrir un canal, ¿Error de conexion (probablemente)?");
                } finally {

                }
                output.close();
                input.close();
                petitionSocket.close();
            }



        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Procesador p = new Procesador();
    }

}
