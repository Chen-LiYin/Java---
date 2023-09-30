import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Cart{
	private ArrayList <father> food = new ArrayList<>();
	private ArrayList <Setmeal> setfood = new ArrayList<>(maintop.choosemeal);
	private ArrayList<SetBreakfast> setbf = new ArrayList<>(maintop.choosebf);
	private String checkstring1 = "" ;
	private String checkstring2 = "" ;
	
	private String temp = "" ;
	private ArrayList <Object>id = new ArrayList<>();
	//private ArrayList cartio = new ArrayList();
	public Cart(){
		cartdata();
	}
	public void cartdata(){
		for (father m : maintop.menu){
			if (m.getNumber() != 0){
				food.add(m);
			}
		}
	}
	
	public int payment(){
		int sumforsetfood = 0;
		int sumforfood = 0;
		int sumforsetbf = 0;
		for (Setmeal s : setfood){
			sumforsetfood += s.getPrice()*s.getNumber();
		}
		for (father m : food){
			
			sumforfood += m.getPrice()*m.getNumber();
		}
		for (SetBreakfast bf :  setbf){
			
			sumforsetbf += bf.getPrice()*bf.getNumber();
		}
		return sumforfood+sumforsetfood+sumforsetbf ;
	}
	public String printdetails(){
		if (setfood != null & food != null){
			int i = 1;
			checkstring1 += "<<<�M�\>>>\n";
			for(Setmeal s : setfood){
				if(s.getNumber() != 0){
					checkstring1 += "�Ǹ�"+i+": "+"�M�\�G"+ s +"\n";}
					i++;
			}
			for(SetBreakfast bf :  setbf){
				if (bf.getNumber() != 0){
					checkstring1 += "�Ǹ�"+i+": "+bf +"\n";}
					i++;
			}
			checkstring2 += "<<<���I>>>\n";
			for(father m : food){
				checkstring2 += "�\�I�G" + m.getName() + " ����G" + m.getPrice()*m.getNumber() + " ����"+m.getNumber()+"\n";
			}
		}
		return checkstring1 +"\n\n"+ checkstring2 +"\n\n\n"+"�ʪ����`���B :"+ payment();
	}
	public String getcheckstring1(){
		return checkstring1;
	}
	public String getcheckstring2(){
		return checkstring2;
	}
	public void resetall(){
		food.clear();
		setfood.clear();
		setbf.clear();
		checkstring1 = "";
		checkstring2 = "";
	}
	/*public String cartID(){		
		//String temp = "";
		//ArrayList <Object>id = new ArrayList<>();
		for (Setmeal s : setfood){
			
			id.add(s);
		}
		for (SetBreakfast bf : setbf){
			//temp += setbf.indexOf(bf) +""+ bf +"\n";
			id.add(bf);
		}
		
		for (father m : food){
			
			id.add(m);
		}
		for(Object i : id){
			temp += id.indexOf(i)+1 +":"+ i + "\n" ;
		}
		return temp ;
	}*/
	/*public void change(int IDinput){	
		String [] movement = {"��ּƶq","�R���ҿ�"};
		int choose = JOptionPane.showOptionDialog(null,"�z�w���"+id.get(IDinput-1)+"\n�n�i�椰��ʧ@�O?","�t�ΰT��",0,1,null,movement,null);
		switch(choose){
			case 0 :
				int amount = Integer.parseInt(JOptionPane.showInputDialog(null,"�n��֦h�֩O?","�t�ΰT��",1));
				/*if (id.get(IDinput-1).getNumber() > amount){
					id.get(IDinput-1).setNumber(amount);
				}
				
				break;
			case 1 :
				id.get(IDinput-1).setNumber(0);
				JOptionPane.showMessageDialog(null,"�w�R��","�t�ΰT��",0);
				break;
			
		}	
		System.out.println(id);
	}*/
	public void reset(int IDinput){
		maintop.menu[IDinput].setNumber(0);
	}
	public void change(int IDinput){	/*�����I����k*/
		int amount = Integer.parseInt(JOptionPane.showInputDialog(null,"�n�֦Y�h��?","�t�ΰT��",3));
		if (maintop.menu[IDinput].getNumber() > amount){
			maintop.menu[IDinput].setNumber(maintop.menu[IDinput].getNumber() - amount);
		}
		else {maintop.menu[IDinput].setNumber(0);}
		
	}

	
}