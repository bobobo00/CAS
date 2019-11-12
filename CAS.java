package others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换
 * 乐观锁的一种实现。
 * @author dell
 *
 */

public class CAS {
	private static AtomicInteger stock=new AtomicInteger(5);//原子性，效率更高。
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer left=stock.decrementAndGet();
				if(left<1) {
					System.out.println("抢完了");
					return;
				}
				System.out.println(Thread.currentThread().getName()+"抢了一件商品-->还剩"+left);
			}).start();
		}
		
	}

}
