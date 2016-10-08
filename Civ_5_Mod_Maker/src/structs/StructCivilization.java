package structs;

import java.awt.Color;

public class StructCivilization {
	public static final String e = System.getProperty("line.separator");

	public String name_constant;
	public String name;
	public String adjective;
	public String art_tag;
	public String art_style;
	public String art_suffix;
	public String art_prefix;
	public String symbol_index;
	public String atlas;
	public String dom_map;
	public String dom_image;
	public String dom_quote;
	public String soundtrack;
	public Color foreground;
	public Color background;
	public String leader;
	public String religion;
	public String[] bN;
	public String[] bO;
	public String[] uN;
	public String[] uO;
	public String terrain;
	public boolean coastal;
	public String[] spies;
	public String[] cities;

	public String getRowCivilization() {
		String output = "";

		output += "			<Row>" + e;
		output += "				<Type>CIVILIZATION_" + name_constant + "</Type>" + e;
		output += "				<Description>" + name + "</Description>" + e;
		output += "				<ShortDescription>" + name + "</ShortDescription>" + e;
		output += "				<Adjective>" + adjective + "</Adjective>" + e;
		output += "				<Civilopedia></Civilopedia>" + e;
		output += "				<Playable>1</Playable>" + e;
		output += "				<AIPlayable>1</AIPlayable>" + e;
		output += "				<CivilopediaTag>" + name + "</CivilopediaTag>" + e;
		output += "				<DefaultPlayerColor>PLAYERCOLOR_" + name_constant
				+ "</DefaultPlayerColor>" + e;
		output += "				<ArtDefineTag>ART_DEF_CIVILIZATION_" + art_tag
				+ "</ArtDefineTag>" + e;
		output += "				<ArtStyleType>ARTSTYLE_" + art_style + "</ArtStyleType>"
				+ e;
		output += "				<ArtStyleSuffix>_" + art_suffix + "</ArtStyleSuffix>"
				+ e;
		output += "				<ArtStylePrefix>" + art_prefix + "</ArtStylePrefix>" + e;
		output += "				<DerivativeCiv></DerivativeCiv>" + e;
		output += "				<PortraitIndex>" + symbol_index + "</PortraitIndex>" + e;
		output += "				<IconAtlas>" + atlas + "</IconAtlas>" + e;
		output += "				<AlphaIconAtlas>CIV_ALPHA_ATLAS</AlphaIconAtlas>" + e;
		output += "				<MapImage>" + dom_map + "</MapImage>" + e;
		output += "				<DawnOfManQuote>" + dom_quote + "</DawnOfManQuote>" + e;
		output += "				<DawnOfManImage>" + dom_image + "</DawnOfManImage>" + e;
		output += "				<DawnOfManAudio></DawnOfManAudio>" + e;
		output += "				<SoundtrackTag>" + soundtrack + "</SoundtrackTag>" + e;
		output += "			</Row>" + e;

		return output;
	}

	public String getPlayerColors() {
		String output = "";

		output += "			<Row>" + e;
		output += "				<Type>PLAYERCOLOR_" + name_constant + "</Type>" + e;
		output += "				<PrimaryColor>COLOR_PLAYER_" + name_constant
				+ "_ICON</PrimaryColor>" + e;
		output += "				<SecondaryColor>COLOR_PLAYER_" + name_constant
				+ "_BACKGROUND</SecondaryColor>" + e;
		output += "				<TextColor>COLOR_PLAYER_WHITE_TEXT</TextColor>" + e;
		output += "			</Row>" + e;

		return output;
	}

