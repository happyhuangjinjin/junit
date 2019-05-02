package com.cto51;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
	
	@Autowired
	private MailService mailService;
	
	@Test
	public void sendTextTest(){
		mailService.sendText("515768476@qq.com", 
				"414679493@qq.com", 
				"普通文本邮件", 
				"普通邮件来自 515768476@qq.com");
	}

	
	@Test
	public void sendTemplateMailTest() {
		String html = "<html><body>"
				+ " <div> "
				+ "     mail from 515768476@qq.com </br>"
				+ "    <b>这是模板邮件</b>"
				+ "    <b>猪年快乐，诸事顺利！</b>"
				+ "</div>"
				+ "</body></html>";
		mailService.sendTemplate("515768476@qq.com", "414679493@qq.com", 
				"模板邮件", html);
	}
	
	@Test
	public void sendAttachmentTest() {
		String filePath = "D:\\sw51cto\\cto51-lesson14\\src\\test\\java\\com\\cto51\\MailServiceTest.java";
		mailService.sendAttachment("515768476@qq.com", "414679493@qq.com", 
				"发送附件", "Attachments from 515768476@qq.com", filePath);
	}
	
	@Test
	public void sendInlineResourceTest() {
		//图片id
		String imgId = "img1";
		String content = "<html><body>"
				+ "内嵌图片邮件其实也是一封模板邮件 </br>"
				+ "内嵌图片：<img src=\'cid:" + imgId + "\' >"
						+ "</body></html>";
		String imgPath = "D:\\sw51cto\\cto51-lesson14\\dice.jpg";
		mailService.sendInlineResource("515768476@qq.com", "414679493@qq.com", 
				"发送内嵌图片资源邮件", content, imgPath, imgId);
	}
}
