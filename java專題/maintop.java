import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;   
import java.util.Date;  
import java.util.ArrayList;


public class maintop extends JFrame{

	static ArrayList <Setmeal> choosemeal = new ArrayList<Setmeal>();
        static ArrayList <SetBreakfast> choosebf = new ArrayList<SetBreakfast>();
        static   father[] menu =  readMenuFromCSV("Single_meal.csv");
	music Music=new music();
	maintop(){	
		super();
 		Music.playmusic();
      		this.setSize(new Dimension(600,800));
      		this.setTitle("manu");
     		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      		this.setLocation(200,200);
      		this.setLayout(null);
      		this.getContentPane().setBackground(Color.white);
                JButton button1=new JButton((Morning())?"breakfirst":"主餐");
                JButton button2=new JButton("副餐");
                JButton button3=new JButton("飲料");
                JButton button4=new JButton("購物車");
                class mainaction implements ActionListener {   //主餐事件
                	public void actionPerformed(ActionEvent e){
                          	int number=0;	/*尬意主餐*/
                          	if(Morning()==false){
                                	String types[]={"麥香雞","大麥克"};
                             
                                
					int setmealreply = JOptionPane.showConfirmDialog(null, "主餐需要搭套餐嗎 ? ","系統訊息",JOptionPane.YES_NO_CANCEL_OPTION);
                              		int type=JOptionPane.showOptionDialog(null,"要什麼主餐?","主餐",0,3,null,types,null); 
                         		if (setmealreply == 1){		/*抹尬意套餐*/
				  
						switch(type){
                					case 0:
 								number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
                						menu[1].setNumber(menu[1].getNumber()+number);
                						break;
							case 1:
 								number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
					       			menu[8].setNumber(menu[8].getNumber() + number);
					        		break;
			  	       			case 2:
								break;		
			    
						}
                               		}

                               		if (setmealreply == 0){		/*尬意套餐*/
						String [] taotsan = {"套餐A","套餐B","套餐C"};	
						number = 1;
						int choose = JOptionPane.showOptionDialog(null,"A普通套餐: 薯條(中) 雪碧(小) (價錢:60)\nB薯餅套餐:薯條(小) 薯餅 可樂(小) (價錢:70)\nC吃很堡套餐: 薯條(大) 雪碧(小) (價錢;70)\n\n套餐有以上三項可供選擇","套餐",0,3,null,taotsan,null);
			                	switch(type){
							case 2:
								break;
						}
						int check = 0;
						if(choose !=3 ){
							Setmeal s = new Setmeal(taotsan[choose],type);
							int amount=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							if (amount <= 0){
								JOptionPane.showMessageDialog(null,"輸入錯誤!!","哥 別搞",0);}
							else{	
							s.addNumber(amount);
							for(int i = 0; i<choosemeal.size();i++){
								if ( Setmeal.check(choosemeal.get(i),s) ){
									choosemeal.get(i).addNumber(amount);
									check = 1;
									}
							}							
							if (check == 0){
							choosemeal.add(s);}
								}
                            }
 					}
	                 	
                        	}
                           	else{
					String brtypes[]={"滿福堡"};
                                	int setmealreply = JOptionPane.showConfirmDialog(null, "主餐需要搭套餐嗎 ? ","系統訊息",JOptionPane.YES_NO_CANCEL_OPTION);	
                           		int brtype =JOptionPane.showOptionDialog(null,"要什麼早餐?","早餐",0,3,null,brtypes,null);
					if (setmealreply == 1){		/*抹尬意套餐*/
						number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));	
						menu[6].setNumber(menu[6].getNumber() + number);
			    		}
                             		else if (setmealreply == 0){		/*尬意套餐*/
						String [] taotsan = {"套餐1","套餐2"};	
						number = 1;
						int choose = JOptionPane.showOptionDialog(null,"A 搭配指定飲料: 可樂(小) or 雪碧(小) or 玉米濃湯  (價錢：10)\nB 薯餅配餐: 可樂(小) or 雪碧(小) or 玉米濃湯 + 薯餅 (價錢：30)\n\n套餐有以上兩項可供選擇", "套餐", 0, 3, null, taotsan, null);
						String DrinksTypes[] = {"可樂(小)","雪碧(小)","玉米濃湯"};
						
					 	int drink = JOptionPane.showOptionDialog(null,"要什麼飲料?","飲料", 0,3,null,DrinksTypes,null); 
						switch(drink){
							case 0:
								drink=2;
								break;
							case 1:
								drink=3;
								break;
							case 2:
								drink=9;
								break;
						}
	
						int check=0;
						if(choose == 0){SetBreakfast bf = new SetBreakfast(choose, (main) menu[6], (inliao) menu[drink]);  /*Down-casting*/
							int amount=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							if (amount <= 0){JOptionPane.showMessageDialog(null,"輸入錯誤操","系統訊息",0);}
							else{
								bf.addNumber(amount);
								for(int i=0;i<choosebf.size();i++){
									if( SetBreakfast.check(choosebf.get(i),bf) ){choosebf.get(i).addNumber(amount);
									check = 1;}
									}
									if(check==0){choosebf.add(bf);}
								}
							}
							else if(choose == 1){
								SetBreakfast bf = new SetBreakfast(choose, (main) menu[6], (inliao) menu[drink], (futsan) menu[5]);  /*Down-casting*/
								int amount=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
								if (amount <= 0){JOptionPane.showMessageDialog(null,"輸入錯誤操","系統訊息",0);}
								else{
									bf.addNumber(amount);
									for(int i=0;i<choosebf.size();i++){
										if( SetBreakfast.check(choosebf.get(i),bf) ){choosebf.get(i).addNumber(amount);
											check = 1;}
									}
									if(check==0){choosebf.add(bf);}
								}
							}
				
						}
                        		}     
                 		}	
			}
		
                 	class futsanaction implements ActionListener{
                      		public void actionPerformed(ActionEvent e){
                        		String futsanTypes[]={"薯條(小)","薯條(中)","薯條(大)","薯餅"};
                        		int number = 0;
					int type = JOptionPane.showOptionDialog(null,"要什麼副餐?","副餐",0,3,null,futsanTypes,null);
                      
				
					switch(type){
						case 0:
                                			number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[0].setNumber(menu[0].getNumber() + number);
							break;
						case 1:
                                			number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[4].setNumber(menu[4].getNumber() + number);
							break;
						case 2:
                                			number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[7].setNumber(menu[7].getNumber() + number);
							break;			
						case 3:
                                			number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[5].setNumber(menu[5].getNumber() + number);
							break;		
                                
					}
		     		}
			}
                	class inliaoaction implements ActionListener{
                    		public void actionPerformed(ActionEvent e){
                        		int number = 0;
					String DrinksTypes[] = {"可樂(小)","雪碧(小)","玉米濃湯"};
					int type=JOptionPane.showOptionDialog(null,"要什麼飲料?","飲料",0,3,null,DrinksTypes,null); 
                      	
					switch(type){
						case 0:
							number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[2].setNumber(menu[2].getNumber() + number);
							break;
						case 1:
							number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[3].setNumber(menu[3].getNumber() + number);
							break;
						case 2:
							number=Integer.parseInt(JOptionPane.showInputDialog("要購買多少"));
							menu[9].setNumber(menu[9].getNumber() + number);
							break;
			
					}
                      		}
			}
			class checkaction implements ActionListener{
                     		public void actionPerformed(ActionEvent e){
			
                        		int totalfee=0;
                        		Cart cart=new Cart();
                       			String check =cart.printdetails();
					//System.out.print();
					String checkchoose[] = {"忍痛結帳QQ","再想想 :)","修改"};
					int i = JOptionPane.showOptionDialog(null, "要結帳嗎\n"+check,"購物車",0,3,null,checkchoose,null);
                    
						
                    if(i==0){		
						int j = JOptionPane.showConfirmDialog(null, "有優惠券嗎？","甘屋優惠 輸入代碼:)",JOptionPane.YES_NO_CANCEL_OPTION);
						if(j == 0){		/*優惠代碼*/
							Music.stopmusic();
							String discountcode = JOptionPane.showInputDialog("請輸入優惠碼");
							double finaltotalfee = 0;
							switch(discountcode){
								case "ShihYunbad" :
                        						
                        						finaltotalfee=cart.payment();
	                						finaltotalfee = finaltotalfee * 0.8;
									setVisible(false);
                        						JOptionPane.showMessageDialog(null,check+ "\n總消費： "+(int)finaltotalfee+ " 元","結帳",2);
									break;

								case "YiYounggood" :
                        						//int finaltotalfee = 0;
                        						finaltotalfee=cart.payment();
	                						finaltotalfee = finaltotalfee * 0.5;
									setVisible(false);
                        						JOptionPane.showMessageDialog(null,check+ "\n總消費： "+(int)finaltotalfee+ " 元","結帳",2);
									break;

								case "XinCigood" :
                        						//int finaltotalfee = 0;
                        						finaltotalfee=cart.payment();
	                						finaltotalfee = finaltotalfee * 0.5;
									setVisible(false);
                        						JOptionPane.showMessageDialog(null,check+ "\n總消費： "+(int)finaltotalfee+ " 元","結帳",2);
									break;

								case "LiYingood" :
                        						//int finaltotalfee = 0;
                        						finaltotalfee=cart.payment();
	                						finaltotalfee = finaltotalfee * 0.5;
									setVisible(false);
                        						JOptionPane.showMessageDialog(null,check+ "\n總消費： "+(int)finaltotalfee+ " 元","結帳",2);
									break;
							
								default:
									JOptionPane.showMessageDialog(null,"優惠碼錯誤","結帳",2);
									finaltotalfee = 0;
                        						finaltotalfee=cart.payment();
	                
									setVisible(false);
                        						JOptionPane.showMessageDialog(null,check+ "\n總消費： "+finaltotalfee+ " 元","結帳",2);
									System.exit(0);	
									break;
							}
						}
						else{
							Music.stopmusic();
							int finaltotalfee = 0;
                        				finaltotalfee=cart.payment();
							setVisible(false);
							JOptionPane.showMessageDialog(null,check+ "\n總消費： "+finaltotalfee+ " 元","結帳",2);
							System.exit(0);	
 								}
							
							}
					if (i == 2)	{		/*修改&刪除&全部bang不見*/
							String []setormeal = {"單點","套餐"};
							int choose = JOptionPane.showOptionDialog(null,"要更改單點還是套餐","修改",0,3,null,setormeal,null); 
						if (choose == 0){
							int IDinput = Integer.parseInt(JOptionPane.showInputDialog(null, ""+cart.getcheckstring2(),"輸入序號來進行餐點修改",1)) ;
							String change[] = {"刪除","數量更改"};
							int type=JOptionPane.showOptionDialog(null,"要刪除還是數量更動","修改",0,3,null,change,null); 

							if(type == 0){
								cart.reset(IDinput-1);}
							else{ cart.change(IDinput-1); }	
							//System.out.println(Cart.setfood);
						}
						if (choose == 1){
							int IDinput = Integer.parseInt(JOptionPane.showInputDialog(null, ""+cart.getcheckstring1(),"輸入序號來進行餐點修改",1));	
								String change[] = {"刪除","數量更改"};
								int type = JOptionPane.showOptionDialog(null,"要刪除還是數量更動","修改",0,3,null,change,null);
								
								if(type == 1){
									
									int amount = Integer.parseInt(JOptionPane.showInputDialog(null, "要少吃多少 ?","輸入序號來進行餐點修改",1));
									if(Morning()==true){
									choosebf.get(IDinput-1).removeNumber(amount);}
                                                                        else{
									choosemeal.get(IDinput-1).removeNumber(amount);}
										}
								else{
                                                                        if(Morning()==true){
									choosebf.get(IDinput-1).delete();}
                                                                        else{
									choosemeal.get(IDinput-1).delete();}
									}
								

						}
						
					}	
				}
            }
			
                //菜單內容(圖示)
               	JLabel type1=new JLabel("主餐");
               	type1.setBounds(40,-50,200,200);
               	this.add(type1);
               	ImageIcon img1= new ImageIcon("image/1.jpg");
       		JLabel label1=new JLabel(menu[1].getName()+" "+menu[1].getPrice()+"元",img1,SwingConstants.LEFT);
		label1.setBounds(20,20,200,200);
		
		ImageIcon img6= new ImageIcon("image/6.jpg");
		JLabel label6=new JLabel( menu[6].getName()+" "+menu[6].getPrice()+"元",img6,SwingConstants.LEFT);
		label6.setBounds(20,20,200,200);
		
        	ImageIcon img8= new ImageIcon("image/8.jpg");
		JLabel label8=new JLabel(menu[8].getName()+" "+menu[8].getPrice()+"元",img8,SwingConstants.LEFT);
		label8.setBounds(20,140,200,200);
		
                if(Morning()==false) {
			this.add(label1);
			this.add(label8);
                }
                else if(Morning()==true){
			this.add(label6);
                }


                JLabel type2=new JLabel("副餐");
                type2.setBounds(220,-50,200,200);
                this.add(type2);
		
		ImageIcon img0= new ImageIcon("image/0.jpg");

		JLabel label0=new JLabel(menu[0].getName()+" "+menu[0].getPrice()+"元",img0,0);
		label0.setBounds(180,20,200,200);
		this.add(label0);

		ImageIcon img4= new ImageIcon("image/4.jpg");

		JLabel label4=new JLabel( menu[4].getName()+" "+menu[4].getPrice()+"元",img4,SwingConstants.CENTER);
		label4.setBounds(180,140,200,200);
		this.add(label4);

		ImageIcon img7= new ImageIcon("image/7.jpg");

		JLabel label7=new JLabel( menu[7].getName()+" "+menu[7].getPrice()+"元",img7,SwingConstants.CENTER);
		label7.setBounds(180,260,200,200);
		this.add(label7);

		ImageIcon img5= new ImageIcon("image/5.jpg");

		JLabel label5=new JLabel( menu[5].getName()+" "+menu[5].getPrice()+"元",img5,0);
		label5.setBounds(180,380,200,200);
		this.add(label5);

                JLabel type3=new JLabel("飲料");
                type3.setBounds(400,-50,200,200);
                this.add(type3);
		
		ImageIcon img2= new ImageIcon("image/2.jpg");

		JLabel label2=new JLabel( menu[2].getName()+" "+menu[2].getPrice()+"元",img2,SwingConstants.RIGHT);
		label2.setBounds(340,20,200,200);
		this.add(label2);

		ImageIcon img3= new ImageIcon("image/3.jpg");

		JLabel label3=new JLabel( menu[3].getName()+" "+menu[3].getPrice()+"元",img3,SwingConstants.RIGHT);
		label3.setBounds(340,140,200,200);
		this.add(label3);

		ImageIcon img9= new ImageIcon("image/9.jpg");

		JLabel label9=new JLabel( menu[9].getName()+" "+menu[9].getPrice()+"元",img9,SwingConstants.RIGHT);
		label9.setBounds(340,260,200,200);
		this.add(label9);
		//怪怪的
		JLabel label10=new JLabel( " ",4);
		label10.setBounds(300,60,100,50);
		this.add(label10);

                //按鈕
                this.getContentPane().add(button1,null);
                button1.setBounds(new Rectangle(40,600,100,27));
                button1.addActionListener(new mainaction());
                this.getContentPane().add(button2,null);
                button2.setBounds(new Rectangle(160,600,100,27));
                button2.addActionListener(new futsanaction());
                this.getContentPane().add(button3,null);
                button3.setBounds(new Rectangle(280,600,100,27));
                button3.addActionListener(new inliaoaction());
                this.getContentPane().add(button4,null);
                button4.setBounds(new Rectangle(400,600,100,27));
                button4.addActionListener(new checkaction());



        this.setVisible(true);
     }
     public static void main(String[] args){ 
	
          new maintop();
     }
 	// 讀取CSV方法
	private static father[] readMenuFromCSV(String fileName) {
        	father[] menu = new father[10];
		father meal;
       		Path pathToFile = Paths.get(fileName);
		int count=0;

        		// create an instance of BufferedReader
        		// using try with resource, Java 7 feature to close resources
       		 try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
			br.readLine();
           			 // read the first line from the text file
            			String line = br.readLine();
			 // loop until all lines are read
            			while (line != null) {
		
                			// use string.split to load a string array with the values from each line of the file, using a comma as the delimiter
              			  String[] attributes = line.split(",");
			if(attributes[3].contains("主餐")){
               					 meal = new main(attributes[0]+"號"+attributes[1],Integer.parseInt(attributes[2]));
			}else if(attributes[3].contains("副餐")){
					meal = new futsan(attributes[0]+"號"+attributes[1],Integer.parseInt(attributes[2]));
			}else{	
					meal = new inliao(attributes[0]+"號"+attributes[1],Integer.parseInt(attributes[2]));
			}
              			  // adding book into ArrayList
			menu[count] = meal;
                			count++;

               			 // read next line before looping
                			// if end of file reached, line would be null
                			line = br.readLine();
			}
          			  

			} catch (IOException ioe) {
           		 ioe.printStackTrace();
       		 }
        	return menu;
   	 }
         //讀取系統時間
	public static String getTime_1(){   
        
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );   
		Date currentTime = new Date();
		String timeStr = formatter.format(currentTime); 
		return    timeStr;
	}
	//判斷目前是否為早餐時段
   	public static boolean Morning() {   
		String Now = getTime_1(); 
		String time= Now.split(" ")[1];
		int h = Integer.parseInt( time.split(":")[0]);
		int m = Integer.parseInt( time.split(":")[1]);
		boolean mor;

		if(h<10 ||(h==10 && m <= 30)){
			mor=true;
		}else{
			mor=false;				
 		}
	return mor;
	}
			
}