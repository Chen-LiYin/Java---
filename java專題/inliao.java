// 飲料
public class inliao extends father{

	public inliao(String name,int price){
		super(name, price);
	}
	public String toString(){
		return  String.format("飲料: %6s  數量: %2d  金額: %3d", name, number, money());
	}
}


