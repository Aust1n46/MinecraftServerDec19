package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ok;
import net.minecraft.server.class_xa;

public class class_ow implements class_oj {
   private String a;
   private int b;
   private ItemStack[] c;
   private List d;
   private boolean e;

   public class_ow(String var1, boolean var2, int var3) {
      this.a = var1;
      this.e = var2;
      this.b = var3;
      this.c = new ItemStack[var3];
   }

   public void a(class_ok var1) {
      if(this.d == null) {
         this.d = Lists.newArrayList();
      }

      this.d.add(var1);
   }

   public void b(class_ok var1) {
      this.d.remove(var1);
   }

   public ItemStack a(int var1) {
      return var1 >= 0 && var1 < this.c.length?this.c[var1]:null;
   }

   public ItemStack a(int var1, int var2) {
      if(this.c[var1] != null) {
         ItemStack var3;
         if(this.c[var1].count <= var2) {
            var3 = this.c[var1];
            this.c[var1] = null;
            this.p_();
            return var3;
         } else {
            var3 = this.c[var1].a(var2);
            if(this.c[var1].count == 0) {
               this.c[var1] = null;
            }

            this.p_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack a(ItemStack var1) {
      ItemStack var2 = var1.clone();

      for(int var3 = 0; var3 < this.b; ++var3) {
         ItemStack var4 = this.a(var3);
         if(var4 == null) {
            this.a(var3, var2);
            this.p_();
            return null;
         }

         if(ItemStack.c(var4, var2)) {
            int var5 = Math.min(this.q_(), var4.c());
            int var6 = Math.min(var2.count, var5 - var4.count);
            if(var6 > 0) {
               var4.count += var6;
               var2.count -= var6;
               if(var2.count <= 0) {
                  this.p_();
                  return null;
               }
            }
         }
      }

      if(var2.count != var1.count) {
         this.p_();
      }

      return var2;
   }

   public ItemStack b(int var1) {
      if(this.c[var1] != null) {
         ItemStack var2 = this.c[var1];
         this.c[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      this.c[var1] = var2;
      if(var2 != null && var2.count > this.q_()) {
         var2.count = this.q_();
      }

      this.p_();
   }

   public int o_() {
      return this.b;
   }

   public String e_() {
      return this.a;
   }

   public boolean l_() {
      return this.e;
   }

   public void a(String var1) {
      this.e = true;
      this.a = var1;
   }

   public IChatBaseComponent f_() {
      return (IChatBaseComponent)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }

   public int q_() {
      return 64;
   }

   public void p_() {
      if(this.d != null) {
         for(int var1 = 0; var1 < this.d.size(); ++var1) {
            ((class_ok)this.d.get(var1)).a(this);
         }
      }

   }

   public boolean a(class_xa var1) {
      return true;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, ItemStack var2) {
      return true;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.c.length; ++var1) {
         this.c[var1] = null;
      }

   }
}
