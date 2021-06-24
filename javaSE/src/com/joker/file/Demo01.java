package com.joker.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

/**
 * File 类的使用
 *
 * @author joker_chen
 */
public class Demo01 {
    public static void main(String[] args) throws Exception{
//        separator();
//        fileOperation();
        directoryOperation();
    }
    //分隔符

    public static void separator(){
        System.out.println("路径分隔符" + File.pathSeparator );
        System.out.println("名称分隔符" + File.separator);
    }
//文件操作
    public static void fileOperation() throws Exception{
        //创建文件 file.createNewFile()
        File file = new File("D:\\2021java学习文件\\mdFile\\File_text.txt");//创建了文件对象，但实际上没有文件
        if (!file.exists()){//如果文件不存在，就创建
            boolean b = file.createNewFile();//如果文件已经存在，就会返回false，并不创建文件
            System.out.println("result: " + b);
        }

        //删除文件
        //2.1 直接删除
//        System.out.println("delete result: " + file.delete());
        //2.2 使用jvm退出时删除
//        file.deleteOnExit();
//        Thread.sleep(5000);

        //获取文件信息
        System.out.println("获取文件绝对路径：" + file.getAbsolutePath());
        System.out.println("获取路径" + file.getPath());//写什么路径就是什么路径
        System.out.println("获取文件名称"+ file.getName());
        System.out.println("获取父目录" + file.getParent());
        System.out.println("获取文件长度" + file.length());
        System.out.println("文件创建时间" + new Date(file.lastModified()));//本来是long 的时间，转换成date

        //判断
        System.out.println("是否可写：" + file.canWrite());
        System.out.println("是否是文件" + file.isFile());
        System.out.println("是否隐藏" + file.isHidden());
    }
//文件夹操作
    public static void directoryOperation() throws Exception{
        //1 创建文件夹
        File dir = new File("d:\\aaa\\bbb\\ccc");
        if (! dir.exists()){
            //dir.mkder() //只能创建单级目录
            System.out.println("创建结果： "+dir.mkdirs());//创建多级目录
        }

        //2 删除
        //2.1 直接删除
//        System.out.println("删除结果： " + dir.delete());//只能删除最底层的目录，且只能删除空目录
        //2.2 使用jvm删除
//        dir.deleteOnExit();
//        Thread.sleep(5000);//只是为了能够看见删除的过程，过5s之后再删除

        //3 获取文件夹信息
        System.out.println("获取绝对路径：" + dir.getAbsolutePath());
        System.out.println("获取路径" + dir.getPath());//写的什么路径就是什么路径
        System.out.println("获取文件名称 " + dir.getName());//获取最底层的文件名称
        System.out.println("获取父目录 " + dir.getParent());
        System.out.println("获取创建时间 " + new Date(dir.lastModified()).toLocaleString());

        //4 判断
        System.out.println("是否是文件夹"+dir.isDirectory());
        System.out.println("是否是隐藏" + dir.isHidden());

        //5 遍历文件夹
        System.out.println("============");
        File dir2 = new File("D:\\2021java学习文件\\learnphoto");

        String[] list = dir2.list();//可以用list() 方法，返回一个字符串数组，也可以用ListFiles() 方法，返回一个File数组
        for (String str :
                list) {
            System.out.println(str);
        }

//        File[] dir3 = dir2.listFiles();
//        for (File file :
//                dir3) {
//            System.out.println(file.getName());
//        }

        //FileFilter 的使用
        System.out.println("============FileFilter==========");

        File dir4 = new File("E:\\精选image");
        File[] files = dir4.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith(".png"))
                    return true;
                return false;//false,就是默认所有的都不接受
            }
        });
        for (File file:
             files) {
            System.out.println(file.getName());
        }
    }
}
