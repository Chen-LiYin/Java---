public class father{			/*µ¹¥D¡B°Æ¡B¶¼®Æ¡B®MÀ\*/
	protected String name;
	protected int price;
	protected int number = 0 ;
	protected boolean br= true;
	public father(String name,int price){
		 setName(name);
		 setPrice(price);
	}

	public void setNumber(int number){this.number=number;}
           	public int getNumber(){return number;}
	public void setName(String name){this.name=name;}
	public String getName(){return name;}
	public void setPrice(int price){ this.price=price; }
	public int getPrice(){ return price; }
	public void setBreakfast(boolean br){ this.br=br; }
	public boolean getBreakfast(){ return br; }
	public int money(){	return getPrice()*getNumber();}

}
