package com.chenguanx.concurrent;


import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * （1）读写锁的优势只有在多读少写、代码段运行时间长这两个条件下才会效率达到最大化；
 * （2）任何公共数据的修改都必须在锁里面完成；
 * （3）读写锁有自己的应用场所，选择合适的应用环境十分重要；
 * （4）编写读写锁很容易出错，朋友们应该多加练习；
 * （5）读锁和写锁一定要分开使用，否则达不到效果。
 * @author Administrator
 * @date 2016年8月22日 下午4:26:34
 */
public class ReadWriteLockTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Data data = new Data();
		
		for(int i=0;i<3;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<5;j++){
						data.get();
					}
				}
				
			}).start();
		}
		for(int i=0;i<3;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<1;j++){
						data.set(new Random().nextInt(30));
					}
				}
				
			}).start();
		}
		
		
	}

}
/**
 * 
 * @author Administrator
 * @version
 *     1.0,2016年8月21日 下午6:51:58
 */
class Data{
	private int data;//共享数据
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public void set(int data){
		rwl.writeLock().lock();//get write lock
		try{
			System.out.println(Thread.currentThread().getName()+"准备写入数据");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.data = data;
			System.out.println(Thread.currentThread().getName()+"写入" + data);
		} finally{
			rwl.writeLock().unlock();
		}
	}
	
	public void get(){
		rwl.readLock().lock();//get read lock
		try{
			System.out.println(Thread.currentThread().getName()+"准备读取数据");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+"读取" + data);
		} finally{
			rwl.readLock().unlock();
		}
	}
}
