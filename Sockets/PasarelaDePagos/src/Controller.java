import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static netutils.CustomNetUtils.*;

public class Controller {

    // http://127.0.0.1:2000/controladorsd/auth?name=AngelFuentes&card=4000100020003000&amount=10&cvv=123&exp=0224

    private HashMap<Integer, Integer> binesDict;
    private HashMap<String, String> procesadoresDict;

    private final static int kMINTOKENS = 3;
    private final static int kMINREQUEST = 1;

    private final static String rootpath = "/home/bonnaroo/Desktop/workspace/claseSD/res/";
    private String bineFileName = "txt/Bines.txt";
    private String procFileName = "txt/Procesadores.txt";
    private String responseFileName = "html/respuesta.html";

    private String lastResource;
    private String lastSource;

    private int port;
    private ServerSocket serversocket;

    public Controller() {

        binesDict = new HashMap<Integer, Integer>();
        procesadoresDict = new HashMap<String, String>();

        obtieneBines();
        obtieneProcesadores();

        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el puerto de escucha");
        this.port = sc.nextInt();
        sc.close();

        try {
            serversocket = new ServerSocket(port);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        run();

    }

    private void obtieneBines() {
        Integer key, value;

        File binFile;
        Scanner reader = null;
        String data;
        String[] parts;

        try {
            binFile = new File(rootpath + bineFileName);
            reader = new Scanner(binFile);

            while (reader.hasNextLine()) {
                data = reader.nextLine();
                parts = data.split("#");
                key = Integer.parseInt(parts[0]);
                value = Integer.parseInt(parts[1]);
                binesDict.put(key, value);
            }
        } catch (FileNotFoundException e) {
            System.out.println(rootpath + bineFileName + "not found.");
        }finally{
            reader.close();
        }
    }

    private void obtieneProcesadores() {
        String key, value, data;
        String[] parts;

        File binFile;
        Scanner reader = null;

        try {
            binFile = new File(rootpath + procFileName);
            reader = new Scanner(binFile);

            while (reader.hasNextLine()) {

                data = reader.nextLine();
                System.out.println(data);
                parts = data.split("#");
                key = parts[0];
                value = parts[1] + ":" + parts[2];
                procesadoresDict.put(key, value);
            }
        } catch (FileNotFoundException e) {
            System.out.println(rootpath + procFileName + "not found.");
        }finally{
            reader.close();
        }
    }

    private String[] procesaPeticionHttp(BufferedReader input, PrintWriter output) {

        char currResponse;

        int ntokens;

        String[] requestAnswer = null;
        String request = "";
        String name, card, amount, cvv, exp;
        String procid, value;
        String codop;
        String[] requestTokens, auxBuffer;
        String notifiedResource;
        String reqResourceName;
        String reqData;

        System.out.println("CONECTADO AL SERVIDOR HTTP");
        try {
            request = input.readLine();

        } catch (IOException ex) {
            System.out.println("No se pudo leer del canal, ¿Error de conexion (probablemente)?");
        }
        System.out.println(request);

        requestTokens = request.split("/");

        ntokens = requestTokens.length;

        if (ntokens < kMINTOKENS) {
            requestAnswer = new String[1];
            requestAnswer[0] = "La URL introducida no es valida.";
            return requestAnswer;
        }

        notifiedResource = requestTokens[2];

        System.out.println(notifiedResource);
        // Ej.:http://IP:Puerto/gatewaySD/
        //auth ? name=AngelFuentes&card=4000100020003000&amount=10&cvv=123&exp=0224
        // Respuesta: Aceptada. Código de Autorización:0010. 10-02-2020. 10€

        // /controladorsd/temperatura?station=2

        requestTokens = notifiedResource.split("\\?");

        reqResourceName = requestTokens[0];

        ntokens = requestTokens.length;

        if (ntokens <= kMINREQUEST) {
            requestAnswer = new String[1];
            requestAnswer[0] = "La URL introducida no es valida.";
            return requestAnswer;
        }

        // el formateo de la peticion es distinto entre autorizaciones de pago y el
        // resto de recursos

        if (reqResourceName.equals("auth")) {
            codop = CODOP_AUTH;
            reqData = requestTokens[1];
            requestTokens = reqData.split("&");

            ntokens = requestTokens.length;

            if (ntokens <= kMINREQUEST) {
                requestAnswer = new String[1];
                requestAnswer[0] = "La URL introducida para el recurso auth no es valida.";
                return requestAnswer;
            }    

            
            auxBuffer = requestTokens[0].split("=");

            ntokens = auxBuffer.length;

            if (ntokens <= kMINREQUEST) {
                requestAnswer = new String[1];
                requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                return requestAnswer;
            }    

            name = auxBuffer[1];
            auxBuffer = requestTokens[1].split("=");
            ntokens = auxBuffer.length;

            if (ntokens <= kMINREQUEST) {
                requestAnswer = new String[1];
                requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                return requestAnswer;
            }    

            card = auxBuffer[1];
            auxBuffer = requestTokens[2].split("=");
            ntokens = auxBuffer.length;

            if (ntokens <= kMINREQUEST) {
                requestAnswer = new String[1];
                requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                return requestAnswer;
            }    

            amount = auxBuffer[1];
            auxBuffer = requestTokens[3].split("=");
            ntokens = auxBuffer.length;

            if (ntokens <= kMINREQUEST) {
                requestAnswer = new String[1];
                requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                return requestAnswer;
            }    

            cvv = auxBuffer[1];
            auxBuffer = requestTokens[4].split("=");
            ntokens = auxBuffer.length;

            if (ntokens <= kMINREQUEST) {
                requestAnswer = new String[1];
                requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                return requestAnswer;
            }    

            exp = auxBuffer[1];

            // requestAnswer = solicitaRecurso(codop, name, card, amount, cvv, exp);
            requestAnswer = new String[6];
            requestAnswer[0] = codop;
            requestAnswer[1] = name;
            requestAnswer[2] = card;
            requestAnswer[3] = amount;
            requestAnswer[4] = cvv;
            requestAnswer[5] = exp;

        } else if (reqResourceName.equals("status") || reqResourceName.equals("fl") || reqResourceName.equals("ul")) {

            reqData = requestTokens[1];
            requestTokens = reqData.split("&");

            if (requestTokens.length < 2) { // getter Ej.: http://IP:Puerto/gatewaySD/fl?proc=1
                codop = CODOP_GET;
                auxBuffer = requestTokens[0].split("=");

                ntokens = auxBuffer.length;

                if (ntokens <= kMINREQUEST) {
                    requestAnswer = new String[1];
                    requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                    return requestAnswer;
                }    

                procid = auxBuffer[1];
                requestAnswer = new String[3];
                requestAnswer[0] = codop;
                requestAnswer[1] = procid;
                requestAnswer[2] = reqResourceName;
                // requestAnswer = solicitaRecurso(codop, procid, reqResourceName);

            } else { // setter Ej.: http://IP:Puerto/gatewaySD/fl?proc=1&set=20

                codop = CODOP_SET;
                auxBuffer = requestTokens[0].split("=");
                ntokens = auxBuffer.length;

                if (ntokens <= kMINREQUEST) {
                    requestAnswer = new String[1];
                    requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                    return requestAnswer;
                }    

                procid = auxBuffer[1];
                auxBuffer = requestTokens[1].split("=");
                ntokens = auxBuffer.length;

                if (ntokens <= kMINREQUEST) {
                    requestAnswer = new String[1];
                    requestAnswer[0] = "Faltan parametros a la derecha del igual.";
                    return requestAnswer;
                }    

                value = auxBuffer[1];
                // requestAnswer = solicitaRecurso(codop, procid, reqResourceName, value);
                requestAnswer = new String[4];
                requestAnswer[0] = codop;
                requestAnswer[1] = procid;
                requestAnswer[2] = reqResourceName;
                requestAnswer[3] = value;
            }

        } else { // el recurso solicitado no existe
            requestAnswer = new String[1];
            requestAnswer[0] = reqResourceName + " no es una variable valida.";
        }

        return requestAnswer;

    }

    public String solicitaRecurso(String... args) {

        String response = "";
        String codop = args[0];
        String procid;
        Integer processorId;
        Integer firstNumOfCard;
        String processorAddress;
        String petition = "";
        String name, card, amount, cvv, exp, resource, value;
        Socket skProcesador = null;
        PrintWriter output = null;
        BufferedReader input = null;

        try {

            if (codop.equals(CODOP_AUTH)) {
                card = args[2];
                firstNumOfCard = Integer.parseInt(String.valueOf(card.charAt(0)));
                processorId = binesDict.get(firstNumOfCard);
                processorAddress = procesadoresDict.get(String.valueOf(processorId));
            } else {
                procid = args[1];
                processorAddress = procesadoresDict.get(procid);
                if (processorAddress == null) {
                    return "El numero de procesador solicitado no existe.";
                }
            }

            skProcesador = new Socket(InetAddress.getByName(processorAddress.split(":")[0]),
                    Integer.parseInt(processorAddress.split(":")[1]));

            output = new PrintWriter(skProcesador.getOutputStream());
            input = new BufferedReader(new InputStreamReader(skProcesador.getInputStream()));

            if (startOutgoingConnection(skProcesador, input, output)) {
                // monta peticion
                petition = montaPeticion(codop, processorAddress, args);
                output.println(petition);
                output.flush();
                response = endOutgoingConnection(skProcesador, input, output);

            } else { // fallo en la conexion con el procesador
                response = "No pudo conectarse al procesador solicitado.";
            }

            input.close();
            output.close();
            skProcesador.close();

        } catch (ConnectException ex) {
            return "El procesador existe pero no esta activo.";

        } catch (IOException ex) {
            System.out.println("No se pudo abrir un canal, ¿Error de conexion (probablemente)?");
        }
        return response;
    }

    private String montaPeticion(String codop, String processorAddress, String... args){
        String peticion = "";
        String name, card, amount, cvv, exp, resource, value;

        if (codop.equals(CODOP_AUTH)) {
            name = args[1];
            card = args[2];
            amount = args[3];
            cvv = args[4];
            exp = args[5];
            peticion = codop + "#" + name + "#" + card + "#" + amount + "#" + cvv + "#" + exp;
            this.lastResource = "Solicitud de pago";
            this.lastSource = processorAddress;
        } else if (codop.equals(CODOP_GET)) {
            resource = args[2];
            peticion = codop + "#" + resource;
            this.lastResource = resource;
            this.lastSource =    processorAddress;
        } else if (codop.equals(CODOP_SET)) {
            resource = args[2];
            value = args[3];
            peticion = codop + "#" + resource + "#" + value;
            this.lastResource = resource;
            this.lastSource = processorAddress;
        }

        return peticion;
    }

    private void escribeFicheroHTML(String response, BufferedOutputStream dataOutput) {

        System.out.println("Escribiendo respuesta HTML.... ");
        String oldFileName = rootpath + responseFileName;
        BufferedWriter bw = null;
        String[] parts;

        String setStatus = "";
        String paymentStatus = "";
        String contenido = "";
        String id = "";
        String date = "";
        String amount = "";

        parts = response.split("#");

        switch (parts[0]) {
            case "0":
                contenido = parts[1];
                break;

            case "1":
                contenido = parts[2];
                setStatus = parts[1];
                break;
            case "2":
                paymentStatus = parts[1];
                id = parts[2];
                date = parts[3];
                amount = parts[4];
                break;
            default:
                contenido = parts[0];

        }

        try {
            bw = new BufferedWriter(new FileWriter(oldFileName));
            // bw.write("<h3>Resource " + "=" + response + "</h3>" + "\n");

            bw.write("<html>" + "\n");
            bw.write("<head>" + "\n");

            bw.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
            bw.write("<title>Dynamic Resource</title>");
            bw.write("</head>");
            bw.write("<body>" + "\n");
            bw.write("<div class=\"jumbotron\" style=\"text-align:center;\">");
            bw.write("<h1>Procesador: " + this.lastSource + "</h1>" + "\n");
            bw.write("<h3>Recurso solicitado: " + this.lastResource + "</h3>" + "\n");
            if (setStatus != "") {
                bw.write("<h3>Estado de operacion SET: " + setStatus + "</h3>" + "\n");
                bw.write("<h3>Nuevo valor: " + contenido + "</h3>" + "\n");

            } else if (paymentStatus != "") {
                bw.write("<h3>Estado de pago: " + paymentStatus + "</h3>" + "\n");
                if (!paymentStatus.equals("KO")) {
                    bw.write("<h3>ID de transaccion: " + id + "</h3>" + "\n");
                    bw.write("<h3>Fecha: " + date + "</h3>" + "\n");
                    bw.write("<h3>Cantidad: " + amount + "</h3>" + "\n");
                }
            } else {
                bw.write("<h3>Valor de respuesta: " + contenido + "</h3>" + "\n");
            }
            bw.write("</div>");
            bw.write(
                    "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
            bw.write("</body></html>" + "\n");

            bw.flush();
            bw.close();

            File file;
            file = new File(rootpath, responseFileName);

            int fileLength = (int) file.length();
            FileInputStream fileIn;
            byte[] fileData = new byte[fileLength];
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
            fileIn.close();
            
            dataOutput.write(fileData, 0, fileLength); // write file
            dataOutput.flush();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

    }

    public void run() {
        try {

            String[] petitionParams;
            String response = "";
            String codop;

            BufferedOutputStream dataOutput = null;
            BufferedReader input = null;
            PrintWriter output = null;
            Socket petitionSocket = null;

            System.out.println("Estoy escuchando en el puerto " + port);
            System.out.println("Esperando solicitudes de recurso dinámico");

            while (true) {

                petitionSocket = serversocket.accept();
                System.out.println("Sirviendo Cliente...");

                try {

                    input = new BufferedReader(new InputStreamReader(petitionSocket.getInputStream()));
                    output = new PrintWriter(petitionSocket.getOutputStream());
                    dataOutput = new BufferedOutputStream(petitionSocket.getOutputStream());

                    System.out.println("NEGOCIANDO");

                    if (startIncomingConnection(petitionSocket, input, output)) {
                        petitionParams = procesaPeticionHttp(input, output);

                        if(petitionParams.length > 1){
                            response = solicitaRecurso(petitionParams);
                        }else{
                            response = petitionParams[0];
                        }

                        output.println(ACK);
                        output.flush();
                        endIncomingConnection(petitionSocket, input, output, response);
                        // parametros = procesaRespuesta(response);
                        dataOutput.flush();
                        // escribeFicheroHTML(parametros);
                        escribeFicheroHTML(response, dataOutput);
                    }

                    System.out.println("Respuesta: " + response);

                } catch (IOException ioex) {
                    System.out.println("No se pudo abrir un canal, ¿Error de conexion (probablemente)?");
                } finally {
                    dataOutput.close();
                    input.close();
                    output.close();
                    petitionSocket.close();
                    System.out.println("--HTTPServer Servido--");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }
}
