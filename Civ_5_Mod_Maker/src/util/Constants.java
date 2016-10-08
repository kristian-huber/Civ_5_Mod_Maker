package util;

import java.awt.Font;

public class Constants {
	public static final int TAB_BUILDING = 1;
	public static final int TAB_CIVILIZATION = 2;
	public static final int TAB_LEADER = 3;
	public static final int TAB_TRAIT = 4;
	public static final int TAB_UNIT = 5;

	public static final Font ARIAL10 = new Font("Arial", Font.PLAIN, 10);
	public static final Font ARIAL12 = new Font("Arial", Font.PLAIN, 12);

	public static final String UNIT_DOMAINS[] = { "AIR", "LAND", "SEA" };

	public static final String UNIT_MOVES[] = { "BIPED", "HEAVY_BIPED",
			"QUADRUPED", "WHEELED", "WOODEN_BOAT", "BOAT", "SUB", "ROBOT",
			"ARTILLERY", "GREAT_PERSON", "PHANT", "AIR_REBASE" };

	public static final String[] YIELD_TYPES = { "CULTURE", "FAITH", "FOOD",
			"GOLD", "PRODUCTION", "SCIENCE" };

	public static final String[] ATYPES = { "ASIAN", "EUROPEAN", "GRECO_ROMAN",
			"MIDDLE_EAST", "SOUTH_AMERICA" };
	public static final String[] ASUFFIX = { "AFRI", "AMER", "ASIA", "EURO",
			"MED" };
	public static final String[] APREFIX = { "AFRICAN", "AMERICAN", "ASIAN",
			"EUROPEAN", "MEDITERRANEAN" };

	public static String[] RELIGIONS = { "BUDDHISM", "CHRISTIANITY",
			"CONFUCIANISM", "HINDUISM", "ISLAM", "JUDIASM", "ORTHODOXY",
			"PROTESTANTISM", "SHINTO", "SIKHISM", "TAOSIM", "TENGRIISM",
			"ZOROASTRIANISM" };

	public static final String[] TERRAINS = { "NONE", "DESERT", "FOREST",
			"GRASS", "HILLS", "JUNGLE", "PLAINS", "SNOW", "TUNDRA" };

	public static final String[] FEATURES = { "FLOOD_PLAINS", "FOREST",
			"FALLOUT", "ICE", "JUNGLE", "LAKE", "MARSH", "OASIS", "RIVER" };

	public static final String[] UNIT_TYPES = { "MELEE", "ARCHER", "RECON",
			"MOUNTED", "SIEGE", "GUN", "ARMOR", "BOMBER", "FIGHTER",
			"NAVALMELEE", "NAVALRANGED", "SUBMARINE", "CARRIER" };

	public static final String[] AI = { "ATTACK", "DEFENSE", "EXPLORE",
			"RANGED", "COUNTER", "FAST_ATTACK", "CITY_BOMBARD", "PARADROP",
			"DEFENSE_AIR", "CARRIER_AIR", "ATTACK_AIR", "ICBM", "ATTACK_SEA",
			"EXPLORE_SEA", "ESCORT_SEA", "RESERVE_SEA", "MISSLE_CARRIER_SEA" };

	public static final String[] FLAVORS = { "OFFENSE", "DEFENSE",
			"CITY_DEFENSE", "MILITARY_TRAINING", "RECON", "RANGED", "MOBILE",
			"NAVAL", "NAVAL_RECON", "NAVAL_GROWTH", "NAVAL_TILE_IMPROVEMENT",
			"AIR", "EXPANSION", "GROWTH", "TILE_IMPROVEMENT", "INFRASTUCTURE",
			"PRODUCTION", "GOLD", "SCIENCE", "CULTURE", "HAPPINESS",
			"GREAT_PEOPLE", "WONDER", "RELIGION", "DIPLOMACY", "SPACESHIP",
			"WATER_CONNECTION", "NUKE", "USE_NUKE", "ESPIONAGE", "ANTIAIR",
			"AIR_CARRIER", "ARCHAEOLOGY", "I_LAND_TRADE_ROUTE",
			"I_SEA_TRADE_ROUTE", "I_TRADE_ORIGIN", "I_TRADE_DESTINATION",
			"AIRLIFT" };
}
