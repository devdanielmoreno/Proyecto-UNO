package CartasSOAP;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebService(serviceName = "WebServiceSOAP")
public class WebServiceSOAP {

    private static List<Partida> partides = new ArrayList<>();

    @WebMethod(operationName = "iniciarJoc")
    @WebResult(name = "result")
    public String[] iniciarJoc(@WebParam(name = "codiPartida") int codiPartida) {
        if (!esPartidaValida(codiPartida)) {
            Partida novaPartida = new Partida(codiPartida); // Llama al método crearBaralla al iniciar la partida
            partides.add(novaPartida);
            return new String[]{
                    "Joc iniciat amb èxit. Codi de partida: " + codiPartida + ". Carta inicial: " + novaPartida.getCartaInicial()
            };
        } else {
            return new String[]{
                    "El codi de partida " + codiPartida + " ja existeix. Si us plau, tria'n un altre."
            };
        }
    }
    @WebMethod(operationName = "mostrarCartes")
    @WebResult(name = "cartes")
    public List<String> mostrarCartes(@WebParam(name = "codiPartida") int codiPartida,
                                      @WebParam(name = "numJugador") int numJugador) {
        if (esPartidaValida(codiPartida)) {
            return partides.get(codiPartida - 1).mostrarMaJugador(numJugador);
        } else {
            return new ArrayList<>();
        }
    }

