package com.dagu.ssm.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dagu.ssm.utils.Commons;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request, String fileName, PrintWriter out) {
		// 把Request强转成多部件请求对象
		MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
		// 根据文件名称获取文件对象
		CommonsMultipartFile file = (CommonsMultipartFile) mh.getFile(fileName);
		// 获取文件上传流 (本地不需要)
		byte[] fbytes = file.getBytes();

		// 文件名称在服务器有可能重复？
		String newFileName = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newFileName = sdf.format(new Date());

		Random r = new Random();

		for (int i = 0; i < 3; i++) {
			newFileName = newFileName + r.nextInt(10);
		}

		// 获取原始图片名
		String originalFilename = file.getOriginalFilename();
		// 获取文件扩展名
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

		// 1种.创建jersey服务器，进行跨服务器上传
		Client client = Client.create();
		// 把文件关联到远程服务器
		WebResource resource = client.resource(Commons.PIC_HOST + "/upload/" + newFileName + suffix);
		// 上传
		resource.put(String.class, fbytes);
		
		// 2种.保存在当前应用服务器
		//指定文件存放目录
		/*String path = request.getServletContext().getRealPath("/upload");
		File dir = new File(path);
		if(!dir.exists()) {
			//如果没有就创建目录
			dir.mkdirs();
		}
		//转化CommonsMultipartFile到File
		DiskFileItem fileItem = (DiskFileItem) file.getFileItem();
		File newFile = fileItem.getStoreLocation();
		//保存文件到当前应用服务器
		newFile.renameTo(new File(path,newFileName + suffix));*/

		// ajax回调函数需要会写写什么东西？
		// 图片需要回显：需要图片完整路径
		// 数据库保存图片的相对路径.
		String fullPath = Commons.PIC_HOST + "/upload/" + newFileName + suffix;

		String relativePath = "/upload/" + newFileName + suffix;
		// 返回json格式字符串   {"":"","":""}
		String result = "{\"fullPath\":\"" + fullPath + "\",\"relativePath\":\"" + relativePath + "\"}";

		out.print(result);
		
	}
}
