package cn.lh.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/14
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class PageUtil {
    public static String uploadAnnex(HttpServletRequest request, CommonsMultipartFile file,String model,String model2){
//             得到文件名称
        String path = request.getSession().getServletContext().getRealPath("/upload/"+model+"/");
        System.out.println(path);
        String orginalFilename = file.getOriginalFilename();
        String suffix = orginalFilename.substring(orginalFilename.indexOf("."),orginalFilename.length());
        String fileName = model2+suffix;
        try{
//            存储到电脑中
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path+fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  path+fileName;
    }
    public static void downloadFile(String filePath, HttpServletResponse response) throws IOException {
        response.reset();
        String fileName = getFileNameByFilePath(filePath);
        String mimeType = URLConnection.guessContentTypeFromName(fileName);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(FileUtils.readFileToByteArray(new File(filePath)));
        outputStream.flush();
        outputStream.close();
    }

    public static String getFileNameByFilePath(String filepath){
        String string[] = filepath.split("\\\\");
        return string[string.length-1];
    }
}
