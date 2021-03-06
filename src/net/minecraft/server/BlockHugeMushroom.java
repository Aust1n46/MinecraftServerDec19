package net.minecraft.server;

import java.util.Random;

public class BlockHugeMushroom extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("variant", BlockHugeMushroom.class_a_in_class_aiw.class);
   private final Block b;

   public BlockHugeMushroom(Material var1, MaterialMapColor var2, Block var3) {
      super(var1, var2);
      this.setBlockData(this.blockStateList.getFirst().set(a, BlockHugeMushroom.class_a_in_class_aiw.l));
      this.b = var3;
   }

   public int getDropCount(Random var1) {
      return Math.max(0, var1.nextInt(10) - 7);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      switch(BlockHugeMushroom.SyntheticClass_1.a[((BlockHugeMushroom.class_a_in_class_aiw)var1.get(a)).ordinal()]) {
      case 1:
         return MaterialMapColor.COLOR4;
      case 2:
         return MaterialMapColor.COLOR3;
      case 3:
         return MaterialMapColor.COLOR3;
      default:
         return super.getMapColor(var1);
      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf(this.b);
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, BlockHugeMushroom.class_a_in_class_aiw.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((BlockHugeMushroom.class_a_in_class_aiw)var1.get(a)).a();
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(BlockHugeMushroom.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            switch(BlockHugeMushroom.SyntheticClass_1.a[((BlockHugeMushroom.class_a_in_class_aiw)var1.get(a)).ordinal()]) {
            case 3:
               break;
            case 4:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.i);
            case 5:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.h);
            case 6:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.g);
            case 7:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.f);
            case 8:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.d);
            case 9:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.c);
            case 10:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.b);
            case 11:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.a);
            default:
               return var1;
            }
         case 2:
            switch(BlockHugeMushroom.SyntheticClass_1.a[((BlockHugeMushroom.class_a_in_class_aiw)var1.get(a)).ordinal()]) {
            case 3:
               break;
            case 4:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.g);
            case 5:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.d);
            case 6:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.a);
            case 7:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.h);
            case 8:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.b);
            case 9:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.i);
            case 10:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.f);
            case 11:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.c);
            default:
               return var1;
            }
         case 3:
            switch(BlockHugeMushroom.SyntheticClass_1.a[((BlockHugeMushroom.class_a_in_class_aiw)var1.get(a)).ordinal()]) {
            case 3:
               break;
            case 4:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.c);
            case 5:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.f);
            case 6:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.i);
            case 7:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.b);
            case 8:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.h);
            case 9:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.a);
            case 10:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.d);
            case 11:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.g);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         BlockHugeMushroom.class_a_in_class_aiw var3 = (BlockHugeMushroom.class_a_in_class_aiw)var1.get(a);
         switch(BlockHugeMushroom.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(BlockHugeMushroom.SyntheticClass_1.a[var3.ordinal()]) {
            case 4:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.g);
            case 5:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.h);
            case 6:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.i);
            case 7:
            case 8:
            default:
               return super.a(var1, var2);
            case 9:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.a);
            case 10:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.b);
            case 11:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.c);
            }
         case 2:
            switch(BlockHugeMushroom.SyntheticClass_1.a[var3.ordinal()]) {
            case 4:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.c);
            case 5:
            case 10:
            default:
               break;
            case 6:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.a);
            case 7:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.f);
            case 8:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.d);
            case 9:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.i);
            case 11:
               return var1.set(a, BlockHugeMushroom.class_a_in_class_aiw.g);
            }
         }

         return super.a(var1, var2);
      }
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            c[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            c[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
            ;
         }

         b = new int[Block.EnumRotation.values().length];

         try {
            b[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            b[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
            ;
         }

         a = new int[BlockHugeMushroom.class_a_in_class_aiw.values().length];

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.m.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.k.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.j.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.a.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.b.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.c.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.d.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.f.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.g.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.h.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[BlockHugeMushroom.class_a_in_class_aiw.i.ordinal()] = 11;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_aiw implements INamable {
      a(1, "north_west"),
      b(2, "north"),
      c(3, "north_east"),
      d(4, "west"),
      e(5, "center"),
      f(6, "east"),
      g(7, "south_west"),
      h(8, "south"),
      i(9, "south_east"),
      j(10, "stem"),
      k(0, "all_inside"),
      l(14, "all_outside"),
      m(15, "all_stem");

      private static final BlockHugeMushroom.class_a_in_class_aiw[] n;
      private final int o;
      private final String p;

      private class_a_in_class_aiw(int var3, String var4) {
         this.o = var3;
         this.p = var4;
      }

      public int a() {
         return this.o;
      }

      public String toString() {
         return this.p;
      }

      public static BlockHugeMushroom.class_a_in_class_aiw a(int var0) {
         if(var0 < 0 || var0 >= n.length) {
            var0 = 0;
         }

         BlockHugeMushroom.class_a_in_class_aiw var1 = n[var0];
         return var1 == null?n[0]:var1;
      }

      public String getName() {
         return this.p;
      }

      static {
         n = new BlockHugeMushroom.class_a_in_class_aiw[16];
         BlockHugeMushroom.class_a_in_class_aiw[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockHugeMushroom.class_a_in_class_aiw var3 = var0[var2];
            n[var3.a()] = var3;
         }

      }
   }
}
