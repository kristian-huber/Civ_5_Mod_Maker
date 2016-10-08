package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import structs.StructTrait;
import util.Constants;

public class TabTraits extends Tab {

	private JTextField name, description, lvlexpmod, gpmod, gsmod, ggmod,
			ggbonus, cityumod, popumod, landbarb, seabarb, landmat, seamat,
			policymod, embarkmoves, bonushightech, bonusagainstbigciv, razemod,
			dofmod, exspies, extraland, workspeed, afraidminor, embarkcost,
			improv_amt, unimprov_amt, resource_amt;
	public JComboBox<String> buildingOnCapture, promo, unit_type, improv,
			improv_yield, unimprov, unimprov_yield, resource;
	private JCheckBox zerocitiesalive, fightdam, woodroad, extrabelief,
			forestfaith, buycity, c;

	public TabTraits() {

		name = new JTextField();
		addComponent(1, "Trait Name: ", name);

		description = new JTextField();
		addComponent(1, "Description: ", description);

		lvlexpmod = new JTextField();
		addComponent(1, "Level Exp Modifer (%): ", lvlexpmod);

		gpmod = new JTextField();
		addComponent(1, "Great Person Modifer (%): ", gpmod);

		gsmod = new JTextField();
		addComponent(1, "Great Sci Modifer (%): ", gsmod);

		ggmod = new JTextField();
		addComponent(1, "Great General Modifer (%): ", ggmod);

		ggbonus = new JTextField();
		addComponent(1, "Great General Bonus (%): ", ggbonus);

		dofmod = new JTextField();
		addComponent(1, "DOF Great Person (%): ", dofmod);

		cityumod = new JTextField();
		addComponent(1, "City Unhappiness (%): ", cityumod);

		popumod = new JTextField();
		addComponent(1, "Pop Unhappiness (%): ", popumod);

		landbarb = new JTextField();
		addComponent(1, "Land Barb Convert (%): ", landbarb);

		seabarb = new JTextField();
		addComponent(1, "Sea Barb Convert (%): ", seabarb);

		landmat = new JTextField();
		addComponent(1, "Land Maintenance (%): ", landmat);

		seamat = new JTextField();
		addComponent(1, "Sea Maintenance (%): ", seamat);

		policymod = new JTextField();
		addComponent(1, "Policy Modifier (%): ", policymod);

		embarkcost = new JTextField();
		addComponent(1, "Embarkment Cost: ", embarkcost);

		embarkmoves = new JTextField();
		addComponent(1, "Extra Embark Moves: ", embarkmoves);

		bonushightech = new JTextField();
		addComponent(1, "Bonus vs Tech (%): ", bonushightech);

		bonusagainstbigciv = new JTextField();
		addComponent(1, "Bonus vs Big Civ (%): ", bonusagainstbigciv);

		razemod = new JTextField();
		addComponent(1, "Raze City Modifer (%): ", razemod);

		exspies = new JTextField();
		addComponent(1, "Extra Spies: ", exspies);

		extraland = new JTextField();
		addComponent(1, "Extra Land: ", extraland);

		workspeed = new JTextField();
		addComponent(1, "Work Speed (%): ", workspeed);

		afraidminor = new JTextField();
		addComponent(1, "Minor Afraid Influence: ", afraidminor);

		c = new JCheckBox("Building on Capture");
		c.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				buildingOnCapture.setEnabled(c.isSelected());
			}
		});
		addComponent(1, c);

		buildingOnCapture = new JComboBox<String>(Window.copy(Window.buildings));
		buildingOnCapture.setEnabled(false);
		addComponent(1, buildingOnCapture);

		zerocitiesalive = new JCheckBox("No Cities Still Alive");
		addComponent(1, zerocitiesalive);

		fightdam = new JCheckBox("Fight While Damaged");
		addComponent(1, fightdam);

		woodroad = new JCheckBox("Forest As Road");
		addComponent(1, woodroad);

		extrabelief = new JCheckBox("Extra Belief");
		addComponent(1, extrabelief);

		forestfaith = new JCheckBox("Faith from Forest");
		addComponent(1, forestfaith);

		buycity = new JCheckBox("Buy City States");
		addComponent(1, buycity);

		unit_type = new JComboBox<String>(Constants.UNIT_TYPES);
		promo = new JComboBox<String>(Window.copy(Window.promotions));
		addListBoxC(1, "Unit Type: ", unit_type, "Promotion: ", promo);

		addPage();

		addLabel(1, "");

		JButton nextPage = new JButton("Next Page");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_TRAIT,
						pages.get(1));
				pages.get(1).repaint();
			}
		});
		addComponent(1, nextPage);

		improv = new JComboBox<String>(Window.copy(Window.improvements));
		improv_yield = new JComboBox<String>(Constants.YIELD_TYPES);
		improv_amt = new JTextField();
		addListBoxD(2, "Improvement: ", improv, "Improvement Yield: ",
				improv_yield, "Yield Amount: ", improv_amt);

		resource = new JComboBox<String>(Window.copy(Window.resources));
		resource_amt = new JTextField();
		addListBoxA(2, "Resource: ", resource, "Modifier (%):", resource_amt);

		addLabel(2, "");
		JButton prevPage = new JButton("Previous Page");
		prevPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_TRAIT,
						pages.get(0));
				pages.get(0).repaint();
			}
		});
		addComponent(2, prevPage);

		unimprov = new JComboBox<String>(Constants.FEATURES);
		unimprov_yield = new JComboBox<String>(Constants.YIELD_TYPES);
		unimprov_amt = new JTextField();
		addListBoxD(2, "Feature: ", unimprov, "Feature Yield: ",
				unimprov_yield, "Yield Amount: ", unimprov_amt);
	}

	public StructTrait getTrait() {
		StructTrait s = new StructTrait();

		s.afraidmin = afraidminor.getText();
		s.buycity = buycity.isSelected();
		s.cityumod = cityumod.getText();
		s.desc = description.getText();
		s.dofgpmod = dofmod.getText();
		s.embcost = embarkcost.getText();
		s.exbelief = extrabelief.isSelected();
		s.exembmoves = embarkmoves.getText();
		s.exspies = exspies.getText();
		s.exterritory = extraland.getText();
		s.faithforest = forestfaith.isSelected();
		s.fightdam = fightdam.isSelected();
		if (buildingOnCapture.isEnabled()) {
			s.freebuilding = Window.buildings.getElementAt(buildingOnCapture
					.getSelectedIndex());
		} else {
			s.freebuilding = "NONE";
		}
		s.ggexbonus = ggbonus.getText();
		s.ggrate = ggmod.getText();
		s.gprate = gpmod.getText();
		s.gsrate = gsmod.getText();
		s.landbarb = landbarb.getText();
		s.landmat = landmat.getText();
		s.lowtech = bonushightech.getText();
		s.lvlexpmod = lvlexpmod.getText();
		s.name = name.getText();
		s.name_constant = name.getText().toUpperCase().replaceAll(" ", "_");
		s.nocityalive = zerocitiesalive.isSelected();
		s.policymod = policymod.getText();
		s.popumod = popumod.getText();
		s.razemod = razemod.getText();
		s.seabarb = seabarb.getText();
		s.seamat = seamat.getText();
		s.smallciv = bonusagainstbigciv.getText();
		s.woodroad = woodroad.isSelected();
		s.workspeed = workspeed.getText();
		s.quantres = getArray(panels.get("Resource: ").getList(), 0);
		s.quantresamt = getArray(panels.get("Resource: ").getList(), 1);
		s.promotions = getArray(panels.get("Unit Type: ").getList(), 1);
		s.unit_types = getArray(panels.get("Unit Type: ").getList(), 0);
		String[] data = panels.get("Improvement: ").getList();
		s.improv = decode(data, 0);
		String[] remaining = decode(data, 1);
		s.improvyieldamt = getArray(remaining, 1);
		s.improvyield = getArray(remaining, 0);
		String[] data2 = panels.get("Feature: ").getList();
		s.feature = decode(data2, 0);
		String[] remaining2 = decode(data, 1);
		s.featureyeildamt = getArray(remaining2, 1);
		s.featureyield = getArray(remaining2, 0);

		return s;
	}

	public void load(StructTrait s) {

		afraidminor.setText(s.afraidmin);
		buycity.setSelected(s.buycity);
		cityumod.setText(s.cityumod);
		description.setText(s.desc);
		dofmod.setText(s.dofgpmod);
		embarkcost.setText(s.embcost);
		extrabelief.setSelected(s.exbelief);
		embarkmoves.setText(s.exembmoves);
		exspies.setText(s.exspies);
		extraland.setText(s.exterritory);
		forestfaith.setSelected(s.faithforest);
		fightdam.setSelected(s.fightdam);
		if (s.freebuilding.equals("NONE")) {
			c.setSelected(false);
			buildingOnCapture.setEnabled(false);
		} else {
			c.setSelected(true);
			buildingOnCapture.setSelectedItem(s.freebuilding);
		}
		ggbonus.setText(s.ggexbonus);
		ggmod.setText(s.ggrate);
		gpmod.setText(s.gprate);
		gsmod.setText(s.gsrate);
		landbarb.setText(s.landbarb);
		landmat.setText(s.landmat);
		bonushightech.setText(s.lowtech);
		lvlexpmod.setText(s.lvlexpmod);
		name.setText(s.name);
		zerocitiesalive.setSelected(s.nocityalive);
		policymod.setText(s.policymod);
		popumod.setText(s.popumod);
		razemod.setText(s.razemod);
		seabarb.setText(s.seabarb);
		seamat.setText(s.seamat);
		bonusagainstbigciv.setText(s.smallciv);
		woodroad.setSelected(s.woodroad);
		workspeed.setText(s.workspeed);
		for (int i = 0; i < s.quantres.length; i++) {
			panels.get("Resource: ").addToList(
					s.quantres[i] + ":" + s.quantresamt[i]);
		}
		for (int i = 0; i < s.promotions.length; i++) {
			panels.get("Unit Type: ").addToList(
					s.unit_types[i] + ":" + s.promotions[i]);
		}
		for (int i = 0; i < s.improv.length; i++) {
			panels.get("Improvement: ").addToList(
					s.improv[i] + ":" + s.improvyield[i] + ":" + s.improvyieldamt[i]);
		}
		for (int i = 0; i < s.feature.length; i++) {
			panels.get("Feature: ").addToList(
					s.feature[i] + ":" + s.featureyield[i] + ":"
							+ s.featureyeildamt[i]);
		}
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
}
