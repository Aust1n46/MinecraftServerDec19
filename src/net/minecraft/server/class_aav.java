package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahz;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_vb;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_aav extends Item {
   public class_aav() {
      this.a(CreativeTab.TOOLS);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      Block var10 = var3.getType(var4).getBlock();
      if(var10 instanceof class_ahz) {
         if(var3.isClientSide) {
            return class_oq.a;
         } else {
            a(var2, var3, var4);
            return class_oq.a;
         }
      } else {
         return class_oq.b;
      }
   }

   public static boolean a(EntityHuman var0, World var1, BlockPosition var2) {
      class_vb var3 = class_vb.b(var1, var2);
      boolean var4 = false;
      double var5 = 7.0D;
      int var7 = var2.getX();
      int var8 = var2.getY();
      int var9 = var2.getZ();
      List var10 = var1.getEntities(class_qb.class, new AxisAlignedBB((double)var7 - var5, (double)var8 - var5, (double)var9 - var5, (double)var7 + var5, (double)var8 + var5, (double)var9 + var5));
      Iterator var11 = var10.iterator();

      while(var11.hasNext()) {
         class_qb var12 = (class_qb)var11.next();
         if(var12.cq() && var12.cr() == var0) {
            if(var3 == null) {
               var3 = class_vb.a(var1, var2);
            }

            var12.a(var3, true);
            var4 = true;
         }
      }

      return var4;
   }
}
