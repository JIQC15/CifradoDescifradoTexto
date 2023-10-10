package Cifrados;

import java.util.ArrayList;
import java.util.List;

public class Secuencial {

    // Atributos
    private String mensajeCifrado;
    private int clave;
    private String mensajeDescifrado;

    // Constructor
    public Secuencial(String mensajeCifrado, int clave) {
        //Cifrado
        this.mensajeCifrado = mensajeCifrado;
        this.clave = clave;

        //Descifrado
        this.mensajeDescifrado = mensajeDescifrado;
    }

    // Metodos
    public void cifrar() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char caracter = mensajeCifrado.charAt(i);
            if (Character.isLetter(caracter)) {
                boolean esMayuscula = Character.isUpperCase(caracter);
                char letraCifrada = (char) (caracter + clave);

                if (esMayuscula) {
                    if (letraCifrada > 'Z') {
                        letraCifrada = (char) ('A' + (letraCifrada - 'Z' - 1));
                    }
                } else {
                    if (letraCifrada > 'z') {
                        letraCifrada = (char) ('a' + (letraCifrada - 'z' - 1));
                    }
                }

                resultado.append(letraCifrada);
            } else {
                resultado.append(caracter);
            }
        }
        mensajeCifrado = resultado.toString();
    }

    public void descifrar() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensajeDescifrado.length(); i++) {
            char caracter = mensajeDescifrado.charAt(i);
            if (Character.isLetter(caracter)) {
                boolean esMayuscula = Character.isUpperCase(caracter);
                char letraDescifrada = (char) (caracter - clave);
                if ((esMayuscula && letraDescifrada < 'A') || (!esMayuscula && letraDescifrada < 'a')) {
                    letraDescifrada += 26;
                }
                resultado.append(letraDescifrada);
            } else {
                resultado.append(caracter);
            }
        }
        mensajeDescifrado = resultado.toString();
    }

    public String getPalabraCifrada() {
        return mensajeCifrado;
    }

    public String getPalabraDescifrada() {
        return mensajeDescifrado;
    }

    public static void main(String[] args) {
        String mensajeOriginal = "ÑÑÑÑ";
        //String mensajeCifrado = "MTPF";
        int claveCifrado = 5;

        //Descifrado
        Secuencial cesarSecuencial = new Secuencial(mensajeOriginal, claveCifrado);

        //Cifrado
        //Secuencial cesarSecuencial = new Secuencial(mensajeCifrado, claveCifrado);
        // Cifrar el mensaje
        cesarSecuencial.cifrar();
        //Descifrar el mensaje
        //cesarSecuencial.descifrar();
        
        System.out.println("Mensaje Original: " + mensajeOriginal);
        System.out.println("Mensaje cifrado: " + cesarSecuencial.getPalabraCifrada());
        //System.out.println("Mensaje Cifrado: " + mensajeCifrado);
        //System.out.println("Mensaje descifrado: " + cesarSecuencial.getPalabraDescifrada());
    }
}
