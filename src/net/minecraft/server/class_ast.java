package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_asv;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTCompressedStreamTools;
import net.minecraft.server.MinecraftKey;
import org.apache.commons.io.IOUtils;

public class class_ast {
   private final Map a = Maps.newHashMap();

   public class_asv a(MinecraftKey var1) {
      String var2 = var1.getName();
      if(this.a.containsKey(var2)) {
         return (class_asv)this.a.get(var2);
      } else {
         this.b(var1);
         if(this.a.containsKey(var2)) {
            return (class_asv)this.a.get(var2);
         } else {
            class_asv var3 = new class_asv();
            this.a.put(var2, var3);
            return var3;
         }
      }
   }

   public boolean b(MinecraftKey var1) {
      String var2 = var1.getName();
      File var3 = MinecraftServer.N().d("structures");
      File var4 = new File(var3, var2 + ".nbt");
      if(!var4.exists()) {
         return this.d(var1);
      } else {
         FileInputStream var5 = null;

         boolean var7;
         try {
            var5 = new FileInputStream(var4);
            this.a(var2, var5);
            return true;
         } catch (Throwable var11) {
            var7 = false;
         } finally {
            IOUtils.closeQuietly((InputStream)var5);
         }

         return var7;
      }
   }

   private boolean d(MinecraftKey var1) {
      String var2 = var1.getNamespace();
      String var3 = var1.getName();
      InputStream var4 = null;

      boolean var6;
      try {
         var4 = MinecraftServer.class.getResourceAsStream("/assets/" + var2 + "/structures/" + var3 + ".nbt");
         this.a(var3, var4);
         return true;
      } catch (Throwable var10) {
         var6 = false;
      } finally {
         IOUtils.closeQuietly(var4);
      }

      return var6;
   }

   private void a(String var1, InputStream var2) throws IOException {
      NBTTagCompound var3 = NBTCompressedStreamTools.fromRawInputStream(var2);
      class_asv var4 = new class_asv();
      var4.b(var3);
      this.a.put(var1, var4);
   }

   public boolean c(MinecraftKey var1) {
      String var2 = var1.getName();
      if(!this.a.containsKey(var2)) {
         return false;
      } else {
         File var3 = MinecraftServer.N().d("structures");
         if(!var3.exists()) {
            if(!var3.mkdirs()) {
               return false;
            }
         } else if(!var3.isDirectory()) {
            return false;
         }

         File var4 = new File(var3, var2 + ".nbt");
         NBTTagCompound var5 = new NBTTagCompound();
         class_asv var6 = (class_asv)this.a.get(var2);
         FileOutputStream var7 = null;

         boolean var9;
         try {
            var6.a(var5);
            var7 = new FileOutputStream(var4);
            NBTCompressedStreamTools.writeToRawOutputStream((NBTTagCompound)var5, (OutputStream)var7);
            return true;
         } catch (Throwable var13) {
            var9 = false;
         } finally {
            IOUtils.closeQuietly((OutputStream)var7);
         }

         return var9;
      }
   }
}
