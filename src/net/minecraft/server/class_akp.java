package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_qa;

public class class_akp extends Block {
   public static final BlockStateEnum N = BlockStateEnum.of("axis", EnumDirection.EnumAxis.class);

   protected class_akp(Material var1) {
      super(var1, var1.getMapColor());
   }

   protected class_akp(Material var1, MaterialMapColor var2) {
      super(var1, var2);
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_akp.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_akp.SyntheticClass_1.a[((EnumDirection.EnumAxis)var1.get(N)).ordinal()]) {
            case 1:
               return var1.set(N, EnumDirection.EnumAxis.Z);
            case 2:
               return var1.set(N, EnumDirection.EnumAxis.X);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection.EnumAxis var2 = EnumDirection.EnumAxis.Y;
      int var3 = var1 & 12;
      if(var3 == 4) {
         var2 = EnumDirection.EnumAxis.X;
      } else if(var3 == 8) {
         var2 = EnumDirection.EnumAxis.Z;
      }

      return this.getBlockData().set(N, var2);
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      EnumDirection.EnumAxis var3 = (EnumDirection.EnumAxis)var1.get(N);
      if(var3 == EnumDirection.EnumAxis.X) {
         var2 |= 4;
      } else if(var3 == EnumDirection.EnumAxis.Z) {
         var2 |= 8;
      }

      return var2;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{N});
   }

   protected ItemStack i(IBlockData var1) {
      return new ItemStack(Item.getByBlock((Block)this));
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).set(N, var3.getAxis());
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_c_in_class_agj.values().length];

      static {
         try {
            b[Block.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[EnumDirection.EnumAxis.values().length];

         try {
            a[EnumDirection.EnumAxis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EnumAxis.Z.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
