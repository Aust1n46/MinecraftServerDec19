package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_an extends class_i {
   public String c() {
      return "banlist";
   }

   public int a() {
      return 3;
   }

   public boolean a(class_m var1) {
      return (MinecraftServer.N().getPlayerList().i().b() || MinecraftServer.N().getPlayerList().h().b()) && super.a(var1);
   }

   public String c(class_m var1) {
      return "commands.banlist.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
         var1.a(new ChatMessage("commands.banlist.ips", new Object[]{Integer.valueOf(MinecraftServer.N().getPlayerList().i().a().length)}));
         var1.a(new ChatComponentText(a(MinecraftServer.N().getPlayerList().i().a())));
      } else {
         var1.a(new ChatMessage("commands.banlist.players", new Object[]{Integer.valueOf(MinecraftServer.N().getPlayerList().h().a().length)}));
         var1.a(new ChatComponentText(a(MinecraftServer.N().getPlayerList().h().a())));
      }

   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, new String[]{"players", "ips"}):null;
   }
}
