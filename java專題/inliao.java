// ����
public class inliao extends father{

	public inliao(String name,int price){
		super(name, price);
	}
	public String toString(){
		return  String.format("����: %6s  �ƶq: %2d  ���B: %3d", name, number, money());
	}
}


