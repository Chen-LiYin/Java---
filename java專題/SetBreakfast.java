import java.util.ArrayList;
public class SetBreakfast{
	private String name;
	private inliao drink;
	private main meal;
	private futsan addition;
	private int no;                        /*甅繺絪腹(1)穎皌﹚都   (2)力绘皌繺 */
	private int number=0;
	
	public SetBreakfast(int no, main meal, inliao drink, futsan addition){
		setNo(no);
		setName();
		setMain(meal);
		setInliao(drink);
		setFutsan(addition);
	}
	public SetBreakfast(int no, main meal, inliao drink){
		setNo(no);
		setName();
		setMain(meal);
		setInliao(drink);
	}

	public void setName(){
		switch(no){
			case 0:
			 	this.name = "﹚都";
				break;
			case 1:
			 	this.name = "力绘皌繺";
				break;	
		}
	}

	public String getName(){ return name;}
	public void setMain(main meal){ this.meal = meal;}	
	public main getMain(){ return meal;}
	public void setFutsan(futsan addition){ this.addition = addition;}	
	public futsan getFutsan(){ return addition;}
	public void setInliao(inliao drink){ this.drink = drink;}	
	public inliao getInliao(){ return drink;}
	public void setNo(int no){this.no =no;}
	public int getNo(){return no;}

	public void addNumber(int number){this.number += number;}
	public int getNumber(){return number;}

	public void removeNumber(int number){
		if (this.number > number){
			this.number -= number;
		}
		else{this.number = 0;}
	}
	public void delete(){
		this.number = 0;
	}
	
	public int getPrice(){
		int sum=0;
		switch(no){
			case 0:
				sum = meal.getPrice() + 10 ;
				break;
			case 1:
				sum = meal.getPrice() + 30 ;
				break;	
		}
		return sum;
	}
	public static boolean check(SetBreakfast o,SetBreakfast n){	/*耞甅繺琌Τ狡*/
		if ( (o.getNo() == n.getNo()) && o.getInliao().getName().equals(n.getInliao().getName()) == true  ){
			
			return true;
		}
		else{
			return false;
		}
	}

	public String toString(){
		String s="";
		if(no==0){
			s = String.format( "%s  穎皌%s   计秖:%2d  肂:%d\n ず:%3s %5s", meal.getName(), getName(), getNumber(),getPrice()*getNumber(), meal.getName(), 
			drink.getName());
		}else{
			s = String.format( "%s  穎皌%s   计秖:%2d  肂:%d\n ず:%3s %5s %4s", meal.getName(), getName(), getNumber(),getPrice()*getNumber(), meal.getName(), 
			drink.getName(), addition.getName());}
	return s;	
	}		
}



