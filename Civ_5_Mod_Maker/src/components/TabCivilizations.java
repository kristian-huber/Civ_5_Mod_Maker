package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import structs.StructCivilization;
import util.Constants;

public class TabCivilizations extends Tab {
	JComboBox<String> artStyle, artSuffix, artPrefix, leader, religion, start,
			utype, unew, uold;
	JTextField name, adj, artTag, atlas, index, map, domLeader, sound;
	JTextArea domText, spies, cities;
	JPanel mainColor, secondaryColor;
	JCheckBox coastal;

	public TabCivilizations() {
		name = new JTextField();
		addComponent(1, "Civilization Name: ", name);

		adj = new JTextField();
		addComponent(1, "Adjective: ", adj);

		artTag = new JTextField();
		addComponent(1, "Art Tag: ", artTag);

		artStyle = new JComboBox<String>(Constants.ATYPES);
		addComponent(1, "Art Style: ", artStyle);

		artPrefix = new JComboBox<String>(Constants.APREFIX);
		addComponent(1, "Art Prefix: ", artPrefix);

		artSuffix = new JComboBox<String>(Constants.ASUFFIX);
		addComponent(1, "Art Suffix: ", artSuffix);

		mainColor = new JPanel();
		addColorPicker(1, "Main Color: ", mainColor);

		secondaryColor = new JPanel();
		addColorPicker(1, "Secondary Color: ", secondaryColor);

		atlas = new JTextField();
		addComponent(1, "Icon Atlas: ", atlas);

		index = new JTextField();
		addComponent(1, "Icon Index: ", index);

		domLeader = new JTextField();
		addComponent(1, "DOM Leader: ", domLeader);

		map = new JTextField();
		addComponent(1, "DOM Map: ", map);

		sound = new JTextField();
		addComponent(1, "Sound", sound);

		leader = new JComboBox<String>(Window.copy(Window.leaders));
		addComponent(1, "Leader: ", leader);

		religion = new JComboBox<String>(Constants.RELIGIONS);
		addComponent(1, "Religion: ", religion);

		start = new JComboBox<String>(Constants.TERRAINS);
		addComponent(1, "Start Priority", start);

		utype = new JComboBox<String>(new String[] { "Building", "Unit" });
		utype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (utype.getSelectedIndex() == 0) {
					unew.setModel(Window.copy(Window.buildings));
					uold.setModel(Window.copy(Window.buildings));
				} else {
					unew.setModel(Window.copy(Window.units));
					uold.setModel(Window.copy(Window.units));
				}
			}
		});
		unew = new JComboBox<String>(Window.copy(Window.buildings));
		uold = new JComboBox<String>(Window.copy(Window.buildings));
		addListBoxB(1, "Unique Type: ", utype, "New Unique: ", unew,
				"Replaces: ", uold);

		domText = new JTextArea();
		JScrollPane jsp = new JScrollPane(domText);
		addComponent(1, "DOM Text: ", 6, jsp);

		coastal = new JCheckBox("Coastal Start");
		addComponent(1, coastal);

		addLabel(1, "");

		spies = new JTextArea();
		spies.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addComponent(1, "Spies: ", 6, spies);

		cities = new JTextArea();
		cities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addComponent(1, "Cities: ", 6, cities);
	}
	
	@Override
	public void reset(){
		super.reset();
		spies.setText("");
		cities.setText("");
		domText.setText("");
	}

	public StructCivilization getCiv() {
		StructCivilization civ = new StructCivilization();

		civ.adjective = adj.getText();
		civ.art_prefix = artPrefix.getSelectedItem().toString();
		civ.art_style = artStyle.getSelectedItem().toString();
		civ.art_suffix = artSuffix.getSelectedItem().toString();
		civ.art_tag = artTag.getText().toUpperCase();
		civ.atlas = atlas.getText();
		civ.background = mainColor.getBackground();
		civ.cities = cities.getText().split("\\n");
		civ.coastal = coastal.isSelected();
		civ.dom_image = domLeader.getText();
		civ.dom_map = map.getText();
		civ.dom_quote = domText.getText().replace("\n", "[NEWLINE]");
		civ.foreground = secondaryColor.getBackground();
		civ.leader = leader.getSelectedItem().toString();
		civ.name = name.getText();
		civ.name_constant = name.getText().toUpperCase().replaceAll(" ", "_");
		civ.religion = religion.getSelectedItem().toString();
		civ.soundtrack = sound.getText();
		civ.spies = spies.getText().split("\\n");
		civ.symbol_index = index.getText();
		civ.terrain = start.getSelectedItem().toString();
		String[] data = panels.get("Unique Type: ").getList();
		String[] buildings = decode(data, 0);
		String[] units = decode(data, 1);
		civ.bO = getArray(buildings, 1);
		civ.bN = getArray(buildings, 0);
		civ.uO = getArray(units, 1);
		civ.uN = getArray(units, 0);

		return civ;
	}

	public void load(StructCivilization civ) {

		adj.setText(civ.adjective);
		artPrefix.setSelectedItem(civ.art_prefix);
		artStyle.setSelectedItem(civ.art_style);
		artSuffix.setSelectedItem(civ.art_suffix);
		artTag.setText(civ.art_tag);
		atlas.setText(civ.atlas);
		mainColor.setBackground(civ.background);
		for (int i = 0; i < civ.cities.length; i++) {
			if(i != 0){
				cities.setText(cities.getText() + "\n" + civ.cities[i]);
			}else{
				cities.setText(civ.cities[0]);
			}
		}
		coastal.setSelected(civ.coastal);
		domLeader.setText(civ.dom_image);
		map.setText(civ.dom_map);
		domText.setText(civ.dom_quote.replace("[NEWLINE]", "\n"));
		secondaryColor.setBackground(civ.foreground);
		leader.setSelectedItem(civ.leader);
		name.setText(civ.name);
		religion.setSelectedItem(civ.religion);
		sound.setText(civ.soundtrack);
		for (int i = 0; i < civ.spies.length; i++) {
			if(i != 0){
				spies.setText(spies.getText() + "\n" + civ.spies[i]);
			}else{
				spies.setText(civ.spies[0]);
			}
		}
		index.setText(civ.symbol_index);
		start.setSelectedItem(civ.terrain);
		for (int i = 0; i < civ.bO.length; i++) {
			this.panels.get("Unique Type: ").addToList(
					"Building:" + civ.bN[i] + ":" + civ.bO[i]);
		}
		for (int i = 0; i < civ.uO.length; i++) {
			this.panels.get("Unique Type: ").addToList(
					"Unit:" + civ.uN[i] + ":" + civ.uO[i]);
		}
	}

	private String[] decode(String[] data, int type) {
		ArrayList<String> x = new ArrayList<String>(0);
		for (String s : data) {
			if (type == 0) {
				if (s.split("/")[0].equals("Building")) {
					x.add(s.split("/")[1]);
				}
			} else if (type == 1) {
				if (s.split("/")[0].equals("Unit")) {
					x.add(s.split("/")[1]);
				}
			}
		}
		String[] output = new String[x.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = x.get(i);
		}
		return output;
	}
}
