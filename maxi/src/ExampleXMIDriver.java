import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.PackageElement;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ExampleXMIDriver {
	// add .jar
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ExampleXMIDriver.readXMIFile();
			System.out.println("READ.");
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
		Document document = xmiBuilder.build(new File("Example.xmi"));
		// get root element
		Element rootElement = document.getRootElement();
		
		
		// print all attributes
		//ExampleXMIDriver.printAttributes(rootElement.getAttributes());
		System.out.println("\n");
		
		// get all children element
		List<Element> childrenElements = rootElement.getChildren();
		ArrayList list = new ArrayList();
		
		// print the attributes of all elements
		for (Element element : childrenElements) {
			if (element.getName().equals("packagedElement")){
			System.out.println("\nnext element: ");
			ExampleXMIDriver.printAttributes(element.getAttributes());
			List<Element> nextChildrenElements = element.getChildren();
			if (nextChildrenElements.size() > 0) {
				for (Element element2 : nextChildrenElements) {
					if (element2.getName().equals("ownedEnd")){
					System.out.println("");
					System.out.println(element2.getName());
					//if(element2.getAttribute().equals("type"))
						System.out.println(element2.getAttributeValue("type"));
						
					//ExampleXMIDriver.printAttributes(element2.getAttributes());
					}
				}
				}
			}
			
		}
		
		return childrenElements;
	}
	
	
	
	
	//--------------------------------------------------------------------------------

	public static void printAttributes(List<Attribute> list) {
		for (int i = 0; i < list.size(); ++i) {
			Attribute attr = (Attribute) list.get(i);
			String attrName = attr.getName();
			String attrValue = attr.getValue();
			System.out.println("Attribute : " + attrName + " = " + attrValue);
		}
	}

	public static void printElements(List<Element> list) {
		for (int i = 0; i < list.size(); ++i) {
			Element ele = list.get(i);
			String attrName = ele.getName();
			System.out.println("Element : " + attrName);
		}
	}

	public static void print(String str) {
		System.out.println(str);
	}
}
