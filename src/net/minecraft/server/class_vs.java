package net.minecraft.server;

import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ams;
import net.minecraft.server.class_amt;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_oj;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_vq;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yn;

public class class_vs extends class_vq implements class_ams {
   private boolean a = true;
   private int b = -1;
   private BlockPosition c;

   public class_vs(World var1) {
      super(var1);
      this.c = BlockPosition.ZERO;
   }

   public class_vs(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.c = BlockPosition.ZERO;
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.f;
   }

   public IBlockData u() {
      return Blocks.HOPPER.getBlockData();
   }

   public int w() {
      return 1;
   }

   public int o_() {
      return 5;
   }

   public boolean a(class_xa var1, ItemStack var2, EnumUsedHand var3) {
      if(!this.o.D) {
         var1.a((class_oj)this);
      }

      return true;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      boolean var5 = !var4;
      if(var5 != this.y()) {
         this.i(var5);
      }

   }

   public boolean y() {
      return this.a;
   }

   public void i(boolean var1) {
      this.a = var1;
   }

   public World z() {
      return this.o;
   }

   public double A() {
      return this.s;
   }

   public double B() {
      return this.t + 0.5D;
   }

   public double C() {
      return this.u;
   }

   public void t_() {
      super.t_();
      if(!this.o.D && this.ai() && this.y()) {
         BlockPosition var1 = new BlockPosition(this);
         if(var1.equals(this.c)) {
            --this.b;
         } else {
            this.m(0);
         }

         if(!this.E()) {
            this.m(0);
            if(this.D()) {
               this.m(4);
               this.p_();
            }
         }
      }

   }

   public boolean D() {
      if(class_amt.a((class_ams)this)) {
         return true;
      } else {
         List var1 = this.o.a(class_vm.class, this.aT().b(0.25D, 0.0D, 0.25D), class_pv.a);
         if(!var1.isEmpty()) {
            class_amt.a((class_oj)this, (class_vm)((class_vm)var1.get(0)));
         }

         return false;
      }
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(this.o.R().b("doEntityDrops")) {
         this.a(Item.getByBlock((Block)Blocks.HOPPER), 1, 0.0F);
      }

   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("TransferCooldown", this.b);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      this.b = var1.getInt("TransferCooldown");
   }

   public void m(int var1) {
      this.b = var1;
   }

   public boolean E() {
      return this.b > 0;
   }

   public String k() {
      return "minecraft:hopper";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yn(var1, this, var2);
   }
}
