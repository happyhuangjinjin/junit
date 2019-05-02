package com.cto51.service;

public interface MailService {

	public void sendText(String from, String to, String subject, String content);
	
	public void sendTemplate(String from, String to, String subject, String content);
	
	public void sendAttachment(String from, String to, String subject, String content, String filePath);
	
	public void sendInlineResource(String from, String to, String subject, String content,
			String imgPath, String imgId);
}
