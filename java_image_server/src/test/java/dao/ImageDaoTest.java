package dao;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ImageDaoTest {

    @Test
    public void insert() {
        //图片有属性进行测试
        Image image=new Image();
        image.setImageName("03演示图片.jpg");
        image.setSize(1416260) ;
        image.setUploadTime("20200604");
        image.setContentType(" image/jpeg") ;
        image.setPath("./image/d54c32d23621fb9ba448c71f1996c871");
        image.setMd5("d54c32d23621fb9ba448c71f1996c871");
        ImageDao imageDao=new ImageDao();
        imageDao.insert(image);
        //图片为空测试
        Image i2=new Image();
        imageDao.insert(i2);
    }

    @Test
    public void selectAll() {
        ImageDao imageDao=new ImageDao();
        List<Image> list=imageDao.selectAll();
        for(Image image:list){
            System.out.println(image.getImageName());
        }
    }

    @Test
    public void selectOne() {
        ImageDao imageDao=new ImageDao();
        //id存在
        Image image1=imageDao.selectOne(113);
        System.out.println(image1.getImageName());
        //id不存在(报错--空指针异常)
        //Image image2=imageDao.selectOne(1);
        //System.out.println(image2.getImageName());
    }

    @Test
    public void delete() {
        ImageDao imageDao=new ImageDao();
        //id存在
        imageDao.delete(113);
        //删除不存在的id（报错）
        //imageDao.delete(1);
    }

    @Test
    public void selectByMd5() {
        ImageDao imageDao=new ImageDao();
        //md5存在
       Image image=imageDao.selectByMd5("d54c32d23621fb9ba448c71f1996c871");
        //Image image2=imageDao.selectByMd5("4c32d23621fb9ba448c71f1996c871");
        //md5不存在（报错）
        System.out.println(image.getImageName()+image.getImageId());
       // System.out.println(image2.getImageName()+image2.getImageId());
    }
}