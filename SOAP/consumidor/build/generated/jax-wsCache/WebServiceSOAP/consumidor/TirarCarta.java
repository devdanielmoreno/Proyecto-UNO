
package consumidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tirarCarta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tirarCarta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiPartida" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="carta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numJugador" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nuevoColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tirarCarta", propOrder = {
    "codiPartida",
    "carta",
    "numJugador",
    "nuevoColor"
})
public class TirarCarta {

    protected int codiPartida;
    protected String carta;
    protected int numJugador;
    protected String nuevoColor;

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
     * Obtiene el valor de la propiedad carta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarta() {
        return carta;
    }

    /**
     * Define el valor de la propiedad carta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarta(String value) {
        this.carta = value;
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

    /**
     * Obtiene el valor de la propiedad nuevoColor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuevoColor() {
        return nuevoColor;
    }

    /**
     * Define el valor de la propiedad nuevoColor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuevoColor(String value) {
        this.nuevoColor = value;
    }

}
