package net.minecraft.server;

import net.minecraft.server.class_dj;

public class LocaleI18n {
   private static class_dj a = class_dj.a();
   private static class_dj b = new class_dj();

   public static String get(String var0) {
      return a.a(var0);
   }

   public static String a(String var0, Object... var1) {
      return a.a(var0, var1);
   }

   public static String b(String var0) {
      return b.a(var0);
   }

   public static boolean c(String var0) {
      return a.b(var0);
   }

   public static long a() {
      return a.c();
   }
}
