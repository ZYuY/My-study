package com.zzk.list.button;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Dimension;

public class SortListItemButton extends JButton implements ListCellRenderer {
	private ImageIcon icon = null;
	public SortListItemButton() {
		super();
		initialize();
	}
	private void initialize() {
        this.setSize(new Dimension(110, 31));
			
	}
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		String title = (String)value;
        icon = new ImageIcon("src/image/"+(index+1)+".png");
        setText(title);
        setIcon(icon);
        if (isSelected) {
            setBackground(new Color(223,206,98));
        } else {
            setBackground(new Color(240,238,225));
        }
		return this;
	}
}
