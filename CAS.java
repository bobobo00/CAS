package others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:�Ƚϲ�����
 * �ֹ�����һ��ʵ�֡�
 * @author dell
 *
 */

public class CAS {
	private static AtomicInteger stock=new AtomicInteger(5);//ԭ���ԣ�Ч�ʸ��ߡ�
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
					System.out.println("������");
					return;
				}
				System.out.println(Thread.currentThread().getName()+"����һ����Ʒ-->��ʣ"+left);
			}).start();
		}
		
	}

}
