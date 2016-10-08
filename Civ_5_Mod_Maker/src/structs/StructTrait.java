package structs;

public class StructTrait {
	public static final String e = System.getProperty("line.separator");

	public String name_constant;
	public String name;
	public String desc;
	public String lvlexpmod;
	public String gprate;
	public String gsrate;
	public String ggrate;
	public String ggexbonus;
	public String cityumod;
	public String popumod;
	public String landbarb;
	public String seabarb;
	public String landmat;
	public String seamat;
	public String policymod;
	public String exembmoves;
	public String lowtech;
	public String smallciv;
	public String razemod;
	public String dofgpmod;
	public String exspies;
	public String exterritory;
	public String workspeed;
	public String afraidmin;
	public boolean fightdam;
	public boolean woodroad;
	public String embcost;
	public boolean nocityalive;
	public boolean buycity;
	public boolean faithforest;
	public boolean exbelief;
	public String freebuilding;
	public String[] unit_types;
	public String[] promotions;
	public String[] quantres;
	public String[] quantresamt;
	public String[] improv;
	public String[] improvyield;
	public String[] improvyieldamt;
	public String[] feature;
	public String[] featureyield;
	public String[] featureyeildamt;

	public String getTrait() {
		String output = "";

		output += "		<Row>" + e;
		output += "			<Type>TRAIT_" + name_constant + "</Type>" + e;
		output += "			<Description> " + desc + "</Description>" + e;
		output += "			<ShortDescription>" + desc + "</ShortDescription>" + e;
		output += "			<LevelExperienceModifier>" + lvlexpmod
				+ "</LevelExperienceModifier>" + e;
		output += "			<GreatPeopleRateModifier>" + gprate
				+ "</GreatPeopleRateModifier>" + e;
		output += "			<GreatScientistRateModifier>" + gsrate
				+ "</GreatScientistRateModifier>" + e;
		output += "			<GreatGeneralRateModifier>" + ggrate
				+ "</GreatGeneralRateModifier>" + e;
		output += "			<GreatGeneralExtraBonus>" + ggexbonus
				+ "</GreatGeneralExtraBonus>" + e;
		output += "			<CityUnhappinessModifier>" + cityumod
				+ "</CityUnhappinessModifier>" + e;
		output += "			<PopulationUnhappinessModifier>" + popumod
				+ "</PopulationUnhappinessModifier>" + e;
		output += "			<LandBarbarianConversionPercent>" + landbarb
				+ "</LandBarbarianConversionPercent>" + e;
		output += "			<SeaBarbarianConversionPercent>" + seabarb
				+ "</SeaBarbarianConversionPercent>" + e;
		output += "			<LandUnitMaintenanceModifier>" + landmat
				+ "</LandUnitMaintenanceModifier>" + e;
		output += "			<NavalUnitMaintenanceModifier>" + seamat
				+ "</NavalUnitMaintenanceModifier>" + e;
		output += "			<PolicyCostModifier>" + policymod
				+ "</PolicyCostModifier>" + e;
		output += "			<ExtraEmbarkMoves>" + exembmoves + "</ExtraEmbarkMoves>"
				+ e;
		output += "			<CombatBonusVsHigherTech>" + lowtech
				+ "</CombatBonusVsHigherTech>" + e;
		output += "			<CombatBonusVsLargerCiv>" + smallciv
				+ "</CombatBonusVsLargerCiv>" + e;
		output += "			<RazeSpeedModifier>" + razemod + "</RazeSpeedModifier>"
				+ e;
		output += "			<DOFGreatPersonModifier>" + dofgpmod
				+ "</DOFGreatPersonModifier>" + e;
		output += "			<ExtraSpies>" + exspies + "</ExtraSpies>" + e;
		output += "			<ExtraFoundedCityTerritoryClaimRange>" + desc
				+ "</ExtraFoundedCityTerritoryClaimRange>" + e;
		output += "			<UniqueLuxuryCities>0</UniqueLuxuryCities>" + e;
		output += "			<UniqueLuxuryQuantity>0</UniqueLuxuryQuantity>" + e;
		output += "			<WorkerSpeedModifier>" + workspeed
				+ "</WorkerSpeedModifier>" + e;
		output += "			<AfraidMinorPerTurnInfluence>" + afraidmin
				+ "</AfraidMinorPerTurnInfluence>" + e;
		if (fightdam) {
			output += "			<FightWellDamaged>1</FightWellDamaged>" + e;
		}
		if (woodroad) {
			output += "			<MoveFriendlyWoodsAsRoad>1</MoveFriendlyWoodsAsRoad>"
					+ e;
		}
		output += "			<EmbarkedToLandFlatCost>" + embcost
				+ "</EmbarkedToLandFlatCost>" + e;
		output += "			<StaysAliveZeroCities>" + nocityalive
				+ "</StaysAliveZeroCities>" + e;
		if (buycity) {
			output += "			<AngerFreeIntrusionOfCityStates>1</AngerFreeIntrusionOfCityStates>"
					+ e;
		}
		if (faithforest) {
			output += "			<FaithFromUnimprovedForest>1</FaithFromUnimprovedForest>"
					+ e;
		}
		if (exbelief) {
			output += "			<BonusReligiousBelief>1</BonusReligiousBelief>" + e;
		}
		if (!freebuilding.equals("NONE")) {
			output += "			<FreeBuildingOnConquest>BUILDING_" + freebuilding
					+ "</FreeBuildingOnConquest>" + e;
		}
		output += "		</Row>" + e;

		return output;
	}

	public String getFreePromos() {
		String output = "";

		for (int i = 0; i < unit_types.length; i++) {
			output += "		<Row>" + e;
			output += "			<TraitType>TRAIT_ " + name_constant + "</TraitType>"
					+ e;
			output += "			<UnitCombatType>UNITCOMBAT_" + unit_types[i]
					+ "</UnitCombatType>" + e;
			output += "			<PromotionType>PROMOTION_" + promotions[i]
					+ "</PromotionType>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getResourceMods() {
		String output = "";

		for (int i = 0; i < quantres.length; i++) {
			output += "		<Row>" + e;
			output += "			<TraitType>TRAIT_" + name_constant + "</TraitType>"
					+ e;
			output += "			<ResourceType>RESOURCE_" + quantres[i]
					+ "</ResourceType>" + e;
			output += "			<ResourceQuantityModifier>" + quantresamt[i]
					+ "</ResourceQuantityModifier>" + e;
			output += "		</Row>" + e;
		}

		return output;
	}

	public String getImprovementMods() {
		String output = "";

		for (int i = 0; i < improv.length; i++) {
			output += "		<Row>" + e;
			output += "			<TraitType>TRAIT_" + name_constant + "</TraitType>"
					+ e;
			output += "			<ImprovementType>IMPROVEMENT_" + improv[i]
					+ "</ImprovementType>" + e;
			output += "			<YieldType>YIELD_" + improvyield[i] + "</YieldType>"
					+ e;
			output += "			<Yield>" + improvyieldamt[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}
		return output;
	}

	public String getUnimprovedMods() {
		String output = "";

		for (int i = 0; i < feature.length; i++) {
			output += "		<Row>" + e;
			output += "			<TraitType>TRAIT_" + name_constant + "</TraitType>"
					+ e;
			output += "			<FeatureType>FEATURE_" + feature[i]
					+ "</FeatureType>" + e;
			output += "			<YieldType>YIELD_" + featureyield[i] + "</YieldType>"
					+ e;
			output += "			<Yield>" + featureyeildamt[i] + "</Yield>" + e;
			output += "		</Row>" + e;
		}
		return output;
	}
}
