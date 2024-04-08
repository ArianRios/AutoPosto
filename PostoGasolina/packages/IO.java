package packages;
import java.util.Scanner;
import java.util.ArrayList;

// Atalhos
public class IO{
// Print
static public void prin(String txt){
    System.out.println(txt);
}

// Ler Inteiro
static public int lerInt(){
    while (true) {
        Scanner ler = new Scanner(System.in);
        try {
            int num = ler.nextInt();
            return num;
        } catch(Exception e) {
            prin("Digite só valores númericos");
        }   
    }
}

// Printear e ler um inteiro
static public int prinInt(String msg, String error){
    while (true) {
        Scanner ler = new Scanner(System.in);
        prin(msg);
        try {    
            int num = ler.nextInt();
            return num;
        } catch(Exception e) {
            prin(error);
        }
    }
}

// Ler String
static public String lerStr(){
    while(true){
        Scanner ler = new Scanner(System.in);
        try {
            String txt = ler.nextLine();
            return txt;
        } catch(Exception e) {
            prin("Digite só caracteres");
        }   
    }
}

// Ler Double
static public Double lerDouble(){
    while(true){
        Scanner ler = new Scanner(System.in);
        try {
            Double num = ler.nextDouble();
            return num;
        } catch(Exception e) {
            prin("Digite só valores numéricos");
        }   
    }
}

// Printear e ler um double
static public Double prinDouble(String msg, String error){
    while(true){
        Scanner ler = new Scanner(System.in);
        try {
            prin(msg);
            Double num = ler.nextDouble();
            return num;
        } catch(Exception e) {
            prin(error);
        }   
    }
}
}