package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class class_le extends class_oh {
   private final Set g = Sets.newHashSet();
   private final Set h;
   private boolean i;

   public class_le(IChatBaseComponent var1, class_oh.class_a_in_class_oh var2, class_oh.class_b_in_class_oh var3, boolean var4, boolean var5) {
      super(MathHelper.getRandomUUID(), var1, var2, var3, var4, var5);
      this.h = Collections.unmodifiableSet(this.g);
      this.i = true;
   }

   public void a(float var1) {
      if(var1 != this.b) {
         super.a(var1);
         this.a(PacketPlayOutBossBar.BossBarType.c);
      }

   }

   private void a(PacketPlayOutBossBar.BossBarType var1) {
      if(this.i) {
         PacketPlayOutBossBar var2 = new PacketPlayOutBossBar(var1, this);
         Iterator var3 = this.g.iterator();

         while(var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            var4.playerConnection.sendPacket((Packet)var2);
         }
      }

   }

   public void a(EntityPlayer var1) {
      if(this.g.add(var1) && this.i) {
         var1.playerConnection.sendPacket((Packet)(new PacketPlayOutBossBar(PacketPlayOutBossBar.BossBarType.a, this)));
      }

   }

   public void b(EntityPlayer var1) {
      if(this.g.remove(var1) && this.i) {
         var1.playerConnection.sendPacket((Packet)(new PacketPlayOutBossBar(PacketPlayOutBossBar.BossBarType.b, this)));
      }

   }

   public void c(boolean var1) {
      if(var1 != this.i) {
         this.i = var1;
         Iterator var2 = this.g.iterator();

         while(var2.hasNext()) {
            EntityPlayer var3 = (EntityPlayer)var2.next();
            var3.playerConnection.sendPacket((Packet)(new PacketPlayOutBossBar(var1? PacketPlayOutBossBar.BossBarType.a: PacketPlayOutBossBar.BossBarType.b, this)));
         }
      }

   }

   public Collection c() {
      return this.h;
   }
}
