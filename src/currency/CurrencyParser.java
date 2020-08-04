package currency;

import java.io.*;
import java.net.URL;
import java.util.Vector;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;



public class CurrencyParser implements Model {


public CurrencyParser(){}

    @Override
    public void UpdateFile() {
try {
	System.out.println("update...");
	

   File path = new File("Output.xml");
    OutputStream output = new FileOutputStream(path);
    URL url = new URL("http://www.boi.org.il/currency.xml");

    InputStream stream = url.openStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    String line = reader.readLine();
    while (line != null) {
        output.write(line.getBytes());
        line = reader.readLine();
    }

    output.close();*/

//catch(IOException e){
  //  e.printStackTrace();
    //    }
    }

    @Override
    public Vector<CoinCurrency> ToParse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Vector<CoinCurrency> currencies = new Vector<CoinCurrency>();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Output.xml");
            NodeList currencyList = doc.getElementsByTagName("CURRENCY");
            for(int i=0; i<currencyList.getLength();i++){
                Node node = currencyList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element e = (Element)node;
                    currencies.add(new CoinCurrency());
                    NodeList details = e.getChildNodes();
                    for(int j=0;j<details.getLength();j++){		// node list of the children(currency details)
                        Node n = details.item(j);
                        if(n.getNodeType()==Node.ELEMENT_NODE){
                            Element det = (Element)n;

                            /**that switch need to enter all details to class*/
                            switch(det.getTagName()){
                                case "NAME":
                                    currencies.get(i).setName(det.getTextContent());
                                    break;
                                case "UNIT":
                                    currencies.get(i).setUnit(Integer.parseInt(det.getTextContent()));
                                    break;
                                case "CURRENCYCODE":
                                    currencies.get(i).setCurrencyCode(det.getTextContent());
                                    break;
                                case "COUNTRY":
                                    currencies.get(i).setCountry(det.getTextContent());
                                    break;
                                case "RATE":
                                    currencies.get(i).setRate(Double.parseDouble(det.getTextContent()));
                                    break;
                                case "CHANGE":
                                    currencies.get(i).setChange(Double.parseDouble(det.getTextContent()));
                                    break;
                            }
                        }
                    }
                }
            }
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return currencies;
    }
    
    public String get_date(){
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder;
    	String str = new String();
    	try {
			builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Output.xml");
            NodeList date = doc.getElementsByTagName("LAST_UPDATE");
            Node D = date.item(0);
            if(D.getNodeType()==Node.ELEMENT_NODE){
                Element e = (Element)D;
            NodeList details = e.getChildNodes();
            Node n = details.item(0);
            str = n.getTextContent();
            }
		}
            catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
    }
    
}
