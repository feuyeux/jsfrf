/**
 * 
 */
package creative.fire.jsfrf.rf.output;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Administrator
 *
 */
@ManagedBean
@RequestScoped
public class ImageStyle implements Serializable {
	private static final long serialVersionUID = 7511279525449561702L;
	private int Width = 100;
	private int Height = 50;
	private Color SlateBlue = new Color(53, 126, 199);
	private Color fontColor = new Color(255, 255, 255);
	private Font font = new Font("微软雅黑", Font.TRUETYPE_FONT, 30);

	public Color getBackground() {
		return SlateBlue;
	}

	public Font getFont() {
		return font;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}

	public Color getSlateBlue() {
		return SlateBlue;
	}

	public Color getFontColor() {
		return fontColor;
	}
}