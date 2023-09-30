// 主餐
public class main extends father{
   
           public main(String name,int price){
                       super(name,price);
           } 
           public String toString(){
                return String.format("主餐: %6s  數量: %2d  金額: %3d",name,number,money());
           }
}

