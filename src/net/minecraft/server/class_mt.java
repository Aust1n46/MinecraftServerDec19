package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;

public class class_mt {
   public static int a;
   public static int b;
   public static int c;
   public static int d;
   public static List e = Lists.newArrayList();
   public static class_ms f;
   public static class_ms g;
   public static class_ms h;
   public static class_ms i;
   public static class_ms j;
   public static class_ms k;
   public static class_ms l;
   public static class_ms m;
   public static class_ms n;
   public static class_ms o;
   public static class_ms p;
   public static class_ms q;
   public static class_ms r;
   public static class_ms s;
   public static class_ms t;
   public static class_ms u;
   public static class_ms v;
   public static class_ms w;
   public static class_ms x;
   public static class_ms y;
   public static class_ms z;
   public static class_ms A;
   public static class_ms B;
   public static class_ms C;
   public static class_ms D;
   public static class_ms E;
   public static class_ms F;
   public static class_ms G;
   public static class_ms H;
   public static class_ms I;
   public static class_ms J;
   public static class_ms K;
   public static class_ms L;
   public static class_ms M;

   public static void a() {
   }

   static {
      f = (new class_ms("achievement.openInventory", "openInventory", 0, 0, Items.BOOK, (class_ms)null)).a().c();
      g = (new class_ms("achievement.mineWood", "mineWood", 2, 1, Blocks.LOG, f)).c();
      h = (new class_ms("achievement.buildWorkBench", "buildWorkBench", 4, -1, Blocks.CRAFTING_TABLE, g)).c();
      i = (new class_ms("achievement.buildPickaxe", "buildPickaxe", 4, 2, Items.WOODEN_PICKAXE, h)).c();
      j = (new class_ms("achievement.buildFurnace", "buildFurnace", 3, 4, Blocks.FURNACE, i)).c();
      k = (new class_ms("achievement.acquireIron", "acquireIron", 1, 4, Items.IRON_INGOT, j)).c();
      l = (new class_ms("achievement.buildHoe", "buildHoe", 2, -3, Items.WOODEN_HOE, h)).c();
      m = (new class_ms("achievement.makeBread", "makeBread", -1, -3, Items.BREAD, l)).c();
      n = (new class_ms("achievement.bakeCake", "bakeCake", 0, -5, Items.CAKE, l)).c();
      o = (new class_ms("achievement.buildBetterPickaxe", "buildBetterPickaxe", 6, 2, Items.STONE_PICKAXE, i)).c();
      p = (new class_ms("achievement.cookFish", "cookFish", 2, 6, Items.COOKED_FISH, j)).c();
      q = (new class_ms("achievement.onARail", "onARail", 2, 3, Blocks.RAIL, k)).b().c();
      r = (new class_ms("achievement.buildSword", "buildSword", 6, -1, Items.WOODEN_SWORD, h)).c();
      s = (new class_ms("achievement.killEnemy", "killEnemy", 8, -1, Items.BONE, r)).c();
      t = (new class_ms("achievement.killCow", "killCow", 7, -3, Items.LEATHER, r)).c();
      u = (new class_ms("achievement.flyPig", "flyPig", 9, -3, Items.SADDLE, t)).b().c();
      v = (new class_ms("achievement.snipeSkeleton", "snipeSkeleton", 7, 0, Items.BOW, s)).b().c();
      w = (new class_ms("achievement.diamonds", "diamonds", -1, 5, Blocks.DIAMOND_ORE, k)).c();
      x = (new class_ms("achievement.diamondsToYou", "diamondsToYou", -1, 2, Items.DIAMOND, w)).c();
      y = (new class_ms("achievement.portal", "portal", -1, 7, Blocks.OBSIDIAN, w)).c();
      z = (new class_ms("achievement.ghast", "ghast", -4, 8, Items.GHAST_TEAR, y)).b().c();
      A = (new class_ms("achievement.blazeRod", "blazeRod", 0, 9, Items.BLAZE_ROD, y)).c();
      B = (new class_ms("achievement.potion", "potion", 2, 8, Items.POTION, A)).c();
      C = (new class_ms("achievement.theEnd", "theEnd", 3, 10, Items.ENDER_EYE, A)).b().c();
      D = (new class_ms("achievement.theEnd2", "theEnd2", 4, 13, Blocks.DRAGON_EGG, C)).b().c();
      E = (new class_ms("achievement.enchantments", "enchantments", -4, 4, Blocks.ENCHANTING_TABLE, w)).c();
      F = (new class_ms("achievement.overkill", "overkill", -4, 1, Items.DIAMOND_SWORD, E)).b().c();
      G = (new class_ms("achievement.bookcase", "bookcase", -3, 6, Blocks.BOOKSHELF, E)).c();
      H = (new class_ms("achievement.breedCow", "breedCow", 7, -5, Items.WHEAT, t)).c();
      I = (new class_ms("achievement.spawnWither", "spawnWither", 7, 12, new ItemStack(Items.SKULL, 1, 1), D)).c();
      J = (new class_ms("achievement.killWither", "killWither", 7, 10, Items.NETHER_STAR, I)).c();
      K = (new class_ms("achievement.fullBeacon", "fullBeacon", 7, 8, Blocks.BEACON, J)).b().c();
      L = (new class_ms("achievement.exploreAllBiomes", "exploreAllBiomes", 4, 8, Items.DIAMOND_BOOTS, C)).a(class_ne.class).b().c();
      M = (new class_ms("achievement.overpowered", "overpowered", 6, 4, new ItemStack(Items.GOLDEN_APPLE, 1, 1), o)).b().c();
   }
}
