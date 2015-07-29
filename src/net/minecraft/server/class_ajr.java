package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;

public class class_ajr extends Block {
   public class_ajr() {
      super(Material.e);
      this.a(CreativeTab.b);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock(Blocks.OBSIDIAN);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return MaterialMapColor.E;
   }
}