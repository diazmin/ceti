
import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class expresiones {
    public static void main(String[] args) throws FileNotFoundException{
        String postfix = "";
        String expresion = "";
        // Conversión de notación Infija a Postfija mediante uso de pilas

        // Entrada de datos
        System.out.println("*Escribe una expresión algebraica: ");
        Scanner leer = new Scanner(System.in);

        //Valida que no haya caracteres raros
        caracteres(leer.nextLine());

        // Depurar la expresion algebraica
        String expr = depurar();
        String[] arrayInfix = expr.split(" ");

        // Declaración de las pilas
        Stack<String> E = new Stack<String>(); // Pila entrada
        Stack<String> P = new Stack<String>(); // Pila temporal para operadores
        Stack<String> S = new Stack<String>(); // Pila salida

        // Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >= 0; i--) {
            E.push(arrayInfix[i]);
        }

        try {
            // Algoritmo Infijo a Postfijo
            while (!E.isEmpty()) {
                switch (pref(E.peek())) {
                case 1:
                    P.push(E.pop());
                    break;
                case 3:
                case 4:
                    while (pref(P.peek()) >= pref(E.peek())) {
                        S.push(P.pop());
                    }
                    P.push(E.pop());
                    break;
                case 2:
                    while (!P.peek().equals("(")) {
                        S.push(P.pop());
                    }
                    P.pop();
                    E.pop();
                    break;
                default:
                    S.push(E.pop());
                }
            }

            // Eliminacion de `impurezas´ en la expresiones algebraicas
            String infix = expr.replace(" ", "");
            postfix = S.toString().replaceAll("[\\]\\[,]", "");

            // Mostrar resultados:
            System.out.println("Expresion: " + infix);
            //System.out.println("Expresion Postfija: " + postfix);

        } catch (Exception ex) {
            System.out.println("Error en la expresión algebraica");
            System.err.println(ex);
        }

        // Evaluar expresión Postfija
        
        String[] post = postfix.split(" ");
       
        // Añadir post (array) a la Pila de entrada (E)
        for (int i = post.length - 1; i >= 0; i--) {
            E.push(post[i]);
        }
        // Algoritmo de Evaluación Postfija
        String operadores = "+-*/%";
        while (!E.isEmpty()) {
            if (operadores.contains("" + E.peek())) {
                P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
            } else {
                P.push(E.pop());
            }
        }

        // Mostrar resultados:
        //System.out.println("Expresion: " + postfix);
        System.out.println("Resultado: " + P.peek());
    }

    // Depurar expresión algebraica
    private static String depurar(String s) {
        s = s.replaceAll("\\s+", ""); // Elimina espacios en blanco
        s = "(" + s + ")";
        String simbols = "+-*/()";
        String str = "";

        // Deja espacios entre operadores
        for (int i = 0; i < s.length(); i++) {
            if (simbols.contains("" + s.charAt(i))) {
                str += " " + s.charAt(i) + " ";
            } else
                str += s.charAt(i);
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    // Jerarquia de los operadores
    private static int pref(String op) {
        int prf = 99;
        if (op.equals("^"))
            prf = 5;
        if (op.equals("*") || op.equals("/"))
            prf = 4;
        if (op.equals("+") || op.equals("-"))
            prf = 3;
        if (op.equals(")"))
            prf = 2;
        if (op.equals("("))
            prf = 1;
        return prf;
    }

    private static int evaluar(String op, String n2, String n1) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        if (op.equals("+"))
            return (num1 + num2);
        if (op.equals("-"))
            return (num1 - num2);
        if (op.equals("*"))
            return (num1 * num2);
        if (op.equals("/"))
            return (num1 / num2);
        if (op.equals("%"))
            return (num1 % num2);
        return 0;
    }

     // Método para validar caracteres
    public static String caracteres(String texto) throws FileNotFoundException{
        String linea = "";
        int bandera = 0;
        
        File archivo = new File("diccionario.txt");
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
                System.out.println("\n---Primer filtro: Caracteres aceptados---"); return linea;}
                 else {System.out.println("\n---Primer filtro: Hay caracteres raros---");}

        }//catch (FileNotFoundException e) {System.out.println("No se encontró el archivo .txt");}
         catch (ArrayIndexOutOfBoundsException ex) {System.out.println("Comandos insuficientes\n");}      
        in.close();
    }
}