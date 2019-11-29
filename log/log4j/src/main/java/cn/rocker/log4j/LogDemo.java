package cn.rocker.log4j;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Log4j 日志框架学习
 *
 * @author: chengzc
 * @create: 2019-11-29 14:23
 * @since:
 **/
@Slf4j
public class LogDemo {

    @Test
    public void testLogLevel(){
        log.trace("this is trace");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
    }

}
