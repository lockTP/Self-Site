package com.lockTP.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 以固定时间间隔执行任务
 * @author chenguanX
 * @date 2016年8月25日 上午11:47:26
 */
public class PeriodicExecutor implements Runnable {
	AtomicInteger ai;

	public PeriodicExecutor(AtomicInteger ai) {
		super();
		this.ai = ai;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		AtomicInteger ai = new AtomicInteger(1);
		// 启动延迟时间
		long initialDelay1 = 1;
		// 间隔时间
		long period1 = 1;

		// 从现在开始1秒钟之后，每隔1秒钟执行一次job1
		service.scheduleAtFixedRate(new PeriodicExecutor(ai), initialDelay1, period1, TimeUnit.SECONDS);
		
		// 这个关闭方法不会等待之前已经提交的任务执行完成。
		// service.shutdown();
		// 这个方法会阻塞，直到所有任务已完成，或者timeout时间已到，
		boolean done = service.awaitTermination(100, TimeUnit.SECONDS);
		if (!done) {
			service.shutdown();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("execute " + ai.getAndIncrement());
	}

}
