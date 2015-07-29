package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.server.class_aan;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_xa;

public class class_aak extends class_aan {
   private final boolean b;

   public class_aak(boolean var1) {
      super(0, 0.0F, false);
      this.b = var1;
   }

   public int h(class_aas var1) {
      class_aak.class_a_in_class_aak var2 = class_aak.class_a_in_class_aak.a(var1);
      return this.b && var2.g()?var2.e():var2.c();
   }

   public float i(class_aas var1) {
      class_aak.class_a_in_class_aak var2 = class_aak.class_a_in_class_aak.a(var1);
      return this.b && var2.g()?var2.f():var2.d();
   }

   protected void a(class_aas var1, World var2, class_xa var3) {
      class_aak.class_a_in_class_aak var4 = class_aak.class_a_in_class_aak.a(var1);
      if(var4 == class_aak.class_a_in_class_aak.d) {
         var3.c(new class_pl(class_pm.s, 1200, 3));
         var3.c(new class_pl(class_pm.q, 300, 2));
         var3.c(new class_pl(class_pm.i, 300, 1));
      }

      super.a(var1, var2, var3);
   }

   public String e_(class_aas var1) {
      class_aak.class_a_in_class_aak var2 = class_aak.class_a_in_class_aak.a(var1);
      return this.a() + "." + var2.b() + "." + (this.b && var2.g()?"cooked":"raw");
   }

   public static enum class_a_in_class_aak {
      a(0, "cod", 2, 0.1F, 5, 0.6F),
      b(1, "salmon", 2, 0.1F, 6, 0.8F),
      c(2, "clownfish", 1, 0.1F),
      d(3, "pufferfish", 1, 0.1F);

      private static final Map e;
      private final int f;
      private final String g;
      private final int h;
      private final float i;
      private final int j;
      private final float k;
      private boolean l = false;

      private class_a_in_class_aak(int var3, String var4, int var5, float var6, int var7, float var8) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = var7;
         this.k = var8;
         this.l = true;
      }

      private class_a_in_class_aak(int var3, String var4, int var5, float var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = 0;
         this.k = 0.0F;
         this.l = false;
      }

      public int a() {
         return this.f;
      }

      public String b() {
         return this.g;
      }

      public int c() {
         return this.h;
      }

      public float d() {
         return this.i;
      }

      public int e() {
         return this.j;
      }

      public float f() {
         return this.k;
      }

      public boolean g() {
         return this.l;
      }

      public static class_aak.class_a_in_class_aak a(int var0) {
         class_aak.class_a_in_class_aak var1 = (class_aak.class_a_in_class_aak)e.get(Integer.valueOf(var0));
         return var1 == null?a:var1;
      }

      public static class_aak.class_a_in_class_aak a(class_aas var0) {
         return var0.b() instanceof class_aak?a(var0.i()):a;
      }

      static {
         e = Maps.newHashMap();
         class_aak.class_a_in_class_aak[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_aak.class_a_in_class_aak var3 = var0[var2];
            e.put(Integer.valueOf(var3.a()), var3);
         }

      }
   }
}