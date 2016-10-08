package structs;

public class StructBuilding {
	public static final String e = System.getProperty("line.separator");

	public String name_super;
	public String name_constant;
	public String name;
	public String tip;
	public String maintenance;
	public boolean sea;
	public boolean river;
	public boolean mountain;
	public String prod_cost;
	public String happiness;
	public String building_mod;
	public String hitpoints;
	public String build_class;
	public String preq_tech;
	public String display_pos;
	public String portrait_index;
	public String icon_atlas;
	public String[] exp_types;
	public String[] exp_amts;
	public String[] prod_types;
	public String[] prod_amt_to_types;
	public String[] flavors;
	public String[] flavor_amts;
	public String[] yields;
	public String[] yield_amts;
	public String[] feats;
	public String[] featyields;
	public String[] featyield_amts;
	public String[] ters;
	public String[] teryields;
	public String[] teryield_amts;
	public String[] res;
	public String[] resyields;
	public String[] resyield_amts;
	public String[] yieldpercents;
	public String[] yieldpercent_amts;
	
	public String[] givenres;
	public String[] givenresamts;
	public String[] reqres;
	public String[] reqresamts;
	public String[] combmod;
	public String[] combmodamts;
	public String[] ors;

	public String getBuilding() {
		String output = "";

		output += "		<Row>" + e;
		output += "			<Type>BUILDING_" + name_constant + "</Type>" + e;
		output += "			<Description>" + name + "</Description>" + e;
		output += "			<Strategy>" + tip + "</Strategy>" + e;
		output += "			<Help>" + tip + "</Help>" + e;
		output += "			<GoldMaintenance>" + maintenance + "</GoldMaintenance>"
				+ e;
		output += "			<MutuallyExclusiveGroup>-1</MutuallyExclusiveGroup>" + e;
		output += "			<Water>" + sea + "</Water>" + e;
		output += "			<River>" + river + "</River>" + e;
		output += "			<NearbyMountainRequired>" + mountain
				+ "</NearbyMountainRequired>" + e;
		output += "			<Cost>" + prod_cost + "</Cost>" + e;
		output += "			<MinAreaSize>-1</MinAreaSize>" + e;
		output += "			<Happiness>" + happiness + "</Happiness>" + e;
		output += "			<BuildingProductionModifier>" + building_mod
				+ "</BuildingProductionModifier>" + e;
		output += "			<Defense> " + hitpoints + "</Defense>" + e;
		if (name_super.equals("ITSELF")) {
			output += "			<BuildingClass>BUILDINGCLASS_" + name_constant
					+ "</BuildingClass>" + e;
			output += "			<ArtDefineTag>ART_DEF_BUILDING_" + name_constant
					+ "</ArtDefineTag>" + e;
		} else {
			output += "			<BuildingClass>BUILDINGCLASS_" + name_super
					+ "</BuildingClass>" + e;
			output += "			<ArtDefineTag>ART_DEF_BUILDING_" + name_super
					+ "</ArtDefineTag>" + e;
		}

		output += "			<PrereqTech>TECH_" + preq_tech + "</PrereqTech>" + e;
		output += "			<DisplayPosition>" + display_pos + "</DisplayPosition>"
				+ e;
		output += "			<PortraitIndex>" + portrait_index + "</PortraitIndex>"
				+ e;
		output += "			<IconAtlas>" + icon_atlas + "</IconAtlas>" + e;
		output += "		</Row>" + e;

		return output;
	}

	public String getBuildingClass() {
		String output = "";

		if (name_super.equals("ITSELF")) {
			output += "		<Row>" + e;
			output += "			<Type>BUILDINGCLASS_" + name_constant + "</Type>" + e;
			output += "			<DefaultBuilding>BUILDING_" + name_constant
					+ "</DefaultBuilding>" + e;
			output += "			<Description>" + tip + "</Description>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getDomainExperience() {
		String output = "";

		for (int i = 0; i < exp_types.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<DomainType>DOMAIN_" + exp_types[i] + "</DomainType>"
					+ e;
			output += "			<Experience>" + exp_amts[i] + "</Experience>" + e;
			output += "		</Row>" + e;
		}
		return output;
	}

	public String getProductionModifersExperience() {
		String output = "";

		for (int i = 0; i < prod_types.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<DomainType>DOMAIN_" + prod_types[i]
					+ "</DomainType>" + e;
			output += "			<Modifier>" + prod_amt_to_types[i] + "</Modifier>"
					+ e;
			output += "		</Row>" + e;
		}
		return output;
	}

	public String getGivenResources() {
		String output = "";

		for (int i = 0; i < givenres.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<ResourceType>RESOURCE_" + givenres[i] + "</ResourceType>"
					+ e;
			output += "			<Quantity>" + givenresamts[i] + "</Quantity>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}
	
	public String getRequiresResources() {
		String output = "";

		for (int i = 0; i < reqres.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<ResourceType>RESOURCE_" + reqres[i] + "</ResourceType>"
					+ e;
			output += "			<Cost>" + reqresamts[i] + "</Cost>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}
	
	public String getCombatMods() {
		String output = "";

		for (int i = 0; i < combmod.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<UnitCombatType>UNITCOMBAT_" + combmod[i] + "</UnitCombatType>"
					+ e;
			output += "			<Modifier>" + combmodamts[i] + "</Modifier>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}
	
	public String getLocalOrs() {
		String output = "";

		for (int i = 0; i < ors.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<ResourceType>RESOURCE_" + ors[i] + "</ResourceType>"
					+ e;
			output += "		</Row>" + e;
		}

		return output;
	}
	
	public String getFlavor() {
		String output = "";

		for (int i = 0; i < flavors.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<FlavorType>FLAVOR_" + flavors[i] + "</FlavorType>"
					+ e;
			output += "			<Flavor>" + flavor_amts[i] + "</Flavor>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getYeildChanges() {
		String output = "";

		for (int i = 0; i < yields.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<YieldType>YIELD_" + yields[i] + "</YieldType>" + e;
			output += "			<Yield>" + yield_amts[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getFeatureYeildChanges() {
		String output = "";

		for (int i = 0; i < featyields.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<FeatureType>FEATURE_" + feats[i] + "</FeatureType>" + e;
			output += "			<YieldType>YIELD_" + featyields[i] + "</YieldType>"
					+ e;
			output += "			<Yield>" + featyield_amts[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}
	
	public String getResourceYeildChanges() {
		String output = "";

		for (int i = 0; i < resyields.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<ResourceType>RESOURCE_" + res[i] + "</ResourceType>" + e;
			output += "			<YieldType>YIELD_" + resyields[i] + "</YieldType>"
					+ e;
			output += "			<Yield>" + resyield_amts[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getTerrainYeildChanges() {
		String output = "";

		for (int i = 0; i <teryields.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<TerrainType>TERRAIN_" + ters[i] + "</TerrainType>"  + e;
			output += "			<YieldType>YIELD_" + teryields[i] + "</YieldType>" + e;
			output += "			<Yield>" + teryield_amts[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getYeildModifiers() {
		String output = "";

		for (int i = 0; i < yieldpercents.length; i++) {
			output += "		<Row>" + e;
			output += "			<BuildingType>BUILDING_" + name_constant
					+ "</BuildingType>" + e;
			output += "			<YieldType>YIELD_" + yieldpercents[i]
					+ "</YieldType>" + e;
			output += "			<Yield>" + yieldpercent_amts[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}
}
