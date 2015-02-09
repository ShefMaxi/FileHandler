import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ReadXMIDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ReadXMIDriver.readXMIFile();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can't read.");
		}

	}

	/**
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static List<Element> readXMIFile() throws JDOMException, IOException {
		// initializtion
		SAXBuilder xmiBuilder = new SAXBuilder();
		Document document = xmiBuilder.build(new File("demo2.xmi"));
		// get root element
		Element rootElement = document.getRootElement();
		System.out.println("\n\n");
		// get all children element
		List<Element> childrenElement = rootElement.getChildren();
		
		System.out.println(childrenElement.get(1));
		printElement(childrenElement);
		return childrenElement;
	}

	public static void printAttribute(List<Attribute> list) {
		for (int i = 0; i < list.size(); ++i) {
			Attribute attr = (Attribute) list.get(i);
			String attrName = attr.getName();
			String attrValue = attr.getValue();
			System.out.println("Attribute : " + attrName + " = " + attrValue);
		}
	}

	public static void printElement(List<Element> list) {
		for (int i = 0; i < list.size(); ++i) {
			Element ele = (Element) list.get(i);
			String attrName = ele.getName();
			System.out.println("Element : " + attrName);
		}
	}

	public static void print(String str) {
		System.out.println(str);
	}
}
