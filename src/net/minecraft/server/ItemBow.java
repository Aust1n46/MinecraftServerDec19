package net.minecraft.server;

public class ItemBow extends Item {
   public ItemBow() {
      this.h = 1;
      this.e(384);
      this.registerItemKey(CreativeTab.COMBAT);
      this.registerItemKey(new MinecraftKey("pull"), new class_aat() {
      });
      this.registerItemKey(new MinecraftKey("pulling"), new class_aat() {
      });
   }

   private int a(PlayerInventory var1) {
      if(this.g_(var1.getItem(40))) {
         return 40;
      } else {
         for(int var2 = 0; var2 < var1.getSize(); ++var2) {
            ItemStack var3 = var1.getItem(var2);
            if(this.g_(var3)) {
               return var2;
            }
         }

         return -1;
      }
   }

   protected boolean g_(ItemStack var1) {
      return var1 != null && var1.getItem() instanceof ItemArrow;
   }

   public void registerItemKey(ItemStack var1, World var2, EntityLiving var3, int var4) {
      if(var3 instanceof EntityHuman) {
         EntityHuman var5 = (EntityHuman)var3;
         boolean var6 = var5.abilities.instabuild || EnchantmentManager.getLevel(Enchantment.w, var1) > 0;
         int var7 = this.a(var5.inventory);
         if(var6 || var7 > -1) {
            ItemStack var8 = var7 > -1?var5.inventory.getItem(var7):null;
            if(var8 == null) {
               var8 = new ItemStack(Items.ARROW);
            }

            ItemArrow var9 = (ItemArrow)((ItemArrow)(var8.getItem() instanceof ItemArrow ?var8.getItem():Items.ARROW));
            int var10 = this.e(var1) - var4;
            float var11 = b(var10);
            if((double)var11 >= 0.1D) {
               EntityArrow var12 = var9.a(var2, var8, var5);
               var12.a(var5.z, var5.y, 0.0F, var11 * 3.0F, 1.0F);
               if(var11 == 1.0F) {
                  var12.a(true);
               }

               int var13 = EnchantmentManager.getLevel(Enchantment.t, var1);
               if(var13 > 0) {
                  var12.b(var12.l() + (double)var13 * 0.5D + 0.5D);
               }

               int var14 = EnchantmentManager.getLevel(Enchantment.u, var1);
               if(var14 > 0) {
                  var12.a(var14);
               }

               if(EnchantmentManager.getLevel(Enchantment.v, var1) > 0) {
                  var12.f(100);
               }

               var1.a(1, (EntityLiving)var5);
               var2.a((Entity)var5, "random.bow", 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + var11 * 0.5F);
               if(var6) {
                  var12.c = 2;
               } else {
                  var5.inventory.splitStack(var7, 1);
               }

               var5.b(StatisticList.ad[Item.getId((Item)this)]);
               if(!var2.isClientSide) {
                  var2.addEntity((Entity)var12);
               }

            }
         }
      }
   }

   public static float b(int var0) {
      float var1 = (float)var0 / 20.0F;
      var1 = (var1 * var1 + var1 * 2.0F) / 3.0F;
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return var1;
   }

   public int e(ItemStack var1) {
      return 72000;
   }

   public class_abz f(ItemStack var1) {
      return class_abz.BOW;
   }

   public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if((var3.abilities.instabuild || this.a(var3.inventory) > -1) && var4 == EnumUsedHand.MAIN_HAND) {
         var3.c(var4);
         return new class_or(UseResult.SUCCESS, var1);
      } else {
         return new class_or(UseResult.CANT_USE, var1);
      }
   }

   public int c() {
      return 1;
   }
}
