package org.shgbit.log4j2;

import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PackageLog {
	
	
	/**
     * 获取最原始被调用的堆栈信息
     * @return    
     * @author Royal
     * @date 20190307
     */
	
    public static StackTraceElement findCaller() {
        // 获取堆栈信息
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if(null == callStack) return null;

        // 最原始被调用的堆栈信息
        StackTraceElement caller = null;
        // 日志类名称
        String logClassName = PackageLog.class.getName();
        // 循环遍历到日志类标识
        boolean isEachLogClass = false;
        
        // 遍历堆栈信息，获取出最原始被调用的方法信息
        for (StackTraceElement s : callStack) {
            // 遍历到日志类
            if(logClassName.equals(s.getClassName())) {
                isEachLogClass = true;
            }
            // 下一个非日志类的堆栈，就是最原始被调用的方法
            if(isEachLogClass) {
                if(!logClassName.equals(s.getClassName())) {
                    isEachLogClass = false;
                    caller = s;
                    break;
                }
            }
        }
        
        return caller;
    }

    /**
     * 自动匹配请求类名，生成logger对象，此处 logger name 值为 [className].[methodName]() Line: [fileLine]
     * @return    
     * @author Royal
     * @date 20190307
     */
    private static Logger logger() {
        // 最原始被调用的堆栈对象
        StackTraceElement caller = findCaller();
        if(null == caller) return LoggerFactory.getLogger(PackageLog.class);
        
        Logger log = LoggerFactory.getLogger(caller.getClassName() + "." + caller.getMethodName() + "() Line: " + caller.getLineNumber());
        
        return log;
    }

    public static String getTagMsg(String tag) {
    	
    	 Properties properties = new Properties();

    	 InputStreamReader in;
		try {
			in = new InputStreamReader(PackageLog.class.getClassLoader().getResourceAsStream("log.properties"), "UTF-8");
			properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}  

    	 String msg = properties.getProperty(tag);
    	 return msg;
    }
    
    
    public static void debug(String tag,String detail) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(getTagMsg(tag));
    	sb.append("    ");
    	sb.append(detail);
    	logger().debug(sb.toString());
    }
    
    public static void info(String tag,String detail) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(getTagMsg(tag));
    	sb.append("    ");
    	sb.append(detail);
    	logger().info(sb.toString());
    }
    
    public static void warn(String tag,String detail) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(getTagMsg(tag));
    	sb.append("    ");
    	sb.append(detail);
    	logger().warn(sb.toString());
    }
    
    public static void error(String tag,String detail) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(getTagMsg(tag));
    	sb.append("    ");
    	sb.append(detail);
    	logger().error(sb.toString());
    }
}
