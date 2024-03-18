package consumidor;

import java.util.Scanner;
import java.util.List;

public class Consumidor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sortir = false;
        
        System.out.println("Benvingut al joc!");
        
        while (!sortir) {
            System.out.println("\nQuina accio vols realitzar?");
            System.out.println("1. Iniciar joc");
            System.out.println("2. Mostrar cartes");
            System.out.println("3. Passar Torn");
            System.out.println("4. Tirar carta");
            System.out.println("5. Acabar joc");
            System.out.println("6. Sortir");
            System.out.print("Introdueix el numero de l'opcio desitjada: ");
            
            int opcio = scanner.nextInt();
            
            switch (opcio) {
                case 1:
                    System.out.print("Introdueix el codi de la partida: ");
                    int codiPartida = scanner.nextInt();
                    List<String> resultatIniciarJoc = iniciarJoc(codiPartida);
                    mostrarResultat(resultatIniciarJoc);
                    break;
                case 2:
                    System.out.print("Introdueix el codi de la partida: ");
                    codiPartida = scanner.nextInt();
                    System.out.print("Introdueix el numero de jugador: ");
                    int numJugador = scanner.nextInt();
                    List<String> resultatMostrarCartes = mostrarCartes(codiPartida, numJugador);
                    mostrarResultat(resultatMostrarCartes);
                    break;
                case 3:
                    System.out.print("Introdueix el codi de la partida: ");
                    codiPartida = scanner.nextInt();
                    System.out.print("Introdueix el numero de jugador: ");
                    numJugador = scanner.nextInt();
                    String resultatMoureJugador = moureJugadorPassa(codiPartida, numJugador);
                    System.out.println("Resultat: " + resultatMoureJugador);
                    break;
                case 4:
                    System.out.print("Introdueix el codi de la partida: ");
                    codiPartida = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Introdueix la carta a tirar: ");
                    String carta = scanner.nextLine();
                    System.out.print("Introdueix el numero de jugador: ");
                    numJugador = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Introdueix el nou color (o deixa en blanc sol utilitzar amb CanviColor o AgafaQuatre): ");
                    String nouColor = scanner.nextLine();
                    String resultatTirarCarta = tirarCarta(codiPartida, carta, numJugador, nouColor);
                    System.out.println("Resultat: " + resultatTirarCarta);
                    break;
                case 5:
                    System.out.print("Introdueix el codi de la partida: ");
                    codiPartida = scanner.nextInt();
                    String resultatAcabarJoc = acabarJoc(codiPartida);
                    System.out.println("Resultat: " + resultatAcabarJoc);
                    break;
                case 6:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opcio no valida. Si us plau, selecciona una opcio valida.");
            }
        }
        
        scanner.close();
    }

    private static java.util.List<java.lang.String> iniciarJoc(int codiPartida) {
        consumidor.WebServiceSOAP_Service service = new consumidor.WebServiceSOAP_Service();
        consumidor.WebServiceSOAP port = service.getWebServiceSOAPPort();
        return port.iniciarJoc(codiPartida);
    }

    private static java.util.List<java.lang.String> mostrarCartes(int codiPartida, int numJugador) {
        consumidor.WebServiceSOAP_Service service = new consumidor.WebServiceSOAP_Service();
        consumidor.WebServiceSOAP port = service.getWebServiceSOAPPort();
        return port.mostrarCartes(codiPartida, numJugador);
    }

    private static String moureJugadorPassa(int codiPartida, int numJugador) {
        consumidor.WebServiceSOAP_Service service = new consumidor.WebServiceSOAP_Service();
        consumidor.WebServiceSOAP port = service.getWebServiceSOAPPort();
        return port.moureJugadorPassa(codiPartida, numJugador);
    }

    private static String tirarCarta(int codiPartida, java.lang.String carta, int numJugador, java.lang.String nouColor) {
        consumidor.WebServiceSOAP_Service service = new consumidor.WebServiceSOAP_Service();
        consumidor.WebServiceSOAP port = service.getWebServiceSOAPPort();
        return port.tirarCarta(codiPartida, carta, numJugador, nouColor);
    }

    private static String acabarJoc(int codiPartida) {
        consumidor.WebServiceSOAP_Service service = new consumidor.WebServiceSOAP_Service();
        consumidor.WebServiceSOAP port = service.getWebServiceSOAPPort();
        return port.acabarJoc(codiPartida);
    }

    private static void mostrarResultat(List<String> resultat) {
        System.out.println("Resultat:");
        for (String str : resultat) {
            System.out.println(str);
        }
    }

}
