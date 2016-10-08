package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import structs.StructBuilding;
import util.Constants;

public class TabBuildings extends Tab {

	private JCheckBox sea, river, mountain;
	private JTextField name, tip, mat, productionCost, expAmount,
			unitModAmount, flavorAmount, yieldAmount, yieldPercentAmount,
			happiness, buildingMod, hitpoints, atlas, portindex, displaypos,
			featureamount, terrainamount, resamount, givesresamt,
			requiresresamt, combmodamt;
	public JComboBox<String> unitMod, flavor, exp, superClass, yields,
			yieldPercent, preqTech, feature, featuretype, terrain, terraintype,
			res, restype, givesres, requiresres, combmod, razors;

	public TabBuildings() {

		name = new JTextField();
		addComponent(1, "Building Name: ", name);

		tip = new JTextField();
		addComponent(1, "Tool Tip: ", tip);

		atlas = new JTextField();
		addComponent(1, "Texture Atlas: ", atlas);

		portindex = new JTextField("0");
		addComponent(1, "Portrait Index: ", portindex);

		displaypos = new JTextField("0");
		addComponent(1, "Display Position:", displaypos);

		mat = new JTextField("0");
		addComponent(1, "Maintenance: ", mat);

		productionCost = new JTextField("0");
		addComponent(1, "Production Cost: ", productionCost);

		hitpoints = new JTextField("0");
		addComponent(1, "City Defense: ", hitpoints);

		addLabel(1, "Requires Terrain: ");

		sea = new JCheckBox("Sea");
		addComponent(1, sea);

		river = new JCheckBox("River");
		addComponent(1, river);

		mountain = new JCheckBox("Mountain");
		addComponent(1, mountain);

		flavor = new JComboBox<String>(Constants.FLAVORS);
		flavorAmount = new JTextField();
		addListBoxA(1, "Flavor: ", flavor, "Amount: ", flavorAmount);

		yields = new JComboBox<String>(Constants.YIELD_TYPES);
		yieldAmount = new JTextField();
		addListBoxA(1, "Yield: ", yields, "Amount: ", yieldAmount);

		happiness = new JTextField("0");
		addComponent(1, "Happiness: ", happiness);

		preqTech = new JComboBox<String>(Window.copy(Window.techs));
		addComponent(1, "Prerequisite Tech: ", preqTech);

		unitMod = new JComboBox<String>(Constants.UNIT_DOMAINS);
		unitModAmount = new JTextField();
		addListBoxA(1, "Unit Production Bonus: ", unitMod, "Amount (%): ",
				unitModAmount);

		exp = new JComboBox<String>(Constants.UNIT_DOMAINS);
		expAmount = new JTextField();
		addListBoxA(1, "Unit Experience: ", exp, "Amount: ", expAmount);

		buildingMod = new JTextField("0");
		addComponent(1, "Building Production (%): ", buildingMod);

		DefaultComboBoxModel<String> d = Window.copy(Window.buildings);
		d.insertElementAt("ITSELF", 0);
		superClass = new JComboBox<String>(d);
		superClass.setSelectedIndex(0);
		superClass
				.setToolTipText("Select ITSELF if you aren't doing a Unique Building");
		addComponent(1, "Model Type: ", superClass);

		yieldPercent = new JComboBox<String>(Constants.YIELD_TYPES);
		yieldPercentAmount = new JTextField();
		addListBoxA(1, "Yield Type: ", yieldPercent, "Amount (%): ",
				yieldPercentAmount);

		razors = new JComboBox<String>(Window.copy(Window.resources));
		addListBoxE(1, "City Must Have: ", razors);

		addPage();
		JButton nextPage = new JButton("Next Page");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_BUILDING,
						pages.get(1));
				pages.get(1).repaint();
			}
		});
		addComponent(1, nextPage);
		nextPage.setBounds(nextPage.getX(), nextPage.getY() + 5,
				nextPage.getWidth(), nextPage.getHeight());

		feature = new JComboBox<String>(Constants.FEATURES);
		featuretype = new JComboBox<String>(Constants.YIELD_TYPES);
		featureamount = new JTextField();
		addListBoxD(2, "Feature: ", feature, "Yield: ", featuretype,
				"Yield Amount: ", featureamount);

		terrain = new JComboBox<String>(Constants.TERRAINS);
		terrain.removeItem("FOREST");
		terrain.removeItem("JUNGLE");
		terrain.removeItem("NONE");
		terraintype = new JComboBox<String>(Constants.YIELD_TYPES);
		terrainamount = new JTextField();
		addListBoxD(2, "Terrain: ", terrain, "Yield: ", terraintype,
				"Yield Amount: ", terrainamount);

		res = new JComboBox<String>(Window.copy(Window.resources));
		restype = new JComboBox<String>(Constants.YIELD_TYPES);
		resamount = new JTextField();
		addListBoxD(2, "Resource: ", res, "Yield: ", restype, "Yield Amount: ",
				resamount);

		givesres = new JComboBox<String>(Window.copy(Window.resources));
		givesresamt = new JTextField();
		addListBoxA(2, "Gives Resource: ", givesres, "Amount: ", givesresamt);

		next(3);

		requiresres = new JComboBox<String>(Window.copy(Window.resources));
		requiresresamt = new JTextField();
		addListBoxA(2, "Requires Resource: ", requiresres, "Amount: ",
				requiresresamt);

		combmod = new JComboBox<String>(Constants.UNIT_TYPES);
		combmodamt = new JTextField();
		addListBoxA(2, "Combat Production: ", combmod, "Amount (%): ",
				combmodamt);

		addLabel(2, "");
		JButton prevPage = new JButton("Previous Page");
		prevPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_BUILDING,
						pages.get(0));
				pages.get(0).repaint();
			}
		});
		addComponent(2, prevPage);
	}

	public StructBuilding getBuilding() {
		StructBuilding b = new StructBuilding();

		b.build_class = Window.buildings.getElementAt(superClass
				.getSelectedIndex());
		b.building_mod = buildingMod.getText();
		b.display_pos = displaypos.getText();
		b.happiness = happiness.getText();
		b.hitpoints = hitpoints.getText();
		b.icon_atlas = atlas.getText();
		b.maintenance = mat.getText();
		b.mountain = mountain.isSelected();
		b.name = name.getText();
		b.name_constant = name.getText().toUpperCase().replaceAll(" ", "_");
		b.name_super = superClass.getSelectedItem().toString();
		b.portrait_index = portindex.getText();
		b.preq_tech = preqTech.getSelectedItem().toString();
		b.prod_cost = productionCost.getText();
		b.river = river.isSelected();
		b.sea = sea.isSelected();
		b.tip = tip.getText();
		b.exp_amts = this.getArray("Unit Experience: ", 1);
		b.exp_types = this.getArray("Unit Experience: ", 0);
		b.flavor_amts = this.getArray("Flavor: ", 1);
		b.flavors = this.getArray("Flavor: ", 0);
		b.prod_amt_to_types = this.getArray("Unit Production Bonus: ", 1);
		b.prod_types = this.getArray("Unit Production Bonus: ", 0);
		b.yield_amts = this.getArray("Yield: ", 1);
		b.yieldpercent_amts = this.getArray("Yield Type: ", 1);
		b.yieldpercents = this.getArray("Yield Type: ", 0);
		b.yields = this.getArray("Yield: ", 0);
		String[] data = panels.get("Terrain: ").getList();
		b.ters = decode(data, 0);
		String[] remaining = decode(data, 1);
		b.teryields = getArray(remaining, 0);
		b.teryield_amts = getArray(remaining, 1);
		String[] data2 = panels.get("Feature: ").getList();
		b.feats = decode(data2, 0);
		String[] remaining2 = decode(data2, 1);
		b.featyields = getArray(remaining2, 0);
		b.featyield_amts = getArray(remaining2, 1);
		String[] data3 = panels.get("Resource: ").getList();
		b.res = decode(data3, 0);
		String[] remaining3 = decode(data3, 1);
		b.resyields = getArray(remaining3, 0);
		b.resyield_amts = getArray(remaining3, 1);
		b.givenres = this.getArray("Gives Resource: ", 0);
		b.givenresamts = this.getArray("Gives Resource: ", 1);
		b.reqres = this.getArray("Requires Resource: ", 0);
		b.reqresamts = this.getArray("Requires Resource: ", 1);
		b.combmod = this.getArray("Combat Production: ", 0);
		b.combmodamts = this.getArray("Combat Production: ", 1);
		b.ors = this.panels.get("City Must Have: ").getList();
		return b;
	}

	private String[] decode(String[] data, int type) {
		ArrayList<String> x = new ArrayList<String>(0);
		for (String s : data) {
			if (type == 0) {
				x.add(s.split("/")[0]);
			} else if (type == 1) {
				x.add(s.split("/")[1]);
			}
		}
		String[] output = new String[x.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = x.get(i);
		}
		return output;
	}

	public void load(StructBuilding b) {

		superClass.setSelectedItem(b.build_class);
		buildingMod.setText(b.building_mod);
		displaypos.setText(b.display_pos);
		happiness.setText(b.happiness);
		hitpoints.setText(b.hitpoints);
		atlas.setText(b.icon_atlas);
		mat.setText(b.maintenance);
		mountain.setSelected(b.mountain);
		name.setText(b.name);
		portindex.setText(b.portrait_index);
		preqTech.setSelectedItem(b.preq_tech);
		productionCost.setText(b.prod_cost);
		river.setSelected(b.river);
		sea.setSelected(b.sea);
		tip.setText(b.tip);
		for (int i = 0; i < b.exp_amts.length; i++) {
			this.panels.get("Unit Experience: ").addToList(
					b.exp_types[i] + ":" + b.exp_amts[i]);
		}
		for (int i = 0; i < b.flavor_amts.length; i++) {
			this.panels.get("Flavor: ").addToList(
					b.flavors[i] + ":" + b.flavor_amts[i]);
		}
		for (int i = 0; i < b.prod_types.length; i++) {
			this.panels.get("Unit Production Bonus: ").addToList(
					b.prod_types[i] + ":" + b.prod_amt_to_types[i]);
		}
		for (int i = 0; i < b.yield_amts.length; i++) {
			this.panels.get("Yield: ").addToList(
					b.yields[i] + ":" + b.yield_amts[i]);
		}
		for (int i = 0; i < b.yieldpercents.length; i++) {
			this.panels.get("Yield Type: ").addToList(
					b.yieldpercents[i] + ":" + b.yieldpercent_amts[i]);
		}
		for (int i = 0; i < b.ters.length; i++) {
			this.panels.get("Terrain: ")
					.addToList(
							b.ters[i] + "/" + b.teryields[i] + ":"
									+ b.teryield_amts[i]);
		}
		for (int i = 0; i < b.feats.length; i++) {
			this.panels.get("Feature: ").addToList(
					b.feats[i] + "/" + b.featyields[i] + ":"
							+ b.featyield_amts[i]);
		}
		for (int i = 0; i < b.res.length; i++) {
			this.panels.get("Resource: ").addToList(
					b.res[i] + "/" + b.resyields[i] + ":" + b.resyield_amts[i]);
		}
		for (int i = 0; i < b.givenres.length; i++) {
			this.panels.get("Gives Resource: ").addToList(
					b.givenres[i] + ":" + b.givenresamts[i]);
		}
		for (int i = 0; i < b.reqres.length; i++) {
			this.panels.get("Requires Resource: ").addToList(
					b.reqres[i] + ":" + b.reqresamts[i]);
		}
		for (int i = 0; i < b.combmod.length; i++) {
			this.panels.get("Combat Production: ").addToList(
					b.combmod[i] + ":" + b.combmodamts[i]);
		}
		for (int i = 0; i < b.ors.length; i++) {
			this.panels.get("City Must Have: ").addToList(b.ors[i]);
		}
	}
}
