package net.minecraft.server;


public abstract class BlockPurpurSlabAbstract extends BlockStepAbstract {

	public static final BlockStateEnum<EnumPurpurSlabType> VARIANT = BlockStateEnum.of("variant", BlockPurpurSlabAbstract.EnumPurpurSlabType.class);

	public BlockPurpurSlabAbstract() {
		super(Material.STONE);
		IBlockData var1 = blockStateList.getFirst();
		if (!isDouble()) {
			var1 = var1.set(HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
		}

		setBlockData(var1.set(VARIANT, BlockPurpurSlabAbstract.EnumPurpurSlabType.DEFAULT));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		IBlockData var2 = getBlockData().set(VARIANT, BlockPurpurSlabAbstract.EnumPurpurSlabType.DEFAULT);
		if (!isDouble()) {
			var2 = var2.set(HALF, (var1 & 8) == 0 ? BlockStepAbstract.EnumSlabHalf.BOTTOM : BlockStepAbstract.EnumSlabHalf.TOP);
		}

		return var2;
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		int var2 = 0;
		if (!isDouble() && (var1.get(HALF) == BlockStepAbstract.EnumSlabHalf.TOP)) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	protected BlockStateList getStateList() {
		return isDouble() ? new BlockStateList(this, new IBlockState[] { VARIANT }) : new BlockStateList(this, new IBlockState[] { HALF, VARIANT });
	}

	@Override
	public String b(int var1) {
		return super.getInternalName();
	}

	@Override
	public IBlockState<EnumPurpurSlabType> getVariant() {
		return VARIANT;
	}

	@Override
	public Object a(ItemStack var1) {
		return BlockPurpurSlabAbstract.EnumPurpurSlabType.DEFAULT;
	}

	public static enum EnumPurpurSlabType implements INamable {
		DEFAULT;

		@Override
		public String getName() {
			return "default";
		}
	}

	public static class BlockPurpurDoubleSlab extends BlockPurpurSlabAbstract {
		@Override
		public boolean isDouble() {
			return true;
		}
	}

	public static class BlockPuprpurSlab extends BlockPurpurSlabAbstract {
		@Override
		public boolean isDouble() {
			return false;
		}
	}

}
