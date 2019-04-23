
package com.primeton.tcisapiwebserviceservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.primeton.tcisapiwebserviceservice package. 
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

    private final static QName _TcisApiWebServiceIn0_QNAME = new QName("http://www.primeton.com/TcisApiWebServiceService", "in0");
    private final static QName _TcisApiWebServiceResponseOut1_QNAME = new QName("http://www.primeton.com/TcisApiWebServiceService", "out1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.primeton.tcisapiwebserviceservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TcisApiWebService }
     * 
     */
    public TcisApiWebService createTcisApiWebService() {
        return new TcisApiWebService();
    }

    /**
     * Create an instance of {@link TcisApiWebServiceResponse }
     * 
     */
    public TcisApiWebServiceResponse createTcisApiWebServiceResponse() {
        return new TcisApiWebServiceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.primeton.com/TcisApiWebServiceService", name = "in0", scope = TcisApiWebService.class)
    public JAXBElement<String> createTcisApiWebServiceIn0(String value) {
        return new JAXBElement<String>(_TcisApiWebServiceIn0_QNAME, String.class, TcisApiWebService.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.primeton.com/TcisApiWebServiceService", name = "out1", scope = TcisApiWebServiceResponse.class)
    public JAXBElement<String> createTcisApiWebServiceResponseOut1(String value) {
        return new JAXBElement<String>(_TcisApiWebServiceResponseOut1_QNAME, String.class, TcisApiWebServiceResponse.class, value);
    }

}
