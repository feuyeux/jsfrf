package creative.fire.jsfrf.rf.output;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;

@ManagedBean
@RequestScoped
public class MediaBean {
	public void paint(OutputStream out, Object data) throws IOException {
		if (data instanceof ImageStyle) {
			ImageStyle paintData = (ImageStyle) data;
			BufferedImage img = new BufferedImage(paintData.getWidth(), paintData.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = img.createGraphics();
			graphics2D.setBackground(paintData.getBackground());
			graphics2D.setColor(paintData.getFontColor());
			graphics2D.clearRect(0,0,paintData.getWidth(),paintData.getHeight());
			graphics2D.setFont(paintData.getFont());
			graphics2D.drawString("乾·坤", 15, 35);
			ImageIO.write(img, "png", out);
		}
	}
}