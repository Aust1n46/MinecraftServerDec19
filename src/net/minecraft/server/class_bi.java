package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.World;
import net.minecraft.server.class_bz;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.EntityHuman;

public class class_bi extends class_i {
   public boolean a(class_m var1) {
      return MinecraftServer.N().isLocal() || super.a(var1);
   }

   public String c() {
      return "seed";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.seed.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      Object var3 = var1 instanceof EntityHuman?((EntityHuman)var1).o:MinecraftServer.N().getWorldServer(0);
      var1.a(new ChatMessage("commands.seed.success", new Object[]{Long.valueOf(((World)var3).K())}));
   }
}
