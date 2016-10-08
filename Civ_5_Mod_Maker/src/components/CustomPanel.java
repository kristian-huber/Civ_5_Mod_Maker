package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import util.Constants;

public class CustomPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	int x, y, width, height;

	DefaultListModel<String> list = new DefaultListModel<String>();

	public CustomPanel(int x, int y, int width, int height, int gap, String s1,
			JComboBox<String> jcb, String s2, JTextField jtf) {

		this.setBounds(gap + x * width + (x * gap), y * height, width,
				height * 6);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(null);

		JList<String> l = new JList<String>(list);
		l.setBorder(BorderFactory.createCompoundBorder());
		l.setBounds(5, 5, width - 10, 35);
		l.setToolTipText("Select an Item then Right Click to Delete");
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == 3) {
					list.removeElementAt(l.getSelectedIndex());
				}
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
		l.setFont(Constants.ARIAL10);

		JScrollPane j = new JScrollPane(l);
		j.setBounds(5, 5, width - 10, 35);
		this.add(j);

		JLabel lbl1 = new JLabel(s1);
		lbl1.setBounds(5, 40, width - 10, 20);
		lbl1.setFont(Constants.ARIAL10);
		this.add(lbl1);

		jcb.setBounds(5, 60, width - 10, 20);
		jcb.setFont(Constants.ARIAL10);
		this.add(jcb);

		JLabel lbl2 = new JLabel(s2);
		lbl2.setBounds(5, 80, width - 10, 20);
		lbl2.setFont(Constants.ARIAL10);
		this.add(lbl2);

		jtf.setBounds(5, 100, width - 10, 20);
		jtf.setText("0");
		jtf.setFont(Constants.ARIAL10);
		this.add(jtf);

		JButton b = new JButton("Add to List");
		b.setBounds(5, 125, width - 10, 20);
		b.setFont(Constants.ARIAL10);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToList(jcb.getSelectedItem().toString() + ":"
						+ jtf.getText());
				jcb.setSelectedIndex(0);
				jtf.setText("0");
			}
		});
		this.add(b);
	}

	public CustomPanel(int x, int y, int width, int height, int gap, String s1,
			JComboBox<String> jcb) {

		this.setBounds(gap + x * width + (x * gap), y * height, width,
				height * 5);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(null);

		JList<String> l = new JList<String>(list);
		l.setBorder(BorderFactory.createCompoundBorder());
		l.setBounds(5, 5, width - 10, 35);
		l.setToolTipText("Select an Item then Right Click to Delete");
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == 3) {
					list.removeElementAt(l.getSelectedIndex());
				}
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
		l.setFont(Constants.ARIAL10);

		JScrollPane j = new JScrollPane(l);
		j.setBounds(5, 5, width - 10, 35);
		this.add(j);

		JLabel lbl1 = new JLabel(s1);
		lbl1.setBounds(5, 40, width - 10, 20);
		lbl1.setFont(Constants.ARIAL10);
		this.add(lbl1);

		jcb.setBounds(5, 60, width - 10, 20);
		jcb.setFont(Constants.ARIAL10);
		this.add(jcb);

		JButton b = new JButton("Add to List");
		b.setBounds(5, 100, width - 10, 20);
		b.setFont(Constants.ARIAL10);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToList(jcb.getSelectedItem().toString());
				jcb.setSelectedIndex(0);
			}
		});
		this.add(b);
	}

	public CustomPanel(int x, int y, int width, int height, int gap, String s1,
			JComboBox<String> jcb, String s2, JComboBox<String> jtf) {

		this.setBounds(gap + x * width + (x * gap), y * height, width,
				height * 6);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(null);

		JList<String> l = new JList<String>(list);
		l.setBorder(BorderFactory.createCompoundBorder());
		l.setBounds(5, 5, width - 10, 35);
		l.setToolTipText("Select an Item then Right Click to Delete");
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == 3) {
					list.removeElementAt(l.getSelectedIndex());
				}
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
		l.setFont(Constants.ARIAL10);

		JScrollPane j = new JScrollPane(l);
		j.setBounds(5, 5, width - 10, 35);
		this.add(j);

		JLabel lbl1 = new JLabel(s1);
		lbl1.setBounds(5, 40, width - 10, 20);
		lbl1.setFont(Constants.ARIAL10);
		this.add(lbl1);

		jcb.setBounds(5, 60, width - 10, 20);
		jcb.setFont(Constants.ARIAL10);
		this.add(jcb);

		JLabel lbl2 = new JLabel(s2);
		lbl2.setBounds(5, 80, width - 10, 20);
		lbl2.setFont(Constants.ARIAL10);
		this.add(lbl2);

		jtf.setBounds(5, 100, width - 10, 20);
		jtf.setFont(Constants.ARIAL10);
		this.add(jtf);

		JButton b = new JButton("Add to List");
		b.setBounds(5, 125, width - 10, 20);
		b.setFont(Constants.ARIAL10);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToList(jcb.getSelectedItem().toString() + ":"
						+ jtf.getSelectedItem().toString());
				jcb.setSelectedIndex(0);
				jtf.setSelectedIndex(0);
				;
			}
		});
		this.add(b);
	}

	public CustomPanel(int x, int y, int width, int height, int gap, String s1,
			JComboBox<String> jcb, String s2, JComboBox<String> jcb2,
			String s3, JTextField jcb3) {

		this.setBounds(gap + x * width + (x * gap), gap + y * height, width,
				height * 8);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(null);

		JList<String> l = new JList<String>(list);
		l.setBorder(BorderFactory.createCompoundBorder());
		l.setBounds(5, 5, width - 10, 35);
		l.setToolTipText("Select an Item then Right Click to Delete");
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == 3) {
					list.removeElementAt(l.getSelectedIndex());
				}
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
		l.setFont(Constants.ARIAL10);

		JScrollPane j = new JScrollPane(l,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		j.setBounds(5, 5, width - 10, 35);
		this.add(j);

		JLabel lbl1 = new JLabel(s1);
		lbl1.setBounds(5, 40, width - 10, 20);
		lbl1.setFont(Constants.ARIAL10);
		this.add(lbl1);

		jcb.setBounds(5, 60, width - 10, 20);
		jcb.setFont(Constants.ARIAL10);
		this.add(jcb);

		JLabel lbl2 = new JLabel(s2);
		lbl2.setBounds(5, 80, width - 10, 20);
		lbl2.setFont(Constants.ARIAL10);
		this.add(lbl2);

		jcb2.setBounds(5, 100, width - 10, 20);
		jcb2.setFont(Constants.ARIAL10);
		this.add(jcb2);

		JLabel lbl3 = new JLabel(s3);
		lbl3.setBounds(5, 120, width - 10, 20);
		lbl3.setFont(Constants.ARIAL10);
		this.add(lbl3);

		jcb3.setBounds(5, 140, width - 10, 20);
		jcb3.setFont(Constants.ARIAL10);
		this.add(jcb3);

		JButton b = new JButton("Add to List");
		b.setBounds(5, 175, width - 10, 20);
		b.setFont(Constants.ARIAL10);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToList(jcb.getSelectedItem().toString() + "/"
						+ jcb2.getSelectedItem().toString() + ":"
						+ jcb3.getText());
				jcb.setSelectedIndex(0);
				jcb2.setSelectedIndex(0);
				jcb3.setText("0");
			}
		});
		this.add(b);
	}

	public CustomPanel(int x, int y, int width, int height, int gap, String s1,
			JComboBox<String> jcb, String s2, JComboBox<String> jcb2,
			String s3, JComboBox<String> jcb3) {

		this.setBounds(gap + x * width + (x * gap), gap + y * height, width,
				height * 8);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(null);

		JList<String> l = new JList<String>(list);
		l.setBorder(BorderFactory.createCompoundBorder());
		l.setBounds(5, 5, width - 10, 35);
		l.setToolTipText("Select an Item then Right Click to Delete");
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == 3) {
					list.removeElementAt(l.getSelectedIndex());
				}
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
		l.setFont(Constants.ARIAL10);

		JScrollPane j = new JScrollPane(l,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		j.setBounds(5, 5, width - 10, 35);
		this.add(j);

		JLabel lbl1 = new JLabel(s1);
		lbl1.setBounds(5, 40, width - 10, 20);
		lbl1.setFont(Constants.ARIAL10);
		this.add(lbl1);

		jcb.setBounds(5, 60, width - 10, 20);
		jcb.setFont(Constants.ARIAL10);
		this.add(jcb);

		JLabel lbl2 = new JLabel(s2);
		lbl2.setBounds(5, 80, width - 10, 20);
		lbl2.setFont(Constants.ARIAL10);
		this.add(lbl2);

		jcb2.setBounds(5, 100, width - 10, 20);
		jcb2.setFont(Constants.ARIAL10);
		this.add(jcb2);

		JLabel lbl3 = new JLabel(s3);
		lbl3.setBounds(5, 120, width - 10, 20);
		lbl3.setFont(Constants.ARIAL10);
		this.add(lbl3);

		jcb3.setBounds(5, 140, width - 10, 20);
		jcb3.setFont(Constants.ARIAL10);
		this.add(jcb3);

		JButton b = new JButton("Add to List");
		b.setBounds(5, 175, width - 10, 20);
		b.setFont(Constants.ARIAL10);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToList(jcb.getSelectedItem().toString() + "/"
						+ jcb2.getSelectedItem().toString() + ":"
						+ jcb3.getSelectedItem().toString());
				jcb.setSelectedIndex(0);
				jcb2.setSelectedIndex(0);
				jcb3.setSelectedIndex(0);
			}
		});
		this.add(b);
	}

	public String[] getList() {
		String[] output = new String[list.getSize()];
		for (int i = 0; i < output.length; i++) {
			output[i] = list.getElementAt(i);
		}
		return output;
	}

	public void clearList() {
		list.clear();
	}

	public void addToList(String s) {

		list.addElement(s);
	}
}
