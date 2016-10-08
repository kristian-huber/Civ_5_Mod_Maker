package structs;

import util.Constants;

public class StructLeader {
	public static final String e = System.getProperty("line.separator");
	public static final String[] MAJOR_CIV = { "WAR", "HOSTILE", "DECEPTIVE",
			"GUARDED", "AFRAID", "FRIENDLY", "NEUTRAL" };
	public static final String[] MINOR_CIV = { "IGNOR", "FRIENDLY",
			"PROTECTIVE", "CONQUEST", "BULLY" };

	public String[] vals = new String[71];

	public String getLeader() {
		String output = "";

		output += "		<Row>" + e;
		output += "			<Type>LEADER_" + vals[1] + "</Type>" + e;
		output += "			<Description>TXT_KEY_LEADER_" + vals[1]
				+ "</Description>" + e;
		output += "			<Civilopedia>" + vals[2] + "</Civilopedia>" + e;
		output += "			<CivilopediaTag>" + vals[2] + "</CivilopediaTag>" + e;
		/***************************************************************/
		output += "			<ArtDefineTag>" + vals[70] + "_Scene.xml</ArtDefineTag>"
				+ e;
		output += "			<VictoryCompetitiveness>" + vals[3]
				+ "</VictoryCompetitiveness>" + e;
		output += "			<WonderCompetitiveness>" + vals[4]
				+ "</WonderCompetitiveness>" + e;
		output += "			<MinorCivCompetitiveness>" + vals[5]
				+ "</MinorCivCompetitiveness>" + e;
		output += "			<Boldness>" + vals[6] + "</Boldness>" + e;
		output += "			<DiploBalance>" + vals[7] + "</DiploBalance>" + e;
		output += "			<WarmongerHate>" + vals[8] + "</WarmongerHate>" + e;
		output += "			<WorkAgainstWillingness>" + vals[9]
				+ "</WorkAgainstWillingness>" + e;
		output += "			<WorkWithWillingness>" + vals[10]
				+ "</WorkWithWillingness>" + e;
		output += "			<DenounceWillingness>" + vals[11]
				+ "</DenounceWillingness>" + e;
		output += "			<DoFWillingness>" + vals[12] + "</DoFWillingness>" + e;
		output += "			<Loyalty>" + vals[13] + "</Loyalty>" + e;
		output += "			<Neediness>" + vals[14] + "</Neediness>" + e;
		output += "			<Forgiveness>" + vals[15] + "</Forgiveness>" + e;
		output += "			<Chattiness>" + vals[16] + "</Chattiness>" + e;
		output += "			<Meanness>" + vals[17] + "</Meanness>" + e;
		/***************************************************************/
		output += "			<PortraitIndex>0</PortraitIndex>" + e;
		/***************************************************************/
		output += "			<IconAtlas>LEADER_ATLAS</IconAtlas>" + e;
		output += "		</Row>" + e;

		return output;
	}

	public String getMajorCivBiases() {
		String output = "";
		for (int i = 0; i < MAJOR_CIV.length; i++) {
			output += getMC(i);
		}
		return output;
	}

	private String getMC(int num) {
		String output = "";
		output += "		<Row>" + e;
		output += "			<LeaderType>LEADER_" + vals[1] + "</LeaderType>" + e;
		output += "			<MajorCivApproachType>MAJOR_CIV_APPROACH_"
				+ MAJOR_CIV[num] + "</MajorCivApproachType>" + e;
		output += "			<Bias>" + vals[18 + num] + "</Bias>" + e;
		output += "		</Row>" + e;
		return output;
	}

	public String getMinorCivBiases() {
		String output = "";
		for (int i = 0; i < MINOR_CIV.length; i++) {
			output += getMinC(i);
		}
		return output;
	}

	private String getMinC(int num) {
		String output = "";
		output += "		<Row>" + e;
		output += "			<LeaderType>LEADER_" + vals[1] + "</LeaderType>" + e;
		output += "			<MinorCivApproachType>MINOR_CIV_APPROACH_"
				+ MINOR_CIV[num] + "</MinorCivApproachType>" + e;
		output += "			<Bias>" + vals[25 + num] + "</Bias>" + e;
		output += "		</Row>" + e;
		return output;
	}

	public String getFlavors() {
		String output = "";
		for (int i = 0; i < Constants.FLAVORS.length; i++) {
			output += getF(i);
		}
		return output;
	}

	private String getF(int num) {
		String output = "";
		output += "		<Row>" + e;
		output += "			<LeaderType>LEADER_" + vals[1] + "</LeaderType>" + e;
		output += "			<FlavorType>FLAVOR_" + Constants.FLAVORS[num]
				+ "</FlavorType>" + e;
		output += "			<Flavor>" + vals[30 + num] + "</Flavor>" + e;
		output += "		</Row>" + e;

		return output;
	}

	public String getTag() {
		String output = "";
		output += "		<Row Tag=\"TXT_KEY_LEADER_" + vals[1] + "\">" + e;
		output += "			<Text>" + vals[2] + "</Text>" + e;
		if (vals[69].equals("feminine")) {
			output += "		<Gender>feminine</Gender>" + e;
		}
		output += "		</Row>" + e;
		return output;
	}

	public String getTrait() {
		String output = "";
		output += "		<Row>" + e;
		output += "			<LeaderType>LEADER_" + vals[1] + "</LeaderType>" + e;
		output += "			<TraitType>TRAIT_" + vals[68] + "</TraitType>" + e;
		output += "		</Row>" + e;
		return output;
	}
}
