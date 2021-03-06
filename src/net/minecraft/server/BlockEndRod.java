package net.minecraft.server;

import java.util.Iterator;

public class BlockEndRod extends class_ahi {

	protected BlockEndRod() {
		super(Material.ORIENTABLE);
		setBlockData(blockStateList.getFirst().set(FACING, EnumDirection.UP));
		setCreativeTab(CreativeTab.DECORATIONS);
	}

	@Override
	public IBlockData a(IBlockData blockdata, Block.EnumRotation rotation) {
		return blockdata.getBlock() != this ? blockdata : blockdata.set(FACING, rotation.a(blockdata.get(FACING)));
	}

	@Override
	public IBlockData a(IBlockData blockdata, Block.class_a_in_class_agj var2) {
		return blockdata.getBlock() != this ? blockdata : blockdata.set(FACING, var2.b(blockdata.get(FACING)));
	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		EnumDirection var4 = var3.get(FACING);
		float var5 = 0.4375F;
		float var6 = 0.5625F;
		return (var4 != EnumDirection.EAST) && (var4 != EnumDirection.WEST) ? ((var4 != EnumDirection.SOUTH) && (var4 != EnumDirection.NORTH) ? new AxisAlignedBB(var2.getX() + var5, var2.getY() + 0, var2.getZ() + var5, var2.getX() + var6, var2.getY() + 1, var2.getZ() + var6) : new AxisAlignedBB(var2.getX() + var5, var2.getY() + var5, var2.getZ() + 0,
				var2.getX() + var6, var2.getY() + var6, var2.getZ() + 1)) : new AxisAlignedBB(var2.getX() + 0, var2.getY() + var5, var2.getZ() + var5, var2.getX() + 1, var2.getY() + var6, var2.getZ() + var6);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean canPlace(World world, BlockPosition position) {
		Iterator<EnumDirection> var3 = FACING.getValues().iterator();

		EnumDirection direction;
		do {
			if (!var3.hasNext()) {
				return false;
			}
			direction = (EnumDirection) var3.next();
		} while (!this.a(world, position, direction));

		return true;
	}

	private boolean a(World var1, BlockPosition var2, EnumDirection var3) {
		return true;
	}

	@Override
	public IBlockData getPlacedState(World world, BlockPosition position, EnumDirection face, float var4, float var5, float var6, int var7, EntityLiving var8) {
		IBlockData blockdata = world.getType(position.shift(face.opposite()));
		if (blockdata.getBlock() == Blocks.END_ROD) {
			EnumDirection facing = blockdata.get(FACING);
			if (facing == face) {
				return getBlockData().set(FACING, face.opposite());
			}
		}
		return getBlockData().set(FACING, face);
	}

	@Override
	public void onPlace(World world, BlockPosition position, IBlockData blockdata) {
	}

	@Override
	public void doPhysics(World world, BlockPosition position, IBlockData blockdata, Block block) {
	}

	@Override
	public MovingObjectPosition rayTraceCollision(World world, BlockPosition position, Vec3D vec1, Vec3D vec2) {
		EnumDirection facing = world.getType(position).get(FACING);
		float var6 = 0.375F;
		float var7 = 0.625F;
		if ((facing != EnumDirection.EAST) && (facing != EnumDirection.WEST)) {
			if ((facing != EnumDirection.SOUTH) && (facing != EnumDirection.NORTH)) {
				setSizes(var6, 0.0F, var6, var7, 1.0F, var7);
			} else {
				setSizes(var6, var6, 0.0F, var7, var7, 1.0F);
			}
		} else {
			setSizes(0.0F, var6, var6, 1.0F, var7, var7);
		}

		return super.rayTraceCollision(world, position, vec1, vec2);
	}

	@Override
	public IBlockData fromLegacyData(int data) {
		IBlockData var2 = getBlockData();
		var2 = var2.set(FACING, EnumDirection.getById(data));
		return var2;
	}

	@Override
	public int toLegacyData(IBlockData blockdata) {
		return blockdata.get(FACING).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { FACING });
	}

	@Override
	public int getPushReaction() {
		return 0;
	}

}
