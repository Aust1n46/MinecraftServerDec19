package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_ahk;
import net.minecraft.server.class_ck;
import net.minecraft.server.class_cn;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cz;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xi;

public abstract class class_kb extends class_cn {
   public ItemStack b(class_ck var1, ItemStack var2) {
      World var3 = var1.i();
      class_cz var4 = class_ahk.a(var1);
      EnumDirection var5 = class_ahk.b(var1.f());
      class_xi var6 = this.a(var3, var4, var2);
      var6.c((double)var5.getAdjacentX(), (double)((float)var5.getAdjacentY() + 0.1F), (double)var5.getAdjacentZ(), this.b(), this.a());
      var3.a((class_pr)var6);
      var2.a(1);
      return var2;
   }

   protected void a(class_ck var1) {
      var1.i().b(1002, var1.d(), 0);
   }

   protected abstract class_xi a(World var1, class_cz var2, ItemStack var3);

   protected float a() {
      return 6.0F;
   }

   protected float b() {
      return 1.1F;
   }
}
