import java.util.ArrayList;
public class Setmeal{
	private int priceA = 60;
	private int priceB = 70;
	private int priceC = 70;
	private String name;
	private String food = "";
	private int number = 0 ;
	private father m ;
	private ArrayList <father>Aset = new ArrayList<>();
	private ArrayList <father>Bset = new ArrayList<>();
	private ArrayList <father>Cset = new ArrayList<>();
	
	
	public Setmeal(String name,int type){
		setName(name);
		arrangeMeals(type);
		addOthermeals();
		setwhatinmeal(name);
	}
	public void addOthermeals(){
		Aset.add(maintop.menu[4]);	//A�\
		Aset.add(maintop.menu[3]);
		
		Bset.add(maintop.menu[0]);	//B�\
		Bset.add(maintop.menu[5]);
		Bset.add(maintop.menu[2]);
		
		Cset.add(maintop.menu[7]);	//C�\
		Cset.add(maintop.menu[3]);
	}
	public void setwhatinmeal(String name){

		if (name == "�M�\A"){
			for(father m : Aset){
				food += m.getName() + "x1 ";
			}
			
		}
		if (name == "�M�\B"){
			for(father m : Bset){
				food += m.getName() + "x1 " ;
			}
			
		}
		if (name == "�M�\C"){
			for(father m : Cset){
				food += m.getName() + "x1 ";
			}
			
		}
	
	}		
	public String getwhatinmeal(){
		return food;
	}
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public void arrangeMeals(int type){
		if (type == 0){
			m = maintop.menu[1];
			
			//number++;
		}
		/*if (type == 1){
			m = User.menu[6];
			number++;
		}*/
		if (type == 1){
			m = maintop.menu[8];
			
			//number++;
		}
	}
	public void addNumber(int n){
		number += n;
		}
	public int getNumber(){
		return number;
	}		
	public int getPrice(){
		int sum = 0;
		switch(name){
			case "�M�\A" :
				sum = m.getPrice()+priceA;
				break;
			case "�M�\B" :
				sum = m.getPrice()+priceB;
				break;
			case "�M�\C" :
				sum = m.getPrice()+priceC;
				break;	
		}
		return sum ;
	}
	public static boolean check(Setmeal t,Setmeal s){	/*�P�_�M�\�O�_������,���g�\��Ӥw���T�w�|�Ψ�*/
		if (s.getName() == t.getName() == true && s.m.getName().equals(t.m.getName()) == true ){
			
			return true;
		}
		else{
			return false;
		}
	}
	public void reset(){	/*�~�ե� :)*/
		Aset.clear();
		Bset.clear();
		Cset.clear();
	}
	public void delete(){
		this.number = 0;
	}
	public void removeNumber(int number){
		if (this.number > number){
			this.number -= number;
		}
		else{this.number = 0;}
	}
	public String toString(){
		return String.format(m.getName()+ "+ %s  �ƶq: %d   ���B: %d\n    ���t : %s",getName(),number,getPrice()*number,getwhatinmeal());}
            
	
}



