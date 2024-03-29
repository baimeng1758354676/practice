package com.bm.task.center.util;

public class Constant {
    /**
     * 用来查询未来？分钟内即将执行的任务
     */
    public static final Integer TASK_TIME_LIMITED = 120;
    public static final long TASK_TIME_LIMITED_IN_MILLIS = TASK_TIME_LIMITED * 60 * 1000;

    /**
     * 未放入内存状态码
     */
    public static final Integer TASK_STATUS_NOT_PUT = 0;

    /**
     * 已放入内存
     */
    public static final Integer TASK_STATUS_PUT = 1;

    /**
     * 执行失败
     */
    public static final Integer TASK_STATUS_EXECUTED_FAILED = 2;

    /**
     * 执行成功
     */
    public static final Integer TASK_STATUS_EXECUTED_SUCCESS = 3;

    public static final String METHOD_GET = "GET";

    public static final String METHOD_POST = "POST";

    public static final int STATUS_SUCCESS = 200;

    public static final int REQUEST_TIME = 3;

    /**
     * 任务队列初始化容量
     */
    public static final int QUEUE_INITIAL_CAPACITY = 10;


}
