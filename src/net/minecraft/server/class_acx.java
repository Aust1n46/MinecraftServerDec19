package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_ajp;
import net.minecraft.server.class_akc;
import net.minecraft.server.class_akf;
import net.minecraft.server.class_aki;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_akr;
import net.minecraft.server.BlockStone;
import net.minecraft.server.class_ali;
import net.minecraft.server.class_alk;
import net.minecraft.server.class_zy;

public class class_acx {
   public void a(class_act var1) {
      var1.a(new class_aas(Blocks.CHEST), new Object[]{"###", "# #", "###", Character.valueOf('#'), Blocks.PLANKS});
      var1.a(new class_aas(Blocks.TRAPPED_CHEST), new Object[]{"#-", Character.valueOf('#'), Blocks.CHEST, Character.valueOf('-'), Blocks.TRIPWIRE_HOOK});
      var1.a(new class_aas(Blocks.ENDER_CHEST), new Object[]{"###", "#E#", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('E'), Items.bK});
      var1.a(new class_aas(Blocks.FURNACE), new Object[]{"###", "# #", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      var1.a(new class_aas(Blocks.CRAFTING_TABLE), new Object[]{"##", "##", Character.valueOf('#'), Blocks.PLANKS});
      var1.a(new class_aas(Blocks.SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new class_aas(Blocks.SAND, 1, class_akq.class_a_in_class_akq.a.a())});
      var1.a(new class_aas(Blocks.RED_SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new class_aas(Blocks.SAND, 1, class_akq.class_a_in_class_akq.b.a())});
      var1.a(new class_aas(Blocks.SANDSTONE, 4, class_akr.class_a_in_class_akr.c.a()), new Object[]{"##", "##", Character.valueOf('#'), new class_aas(Blocks.SANDSTONE, 1, class_akr.class_a_in_class_akr.a.a())});
      var1.a(new class_aas(Blocks.RED_SANDSTONE, 4, class_aki.class_a_in_class_aki.c.a()), new Object[]{"##", "##", Character.valueOf('#'), new class_aas(Blocks.RED_SANDSTONE, 1, class_aki.class_a_in_class_aki.a.a())});
      var1.a(new class_aas(Blocks.SANDSTONE, 1, class_akr.class_a_in_class_akr.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new class_aas(Blocks.STONE_SLAB, 1, class_alk.class_a_in_class_alk.b.a())});
      var1.a(new class_aas(Blocks.RED_SANDSTONE, 1, class_aki.class_a_in_class_aki.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new class_aas(Blocks.STONE_SLAB2, 1, class_ajp.class_a_in_class_ajp.a.a())});
      var1.a(new class_aas(Blocks.QUARTZ_BLOCK, 1, class_akf.class_a_in_class_akf.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new class_aas(Blocks.STONE_SLAB, 1, class_alk.class_a_in_class_alk.h.a())});
      var1.a(new class_aas(Blocks.QUARTZ_BLOCK, 2, class_akf.class_a_in_class_akf.c.a()), new Object[]{"#", "#", Character.valueOf('#'), new class_aas(Blocks.QUARTZ_BLOCK, 1, class_akf.class_a_in_class_akf.a.a())});
      var1.a(new class_aas(Blocks.STONEBRICK, 4), new Object[]{"##", "##", Character.valueOf('#'), new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      var1.a(new class_aas(Blocks.STONEBRICK, 1, class_ali.P), new Object[]{"#", "#", Character.valueOf('#'), new class_aas(Blocks.STONE_SLAB, 1, class_alk.class_a_in_class_alk.f.a())});
      var1.b(new class_aas(Blocks.STONEBRICK, 1, class_ali.N), new Object[]{Blocks.STONEBRICK, Blocks.VINE});
      var1.b(new class_aas(Blocks.MOSSY_COBBLESTONE, 1), new Object[]{Blocks.COBBLESTONE, Blocks.VINE});
      var1.a(new class_aas(Blocks.IRON_BARS, 16), new Object[]{"###", "###", Character.valueOf('#'), Items.l});
      var1.a(new class_aas(Blocks.GLASS_PANE, 16), new Object[]{"###", "###", Character.valueOf('#'), Blocks.GLASS});
      var1.a(new class_aas(Blocks.REDSTONE_LAMP, 1), new Object[]{" R ", "RGR", " R ", Character.valueOf('R'), Items.aE, Character.valueOf('G'), Blocks.GLOWSTONE});
      var1.a(new class_aas(Blocks.BEACON, 1), new Object[]{"GGG", "GSG", "OOO", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('S'), Items.cc, Character.valueOf('O'), Blocks.OBSIDIAN});
      var1.a(new class_aas(Blocks.NETHER_BRICK, 1), new Object[]{"NN", "NN", Character.valueOf('N'), Items.ci});
      var1.a(new class_aas(Blocks.STONE, 2, BlockStone.EnumStoneVariant.DIORITE.getData()), new Object[]{"CQ", "QC", Character.valueOf('C'), Blocks.COBBLESTONE, Character.valueOf('Q'), Items.cj});
      var1.b(new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.getData()), new Object[]{new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData()), Items.cj});
      var1.b(new class_aas(Blocks.STONE, 2, BlockStone.EnumStoneVariant.ANDESITE.getData()), new Object[]{new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData()), Blocks.COBBLESTONE});
      var1.a(new class_aas(Blocks.DIRT, 4, class_ahj.class_a_in_class_ahj.b.a()), new Object[]{"DG", "GD", Character.valueOf('D'), new class_aas(Blocks.DIRT, 1, class_ahj.class_a_in_class_ahj.a.a()), Character.valueOf('G'), Blocks.GRAVEL});
      var1.a(new class_aas(Blocks.STONE, 4, BlockStone.EnumStoneVariant.DIORITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData())});
      var1.a(new class_aas(Blocks.STONE, 4, BlockStone.EnumStoneVariant.GRANITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.getData())});
      var1.a(new class_aas(Blocks.STONE, 4, BlockStone.EnumStoneVariant.ANDESITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new class_aas(Blocks.STONE, 1, BlockStone.EnumStoneVariant.ANDESITE.getData())});
      var1.a(new class_aas(Blocks.PRISMARINE, 1, class_akc.b), new Object[]{"SS", "SS", Character.valueOf('S'), Items.cF});
      var1.a(new class_aas(Blocks.PRISMARINE, 1, class_akc.N), new Object[]{"SSS", "SSS", "SSS", Character.valueOf('S'), Items.cF});
      var1.a(new class_aas(Blocks.PRISMARINE, 1, class_akc.O), new Object[]{"SSS", "SIS", "SSS", Character.valueOf('S'), Items.cF, Character.valueOf('I'), new class_aas(Items.aY, 1, class_zy.p.b())});
      var1.a(new class_aas(Blocks.SEA_LANTERN, 1, 0), new Object[]{"SCS", "CCC", "SCS", Character.valueOf('S'), Items.cF, Character.valueOf('C'), Items.cG});
      var1.a(new class_aas(Blocks.PURPUR_BLOCK, 4, 0), new Object[]{"FF", "FF", Character.valueOf('F'), Items.cJ});
      var1.a(new class_aas(Blocks.PURPUR_STAIRS, 4, 0), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.PURPUR_BLOCK});
      var1.a(new class_aas(Blocks.PURPUR_PILLAR, 1, 0), new Object[]{"#", "#", Character.valueOf('#'), Blocks.PURPUR_SLAB});
      var1.a(new class_aas(Blocks.END_BRICKS, 4, 0), new Object[]{"##", "##", Character.valueOf('#'), Blocks.END_STONE});
   }
}