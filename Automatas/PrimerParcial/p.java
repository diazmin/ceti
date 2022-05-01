/*Diana Yazmin Camacho Vázquez
17310046 - 4M - Teoría de Autómatas - Desarrollo de software

Este programa contiene todas las prácticas juntas:
1. Analiza el texto ingresado por el usuario y define que no existan caracteres raros, además de afirmar si existe 
en el diccionario
2. Analiza si el comando existe en el diccionario, para así imprimir en pantalla una acción + el nombre de la persona
3. Comando fecha, que al ingresarse se imprime en pantalla la fecha del día actual
4. Comando sumar, se ingresa junto con los números que se deseen sumar separados por espacios, para después el programa
imprima el resultado.
5. Comando enviar correo, seguido del correo del destinatario + el asunto + el cuerpo del mensaje que se desea enviar.*/
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Date;


public class p {
    static String txt = " ";
    //static String[] parts = txt.split(" ");
    //static int contParts = parts.length;
    
    // Método para validar caracteres
    public static void caracteres(String texto) throws FileNotFoundException{
        String linea = "";
        int bandera = 0;
        File archivo = new File("letras1.txt");
        Scanner in = new Scanner(archivo);
        
        try {
            // Analiza fichero
            while (in.hasNextLine()) {
                linea = in.nextLine();
                //System.out.println(linea);
            }
            // Compara texto con fichero
            for (int i = 0; i < (texto.length() - 1); i++) {
                bandera = 0;
                for (int j = 0; j < (linea.length() - 1); j++) {
                    // System.out.println(texto.charAt(i));
                    if (linea.charAt(j) == texto.charAt(i)) {
                        bandera = 1;
                        break;
                    }
                }

                if (bandera == 0) {
                    break;
                }
            }
            if (bandera == 1) {
                System.out.println("\n---Primer filtro: Caracteres aceptados---");}
                 else {System.out.println("\n---Primer filtro: Hay caracteres raros---");}

        }//catch (FileNotFoundException e) {System.out.println("No se encontró el archivo .txt");}
         catch (ArrayIndexOutOfBoundsException ex) {System.out.println("Comandos insuficientes\n");}      
        in.close();
    }

    // Método para validar comandos
    public static void comandos(String comando) throws FileNotFoundException{
        String[] partes = comando.split(" ");
        int contPartes = partes.length;
        int band = 0;
        String[] linea2 = new String[7];
        int cont = 0;
        int cont2 = 0;
        File archivo2 = new File("palabras.txt");
        Scanner in3 = new Scanner(archivo2);
        try{
            // System.out.println(parts[0]);
        while (in3.hasNextLine()) {
            linea2[cont] = in3.nextLine();
            cont++;
        }
        for (int x = 0; x < 7; x++) {
            band = 0;
            // System.out.println(linea2[x]);
            cont2++;
            if (linea2[x].equals(partes[0])) {
                band = 1;
                break;
            }
        }
        if (band == 1) {
            System.out.println("--Segundo filtro: El comando existe en el diccionario---\n");
            switch (partes[0]) {
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
            }// switch
        } else if (partes[0].equals("enviar") && partes[1].equals("correo")) {
            System.out.println("--Segundo filtro: El comando existe en el diccionario---\n");
            System.out.println("El correo es: " + correo(partes[2])); //correo

            //Asunto
            String asunto = "";
            String cuerpo = "";
            int bandera = 0;
            int i = 0;
            for(i = 3; i < contPartes; i++){
                bandera = 0;
                    if (partes[i].equals("cuerpo:")) {
                        bandera = 1;
                        break;
                    }else{
                        asunto += partes[i] + " ";
                    }  
            }
            
            if(bandera == 1){
                for(int j = (i + 1); j < contPartes; j++){
                    cuerpo += partes[j] + " ";
                }
            }
            System.out.println("El asunto es: " + asunto);
            System.out.println("El cuerpo es: " + cuerpo);
            
            //enviarConGMail(correo(partes[2]), asunto, cuerpo);

        } else {
            System.out.println("--Segundo filtro: El comando no existe en el diccionario---");
        }
        }//catch (FileNotFoundException e) {System.out.println("No se encontró el archivo .txt");} 
        catch (ArrayIndexOutOfBoundsException ex) {System.out.println("Comandos insuficientes\n");}
        
        in3.close();
    }
    
    // public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {

    // // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el
    // // remitente también.
    // String remitente = "dianayazminlove"; // Para la dirección nomcuenta@gmail.com

    // Properties props = System.getProperties();props.put("mail.smtp.host","smtp.gmail.com"); // El servidor SMTP de
    //                                                                                         // Google
    // props.put("mail.smtp.user",remitente);props.put("mail.smtp.clave","miClaveDeGMail"); // La clave de la cuenta
    // props.put("mail.smtp.auth","true"); // Usar autenticación mediante usuario y clave
    // props.put("mail.smtp.starttls.enable","true"); // Para conectar de manera segura al servidor SMTP
    // props.put("mail.smtp.port","587"); // El puerto SMTP seguro de Google

    // Session session = Session.getDefaultInstance(props);
    // MimeMessage message = new MimeMessage(session);

    // try
    // {
    //     message.setFrom(new InternetAddress(remitente));
    //     message.addRecipient(Message.RecipientType.TO, destinatario); // Se podrían añadir varios de la misma manera
    //     message.setSubject(asunto);
    //     message.setText(cuerpo);
    //     Transport transport = session.getTransport("smtp");
    //     transport.connect("smtp.gmail.com", remitente, clave);
    //     transport.sendMessage(message, message.getAllRecipients());
    //     transport.close();
    // }catch(
    // MessagingException me)
    // {
    //     me.printStackTrace(); // Si se produce un error
    // }}


    public static void fecha() {
        Date objDate = new Date();
        System.out.println("La fecha es: " + objDate.toString());
    }

    public static void sumar(String numeros) {
        String[] partes1 = numeros.split(" ");
        int contPartes1 = partes1.length;
        char[] listNums = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        int suma = 0;
        int bandera = 0;
        try{
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
        }catch(ArrayIndexOutOfBoundsException ex){System.out.println("Comandos insuficientes\n");}
        
    }

    public static String correo (String email) {
        /* enviar correo correo@gmail.com Asunto blablabla Cuerpo */
        String[] userEmail = email.split("@");
        // boolean adress = false;
        String dir = "";
        try{
            // if(userEmail[0].equals(" ") || userEmail[1].equals(" ")){
        // System.out.println("El correo no está completo");
        // }
            if (userEmail[1].equals("gmail.com")) {
                // adress = true;
                dir = userEmail[0] + "@" + userEmail[1];
                } else{System.out.println("El correo no es correcto");}
        
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Comandos insuficientes\n");}
        return dir;
    }
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Escribe: ");
        txt = in.nextLine();
        try {
            caracteres(txt);
            comandos(txt);
        }catch (ArrayIndexOutOfBoundsException ex) {System.out.println("Comandos insuficientes\n");}
         in.close();
    }   
}