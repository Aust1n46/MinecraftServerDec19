package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ajd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zn extends Item {
   private Block a;

   public class_zn(Block var1) {
      this.h = 1;
      this.a = var1;
      this.a(CreativeTab.f);
   }

   public class_or a(class_aas var1, World var2, class_xa var3, class_oo var4) {
      boolean var5 = this.a == Blocks.AIR;
      class_awg var6 = this.a(var2, var3, var5);
      if(var6 == null) {
         return new class_or(class_oq.b, var1);
      } else {
         if(var6.a == class_awg.class_a_in_class_awg.b) {
            class_cj var7 = var6.a();
            if(!var2.a(var3, var7)) {
               return new class_or(class_oq.b, var1);
            }

            if(!var5) {
               if(this.a == Blocks.AIR) {
                  return new class_or(class_oq.a, new class_aas(Items.ay));
               }

               class_cj var10 = var7.a(var6.b);
               if(!var3.a(var10, var6.b, var1)) {
                  return new class_or(class_oq.b, var1);
               }

               if(this.a(var2, var10) && !var3.bH.d) {
                  var3.b(class_nc.ad[Item.getId((Item)this)]);
                  return new class_or(class_oq.a, new class_aas(Items.ay));
               }

               return new class_or(class_oq.a, var1);
            }

            if(!var3.a(var7.a(var6.b), var6.b, var1)) {
               return new class_or(class_oq.b, var1);
            }

            IBlockData var8 = var2.p(var7);
            Material var9 = var8.getBlock().getMaterial();
            if(var9 == Material.h && ((Integer)var8.get(class_ajd.b)).intValue() == 0) {
               var2.g(var7);
               var3.b(class_nc.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, this.a(var1, var3, Items.az));
            }

            if(var9 == Material.i && ((Integer)var8.get(class_ajd.b)).intValue() == 0) {
               var2.g(var7);
               var3.b(class_nc.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, this.a(var1, var3, Items.aA));
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }

   private class_aas a(class_aas var1, class_xa var2, Item var3) {
      if(var2.bH.d) {
         return var1;
      } else if(--var1.b <= 0) {
         return new class_aas(var3);
      } else {
         if(!var2.bp.a(new class_aas(var3))) {
            var2.a(new class_aas(var3), false);
         }

         return var1;
      }
   }

   public boolean a(World var1, class_cj var2) {
      if(this.a == Blocks.AIR) {
         return false;
      } else {
         Material var3 = var1.p(var2).getBlock().getMaterial();
         boolean var4 = !var3.a();
         if(!var1.d(var2) && !var4) {
            return false;
         } else {
            if(var1.t.l() && this.a == Blocks.FLOWING_WATER) {
               int var5 = var2.n();
               int var6 = var2.o();
               int var7 = var2.p();
               var1.a((double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 8; ++var8) {
                  var1.a(class_cy.m, (double)var5 + Math.random(), (double)var6 + Math.random(), (double)var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
               }
            } else {
               if(!var1.D && var4 && !var3.d()) {
                  var1.b(var2, true);
               }

               var1.a((class_cj)var2, (IBlockData)this.a.getBlockData(), 3);
            }

            return true;
         }
      }
   }
}