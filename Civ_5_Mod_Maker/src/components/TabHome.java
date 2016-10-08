package components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import util.Constants;

public class TabHome extends Tab {
	private DefaultListModel<String> exports = new DefaultListModel<String>();

	public TabHome(Window w) {
		JList<String> l = new JList<String>(exports);
		l.setToolTipText("Double Click a Selected Item to Delete It, Left Click to Edit");
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == 1 && arg0.getClickCount() == 2) {;
					switch (l.getSelectedValue().split(":")[0]) {
					case "Building":
						Window.fileTypes.setSelectedIndex(Constants.TAB_BUILDING);
						w.b.load(Window.outputBuilds.get(l.getSelectedValue()
								.split(":")[1].replaceFirst(" ", "")));
						break;
					case "Civilization":
						Window.fileTypes.setSelectedIndex(Constants.TAB_CIVILIZATION);
						w.c.load(Window.outputCivs.get(l.getSelectedValue()
								.split(":")[1].replaceFirst(" ", "")));
						break;
					case "Leader":
						Window.fileTypes.setSelectedIndex(Constants.TAB_LEADER);
						w.l.load(Window.outputLeads.get(l.getSelectedValue()
								.split(":")[1].replaceFirst(" ", "")));
						break;
					case "Trait":
						Window.fileTypes.setSelectedIndex(Constants.TAB_TRAIT);
						w.t.load(Window.outputTraits.get(l.getSelectedValue()
								.split(":")[1].replaceFirst(" ", "")));
						break;
					case "Unit":
						Window.fileTypes.setSelectedIndex(Constants.TAB_UNIT);
						w.u.load(Window.outputUnits.get(l.getSelectedValue()
								.split(":")[1].replaceFirst(" ", "")));
						break;
					}
				} else if (arg0.getButton() == 3) {
					int r = JOptionPane.showConfirmDialog(null,
							"Are You ABSOLUTLY Sure You Want to Delete This?");

					if (r == JOptionPane.YES_OPTION) {
						switch (l.getSelectedValue().split(":")[0]) {
						case "Building":
							Window.outputBuilds.remove(l.getSelectedValue()
									.split(":")[1].replaceFirst(" ", ""));
							break;
						case "Civilization":
							Window.outputCivs.remove(l.getSelectedValue()
									.split(":")[1].replaceFirst(" ", ""));
							break;
						case "Leader":
							Window.outputLeads.remove(l.getSelectedValue()
									.split(":")[1].replaceFirst(" ", ""));
							break;
						case "Trait":
							Window.outputTraits.remove(l.getSelectedValue()
									.split(":")[1].replaceFirst(" ", ""));
							break;
						case "Unit":
							Window.outputUnits.remove(l.getSelectedValue()
									.split(":")[1].replaceFirst(" ", ""));
							break;
						}
						exports.removeElementAt(l.getSelectedIndex());
					}
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
		JScrollPane jsp = new JScrollPane(l);
		addComponent(1, "Mod Files: ", 15, jsp);

		DefaultListModel<String> m = new DefaultListModel<String>();
		addLabel(1, "<html><u>Helpful Icons:</u><html>");
		JList<String> l2 = new JList<String>(m);
		m.addElement("[NEWLINE]*");
		m.addElement("[ICON_RESEARCH]");
		m.addElement("[ICON_GOLD]");
		m.addElement("[ICON_PRODUCTION]");
		m.addElement("[ICON_FOOD]");
		m.addElement("[ICON_CULTURE]");
		m.addElement("[ICON_STRENGTH]");
		m.addElement("[ICON_RES_IRON]");
		m.addElement("[ICON_RES_HORSE]");
		m.addElement("[ICON_RES_COAL]");
		m.addElement("[ICON_RES_OIL]");
		m.addElement("[ICON_RES_ALUMINUM]");
		m.addElement("[ICON_RES_URANIUM]");
		m.addElement("[ICON_RES_WHALE]");
		m.addElement("[ICON_RES_GOLD]");
		m.addElement("[ICON_RES_GEMS]");
		m.addElement("[ICON_RES_MARBLE]");
		m.addElement("[ICON_RES_IVORY]");
		m.addElement("[ICON_RES_DYE]");
		m.addElement("[ICON_RES_SPICES]");
		m.addElement("[ICON_RES_SILK]");
		m.addElement("[ICON_RES_SUGAR]");
		m.addElement("[ICON_RES_COTTON]");
		m.addElement("[ICON_HAPPINESS_1]*");
		m.addElement("[ICON_HAPPINESS_4]*");
		m.addElement("[ICON_GOLDEN_AGE]");
		m.addElement("[ICON_RES_PEARLS]");
		m.addElement("[ICON_RES_INCENSE]");
		m.addElement("[ICON_RES_WINE]");
		m.addElement("[ICON_RES_SILVER]");
		m.addElement("[ICON_RES_FUR]");
		m.addElement("[ICON_CITIZEN]");
		m.addElement("[ICON_GREAT_PEOPLE]");
		m.addElement("[ICON_RAZING]");
		m.addElement("[ICON_PEACE]");
		m.addElement("[ICON_CITY_STATE]");
		l2.setBorder(BorderFactory.createEtchedBorder());
		JScrollPane j = new JScrollPane(l2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		addComponent(1, 7, j);

		JLabel lbl3 = new JLabel(
				"<html>New Line is Added Automatically<br>1 = Happy<br>4 = Unhappy<html>");
		addComponent(1, 2, lbl3);

		next(6);
		addLabel(1, "<html><u>Coming Soon:</u><html>");
		JLabel lbl = new JLabel(
				"<html>-Deleting Items<br>-Techs<br>-Resources<br>-Lua<html>");
		addComponent(1, 2, lbl);
	}

	public void addToList(String info) {

		exports.addElement(info);
	}
}
