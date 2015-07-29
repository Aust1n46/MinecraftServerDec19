package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ago;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.INamable;

public abstract class class_aic extends class_ago {
	protected BlockStateEnum a;

	protected class_aic() {
		this.setBlockData(this.blockStateList.getFirst().set(this.n(), this.l() == class_aic.class_b_in_class_aic.b ? class_aic.class_a_in_class_aic.b : class_aic.class_a_in_class_aic.a));
	}

	public int getDropData(IBlockData var1) {
		return ((class_aic.class_a_in_class_aic) var1.get(this.n())).b();
	}

	public IBlockData fromLegacyData(int var1) {
		return this.getBlockData().set(this.n(), class_aic.class_a_in_class_aic.a(this.l(), var1));
	}

	public abstract class_aic.class_b_in_class_aic l();

	public IBlockState n() {
		if (this.a == null) {
			this.a = BlockStateEnum.a("type", class_aic.class_a_in_class_aic.class, new Predicate() {
				public boolean a(class_aic.class_a_in_class_aic var1) {
					return var1.a() == class_aic.this.l();
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((class_aic.class_a_in_class_aic) var1);
				}
			});
		}

		return this.a;
	}

	public int toLegacyData(IBlockData var1) {
		return ((class_aic.class_a_in_class_aic) var1.get(this.n())).b();
	}

	protected BlockStateList createBlockStateList() {
		return new BlockStateList(this, new IBlockState[] { this.n() });
	}

	public static enum class_a_in_class_aic implements INamable {
		a(class_aic.class_b_in_class_aic.a, 0, "dandelion"), b(class_aic.class_b_in_class_aic.b, 0, "poppy"), c(class_aic.class_b_in_class_aic.b, 1, "blue_orchid", "blueOrchid"), d(class_aic.class_b_in_class_aic.b, 2, "allium"), e(class_aic.class_b_in_class_aic.b, 3, "houstonia"), f(class_aic.class_b_in_class_aic.b, 4, "red_tulip", "tulipRed"), g(class_aic.class_b_in_class_aic.b, 5, "orange_tulip", "tulipOrange"), h(class_aic.class_b_in_class_aic.b, 6, "white_tulip", "tulipWhite"), i(
				class_aic.class_b_in_class_aic.b, 7, "pink_tulip", "tulipPink"), j(class_aic.class_b_in_class_aic.b, 8, "oxeye_daisy", "oxeyeDaisy");

		private static final class_aic.class_a_in_class_aic[][] k;
		private final class_aic.class_b_in_class_aic l;
		private final int m;
		private final String n;
		private final String o;

		private class_a_in_class_aic(class_aic.class_b_in_class_aic var3, int var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private class_a_in_class_aic(class_aic.class_b_in_class_aic var3, int var4, String var5, String var6) {
			this.l = var3;
			this.m = var4;
			this.n = var5;
			this.o = var6;
		}

		public class_aic.class_b_in_class_aic a() {
			return this.l;
		}

		public int b() {
			return this.m;
		}

		public static class_aic.class_a_in_class_aic a(class_aic.class_b_in_class_aic var0, int var1) {
			class_aic.class_a_in_class_aic[] var2 = k[var0.ordinal()];
			if (var1 < 0 || var1 >= var2.length) {
				var1 = 0;
			}

			return var2[var1];
		}

		public String toString() {
			return this.n;
		}

		public String getName() {
			return this.n;
		}

		public String d() {
			return this.o;
		}

		static {
			k = new class_aic.class_a_in_class_aic[class_aic.class_b_in_class_aic.values().length][];
			class_aic.class_b_in_class_aic[] var0 = class_aic.class_b_in_class_aic.values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				final class_aic.class_b_in_class_aic var3 = var0[var2];
				Collection var4 = Collections2.filter(Lists.newArrayList((Object[]) values()), new Predicate() {
					public boolean a(class_aic.class_a_in_class_aic var1) {
						return var1.a() == var3;
					}

					// $FF: synthetic method
					public boolean apply(Object var1) {
						return this.a((class_aic.class_a_in_class_aic) var1);
					}
				});
				k[var3.ordinal()] = (class_aic.class_a_in_class_aic[]) var4.toArray(new class_aic.class_a_in_class_aic[var4.size()]);
			}

		}
	}

	public static enum class_b_in_class_aic {
		a, b;

		public class_aic a() {
			return this == a ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
		}
	}
}