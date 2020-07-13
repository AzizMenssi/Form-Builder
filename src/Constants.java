import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.InputStream;

public class Constants {

	public static final Dimension HORIZONTAL_WIDE_SEPARAION = new Dimension(1920,5);
	public static final Dimension VERTICAL_WIDE_SEPARAION = new Dimension(5,1920);
	public static final Dimension HORIZONTAL_SEPARAION = new Dimension(300,5);
	public static final Dimension VERTICAL_SEPARAION = new Dimension(5,300);
	
	public static final Font SETTING_LABEL = new Font("Bank Gothic", Font.PLAIN, 15);

	public static final Font ITEM_LABEL =  new Font("Bank Gothic", Font.BOLD, 20);
	public static final Font TITLE =  new Font("Bank Gothic", Font.BOLD, 30);
	
	public static final Font TEXTFIELD = new Font("Bank Gothic", Font.BOLD, 10);
	public static final Font DESCRIPTIONFIELD = new Font("Bank Gothic", Font.PLAIN, 13);
	
	public static final int STYLE_EDITOR = 1;
	public static final int STYLE_FORM = 0;
	
	public static final Color EDITOR_BACKGROUND =new Color(232,234,240);
	
	public static final Color EDITOR_SELECTION_BACKGROUND =new Color(184,207,229);
	
	public static final Dimension EDITOR_LARGE = new Dimension(320,20);
	public static final Dimension EDITOR_STANDARD= new Dimension(150,20);
	public static final Dimension EDITOR_SMALL = new Dimension(50,20);
	public static String COLORS[]={"black","green","gray","olive","maroon","navy","red","blue","purple","teal","fuchsia"};
	
	public static String BG_COLORS[]={"black","white","gray","light Gray","dark Gray","gainsboro","bisque","lavender blush","seashell","beige","light pink","lavender","light blue"
			,"light cyan","light golden rod yellow","light coral"};
	
	public static Color colorFromString(String name) {
		
		switch(name) {
			case "black": 					 return Color.black;
			case "white": 					 return Color.white;
			case "gray": 					 return Color.gray;
			case "light Gray": 				 return Color.lightGray;
			case "dark Gray": 				 return Color.darkGray;
			case "gainsboro":				 return new Color(220,220,220);
			case "bisque":					 return new Color(255,228,196);
			case "lavender blush":			 return new Color(255,240,245);
			case "seashell":				 return new Color(255,245,238);
			case "beige":					 return new Color(245,245,220);
			case "light pink":			     return new Color(255,182,193);
			case "lavender":				 return new Color(230,230,250);
			case "light blue":				 return new Color(173,216,230);
			case "light cyan":				 return new Color(224,255,255);
			case "light golden rod yellow":	 return new Color(250,250,210);
			case "light coral":				 return new Color(240,128,128);
	
	}
	
		
		return new Color(0,0,0);
		
	}
	
}