	public String getColors() {
		String output = "";

		output += "			<Row>" + e;
		output += "				<Type>COLOR_PLAYER_" + name_constant + "_ICON</Type>"
				+ e;
		output += "				<Red>" + ((float) foreground.getRed() / 255) + "</Red>"
				+ e;
		output += "				<Green>" + ((float) foreground.getGreen() / 255)
				+ "</Green>" + e;
		output += "				<Blue>" + ((float) foreground.getBlue() / 255)
				+ "</Blue>" + e;
		output += "				<Alpha>1</Alpha>" + e;
		output += "			</Row>" + e;
		output += "			<Row>" + e;
		output += "				<Type>COLOR_PLAYER_" + name_constant
				+ "_BACKGROUND</Type>" + e;
		output += "				<Red>" + ((float) background.getRed() / 255) + "</Red>"
				+ e;
		output += "				<Green>" + ((float) background.getGreen() / 255)
				+ "</Green>" + e;
		output += "				<Blue>" + ((float) background.getBlue() / 255)
				+ "</Blue>" + e;
		output += "				<Alpha>1</Alpha>" + e;
		output += "			</Row>" + e;

		return output;
	}

	public String getLeader() {
		String output = "";

		output += "			<Row>" + e;
		output += civType() + e;
		output += "				<LeaderheadType>LEADER_" + leader + "</LeaderheadType>"
				+ e;
		output += "			</Row>" + e;

		return output;
	}

	public String getReligion() {
		String output = "";

		output += "			<Row>" + e;
		output += civType() + e;
		output += "				<ReligionType>RELIGION_" + religion + "</ReligionType>"
				+ e;
		output += "			</Row>" + e;

		return output;
	}

	public String getBuildings() {
		String output = "";

		for (int i = 0; i < bO.length; i++) {
			output += "			<Row>" + e;
			output += civType() + e;
			output += "				<BuildingClassType>BUILDINGCLASS_" + bO[i]
					+ "</BuildingClassType>" + e;
			output += "				<BuildingType>BUILDING_" + bN[i] + "</BuildingType>"
					+ e;
			output += "			</Row>" + e;
		}

		return output;
	}

	public String getUnits() {
		String output = "";

		for(int i = 0; i < uO.length; i++){
			output += "			<Row>" + e;
			output += civType() + e;
			output += "				<UnitClassType>UNITCLASS_" + uO[i]
					+ "</UnitClassType>" + e;
			output += "				<UnitType>UNIT_" + uN[i] + "</UnitType>" + e;
			output += "			</Row>" + e;
		}

		return output;
	}

	public String getStartRegionPriority() {
		String output = "";

		if (!terrain.equals("NONE")) {

			output += "		<Row>" + e;
			output += civType() + e;
			output += "			<RegionType>REGION_" + terrain + "</RegionType>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getCoastal() {
		String output = "";

		if (coastal) {

			output += "		<Row>" + e;
			output += civType() + e;
			output += "			<StartAlongOcean>true</StartAlongOcean>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getFreeBuildings() {
		String output = "";

		output += "			<Row>" + e;
		output += civType() + e;
		output += "				<BuildingClassType>BUILDINGCLASS_PALACE</BuildingClassType>"
				+ e;
		output += "			</Row>" + e;

		return output;
	}

	public String getFreeUnits() {
		String output = "";

		output += "			<Row>" + e;
		output += civType() + e;
		output += "				<UnitClassType>UNITCLASS_SETTLER</UnitClassType>" + e;
		output += "				<Count>1</Count>" + e;
		output += "				<UnitAIType>UNITAI_SETTLE</UnitAIType>" + e;
		output += "			</Row>";

		return output;
	}

	public String getFreeTechs() {
		String output = "";

		output += "			<Row>" + e;
		output += civType() + e;
		output += "				<TechType>TECH_AGRICULTURE</TechType>" + e;
		output += "			</Row>" + e;

		return output;
	}

	public String getSpies() {
		String output = "";

		for (String s : spies) {

			output += "		<Row>" + e;
			output += civType() + e;
			output += "			<SpyName>" + s + "</SpyName>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getCities() {
		String output = "";

		for (String s : cities) {

			output += "		<Row>" + e;
			output += civType() + e;
			output += "			<CityName>" + s + "</CityName>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String civType() {

		return "				<CivilizationType>CIVILIZATION_" + name_constant
				+ "</CivilizationType>";
	}
}
