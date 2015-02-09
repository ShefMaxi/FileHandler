import java.io.*;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
public class PrettyPrinter {
   public static void main(String[] args) {
        // Assume filename argument
       // String filename = args[0];
        try {
            // Build the document with SAX and Xerces, no validation
            SAXBuilder builder = new SAXBuilder();
            // Create the document
            Document doc = builder.build(new File("employees.xml"));
            // Output the document, use standard formatter
            XMLOutputter fmt = new XMLOutputter();
            fmt.output(doc, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
