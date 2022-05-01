import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.Date;

public class Practica{
    static String txt = " ";
    static String[] parts = txt.split(" ");
    static int contParts = parts.length;
    
    // Método para validar caracteres
    public static void caracteres(String texto) throws FileNotFoundException {
        String linea = "";
        int bandera = 0;
        File archivo = new File("letras1.txt");
        Scanner in = new Scanner(archivo);
        
        //Analiza fichero
        while (in.hasNextLine()) {
            linea = in.nextLine();
            //System.out.println(linea);
        }
        //Compara texto con fichero                         
        for (int i = 0; i < (texto.length() - 1); i++) {
            bandera = 0;
            for (int j = 0; j < (linea.length() - 1); j++) {
                //System.out.println(texto.charAt(i));
                if (linea.charAt(j) == texto.charAt(i)) {
                    bandera = 1;
                    break;
                }
            }

            if (bandera == 0) {
                break;
            }
        }
        if (bandera == 1) {System.out.println("\n---Primer filtro: Caracteres aceptados---");} 
        else {System.out.println("\n---Primer filtro: Hay caracteres raros---");}
        in.close();
    }

    // Método para validar comandos
    public static void comandos(String comando) throws FileNotFoundException{
        String[] partes = comando.split(" ");
        //int contPartes = partes.length;
        int band = 0;
        String[] linea2 = new String[7];
        int cont = 0;
        int cont2 = 0;
        File archivo2 = new File("palabras.txt");
        Scanner in3 = new Scanner(archivo2);
        //System.out.println(parts[0]);
        while (in3.hasNextLine()) {
            linea2[cont] = in3.nextLine();
            cont++;
        }
        for (int x = 0; x < 7; x++) {
            band = 0;
            //System.out.println(linea2[x]);
            cont2++;
            if (linea2[x].equals(partes[0])) {
                band = 1;
                break;
            }
        }
        if (band == 1) {System.out.println("--Segundo filtro: El comando existe en el diccionario---\n");
            switch(partes[0]){
                case "saludar":
                    System.out.println("hola " + partes[1] + "\n");
                    break;

                case "despedir":
                    System.out.println("bye " + partes[1] + "\n");
                    break;

                case "llamar":
                    System.out.println("*Llamando a " + partes[1] + "*" + "\n");
                    break;

                case "ver":
                    System.out.println("*Videollamando a " + partes[1] + "*" + "\n");
                    break;
                case "fecha":
                    fecha();
                    break;
                case "sumar":
                    sumar(comando);
                    break;    
            }//switch
        } else if(partes[0].equals("enviar") && partes[1].equals("correo")){
            System.out.println("--Segundo filtro: El comando existe en el diccionario---\n");
            if(partes[2].equals(" ")){
                System.out.println("No se ha ingresado un correo");
            }else{
                //correo(partes[2]);
                System.out.println(correo(partes[2]));
            }
            
        }
            else {System.out.println("--Segundo filtro: El comando no existe en el diccionario---");}       
            in3.close();
    }

    public static void fecha(){
        Date objDate = new Date();
        System.out.println("La fecha es: " + objDate.toString());
    }

    public static void sumar(String numeros){
        String[] partes1 = numeros.split(" ");
        int contPartes1 = partes1.length;
        char[] listNums = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        int suma = 0;
        int bandera = 0;
        // validar numeros
        for (int i = 1; i < contPartes1; i++) { // Numeros
            // System.out.println("Parte: " + parts[i]);
            for (int j = 0; j < partes1[i].length(); j++) { // Digitos
                bandera = 0;
                // System.out.println("Digito: " + parts[i].charAt(j));
                for (int k = 0; k < 10; k++) { // Arreglo char de numeros
                    // System.out.println(listNums[k]);
                    if (partes1[i].charAt(j) == listNums[k]) {
                        bandera = 1;
                        break;
                    }
                }
            }
            if (bandera == 1) {
                // System.out.println("Sumar " + parts[i]);
                suma += Integer.parseInt(partes1[i]);
            } else {
                break;
            }

        }
        System.out.println("El resultado es: " + suma);
        // String[] numeros = new String[contParts];
    }

    public static String correo (String email){
        /*enviar correo correo@gmail.com Asunto blablabla Cuerpo */
         String[] userEmail = email.split("@");
         boolean adress = false;
         String dir = "";
         for(int i = 0; i < userEmail.length; i++){
             System.out.println(userEmail[i]);
         }
         if(userEmail[0].equals(" ") || userEmail[1].equals(" ")){
             System.out.println("El correo no está completo");
         }
         if (userEmail[1].equals("gmail.com")) {
            adress = true;
            dir = userEmail[0] + "@" + userEmail[1];
            System.out.println(dir);
            //System.out.println(adress);
            
        }
         return dir;
    }
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Escribe: ");
        txt = in.nextLine();

        caracteres(txt);
        comandos(txt);
        in.close();

    }
}