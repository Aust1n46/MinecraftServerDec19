package net.minecraft.server;

import java.util.Calendar;

public class EntityBat extends class_tt {
   private static final int a = Datawathcer.claimId(EntityBat.class);
   private BlockPosition b;

   public EntityBat(World var1) {
      super(var1);
      this.a(0.5F, 0.9F);
      this.a(true);
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
      this.datawatcher.add(a, new Byte((byte)0));
   }

   protected float bC() {
      return 0.1F;
   }

   protected float bD() {
      return super.bD() * 0.95F;
   }

   protected String C() {
      return this.n() && this.random.nextInt(4) != 0?null:"mob.bat.idle";
   }

   protected String bp() {
      return "mob.bat.hurt";
   }

   protected String bq() {
      return "mob.bat.death";
   }

   public boolean ae() {
      return false;
   }

   protected void s(Entity var1) {
   }

   protected void bM() {
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(6.0D);
   }

   public boolean n() {
      return (this.datawatcher.getByte(a) & 1) != 0;
   }

   public void a(boolean var1) {
      byte var2 = this.datawatcher.getByte(a);
      if(var1) {
         this.datawatcher.update(a, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.datawatcher.update(a, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public void t_() {
      super.t_();
      if(this.n()) {
         this.v = this.motY = this.x = 0.0D;
         this.t = (double)MathHelper.floor(this.t) + 1.0D - (double)this.K;
      } else {
         this.motY *= 0.6000000238418579D;
      }

   }

   protected void cc() {
      super.cc();
      BlockPosition var1 = new BlockPosition(this);
      BlockPosition var2 = var1.up();
      if(this.n()) {
         if(!this.o.getType(var2).getBlock().isOccluding()) {
            this.a(false);
            this.o.a((EntityHuman)null, 1015, var1, 0);
         } else {
            if(this.random.nextInt(200) == 0) {
               this.aN = (float)this.random.nextInt(360);
            }

            if(this.o.a(this, 4.0D) != null) {
               this.a(false);
               this.o.a((EntityHuman)null, 1015, var1, 0);
            }
         }
      } else {
         if(this.b != null && (!this.o.isEmpty(this.b) || this.b.getY() < 1)) {
            this.b = null;
         }

         if(this.b == null || this.random.nextInt(30) == 0 || this.b.distanceSquared((double)((int)this.s), (double)((int)this.t), (double)((int)this.u)) < 4.0D) {
            this.b = new BlockPosition((int)this.s + this.random.nextInt(7) - this.random.nextInt(7), (int)this.t + this.random.nextInt(6) - 2, (int)this.u + this.random.nextInt(7) - this.random.nextInt(7));
         }

         double var3 = (double)this.b.getX() + 0.5D - this.s;
         double var5 = (double)this.b.getY() + 0.1D - this.t;
         double var7 = (double)this.b.getZ() + 0.5D - this.u;
         this.v += (Math.signum(var3) * 0.5D - this.v) * 0.10000000149011612D;
         this.motY += (Math.signum(var5) * 0.699999988079071D - this.motY) * 0.10000000149011612D;
         this.x += (Math.signum(var7) * 0.5D - this.x) * 0.10000000149011612D;
         float var9 = (float)(MathHelper.b(this.x, this.v) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var10 = MathHelper.clampAngle(var9 - this.y);
         this.bd = 0.5F;
         this.y += var10;
         if(this.random.nextInt(100) == 0 && this.o.getType(var2).getBlock().isOccluding()) {
            this.a(true);
         }
      }

   }

   protected boolean s_() {
      return false;
   }

   public void e(float var1, float var2) {
   }

   protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
   }

   public boolean aK() {
      return true;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         if(!this.o.isClientSide && this.n()) {
            this.a(false);
         }

         return super.damageEntity(var1, var2);
      }
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.datawatcher.update(a, Byte.valueOf(var1.getByte("BatFlags")));
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("BatFlags", this.datawatcher.getByte(a));
   }

   public boolean cf() {
      BlockPosition var1 = new BlockPosition(this.s, this.aT().yMin, this.u);
      if(var1.getY() >= this.o.G()) {
         return false;
      } else {
         int var2 = this.o.l(var1);
         byte var3 = 4;
         if(this.a(this.o.Z())) {
            var3 = 7;
         } else if(this.random.nextBoolean()) {
            return false;
         }

         return var2 > this.random.nextInt(var3)?false:super.cf();
      }
   }

   private boolean a(Calendar var1) {
      return var1.get(2) + 1 == 10 && var1.get(5) >= 20 || var1.get(2) + 1 == 11 && var1.get(5) <= 3;
   }

   public float aU() {
      return this.K / 2.0F;
   }
}
