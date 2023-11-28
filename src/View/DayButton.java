package View;

import java.awt.*;
import javax.swing.*;

import Data.UserInfo;

public class DayButton extends JButton {
	public UserInfo DayInfo;
	public JLabel title;
	public DayButton(String text) {
		super(text);
		title = new JLabel("",JLabel.CENTER); //TODO button에 label을 붙이기
		setLayout(new BorderLayout());
		add(title,"South");
	}
}
