package sc.mail.service;

public interface MailService {

	public void sendSimpleMail(String from, String to, String subject, String content);
	
	public void sendTemplateMail(String from, String to, String subject, String content);
	
	public void sendAttachmentsMail(String from, String to, String subject, String content, String filePath);
	
	public void sendInlineResourceMail(String from, String to, String subject, String content,
			String imgPath, String imgId);
	
	
}
