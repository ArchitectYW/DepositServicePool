package com.yewei.service.scheduled;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("myScheduleImplService")
@Configurable
@EnableScheduling
@EnableAsync //1.加这两个注解，可以使任务并行处理
public class MyScheduleImplService implements MyScheduled{

	@Override
	@Scheduled(cron = "0 1 *  * * ? ")
	@Async   //2.加这两个注解，可以使任务并行处理
	public void doSchedule() {
		// TODO Auto-generated method stub
		System.out.println("定时任务1执行了");
		System.out.println("===========1=>");
        try {
            for(int i=1;i<=10;i++){
                System.out.println("=1==>"+i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
	@Scheduled(cron = "0 1 *  * * ? ")
	@Async //2.加这两个注解，可以使任务并行处理
	public void doSchedule2() {
		// TODO Auto-generated method stub
		System.out.println("定时任务2执行了");
		for(int i=1;i<=10;i++){
            System.out.println("=2==>"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}
