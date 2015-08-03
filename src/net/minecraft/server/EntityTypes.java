package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityTypes {
   private static final Logger b = LogManager.getLogger();
   private static final Map c = Maps.newHashMap();
   private static final Map d = Maps.newHashMap();
   private static final Map e = Maps.newHashMap();
   private static final Map f = Maps.newHashMap();
   private static final Map g = Maps.newHashMap();
   public static final Map a = Maps.newLinkedHashMap();

   private static void a(Class var0, String var1, int var2) {
      if(c.containsKey(var1)) {
         throw new IllegalArgumentException("ID is already registered: " + var1);
      } else if(e.containsKey(Integer.valueOf(var2))) {
         throw new IllegalArgumentException("ID is already registered: " + var2);
      } else if(var2 == 0) {
         throw new IllegalArgumentException("Cannot register to reserved id: " + var2);
      } else if(var0 == null) {
         throw new IllegalArgumentException("Cannot register null clazz for id: " + var2);
      } else {
         c.put(var1, var0);
         d.put(var0, var1);
         e.put(Integer.valueOf(var2), var0);
         f.put(var0, Integer.valueOf(var2));
         g.put(var1, Integer.valueOf(var2));
      }
   }

   private static void a(Class var0, String var1, int var2, int var3, int var4) {
      a(var0, var1, var2);
      a.put(Integer.valueOf(var2), new EntityTypes.class_a_in_class_pt(var2, var3, var4));
   }

   public static Entity a(String var0, World var1) {
      Entity var2 = null;

      try {
         Class var3 = (Class)c.get(var0);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var2;
   }

   public static Entity a(NBTTagCompound var0, World var1) {
      Entity var2 = null;
      if("Minecart".equals(var0.getString("id"))) {
         var0.put("id", class_vn.class_a_in_class_vn.a(var0.getInt("Type")).b());
         var0.remove("Type");
      }

      try {
         Class var3 = (Class)c.get(var0.getString("id"));
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.f(var0);
      } else {
         b.warn("Skipping Entity with id " + var0.getString("id"));
      }

      return var2;
   }

   public static Entity a(int var0, World var1) {
      Entity var2 = null;

      try {
         Class var3 = a(var0);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 == null) {
         b.warn("Skipping Entity with id " + var0);
      }

      return var2;
   }

   public static int a(Entity var0) {
      Integer var1 = (Integer)f.get(var0.getClass());
      return var1 == null?0:var1.intValue();
   }

   public static Class a(int var0) {
      return (Class)e.get(Integer.valueOf(var0));
   }

   public static String b(Entity var0) {
      return (String)d.get(var0.getClass());
   }

   public static String b(int var0) {
      return (String)d.get(a(var0));
   }

   public static void a() {
   }

   public static List b() {
      Set var0 = c.keySet();
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Class var4 = (Class)c.get(var3);
         if((var4.getModifiers() & 1024) != 1024) {
            var1.add(var3);
         }
      }

      var1.add("LightningBolt");
      return var1;
   }

   public static boolean a(Entity var0, String var1) {
      String var2 = b(var0);
      if(var2 == null && var0 instanceof EntityHuman) {
         var2 = "Player";
      } else if(var2 == null && var0 instanceof class_vi) {
         var2 = "LightningBolt";
      }

      return var1.equals(var2);
   }

   public static boolean b(String var0) {
      return "Player".equals(var0) || b().contains(var0);
   }

   static {
      a(EntityItem.class, "Item", 1);
      a(EntityExperienceOrb.class, "XPOrb", 2);
      a(class_xp.class, "ThrownEgg", 7);
      a(class_vb.class, "LeashKnot", 8);
      a(class_vc.class, "Painting", 9);
      a(class_xd.class, "Arrow", 10);
      a(class_xm.class, "Snowball", 11);
      a(class_xh.class, "Fireball", 12);
      a(class_xl.class, "SmallFireball", 13);
      a(class_xq.class, "ThrownEnderpearl", 14);
      a(class_xe.class, "EyeOfEnderSignal", 15);
      a(class_xs.class, "ThrownPotion", 16);
      a(class_xr.class, "ThrownExpBottle", 17);
      a(class_va.class, "ItemFrame", 18);
      a(class_xu.class, "WitherSkull", 19);
      a(EntityTNTPrimed.class, "PrimedTnt", 20);
      a(EntityFallingBlock.class, "FallingSand", 21);
      a(class_xg.class, "FireworksRocketEntity", 22);
      a(class_xt.class, "TippedArrow", 23);
      a(class_xn.class, "SpectralArrow", 24);
      a(class_xk.class, "ShulkerBullet", 25);
      a(class_uy.class, "ArmorStand", 30);
      a(class_vk.class, "Boat", 41);
      a(class_vt.class, class_vn.class_a_in_class_vn.a.b(), 42);
      a(class_vo.class, class_vn.class_a_in_class_vn.b.b(), 43);
      a(class_vr.class, class_vn.class_a_in_class_vn.c.b(), 44);
      a(class_vv.class, class_vn.class_a_in_class_vn.d.b(), 45);
      a(class_vs.class, class_vn.class_a_in_class_vn.f.b(), 46);
      a(class_vu.class, class_vn.class_a_in_class_vn.e.b(), 47);
      a(class_vp.class, class_vn.class_a_in_class_vn.g.b(), 40);
      a(class_qb.class, "Mob", 48);
      a(class_wi.class, "Monster", 49);
      a(class_wa.class, "Creeper", 50, 894731, 0);
      a(class_wn.class, "Skeleton", 51, 12698049, 4802889);
      a(class_wp.class, "Spider", 52, 3419431, 11013646);
      a(class_wf.class, "Giant", 53);
      a(class_wr.class, "Zombie", 54, '꾯', 7969893);
      a(class_wo.class, "Slime", 55, 5349438, 8306542);
      a(class_we.class, "Ghast", 56, 16382457, 12369084);
      a(class_wj.class, "PigZombie", 57, 15373203, 5009705);
      a(class_wb.class, "Enderman", 58, 1447446, 0);
      a(class_vz.class, "CaveSpider", 59, 803406, 11013646);
      a(class_wm.class, "Silverfish", 60, 7237230, 3158064);
      a(class_vy.class, "Blaze", 61, 16167425, 16775294);
      a(class_wh.class, "LavaSlime", 62, 3407872, 16579584);
      a(class_ur.class, "EnderDragon", 63);
      a(class_uw.class, "WitherBoss", 64);
      a(class_tu.class, "Bat", 65, 4996656, 986895);
      a(class_wq.class, "Witch", 66, 3407872, 5349438);
      a(class_wc.class, "Endermite", 67, 1447446, 7237230);
      a(class_wg.class, "Guardian", 68, 5931634, 15826224);
      a(class_ug.class, "Shulker", 69, 9725844, 5060690);
      a(class_ud.class, "Pig", 90, 15771042, 14377823);
      a(class_uf.class, "Sheep", 91, 15198183, 16758197);
      a(class_ty.class, "Cow", 92, 4470310, 10592673);
      a(class_tx.class, "Chicken", 93, 10592673, 16711680);
      a(class_ui.class, "Squid", 94, 2243405, 7375001);
      a(class_ul.class, "Wolf", 95, 14144467, 13545366);
      a(class_ub.class, "MushroomCow", 96, 10489616, 12040119);
      a(class_uh.class, "SnowMan", 97);
      a(class_uc.class, "Ozelot", 98, 15720061, 5653556);
      a(class_uj.class, "VillagerGolem", 99);
      a(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
      a(class_ue.class, "Rabbit", 101, 10051392, 7555121);
      a(class_wv.class, "Villager", 120, 5651507, 12422002);
      a(class_uq.class, "EnderCrystal", 200);
   }

   public static class class_a_in_class_pt {
      public final int a;
      public final int b;
      public final int c;
      public final class_my d;
      public final class_my e;

      public class_a_in_class_pt(int var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = StatisticList.a(this);
         this.e = StatisticList.b(this);
      }
   }
}
