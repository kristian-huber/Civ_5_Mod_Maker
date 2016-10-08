package components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import util.Constants;

public class Tab {
	protected HashMap<String, CustomPanel> panels = new HashMap<String, CustomPanel>();
	protected ArrayList<JComponent> components = new ArrayList<JComponent>();
	protected ArrayList<JPanel> pages = new ArrayList<JPanel>();

	private int width, height;
	private int x, y;
	private int gap;

	public Tab() {
		addPage();
		width = 157;
		height = 25;
		gap = 5;
		x = 0;
		y = 0;
	}

	protected void addComponent(int page, String arg0, JComponent comp) {
		addLabel(page, arg0);
		addComponent(page, comp);
	}

	protected void addColorPicker(int page, String arg0, JPanel j) {
		addLabel(1, arg0);
		Color rand = getRandomColor();
		j.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		j.setBackground(rand);
		j.setBounds(gap + x * width + (gap * x), y * height, width, height);
		j.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				j.setBackground(JColorChooser.showDialog(null,
						"Civilization V", rand));
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});
		pages.get(page - 1).add(j);
		components.add(j);
		next();
	}

	protected void addComponent(int page, JComponent comp) {
		if (comp instanceof JComboBox) {
			comp.setBounds(gap + x * width + (x * gap), y * height, width,
					height - gap);
		} else if (comp instanceof JCheckBox) {
			comp.setBounds(x * width + (x * gap), y * height, width, height
					- gap);
		} else {
			comp.setBounds(gap + x * width + (x * gap), y * height, width,
					height);
		}
		comp.setFont(Constants.ARIAL12);
		pages.get(page - 1).add(comp);
		next();
		components.add(comp);
	}

	protected void addComponent(int page, String arg0, int multi,
			JComponent comp) {
		addLabel(page, arg0);
		comp.setBounds(gap + x * width + (x * gap), y * height, width, height
				* multi);
		comp.setFont(Constants.ARIAL10);
		pages.get(page - 1).add(comp);
		next(multi);
		components.add(comp);
	}
	
	protected void addComponent(int page, int multi,
			JComponent comp) {
		comp.setBounds(gap + x * width + (x * gap), y * height, width, height
				* multi);
		comp.setFont(Constants.ARIAL10);
		pages.get(page - 1).add(comp);
		next(multi);
		components.add(comp);
	}

	protected void addSlider(int page, String arg0, JSlider j) {
		j.setMajorTickSpacing(1);
		j.setMinorTickSpacing(1);
		j.setPaintTicks(true);
		j.setMaximum(10);
		j.setMinimum(0);
		j.setValue(5);
		addComponent(page, arg0, j);
	}

	protected void addLabel(int page, String arg0) {
		JLabel lbl = new JLabel(arg0);
		lbl.setBounds(gap + x * width + (x * gap), y * height, width, height);
		lbl.setFont(Constants.ARIAL12);
		pages.get(page - 1).add(lbl);
		next();
	}

	/**
	 * Adds a List, a ComboBox, and a TextField
	 */
	public void addListBoxA(int page, String s1, JComboBox<String> jcb,
			String s2, JTextField jtf) {

		CustomPanel c = new CustomPanel(x, y, width, height, gap, s1, jcb, s2,
				jtf);
		panels.put(s1, c);
		pages.get(page - 1).add(c);
		next(6);
		components.add(c);
	}

	/**
	 * Adds a List, and 3 Comboboxes
	 */
	public void addListBoxB(int page, String s1, JComboBox<String> jcb,
			String s2, JComboBox<String> jcb2, String s3, JComboBox<String> jcb3) {

		CustomPanel c = new CustomPanel(x, y, width, height, gap, s1, jcb, s2,
				jcb2, s3, jcb3);
		panels.put(s1, c);
		pages.get(page - 1).add(c);
		next(8);
		components.add(c);
	}

	/**
	 * Adds a List, and 2 ComboBoxes
	 */
	public void addListBoxC(int page, String s1, JComboBox<String> jcb,
			String s2, JComboBox<String> jtf) {

		CustomPanel c = new CustomPanel(x, y, width, height, gap, s1, jcb, s2,
				jtf);
		panels.put(s1, c);
		pages.get(page - 1).add(c);
		next(6);
		components.add(c);
	}

	/**
	 * Adds a List, 2 Comboboxes, and a TextField
	 */
	public void addListBoxD(int page, String s1, JComboBox<String> jcb,
			String s2, JComboBox<String> jcb2, String s3, JTextField jcb3) {

		CustomPanel c = new CustomPanel(x, y, width, height, gap, s1, jcb, s2,
				jcb2, s3, jcb3);
		panels.put(s1, c);
		pages.get(page - 1).add(c);
		next(8);
		components.add(c);
	}
	
	/**
	 * Adds a List, and 1 ComboBox
	 */
	public void addListBoxE(int page, String s1, JComboBox<String> jcb) {

		CustomPanel c = new CustomPanel(x, y, width, height, gap, s1, jcb);
		panels.put(s1, c);
		pages.get(page - 1).add(c);
		next(5);
		components.add(c);
	}

	private void next() {
		y++;
		if (y >= 16) {
			y = 0;
			x++;
			if (x >= 4) {
				x = 0;
			}
		}
	}

	protected void next(int times) {
		y += times;
		if (y >= 16) {
			y = 0;
			x++;
			if (x >= 4) {
				x = 0;
			}
		}
	}

	public String[] getArray(String input, int part) {
		String[] array = panels.get(input).getList();
		String[] output = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			output[i] = array[i].split(":")[part];
		}
		return output;
	}

	public String[] getArray(String[] input, int part) {
		String[] output = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i].split(":")[part];
		}
		return output;
	}

	public Color getRandomColor() {

		return new Color((int) (255 * Math.random()),
				(int) (255 * Math.random()), (int) (255 * Math.random()));
	}

	public void addPage() {
		JPanel p = new JPanel();
		p.setLayout(null);
		pages.add(p);
	}

	@SuppressWarnings("unchecked")
	public void reset() {

		for (JComponent j : components) {

			if (j instanceof JTextField) {
				((JTextField) j).setText("");
			} else if (j instanceof JComboBox) {
				((JComboBox<String>) j).setSelectedIndex(0);
			} else if (j instanceof CustomPanel) {
				((CustomPanel) j).clearList();
			} else if (j instanceof JPanel) {
				j.setBackground(getRandomColor());
			} else if(j instanceof JCheckBox){
				((JCheckBox) j).setSelected(false);
			}
		}
	}

	public JPanel getTab() {
		JPanel p = pages.get(0);
		return p;
	}
}
