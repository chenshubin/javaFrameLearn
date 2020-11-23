package cn.murphy.springbootLearning.test;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileFilter;

public class Rename {

    public static void main(String[] args) {
        File file = new File("F:\\BaiduNetdiskDownload\\架构视频");
        if(file.exists() && file.isDirectory()){
            File[] listFiles = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.getName().contains("每特教育")){
                        return true;
                    }
                    return false;
                }
            });

            for(File dir :  listFiles){
                System.out.println(dir.getName());
                File[] vedios = dir.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        if(pathname.getName().contains("第")){
                            return true;
                        }
                        return false;
                    }
                });

                for(File vedio : vedios){
                    System.out.println(vedio.getName());
                    String name = vedio.getName();
                    String numChina = StringUtils.substring(name ,name.indexOf("第")+1,name.indexOf("节")-name.indexOf("第"));
                    int i = ChineseNumberUtil.numberCN2Arab(numChina);
                    System.out.println(i+"-"+name);
                    System.out.println(dir.getAbsolutePath()+"\\"+i+"-"+name);
                    File newFile = new File(dir.getAbsolutePath()+"\\"+i+"-"+name);
                    vedio.renameTo(newFile);




                }



            }


        }
    }

}
