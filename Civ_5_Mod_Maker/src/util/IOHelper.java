package util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;

import javax.swing.JFileChooser;

import structs.StructBuilding;
import structs.StructCivilization;
import structs.StructLeader;
import structs.StructTrait;
import structs.StructUnit;

public class IOHelper {

	public static void writeTraitFile(Collection<StructTrait> l,
			JFileChooser chooser) {
		try {
			FileWriter writer = new FileWriter(chooser.getSelectedFile()
					+ "_Traits.xml");

			BufferedReader r = new BufferedReader(new InputStreamReader(IOHelper.class
					.getResourceAsStream("/BaseTrait.txt")));

			String line = "";
			while ((line = r.readLine()) != null) {

				if (!line.contains("#")) {
					writer.write(line + System.getProperty("line.separator"));
				} else {
					String num = "";
					for (int i = 0; i < line.length(); i++) {
						if (line.substring(i, i + 1).equals("#")) {
							num = line.substring(i + 1, line.length());
							break;
						}
					}

					switch (Integer.parseInt(num)) {
					case 1:
						for (StructTrait s : l) {
							writer.write(s.getTrait());
						}
						break;
					case 2:
						for (StructTrait s : l) {
							writer.write(s.getFreePromos());
						}
						break;
					case 3:
						for (StructTrait s : l) {
							writer.write(s.getResourceMods());
						}
						break;
					case 4:
						for (StructTrait s : l) {
							writer.write(s.getImprovementMods());
						}
						break;
					case 5:
						for (StructTrait s : l) {
							writer.write(s.getUnimprovedMods());
						}
						break;
					}
				}

			}

			writer.close();
			r.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeUnitFile(Collection<StructUnit> l,
			JFileChooser chooser) {
		try {
			FileWriter writer = new FileWriter(chooser.getSelectedFile()
					+ "_Units.xml");

			BufferedReader r = new BufferedReader(new InputStreamReader(IOHelper.class
					.getResourceAsStream("/BaseUnit.txt")));

			String line = "";
			while ((line = r.readLine()) != null) {

				if (!line.contains("#")) {
					writer.write(line + System.getProperty("line.separator"));
				} else {
					String num = "";
					for (int i = 0; i < line.length(); i++) {
						if (line.substring(i, i + 1).equals("#")) {
							num = line.substring(i + 1, line.length());
							break;
						}
					}

					switch (Integer.parseInt(num)) {
					case 1:
						for (StructUnit s : l) {
							writer.write(s.getUnit());
						}
						break;
					case 2:
						for (StructUnit s : l) {
							writer.write(s.getUnitAI());
						}
						break;
					case 3:
						for (StructUnit s : l) {
							writer.write(s.getBuilds());
						}
						break;
					case 4:
						for (StructUnit s : l) {
							writer.write(s.getUpgrade());
						}
						break;
					case 5:
						for (StructUnit s : l) {
							writer.write(s.getPromotions());
						}
						break;
					case 6:
						for (StructUnit s : l) {
							writer.write(s.getFlavors());
						}
						break;
					case 7:
						for (StructUnit s : l) {
							writer.write(s.getResources());
						}
						break;
					case 8:
						for (StructUnit s : l) {
							writer.write(s.getKillYield());
						}
						break;
					case 9:
						for (StructUnit s : l) {
							writer.write(s.getUnitClass());
						}
						break;
					}
				}

			}

			writer.close();
			r.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeLeaderFile(Collection<StructLeader> l,
			JFileChooser chooser) {
		try {
			FileWriter writer = new FileWriter(chooser.getSelectedFile()
					+ "_Leaders.xml");
			
			BufferedReader r = new BufferedReader(new InputStreamReader(IOHelper.class
					.getResourceAsStream("/BaseLeader.txt")));

			String line = "";
			while ((line = r.readLine()) != null) {

				if (!line.contains("#")) {
					writer.write(line + System.getProperty("line.separator"));
				} else {
					String num = "";
					for (int i = 0; i < line.length(); i++) {
						if (line.substring(i, i + 1).equals("#")) {
							num = line.substring(i + 1, line.length());
							break;
						}
					}

					switch (Integer.parseInt(num)) {
					case 1:
						for (StructLeader s : l) {
							writer.write(s.getLeader());
						}
						break;
					case 2:
						for (StructLeader s : l) {
							writer.write(s.getMajorCivBiases());
						}
						break;
					case 3:
						for (StructLeader s : l) {
							writer.write(s.getMinorCivBiases());
						}
						break;
					case 4:
						for (StructLeader s : l) {
							writer.write(s.getFlavors());
						}
						break;
					case 5:
						for (StructLeader s : l) {
							writer.write(s.getTrait());
						}
						break;
					case 6:
						for (StructLeader s : l) {
							writer.write(s.getTag());
						}
						break;
					}
				}

			}

			writer.close();
			r.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeBuildingFile(Collection<StructBuilding> l,
			JFileChooser chooser) {
		try {
			FileWriter writer = new FileWriter(chooser.getSelectedFile()
					+ "_Buildings.xml");

			BufferedReader r = new BufferedReader(new InputStreamReader(IOHelper.class
					.getResourceAsStream("/BaseBuilding.txt")));

			String line = "";
			while ((line = r.readLine()) != null) {

				if (!line.contains("#")) {
					writer.write(line + System.getProperty("line.separator"));
				} else {
					String num = "";
					for (int i = 0; i < line.length(); i++) {
						if (line.substring(i, i + 1).equals("#")) {
							num = line.substring(i + 1, line.length());
							break;
						}
					}

					switch (Integer.parseInt(num)) {
					case 1:
						for (StructBuilding s : l) {
							writer.write(s.getBuilding());
						}
						break;
					case 2:
						for (StructBuilding s : l) {
							writer.write(s.getDomainExperience());
						}
						break;
					case 3:
						for (StructBuilding s : l) {
							writer.write(s.getProductionModifersExperience());
						}
						break;
					case 4:
						for (StructBuilding s : l) {
							writer.write(s.getFlavor());
						}
						break;
					case 5:
						for (StructBuilding s : l) {
							writer.write(s.getYeildChanges());
						}
						break;
					case 6:
						for (StructBuilding s : l) {
							writer.write(s.getYeildModifiers());
						}
						break;
					case 7:
						for (StructBuilding s : l) {
							writer.write(s.getBuildingClass());
						}
						break;
					case 9:
						for (StructBuilding s : l) {
							writer.write(s.getFeatureYeildChanges());
						}
						break;
					case 8:
						for (StructBuilding s : l) {
							writer.write(s.getTerrainYeildChanges());
						}
						break;
					case 10:
						for (StructBuilding s : l) {
							writer.write(s.getResourceYeildChanges());
						}
						break;
					case 11:
						for (StructBuilding s : l) {
							writer.write(s.getRequiresResources());
						}
						break;
					case 12:
						for (StructBuilding s : l) {
							writer.write(s.getGivenResources());
						}
						break;
					case 13:
						for (StructBuilding s : l) {
							writer.write(s.getCombatMods());
						}
						break;
					case 14:
						for (StructBuilding s : l) {
							writer.write(s.getLocalOrs());
						}
						break;
					}
				}

			}

			writer.close();
			r.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeCivFile(Collection<StructCivilization> c,
			JFileChooser chooser) {
		try {
			FileWriter writer = new FileWriter(chooser.getSelectedFile()
					+ "_Civilizations.xml");

			BufferedReader r = new BufferedReader(new InputStreamReader(IOHelper.class
					.getResourceAsStream("/Base.txt")));

			String line = "";
			while ((line = r.readLine()) != null) {

				if (!line.contains("#")) {
					writer.write(line + System.getProperty("line.separator"));
				} else {
					String num = "";
					for (int i = 0; i < line.length(); i++) {
						if (line.substring(i, i + 1).equals("#")) {
							num = line.substring(i + 1, line.length());
							break;
						}
					}

					switch (Integer.parseInt(num)) {
					case 1:
						for (StructCivilization s : c) {
							writer.write(s.getRowCivilization());
						}
						break;
					case 2:
						for (StructCivilization s : c) {
							writer.write(s.getPlayerColors());
						}
						break;
					case 3:
						for (StructCivilization s : c) {
							writer.write(s.getColors());
						}
						break;
					case 4:
						for (StructCivilization s : c) {
							writer.write(s.getLeader());
						}
						break;
					case 5:
						for (StructCivilization s : c) {
							writer.write(s.getReligion());
						}
						break;
					case 6:
						for (StructCivilization s : c) {
							writer.write(s.getBuildings());
						}
						break;
					case 7:
						for (StructCivilization s : c) {
							writer.write(s.getUnits());
						}
						break;
					case 8:
						for (StructCivilization s : c) {
							writer.write(s.getStartRegionPriority());
						}
						break;
					case 9:
						for (StructCivilization s : c) {
							writer.write(s.getCoastal());
						}
						break;
					case 10:
						for (StructCivilization s : c) {
							writer.write(s.getFreeBuildings());
						}
						break;
					case 11:
						for (StructCivilization s : c) {
							writer.write(s.getFreeUnits());
						}
						break;
					case 12:
						for (StructCivilization s : c) {
							writer.write(s.getFreeTechs());
						}
						break;
					case 13:
						for (StructCivilization s : c) {
							writer.write(s.getSpies());
						}
						break;
					case 14:
						for (StructCivilization s : c) {
							writer.write(s.getCities());
						}
						break;
					}
				}
			}

			writer.close();
			r.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
