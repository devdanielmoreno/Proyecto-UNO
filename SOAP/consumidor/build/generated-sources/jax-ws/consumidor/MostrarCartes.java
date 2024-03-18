
package consumidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para mostrarCartes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="mostrarCartes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiPartida" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numJugador" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mostrarCartes", propOrder = {
    "codiPartida",
    "numJugador"
})
public class MostrarCartes {

    protected int codiPartida;
    protected int numJugador;

    /**
     * Obtiene el valor de la propiedad codiPartida.
     * 
     */
    public int getCodiPartida() {
        return codiPartida;
    }

    /**
     * Define el valor de la propiedad codiPartida.
     * 
     */
    public void setCodiPartida(int value) {
        this.codiPartida = value;
    }

    /**
     * Obtiene el valor de la propiedad numJugador.
     * 
     */
    public int getNumJugador() {
        return numJugador;
    }

    /**
     * Define el valor de la propiedad numJugador.
     * 
     */
    public void setNumJugador(int value) {
        this.numJugador = value;
    }

}
