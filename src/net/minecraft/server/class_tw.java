package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pp;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;

public abstract class class_tw extends class_po implements class_pp {
   protected Block bv;
   private int bs;
   private EntityHuman bt;

   public class_tw(World var1) {
      super(var1);
      this.bv = Blocks.GRASS;
   }

   protected void cc() {
      if(this.l() != 0) {
         this.bs = 0;
      }

      super.cc();
   }

   public void m() {
      super.m();
      if(this.l() != 0) {
         this.bs = 0;
      }

      if(this.bs > 0) {
         --this.bs;
         if(this.bs % 10 == 0) {
            double var1 = this.V.nextGaussian() * 0.02D;
            double var3 = this.V.nextGaussian() * 0.02D;
            double var5 = this.V.nextGaussian() * 0.02D;
            this.o.a(class_cy.I, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var1, var3, var5, new int[0]);
         }
      }

   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         this.bs = 0;
         return super.a(var1, var2);
      }
   }

   public float a(BlockPosition var1) {
      return this.o.getType(var1.down()).getBlock() == Blocks.GRASS?10.0F:this.o.o(var1) - 0.5F;
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("InLove", this.bs);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.bs = var1.getInt("InLove");
   }

   public boolean cf() {
      int var1 = MathHelper.floor(this.s);
      int var2 = MathHelper.floor(this.aT().yMin);
      int var3 = MathHelper.floor(this.u);
      BlockPosition var4 = new BlockPosition(var1, var2, var3);
      return this.o.getType(var4.down()).getBlock() == this.bv && this.o.k(var4) > 8 && super.cf();
   }

   public int y() {
      return 120;
   }

   protected boolean E() {
      return false;
   }

   protected int b(EntityHuman var1) {
      return 1 + this.o.random.nextInt(3);
   }

   public boolean d(ItemStack var1) {
      return var1 == null?false:var1.getItem() == Items.Q;
   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null) {
         if(this.d(var3) && this.l() == 0 && this.bs <= 0) {
            this.a(var1, var3);
            this.a(var1);
            return true;
         }

         if(this.j_() && this.d(var3)) {
            this.a(var1, var3);
            this.a((int)((float)(-this.l() / 20) * 0.1F), true);
            return true;
         }
      }

      return super.a(var1, var2, var3);
   }

   protected void a(EntityHuman var1, ItemStack var2) {
      if(!var1.bH.instabuild) {
         --var2.count;
      }

   }

   public void a(EntityHuman var1) {
      this.bs = 600;
      this.bt = var1;
      this.o.a((Entity)this, (byte)18);
   }

   public EntityHuman cF() {
      return this.bt;
   }

   public boolean cG() {
      return this.bs > 0;
   }

   public void cH() {
      this.bs = 0;
   }

   public boolean a(class_tw var1) {
      return var1 == this?false:(var1.getClass() != this.getClass()?false:this.cG() && var1.cG());
   }
}
