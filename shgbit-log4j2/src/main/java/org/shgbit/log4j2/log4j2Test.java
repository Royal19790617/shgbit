package org.shgbit.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shgbit.log4j2.PackageLog;

/**
 * Created by Royal on 2019/2/24.
 **/
public class log4j2Test {
	 
    public static void main(String[] args) {
    	/*
        logger.trace("entry"); //开始时调用
        logger.error("Did it again!"); //error级别的信息
        logger.info("我是info信息"); //info级别的信息
        logger.debug("我是debug信息"); //debug级别的信息
        logger.warn("我是warn信息"); //warn级别的信息
        logger.fatal("我是fatal信息"); //fatal级别的信息
        logger.log(Level.DEBUG,"我是debug信息"); //指定Level类型的调用
        logger.trace("exit"); //结束时调用
         */
    	PackageLog.debug("TRACK_MESSAGE_001","我是info信息"); //info级别的信息
    	PackageLog.info("TRACK_MESSAGE_002","我是info信息"); //info级别的信息
    	PackageLog.warn("TRACK_MESSAGE_001","我是info信息"); //info级别的信息
    	PackageLog.error("TRACK_MESSAGE_002","我是info信息"); //info级别的信息
    	

    }
    
}
