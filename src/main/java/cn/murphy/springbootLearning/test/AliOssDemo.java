package cn.murphy.springbootLearning.test;

import cn.murphy.springbootLearning.service.DemoService;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AliOssDemo {

    private Logger logger = LoggerFactory.getLogger(AliOssDemo.class);

    // Endpoint以北京为例，其它Region请按实际情况填写。
    public final static String ENDPOINT = "http://oss-cn-shenzhen.aliyuncs.com";
    //accessKey
    public final static String ACCESS_KEY_ID = "LTAI4GH4kdpWFr4omnFB3uha";
    //accessKey secret
    public final static String ACCESS_KEY_SECRET = "idBThren71jhUEeAiDxLXO9GdO5gZb";

    //源bucket名
    public final static String SOURCE_BUCKET_NAME = "test-private-chenshubin";
    //目标bucket名
    public final static String TARGET_BUCKET_NAME = "test2-public-chenshubin";

    /**
     * 获得文件列表
     * @return
     */
    public static List<String> listKeys() {
        List<String> keyList = new ArrayList<>();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        // 设置最大个数。
        final int maxKeys = 200;

        String nextMarker = null;
        ObjectListing objectListing;

        do {
            objectListing = ossClient.listObjects(new ListObjectsRequest(SOURCE_BUCKET_NAME).withMarker(nextMarker).withMaxKeys(maxKeys));

            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                keyList.add(s.getKey());
            }
            nextMarker = objectListing.getNextMarker();

        } while (objectListing.isTruncated());

        // 关闭OSSClient。
        ossClient.shutdown();
        return keyList;
    }

    /**
     * 拷贝文件
     * @param keyList
     */
    public static void copyFiles(List<String> keyList) {
        Long startTime = System.currentTimeMillis();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("text/html");
        // 复制文件。
        for (int i = 0; i < keyList.size(); i++) {
            //log.info("开始上传：" + keyList.get(i) + " :第" + (i + 1) + "个文件");

            System.out.println("开始上传：" + keyList.get(i) + " :第" + (i + 1) + "个文件");


            // 创建CopyObjectRequest对象。
            CopyObjectRequest copyObjectRequest = new CopyObjectRequest(SOURCE_BUCKET_NAME, keyList.get(i), TARGET_BUCKET_NAME, keyList.get(i));
            // 设置新的文件元信息。
            copyObjectRequest.setNewObjectMetadata(meta);
            ossClient.copyObject(copyObjectRequest);
            //log.info("上传成功：" + keyList.get(i) + " :第" + (i + 1) + "个文件");
            System.out.println("开始上传：" + keyList.get(i) + " :第" + (i + 1) + "个文件");
        }
    }

    public static void main(String[] args) {
        copyFiles(listKeys());
    }

}
