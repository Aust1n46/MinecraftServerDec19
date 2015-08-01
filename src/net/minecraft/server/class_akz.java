package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Entity;
import net.minecraft.server.CreativeTab;

public class class_akz extends Block {
   public class_akz() {
      super(Material.SAND, MaterialMapColor.COLOR27);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      float var4 = 0.125F;
      return new AxisAlignedBB((double)var2.getX(), (double)var2.getY(), (double)var2.getZ(), (double)(var2.getX() + 1), (double)((float)(var2.getY() + 1) - var4), (double)(var2.getZ() + 1));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
      var4.v *= 0.4D;
      var4.x *= 0.4D;
   }
}
