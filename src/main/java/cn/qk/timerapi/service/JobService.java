package cn.qk.timerapi.service;

import cn.qk.timerapi.util.MongoConstants;
import cn.qk.timerapi.util.TimerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Configurable
@EnableScheduling
public class JobService extends TimerUtil {
    private static Logger logger = Logger.getLogger(JobService.class);

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(cron = "0 0 8 * * ?") //每分钟执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeByMin() {
//        executeMinByTime();
        System.out.println("你好");
    }
}