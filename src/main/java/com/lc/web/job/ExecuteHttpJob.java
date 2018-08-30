package com.lc.web.job;//package com.xinjihua.lock.job;
//
//import LogUtils;
//import com.xinjihua.lock.mongoDB.MoTimingHttpTaskRepository;
//import com.xinjihua.lock.pojo.TimingHttpTask;
//import com.xinjihua.lock.service.TaskService;
//import ExecutorUtils;
//import PoolHttpClientUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
///**
// * 执行任务
// */
//@Component
//public class ExecuteHttpJob {
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    MoTimingHttpTaskRepository timingHttpTaskRepository;
////    /**
////     * 执行固定任务
////     */
////    @Scheduled(fixedRate = 5000)
////    public void timingJob() {
////        dateFormat.format(new Date());
////        System.out.println("现在时间" + System.currentTimeMillis());
////    }
//    Long count = 0L;
//    /**
//     * 执行倒计时任务
//     */
//    @Scheduled(fixedRate = 5000)
//    public void countdownJob() {
//        List<TimingHttpTask>  tasks = taskService.queryTask((short)2, (short)1);
//        LogUtils.info(count++ + " 次执行任务 ");
//        for(TimingHttpTask timingHttpTask : tasks){
//            timingHttpTask.setCountdown(timingHttpTask.getReqDate());
//            timingHttpTaskRepository.save(timingHttpTask);
//            taskService.updateTaskStatus((short) 2, timingHttpTask.getTaskId());
//        }
//    }
//
//    @Scheduled(initialDelay = 5000, fixedRate = 1000)
//    public void runHandeling(){
//        List<TimingHttpTask> jobs = timingHttpTaskRepository.findAll();
//        if(jobs == null || jobs.size() < 1){
//            LogUtils.info( "当前没有任务");
//            return ;
//        }
//        LogUtils.info( "当前有："+ jobs.size() +" 个任务");
//
//        for(TimingHttpTask timingHttpTask : jobs){
//            //判断是否需要执行
//            if(timingHttpTask.getCountdown() == 0){
//                //判断是否循环
//                if(timingHttpTask.isCycle()){
//                    //重置倒计时
//                    timingHttpTask.setCountdown(timingHttpTask.getReqDate());
//                    timingHttpTaskRepository.save(timingHttpTask);
//                }else{
//                    //从任务队列里面删除该任务
//                    timingHttpTaskRepository.delete(timingHttpTask.getTaskId());
//                    //修改数据库状态
//                    taskService.updateTaskStatus((short) 9, timingHttpTask.getTaskId());
//                }
//                //发送
//                request(timingHttpTask);
//            }else{
//                //时间减1
//                timingHttpTask.setCountdown(timingHttpTask.getCountdown() - 1);
//                //重新赋值进去
//                timingHttpTaskRepository.save(timingHttpTask);
//            }
//        }
//
//    }
//
//    //发送
//    public void request(TimingHttpTask timingHttpTask){
//        ExecutorUtils.cachedThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                PoolHttpClientUtils.post(timingHttpTask.getReqUrl(), timingHttpTask.getReqData());
//            }
//        });
//    }
//
//
//
//
//
//}
