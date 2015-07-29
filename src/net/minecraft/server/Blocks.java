package net.minecraft.server;

import net.minecraft.server.class_agg;
import net.minecraft.server.Block;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_agq;
import net.minecraft.server.class_agt;
import net.minecraft.server.class_agu;
import net.minecraft.server.class_ahb;
import net.minecraft.server.class_ahe;
import net.minecraft.server.class_ahf;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_ahp;
import net.minecraft.server.class_aib;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_aik;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_aiu;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajj;
import net.minecraft.server.class_ajx;
import net.minecraft.server.class_akk;
import net.minecraft.server.class_akn;
import net.minecraft.server.class_ako;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_akv;
import net.minecraft.server.class_alb;
import net.minecraft.server.class_alc;
import net.minecraft.server.class_alf;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_alt;
import net.minecraft.server.class_ane;
import net.minecraft.server.class_anf;
import net.minecraft.server.class_anh;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Bootstrap;

public class Blocks {

	public static final Block AIR;
	public static final Block STONE;
	public static final class_aik GRASS;
	public static final Block DIRT;
	public static final Block COBBLESTONE;
	public static final Block PLANKS;
	public static final Block SAPLING;
	public static final Block BEDROCK;
	public static final class_ahp FLOWING_WATER;
	public static final class_alf WATER;
	public static final class_ahp FLOWING_LAVA;
	public static final class_alf LAVA;
	public static final class_akq SAND;
	public static final Block GRAVEL;
	public static final Block GOLD_ORE;
	public static final Block IRON_ORE;
	public static final Block COAL_ORE;
	public static final Block LOG;
	public static final Block LOG2;
	public static final class_aja LEAVES;
	public static final class_aja LEAVES2;
	public static final Block SPONGE;
	public static final Block GLASS;
	public static final Block LAPIS_ORE;
	public static final Block LAPIS_BLOCK;
	public static final Block DISPENSER;
	public static final Block SANDSTONE;
	public static final Block NOTEBLOCK;
	public static final Block BED;
	public static final Block GOLDEN_RAIL;
	public static final Block DETECTOR_RAIL;
	public static final class_ane STICKY_PISTON;
	public static final Block WEB;
	public static final class_alm TALLGRASS;
	public static final class_ahf DEADBUSH;
	public static final class_ane PISTON;
	public static final class_anf PISTON_HEAD;
	public static final Block WOOL;
	public static final class_anh PISTON_EXTENSION;
	public static final class_aic YELLOW_FLOWER;
	public static final class_aic RED_FLOWER;
	public static final class_ago BROWN_MUSHROOM;
	public static final class_ago RED_MUSHROOM;
	public static final Block GOLD_BLOCK;
	public static final Block IRON_BLOCK;
	public static final class_aio DOUBLE_SANDSTONE_SLAB;
	public static final class_aio STONE_SLAB;
	public static final Block BRICK_BLOCK;
	public static final Block TNT;
	public static final Block BOOKSHELF;
	public static final Block MOSSY_COBBLESTONE;
	public static final Block OBSIDIAN;
	public static final Block TORCH;
	public static final class_aib FIRE;
	public static final Block MOB_SPAWNER;
	public static final Block OAK_STAIRS;
	public static final class_agu CHEST;
	public static final class_akk REDSTONE_WIRE;
	public static final Block DIAMOND_ORE;
	public static final Block DIAMOND_BLOCK;
	public static final Block CRAFTING_TABLE;
	public static final Block WHEAT;
	public static final Block FARMLAND;
	public static final Block FURNACE;
	public static final Block LIT_FURNACE;
	public static final Block STANDING_SIGN;
	public static final Block WOODEN_DOOR;
	public static final Block SPRUCE_DOOR;
	public static final Block BIRCH_DOOR;
	public static final Block JUNGLE_DOOR;
	public static final Block ACACIA_DOOR;
	public static final Block DARK_OAK_DOOR;
	public static final Block LADDER;
	public static final Block RAIL;
	public static final Block STONE_STAIRS;
	public static final Block WALL_SIGN;
	public static final Block LEVER;
	public static final Block STONE_PRESSURE_PLATE;
	public static final Block IRON_DOOR;
	public static final Block WOODEN_PRESSURE_PLATE;
	public static final Block REDSTONE_ORE;
	public static final Block LIT_REDSTONE_ORE;
	public static final Block UNLIT_REDSTONE_TORCH;
	public static final Block REDSTONE_TORCH;
	public static final Block STONE_BUTTON;
	public static final Block SNOW_LAYER;
	public static final Block ICE;
	public static final Block SNOW;
	public static final class_agq CACTUS;
	public static final Block CLAY;
	public static final class_akn REEDS;
	public static final Block JUKEBOX;
	public static final Block FENCE;
	public static final Block SPRUCE_FENCE;
	public static final Block BIRCH_FENCE;
	public static final Block JUNGLE_FENCE;
	public static final Block DARK_OAK_FENCE;
	public static final Block ACACIA_FENCE;
	public static final Block PUMPKIN;
	public static final Block NETHERRACK;
	public static final Block SOUL_SAND;
	public static final Block GLOWSTONE;
	public static final class_ajx PORTAL;
	public static final Block LIT_PUMPKIN;
	public static final Block CAKE;
	public static final class_ako UNPOWERED_REPEATER;
	public static final class_ako POWERED_REPEATER;
	public static final Block TRAPDOOR;
	public static final Block MONSTER_EGG;
	public static final Block STONEBRICK;
	public static final Block BROWN_MUSHROOM_BLOCK;
	public static final Block RED_MUSHROOM_BLOCK;
	public static final Block IRON_BARS;
	public static final Block GLASS_PANE;
	public static final Block MELON_BLOCK;
	public static final Block PUMPKIN_STEM;
	public static final Block MELON_STEM;
	public static final Block VINE;
	public static final Block FENCE_GATE;
	public static final Block SPRUCE_FENCE_GATE;
	public static final Block BIRCH_FENCE_GATE;
	public static final Block JUGLE_FENCE_GATE;
	public static final Block DARK_OAK_FENCE_GATE;
	public static final Block ACACIA_FENCE_GATE;
	public static final Block BRICK_STAIRS;
	public static final Block STONE_BRICK_STAIRS;
	public static final class_ajj MYCELIM;
	public static final Block WATERLILY;
	public static final Block NETHER_BRICK;
	public static final Block NETHER_BRICK_FENCE;
	public static final Block NETHER_BTICK_STAIRS;
	public static final Block NETHER_WART;
	public static final Block ENCHANTING_TABLE;
	public static final Block BREWING_STAND;
	public static final class_agt CAULDRON;
	public static final Block END_PORTAL;
	public static final Block END_PORTAL_FRAME;
	public static final Block END_STONE;
	public static final Block DRAGON_EGG;
	public static final Block REDSTONE_LAMP;
	public static final Block LIT_REDSTONE_LAMP;
	public static final class_aio DOUBLE_WOODEN_SLAB;
	public static final class_aio WOODEN_SLAB;
	public static final Block COCOA;
	public static final Block SANDSTONE_STAIRS;
	public static final Block EMERALD_ORE;
	public static final Block ENDER_CHEST;
	public static final class_alt TRIPWIRE_HOOK;
	public static final Block TRIPWIRE;
	public static final Block EMERALD_BLOCK;
	public static final Block SPRUCE_STAIRS;
	public static final Block BIRCH_STAIRS;
	public static final Block JUNGKE_STAIRS;
	public static final Block COMMAND_BLOCK;
	public static final class_agg BEACON;
	public static final Block COBBLESTONE_WALL;
	public static final Block FLOWER_POT;
	public static final Block CARROTS;
	public static final Block POTATOES;
	public static final Block WOODEN_BUTTON;
	public static final class_akv SKULL;
	public static final Block ANVIL;
	public static final Block TRAPPED_CHEST;
	public static final Block LIGHT_W_PRESSURE_PLATE;
	public static final Block HEAVY_W_PRESSURE_PLATE;
	public static final class_ahb UNPOWERED_COMPARATOR;
	public static final class_ahb POWERED_COMPARATOR;
	public static final class_ahe DAYLIGHT_DETECTOR;
	public static final class_ahe DAYLIGHT_DETECTOR_INVERTED;
	public static final Block REDSTONE_BLOCK;
	public static final Block QUARTZ_ORE;
	public static final class_aiu HOPPER;
	public static final Block QUARTZ_BLOCK;
	public static final Block QUARTZ_STAIRS;
	public static final Block ACTIVATOR_RAIL;
	public static final Block DROPPER;
	public static final Block STAINED_HARDENED_CLAY;
	public static final Block BARRIER;
	public static final Block IRON_TRAPDOOR;
	public static final Block HAY_BLOCK;
	public static final Block CARPET;
	public static final Block HARDENED_CLAY;
	public static final Block COAL_BLOCK;
	public static final Block PACKED_ICE;
	public static final Block ACACIA_STAIRS;
	public static final Block DARK_OAK_STAIRS;
	public static final Block SLINE;
	public static final class_ahm DOUBLE_PLANT;
	public static final class_alb STAINED_GLASS;
	public static final class_alc STAINED_GLASS_PANE;
	public static final Block PRISMARINE;
	public static final Block SEA_LANTERN;
	public static final Block STANDING_BANNER;
	public static final Block WALL_BANNER;
	public static final Block RED_SANDSTONE;
	public static final Block RED_SANDSTONE_STAIRS;
	public static final class_aio DOUBLE_STONE_SLAB2;
	public static final class_aio STONE_SLAB2;
	public static final Block END_ROD;
	public static final Block CHORUS_PLANT;
	public static final Block CHORUS_FLOWER;
	public static final Block PURPUR_BLOCK;
	public static final Block PURPUR_PILLAR;
	public static final Block PURPUR_STAIRS;
	public static final class_aio PURPUR_DOUBLE_SLAB;
	public static final class_aio PURPUR_SLAB;
	public static final Block END_BRICKS;
	public static final Block BEETROOTS;
	public static final Block GRASS_PATH;
	public static final Block END_GATEWAY;
	public static final Block STRUCTURE_BLOCK;

