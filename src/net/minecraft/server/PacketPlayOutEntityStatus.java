package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.Entity;

public class PacketPlayOutEntityStatus implements Packet {
   private int a;
   private byte b;

   public PacketPlayOutEntityStatus() {
   }

   public PacketPlayOutEntityStatus(Entity var1, byte var2) {
      this.a = var1.getId();
      this.b = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.readByte();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeByte(this.b);
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
