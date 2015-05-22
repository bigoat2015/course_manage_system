<%@ page contentType="image/jpeg" language="java" pageEncoding="UTF-8" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %> 

<%! 
	Color getRandColor(int fc,int bc) 
	{ 
		Random random = new Random(); 
		if(fc>255) fc=255; 
		if(bc>255) bc=255; 
		int r=fc+random.nextInt(bc-fc); 
		int g=fc+random.nextInt(bc-fc); 
		int b=fc+random.nextInt(bc-fc); 
		return new Color(r,g,b); 
	} 
%> 

<% 
	out.clear();//这句针对resin服务器，如果是tomacat可以不要这句 
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
	
	int width=68, height=35; 
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
	Graphics g = image.getGraphics(); 
	Random random = new Random();
	
	g.setColor(new Color(255,255,255)); 
	g.fillRect(0,0,width,height);
	g.setColor(new Color(204,204,204)); 
	g.drawRect(0, 0, width, height); 
	
	g.setFont(new Font("Times New Roman",Font.PLAIN,28)); 
	g.setColor(new Color(204,204,204)); 
	
	for (int i=0;i<35;i++) 
	{ 
		int x = random.nextInt(width); 
		int y = random.nextInt(height); 
		int xl = random.nextInt(22); 
		int yl = random.nextInt(22); 
		g.drawLine(x,y,x+xl,y+yl); 
	} 
	
	g.setColor(new Color(51,51,51));
	String sRand=""; 
	for (int i=0;i<4;i++){ 
		String rand=String.valueOf(random.nextInt(10)); 
		sRand += rand; 
		//g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110))); 
		g.drawString(rand,13*i+8,26); 
	} 
	
	// 将认证码存入SESSION 
	session.setAttribute("validateCode",sRand); 
	
	g.dispose(); 
	
	out.clear(); 
    out=pageContext.pushBody();
	
	ImageIO.write(image, "JPEG", response.getOutputStream()); 
%>
