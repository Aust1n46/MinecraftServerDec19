package net.minecraft.server;

import net.minecraft.server.BlockRotatable;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.CreativeTab;

public class class_ait extends BlockRotatable {
   public class_ait() {
      super(Material.GRASS, MaterialMapColor.COLOR19);
      this.setBlockData(this.blockStateList.getFirst().set(AXIS, EnumDirection.EnumAxis.Y));
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }
}
