package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.CreativeTab;

public class BlockPackedIce extends Block {
   public BlockPackedIce() {
      super(Material.SNOW_LAYER);
      this.frictionFactor = 0.98F;
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropCount(Random var1) {
      return 0;
   }
}
