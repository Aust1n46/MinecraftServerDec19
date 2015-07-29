package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_uz;
import net.minecraft.server.class_xa;

public class class_vc extends class_uz {
   public class_vc.class_a_in_class_vc c;

   public class_vc(World var1) {
      super(var1);
   }

   public class_vc(World var1, class_cj var2, class_cq var3) {
      super(var1, var2);
      ArrayList var4 = Lists.newArrayList();
      class_vc.class_a_in_class_vc[] var5 = class_vc.class_a_in_class_vc.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         class_vc.class_a_in_class_vc var8 = var5[var7];
         this.c = var8;
         this.a(var3);
         if(this.j()) {
            var4.add(var8);
         }
      }

      if(!var4.isEmpty()) {
         this.c = (class_vc.class_a_in_class_vc)var4.get(this.V.nextInt(var4.size()));
      }

      this.a(var3);
   }

   public void b(class_dn var1) {
      var1.a("Motive", this.c.B);
      super.b(var1);
   }

   public void a(class_dn var1) {
      String var2 = var1.k("Motive");
      class_vc.class_a_in_class_vc[] var3 = class_vc.class_a_in_class_vc.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_vc.class_a_in_class_vc var6 = var3[var5];
         if(var6.B.equals(var2)) {
            this.c = var6;
         }
      }

      if(this.c == null) {
         this.c = class_vc.class_a_in_class_vc.a;
      }

      super.a(var1);
   }

   public int l() {
      return this.c.C;
   }

   public int m() {
      return this.c.D;
   }

   public void b(class_pr var1) {
      if(this.o.R().b("doEntityDrops")) {
         if(var1 instanceof class_xa) {
            class_xa var2 = (class_xa)var1;
            if(var2.bH.d) {
               return;
            }
         }

         this.a(new class_aas(Items.ap), 0.0F);
      }
   }

   public void b(double var1, double var3, double var5, float var7, float var8) {
      class_cj var9 = this.a.a(var1 - this.s, var3 - this.t, var5 - this.u);
      this.b((double)var9.n(), (double)var9.o(), (double)var9.p());
   }

   public static enum class_a_in_class_vc {
      a("Kebab", 16, 16, 0, 0),
      b("Aztec", 16, 16, 16, 0),
      c("Alban", 16, 16, 32, 0),
      d("Aztec2", 16, 16, 48, 0),
      e("Bomb", 16, 16, 64, 0),
      f("Plant", 16, 16, 80, 0),
      g("Wasteland", 16, 16, 96, 0),
      h("Pool", 32, 16, 0, 32),
      i("Courbet", 32, 16, 32, 32),
      j("Sea", 32, 16, 64, 32),
      k("Sunset", 32, 16, 96, 32),
      l("Creebet", 32, 16, 128, 32),
      m("Wanderer", 16, 32, 0, 64),
      n("Graham", 16, 32, 16, 64),
      o("Match", 32, 32, 0, 128),
      p("Bust", 32, 32, 32, 128),
      q("Stage", 32, 32, 64, 128),
      r("Void", 32, 32, 96, 128),
      s("SkullAndRoses", 32, 32, 128, 128),
      t("Wither", 32, 32, 160, 128),
      u("Fighters", 64, 32, 0, 96),
      v("Pointer", 64, 64, 0, 192),
      w("Pigscene", 64, 64, 64, 192),
      x("BurningSkull", 64, 64, 128, 192),
      y("Skeleton", 64, 48, 192, 64),
      z("DonkeyKong", 64, 48, 192, 112);

      public static final int A;
      public final String B;
      public final int C;
      public final int D;
      public final int E;
      public final int F;

      private class_a_in_class_vc(String var3, int var4, int var5, int var6, int var7) {
         this.B = var3;
         this.C = var4;
         this.D = var5;
         this.E = var6;
         this.F = var7;
      }

      static {
         A = "SkullAndRoses".length();
      }
   }
}