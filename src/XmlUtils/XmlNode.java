package XmlUtils;

import java.util.Vector;

public class XmlNode{

    String name;
    Vector<String> attributes = new Vector<String>();
    Vector<String> attributeValues = new Vector<String>();
    String value;

    Vector<XmlNode> children = new Vector<XmlNode>();

    XmlNode(String n,String v){

        name= n;
        value = v;

    }

    public void AddAtribute(String name, String value){

        attributes.add(name);
        attributeValues.add(value);
    }

    
    public void SetAttributes(Vector<String> names, Vector<String> values){

        attributes = names;
        attributeValues = values;

    }

 
    public void addChild(XmlNode child){

        children.add(child);

    }

    public void setValue(String v){

        value = v;

    }

    
    public void setName(String n){

        name = n;

    }

    public String getCode(){


        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("<" + name + (attributes.size() ==0 ? "" : " "));
        
        for( int i=0 ; i< attributes.size();i++){

            sb.append( attributes.get(i)+"=\""+ attributeValues.get(i) + "\"" + ( i == attributes.size()-1 ? "" : " " ) );

        }
        sb.append(">" + value + "");

        for(XmlNode ch : children){
            sb.append("\n");
            sb.append(ch.getCode());
            sb.append("\n");
        }


        sb.append("</" + name + ">");
        sb.append("\n");

		return sb.toString();

    }

}