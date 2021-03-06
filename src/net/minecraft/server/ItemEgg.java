package net.minecraft.server;

public class ItemEgg extends Item {
   public ItemEgg() {
      this.h = 16;
      this.registerItemKey(CreativeTab.MATERIALS);
   }

   public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(!var3.abilities.instabuild) {
         --var1.count;
      }

      var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      if(!var2.isClientSide) {
         EntityEgg var5 = new EntityEgg(var2, var3);
         var5.a(var3.z, var3.y, 0.0F, 1.5F, 1.0F);
         var2.addEntity((Entity)var5);
      }

      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new class_or(UseResult.SUCCESS, var1);
   }
}
