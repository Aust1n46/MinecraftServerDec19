package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahi;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.CreativeTab;

public abstract class class_agp extends class_ahi {
   public static final class_anw a = class_anw.a("powered");
   private final boolean N;

   protected class_agp(boolean var1) {
      super(Material.q);
      this.setBlockData(this.blockStateList.getFirst().set(b, class_cq.c).set(a, Boolean.valueOf(false)));
      this.setTicking(true);
      this.a(CreativeTab.d);
      this.N = var1;
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public int a(World var1) {
      return this.N?30:20;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean b(World var1, class_cj var2, class_cq var3) {
      return a(var1, var2, var3.d());
   }

   public boolean d(World var1, class_cj var2) {
      class_cq[] var3 = class_cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_cq var6 = var3[var5];
         if(a(var1, var2, var6)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean a(World var0, class_cj var1, class_cq var2) {
      class_cj var3 = var1.a(var2);
      return var2 == class_cq.a?World.a((class_aer)var0, (class_cj)var3):var0.p(var3).getBlock().isOccluding();
   }

   public IBlockData a(World var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return a(var1, var2, var3.d())?this.getBlockData().set(b, var3).set(a, Boolean.valueOf(false)):this.getBlockData().set(b, class_cq.a).set(a, Boolean.valueOf(false));
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(this.e(var1, var2, var3) && !a(var1, var2, ((class_cq)var3.get(b)).d())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private boolean e(World var1, class_cj var2, IBlockData var3) {
      if(this.d(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public void a(class_aer var1, class_cj var2) {
      this.d(var1.p(var2));
   }

   private void d(IBlockData var1) {
      class_cq var2 = (class_cq)var1.get(b);
      boolean var3 = ((Boolean)var1.get(a)).booleanValue();
      float var4 = 0.25F;
      float var5 = 0.375F;
      float var6 = (float)(var3?1:2) / 16.0F;
      float var7 = 0.125F;
      float var8 = 0.1875F;
      switch(class_agp.SyntheticClass_1.a[var2.ordinal()]) {
      case 1:
         this.setSizes(0.0F, 0.375F, 0.3125F, var6, 0.625F, 0.6875F);
         break;
      case 2:
         this.setSizes(1.0F - var6, 0.375F, 0.3125F, 1.0F, 0.625F, 0.6875F);
         break;
      case 3:
         this.setSizes(0.3125F, 0.375F, 0.0F, 0.6875F, 0.625F, var6);
         break;
      case 4:
         this.setSizes(0.3125F, 0.375F, 1.0F - var6, 0.6875F, 0.625F, 1.0F);
         break;
      case 5:
         this.setSizes(0.3125F, 0.0F, 0.375F, 0.6875F, 0.0F + var6, 0.625F);
         break;
      case 6:
         this.setSizes(0.3125F, 1.0F - var6, 0.375F, 0.6875F, 1.0F, 0.625F);
      }

   }

   public boolean a(World var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         return true;
      } else {
         var1.a((class_cj)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 3);
         var1.b(var2, var2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
         this.c(var1, var2, (class_cq)var3.get(b));
         var1.a((class_cj)var2, (Block)this, this.a(var1));
         return true;
      }
   }

   public void b(World var1, class_cj var2, IBlockData var3) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         this.c(var1, var2, (class_cq)var3.get(b));
      }

      super.b(var1, var2, var3);
   }

   public int a(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return ((Boolean)var3.get(a)).booleanValue()?15:0;
   }

   public int b(class_aer var1, class_cj var2, IBlockData var3, class_cq var4) {
      return !((Boolean)var3.get(a)).booleanValue()?0:(var3.get(b) == var4?15:0);
   }

   public boolean isPowerSource() {
      return true;
   }

   public void a(World var1, class_cj var2, IBlockData var3, Random var4) {
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         if(((Boolean)var3.get(a)).booleanValue()) {
            if(this.N) {
               this.f(var1, var2, var3);
            } else {
               var1.a(var2, var3.set(a, Boolean.valueOf(false)));
               this.c(var1, var2, (class_cq)var3.get(b));
               var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
               var1.b(var2, var2);
            }

         }
      }
   }

   public void j() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.setSizes(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_pr var4) {
      if(!var1.D) {
         if(this.N) {
            if(!((Boolean)var3.get(a)).booleanValue()) {
               this.f(var1, var2, var3);
            }
         }
      }
   }

   private void f(World var1, class_cj var2, IBlockData var3) {
      this.d(var3);
      List var4 = var1.a(class_xd.class, new class_awf((double)var2.n() + this.minX, (double)var2.o() + this.minY, (double)var2.p() + this.minZ, (double)var2.n() + this.maxX, (double)var2.o() + this.maxY, (double)var2.p() + this.maxZ));
      boolean var5 = !var4.isEmpty();
      boolean var6 = ((Boolean)var3.get(a)).booleanValue();
      if(var5 && !var6) {
         var1.a(var2, var3.set(a, Boolean.valueOf(true)));
         this.c(var1, var2, (class_cq)var3.get(b));
         var1.b(var2, var2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(!var5 && var6) {
         var1.a(var2, var3.set(a, Boolean.valueOf(false)));
         this.c(var1, var2, (class_cq)var3.get(b));
         var1.b(var2, var2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
      }

      if(var5) {
         var1.a((class_cj)var2, (Block)this, this.a(var1));
      }

   }

   private void c(World var1, class_cj var2, class_cq var3) {
      var1.c((class_cj)var2, (Block)this);
      var1.c((class_cj)var2.a(var3.d()), (Block)this);
   }

   public IBlockData fromLegacyData(int var1) {
      class_cq var2;
      switch(var1 & 7) {
      case 0:
         var2 = class_cq.a;
         break;
      case 1:
         var2 = class_cq.f;
         break;
      case 2:
         var2 = class_cq.e;
         break;
      case 3:
         var2 = class_cq.d;
         break;
      case 4:
         var2 = class_cq.c;
         break;
      case 5:
      default:
         var2 = class_cq.b;
      }

      return this.getBlockData().set(b, var2).set(a, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2;
      switch(class_agp.SyntheticClass_1.a[((class_cq)var1.get(b)).ordinal()]) {
      case 1:
         var2 = 1;
         break;
      case 2:
         var2 = 2;
         break;
      case 3:
         var2 = 3;
         break;
      case 4:
         var2 = 4;
         break;
      case 5:
      default:
         var2 = 5;
         break;
      case 6:
         var2 = 0;
      }

      if(((Boolean)var1.get(a)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.a((class_cq)var1.get(b)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(b)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.f.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_cq.d.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.b.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.a.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}