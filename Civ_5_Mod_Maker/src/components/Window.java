package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import structs.StructBuilding;
import structs.StructCivilization;
import structs.StructLeader;
import structs.StructTrait;
import structs.StructUnit;
import util.Constants;
import util.IOHelper;

public class Window extends JFrame {
	public static DefaultComboBoxModel<String> buildings = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> units = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> leaders = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> traits = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> promotions = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> resources = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> improvements = new DefaultComboBoxModel<String>();
	public static DefaultComboBoxModel<String> techs = new DefaultComboBoxModel<String>();
	
	public static HashMap<String, StructCivilization> outputCivs = new HashMap<String, StructCivilization>();
	public static HashMap<String, StructBuilding> outputBuilds = new HashMap<String, StructBuilding>();
	public static HashMap<String, StructLeader> outputLeads = new HashMap<String, StructLeader>();
	public static HashMap<String, StructTrait> outputTraits = new HashMap<String, StructTrait>();
	public static HashMap<String, StructUnit> outputUnits = new HashMap<String, StructUnit>();

	public TabBuildings b;
	public TabCivilizations c;
	public TabHome h;
	public TabLeaders l;
	public TabTraits t;
	public TabUnits u;

	private static final long serialVersionUID = 1L;

	public static JTabbedPane fileTypes;
	private JButton export, add;

	public Window() {

		try {
			loadFiles("Units", units);
			loadFiles("Buildings", buildings);
			loadFiles("Leaders", leaders);
			loadFiles("Traits", traits);
			loadFiles("Promotions", promotions);
			loadFiles("Resources", resources);
			loadFiles("Improvements", improvements);
			loadFiles("Techs", techs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Civilization V Editor");
		this.setResizable(false);
		this.setSize(675, 505);
		this.setLayout(null);

		fileTypes = new JTabbedPane();
		fileTypes.setFont(Constants.ARIAL12);
		l = new TabLeaders();
		b = new TabBuildings();
		c = new TabCivilizations();
		t = new TabTraits();
		u = new TabUnits();
		h = new TabHome(this);
		fileTypes.setBounds(5, 35, 658, 435);
		fileTypes.addTab("Home", h.getTab());
		fileTypes.addTab("Buildings", b.getTab());
		fileTypes.addTab("Civilizations", c.getTab());
		fileTypes.addTab("Leaders", l.getTab());
		fileTypes.addTab("Traits", t.getTab());
		fileTypes.addTab("Units", u.getTab());
		this.add(fileTypes);

		export = new JButton("Export Project");
		export.setBounds(5, 5, 335, 25);
		export.setFont(Constants.ARIAL12);
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileTypes.setSelectedIndex(0);
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				if (!outputLeads.isEmpty()) {
					IOHelper.writeLeaderFile(outputLeads.values(), chooser);
				}
				if (!outputCivs.isEmpty()) {
					IOHelper.writeCivFile(outputCivs.values(), chooser);
				}
				if (!outputBuilds.isEmpty()) {
					IOHelper.writeBuildingFile(outputBuilds.values(), chooser);
				}
				if (!outputTraits.isEmpty()) {
					IOHelper.writeTraitFile(outputTraits.values(), chooser);
				}
				if (!outputUnits.isEmpty()) {
					IOHelper.writeUnitFile(outputUnits.values(), chooser);
				}
			}
		});
		this.add(export);

		add = new JButton("Add Current File");
		add.setFont(Constants.ARIAL12);
		add.setBounds(345, 5, 320, 25);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Are You Sure You Want to Save This File?");

				if (reply == JOptionPane.YES_OPTION) {

					if (fileTypes.getSelectedIndex() == Constants.TAB_BUILDING) {
						StructBuilding x = b.getBuilding();
						if(outputBuilds.containsKey(x.name)){
							int r = JOptionPane.showConfirmDialog(null, "Override Current File?");
							if(r == JOptionPane.YES_OPTION){
								outputBuilds.remove(x.name);
								outputBuilds.put(x.name, x);
								b.reset();	
							}
						}else{
							addBuilding(x.name_constant);
							outputBuilds.put(x.name, x);
							h.addToList("Building: " + x.name);
							b.reset();
						}
					} else if (fileTypes.getSelectedIndex() == Constants.TAB_CIVILIZATION) {
						StructCivilization x = c.getCiv();
						if(outputCivs.containsKey(x.name)){
							int r = JOptionPane.showConfirmDialog(null, "Override Current File?");
							if(r == JOptionPane.YES_OPTION){
								outputCivs.remove(x.name);
								outputCivs.put(x.name, x);
								c.reset();	
							}
						}else{
							outputCivs.put(x.name, x);
							h.addToList("Civilization: " + x.name);
							c.reset();
						}
					} else if (fileTypes.getSelectedIndex() == Constants.TAB_LEADER) {
						StructLeader x = l.getLeader();
						if(outputLeads.containsKey(x.vals[2])){
							int r = JOptionPane.showConfirmDialog(null, "Override Current File?");
							if(r == JOptionPane.YES_OPTION){
								outputLeads.remove(x.vals[2]);
								outputLeads.put(x.vals[2], x);
								c.reset();	
							}
						}else{
							outputLeads.put(x.vals[2], x);
							addLeader(x.vals[1]);
							h.addToList("Leader: " + x.vals[2]);
							l.reset();
						}
					} else if (fileTypes.getSelectedIndex() == Constants.TAB_TRAIT) {
						StructTrait x = t.getTrait();
						if(outputTraits.containsKey(x.name)){
							int r = JOptionPane.showConfirmDialog(null, "Override Current File?");
							if(r == JOptionPane.YES_OPTION){
								outputTraits.remove(x.name);
								outputTraits.put(x.name, x);
								t.reset();	
							}
						}else{
							outputTraits.put(x.name, x);
							addTrait(x.name_constant);
							h.addToList("Trait: " + x.name);
							t.reset();
						}
					} else if (fileTypes.getSelectedIndex() == Constants.TAB_UNIT) {
						StructUnit x = u.getUnit();
						if(outputUnits.containsKey(x.name)){
							int r = JOptionPane.showConfirmDialog(null, "Override Current File?");
							if(r == JOptionPane.YES_OPTION){
								outputUnits.remove(x.name);
								outputUnits.put(x.name, x);
								u.reset();
							}
						}else{
							outputUnits.put(x.name, x);
							addUnit(x.name_constant);
							h.addToList("Unit: " + x.name);
							u.reset();
						}
					}
				}
			}
		});
		this.add(add);

		this.setVisible(true);
	}

	public static DefaultComboBoxModel<String> copy(
			DefaultComboBoxModel<String> c) {
		DefaultComboBoxModel<String> d = new DefaultComboBoxModel<String>();
		for (int i = 0; i < c.getSize(); i++) {
			d.addElement(c.getElementAt(i));
		}
		return d;
	}

	public void addUnit(String unit) {
		u.upgrade.addItem(unit);
		units.addElement(unit);
	}

	public void addLeader(String leader) {
		c.leader.addItem(leader);
		leaders.addElement(leader);
	}

	public void addBuilding(String building) {
		t.buildingOnCapture.addItem(building);
		c.unew.addItem(building);
		buildings.addElement(building);
	}

	public void addTrait(String trait) {
		l.traits.addItem(trait);
		traits.addElement(trait);
	}

	public void loadFiles(String file, DefaultComboBoxModel<String> list)
			throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(getClass()
				.getResourceAsStream("/" + file + ".txt")));

		String line = "";
		while ((line = br.readLine()) != null) {
			list.addElement(line);
		}
	}
}
