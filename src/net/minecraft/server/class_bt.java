package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_bt extends class_i {
   public String c() {
      return "toggledownfall";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.downfall.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      this.d();
      a(var1, this, "commands.downfall.success", new Object[0]);
   }

   protected void d() {
      class_avn var1 = MinecraftServer.N().d[0].Q();
      var1.b(!var1.p());
   }
}
