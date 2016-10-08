package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import structs.StructUnit;
import util.Constants;

public class TabUnits extends Tab {
	JTextField name, description, help, combat, rangedcombat, prodCost, moves,
			range, sight, airinterceptrange, religionspreads, removehersey,
			rstrength, expattack, expdefense, unitartinfo, unitflagiconoffset,
			portraitindex, iconatlas, unitflagatlas;
	JComboBox<String> uclass, combatclass, domain, defaultai, preqtech,
			obsoletetech, upgrade, moverate;
	JCheckBox canGoRival, nomaintenance, canreligion, foundsreligion,
			buycitystate, autoexplore;

	JComboBox<String> unitais, builds, promotions, flavor, resource,
			yieldfromkills;
	JTextField flavoramt, resourceamt, yieldfromkillsamt;

	public TabUnits() {

		name = new JTextField();
		addComponent(1, "Unit Name: ", name);

		description = new JTextField();
		addComponent(1, "Description: ", description);

		help = new JTextField();
		addComponent(1, "Help: ", help);

		prodCost = new JTextField();
		addComponent(1, "Production Cost: ", prodCost);

		moves = new JTextField();
		addComponent(1, "Moves: ", moves);

		combat = new JTextField();
		addComponent(1, "Combat Strength: ", combat);

		rangedcombat = new JTextField();
		addComponent(1, "Ranged Strength: ", rangedcombat);

		range = new JTextField();
		addComponent(1, "Range: ", range);

		sight = new JTextField();
		addComponent(1, "Sight", sight);

		airinterceptrange = new JTextField();
		addComponent(1, "Air Interception Range: ", airinterceptrange);

		religionspreads = new JTextField();
		addComponent(1, "Religion Spreads: ", religionspreads);

		removehersey = new JTextField();
		addComponent(1, "Remove Heresy: ", removehersey);

		rstrength = new JTextField();
		addComponent(1, "Religious Strength: ", rstrength);

		expattack = new JTextField();
		addComponent(1, "Exp From Attacking: ", expattack);

		expdefense = new JTextField();
		addComponent(1, "Exp From Defending: ", expdefense);

		unitartinfo = new JTextField();
		addComponent(1, "Unit Art Info: ", unitartinfo);

		unitflagatlas = new JTextField();
		addComponent(1, "Unit Flag Atlas: ", unitflagatlas);

		unitflagiconoffset = new JTextField();
		addComponent(1, "Unit Flag Icon Offset: ", unitflagiconoffset);

		iconatlas = new JTextField();
		addComponent(1, "Icon Atlas: ", iconatlas);

		portraitindex = new JTextField();
		addComponent(1, "Portrait Index: ", portraitindex);

		DefaultComboBoxModel<String> d = Window.copy(Window.units);
		d.insertElementAt("ITSELF", 0);
		uclass = new JComboBox<String>(d);
		uclass.setToolTipText("Select ITSELF if you aren't doing a Unique Unit");
		uclass.setSelectedIndex(0);
		addComponent(1, "Unit Class: ", uclass);

		combatclass = new JComboBox<String>(Constants.UNIT_TYPES);
		addComponent(1, "Combat Class: ", combatclass);

		domain = new JComboBox<String>(Constants.UNIT_DOMAINS);
		addComponent(1, "Unit Domain: ", domain);

		defaultai = new JComboBox<String>(Constants.AI);
		addComponent(1, "Default AI: ", defaultai);

		DefaultComboBoxModel<String> d3 = Window.copy(Window.techs);
		d3.insertElementAt("NONE", 0);
		preqtech = new JComboBox<String>(d3);
		preqtech.setSelectedIndex(0);
		addComponent(1, "Prerequisite Tech: ", preqtech);

		DefaultComboBoxModel<String> d5 = Window.copy(Window.techs);
		d5.insertElementAt("NONE", 0);
		obsoletetech = new JComboBox<String>(d5);
		obsoletetech.setSelectedIndex(0);
		addComponent(1, "Obsolete Tech: ", obsoletetech);

		DefaultComboBoxModel<String> d2 = Window.copy(Window.units);
		d2.insertElementAt("NONE", 0);
		upgrade = new JComboBox<String>(d2);
		upgrade.setSelectedIndex(0);
		addComponent(1, "Upgrades To: ", upgrade);

		moverate = new JComboBox<String>(Constants.UNIT_MOVES);
		addComponent(1, "Move Rate: ", moverate);

		canGoRival = new JCheckBox("Enter Foreign Lands");
		addComponent(1, canGoRival);

		nomaintenance = new JCheckBox("No Maintenance");
		addComponent(1, nomaintenance);

		canreligion = new JCheckBox("Can Spread Religion");
		addComponent(1, canreligion);

		foundsreligion = new JCheckBox("Founds a Religion");
		addComponent(1, foundsreligion);

		buycitystate = new JCheckBox("Buys a City State");
		addComponent(1, buycitystate);

		autoexplore = new JCheckBox("Auto Explore");
		addComponent(1, autoexplore);

		addPage();

		addLabel(1, "");

		JButton nextPage = new JButton("Next Page");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_UNIT,
						pages.get(1));
				pages.get(1).repaint();
			}
		});
		addComponent(1, nextPage);

		unitais = new JComboBox<String>(Constants.AI);
		addListBoxE(2, "Add Unit AI: ", unitais);

		builds = new JComboBox<String>(Window.copy(Window.improvements));
		addListBoxE(2, "Can Build: ", builds);

		promotions = new JComboBox<String>(Window.copy(Window.promotions));
		addListBoxE(2, "Promotions: ", promotions);

		addLabel(2, "");

		flavor = new JComboBox<String>(Constants.FLAVORS);
		flavoramt = new JTextField();
		addListBoxA(2, "Flavor: ", flavor, "Amount: ", flavoramt);

		next(10);

		resource = new JComboBox<String>(Window.copy(Window.resources));
		resourceamt = new JTextField();
		addListBoxA(2, "Resource: ", resource, "Amount: ", resourceamt);

		next(10);

		yieldfromkills = new JComboBox<String>(Constants.YIELD_TYPES);
		yieldfromkillsamt = new JTextField();
		addListBoxA(2, "Yield Per Kill: ", yieldfromkills, "Amount: ",
				yieldfromkillsamt);

		next(9);

		JButton nextPage2 = new JButton("First Page");
		nextPage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_UNIT,
						pages.get(0));
				pages.get(0).repaint();
			}
		});
		addComponent(2, nextPage2);
	}

	public StructUnit getUnit() {
		StructUnit u = new StructUnit();

		u.airinterceptrange = airinterceptrange.getText();
		u.autoexplore = autoexplore.isSelected();
		u.buildings = panels.get("Can Build: ").getList();
		u.buycitystate = buycitystate.isSelected();
		u.canGoRival = canGoRival.isSelected();
		u.combat = combat.getText();
		u.combatclass = combatclass.getSelectedItem().toString();
		u.defaultai = defaultai.getSelectedItem().toString();
		u.description = description.getText();
		u.domain = domain.getSelectedItem().toString();
		u.expattack = expattack.getText();
		u.expdefense = expdefense.getText();
		u.foundsreligion = foundsreligion.isSelected();
		u.help = help.getText();
		u.iconatlas = iconatlas.getText();
		u.moves = moves.getText();
		u.moverate = moverate.getSelectedItem().toString();
		u.name = name.getText();
		u.name_constant = name.getText().toUpperCase().replaceAll(" ", "_");
		u.nomaintenance = nomaintenance.isSelected();
		u.obsoltetech = obsoletetech.getSelectedItem().toString();
		u.portraitindex = portraitindex.getText();
		u.preqtech = preqtech.getSelectedItem().toString();
		u.prodcost = prodCost.getText();
		u.promotions = panels.get("Promotions: ").getList();
		u.range = range.getText();
		u.rangedcombat = rangedcombat.getText();
		u.religionspreads = religionspreads.getText();
		u.relstrength = rstrength.getText();
		u.removeheresy = removehersey.getText();
		u.sight = sight.getText();
		u.uclass = uclass.getSelectedItem().toString();
		u.unitartinfo = unitartinfo.getText();
		u.unitais = panels.get("Add Unit AI: ").getList();
		u.unitflagatlas = unitflagatlas.getText();
		u.unitflagiconoffset = unitflagiconoffset.getText();
		u.upgradesTo = upgrade.getSelectedItem().toString();
		u.flavoramts = this.getArray("Flavor: ", 1);
		u.flavors = this.getArray("Flavor: ", 0);
		u.resourceamts = this.getArray("Resource: ", 1);
		u.resources = this.getArray("Resource: ", 0);
		u.yfromkill = this.getArray("Yield Per Kill: ", 0);
		u.yfromkillamt = this.getArray("Yield Per Kill: ", 1);

		return u;
	}
	
	public void load(StructUnit u){
		
		airinterceptrange.setText(u.airinterceptrange);
		autoexplore.setSelected(u.autoexplore);
		for(String s : u.buildings){
			panels.get("Can Build: ").addToList(s);	
		}
		buycitystate.setSelected(u.buycitystate);
		canGoRival.setSelected(u.canGoRival);
		combat.setText(u.combat);
		combatclass.setSelectedItem(u.combatclass);
		defaultai.setSelectedItem(u.defaultai);
		description.setText(u.description);
		domain.setSelectedItem(u.domain);
		expattack.setText(u.expattack);
		expdefense.setText(u.expdefense);
		foundsreligion.setSelected(u.foundsreligion);
		help.setText(u.help);
		iconatlas.setText(u.iconatlas);
		moves.setText(u.moves);
		moverate.setSelectedItem(u.moverate);
		name.setText(u.name);
		nomaintenance.setSelected(u.nomaintenance);
		obsoletetech.setSelectedItem(u.obsoltetech);
		portraitindex.setText(u.portraitindex);
		preqtech.setSelectedItem(u.preqtech);
		prodCost.setText(u.prodcost);
		for(String s : u.promotions){
			 panels.get("Promotions: ").addToList(s);
		}
		range.setText(u.range);
		rangedcombat.setText(u.rangedcombat);
		religionspreads.setText(u.religionspreads);
		rstrength.setText(u.relstrength);
		removehersey.setText(u.removeheresy);
		sight.setText(u.sight);
		uclass.setSelectedItem(u.uclass);
		unitartinfo.setText(u.unitartinfo);
		for(String s : u.unitais){
			 panels.get("Add Unit AI: ").addToList(s);
		}
		unitflagatlas.setText(u.unitflagatlas);
		unitflagiconoffset.setText(u.unitflagiconoffset);
		upgrade.setSelectedItem(u.upgradesTo);
		for(int i = 0; i < u.flavoramts.length; i++){
			this.panels.get("Flavor: ").addToList(u.flavors[i] + ":" + u.flavoramts[i]);
		}
		for(int i = 0; i < u.resourceamts.length; i++){
			this.panels.get("Resource: ").addToList(u.resources[i] + ":" + u.resourceamts[i]);
		}
		for(int i = 0; i < u.yfromkill.length; i++){
			this.panels.get("Yield Per Kill: ").addToList(u.yfromkill[i] + ":" + u.yfromkillamt[i]);
		}
	}
}
