import java.io.Serializable;


public class Note implements Serializable{
	int num;
	String contenu;
	public Note(int num,String contenu) {
		this.num=num;
		this.contenu=contenu;
	}
	public int getNum() {
		return num;
	}
	public String getContenu() {
		return contenu;
	}
	public String toString() {
		return "Num : "+num+" Contenu : "+contenu;
	};
}
