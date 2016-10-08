package structs;

public class StructUnit {
	public static final String e = System.getProperty("line.separator");

	public String name_constant;
	public String name;
	public String description;
	public String help;
	public String combat;
	public String rangedcombat;
	public String prodcost;
	public String moves;
	public String range;
	public String sight;
	public String airinterceptrange;
	public String religionspreads;
	public String removeheresy;
	public String relstrength;
	public String expattack;
	public String moverate;
	public String expdefense;
	public String unitartinfo;
	public String unitflagiconoffset;
	public String portraitindex;
	public String iconatlas;
	public String unitflagatlas;
	public String uclass;
	public String combatclass;
	public String domain;
	public String defaultai;
	public String preqtech;
	public String obsoltetech;
	public String upgradesTo;
	public boolean canGoRival;
	public boolean nomaintenance;
	public boolean canreligion;
	public boolean foundsreligion;
	public boolean buycitystate;
	public boolean autoexplore;
	public String[] unitais;
	public String[] buildings;
	public String[] promotions;
	public String[] flavors;
	public String[] flavoramts;
	public String[] resources;
	public String[] resourceamts;
	public String[] yfromkill;
	public String[] yfromkillamt;

	public String getUnitClass() {
		String output = "";
		
		output += "		<Row>" + e;
		output += "			<Type>UNITCLASS_" + name_constant + "</Type>" + e;
		output += "			<Description>" + description + "</Description>" + e;
		output += "			<DefaultUnit>UNIT_" + name_constant + "</DefaultUnit>" + e;
		output += "		</Row>" + e;
		
		return output;
	}

	public String getUnit() {
		String output = "";

		output += "		<Row>" + e;
		output += "			<Type>UNIT_" + name_constant + "</Type>" + e;
		output += "			<Description>" + description + "</Description>" + e;
		output += "			<Strategy>" + help + "</Strategy>" + e;
		output += "			<Help>" + help + "</Help>" + e;
		output += "			<Combat>" + combat + "</Combat>" + e;
		output += "			<RangedCombat>" + rangedcombat + "</RangedCombat>" + e;
		output += "			<Cost>" + prodcost + "</Cost>" + e;
		output += "			<Moves>" + moves + "</Moves>" + e;
		output += "			<Range>" + range + "</Range>" + e;
		output += "			<BaseSightRange>" + sight + "</BaseSightRange>" + e;
		if(uclass.equals("ITSELF")){
			output += "			<Class>UNITCLASS_" + name_constant + "</Class>" + e;
		}else{
			output += "			<Class>UNITCLASS_" + uclass + "</Class>" + e;	
		}
		output += "			<CombatClass>UNITCOMBAT_" + combatclass
				+ "</CombatClass>" + e;
		output += "			<Domain>DOMAIN_" + domain + "</Domain>" + e;
		output += "			<DefaultUnitAI>UNITAI_" + defaultai + "</DefaultUnitAI>"
				+ e;
		output += "			<RivalTerritory>" + canGoRival + "</RivalTerritory>" + e;
		if (!preqtech.equals("NONE")) {
			output += "			<PrereqTech>TECH_" + preqtech + "</PrereqTech>" + e;
		}
		if (!obsoltetech.equals("NONE")) {
			output += "			<ObsoleteTech>TECH_" + obsoltetech
					+ "</ObsoleteTech>" + e;
		}
		if (!upgradesTo.equals("NONE")) {
			output += "			<GoodyHutUpgradeUnitClass>UNITCLASS_" + upgradesTo
					+ "</GoodyHutUpgradeUnitClass>" + e;
		}
		output += "			<AirInterceptRange>" + airinterceptrange
				+ "	</AirInterceptRange>      " + e;
		output += "			<SpreadReligion>" + canreligion + "</SpreadReligion>" + e;
		output += "			<RemoveHeresy>" + removeheresy + "</RemoveHeresy>" + e;
		output += "			<ReligionSpreads>" + religionspreads
				+ "</ReligionSpreads>" + e;
		output += "			<ReligiousStrength>" + relstrength
				+ "</ReligiousStrength>" + e;
		output += "			<FoundReligion>" + foundsreligion + "</FoundReligion>"
				+ e;
		output += "			<CanBuyCityState>" + buycitystate + "</CanBuyCityState>"
				+ e;
		output += "			<XPValueAttack>" + expattack + "</XPValueAttack>" + e;
		output += "			<XPValueDefense>" + expdefense + "</XPValueDefense>" + e;
		output += "			<NoMaintenance>" + nomaintenance + "</NoMaintenance>" + e;
		output += "			<UnitArtInfo>" + unitartinfo
				+ "</UnitArtInfo>" + e;
		output += "			<MoveRate>" + moverate + "</MoveRate>" + e;
		output += "			<UnitFlagIconOffset>" + unitflagiconoffset
				+ "</UnitFlagIconOffset>" + e;
		output += "			<PortraitIndex>" + portraitindex + "</PortraitIndex>" + e;
		output += "			<IconAtlas>" + iconatlas + "</IconAtlas>" + e;
		output += "			<UnitFlagAtlas>" + unitflagatlas + "</UnitFlagAtlas>" + e;
		output += "			<Mechanized>" + autoexplore + "</Mechanized>" + e;
		output += "			<MilitarySupport>1</MilitarySupport>" + e;
		output += "			<MilitaryProduction>1</MilitaryProduction>" + e;
		output += "			<Pillage>1</Pillage>" + e;
		output += "			<MinAreaSize>-1</MinAreaSize>" + e;
		output += "			<NukeDamageLevel>-1</NukeDamageLevel>" + e;
		if (domain.equals("AIR")) {
			output += "			<RangedCombatLimit>100</RangedCombatLimit>" + e;
		} else {
			output += "			<CombatLimit>100</CombatLimit>" + e;
		}
		output += " </Row>" + e;

		return output;
	}