    @WebMethod(operationName = "tirarCarta")
    @WebResult(name = "result")
    public String tirarCarta(@WebParam(name = "codiPartida") int codiPartida,
                             @WebParam(name = "carta") String carta,
                             @WebParam(name = "numJugador") int numJugador,
                             @WebParam(name = "nuevoColor") String nuevoColor) {
        if (esPartidaValida(codiPartida)) {
            Partida partida = partides.get(codiPartida - 1);
            System.out.println("Partida actual: " + partida);

            try {
                if (carta.contains("CanviColor") || carta.contains("AgafaQuatre")) {
                    if (!partida.mans.get(numJugador - 1).contains(carta)) {
                        return "Error: El jugador " + numJugador + " no tiene la carta " + carta + " en su mano.";
                    }

                    if (nuevoColor == null || !Arrays.asList("Vermell", "Verd", "Blau", "Groc").contains(nuevoColor)) {
                        return "Error: Debes proporcionar un nuevo color válido para la carta CanviColor (Vermell, Verd, Blau o Groc).";
                    }

                    if (carta.contains("CanviColor")) {
                        partida.establecerCartaInicial(nuevoColor + " CanviColor");
                        partida.mans.get(numJugador - 1).remove(carta);
                        partida.setUltimaCarta(nuevoColor + " CanviColor");
                        partida.cambiarTurno();
                        return "El jugador " + numJugador + " ha tirado " + nuevoColor + " " + carta + " y ha cambiado el color a " + nuevoColor + ".";
                    } else if (carta.contains("AgafaQuatre")) {
                        if (!partida.mans.get(numJugador - 1).contains(carta)) {
                            return "Error: El jugador " + numJugador + " no tiene la carta " + carta + " en su mano.";
                        }

                        int jugadorOponente = partida.getTurnoActual() % 2 + 1;

                        for (int i = 0; i < 4; i++) {
                            List<String> manoOponente = partida.mans.get(jugadorOponente - 1);
                            manoOponente.add(partida.generarCartaRandom());
                        }

                        partida.mans.get(numJugador - 1).remove(carta);

                        partida.setUltimaCarta(nuevoColor + " AgafaQuatre");
                        partida.cambiarTurno();
                        return "El jugador " + numJugador + " ha tirado " + partida.getUltimaCarta() + ". El jugador " + jugadorOponente + " ha robado 4 cartas.";
                    }
                }

                String resultadoTirada = partida.tirarCarta(numJugador, carta, nuevoColor);

                if (resultadoTirada.startsWith("Error")) {
                    String cartaEnMesa = partida.getUltimaCarta();
                    System.out.println("Carta en la mesa: " + cartaEnMesa);
                    return resultadoTirada + ". Carta en la mesa: " + cartaEnMesa;
                } else {
                    String mensaje = String.format("%s", resultadoTirada);
                    System.out.println("Carta Inicial: " + partida.getCartaInicial());
                    System.out.println("Última Carta: " + partida.getUltimaCarta());
                    return mensaje;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Error: Se produjo una excepción durante la tirada de la carta.";
            }
        } else {
            return "Codi de partida no vàlid.";
        }
    }

    @WebMethod(operationName = "moureJugadorPassa")
    @WebResult(name = "result")
    public String moureJugadorPassa(@WebParam(name = "codiPartida") int codiPartida,
                                    @WebParam(name = "numJugador") int numJugador) {
        if (esPartidaValida(codiPartida)) {
            return partides.get(codiPartida - 1).passarTorn(numJugador);
        } else {
            return "Codi de partida no vàlid.";
        }
    }

    @WebMethod(operationName = "acabarJoc")
    @WebResult(name = "result")
    public String acabarJoc(@WebParam(name = "codiPartida") int codiPartida) {
        if (esPartidaValida(codiPartida)) {
            partides.remove(codiPartida - 1);
            return "Joc finalitzat " + codiPartida;
        } else {
            return "Codi de partida no vàlid.";
        }
    }

    private boolean esPartidaValida(int codiPartida) {
        return codiPartida <= partides.size() && codiPartida > 0;
    }

    private class Partida {

        private int codiPartida;
        private List<List<String>> mans;
        private int torn;
        private String cartaInicial;
        private String ultimaCarta;

public Partida(int codiPartida) {
    this.codiPartida = codiPartida;
    this.mans = new ArrayList<>();
    this.mans.add(new ArrayList<>()); // Jugador 1
    this.mans.add(new ArrayList<>()); // Jugador 2
    this.torn = 1;

    this.cartaInicial = generarCartaInicialAleatoria();
    while (this.cartaInicial.equals("Inverteix") || this.cartaInicial.equals("Salta") || this.cartaInicial.equals("AgafaDos") || this.cartaInicial.equals("AgafaQuatre") || this.cartaInicial.contains("CanviColor")) {
        this.cartaInicial = generarCartaInicialAleatoria();
    }

    this.ultimaCarta = this.cartaInicial;
    repartirCartesIniciales();
}


        public String getCartaInicial() {
            return cartaInicial;
        }

        public String getUltimaCarta() {
            return ultimaCarta;
        }

        public void setUltimaCarta(String ultimaCarta) {
            this.ultimaCarta = ultimaCarta;
        }

        public int getTurnoActual() {
            return torn;
        }

        public void cambiarTurno() {
            torn = torn % 2 + 1;
        }

        public List<String> mostrarMaJugador(int numJugador) {
            return new ArrayList<>(mans.get(numJugador - 1));
        }

        public void establecerCartaInicial(String cartaInicial) {
            this.cartaInicial = cartaInicial;
        }

public void repartirCartesIniciales() {
    for (List<String> mano : mans) {
        for (int i = 0; i < 7; i++) {
            String cartaRandom;
            do {
                cartaRandom = generarCartaRandom();
            } while (cartaRandom.equals("Inverteix") || cartaRandom.equals("Salta") || cartaRandom.equals("AgafaDos"));
            
            mano.add(cartaRandom);
        }
    }
}
private String generarCartaInicialAleatoria() {
    String[] colores = {"Vermell", "Verd", "Blau", "Groc"};
    String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    String colorAleatorio = colores[(int) (Math.random() * colores.length)];
    String numeroAleatorio = numeros[(int) (Math.random() * numeros.length)];

    return colorAleatorio + " " + numeroAleatorio;
}

public String generarCartaRandom() {
    String[] colores = {"Vermell", "Verd", "Blau", "Groc"};
    String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Salta", "Inverteix", "AgafaDos", "CanviColor", "AgafaQuatre"};

    String colorAleatorio = colores[(int) (Math.random() * colores.length)];
    String numeroAleatorio = numeros[(int) (Math.random() * numeros.length)];

    if (numeroAleatorio.equals("CanviColor") || numeroAleatorio.equals("AgafaQuatre")) {
        return numeroAleatorio;
    } else {
        return colorAleatorio + " " + numeroAleatorio;
    }
}


        public String tirarCarta(int numJugador, String carta, String nuevoColor) {
            if (numJugador == this.torn) {
                List<String> maJugador = this.mans.get(numJugador - 1);

                if (this.ultimaCarta == null) {
                    if (maJugador.contains(carta) && (carta.contains("CanviColor") || carta.contains("AgafaQuatre") || this.esMismaCartaInicial(carta))) {
                        int cartaIndex = maJugador.indexOf(carta);
                        maJugador.remove(cartaIndex);

                        if (carta.contains("CanviColor")) {
                            int jugadorOponente = getTurnoActual() % 2 + 1;

                            String nuevaCarta = generarCartaRandom();
                            mans.get(jugadorOponente - 1).add(nuevaCarta);

                            maJugador.remove(carta);

                            setUltimaCarta(nuevoColor + " CanviColor");
                            cambiarTurno();
                            return "El jugador " + numJugador + " ha tirado " + nuevoColor + " " + carta + " y ha cambiado el color a " + nuevoColor + ".";
                        } else if (carta.contains("AgafaQuatre")) {
                            if (!maJugador.contains(carta)) {
                                return "Error: El jugador " + numJugador + " no tiene la carta " + carta + " en su mano.";
                            }

                            int jugadorOponente = getTurnoActual() % 2 + 1;

                            for (int i = 0; i < 4; i++) {
                                String nuevaCarta = generarCartaRandom();
                                mans.get(jugadorOponente - 1).add(nuevaCarta);
                            }

                            maJugador.remove(carta);

                            setUltimaCarta(nuevoColor + " AgafaQuatre");
                            cambiarTurno();
                            return "El jugador " + numJugador + " ha tirado " + getUltimaCarta() + ". El jugador " + jugadorOponente + " ha robado 4 cartas.";
                        }
                    }

                    if (carta.contains("AgafaDos")) {
                        int jugadorSiguiente = this.torn % 2 + 1;

                        for (int i = 0; i < 2; i++) {
                            this.mans.get(jugadorSiguiente - 1).add(this.generarCartaRandom());
                        }

                        this.torn = numJugador;

                        return "El jugador " + numJugador + " ha tirado " + carta + ". El jugador " + jugadorSiguiente + " ha robado 2 cartas. No puede tirar en la siguiente ronda.";
                    } else if (carta.contains("Salta")) {
                        this.torn = numJugador;
                        this.ultimaCarta = carta;
                        return "El jugador " + numJugador + " ha tirado " + carta + ". Ha saltado el turno del jugador " + (numJugador % 2 + 1) + ".";
                    } else if (carta.contains("Inverteix")) {
                        this.torn = numJugador;
                        this.ultimaCarta = carta;
                        return "El jugador " + numJugador + " ha tirado " + carta + ". Se ha invertido el turno. Ahora le toca al jugador " + numJugador + ".";
                    } else {
                        this.torn = this.torn % 2 + 1;
                    }

                    this.ultimaCarta = carta;

                    return "El jugador " + numJugador + " ha tirado una carta: " + carta;
                } else {
                    if (puedeTirarCarta(carta)) {
                        int cartaIndex = maJugador.indexOf(carta);
                        if (cartaIndex != -1) {
                            maJugador.remove(cartaIndex);

                            if (!carta.contains("AgafaDos") && !carta.contains("Salta") && !carta.contains("Inverteix")) {
                                this.ultimaCarta = carta;
                            }

                            if (carta.contains("AgafaDos")) {
                                int jugadorSiguiente = this.torn % 2 + 1;

                                for (int i = 0; i < 2; i++) {
                                    this.mans.get(jugadorSiguiente - 1).add(this.generarCartaRandom());
                                }

                                this.torn = numJugador;

                                return "El jugador " + numJugador + " ha tirado " + carta + ". El jugador " + jugadorSiguiente + " ha robado 2 cartas. No puede tirar en la siguiente ronda.";
                            } else if (carta.contains("Salta")) {
                                this.torn = numJugador;
                                this.ultimaCarta = carta;
                                return "El jugador " + numJugador + " ha tirado " + carta + ". Ha saltado/bloqueado el turno del jugador " + (numJugador % 2 + 1) + ".";
                            } else if (carta.contains("Inverteix")) {
                                this.torn = numJugador;
                                this.ultimaCarta = carta;
                                return "El jugador " + numJugador + " ha tirado " + carta + ". Se ha invertido el turno. Ahora le toca al jugador " + numJugador + ".";
                            } else {
                                this.torn = this.torn % 2 + 1;
                            }

                            this.ultimaCarta = carta;

                            return "El jugador " + numJugador + " ha tirado una carta: " + carta;
                        } else {
                            return "La carta no está en la mano del jugador " + numJugador;
                        }
                    } else {
                        return "Error: Debes tirar una carta que tenga el mismo color, el mismo número o una carta especial ('Salta', 'Inverteix', 'AgafaDos').";
                    }
                }
            } else {
                return "No es tu turno para tirar.";
            }
        }

        private boolean esMismaCartaInicial(String carta) {
            return this.cartaInicial.equals(carta);
        }

        private boolean puedeTirarCarta(String carta) {
            String[] cartaSplit = carta.split(" ");
            String colorCarta = cartaSplit[0];
            String numeroCarta = cartaSplit[1];

            String[] ultimaCartaSplit = this.ultimaCarta.split(" ");
            String colorUltimaCarta = ultimaCartaSplit[0];
            String numeroUltimaCarta = ultimaCartaSplit[1];

            return colorCarta.equals(colorUltimaCarta) || numeroCarta.equals(numeroUltimaCarta);
        }

        public String passarTorn(int numJugador) {
            cambiarTurno();
            return "Turno pasado al siguiente jugador.";
        }
    }
}
