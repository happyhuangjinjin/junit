package sc.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sc.mail.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSendTest {

	@Autowired
	private MailService mailService;

	@Test
	public void sendSimpleMailTest() {
		mailService.sendSimpleMail("515768476@qq.com", "happy.huangjinjin@163.com", 
				"sendSimpleMailTest", "sendSimpleMailTest from 515768476@qq.com");
	}

	@Test
	public void sendTemplateMailTest() {
		String html = "<html><body>"
				+ " <div> "
				+ "    sendTemplateMailTest from 515768476@qq.com </br>"
				+ "    <b>这是模板邮件</b>"
				+ "</div>"
				+ "</body></html>";
		mailService.sendTemplateMail("515768476@qq.com", "happy.huangjinjin@163.com", 
				"sendTemplateMailTest", html);
	}

	@Test
	public void sendAttachmentsMailTest() {
		String filePath = "D:\\springcloudws\\sc-mail\\src\\main\\java\\sc\\mail\\service\\impl\\MailServiceImpl.java";
		mailService.sendAttachmentsMail("515768476@qq.com", "happy.huangjinjin@163.com", 
				"sendAttachmentsMailTest", "sendAttachmentsMailTest from 515768476@qq.com", filePath);
	}
	
	@Test
	public void sendInlineResourceMailTest() {
		String imgId = "img1";
		
		String content = "<html><body>"
				+ "sendInlineResourceMailTest：<img src=\'cid:" + imgId + "\' >"
						+ "</body></html>";
		
		String imgPath = "D:\\springcloudws\\sc-mail\\src\\main\\resources\\20181015223228.jpg";
		
		mailService.sendInlineResourceMail("515768476@qq.com", "happy.huangjinjin@163.com", 
				"sendInlineResourceMailTest", content, imgPath, imgId);
	}

}
