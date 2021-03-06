package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.Entity;

public class class_bq extends class_i {
   public String c() {
      return "testfor";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.testfor.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 1) {
         throw new class_cf("commands.testfor.usage", new Object[0]);
      } else {
         Entity var3 = b(var1, var2[0]);
         NBTTagCompound var4 = null;
         if(var2.length >= 2) {
            try {
               var4 = class_ed.a(a(var2, 1));
            } catch (class_ec var6) {
               throw new class_bz("commands.testfor.tagError", new Object[]{var6.getMessage()});
            }
         }

         if(var4 != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var3.e(var5);
            if(!class_dy.a(var4, var5, true)) {
               throw new class_bz("commands.testfor.failure", new Object[]{var3.getName()});
            }
         }

         a(var1, this, "commands.testfor.success", new Object[]{var3.getName()});
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().K()):null;
   }
}
