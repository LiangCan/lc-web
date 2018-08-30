package com.lc.web.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Liang on 2017/1/6.
 */
public class UploadUtils {
//    private static String SERVICE_URL = "http://192.168.1.120:8080/userIcon/";
//    private static String SERVICE_URL = "";



    public static String  uploadUserIcon(MultipartFile file, Long userId){
        if (file.isEmpty()) {
            return "文件为空";
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        File dest = new File(request.getRealPath("/userIcon/" + userId + ".png")  );

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            // 文件上传路径
            StringBuilder iconUrl = new StringBuilder("");
            iconUrl.append(userId);
            iconUrl.append(".png");
            return iconUrl.toString();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