	private static Block getByName(String string) {
		Block block = Block.BLOCK_REGISTRY.get(new MinecraftKey(string));
		if (block == null) {
			throw new IllegalStateException("Invalid Block requested: " + string);
		} else {
			return block;
		}
	}

	static {
		if (!Bootstrap.isInitDone()) {
			throw new RuntimeException("Accessed Blocks before Bootstrap!");
		} else {
			AIR = getByName("air");
			STONE = getByName("stone");
			GRASS = (class_aik) getByName("grass");
			DIRT = getByName("dirt");
			COBBLESTONE = getByName("cobblestone");
			PLANKS = getByName("planks");
			SAPLING = getByName("sapling");
			BEDROCK = getByName("bedrock");
			FLOWING_WATER = (class_ahp) getByName("flowing_water");
			WATER = (class_alf) getByName("water");
			FLOWING_LAVA = (class_ahp) getByName("flowing_lava");
			LAVA = (class_alf) getByName("lava");
			SAND = (class_akq) getByName("sand");
			GRAVEL = getByName("gravel");
			GOLD_ORE = getByName("gold_ore");
			IRON_ORE = getByName("iron_ore");
			COAL_ORE = getByName("coal_ore");
			LOG = getByName("log");
			LOG2 = getByName("log2");
			LEAVES = (class_aja) getByName("leaves");
			LEAVES2 = (class_aja) getByName("leaves2");
			SPONGE = getByName("sponge");
			GLASS = getByName("glass");
			LAPIS_ORE = getByName("lapis_ore");
			LAPIS_BLOCK = getByName("lapis_block");
			DISPENSER = getByName("dispenser");
			SANDSTONE = getByName("sandstone");
			NOTEBLOCK = getByName("noteblock");
			BED = getByName("bed");
			GOLDEN_RAIL = getByName("golden_rail");
			DETECTOR_RAIL = getByName("detector_rail");
			STICKY_PISTON = (class_ane) getByName("sticky_piston");
			WEB = getByName("web");
			TALLGRASS = (class_alm) getByName("tallgrass");
			DEADBUSH = (class_ahf) getByName("deadbush");
			PISTON = (class_ane) getByName("piston");
			PISTON_HEAD = (class_anf) getByName("piston_head");
			WOOL = getByName("wool");
			PISTON_EXTENSION = (class_anh) getByName("piston_extension");
			YELLOW_FLOWER = (class_aic) getByName("yellow_flower");
			RED_FLOWER = (class_aic) getByName("red_flower");
			BROWN_MUSHROOM = (class_ago) getByName("brown_mushroom");
			RED_MUSHROOM = (class_ago) getByName("red_mushroom");
			GOLD_BLOCK = getByName("gold_block");
			IRON_BLOCK = getByName("iron_block");
			DOUBLE_SANDSTONE_SLAB = (class_aio) getByName("double_stone_slab");
			STONE_SLAB = (class_aio) getByName("stone_slab");
			BRICK_BLOCK = getByName("brick_block");
			TNT = getByName("tnt");
			BOOKSHELF = getByName("bookshelf");
			MOSSY_COBBLESTONE = getByName("mossy_cobblestone");
			OBSIDIAN = getByName("obsidian");
			TORCH = getByName("torch");
			FIRE = (class_aib) getByName("fire");
			MOB_SPAWNER = getByName("mob_spawner");
			OAK_STAIRS = getByName("oak_stairs");
			CHEST = (class_agu) getByName("chest");
			REDSTONE_WIRE = (class_akk) getByName("redstone_wire");
			DIAMOND_ORE = getByName("diamond_ore");
			DIAMOND_BLOCK = getByName("diamond_block");
			CRAFTING_TABLE = getByName("crafting_table");
			WHEAT = getByName("wheat");
			FARMLAND = getByName("farmland");
			FURNACE = getByName("furnace");
			LIT_FURNACE = getByName("lit_furnace");
			STANDING_SIGN = getByName("standing_sign");
			WOODEN_DOOR = getByName("wooden_door");
			SPRUCE_DOOR = getByName("spruce_door");
			BIRCH_DOOR = getByName("birch_door");
			JUNGLE_DOOR = getByName("jungle_door");
			ACACIA_DOOR = getByName("acacia_door");
			DARK_OAK_DOOR = getByName("dark_oak_door");
			LADDER = getByName("ladder");
			RAIL = getByName("rail");
			STONE_STAIRS = getByName("stone_stairs");
			WALL_SIGN = getByName("wall_sign");
			LEVER = getByName("lever");
			STONE_PRESSURE_PLATE = getByName("stone_pressure_plate");
			IRON_DOOR = getByName("iron_door");
			WOODEN_PRESSURE_PLATE = getByName("wooden_pressure_plate");
			REDSTONE_ORE = getByName("redstone_ore");
			LIT_REDSTONE_ORE = getByName("lit_redstone_ore");
			UNLIT_REDSTONE_TORCH = getByName("unlit_redstone_torch");
			REDSTONE_TORCH = getByName("redstone_torch");
			STONE_BUTTON = getByName("stone_button");
			SNOW_LAYER = getByName("snow_layer");
			ICE = getByName("ice");
			SNOW = getByName("snow");
			CACTUS = (class_agq) getByName("cactus");
			CLAY = getByName("clay");
			REEDS = (class_akn) getByName("reeds");
			JUKEBOX = getByName("jukebox");
			FENCE = getByName("fence");
			SPRUCE_FENCE = getByName("spruce_fence");
			BIRCH_FENCE = getByName("birch_fence");
			JUNGLE_FENCE = getByName("jungle_fence");
			DARK_OAK_FENCE = getByName("dark_oak_fence");
			ACACIA_FENCE = getByName("acacia_fence");
			PUMPKIN = getByName("pumpkin");
			NETHERRACK = getByName("netherrack");
			SOUL_SAND = getByName("soul_sand");
			GLOWSTONE = getByName("glowstone");
			PORTAL = (class_ajx) getByName("portal");
			LIT_PUMPKIN = getByName("lit_pumpkin");
			CAKE = getByName("cake");
			UNPOWERED_REPEATER = (class_ako) getByName("unpowered_repeater");
			POWERED_REPEATER = (class_ako) getByName("powered_repeater");
			TRAPDOOR = getByName("trapdoor");
			MONSTER_EGG = getByName("monster_egg");
			STONEBRICK = getByName("stonebrick");
			BROWN_MUSHROOM_BLOCK = getByName("brown_mushroom_block");
			RED_MUSHROOM_BLOCK = getByName("red_mushroom_block");
			IRON_BARS = getByName("iron_bars");
			GLASS_PANE = getByName("glass_pane");
			MELON_BLOCK = getByName("melon_block");
			PUMPKIN_STEM = getByName("pumpkin_stem");
			MELON_STEM = getByName("melon_stem");
			VINE = getByName("vine");
			FENCE_GATE = getByName("fence_gate");
			SPRUCE_FENCE_GATE = getByName("spruce_fence_gate");
			BIRCH_FENCE_GATE = getByName("birch_fence_gate");
			JUGLE_FENCE_GATE = getByName("jungle_fence_gate");
			DARK_OAK_FENCE_GATE = getByName("dark_oak_fence_gate");
			ACACIA_FENCE_GATE = getByName("acacia_fence_gate");
			BRICK_STAIRS = getByName("brick_stairs");
			STONE_BRICK_STAIRS = getByName("stone_brick_stairs");
			MYCELIM = (class_ajj) getByName("mycelium");
			WATERLILY = getByName("waterlily");
			NETHER_BRICK = getByName("nether_brick");
			NETHER_BRICK_FENCE = getByName("nether_brick_fence");
			NETHER_BTICK_STAIRS = getByName("nether_brick_stairs");
			NETHER_WART = getByName("nether_wart");
			ENCHANTING_TABLE = getByName("enchanting_table");
			BREWING_STAND = getByName("brewing_stand");
			CAULDRON = (class_agt) getByName("cauldron");
			END_PORTAL = getByName("end_portal");
			END_PORTAL_FRAME = getByName("end_portal_frame");
			END_STONE = getByName("end_stone");
			DRAGON_EGG = getByName("dragon_egg");
			REDSTONE_LAMP = getByName("redstone_lamp");
			LIT_REDSTONE_LAMP = getByName("lit_redstone_lamp");
			DOUBLE_WOODEN_SLAB = (class_aio) getByName("double_wooden_slab");
			WOODEN_SLAB = (class_aio) getByName("wooden_slab");
			COCOA = getByName("cocoa");
			SANDSTONE_STAIRS = getByName("sandstone_stairs");
			EMERALD_ORE = getByName("emerald_ore");
			ENDER_CHEST = getByName("ender_chest");
			TRIPWIRE_HOOK = (class_alt) getByName("tripwire_hook");
			TRIPWIRE = getByName("tripwire");
			EMERALD_BLOCK = getByName("emerald_block");
			SPRUCE_STAIRS = getByName("spruce_stairs");
			BIRCH_STAIRS = getByName("birch_stairs");
			JUNGKE_STAIRS = getByName("jungle_stairs");
			COMMAND_BLOCK = getByName("command_block");
			BEACON = (class_agg) getByName("beacon");
			COBBLESTONE_WALL = getByName("cobblestone_wall");
			FLOWER_POT = getByName("flower_pot");
			CARROTS = getByName("carrots");
			POTATOES = getByName("potatoes");
			WOODEN_BUTTON = getByName("wooden_button");
			SKULL = (class_akv) getByName("skull");
			ANVIL = getByName("anvil");
			TRAPPED_CHEST = getByName("trapped_chest");
			LIGHT_W_PRESSURE_PLATE = getByName("light_weighted_pressure_plate");
			HEAVY_W_PRESSURE_PLATE = getByName("heavy_weighted_pressure_plate");
			UNPOWERED_COMPARATOR = (class_ahb) getByName("unpowered_comparator");
			POWERED_COMPARATOR = (class_ahb) getByName("powered_comparator");
			DAYLIGHT_DETECTOR = (class_ahe) getByName("daylight_detector");
			DAYLIGHT_DETECTOR_INVERTED = (class_ahe) getByName("daylight_detector_inverted");
			REDSTONE_BLOCK = getByName("redstone_block");
			QUARTZ_ORE = getByName("quartz_ore");
			HOPPER = (class_aiu) getByName("hopper");
			QUARTZ_BLOCK = getByName("quartz_block");
			QUARTZ_STAIRS = getByName("quartz_stairs");
			ACTIVATOR_RAIL = getByName("activator_rail");
			DROPPER = getByName("dropper");
			STAINED_HARDENED_CLAY = getByName("stained_hardened_clay");
			BARRIER = getByName("barrier");
			IRON_TRAPDOOR = getByName("iron_trapdoor");
			HAY_BLOCK = getByName("hay_block");
			CARPET = getByName("carpet");
			HARDENED_CLAY = getByName("hardened_clay");
			COAL_BLOCK = getByName("coal_block");
			PACKED_ICE = getByName("packed_ice");
			ACACIA_STAIRS = getByName("acacia_stairs");
			DARK_OAK_STAIRS = getByName("dark_oak_stairs");
			SLINE = getByName("slime");
			DOUBLE_PLANT = (class_ahm) getByName("double_plant");
			STAINED_GLASS = (class_alb) getByName("stained_glass");
			STAINED_GLASS_PANE = (class_alc) getByName("stained_glass_pane");
			PRISMARINE = getByName("prismarine");
			SEA_LANTERN = getByName("sea_lantern");
			STANDING_BANNER = getByName("standing_banner");
			WALL_BANNER = getByName("wall_banner");
			RED_SANDSTONE = getByName("red_sandstone");
			RED_SANDSTONE_STAIRS = getByName("red_sandstone_stairs");
			DOUBLE_STONE_SLAB2 = (class_aio) getByName("double_stone_slab2");
			STONE_SLAB2 = (class_aio) getByName("stone_slab2");
			END_ROD = getByName("end_rod");
			CHORUS_PLANT = getByName("chorus_plant");
			CHORUS_FLOWER = getByName("chorus_flower");
			PURPUR_BLOCK = getByName("purpur_block");
			PURPUR_PILLAR = getByName("purpur_pillar");
			PURPUR_STAIRS = getByName("purpur_stairs");
			PURPUR_DOUBLE_SLAB = (class_aio) getByName("purpur_double_slab");
			PURPUR_SLAB = (class_aio) getByName("purpur_slab");
			END_BRICKS = getByName("end_bricks");
			BEETROOTS = getByName("beetroots");
			GRASS_PATH = getByName("grass_path");
			END_GATEWAY = getByName("end_gateway");
			STRUCTURE_BLOCK = getByName("structure_block");
		}
	}

}