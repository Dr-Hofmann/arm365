package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxProcessor {

	public SaxProcessor() throws FileNotFoundException,SAXException, ParserConfigurationException, IOException {
		
		SAXParserFactory sax = SAXParserFactory.newInstance();
		
		SAXParser parser =sax.newSAXParser();
		
		InputStream xmlInput  = new FileInputStream("sax.xml");

		SaxPerson handler = new SaxPerson();
		
		parser.parse(xmlInput, handler);
		
		System.out.println(handler.getPerson().getName());
	}
   

	
}

