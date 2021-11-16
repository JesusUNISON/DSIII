/**
 * @author Jesus Angel Juarez
 */
package main.java;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

public class URLParser extends HTMLEditorKit.ParserCallback {

    private URL baseUrl;

    public URLParser(URL u) {
        super();

        String s = u.toString();

        String urlString = s.substring(0,
                s.lastIndexOf('/')+1);
        System.out.println(urlString);

        try {
            baseUrl = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet att, int pos) {
        if ( tag == HTML.Tag.A ) {

            Enumeration attributeNames = att.getAttributeNames();
            // mostrar atributos y valores
            while (attributeNames.hasMoreElements()) {
                Object name =  attributeNames.nextElement();
                System.out.printf("%s = %s\n", name, att.getAttribute(name));
            }

            Object value = att.getAttribute(HTML.Attribute.HREF);

            if( value == null )
                return;
            if (value.toString().endsWith(".csv")) {
                if (isRelative(value.toString())) {
                    System.out.println(value);
                    String url = baseUrl.toString() + value;
                    System.out.println(url);
                    Thread t = new Thread(new CSVReader(url));
                    t.start();
                    try {

                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                } else {
                    System.out.println(value);
                    System.out.println();
                }
            }
        }
    }

    @Override
    public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        super.handleSimpleTag(t, a, pos);
    }

    private boolean isRelative(String url) {
        boolean result = false;

        try {
            URL u = new URL(url);
        } catch (MalformedURLException e) {
            result = true;
        }
        return result;
    }


}
