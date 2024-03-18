
package consumidor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the consumidor package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AcabarJoc_QNAME = new QName("http://CartasSOAP/", "acabarJoc");
    private final static QName _AcabarJocResponse_QNAME = new QName("http://CartasSOAP/", "acabarJocResponse");
    private final static QName _IniciarJoc_QNAME = new QName("http://CartasSOAP/", "iniciarJoc");
    private final static QName _IniciarJocResponse_QNAME = new QName("http://CartasSOAP/", "iniciarJocResponse");
    private final static QName _MostrarCartes_QNAME = new QName("http://CartasSOAP/", "mostrarCartes");
    private final static QName _MostrarCartesResponse_QNAME = new QName("http://CartasSOAP/", "mostrarCartesResponse");
    private final static QName _MoureJugadorPassa_QNAME = new QName("http://CartasSOAP/", "moureJugadorPassa");
    private final static QName _MoureJugadorPassaResponse_QNAME = new QName("http://CartasSOAP/", "moureJugadorPassaResponse");
    private final static QName _TirarCarta_QNAME = new QName("http://CartasSOAP/", "tirarCarta");
    private final static QName _TirarCartaResponse_QNAME = new QName("http://CartasSOAP/", "tirarCartaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: consumidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcabarJoc }
     * 
     */
    public AcabarJoc createAcabarJoc() {
        return new AcabarJoc();
    }

    /**
     * Create an instance of {@link AcabarJocResponse }
     * 
     */
    public AcabarJocResponse createAcabarJocResponse() {
        return new AcabarJocResponse();
    }

    /**
     * Create an instance of {@link IniciarJoc }
     * 
     */
    public IniciarJoc createIniciarJoc() {
        return new IniciarJoc();
    }

    /**
     * Create an instance of {@link IniciarJocResponse }
     * 
     */
    public IniciarJocResponse createIniciarJocResponse() {
        return new IniciarJocResponse();
    }

    /**
     * Create an instance of {@link MostrarCartes }
     * 
     */
    public MostrarCartes createMostrarCartes() {
        return new MostrarCartes();
    }

    /**
     * Create an instance of {@link MostrarCartesResponse }
     * 
     */
    public MostrarCartesResponse createMostrarCartesResponse() {
        return new MostrarCartesResponse();
    }

    /**
     * Create an instance of {@link MoureJugadorPassa }
     * 
     */
    public MoureJugadorPassa createMoureJugadorPassa() {
        return new MoureJugadorPassa();
    }

    /**
     * Create an instance of {@link MoureJugadorPassaResponse }
     * 
     */
    public MoureJugadorPassaResponse createMoureJugadorPassaResponse() {
        return new MoureJugadorPassaResponse();
    }

    /**
     * Create an instance of {@link TirarCarta }
     * 
     */
    public TirarCarta createTirarCarta() {
        return new TirarCarta();
    }

    /**
     * Create an instance of {@link TirarCartaResponse }
     * 
     */
    public TirarCartaResponse createTirarCartaResponse() {
        return new TirarCartaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJoc }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcabarJoc }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "acabarJoc")
    public JAXBElement<AcabarJoc> createAcabarJoc(AcabarJoc value) {
        return new JAXBElement<AcabarJoc>(_AcabarJoc_QNAME, AcabarJoc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJocResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcabarJocResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "acabarJocResponse")
    public JAXBElement<AcabarJocResponse> createAcabarJocResponse(AcabarJocResponse value) {
        return new JAXBElement<AcabarJocResponse>(_AcabarJocResponse_QNAME, AcabarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarJoc }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IniciarJoc }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "iniciarJoc")
    public JAXBElement<IniciarJoc> createIniciarJoc(IniciarJoc value) {
        return new JAXBElement<IniciarJoc>(_IniciarJoc_QNAME, IniciarJoc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarJocResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IniciarJocResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "iniciarJocResponse")
    public JAXBElement<IniciarJocResponse> createIniciarJocResponse(IniciarJocResponse value) {
        return new JAXBElement<IniciarJocResponse>(_IniciarJocResponse_QNAME, IniciarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarCartes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MostrarCartes }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "mostrarCartes")
    public JAXBElement<MostrarCartes> createMostrarCartes(MostrarCartes value) {
        return new JAXBElement<MostrarCartes>(_MostrarCartes_QNAME, MostrarCartes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarCartesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MostrarCartesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "mostrarCartesResponse")
    public JAXBElement<MostrarCartesResponse> createMostrarCartesResponse(MostrarCartesResponse value) {
        return new JAXBElement<MostrarCartesResponse>(_MostrarCartesResponse_QNAME, MostrarCartesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugadorPassa }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MoureJugadorPassa }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "moureJugadorPassa")
    public JAXBElement<MoureJugadorPassa> createMoureJugadorPassa(MoureJugadorPassa value) {
        return new JAXBElement<MoureJugadorPassa>(_MoureJugadorPassa_QNAME, MoureJugadorPassa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugadorPassaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MoureJugadorPassaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "moureJugadorPassaResponse")
    public JAXBElement<MoureJugadorPassaResponse> createMoureJugadorPassaResponse(MoureJugadorPassaResponse value) {
        return new JAXBElement<MoureJugadorPassaResponse>(_MoureJugadorPassaResponse_QNAME, MoureJugadorPassaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TirarCarta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TirarCarta }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "tirarCarta")
    public JAXBElement<TirarCarta> createTirarCarta(TirarCarta value) {
        return new JAXBElement<TirarCarta>(_TirarCarta_QNAME, TirarCarta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TirarCartaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TirarCartaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://CartasSOAP/", name = "tirarCartaResponse")
    public JAXBElement<TirarCartaResponse> createTirarCartaResponse(TirarCartaResponse value) {
        return new JAXBElement<TirarCartaResponse>(_TirarCartaResponse_QNAME, TirarCartaResponse.class, null, value);
    }

}
