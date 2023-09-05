package com.sea.weed.scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestScheduler {
    
    // cron 초 분 시 일 월 년
    // @Scheduled(cron="0/10 * * * * *") // 10초마다
    // @Async //비동기
    // public void testCron(){
    //     log.info("TestScheduler :: LOGGING");
    // }

}
