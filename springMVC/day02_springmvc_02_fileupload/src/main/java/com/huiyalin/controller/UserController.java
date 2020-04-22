package com.huiyalin.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传....");
        //使用fileupload组件完成上传
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file=new File(path);
        if (!file.exists()){
            //创建该文件夹
            file.mkdirs();
        }
        //解析request对象，获取文件上传项
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
        //解析request
        List<FileItem> items=servletFileUpload.parseRequest(request);
        for (FileItem item:items){
            //进行判断，当前item对象是否是上传文件项
            if (item.isFormField()){
                //说明是普通表单项
            }else {
                //说明是文件上传项，获取文件名
                String filename = item.getName();
                //完成文件上传
                //把文件的名称设置成唯一值,uuid
                String replaceName = UUID.randomUUID().toString().replace("-", "");
                filename=replaceName+"_"+filename;
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springMVC文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springMVC文件上传....");
        //使用fileupload组件完成上传
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file=new File(path);
        if (!file.exists()){
            //创建该文件夹
            file.mkdirs();
        }
                //说明是文件上传项，获取文件名
                String filename = upload.getOriginalFilename();

                //完成文件上传
                //把文件的名称设置成唯一值,uuid
                String replaceName = UUID.randomUUID().toString().replace("-", "");
                filename=replaceName+"_"+filename;
                upload.transferTo(new File(path,filename));
        return "success";
    }
    @RequestMapping("/fileupload3")
    public String fileUpload3( MultipartFile upload1) throws Exception {
        System.out.println("跨服务器文件上传....");
        //定义上传文件服务器路径
        String path="http://localhost:9090/uploads/";
        //说明是文件上传项，获取文件名
        String filename = upload1.getOriginalFilename();
        //完成文件上传
        //把文件的名称设置成唯一值,uuid
        String replaceName = UUID.randomUUID().toString().replace("-", "");
        filename=replaceName+"_"+filename;
        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path+filename);
        //上传文件
        webResource.put(upload1.getBytes());
        return "success";
    }
}
