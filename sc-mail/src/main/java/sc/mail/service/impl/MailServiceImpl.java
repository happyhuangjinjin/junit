package sc.mail.service.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import sc.mail.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 文本
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 */
	@Override
	public void sendSimpleMail(String from, String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		try {
			mailSender.send(message);
			logger.info("simple mail had send。");
		} catch (Exception e) {
			logger.error("send mail error", e);
		}
	}

	/**
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendTemplateMail(String from, String to, String subject, String content) {
	    MimeMessage message = mailSender.createMimeMessage();
	    try {
	        //true表示需要创建一个multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);
	        mailSender.send(message);
	        logger.info("send template success");
	    } catch (Exception e) {
	        logger.error("send template eror", e);
	    }
	}
	
	
	/**
	 * 附件
	 * 
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param filePath
	 */
	public void sendAttachmentsMail(String from, String to, String subject, String content, String filePath){
	    MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);
	        FileSystemResource file = new FileSystemResource(new File(filePath));
	        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
	        helper.addAttachment(fileName, file);
	        mailSender.send(message);
	        logger.info("send mail with attach success。");
	    } catch (Exception e) {
	        logger.error("send mail with attach success", e);
	    }
	}
	
	
	/**
	 * 发送内嵌图片
	 * 
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param imgPath
	 * @param imgId
	 */
	public void sendInlineResourceMail(String from, String to, String subject, String content,
			String imgPath, String imgId){
	    MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);
	        FileSystemResource res = new FileSystemResource(new File(imgPath));
	        helper.addInline(imgId, res);
	        mailSender.send(message);
	        logger.info("send inner resources success。");
	    } catch (Exception e) {
	        logger.error("send inner resources fail", e);
	    }
	}

}
