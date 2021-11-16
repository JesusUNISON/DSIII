/*
    Autor: Jesus Angel Juarez Zazueta
 */

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Geometric extends DefaultHandler {
    private static final String CLASS_NAME = Geometric.class.getSimpleName();

    private final static Logger LOG = Logger.getLogger(CLASS_NAME);

    public Geometric() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equals("circle")) {
            double r = Double.parseDouble(attributes.getValue("r"));

            double area = Math.pow(r, 2) * Math.PI;
            double perimetro = 2 * r * Math.PI;

            System.out.printf("Area circulo: %7.2f\n", area);
            System.out.printf("Perimetro circulo: %7.2f\n", perimetro);
        }

        if (localName.equals("rect")) {
            double largo = Double.parseDouble(attributes.getValue("height"));
            double ancho = Double.parseDouble(attributes.getValue("width"));

            double area = largo * ancho;
            double perimetro = (2*largo) + (2*ancho);

            System.out.printf("Area rectangulo: %7.2f\n", area);
            System.out.printf("Perimetro rectangulo: %7.2f\n", perimetro);
        }

        if (localName.equals("line")) {
            double x1 = Double.parseDouble(attributes.getValue("x1"));
            double y1 = Double.parseDouble(attributes.getValue("y1"));
            double x2 = Double.parseDouble(attributes.getValue("x2"));
            double y2 = Double.parseDouble(attributes.getValue("y2"));

            double distancia = Math.sqrt( Math.pow( x2-x1,2) +  Math.pow( y2-y1,2) );
            double pendiente = (y2-y1) / (x2-x1);

            System.out.printf("Longitud linea: %7.2f\n", distancia);
            System.out.printf("Pendiente linea: %7.2f\n", pendiente);
        }

    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println();
    }


    public static void main(String args[]) {
        /*  if (args.length == 0) {
            LOG.severe("No file to process. Usage is:" + "\njava Geometric <filename>");
            return;
        }*/

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            LOG.severe( e.getMessage());
        } catch (SAXException e) {
            LOG.severe( e.getMessage());
        }

        File xmlFile = new File("D:/Escuela/UNI/DS III/IntelJ/Figuras/xml/figuras.svg");

        Geometric handler = new Geometric();

        try {
            assert saxParser != null;
            saxParser.parse(xmlFile, handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LOG.severe( e.getMessage());
        }
    }

}
