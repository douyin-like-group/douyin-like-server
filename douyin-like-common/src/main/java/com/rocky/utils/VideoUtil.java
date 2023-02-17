//package com.rocky.utils;
//
//import cn.hutool.core.io.FileUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.bytedeco.javacv.FFmpegFrameGrabber;
//import org.bytedeco.javacv.Frame;
//import org.bytedeco.javacv.Java2DFrameConverter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 视频工具类
// *
// * @Author:
// * @Date:
// */
//@Slf4j
//@Component
//public class VideoUtil {
//    private static final Logger LOGGER = LoggerFactory.getLogger(VideoUtil.class);
//
//
//    /**
//     * 通过Javacv的方式获取视频截图
//     *
//     * @param deviceFile 视频文件路径
//     * @return Map<String, Object>
//     */
//
//    public static Map<String, Object> getScreenshot(File deviceFile) {
//        try {
//            LOGGER.debug("截取视频截图开始：" + System.currentTimeMillis());
//            Map<String, Object> result = new HashMap<String, Object>();
//            FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(deviceFile);
//
//            String fileName = FileUtil.getName(deviceFile);
//            String absolutePath = FileUtil.getAbsolutePath(deviceFile);
//
////            // 第一帧图片存储位置
//            String targerFilePath = absolutePath.substring(0, absolutePath.lastIndexOf("\\"));
////            // 视频文件名
////            String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
//            // 图片名称
//            String targetFileName = fileName.substring(0, fileName.lastIndexOf("."));
////            LOGGER.debug("视频路径是：" + targerFilePath);
////            LOGGER.debug("视频文件名：" + fileName);
//            LOGGER.debug("图片名称是：" + targetFileName);
//
//            grabber.start();
//            //设置视频截取帧（默认取第一帧）
//            Frame frame = grabber.grabImage();
//            int i = 0;
//            int length = grabber.getLengthInFrames();
//            Frame f = null;
//            while (i < length) {
//                // 过滤前300帧，避免出现全黑的图片，依自己情况而定
////             f = grabber.grabFrame();
//                f = grabber.grabImage();
//                if ((i > 1) && (f.image != null)) {
//                    break;
//                }
//                i++;
//            }
//
//
//
//            Java2DFrameConverter converter = new Java2DFrameConverter();
//            //绘制图片
//            BufferedImage bi = converter.getBufferedImage(f);
//
//            //图片的类型
//            String imageMat = "jpg";
//            //图片的完整路径
//            String imagePath = targerFilePath+ File.separator + targetFileName + "." + imageMat;
//            //创建文件
//            File output = new File(imagePath);
//            ImageIO.write(bi, imageMat, output);
//            // todo
//            //这里如何关闭数据流
//
////            //拼接Map信息
////            result.put("videoWide", bi.getWidth());
////            result.put("videoHigh", bi.getHeight());
////            long duration = grabber.getLengthInTime() / (1000 * 1000);
////            result.put("rotate", StringUtils.isBlank(rotate) ? "0" : rotate);
////            result.put("format", grabber.getFormat());
//            result.put("imgPath", output.getPath());
////            result.put("time", duration);
////            LOGGER.debug("视频的宽:" + bi.getWidth());
////            LOGGER.debug("视频的高:" + bi.getHeight());
////            LOGGER.debug("视频的旋转度：" + rotate);
////            LOGGER.debug("视频的格式：" + grabber.getFormat());
////            LOGGER.debug("此视频时长（s/秒）：" + duration);
//            grabber.stop();
//            LOGGER.debug("截取视频截图结束：" + System.currentTimeMillis());
//            return result;
//        } catch (Exception e) {
////            LOGGER.error("VideoUtil getScreenshot fail: {}", ExceptionStackTrace.printStackTrace(e));
//            return null;
//        }
//    }
//}
