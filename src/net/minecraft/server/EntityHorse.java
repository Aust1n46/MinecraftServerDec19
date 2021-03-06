package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class EntityHorse extends class_tw implements class_ok {
   private static final Predicate by = new Predicate() {
      public boolean a(Entity var1) {
         return var1 instanceof EntityHorse && ((EntityHorse)var1).cP();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((Entity)var1);
      }
   };
   private static final class_qk bz = (new class_qs((class_qk)null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).a("Jump Strength").a(true);
   private static final int bA = Datawathcer.claimId(EntityHorse.class);
   private static final int bB = Datawathcer.claimId(EntityHorse.class);
   private static final int bC = Datawathcer.claimId(EntityHorse.class);
   private static final int bD = Datawathcer.claimId(EntityHorse.class);
   private static final int bE = Datawathcer.claimId(EntityHorse.class);
   private static final String[] bF = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
   private static final String[] bG = new String[]{"", "meo", "goo", "dio"};
   private static final int[] bH = new int[]{0, 5, 7, 11};
   private static final String[] bI = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
   private static final String[] bJ = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
   private static final String[] bK = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
   private static final String[] bL = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
   private int bM;
   private int bN;
   private int bO;
   public int bs;
   public int bt;
   protected boolean bu;
   private class_ya bP;
   private boolean bQ;
   protected int bw;
   protected float bx;
   private boolean bR;
   private float bS;
   private float bT;
   private float bU;
   private float bV;
   private float bW;
   private float bX;
   private int bY;
   private String bZ;
   private String[] ca = new String[3];
   private boolean cb = false;

   public EntityHorse(World var1) {
      super(var1);
      this.a(1.4F, 1.6F);
      this.ab = false;
      this.p(false);
      ((class_tf)this.u()).a(true);
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_se(this, 1.2D));
      this.i.a(1, new class_sn(this, 1.2D));
      this.i.a(2, new class_re(this, 1.0D));
      this.i.a(4, new class_rl(this, 1.0D));
      this.i.a(6, new class_si(this, 0.7D));
      this.i.a(7, new class_rr(this, EntityHuman.class, 6.0F));
      this.i.a(8, new class_sh(this));
      this.dp();
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
      this.datawatcher.add(bA, Integer.valueOf(0));
      this.datawatcher.add(bB, Byte.valueOf((byte)0));
      this.datawatcher.add(bC, Integer.valueOf(0));
      this.datawatcher.add(bD, String.valueOf(""));
      this.datawatcher.add(bE, Integer.valueOf(0));
   }

   public void m(int var1) {
      this.datawatcher.update(bB, Byte.valueOf((byte)var1));
      this.dr();
   }

   public int cA() {
      return this.datawatcher.getByte(bB);
   }

   public void n(int var1) {
      this.datawatcher.update(bC, Integer.valueOf(var1));
      this.dr();
   }

   public int cB() {
      return this.datawatcher.getInt(bC);
   }

   public String getName() {
      if(this.hasCustomName()) {
         return this.aO();
      } else {
         int var1 = this.cA();
         switch(var1) {
         case 0:
         default:
            return LocaleI18n.get("entity.horse.name");
         case 1:
            return LocaleI18n.get("entity.donkey.name");
         case 2:
            return LocaleI18n.get("entity.mule.name");
         case 3:
            return LocaleI18n.get("entity.zombiehorse.name");
         case 4:
            return LocaleI18n.get("entity.skeletonhorse.name");
         }
      }
   }

   private boolean r(int var1) {
      return (this.datawatcher.getInt(bA) & var1) != 0;
   }

   private void c(int var1, boolean var2) {
      int var3 = this.datawatcher.getInt(bA);
      if(var2) {
         this.datawatcher.update(bA, Integer.valueOf(var3 | var1));
      } else {
         this.datawatcher.update(bA, Integer.valueOf(var3 & ~var1));
      }

   }

   public boolean cC() {
      return !this.j_();
   }

   public boolean cD() {
      return this.r(2);
   }

   public boolean cE() {
      return this.cC();
   }

   public String cI() {
      return this.datawatcher.getString(bD);
   }

   public void b(String var1) {
      this.datawatcher.update(bD, var1);
   }

   public float cJ() {
      return 0.5F;
   }

   public void a(boolean var1) {
      if(var1) {
         this.a(this.cJ());
      } else {
         this.a(1.0F);
      }

   }

   public boolean cK() {
      return this.bu;
   }

   public void m(boolean var1) {
      this.c(2, var1);
   }

   public void n(boolean var1) {
      this.bu = var1;
   }

   public boolean cp() {
      return !this.dg() && super.cp();
   }

   protected void o(float var1) {
      if(var1 > 6.0F && this.cN()) {
         this.s(false);
      }

   }

   public boolean cL() {
      return this.r(8);
   }

   public int cM() {
      return this.datawatcher.getInt(bE);
   }

   private int f(ItemStack var1) {
      if(var1 == null) {
         return 0;
      } else {
         Item var2 = var1.getItem();
         return var2 == Items.IRON_HORSE_ARMOR ?1:(var2 == Items.GOLDEN_HORSE_ARMOR ?2:(var2 == Items.DIAMOND_HORSE_ARMOR ?3:0));
      }
   }

   public boolean cN() {
      return this.r(32);
   }

   public boolean cO() {
      return this.r(64);
   }

   public boolean cP() {
      return this.r(16);
   }

   public boolean cQ() {
      return this.bQ;
   }

   public void e(ItemStack var1) {
      this.datawatcher.update(bE, Integer.valueOf(this.f(var1)));
      this.dr();
   }

   public void o(boolean var1) {
      this.c(16, var1);
   }

   public void p(boolean var1) {
      this.c(8, var1);
   }

   public void q(boolean var1) {
      this.bQ = var1;
   }

   public void r(boolean var1) {
      this.c(4, var1);
   }

   public int cR() {
      return this.bw;
   }

   public void o(int var1) {
      this.bw = var1;
   }

   public int p(int var1) {
      int var2 = MathHelper.clamp(this.cR() + var1, 0, this.cX());
      this.o(var2);
      return var2;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      Entity var3 = var1.j();
      return this.passenger != null && this.passenger.equals(var3)?false:super.damageEntity(var1, var2);
   }

   public int bs() {
      return bH[this.cM()];
   }

   public boolean ae() {
      return this.passenger == null;
   }

   public boolean cS() {
      int var1 = MathHelper.floor(this.s);
      int var2 = MathHelper.floor(this.u);
      this.o.b(new BlockPosition(var1, 0, var2));
      return true;
   }

   public void cT() {
      if(!this.o.isClientSide && this.cL()) {
         this.a(Item.getItemOf((Block)Blocks.CHEST), 1);
         this.p(false);
      }
   }

   private void dn() {
      this.du();
      if(!this.R()) {
         this.o.a((Entity)this, "eating", 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
      }

   }

   public void e(float var1, float var2) {
      if(var1 > 1.0F) {
         this.a("mob.horse.land", 0.4F, 1.0F);
      }

      int var3 = MathHelper.ceil((var1 * 0.5F - 3.0F) * var2);
      if(var3 > 0) {
         this.damageEntity(DamageSource.i, (float)var3);
         if(this.passenger != null) {
            this.passenger.damageEntity(DamageSource.i, (float)var3);
         }

         Block var4 = this.o.getType(new BlockPosition(this.s, this.t - 0.2D - (double)this.A, this.u)).getBlock();
         if(var4.getMaterial() != Material.AIR && !this.R()) {
            Block.Sound var5 = var4.stepSound;
            this.o.a((Entity)this, var5.getStepSound(), var5.getVolume() * 0.5F, var5.getPitch() * 0.75F);
         }

      }
   }

   private int doRENAMED() {
      int var1 = this.cA();
      return !this.cL() || var1 != 1 && var1 != 2?2:17;
   }

   private void dp() {
      class_ya var1 = this.bP;
      this.bP = new class_ya("HorseChest", this.doRENAMED());
      this.bP.a(this.getName());
      if(var1 != null) {
         var1.b(this);
         int var2 = Math.min(var1.getSize(), this.bP.getSize());

         for(int var3 = 0; var3 < var2; ++var3) {
            ItemStack var4 = var1.getItem(var3);
            if(var4 != null) {
               this.bP.setItem(var3, var4.clone());
            }
         }
      }

      this.bP.a(this);
      this.dq();
   }

   private void dq() {
      if(!this.o.isClientSide) {
         this.r(this.bP.getItem(0) != null);
         if(this.dd()) {
            this.e(this.bP.getItem(1));
         }
      }

   }

   public void a(class_ow var1) {
      int var2 = this.cM();
      boolean var3 = this.cV();
      this.dq();
      if(this.W > 20) {
         if(var2 == 0 && var2 != this.cM()) {
            this.a("mob.horse.armor", 0.5F, 1.0F);
         } else if(var2 != this.cM()) {
            this.a("mob.horse.armor", 0.5F, 1.0F);
         }

         if(!var3 && this.cV()) {
            this.a("mob.horse.leather", 0.5F, 1.0F);
         }
      }

   }

   public boolean cf() {
      this.cS();
      return super.cf();
   }

   protected EntityHorse a(Entity var1, double var2) {
      double var4 = Double.MAX_VALUE;
      Entity var6 = null;
      List var7 = this.o.a(var1, var1.aT().add(var2, var2, var2), by);
      Iterator var8 = var7.iterator();

      while(var8.hasNext()) {
         Entity var9 = (Entity)var8.next();
         double var10 = var9.e(var1.s, var1.t, var1.u);
         if(var10 < var4) {
            var6 = var9;
            var4 = var10;
         }
      }

      return (EntityHorse)var6;
   }

   public double cU() {
      return this.a((class_qk)bz).e();
   }

   protected String bq() {
      this.du();
      int var1 = this.cA();
      return var1 == 3?"mob.horse.zombie.death":(var1 == 4?"mob.horse.skeleton.death":(var1 != 1 && var1 != 2?"mob.horse.death":"mob.horse.donkey.death"));
   }

   protected Item D() {
      boolean var1 = this.random.nextInt(4) == 0;
      int var2 = this.cA();
      return var2 == 4?Items.BONE :(var2 == 3?(var1?null:Items.ROTTEN_FLESH):Items.LEATHER);
   }

   protected String bp() {
      this.du();
      if(this.random.nextInt(3) == 0) {
         this.dw();
      }

      int var1 = this.cA();
      return var1 == 3?"mob.horse.zombie.hit":(var1 == 4?"mob.horse.skeleton.hit":(var1 != 1 && var1 != 2?"mob.horse.hit":"mob.horse.donkey.hit"));
   }

   public boolean cV() {
      return this.r(4);
   }

   protected String C() {
      this.du();
      if(this.random.nextInt(10) == 0 && !this.bE()) {
         this.dw();
      }

      int var1 = this.cA();
      return var1 == 3?"mob.horse.zombie.idle":(var1 == 4?"mob.horse.skeleton.idle":(var1 != 1 && var1 != 2?"mob.horse.idle":"mob.horse.donkey.idle"));
   }

   protected String cW() {
      this.du();
      this.dw();
      int var1 = this.cA();
      return var1 != 3 && var1 != 4?(var1 != 1 && var1 != 2?"mob.horse.angry":"mob.horse.donkey.angry"):null;
   }

   protected void a(BlockPosition var1, Block var2) {
      Block.Sound var3 = var2.stepSound;
      if(this.o.getType(var1.up()).getBlock() == Blocks.SNOW_LAYER) {
         var3 = Blocks.SNOW_LAYER.stepSound;
      }

      if(!var2.getMaterial().isLiquid()) {
         int var4 = this.cA();
         if(this.passenger != null && var4 != 1 && var4 != 2) {
            ++this.bY;
            if(this.bY > 5 && this.bY % 3 == 0) {
               this.a("mob.horse.gallop", var3.getVolume() * 0.15F, var3.getPitch());
               if(var4 == 0 && this.random.nextInt(10) == 0) {
                  this.a("mob.horse.breathe", var3.getVolume() * 0.6F, var3.getPitch());
               }
            } else if(this.bY <= 5) {
               this.a("mob.horse.wood", var3.getVolume() * 0.15F, var3.getPitch());
            }
         } else if(var3 == Block.STEP_SOUND_WOOD) {
            this.a("mob.horse.wood", var3.getVolume() * 0.15F, var3.getPitch());
         } else {
            this.a("mob.horse.soft", var3.getVolume() * 0.15F, var3.getPitch());
         }
      }

   }

   protected void aY() {
      super.aY();
      this.by().b(bz);
      this.a((class_qk)class_wl.a).a(53.0D);
      this.a((class_qk)class_wl.d).a(0.22499999403953552D);
   }

   public int cj() {
      return 6;
   }

   public int cX() {
      return 100;
   }

   protected float bC() {
      return 0.8F;
   }

   public int y() {
      return 400;
   }

   private void dr() {
      this.bZ = null;
   }

   public void c(EntityHuman var1) {
      if(!this.o.isClientSide && (this.passenger == null || this.passenger == var1) && this.cD()) {
         this.bP.a(this.getName());
         var1.a((EntityHorse)this, (IInventory)this.bP);
      }

   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null && var3.getItem() == Items.SPAWN_EGG) {
         return super.a(var1, var2, var3);
      } else if(!this.cD() && this.dg()) {
         return false;
      } else if(this.cD() && this.cC() && var1.ax()) {
         this.c(var1);
         return true;
      } else if(this.cE() && this.passenger != null) {
         return super.a(var1, var2, var3);
      } else {
         if(var3 != null) {
            if(this.dd()) {
               byte var4 = -1;
               if(var3.getItem() == Items.IRON_HORSE_ARMOR) {
                  var4 = 1;
               } else if(var3.getItem() == Items.GOLDEN_HORSE_ARMOR) {
                  var4 = 2;
               } else if(var3.getItem() == Items.DIAMOND_HORSE_ARMOR) {
                  var4 = 3;
               }

               if(var4 >= 0) {
                  if(!this.cD()) {
                     this.dl();
                     return true;
                  }

                  this.c(var1);
                  return true;
               }
            }

            boolean var8 = false;
            if(!this.dg()) {
               float var5 = 0.0F;
               short var6 = 0;
               byte var7 = 0;
               if(var3.getItem() == Items.WHEAT) {
                  var5 = 2.0F;
                  var6 = 20;
                  var7 = 3;
               } else if(var3.getItem() == Items.SUGAR) {
                  var5 = 1.0F;
                  var6 = 30;
                  var7 = 3;
               } else if(Block.getByItem(var3.getItem()) == Blocks.HAY_BLOCK) {
                  var5 = 20.0F;
                  var6 = 180;
               } else if(var3.getItem() == Items.APPLE) {
                  var5 = 3.0F;
                  var6 = 60;
                  var7 = 3;
               } else if(var3.getItem() == Items.GOLDEN_CARROT) {
                  var5 = 4.0F;
                  var6 = 60;
                  var7 = 5;
                  if(this.cD() && this.getAge() == 0) {
                     var8 = true;
                     this.a((EntityHuman)var1);
                  }
               } else if(var3.getItem() == Items.GOLDEN_APPLE) {
                  var5 = 10.0F;
                  var6 = 240;
                  var7 = 10;
                  if(this.cD() && this.getAge() == 0) {
                     var8 = true;
                     this.a((EntityHuman)var1);
                  }
               }

               if(this.getHealth() < this.bv() && var5 > 0.0F) {
                  this.h(var5);
                  var8 = true;
               }

               if(!this.cC() && var6 > 0) {
                  this.a(var6);
                  var8 = true;
               }

               if(var7 > 0 && (var8 || !this.cD()) && var7 < this.cX()) {
                  var8 = true;
                  this.p(var7);
               }

               if(var8) {
                  this.dn();
               }
            }

            if(!this.cD() && !var8) {
               if(var3.a((EntityHuman)var1, (EntityLiving)this, var2)) {
                  return true;
               }

               this.dl();
               return true;
            }

            if(!var8 && this.de() && !this.cL() && var3.getItem() == Item.getItemOf((Block)Blocks.CHEST)) {
               this.p(true);
               this.a("mob.chickenplop", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
               var8 = true;
               this.dp();
            }

            if(!var8 && this.cE() && !this.cV() && var3.getItem() == Items.SADDLE) {
               this.c(var1);
               return true;
            }

            if(var8) {
               if(!var1.abilities.instabuild) {
                  --var3.count;
               }

               return true;
            }
         }

         if(this.cE() && this.passenger == null) {
            if(var3 != null && var3.a((EntityHuman)var1, (EntityLiving)this, var2)) {
               return true;
            } else {
               this.g(var1);
               return true;
            }
         } else {
            return super.a(var1, var2, var3);
         }
      }
   }

   private void g(EntityHuman var1) {
      var1.y = this.y;
      var1.z = this.z;
      this.s(false);
      this.t(false);
      if(!this.o.isClientSide) {
         var1.a((Entity)this);
      }

   }

   public boolean dd() {
      return this.cA() == 0;
   }

   public boolean de() {
      int var1 = this.cA();
      return var1 == 2 || var1 == 1;
   }

   protected boolean bE() {
      return this.passenger != null && this.cV()?true:this.cN() || this.cO();
   }

   public boolean dg() {
      int var1 = this.cA();
      return var1 == 3 || var1 == 4;
   }

   public boolean dh() {
      return this.dg() || this.cA() == 2;
   }

   public boolean d(ItemStack var1) {
      return false;
   }

   private void dt() {
      this.bs = 1;
   }

   public void a(DamageSource var1) {
      super.a((DamageSource)var1);
      if(!this.o.isClientSide) {
         this.dm();
      }

   }

   public void m() {
      if(this.random.nextInt(200) == 0) {
         this.dt();
      }

      super.m();
      if(!this.o.isClientSide) {
         if(this.random.nextInt(900) == 0 && this.deathTicks == 0) {
            this.h(1.0F);
         }

         if(!this.cN() && this.passenger == null && this.random.nextInt(300) == 0 && this.o.getType(new BlockPosition(MathHelper.floor(this.s), MathHelper.floor(this.t) - 1, MathHelper.floor(this.u))).getBlock() == Blocks.GRASS) {
            this.s(true);
         }

         if(this.cN() && ++this.bM > 50) {
            this.bM = 0;
            this.s(false);
         }

         if(this.cP() && !this.cC() && !this.cN()) {
            EntityHorse var1 = this.a(this, 16.0D);
            if(var1 != null && this.h(var1) > 4.0D) {
               this.h.a((Entity)var1);
            }
         }
      }

   }

   public void t_() {
      super.t_();
      if(this.o.isClientSide && this.datawatcher.a()) {
         this.datawatcher.e();
         this.dr();
      }

      if(this.bN > 0 && ++this.bN > 30) {
         this.bN = 0;
         this.c(128, false);
      }

      if(!this.o.isClientSide && this.bO > 0 && ++this.bO > 20) {
         this.bO = 0;
         this.t(false);
      }

      if(this.bs > 0 && ++this.bs > 8) {
         this.bs = 0;
      }

      if(this.bt > 0) {
         ++this.bt;
         if(this.bt > 300) {
            this.bt = 0;
         }
      }

      this.bT = this.bS;
      if(this.cN()) {
         this.bS += (1.0F - this.bS) * 0.4F + 0.05F;
         if(this.bS > 1.0F) {
            this.bS = 1.0F;
         }
      } else {
         this.bS += (0.0F - this.bS) * 0.4F - 0.05F;
         if(this.bS < 0.0F) {
            this.bS = 0.0F;
         }
      }

      this.bV = this.bU;
      if(this.cO()) {
         this.bT = this.bS = 0.0F;
         this.bU += (1.0F - this.bU) * 0.4F + 0.05F;
         if(this.bU > 1.0F) {
            this.bU = 1.0F;
         }
      } else {
         this.bR = false;
         this.bU += (0.8F * this.bU * this.bU * this.bU - this.bU) * 0.6F - 0.05F;
         if(this.bU < 0.0F) {
            this.bU = 0.0F;
         }
      }

      this.bX = this.bW;
      if(this.r(128)) {
         this.bW += (1.0F - this.bW) * 0.7F + 0.05F;
         if(this.bW > 1.0F) {
            this.bW = 1.0F;
         }
      } else {
         this.bW += (0.0F - this.bW) * 0.7F - 0.05F;
         if(this.bW < 0.0F) {
            this.bW = 0.0F;
         }
      }

   }

   private void du() {
      if(!this.o.isClientSide) {
         this.bN = 1;
         this.c(128, true);
      }

   }

   private boolean dv() {
      return this.passenger == null && this.vehicle == null && this.cD() && this.cC() && !this.dh() && this.getHealth() >= this.bv() && this.cG();
   }

   public void s(boolean var1) {
      this.c(32, var1);
   }

   public void t(boolean var1) {
      if(var1) {
         this.s(false);
      }

      this.c(64, var1);
   }

   private void dw() {
      if(!this.o.isClientSide) {
         this.bO = 1;
         this.t(true);
      }

   }

   public void dl() {
      this.dw();
      String var1 = this.cW();
      if(var1 != null) {
         this.a(var1, this.bC(), this.bD());
      }

   }

   public void dm() {
      this.a((Entity)this, (class_ya)this.bP);
      this.cT();
   }

   private void a(Entity var1, class_ya var2) {
      if(var2 != null && !this.o.isClientSide) {
         for(int var3 = 0; var3 < var2.getSize(); ++var3) {
            ItemStack var4 = var2.getItem(var3);
            if(var4 != null) {
               this.a(var4, 0.0F);
            }
         }

      }
   }

   public boolean f(EntityHuman var1) {
      this.b(var1.aM().toString());
      this.m(true);
      return true;
   }

   public void g(float var1, float var2) {
      if(this.passenger != null && this.passenger instanceof EntityLiving && this.cV()) {
         this.A = this.y = this.passenger.y;
         this.z = this.passenger.z * 0.5F;
         this.b(this.y, this.z);
         this.aN = this.aL = this.y;
         var1 = ((EntityLiving)this.passenger).bc * 0.5F;
         var2 = ((EntityLiving)this.passenger).bd;
         if(var2 <= 0.0F) {
            var2 *= 0.25F;
            this.bY = 0;
         }

         if(this.C && this.bx == 0.0F && this.cO() && !this.bR) {
            var1 = 0.0F;
            var2 = 0.0F;
         }

         if(this.bx > 0.0F && !this.cK() && this.C) {
            this.motY = this.cU() * (double)this.bx;
            if(this.hasEffect((MobEffectType) MobEffectList.h)) {
               this.motY += (double)((float)(this.getEffect((MobEffectType) MobEffectList.h).c() + 1) * 0.1F);
            }

            this.n(true);
            this.ai = true;
            if(var2 > 0.0F) {
               float var3 = MathHelper.sin(this.y * 3.1415927F / 180.0F);
               float var4 = MathHelper.cos(this.y * 3.1415927F / 180.0F);
               this.v += (double)(-0.4F * var3 * this.bx);
               this.x += (double)(0.4F * var4 * this.bx);
               this.a("mob.horse.jump", 0.4F, 1.0F);
            }

            this.bx = 0.0F;
         }

         this.S = 1.0F;
         this.aP = this.bJ() * 0.1F;
         if(!this.o.isClientSide) {
            this.k((float)this.a((class_qk)class_wl.d).e());
            super.g(var1, var2);
         }

         if(this.C) {
            this.bx = 0.0F;
            this.n(false);
         }

         this.aD = this.aE;
         double var8 = this.s - this.p;
         double var5 = this.u - this.r;
         float var7 = MathHelper.sqrt(var8 * var8 + var5 * var5) * 4.0F;
         if(var7 > 1.0F) {
            var7 = 1.0F;
         }

         this.aE += (var7 - this.aE) * 0.4F;
         this.aF += this.aE;
      } else {
         this.S = 0.5F;
         this.aP = 0.02F;
         super.g(var1, var2);
      }
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("EatingHaystack", this.cN());
      var1.put("ChestedHorse", this.cL());
      var1.put("HasReproduced", this.cQ());
      var1.put("Bred", this.cP());
      var1.put("Type", this.cA());
      var1.put("Variant", this.cB());
      var1.put("Temper", this.cR());
      var1.put("Tame", this.cD());
      var1.put("OwnerUUID", this.cI());
      if(this.cL()) {
         NBTTagList var2 = new NBTTagList();

         for(int var3 = 2; var3 < this.bP.getSize(); ++var3) {
            ItemStack var4 = this.bP.getItem(var3);
            if(var4 != null) {
               NBTTagCompound var5 = new NBTTagCompound();
               var5.put("Slot", (byte)var3);
               var4.write(var5);
               var2.add((NBTTag)var5);
            }
         }

         var1.put((String)"Items", (NBTTag)var2);
      }

      if(this.bP.getItem(1) != null) {
         var1.put((String)"ArmorItem", (NBTTag)this.bP.getItem(1).write(new NBTTagCompound()));
      }

      if(this.bP.getItem(0) != null) {
         var1.put((String)"SaddleItem", (NBTTag)this.bP.getItem(0).write(new NBTTagCompound()));
      }

   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.s(var1.getBoolean("EatingHaystack"));
      this.o(var1.getBoolean("Bred"));
      this.p(var1.getBoolean("ChestedHorse"));
      this.q(var1.getBoolean("HasReproduced"));
      this.m(var1.getInt("Type"));
      this.n(var1.getInt("Variant"));
      this.o(var1.getInt("Temper"));
      this.m(var1.getBoolean("Tame"));
      String var2 = "";
      if(var1.hasOfType("OwnerUUID", 8)) {
         var2 = var1.getString("OwnerUUID");
      } else {
         String var3 = var1.getString("Owner");
         var2 = class_ly.a(var3);
      }

      if(!var2.isEmpty()) {
         this.b(var2);
      }

      class_ql var8 = this.by().a("Speed");
      if(var8 != null) {
         this.a((class_qk)class_wl.d).a(var8.b() * 0.25D);
      }

      if(this.cL()) {
         NBTTagList var4 = var1.getList("Items", 10);
         this.dp();

         for(int var5 = 0; var5 < var4.getSize(); ++var5) {
            NBTTagCompound var6 = var4.getCompound(var5);
            int var7 = var6.getByte("Slot") & 255;
            if(var7 >= 2 && var7 < this.bP.getSize()) {
               this.bP.setItem(var7, ItemStack.a(var6));
            }
         }
      }

      ItemStack var9;
      if(var1.hasOfType("ArmorItem", 10)) {
         var9 = ItemStack.a(var1.getCompound("ArmorItem"));
         if(var9 != null && a(var9.getItem())) {
            this.bP.setItem(1, var9);
         }
      }

      if(var1.hasOfType("SaddleItem", 10)) {
         var9 = ItemStack.a(var1.getCompound("SaddleItem"));
         if(var9 != null && var9.getItem() == Items.SADDLE) {
            this.bP.setItem(0, var9);
         }
      } else if(var1.getBoolean("Saddle")) {
         this.bP.setItem(0, new ItemStack(Items.SADDLE));
      }

      this.dq();
   }

   public boolean a(class_tw var1) {
      if(var1 == this) {
         return false;
      } else if(var1.getClass() != this.getClass()) {
         return false;
      } else {
         EntityHorse var2 = (EntityHorse)var1;
         if(this.dv() && var2.dv()) {
            int var3 = this.cA();
            int var4 = var2.cA();
            return var3 == var4 || var3 == 0 && var4 == 1 || var3 == 1 && var4 == 0;
         } else {
            return false;
         }
      }
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      EntityHorse var2 = (EntityHorse)var1;
      EntityHorse var3 = new EntityHorse(this.o);
      int var4 = this.cA();
      int var5 = var2.cA();
      int var6 = 0;
      if(var4 == var5) {
         var6 = var4;
      } else if(var4 == 0 && var5 == 1 || var4 == 1 && var5 == 0) {
         var6 = 2;
      }

      if(var6 == 0) {
         int var8 = this.random.nextInt(9);
         int var7;
         if(var8 < 4) {
            var7 = this.cB() & 255;
         } else if(var8 < 8) {
            var7 = var2.cB() & 255;
         } else {
            var7 = this.random.nextInt(7);
         }

         int var9 = this.random.nextInt(5);
         if(var9 < 2) {
            var7 |= this.cB() & '\uff00';
         } else if(var9 < 4) {
            var7 |= var2.cB() & '\uff00';
         } else {
            var7 |= this.random.nextInt(5) << 8 & '\uff00';
         }

         var3.n(var7);
      }

      var3.m(var6);
      double var14 = this.a((class_qk)class_wl.a).b() + var1.a((class_qk)class_wl.a).b() + (double)this.dx();
      var3.a((class_qk)class_wl.a).a(var14 / 3.0D);
      double var13 = this.a((class_qk)bz).b() + var1.a((class_qk)bz).b() + this.dy();
      var3.a((class_qk)bz).a(var13 / 3.0D);
      double var11 = this.a((class_qk)class_wl.d).b() + var1.a((class_qk)class_wl.d).b() + this.dz();
      var3.a((class_qk)class_wl.d).a(var11 / 3.0D);
      return var3;
   }

   public class_qd a(class_on var1, class_qd var2) {
      Object var7 = super.a(var1, var2);
      boolean var3 = false;
      int var4 = 0;
      int var8;
      if(var7 instanceof EntityHorse.class_a_in_class_tz) {
         var8 = ((EntityHorse.class_a_in_class_tz)var7).a;
         var4 = ((EntityHorse.class_a_in_class_tz)var7).b & 255 | this.random.nextInt(5) << 8;
      } else {
         if(this.random.nextInt(10) == 0) {
            var8 = 1;
         } else {
            int var5 = this.random.nextInt(7);
            int var6 = this.random.nextInt(5);
            var8 = 0;
            var4 = var5 | var6 << 8;
         }

         var7 = new EntityHorse.class_a_in_class_tz(var8, var4);
      }

      this.m(var8);
      this.n(var4);
      if(this.random.nextInt(5) == 0) {
         this.b(-24000);
      }

      if(var8 != 4 && var8 != 3) {
         this.a((class_qk)class_wl.a).a((double)this.dx());
         if(var8 == 0) {
            this.a((class_qk)class_wl.d).a(this.dz());
         } else {
            this.a((class_qk)class_wl.d).a(0.17499999701976776D);
         }
      } else {
         this.a((class_qk)class_wl.a).a(15.0D);
         this.a((class_qk)class_wl.d).a(0.20000000298023224D);
      }

      if(var8 != 2 && var8 != 1) {
         this.a((class_qk)bz).a(this.dy());
      } else {
         this.a((class_qk)bz).a(0.5D);
      }

      this.i(this.bv());
      return (class_qd)var7;
   }

   public void q(int var1) {
      if(this.cV()) {
         if(var1 < 0) {
            var1 = 0;
         } else {
            this.bR = true;
            this.dw();
         }

         if(var1 >= 90) {
            this.bx = 1.0F;
         } else {
            this.bx = 0.4F + 0.4F * (float)var1 / 90.0F;
         }
      }

   }

   public void al() {
      super.al();
      if(this.bV > 0.0F) {
         float var1 = MathHelper.sin(this.aL * 3.1415927F / 180.0F);
         float var2 = MathHelper.cos(this.aL * 3.1415927F / 180.0F);
         float var3 = 0.7F * this.bV;
         float var4 = 0.15F * this.bV;
         this.passenger.b(this.s + (double)(var3 * var1), this.t + this.an() + this.passenger.am() + (double)var4, this.u - (double)(var3 * var2));
         if(this.passenger instanceof EntityLiving) {
            ((EntityLiving)this.passenger).aL = this.aL;
         }
      }

   }

   private float dx() {
      return 15.0F + (float)this.random.nextInt(8) + (float)this.random.nextInt(9);
   }

   private double dy() {
      return 0.4000000059604645D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D;
   }

   private double dz() {
      return (0.44999998807907104D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D) * 0.25D;
   }

   public static boolean a(Item var0) {
      return var0 == Items.IRON_HORSE_ARMOR || var0 == Items.GOLDEN_HORSE_ARMOR || var0 == Items.DIAMOND_HORSE_ARMOR;
   }

   public boolean k_() {
      return false;
   }

   public float aU() {
      return this.K;
   }

   public boolean c(int var1, ItemStack var2) {
      if(var1 == 499 && this.de()) {
         if(var2 == null && this.cL()) {
            this.p(false);
            this.dp();
            return true;
         }

         if(var2 != null && var2.getItem() == Item.getItemOf((Block)Blocks.CHEST) && !this.cL()) {
            this.p(true);
            this.dp();
            return true;
         }
      }

      int var3 = var1 - 400;
      if(var3 >= 0 && var3 < 2 && var3 < this.bP.getSize()) {
         if(var3 == 0 && var2 != null && var2.getItem() != Items.SADDLE) {
            return false;
         } else if(var3 != 1 || (var2 == null || a(var2.getItem())) && this.dd()) {
            this.bP.setItem(var3, var2);
            this.dq();
            return true;
         } else {
            return false;
         }
      } else {
         int var4 = var1 - 500 + 2;
         if(var4 >= 2 && var4 < this.bP.getSize()) {
            this.bP.setItem(var4, var2);
            return true;
         } else {
            return false;
         }
      }
   }

   public static class class_a_in_class_tz implements class_qd {
      public int a;
      public int b;

      public class_a_in_class_tz(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
