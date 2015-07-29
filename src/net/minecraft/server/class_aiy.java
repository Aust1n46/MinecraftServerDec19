package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aiy extends class_agd {
   public static final class_anw a = class_anw.a("has_record");

   protected class_aiy() {
      super(Material.d, MaterialMapColor.l);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
      this.a(CreativeTab.c);
   }

   public boolean a(World var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         this.e(var1, var2, var3);
         var3 = var3.set(a, Boolean.valueOf(false));
         var1.a((class_cj)var2, (IBlockData)var3, 2);
         return true;
      } else {
         return false;
      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_aas var4) {
      if(!var1.D) {
         class_amg var5 = var1.s(var2);
         if(var5 instanceof class_aiy.class_a_in_class_aiy) {
            ((class_aiy.class_a_in_class_aiy)var5).a(new class_aas(var4.b(), 1, var4.i()));
            var1.a((class_cj)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 2);
         }
      }
   }

   private void e(World var1, class_cj var2, IBlockData var3) {
      if(!var1.D) {
         class_amg var4 = var1.s(var2);
         if(var4 instanceof class_aiy.class_a_in_class_aiy) {
            class_aiy.class_a_in_class_aiy var5 = (class_aiy.class_a_in_class_aiy)var4;
            class_aas var6 = var5.a();
            if(var6 != null) {
               var1.b(1005, var2, 0);
               var1.a((class_cj)var2, (String)null);
               var5.a((class_aas)null);
               float var7 = 0.7F;
               double var8 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               double var10 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
               double var12 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               class_aas var14 = var6.k();
               class_vm var15 = new class_vm(var1, (double)var2.n() + var8, (double)var2.o() + var10, (double)var2.p() + var12, var14);
               var15.p();
               var1.a((class_pr)var15);
            }
         }
      }
   }

   public void b(World var1, class_cj var2, IBlockData var3) {
      this.e(var1, var2, var3);
      super.b(var1, var2, var3);
   }

   public void a(World var1, class_cj var2, IBlockData var3, float var4, int var5) {
      if(!var1.D) {
         super.a(var1, var2, var3, var4, 0);
      }
   }

   public class_amg a(World var1, int var2) {
      return new class_aiy.class_a_in_class_aiy();
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, class_cj var2) {
      class_amg var3 = var1.s(var2);
      if(var3 instanceof class_aiy.class_a_in_class_aiy) {
         class_aas var4 = ((class_aiy.class_a_in_class_aiy)var3).a();
         if(var4 != null) {
            return Item.getId(var4.b()) + 1 - Item.getId(Items.ct);
         }
      }

      return 0;
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf(var1 > 0));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?1:0;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public static class class_a_in_class_aiy extends class_amg {
      private class_aas a;

      public void a(class_dn var1) {
         super.a(var1);
         if(var1.b("RecordItem", 10)) {
            this.a(class_aas.a(var1.n("RecordItem")));
         } else if(var1.g("Record") > 0) {
            this.a(new class_aas(Item.getById(var1.g("Record"))));
         }

      }

      public void b(class_dn var1) {
         super.b(var1);
         if(this.a() != null) {
            var1.a((String)"RecordItem", (class_eb)this.a().b(new class_dn()));
         }

      }

      public class_aas a() {
         return this.a;
      }

      public void a(class_aas var1) {
         this.a = var1;
         this.p_();
      }
   }
}