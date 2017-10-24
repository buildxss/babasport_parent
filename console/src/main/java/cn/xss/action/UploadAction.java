package cn.xss.action;

import cn.xss.core.dictionary.Constants;
import cn.xss.core.tools.FastDFSTool;
import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传控制器
 *
 * @author Administrator
 */
@Controller
public class UploadAction {

    /**
     * 上传文件
     *
     * @return
     */
    @RequestMapping(value = "/uploadFile.do")
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile mpf) {
        System.out.println(mpf.getOriginalFilename());

        // 将文件上传到分布式文件系统，并返回文件的存储路径及名称
        String uploadFile = null;
        try {
            uploadFile = FastDFSTool.uploadFile(mpf.getBytes(),
                    mpf.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回json格式的字符串（图片的绝对网络存放地址）
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("path", Constants.FDFS_SEVER + uploadFile);
        return hashMap;
    }

}
