public class TicketSell implements Runnable
{
	int num=10;            //车票数量
	public void run(){
	while(true){
		synchronized(" "){
			if(num>0){
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"车票："+--num);
			}
		}
	}
			
}
public static void main(String[] args){
	TicketSell sell=new TicketSell();
	Thread t1=new Thread(sell);
	Thread t2=new Thread(sell);
	Thread t3=new Thread(sell);
	Thread t4=new Thread(sell);
	t1.start();
	t2.start();
	t3.start();
	t4.start();
  }
}