	public String getUnitAI() {
		String output = "";

		for (int i = 0; i < unitais.length; i++) {

			output += "		<Row>" + e;
			output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
			output += "			<UnitAIType>UNITAI_" + unitais[i] + "</UnitAIType>"
					+ e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getBuilds() {
		String output = "";

		for (int i = 0; i < buildings.length; i++) {

			output += "		<Row>" + e;
			output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
			output += "			<BuildType>BUILD_" + buildings[i] + "</BuildType>"
					+ e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getUpgrade() {
		String output = "";

		if (upgradesTo.equals("NONE")) {
			return "";
		}

		output += "		<Row>" + e;
		output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
		output += "			<UnitClassType>UNITCLASS_" + upgradesTo
				+ "</UnitClassType>" + e;
		output += "		</Row>" + e;

		return output;
	}

	public String getPromotions() {
		String output = "";

		for (int i = 0; i < promotions.length; i++) {

			output += "		<Row>" + e;
			output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
			output += "			<PromotionType>PROMOTION_" + promotions[i]
					+ "</PromotionType>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getFlavors() {
		String output = "";

		for (int i = 0; i < flavors.length; i++) {

			output += "		<Row>" + e;
			output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
			output += "			<FlavorType>FLAVOR_" + flavors[i] + "</FlavorType>"
					+ e;
			output += "			<Flavor>" + flavoramts[i] + "</Flavor>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getResources() {
		String output = "";

		for (int i = 0; i < resources.length; i++) {

			output += "		<Row>" + e;
			output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
			output += "			<ResourceType>RESOURCE_" + resources[i]
					+ "</ResourceType>" + e;
			output += "			<Cost>" + resourceamts[i] + "</Cost>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getKillYield() {
		String output = "";

		for (int i = 0; i < yfromkill.length; i++) {

			output += "		<Row>" + e;
			output += "			<UnitType>UNIT_" + name_constant + "</UnitType>" + e;
			output += "			<YieldType>YIELD_" + yfromkill[i] + "</YieldType>"
					+ e;
			output += "			<Yield>" + yfromkillamt[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}
}
