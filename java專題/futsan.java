// °ÆÀ\
public class futsan extends father{

	public futsan(String name,int price){
		super(name, price);
	}
	public String toString(){
		return String.format("°ÆÀ\: %6s  ¼Æ¶q: %2d  ª÷ÃB: %3d", name, number, money() );
	}
}


