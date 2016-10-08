package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;

import structs.StructLeader;
import util.Constants;

public class TabLeaders extends Tab {
	public static final String[] GENDER = { "masculine", "feminine" };

	JSlider victory, wonder, minor, bold, diplobal, warmhate, workagainst,
			workwith, denounce, doFor, loyal, need, forgiv, chat, mean, war,
			hostile, deceptive, guarded, afraid, friendly, neutral, minIgnor,
			minFriendly, minProtective, minConquest, minBully, offense,
			defense, cityDef, training, recon, ranged, mobile, naval,
			navalrecon, navalgrowth, navaltile, air, expansion, growth,
			tileimp, infra, production, gold, science, culture, happiness,
			great, wonder2, religion, diplomacy, space, waterconnect, nuke,
			usenuke, spying, antiair, carrier, arch, landtrade, seatrade,
			tradeorigin, tradedestination, airlift;
	JTextField leader, leaderScene, iconatlas, index;
	public JComboBox<String> gender, traits;

	public TabLeaders() {

		leader = new JTextField();
		addComponent(1, "Leader Name: ", leader);

		gender = new JComboBox<String>(GENDER);
		addComponent(1, "Gender: ", gender);

		leaderScene = new JTextField();
		addComponent(1, "Leader Scene: ", leaderScene);

		traits = new JComboBox<String>(Window.copy(Window.traits));
		addComponent(1, "Trait: ", traits);

		iconatlas = new JTextField();
		addComponent(1, "Icon Atlas: ", iconatlas);

		index = new JTextField();
		addComponent(1, "Portrait Index: ", index);

		victory = new JSlider();
		addSlider(1, "Competition Victory: ", victory);
		wonder = new JSlider();
		addSlider(1, "Competition Wonders:", wonder);
		minor = new JSlider();
		addSlider(1, "Competition City-States:", minor);
		bold = new JSlider();
		addSlider(1, "Boldness", bold);
		diplobal = new JSlider();
		addSlider(1, "Diplomacy Balance: ", diplobal);
		warmhate = new JSlider();
		addSlider(1, "Warmongerer Hate: ", warmhate);
		workagainst = new JSlider();
		addSlider(1, "Work Against Will: ", workagainst);
		workwith = new JSlider();
		addSlider(1, "Work With Will: ", workwith);
		denounce = new JSlider();
		addSlider(1, "Denounce: ", denounce);
		doFor = new JSlider();
		addSlider(1, "Do For Likeliness: ", doFor);
		loyal = new JSlider();
		addSlider(1, "Loyalty: ", loyal);
		need = new JSlider();
		addSlider(1, "Neediness: ", need);
		forgiv = new JSlider();
		addSlider(1, "Forgiveness: ", forgiv);
		chat = new JSlider();
		addSlider(1, "Chattiness: ", chat);
		mean = new JSlider();
		addSlider(1, "Meanness: ", mean);
		war = new JSlider();
		addSlider(1, "Maj Civ War: ", war);
		hostile = new JSlider();
		addSlider(1, "Maj Civ Hostile: ", hostile);
		deceptive = new JSlider();
		addSlider(1, "Maj Civ Deceptive: ", deceptive);
		guarded = new JSlider();
		addSlider(1, "Maj Civ Guarded: ", guarded);
		afraid = new JSlider();
		addSlider(1, "Maj Civ Afraid: ", afraid);
		friendly = new JSlider();
		addSlider(1, "Maj Civ Friendly: ", friendly);
		neutral = new JSlider();
		addSlider(1, "Maj Civ Neutral: ", neutral);
		minIgnor = new JSlider();
		addSlider(1, "Min Civ Ignor: ", minIgnor);
		minFriendly = new JSlider();
		addSlider(1, "Min Civ Friendly", minFriendly);
		minProtective = new JSlider();
		addSlider(1, "Min Civ Protective: ", minProtective);

		addPage();

		addLabel(1, "");

		JButton nextPage = new JButton("Next Page");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_LEADER,
						pages.get(1));
				pages.get(1).repaint();
			}
		});
		addComponent(1, nextPage);

		minConquest = new JSlider();
		addSlider(2, "Min Civ Conquest: ", minConquest);
		minBully = new JSlider();
		addSlider(2, "Min Civ Bully: ", minBully);
		offense = new JSlider();
		addSlider(2, "Flavor Offense: ", offense);
		defense = new JSlider();
		addSlider(2, "Flavor Defense: ", defense);
		cityDef = new JSlider();
		addSlider(2, "Flavor City Defense: ", cityDef);
		training = new JSlider();
		addSlider(2, "Flavor Training: ", training);
		recon = new JSlider();
		addSlider(2, "Flavor Recon: ", recon);
		ranged = new JSlider();
		addSlider(2, "Flavor Ranged: ", ranged);
		mobile = new JSlider();
		addSlider(2, "Flavor Mobile: ", mobile);
		naval = new JSlider();
		addSlider(2, "Flavor Naval: ", naval);
		navalrecon = new JSlider();
		addSlider(2, "Flavor Naval Recon: ", navalrecon);
		navalgrowth = new JSlider();
		addSlider(2, "Flavor Naval Growth: ", navalgrowth);
		navaltile = new JSlider();
		addSlider(2, "Flavor Sea Tile Improve: ", navaltile);
		air = new JSlider();
		addSlider(2, "Flavor Air Production: ", air);
		expansion = new JSlider();
		addSlider(2, "Flavor Expansion: ", expansion);
		growth = new JSlider();
		addSlider(2, "Flavor Growth: ", growth);
		tileimp = new JSlider();
		addSlider(2, "Flavor Tile Improvement: ", tileimp);
		infra = new JSlider();
		addSlider(2, "Flavor Roads: ", infra);
		production = new JSlider();
		addSlider(2, "Flavor Production: ", production);
		gold = new JSlider();
		addSlider(2, "Flavor Gold: ", gold);
		science = new JSlider();
		addSlider(2, "Flavor Science: ", science);
		culture = new JSlider();
		addSlider(2, "Flavor Culture: ", culture);
		happiness = new JSlider();
		addSlider(2, "Flavor Happiness: ", happiness);
		great = new JSlider();
		addSlider(2, "Flavor Great People: ", great);
		wonder2 = new JSlider();
		addSlider(2, "Flavor Wonders: ", wonder2);
		religion = new JSlider();
		addSlider(2, "Flavor Religion: ", religion);
		diplomacy = new JSlider();
		addSlider(2, "Flavor Diplomacy: ", diplomacy);
		space = new JSlider();
		addSlider(2, "Flavor Space Ship: ", space);
		waterconnect = new JSlider();
		addSlider(2, "Flavor Water Connection: ", waterconnect);
		nuke = new JSlider();
		addSlider(2, "Flavor Nukes: ", nuke);
		usenuke = new JSlider();
		addSlider(2, "Flavor Use Nukes: ", usenuke);

		addPage();

		addLabel(2, "");

		JButton nextPage2 = new JButton("Next Page 2");
		nextPage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_LEADER,
						pages.get(2));
				pages.get(2).repaint();
			}
		});
		addComponent(2, nextPage2);

		spying = new JSlider();
		addSlider(3, "Flavor Espionage: ", spying);
		antiair = new JSlider();
		addSlider(3, "Flavor Anti-Air: ", antiair);
		carrier = new JSlider();
		addSlider(3, "Flavor Air-Craft Carrier: ", carrier);
		arch = new JSlider();
		addSlider(3, "Flavor Archaeology: ", arch);
		landtrade = new JSlider();
		addSlider(3, "Flavor Land Trade: ", landtrade);
		seatrade = new JSlider();
		addSlider(3, "Flavor Sea Trade: ", seatrade);
		tradeorigin = new JSlider();
		addSlider(3, "Flavor Trade Origin: ", tradeorigin);
		tradedestination = new JSlider();
		addSlider(3, "Flavor Trade Destination: ", tradedestination);
		airlift = new JSlider();
		addSlider(3, "Flavor Air Lifting: ", airlift);

		addLabel(3, "");
		JButton nextPage3 = new JButton("First Page");
		nextPage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.fileTypes.setComponentAt(Constants.TAB_LEADER,
						pages.get(0));
				pages.get(0).repaint();
			}
		});
		addComponent(3, nextPage3);
	}

	public StructLeader getLeader() {
		StructLeader l = new StructLeader();

		l.vals[1] = leader.getText().toUpperCase().replaceAll(" ", "_");
		l.vals[2] = leader.getText();
		l.vals[3] = victory.getValue() + "";
		l.vals[4] = wonder.getValue() + "";
		l.vals[5] = minor.getValue() + "";
		l.vals[6] = bold.getValue() + "";
		l.vals[7] = diplobal.getValue() + "";
		l.vals[8] = warmhate.getValue() + "";
		l.vals[9] = workagainst.getValue() + "";
		l.vals[10] = workwith.getValue() + "";
		l.vals[11] = denounce.getValue() + "";
		l.vals[12] = doFor.getValue() + "";
		l.vals[13] = loyal.getValue() + "";
		l.vals[14] = need.getValue() + "";
		l.vals[15] = forgiv.getValue() + "";
		l.vals[16] = chat.getValue() + "";
		l.vals[17] = mean.getValue() + "";
		l.vals[18] = war.getValue() + "";
		l.vals[19] = hostile.getValue() + "";
		l.vals[20] = deceptive.getValue() + "";
		l.vals[21] = guarded.getValue() + "";
		l.vals[22] = afraid.getValue() + "";
		l.vals[23] = friendly.getValue() + "";
		l.vals[24] = neutral.getValue() + "";
		l.vals[25] = minIgnor.getValue() + "";
		l.vals[26] = minFriendly.getValue() + "";
		l.vals[27] = minProtective.getValue() + "";
		l.vals[28] = minConquest.getValue() + "";
		l.vals[29] = minBully.getValue() + "";
		l.vals[30] = offense.getValue() + "";
		l.vals[31] = defense.getValue() + "";
		l.vals[32] = cityDef.getValue() + "";
		l.vals[33] = training.getValue() + "";
		l.vals[34] = recon.getValue() + "";
		l.vals[35] = ranged.getValue() + "";
		l.vals[36] = mobile.getValue() + "";
		l.vals[37] = naval.getValue() + "";
		l.vals[38] = navalrecon.getValue() + "";
		l.vals[39] = navalgrowth.getValue() + "";
		l.vals[40] = navaltile.getValue() + "";
		l.vals[41] = air.getValue() + "";
		l.vals[42] = expansion.getValue() + "";
		l.vals[43] = growth.getValue() + "";
		l.vals[44] = tileimp.getValue() + "";
		l.vals[45] = infra.getValue() + "";
		l.vals[46] = production.getValue() + "";
		l.vals[47] = gold.getValue() + "";
		l.vals[48] = science.getValue() + "";
		l.vals[49] = culture.getValue() + "";
		l.vals[50] = happiness.getValue() + "";
		l.vals[51] = great.getValue() + "";
		l.vals[52] = wonder2.getValue() + "";
		l.vals[53] = religion.getValue() + "";
		l.vals[54] = diplomacy.getValue() + "";
		l.vals[55] = space.getValue() + "";
		l.vals[56] = waterconnect.getValue() + "";
		l.vals[57] = nuke.getValue() + "";
		l.vals[58] = usenuke.getValue() + "";
		l.vals[59] = spying.getValue() + "";
		l.vals[60] = antiair.getValue() + "";
		l.vals[61] = carrier.getValue() + "";
		l.vals[62] = arch.getValue() + "";
		l.vals[63] = landtrade.getValue() + "";
		l.vals[64] = seatrade.getValue() + "";
		l.vals[65] = tradeorigin.getValue() + "";
		l.vals[66] = tradedestination.getValue() + "";
		l.vals[67] = airlift.getValue() + "";
		l.vals[68] = traits.getSelectedItem().toString();
		l.vals[69] = GENDER[gender.getSelectedIndex()];
		l.vals[70] = leaderScene.getText();

		return l;
	}

	public void load(StructLeader l) {
		leader.setText(l.vals[2]);
		traits.setSelectedItem(l.vals[68]);
		gender.setSelectedItem(l.vals[69]);
		leaderScene.setText(l.vals[70]);
		victory.setValue(parse(l, 3));
		wonder.setValue(parse(l, 4));
		minor.setValue(parse(l, 5));
		bold.setValue(parse(l, 6));
		diplobal.setValue(parse(l, 7));
		warmhate.setValue(parse(l, 8));
		workagainst.setValue(parse(l, 9));
		workwith.setValue(parse(l, 10));
		denounce.setValue(parse(l, 11));
		doFor.setValue(parse(l, 12));
		loyal.setValue(parse(l, 13));
		need.setValue(parse(l, 14));
		forgiv.setValue(parse(l, 15));
		chat.setValue(parse(l, 16));
		mean.setValue(parse(l, 17));
		war.setValue(parse(l, 18));
		hostile.setValue(parse(l, 19));
		deceptive.setValue(parse(l, 20));
		guarded.setValue(parse(l, 21));
		afraid.setValue(parse(l, 22));
		friendly.setValue(parse(l, 23));
		neutral.setValue(parse(l, 24));
		minIgnor.setValue(parse(l, 25));
		minFriendly.setValue(parse(l, 26));
		minProtective.setValue(parse(l, 27));
		minConquest.setValue(parse(l, 28));
		minBully.setValue(parse(l, 29));
		offense.setValue(parse(l, 30));
		defense.setValue(parse(l, 31));
		cityDef.setValue(parse(l, 32));
		training.setValue(parse(l, 33));
		recon.setValue(parse(l, 34));
		ranged.setValue(parse(l, 35));
		mobile.setValue(parse(l, 36));
		naval.setValue(parse(l, 37));
		navalrecon.setValue(parse(l, 38));
		navalgrowth.setValue(parse(l, 39));
		navaltile.setValue(parse(l, 40));
		air.setValue(parse(l, 41));
		expansion.setValue(parse(l, 42));
		growth.setValue(parse(l, 43));
		tileimp.setValue(parse(l, 44));
		infra.setValue(parse(l, 45));
		production.setValue(parse(l, 46));
		gold.setValue(parse(l, 47));
		science.setValue(parse(l, 48));
		culture.setValue(parse(l, 49));
		happiness.setValue(parse(l, 50));
		great.setValue(parse(l, 51));
		wonder2.setValue(parse(l, 52));
		religion.setValue(parse(l, 53));
		diplomacy.setValue(parse(l, 54));
		space.setValue(parse(l, 55));
		waterconnect.setValue(parse(l, 56));
		nuke.setValue(parse(l, 57));
		usenuke.setValue(parse(l, 58));
		spying.setValue(parse(l, 59));
		antiair.setValue(parse(l, 60));
		carrier.setValue(parse(l, 61));
		arch.setValue(parse(l, 62));
		landtrade.setValue(parse(l, 63));
		seatrade.setValue(parse(l, 64));
		tradeorigin.setValue(parse(l, 65));
		tradedestination.setValue(parse(l, 66));
		airlift.setValue(parse(l, 67));
	}

	public int parse(StructLeader l, int num) {

		return Integer.parseInt(l.vals[num]);
	}
}
