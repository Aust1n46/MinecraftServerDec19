package net.minecraft.server;

public class EntityGiantZombie extends EntityMonster {
   public EntityGiantZombie(World var1) {
      super(var1);
      this.a(this.J * 6.0F, this.K * 6.0F);
   }

   public float aU() {
      return 10.440001F;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(100.0D);
      this.a(class_wl.d).a(0.5D);
      this.a(class_wl.e).a(50.0D);
   }

   public float a(BlockPosition var1) {
      return this.o.o(var1) - 0.5F;
   }
}
