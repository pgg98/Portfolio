package netutils;

import java.io.*;
import java.net.*;

public final class CustomNetUtils {

    public static final String STX = "STX";
    public static final String ETX = "ETX";
    public static final String ACK = "ACK";
    public static final String NACK = "NACK";
    public static final String ENQ = "ENQ";
    public static final String EOT = "EOT";

    public static final String CODOP_GET = "0";
    public static final String CODOP_SET = "1";
    public static final String CODOP_AUTH = "2";

    // Ejemplo Utility method

    public static boolean startOutgoingConnection(Socket destiny, BufferedReader input, PrintWriter output) {

        String currResponse;

        try {
            output = new PrintWriter(destiny.getOutputStream(), true);
            output.println(ENQ);
            System.out.println("sOC/" + ENQ);
            output.flush();

            currResponse = input.readLine();

            if (!currResponse.equals(ACK)) {
                output.println(EOT);
                System.out.println("sOC/" + EOT);
                return false;
            } else {

                output.println(STX);
                output.flush();
                System.out.println("sOC/" + STX);
            }
        } catch (IOException ex) {
            return false;
        }

        return true;
    }

    public static boolean startIncomingConnection(Socket petitionSocket, BufferedReader input, PrintWriter output) {

        String currResponse;

        try {
            currResponse = input.readLine();
            if (!currResponse.equals(ENQ)) {
                output.println(NACK);
                output.flush();
                System.out.println("sIC/" + NACK);
                return false;
            } else {
                output.println(ACK);
                output.flush();
                System.out.println("sIC/" + ACK);
            }

            currResponse = input.readLine();
            if (!currResponse.equals(STX)) {
                output.println(EOT);
                output.flush();
                System.out.println("sIC/" + EOT);
                return false;
            }

        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public static String endOutgoingConnection(Socket destiny, BufferedReader input, PrintWriter output) {

        String response = "";
        String auxres = "";
        try {
            response = input.readLine(); // STX
            System.out.println(response);
            response = input.readLine();
            System.out.println(response);
            if (!response.equals("")) {

                output.println(ACK);
                output.flush();
                output.println(EOT);
                output.flush();
                System.out.println("eOC" + ACK);
                System.out.println("eOC" + EOT);
                // auxres = input.readLine();
            } else {

                output.println(NACK);
                output.flush();
                System.out.println("eOC" + response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public static boolean endIncomingConnection(Socket petitionSocket, BufferedReader input, PrintWriter output,
            String response) {

        try {
            int cont = 0;
            String currResponse;

            output.println(response);
            System.out.println("eIC" + response);
            output.flush();
            currResponse = input.readLine();
            currResponse = input.readLine();
            // output.println(EOT);
            System.out.println("eIC" + EOT);
            // output.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}