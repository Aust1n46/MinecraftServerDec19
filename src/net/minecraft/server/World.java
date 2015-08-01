package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aeh;
import net.minecraft.server.Explosion;
import net.minecraft.server.class_ael;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aep;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_aet;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockStepAbstract;
import net.minecraft.server.class_aiu;
import net.minecraft.server.BlockFluids;
import net.minecraft.server.class_aky;
import net.minecraft.server.BlockStairs;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aoe;
import net.minecraft.server.class_aoh;
import net.minecraft.server.Chunk;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_arw;
import net.minecraft.server.Material;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_avz;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.Vec3D;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_e;
import net.minecraft.server.ITickAble;
import net.minecraft.server.class_no;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_nv;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_tr;
import net.minecraft.server.EntityHuman;

public abstract class World implements IBlockAccess {
   private int a = 63;
   protected boolean e;
   public final List f = Lists.newArrayList();
   protected final List g = Lists.newArrayList();
   public final List h = Lists.newArrayList();
   public final List i = Lists.newArrayList();
   private final List b = Lists.newArrayList();
   private final List c = Lists.newArrayList();
   public final List<EntityHuman> players = Lists.newArrayList();
   public final List k = Lists.newArrayList();
   protected final class_no l = new class_no();
   private long d = 16777215L;
   private int I;
   protected int m = (new Random()).nextInt();
   protected final int n = 1013904223;
   protected float o;
   protected float p;
   protected float q;
   protected float r;
   private int J;
   public final Random random = new Random();
   public final class_aoy worldProvider;
   protected List u = Lists.newArrayList();
   protected class_aoh v;
   protected final class_avo w;
   protected class_avn x;
   protected boolean y;
   protected class_avz z;
   protected class_tr A;
   public final class_nv B;
   private final Calendar K = Calendar.getInstance();
   protected class_awn C = new class_awn();
   public final boolean isClientSide;
   protected Set E = Sets.newHashSet();
   private int L;
   protected boolean F;
   protected boolean G;
   private boolean M;
   private final class_aoe N;
   int[] H;

   protected World(class_avo var1, class_avn var2, class_aoy var3, class_nv var4, boolean var5) {
      this.L = this.random.nextInt(12000);
      this.F = true;
      this.G = true;
      this.H = new int['耀'];
      this.w = var1;
      this.B = var4;
      this.x = var2;
      this.worldProvider = var3;
      this.isClientSide = var5;
      this.N = var3.o();
   }

   public World b() {
      return this;
   }

   public BiomeBase b(final BlockPosition var1) {
      if(this.e(var1)) {
         Chunk var2 = this.f(var1);

         try {
            return var2.a(var1, this.worldProvider.k());
         } catch (Throwable var6) {
            class_b var4 = class_b.a(var6, "Getting biome");
            class_c var5 = var4.a("Coordinates of biome request");
            var5.a("Location", new Callable() {
               public String a() throws Exception {
                  return class_c.a(var1);
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var4);
         }
      } else {
         return this.worldProvider.k().a(var1, BiomeBase.q);
      }
   }

   public class_afd w() {
      return this.worldProvider.k();
   }

   protected abstract class_aoh l();

   public void a(WorldSettings var1) {
      this.x.d(true);
   }

   public Block c(BlockPosition var1) {
      BlockPosition var2;
      for(var2 = new BlockPosition(var1.getX(), this.G(), var1.getZ()); !this.isEmpty(var2.up()); var2 = var2.up()) {
         ;
      }

      return this.getType(var2).getBlock();
   }

   private boolean a(BlockPosition var1) {
      return var1.getX() >= -30000000 && var1.getZ() >= -30000000 && var1.getX() < 30000000 && var1.getZ() < 30000000 && var1.getY() >= 0 && var1.getY() < 256;
   }

   public boolean isEmpty(BlockPosition position) {
      return this.getType(position).getBlock().getMaterial() == Material.AIR;
   }

   public boolean e(BlockPosition var1) {
      return this.a(var1, true);
   }

   public boolean a(BlockPosition var1, boolean var2) {
      return !this.a(var1)?false:this.a(var1.getX() >> 4, var1.getZ() >> 4, var2);
   }

   public boolean a(BlockPosition var1, int var2) {
      return this.a(var1, var2, true);
   }

   public boolean a(BlockPosition var1, int var2, boolean var3) {
      return this.a(var1.getX() - var2, var1.getY() - var2, var1.getZ() - var2, var1.getX() + var2, var1.getY() + var2, var1.getZ() + var2, var3);
   }

   public boolean areChunksLoadedBetween(BlockPosition var1, BlockPosition var2) {
      return this.a(var1, var2, true);
   }

   public boolean a(BlockPosition var1, BlockPosition var2, boolean var3) {
      return this.a(var1.getX(), var1.getY(), var1.getZ(), var2.getX(), var2.getY(), var2.getZ(), var3);
   }

   public boolean a(class_arw var1) {
      return this.b(var1, true);
   }

   public boolean b(class_arw var1, boolean var2) {
      return this.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var2);
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      if(var5 >= 0 && var2 < 256) {
         var1 >>= 4;
         var3 >>= 4;
         var4 >>= 4;
         var6 >>= 4;

         for(int var8 = var1; var8 <= var4; ++var8) {
            for(int var9 = var3; var9 <= var6; ++var9) {
               if(!this.a(var8, var9, var7)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean a(int var1, int var2, boolean var3) {
      return this.v.a(var1, var2) && (var3 || !this.v.d(var1, var2).f());
   }

   public Chunk f(BlockPosition var1) {
      return this.a(var1.getX() >> 4, var1.getZ() >> 4);
   }

   public Chunk a(int var1, int var2) {
      return this.v.d(var1, var2);
   }

   public boolean setTypeAndData(BlockPosition var1, IBlockData var2, int var3) {
      if(!this.a(var1)) {
         return false;
      } else if(!this.isClientSide && this.x.u() == class_aes.g) {
         return false;
      } else {
         Chunk var4 = this.f(var1);
         Block var5 = var2.getBlock();
         IBlockData var6 = var4.a(var1, var2);
         if(var6 == null) {
            return false;
         } else {
            Block var7 = var6.getBlock();
            if(var5.getLightOpacity() != var7.getLightOpacity() || var5.getLightLevel() != var7.getLightLevel()) {
               this.B.a("checkLight");
               this.x(var1);
               this.B.b();
            }

            if((var3 & 2) != 0 && (!this.isClientSide || (var3 & 4) == 0) && var4.i()) {
               this.h(var1);
            }

            if(!this.isClientSide && (var3 & 1) != 0) {
               this.b(var1, var6.getBlock());
               if(var5.isComplexRedstone()) {
                  this.e(var1, var5);
               }
            }

            return true;
         }
      }
   }

   public boolean setAir(BlockPosition var1) {
      return this.setTypeAndData((BlockPosition)var1, (IBlockData)Blocks.AIR.getBlockData(), 3);
   }

   public boolean b(BlockPosition var1, boolean var2) {
      IBlockData var3 = this.getType(var1);
      Block var4 = var3.getBlock();
      if(var4.getMaterial() == Material.AIR) {
         return false;
      } else {
         this.b(2001, var1, Block.getCombinedId(var3));
         if(var2) {
            var4.dropNaturallyForSure(this, var1, var3, 0);
         }

         return this.setTypeAndData((BlockPosition)var1, (IBlockData)Blocks.AIR.getBlockData(), 3);
      }
   }

   public boolean setTypeUpdate(BlockPosition var1, IBlockData var2) {
      return this.setTypeAndData((BlockPosition)var1, (IBlockData)var2, 3);
   }

   public void h(BlockPosition var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).a(var1);
      }

   }

   public void b(BlockPosition var1, Block var2) {
      if(this.x.u() != class_aes.g) {
         this.c(var1, var2);
      }

   }

   public void a(int var1, int var2, int var3, int var4) {
      int var5;
      if(var3 > var4) {
         var5 = var4;
         var4 = var3;
         var3 = var5;
      }

      if(!this.worldProvider.m()) {
         for(var5 = var3; var5 <= var4; ++var5) {
            this.c(class_aet.a, new BlockPosition(var1, var5, var2));
         }
      }

      this.b(var1, var3, var2, var1, var4, var2);
   }

   public void b(BlockPosition var1, BlockPosition var2) {
      this.b(var1.getX(), var1.getY(), var1.getZ(), var2.getX(), var2.getY(), var2.getZ());
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      for(int var7 = 0; var7 < this.u.size(); ++var7) {
         ((class_aep)this.u.get(var7)).a(var1, var2, var3, var4, var5, var6);
      }

   }

   public void c(BlockPosition var1, Block var2) {
      this.d(var1.west(), var2);
      this.d(var1.east(), var2);
      this.d(var1.down(), var2);
      this.d(var1.up(), var2);
      this.d(var1.north(), var2);
      this.d(var1.south(), var2);
   }

   public void a(BlockPosition var1, Block var2, EnumDirection var3) {
      if(var3 != EnumDirection.WEST) {
         this.d(var1.west(), var2);
      }

      if(var3 != EnumDirection.EAST) {
         this.d(var1.east(), var2);
      }

      if(var3 != EnumDirection.DOWN) {
         this.d(var1.down(), var2);
      }

      if(var3 != EnumDirection.UP) {
         this.d(var1.up(), var2);
      }

      if(var3 != EnumDirection.NORTH) {
         this.d(var1.north(), var2);
      }

      if(var3 != EnumDirection.SOUTH) {
         this.d(var1.south(), var2);
      }

   }

   public void d(BlockPosition var1, final Block var2) {
      if(!this.isClientSide) {
         IBlockData var3 = this.getType(var1);

         try {
            var3.getBlock().doPhysics(this, var1, var3, var2);
         } catch (Throwable var7) {
            class_b var5 = class_b.a(var7, "Exception while updating neighbours");
            class_c var6 = var5.a("Block being updated");
            var6.a("Source block type", new Callable() {
               public String a() throws Exception {
                  try {
                     return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(Block.getId(var2)), var2.getInternalName(), var2.getClass().getCanonicalName()});
                  } catch (Throwable var2x) {
                     return "ID #" + Block.getId(var2);
                  }
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            class_c.a(var6, var1, var3);
            throw new class_e(var5);
         }
      }
   }

   public boolean a(BlockPosition var1, Block var2) {
      return false;
   }

   public boolean i(BlockPosition var1) {
      return this.f(var1).d(var1);
   }

   public boolean j(BlockPosition var1) {
      if(var1.getY() >= this.G()) {
         return this.i(var1);
      } else {
         BlockPosition var2 = new BlockPosition(var1.getX(), this.G(), var1.getZ());
         if(!this.i(var2)) {
            return false;
         } else {
            for(var2 = var2.down(); var2.getY() > var1.getY(); var2 = var2.down()) {
               Block var3 = this.getType(var2).getBlock();
               if(var3.getLightOpacity() > 0 && !var3.getMaterial().isLiquid()) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int k(BlockPosition var1) {
      if(var1.getY() < 0) {
         return 0;
      } else {
         if(var1.getY() >= 256) {
            var1 = new BlockPosition(var1.getX(), 255, var1.getZ());
         }

         return this.f(var1).a((BlockPosition)var1, 0);
      }
   }

   public int l(BlockPosition var1) {
      return this.c(var1, true);
   }

   public int c(BlockPosition var1, boolean var2) {
      if(var1.getX() >= -30000000 && var1.getZ() >= -30000000 && var1.getX() < 30000000 && var1.getZ() < 30000000) {
         if(var2 && this.getType(var1).getBlock().useNeighborBrightness()) {
            int var8 = this.c(var1.up(), false);
            int var4 = this.c(var1.east(), false);
            int var5 = this.c(var1.west(), false);
            int var6 = this.c(var1.south(), false);
            int var7 = this.c(var1.north(), false);
            if(var4 > var8) {
               var8 = var4;
            }

            if(var5 > var8) {
               var8 = var5;
            }

            if(var6 > var8) {
               var8 = var6;
            }

            if(var7 > var8) {
               var8 = var7;
            }

            return var8;
         } else if(var1.getY() < 0) {
            return 0;
         } else {
            if(var1.getY() >= 256) {
               var1 = new BlockPosition(var1.getX(), 255, var1.getZ());
            }

            Chunk var3 = this.f(var1);
            return var3.a(var1, this.I);
         }
      } else {
         return 15;
      }
   }

   public BlockPosition m(BlockPosition var1) {
      int var2;
      if(var1.getX() >= -30000000 && var1.getZ() >= -30000000 && var1.getX() < 30000000 && var1.getZ() < 30000000) {
         if(this.a(var1.getX() >> 4, var1.getZ() >> 4, true)) {
            var2 = this.a(var1.getX() >> 4, var1.getZ() >> 4).b(var1.getX() & 15, var1.getZ() & 15);
         } else {
            var2 = 0;
         }
      } else {
         var2 = this.G() + 1;
      }

      return new BlockPosition(var1.getX(), var2, var1.getZ());
   }

   public int b(int var1, int var2) {
      if(var1 >= -30000000 && var2 >= -30000000 && var1 < 30000000 && var2 < 30000000) {
         if(!this.a(var1 >> 4, var2 >> 4, true)) {
            return 0;
         } else {
            Chunk var3 = this.a(var1 >> 4, var2 >> 4);
            return var3.v();
         }
      } else {
         return this.G() + 1;
      }
   }

   public int b(class_aet var1, BlockPosition var2) {
      if(var2.getY() < 0) {
         var2 = new BlockPosition(var2.getX(), 0, var2.getZ());
      }

      if(!this.a(var2)) {
         return var1.c;
      } else if(!this.e(var2)) {
         return var1.c;
      } else {
         Chunk var3 = this.f(var2);
         return var3.a(var1, var2);
      }
   }

   public void a(class_aet var1, BlockPosition var2, int var3) {
      if(this.a(var2)) {
         if(this.e(var2)) {
            Chunk var4 = this.f(var2);
            var4.a(var1, var2, var3);
            this.n(var2);
         }
      }
   }

   public void n(BlockPosition var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).b(var1);
      }

   }

   public float o(BlockPosition var1) {
      return this.worldProvider.n()[this.l(var1)];
   }

   public IBlockData getType(BlockPosition var1) {
      if(!this.a(var1)) {
         return Blocks.AIR.getBlockData();
      } else {
         Chunk var2 = this.f(var1);
         return var2.g(var1);
      }
   }

   public boolean x() {
      return this.I < 4;
   }

   public MovingObjectPosition a(Vec3D var1, Vec3D var2) {
      return this.a(var1, var2, false, false, false);
   }

   public MovingObjectPosition a(Vec3D var1, Vec3D var2, boolean var3) {
      return this.a(var1, var2, var3, false, false);
   }

   public MovingObjectPosition a(Vec3D var1, Vec3D var2, boolean var3, boolean var4, boolean var5) {
      if(!Double.isNaN(var1.x) && !Double.isNaN(var1.y) && !Double.isNaN(var1.z)) {
         if(!Double.isNaN(var2.x) && !Double.isNaN(var2.y) && !Double.isNaN(var2.z)) {
            int var6 = MathHelper.floor(var2.x);
            int var7 = MathHelper.floor(var2.y);
            int var8 = MathHelper.floor(var2.z);
            int var9 = MathHelper.floor(var1.x);
            int var10 = MathHelper.floor(var1.y);
            int var11 = MathHelper.floor(var1.z);
            BlockPosition var12 = new BlockPosition(var9, var10, var11);
            IBlockData var13 = this.getType(var12);
            Block var14 = var13.getBlock();
            if((!var4 || var14.getBoundingBox(this, var12, var13) != null) && var14.canCollide(var13, var3)) {
               MovingObjectPosition var15 = var14.rayTraceCollision(this, var12, var1, var2);
               if(var15 != null) {
                  return var15;
               }
            }

            MovingObjectPosition var40 = null;
            int var41 = 200;

            while(var41-- >= 0) {
               if(Double.isNaN(var1.x) || Double.isNaN(var1.y) || Double.isNaN(var1.z)) {
                  return null;
               }

               if(var9 == var6 && var10 == var7 && var11 == var8) {
                  return var5?var40:null;
               }

               boolean var42 = true;
               boolean var16 = true;
               boolean var17 = true;
               double var18 = 999.0D;
               double var20 = 999.0D;
               double var22 = 999.0D;
               if(var6 > var9) {
                  var18 = (double)var9 + 1.0D;
               } else if(var6 < var9) {
                  var18 = (double)var9 + 0.0D;
               } else {
                  var42 = false;
               }

               if(var7 > var10) {
                  var20 = (double)var10 + 1.0D;
               } else if(var7 < var10) {
                  var20 = (double)var10 + 0.0D;
               } else {
                  var16 = false;
               }

               if(var8 > var11) {
                  var22 = (double)var11 + 1.0D;
               } else if(var8 < var11) {
                  var22 = (double)var11 + 0.0D;
               } else {
                  var17 = false;
               }

               double var24 = 999.0D;
               double var26 = 999.0D;
               double var28 = 999.0D;
               double var30 = var2.x - var1.x;
               double var32 = var2.y - var1.y;
               double var34 = var2.z - var1.z;
               if(var42) {
                  var24 = (var18 - var1.x) / var30;
               }

               if(var16) {
                  var26 = (var20 - var1.y) / var32;
               }

               if(var17) {
                  var28 = (var22 - var1.z) / var34;
               }

               if(var24 == -0.0D) {
                  var24 = -1.0E-4D;
               }

               if(var26 == -0.0D) {
                  var26 = -1.0E-4D;
               }

               if(var28 == -0.0D) {
                  var28 = -1.0E-4D;
               }

               EnumDirection var36;
               if(var24 < var26 && var24 < var28) {
                  var36 = var6 > var9?EnumDirection.WEST:EnumDirection.EAST;
                  var1 = new Vec3D(var18, var1.y + var32 * var24, var1.z + var34 * var24);
               } else if(var26 < var28) {
                  var36 = var7 > var10?EnumDirection.DOWN:EnumDirection.UP;
                  var1 = new Vec3D(var1.x + var30 * var26, var20, var1.z + var34 * var26);
               } else {
                  var36 = var8 > var11?EnumDirection.NORTH:EnumDirection.SOUTH;
                  var1 = new Vec3D(var1.x + var30 * var28, var1.y + var32 * var28, var22);
               }

               var9 = MathHelper.floor(var1.x) - (var36 == EnumDirection.EAST?1:0);
               var10 = MathHelper.floor(var1.y) - (var36 == EnumDirection.UP?1:0);
               var11 = MathHelper.floor(var1.z) - (var36 == EnumDirection.SOUTH?1:0);
               var12 = new BlockPosition(var9, var10, var11);
               IBlockData var37 = this.getType(var12);
               Block var38 = var37.getBlock();
               if(!var4 || var38.getBoundingBox(this, var12, var37) != null) {
                  if(var38.canCollide(var37, var3)) {
                     MovingObjectPosition var39 = var38.rayTraceCollision(this, var12, var1, var2);
                     if(var39 != null) {
                        return var39;
                     }
                  } else {
                     var40 = new MovingObjectPosition(MovingObjectPosition.class_a_in_class_awg.a, var1, var36, var12);
                  }
               }
            }

            return var5?var40:null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void a(Entity var1, String var2, float var3, float var4) {
      for(int var5 = 0; var5 < this.u.size(); ++var5) {
         ((class_aep)this.u.get(var5)).a(var2, var1.s, var1.t, var1.u, var3, var4);
      }

   }

   public void a(EntityHuman var1, String var2, float var3, float var4) {
      for(int var5 = 0; var5 < this.u.size(); ++var5) {
         ((class_aep)this.u.get(var5)).a(var1, var2, var1.s, var1.t, var1.u, var3, var4);
      }

   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9) {
      for(int var10 = 0; var10 < this.u.size(); ++var10) {
         ((class_aep)this.u.get(var10)).a(var7, var1, var3, var5, var8, var9);
      }

   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
   }

   public void a(BlockPosition var1, String var2) {
      for(int var3 = 0; var3 < this.u.size(); ++var3) {
         ((class_aep)this.u.get(var3)).a(var2, var1);
      }

   }

   public void a(class_cy var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
      this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
   }

   private void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      for(int var16 = 0; var16 < this.u.size(); ++var16) {
         ((class_aep)this.u.get(var16)).a(var1, var2, var3, var5, var7, var9, var11, var13, var15);
      }

   }

   public boolean d(Entity var1) {
      this.k.add(var1);
      return true;
   }

   public boolean addEntity(Entity var1) {
      int var2 = MathHelper.floor(var1.s / 16.0D);
      int var3 = MathHelper.floor(var1.u / 16.0D);
      boolean var4 = var1.n;
      if(var1 instanceof EntityHuman) {
         var4 = true;
      }

      if(!var4 && !this.a(var2, var3, true)) {
         return false;
      } else {
         if(var1 instanceof EntityHuman) {
            EntityHuman var5 = (EntityHuman)var1;
            this.players.add(var5);
            this.e();
         }

         this.a(var2, var3).a(var1);
         this.f.add(var1);
         this.b(var1);
         return true;
      }
   }

   protected void b(Entity var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).a(var1);
      }

   }

   protected void c(Entity var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).b(var1);
      }

   }

   public void e(Entity var1) {
      if(var1.l != null) {
         var1.l.a((Entity)null);
      }

      if(var1.m != null) {
         var1.a((Entity)null);
      }

      var1.J();
      if(var1 instanceof EntityHuman) {
         this.players.remove(var1);
         this.e();
         this.c(var1);
      }

   }

   public void f(Entity var1) {
      var1.J();
      if(var1 instanceof EntityHuman) {
         this.players.remove(var1);
         this.e();
      }

      int var2 = var1.ae;
      int var3 = var1.ag;
      if(var1.ad && this.a(var2, var3, true)) {
         this.a(var2, var3).b(var1);
      }

      this.f.remove(var1);
      this.c(var1);
   }

   public void a(class_aep var1) {
      this.u.add(var1);
   }

   public List a(Entity var1, AxisAlignedBB var2) {
      ArrayList var3 = Lists.newArrayList();
      int var4 = MathHelper.floor(var2.xMin);
      int var5 = MathHelper.floor(var2.xMax + 1.0D);
      int var6 = MathHelper.floor(var2.yMin);
      int var7 = MathHelper.floor(var2.yMax + 1.0D);
      int var8 = MathHelper.floor(var2.zMin);
      int var9 = MathHelper.floor(var2.zMax + 1.0D);
      class_aoe var10 = this.ag();
      boolean var11 = var1.aV();
      boolean var12 = this.a(var10, var1);
      IBlockData var13 = Blocks.STONE.getBlockData();
      BlockPosition.MutableBlockPosition var14 = new BlockPosition.MutableBlockPosition();

      for(int var15 = var4; var15 < var5; ++var15) {
         for(int var16 = var8; var16 < var9; ++var16) {
            if(this.e((BlockPosition)var14.setPosition(var15, 64, var16))) {
               for(int var17 = var6 - 1; var17 < var7; ++var17) {
                  var14.setPosition(var15, var17, var16);
                  if(var11 && var12) {
                     var1.h(false);
                  } else if(!var11 && !var12) {
                     var1.h(true);
                  }

                  IBlockData var18 = var13;
                  if(var10.a((BlockPosition)var14) || !var12) {
                     var18 = this.getType(var14);
                  }

                  var18.getBlock().addBBIfInsideInputBB(this, (BlockPosition)var14, (IBlockData)var18, (AxisAlignedBB)var2, (List)var3, (Entity)var1);
               }
            }
         }
      }

      double var21 = 0.25D;
      List var22 = this.b(var1, var2.grow(var21, var21, var21));

      for(int var23 = 0; var23 < var22.size(); ++var23) {
         Entity var19 = (Entity)var22.get(var23);
         if(var1.l != var19 && var1.m != var19) {
            AxisAlignedBB var20 = var19.S();
            if(var20 != null && var20.isInside(var2)) {
               var3.add(var20);
            }

            var20 = var1.j(var19);
            if(var20 != null && var20.isInside(var2)) {
               var3.add(var20);
            }
         }
      }

      return var3;
   }

   public boolean a(class_aoe var1, Entity var2) {
      double var3 = var1.b();
      double var5 = var1.c();
      double var7 = var1.d();
      double var9 = var1.e();
      if(var2.aV()) {
         ++var3;
         ++var5;
         --var7;
         --var9;
      } else {
         --var3;
         --var5;
         ++var7;
         ++var9;
      }

      return var2.s > var3 && var2.s < var7 && var2.u > var5 && var2.u < var9;
   }

   public List a(AxisAlignedBB var1) {
      ArrayList var2 = Lists.newArrayList();
      int var3 = MathHelper.floor(var1.xMin);
      int var4 = MathHelper.floor(var1.xMax + 1.0D);
      int var5 = MathHelper.floor(var1.yMin);
      int var6 = MathHelper.floor(var1.yMax + 1.0D);
      int var7 = MathHelper.floor(var1.zMin);
      int var8 = MathHelper.floor(var1.zMax + 1.0D);
      BlockPosition.MutableBlockPosition var9 = new BlockPosition.MutableBlockPosition();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var7; var11 < var8; ++var11) {
            if(this.e((BlockPosition)var9.setPosition(var10, 64, var11))) {
               for(int var12 = var5 - 1; var12 < var6; ++var12) {
                  var9.setPosition(var10, var12, var11);
                  IBlockData var13;
                  if(var10 >= -30000000 && var10 < 30000000 && var11 >= -30000000 && var11 < 30000000) {
                     var13 = this.getType(var9);
                  } else {
                     var13 = Blocks.BEDROCK.getBlockData();
                  }

                  var13.getBlock().addBBIfInsideInputBB(this, (BlockPosition)var9, (IBlockData)var13, (AxisAlignedBB)var1, (List)var2, (Entity)null);
               }
            }
         }
      }

      return var2;
   }

   public int a(float var1) {
      float var2 = this.c(var1);
      float var3 = 1.0F - (MathHelper.cos(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      var3 = MathHelper.clamp(var3, 0.0F, 1.0F);
      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.j(var1) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.h(var1) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public float c(float var1) {
      return this.worldProvider.a(this.x.g(), var1);
   }

   public float z() {
      return class_aoy.a[this.worldProvider.a(this.x.g())];
   }

   public float d(float var1) {
      float var2 = this.c(var1);
      return var2 * 3.1415927F * 2.0F;
   }

   public BlockPosition q(BlockPosition var1) {
      return this.f(var1).h(var1);
   }

   public BlockPosition r(BlockPosition var1) {
      Chunk var2 = this.f(var1);

      BlockPosition var3;
      BlockPosition var4;
      for(var3 = new BlockPosition(var1.getX(), var2.g() + 16, var1.getZ()); var3.getY() >= 0; var3 = var4) {
         var4 = var3.down();
         Material var5 = var2.a(var4).getMaterial();
         if(var5.isSolid() && var5 != Material.LEAVES) {
            break;
         }
      }

      return var3;
   }

   public void a(BlockPosition var1, Block var2, int var3) {
   }

   public void a(BlockPosition var1, Block var2, int var3, int var4) {
   }

   public void b(BlockPosition var1, Block var2, int var3, int var4) {
   }

   public void j() {
      this.B.a("entities");
      this.B.a("global");

      int var1;
      Entity var2;
      class_b var4;
      class_c var5;
      for(var1 = 0; var1 < this.k.size(); ++var1) {
         var2 = (Entity)this.k.get(var1);

         try {
            ++var2.W;
            var2.t_();
         } catch (Throwable var9) {
            var4 = class_b.a(var9, "Ticking entity");
            var5 = var4.a("Entity being ticked");
            if(var2 == null) {
               var5.a((String)"Entity", (Object)"~~NULL~~");
            } else {
               var2.a(var5);
            }

            throw new class_e(var4);
         }

         if(var2.I) {
            this.k.remove(var1--);
         }
      }

      this.B.c("remove");
      this.f.removeAll(this.g);

      int var3;
      int var14;
      for(var1 = 0; var1 < this.g.size(); ++var1) {
         var2 = (Entity)this.g.get(var1);
         var3 = var2.ae;
         var14 = var2.ag;
         if(var2.ad && this.a(var3, var14, true)) {
            this.a(var3, var14).b(var2);
         }
      }

      for(var1 = 0; var1 < this.g.size(); ++var1) {
         this.c((Entity)this.g.get(var1));
      }

      this.g.clear();
      this.B.c("regular");

      for(var1 = 0; var1 < this.f.size(); ++var1) {
         var2 = (Entity)this.f.get(var1);
         if(var2.m != null) {
            if(!var2.m.I && var2.m.l == var2) {
               continue;
            }

            var2.m.l = null;
            var2.m = null;
         }

         this.B.a("tick");
         if(!var2.I) {
            try {
               this.g(var2);
            } catch (Throwable var8) {
               var4 = class_b.a(var8, "Ticking entity");
               var5 = var4.a("Entity being ticked");
               var2.a(var5);
               throw new class_e(var4);
            }
         }

         this.B.b();
         this.B.a("remove");
         if(var2.I) {
            var3 = var2.ae;
            var14 = var2.ag;
            if(var2.ad && this.a(var3, var14, true)) {
               this.a(var3, var14).b(var2);
            }

            this.f.remove(var1--);
            this.c(var2);
         }

         this.B.b();
      }

      this.B.c("blockEntities");
      this.M = true;
      Iterator var15 = this.i.iterator();

      while(var15.hasNext()) {
         TileEntity var10 = (TileEntity)var15.next();
         if(!var10.isInvalid() && var10.hasWorld()) {
            BlockPosition var12 = var10.getPosition();
            if(this.e(var12) && this.N.a(var12)) {
               try {
                  ((ITickAble)var10).tick();
               } catch (Throwable var7) {
                  class_b var16 = class_b.a(var7, "Ticking block entity");
                  class_c var6 = var16.a("Block entity being ticked");
                  var10.a(var6);
                  throw new class_e(var16);
               }
            }
         }

         if(var10.isInvalid()) {
            var15.remove();
            this.h.remove(var10);
            if(this.e(var10.getPosition())) {
               this.f(var10.getPosition()).e(var10.getPosition());
            }
         }
      }

      this.M = false;
      if(!this.c.isEmpty()) {
         this.i.removeAll(this.c);
         this.h.removeAll(this.c);
         this.c.clear();
      }

      this.B.c("pendingBlockEntities");
      if(!this.b.isEmpty()) {
         for(int var11 = 0; var11 < this.b.size(); ++var11) {
            TileEntity var13 = (TileEntity)this.b.get(var11);
            if(!var13.isInvalid()) {
               if(!this.h.contains(var13)) {
                  this.a(var13);
               }

               if(this.e(var13.getPosition())) {
                  this.f(var13.getPosition()).a(var13.getPosition(), var13);
               }

               this.h(var13.getPosition());
            }
         }

         this.b.clear();
      }

      this.B.b();
      this.B.b();
   }

   public boolean a(TileEntity var1) {
      boolean var2 = this.h.add(var1);
      if(var2 && var1 instanceof ITickAble) {
         this.i.add(var1);
      }

      return var2;
   }

   public void b(Collection var1) {
      if(this.M) {
         this.b.addAll(var1);
      } else {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            TileEntity var3 = (TileEntity)var2.next();
            this.h.add(var3);
            if(var3 instanceof ITickAble) {
               this.i.add(var3);
            }
         }
      }

   }

   public void g(Entity var1) {
      this.a(var1, true);
   }

   public void a(Entity var1, boolean var2) {
      int var3 = MathHelper.floor(var1.s);
      int var4 = MathHelper.floor(var1.u);
      byte var5 = 32;
      if(!var2 || this.a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
         var1.P = var1.s;
         var1.Q = var1.t;
         var1.R = var1.u;
         var1.A = var1.y;
         var1.B = var1.z;
         if(var2 && var1.ad) {
            ++var1.W;
            if(var1.m != null) {
               var1.ak();
            } else {
               var1.t_();
            }
         }

         this.B.a("chunkCheck");
         if(Double.isNaN(var1.s) || Double.isInfinite(var1.s)) {
            var1.s = var1.P;
         }

         if(Double.isNaN(var1.t) || Double.isInfinite(var1.t)) {
            var1.t = var1.Q;
         }

         if(Double.isNaN(var1.u) || Double.isInfinite(var1.u)) {
            var1.u = var1.R;
         }

         if(Double.isNaN((double)var1.z) || Double.isInfinite((double)var1.z)) {
            var1.z = var1.B;
         }

         if(Double.isNaN((double)var1.y) || Double.isInfinite((double)var1.y)) {
            var1.y = var1.A;
         }

         int var6 = MathHelper.floor(var1.s / 16.0D);
         int var7 = MathHelper.floor(var1.t / 16.0D);
         int var8 = MathHelper.floor(var1.u / 16.0D);
         if(!var1.ad || var1.ae != var6 || var1.af != var7 || var1.ag != var8) {
            if(var1.ad && this.a(var1.ae, var1.ag, true)) {
               this.a(var1.ae, var1.ag).a(var1, var1.af);
            }

            if(this.a(var6, var8, true)) {
               var1.ad = true;
               this.a(var6, var8).a(var1);
            } else {
               var1.ad = false;
            }
         }

         this.B.b();
         if(var2 && var1.ad && var1.l != null) {
            if(!var1.l.I && var1.l.m == var1) {
               this.g(var1.l);
            } else {
               var1.l.m = null;
               var1.l = null;
            }
         }

      }
   }

   public boolean b(AxisAlignedBB var1) {
      return this.a((AxisAlignedBB)var1, (Entity)null);
   }

   public boolean a(AxisAlignedBB var1, Entity var2) {
      List var3 = this.b((Entity)null, (AxisAlignedBB)var1);

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         Entity var5 = (Entity)var3.get(var4);
         if(!var5.I && var5.k && var5 != var2 && (var2 == null || var2.m != var5 && var2.l != var5)) {
            return false;
         }
      }

      return true;
   }

   public boolean c(AxisAlignedBB var1) {
      int var2 = MathHelper.floor(var1.xMin);
      int var3 = MathHelper.floor(var1.xMax);
      int var4 = MathHelper.floor(var1.yMin);
      int var5 = MathHelper.floor(var1.yMax);
      int var6 = MathHelper.floor(var1.zMin);
      int var7 = MathHelper.floor(var1.zMax);
      BlockPosition.MutableBlockPosition var8 = new BlockPosition.MutableBlockPosition();

      for(int var9 = var2; var9 <= var3; ++var9) {
         for(int var10 = var4; var10 <= var5; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
               Block var12 = this.getType(var8.setPosition(var9, var10, var11)).getBlock();
               if(var12.getMaterial() != Material.AIR) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean d(AxisAlignedBB var1) {
      int var2 = MathHelper.floor(var1.xMin);
      int var3 = MathHelper.floor(var1.xMax);
      int var4 = MathHelper.floor(var1.yMin);
      int var5 = MathHelper.floor(var1.yMax);
      int var6 = MathHelper.floor(var1.zMin);
      int var7 = MathHelper.floor(var1.zMax);
      BlockPosition.MutableBlockPosition var8 = new BlockPosition.MutableBlockPosition();

      for(int var9 = var2; var9 <= var3; ++var9) {
         for(int var10 = var4; var10 <= var5; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
               Block var12 = this.getType(var8.setPosition(var9, var10, var11)).getBlock();
               if(var12.getMaterial().isLiquid()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean e(AxisAlignedBB var1) {
      int var2 = MathHelper.floor(var1.xMin);
      int var3 = MathHelper.floor(var1.xMax + 1.0D);
      int var4 = MathHelper.floor(var1.yMin);
      int var5 = MathHelper.floor(var1.yMax + 1.0D);
      int var6 = MathHelper.floor(var1.zMin);
      int var7 = MathHelper.floor(var1.zMax + 1.0D);
      if(this.a(var2, var4, var6, var3, var5, var7, true)) {
         BlockPosition.MutableBlockPosition var8 = new BlockPosition.MutableBlockPosition();

         for(int var9 = var2; var9 < var3; ++var9) {
            for(int var10 = var4; var10 < var5; ++var10) {
               for(int var11 = var6; var11 < var7; ++var11) {
                  Block var12 = this.getType(var8.setPosition(var9, var10, var11)).getBlock();
                  if(var12 == Blocks.FIRE || var12 == Blocks.FLOWING_LAVA || var12 == Blocks.LAVA) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean a(AxisAlignedBB var1, Material var2, Entity var3) {
      int var4 = MathHelper.floor(var1.xMin);
      int var5 = MathHelper.floor(var1.xMax + 1.0D);
      int var6 = MathHelper.floor(var1.yMin);
      int var7 = MathHelper.floor(var1.yMax + 1.0D);
      int var8 = MathHelper.floor(var1.zMin);
      int var9 = MathHelper.floor(var1.zMax + 1.0D);
      if(!this.a(var4, var6, var8, var5, var7, var9, true)) {
         return false;
      } else {
         boolean var10 = false;
         Vec3D var11 = new Vec3D(0.0D, 0.0D, 0.0D);
         BlockPosition.MutableBlockPosition var12 = new BlockPosition.MutableBlockPosition();

         for(int var13 = var4; var13 < var5; ++var13) {
            for(int var14 = var6; var14 < var7; ++var14) {
               for(int var15 = var8; var15 < var9; ++var15) {
                  var12.setPosition(var13, var14, var15);
                  IBlockData var16 = this.getType(var12);
                  Block var17 = var16.getBlock();
                  if(var17.getMaterial() == var2) {
                     double var18 = (double)((float)(var14 + 1) - BlockFluids.b(((Integer)var16.get(BlockFluids.LEVEL)).intValue()));
                     if((double)var7 >= var18) {
                        var10 = true;
                        var11 = var17.modifyVelocity((World)this, var12, (Entity)var3, (Vec3D)var11);
                     }
                  }
               }
            }
         }

         if(var11.length() > 0.0D && var3.aN()) {
            var11 = var11.normalize();
            double var20 = 0.014D;
            var3.v += var11.x * var20;
            var3.motY += var11.y * var20;
            var3.x += var11.z * var20;
         }

         return var10;
      }
   }

   public boolean a(AxisAlignedBB var1, Material var2) {
      int var3 = MathHelper.floor(var1.xMin);
      int var4 = MathHelper.floor(var1.xMax + 1.0D);
      int var5 = MathHelper.floor(var1.yMin);
      int var6 = MathHelper.floor(var1.yMax + 1.0D);
      int var7 = MathHelper.floor(var1.zMin);
      int var8 = MathHelper.floor(var1.zMax + 1.0D);
      BlockPosition.MutableBlockPosition var9 = new BlockPosition.MutableBlockPosition();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var5; var11 < var6; ++var11) {
            for(int var12 = var7; var12 < var8; ++var12) {
               if(this.getType(var9.setPosition(var10, var11, var12)).getBlock().getMaterial() == var2) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean b(AxisAlignedBB var1, Material var2) {
      int var3 = MathHelper.floor(var1.xMin);
      int var4 = MathHelper.floor(var1.xMax + 1.0D);
      int var5 = MathHelper.floor(var1.yMin);
      int var6 = MathHelper.floor(var1.yMax + 1.0D);
      int var7 = MathHelper.floor(var1.zMin);
      int var8 = MathHelper.floor(var1.zMax + 1.0D);
      BlockPosition.MutableBlockPosition var9 = new BlockPosition.MutableBlockPosition();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var5; var11 < var6; ++var11) {
            for(int var12 = var7; var12 < var8; ++var12) {
               IBlockData var13 = this.getType(var9.setPosition(var10, var11, var12));
               Block var14 = var13.getBlock();
               if(var14.getMaterial() == var2) {
                  int var15 = ((Integer)var13.get(BlockFluids.LEVEL)).intValue();
                  double var16 = (double)(var11 + 1);
                  if(var15 < 8) {
                     var16 = (double)(var11 + 1) - (double)var15 / 8.0D;
                  }

                  if(var16 >= var1.yMin) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public Explosion a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
      return this.createExplosion(var1, var2, var4, var6, var8, false, var9);
   }

   public Explosion createExplosion(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      Explosion var11 = new Explosion(this, var1, var2, var4, var6, var8, var9, var10);
      var11.doStage1();
      var11.doStage2(true);
      return var11;
   }

   public float a(Vec3D var1, AxisAlignedBB var2) {
      double var3 = 1.0D / ((var2.xMax - var2.xMin) * 2.0D + 1.0D);
      double var5 = 1.0D / ((var2.yMax - var2.yMin) * 2.0D + 1.0D);
      double var7 = 1.0D / ((var2.zMax - var2.zMin) * 2.0D + 1.0D);
      double var9 = (1.0D - Math.floor(1.0D / var3) * var3) / 2.0D;
      double var11 = (1.0D - Math.floor(1.0D / var7) * var7) / 2.0D;
      if(var3 >= 0.0D && var5 >= 0.0D && var7 >= 0.0D) {
         int var13 = 0;
         int var14 = 0;

         for(float var15 = 0.0F; var15 <= 1.0F; var15 = (float)((double)var15 + var3)) {
            for(float var16 = 0.0F; var16 <= 1.0F; var16 = (float)((double)var16 + var5)) {
               for(float var17 = 0.0F; var17 <= 1.0F; var17 = (float)((double)var17 + var7)) {
                  double var18 = var2.xMin + (var2.xMax - var2.xMin) * (double)var15;
                  double var20 = var2.yMin + (var2.yMax - var2.yMin) * (double)var16;
                  double var22 = var2.zMin + (var2.zMax - var2.zMin) * (double)var17;
                  if(this.a(new Vec3D(var18 + var9, var20, var22 + var11), var1) == null) {
                     ++var13;
                  }

                  ++var14;
               }
            }
         }

         return (float)var13 / (float)var14;
      } else {
         return 0.0F;
      }
   }

   public boolean a(EntityHuman var1, BlockPosition var2, EnumDirection var3) {
      var2 = var2.shift(var3);
      if(this.getType(var2).getBlock() == Blocks.FIRE) {
         this.a(var1, 1004, var2, 0);
         this.setAir(var2);
         return true;
      } else {
         return false;
      }
   }

   public TileEntity getTileEntity(BlockPosition var1) {
      if(!this.a(var1)) {
         return null;
      } else {
         TileEntity var2 = null;
         int var3;
         TileEntity var4;
         if(this.M) {
            for(var3 = 0; var3 < this.b.size(); ++var3) {
               var4 = (TileEntity)this.b.get(var3);
               if(!var4.isInvalid() && var4.getPosition().equals(var1)) {
                  var2 = var4;
                  break;
               }
            }
         }

         if(var2 == null) {
            var2 = this.f(var1).a(var1, Chunk.class_a_in_class_aok.a);
         }

         if(var2 == null) {
            for(var3 = 0; var3 < this.b.size(); ++var3) {
               var4 = (TileEntity)this.b.get(var3);
               if(!var4.isInvalid() && var4.getPosition().equals(var1)) {
                  var2 = var4;
                  break;
               }
            }
         }

         return var2;
      }
   }

   public void a(BlockPosition var1, TileEntity var2) {
      if(var2 != null && !var2.isInvalid()) {
         if(this.M) {
            var2.setPosition(var1);
            Iterator var3 = this.b.iterator();

            while(var3.hasNext()) {
               TileEntity var4 = (TileEntity)var3.next();
               if(var4.getPosition().equals(var1)) {
                  var4.setInvalid();
                  var3.remove();
               }
            }

            this.b.add(var2);
         } else {
            this.a(var2);
            this.f(var1).a(var1, var2);
         }
      }

   }

   public void t(BlockPosition var1) {
      TileEntity var2 = this.getTileEntity(var1);
      if(var2 != null && this.M) {
         var2.setInvalid();
         this.b.remove(var2);
      } else {
         if(var2 != null) {
            this.b.remove(var2);
            this.h.remove(var2);
            this.i.remove(var2);
         }

         this.f(var1).e(var1);
      }

   }

   public void b(TileEntity var1) {
      this.c.add(var1);
   }

   public boolean u(BlockPosition var1) {
      IBlockData var2 = this.getType(var1);
      AxisAlignedBB var3 = var2.getBlock().getBoundingBox(this, var1, var2);
      return var3 != null && var3.a() >= 1.0D;
   }

   public static boolean a(IBlockAccess var0, BlockPosition var1) {
      IBlockData var2 = var0.getType(var1);
      Block var3 = var2.getBlock();
      return var3.getMaterial().isOpaque() && var3.isFullCube()?true:(var3 instanceof BlockStairs?var2.get(BlockStairs.b) == BlockStairs.EnumHalf.TOP:(var3 instanceof BlockStepAbstract?var2.get(BlockStepAbstract.HALF) == BlockStepAbstract.EnumSlabHalf.TOP:(var3 instanceof class_aiu?true:(var3 instanceof class_aky?((Integer)var2.get(class_aky.a)).intValue() == 7:false))));
   }

   public boolean d(BlockPosition var1, boolean var2) {
      if(!this.a(var1)) {
         return var2;
      } else {
         Chunk var3 = this.v.a(var1);
         if(var3.f()) {
            return var2;
         } else {
            Block var4 = this.getType(var1).getBlock();
            return var4.getMaterial().isOpaque() && var4.isFullCube();
         }
      }
   }

   public void C() {
      int var1 = this.a(1.0F);
      if(var1 != this.I) {
         this.I = var1;
      }

   }

   public void a(boolean var1, boolean var2) {
      this.F = var1;
      this.G = var2;
   }

   public void d() {
      this.q();
   }

   protected void D() {
      if(this.x.p()) {
         this.p = 1.0F;
         if(this.x.n()) {
            this.r = 1.0F;
         }
      }

   }

   protected void q() {
      if(!this.worldProvider.m()) {
         if(!this.isClientSide) {
            int var1 = this.x.A();
            if(var1 > 0) {
               --var1;
               this.x.i(var1);
               this.x.f(this.x.n()?1:2);
               this.x.g(this.x.p()?1:2);
            }

            int var2 = this.x.o();
            if(var2 <= 0) {
               if(this.x.n()) {
                  this.x.f(this.random.nextInt(12000) + 3600);
               } else {
                  this.x.f(this.random.nextInt(168000) + 12000);
               }
            } else {
               --var2;
               this.x.f(var2);
               if(var2 <= 0) {
                  this.x.a(!this.x.n());
               }
            }

            this.q = this.r;
            if(this.x.n()) {
               this.r = (float)((double)this.r + 0.01D);
            } else {
               this.r = (float)((double)this.r - 0.01D);
            }

            this.r = MathHelper.clamp(this.r, 0.0F, 1.0F);
            int var3 = this.x.q();
            if(var3 <= 0) {
               if(this.x.p()) {
                  this.x.g(this.random.nextInt(12000) + 12000);
               } else {
                  this.x.g(this.random.nextInt(168000) + 12000);
               }
            } else {
               --var3;
               this.x.g(var3);
               if(var3 <= 0) {
                  this.x.b(!this.x.p());
               }
            }

            this.o = this.p;
            if(this.x.p()) {
               this.p = (float)((double)this.p + 0.01D);
            } else {
               this.p = (float)((double)this.p - 0.01D);
            }

            this.p = MathHelper.clamp(this.p, 0.0F, 1.0F);
         }
      }
   }

   protected void E() {
      this.E.clear();
      this.B.a("buildList");

      int var1;
      EntityHuman var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < this.players.size(); ++var1) {
         var2 = (EntityHuman)this.players.get(var1);
         var3 = MathHelper.floor(var2.s / 16.0D);
         var4 = MathHelper.floor(var2.u / 16.0D);
         var5 = this.r();

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.E.add(new class_aeh(var6 + var3, var7 + var4));
            }
         }
      }

      this.B.b();
      if(this.L > 0) {
         --this.L;
      }

      this.B.a("playerCheckLight");
      if(!this.players.isEmpty()) {
         var1 = this.random.nextInt(this.players.size());
         var2 = (EntityHuman)this.players.get(var1);
         var3 = MathHelper.floor(var2.s) + this.random.nextInt(11) - 5;
         var4 = MathHelper.floor(var2.t) + this.random.nextInt(11) - 5;
         var5 = MathHelper.floor(var2.u) + this.random.nextInt(11) - 5;
         this.x(new BlockPosition(var3, var4, var5));
      }

      this.B.b();
   }

   protected abstract int r();

   protected void a(int var1, int var2, Chunk var3) {
      this.B.c("moodSound");
      if(this.L == 0 && !this.isClientSide) {
         this.m = this.m * 3 + 1013904223;
         int var4 = this.m >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 255;
         BlockPosition var8 = new BlockPosition(var5, var7, var6);
         Block var9 = var3.a(var8);
         var5 += var1;
         var6 += var2;
         if(var9.getMaterial() == Material.AIR && this.k(var8) <= this.random.nextInt(8) && this.b(class_aet.a, var8) <= 0) {
            EntityHuman var10 = this.a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if(var10 != null && var10.e((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.random.nextFloat() * 0.2F);
               this.L = this.random.nextInt(12000) + 6000;
            }
         }
      }

      this.B.c("checkLight");
      var3.m();
   }

   protected void i() {
      this.E();
   }

   public void a(Block var1, BlockPosition var2, Random var3) {
      this.e = true;
      var1.tick(this, var2, this.getType(var2), var3);
      this.e = false;
   }

   public boolean v(BlockPosition var1) {
      return this.e(var1, false);
   }

   public boolean w(BlockPosition var1) {
      return this.e(var1, true);
   }

   public boolean e(BlockPosition var1, boolean var2) {
      BiomeBase var3 = this.b(var1);
      float var4 = var3.a(var1);
      if(var4 > 0.15F) {
         return false;
      } else {
         if(var1.getY() >= 0 && var1.getY() < 256 && this.b(class_aet.b, var1) < 10) {
            IBlockData var5 = this.getType(var1);
            Block var6 = var5.getBlock();
            if((var6 == Blocks.WATER || var6 == Blocks.FLOWING_WATER) && ((Integer)var5.get(BlockFluids.LEVEL)).intValue() == 0) {
               if(!var2) {
                  return true;
               }

               boolean var7 = this.F(var1.west()) && this.F(var1.east()) && this.F(var1.north()) && this.F(var1.south());
               if(!var7) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private boolean F(BlockPosition var1) {
      return this.getType(var1).getBlock().getMaterial() == Material.WATER;
   }

   public boolean f(BlockPosition var1, boolean var2) {
      BiomeBase var3 = this.b(var1);
      float var4 = var3.a(var1);
      if(var4 > 0.15F) {
         return false;
      } else if(!var2) {
         return true;
      } else {
         if(var1.getY() >= 0 && var1.getY() < 256 && this.b(class_aet.b, var1) < 10) {
            Block var5 = this.getType(var1).getBlock();
            if(var5.getMaterial() == Material.AIR && Blocks.SNOW_LAYER.canPlace(this, var1)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean x(BlockPosition var1) {
      boolean var2 = false;
      if(!this.worldProvider.m()) {
         var2 |= this.c(class_aet.a, var1);
      }

      var2 |= this.c(class_aet.b, var1);
      return var2;
   }

   private int a(BlockPosition var1, class_aet var2) {
      if(var2 == class_aet.a && this.i(var1)) {
         return 15;
      } else {
         Block var3 = this.getType(var1).getBlock();
         int var4 = var2 == class_aet.a?0:var3.getLightLevel();
         int var5 = var3.getLightOpacity();
         if(var5 >= 15 && var3.getLightLevel() > 0) {
            var5 = 1;
         }

         if(var5 < 1) {
            var5 = 1;
         }

         if(var5 >= 15) {
            return 0;
         } else if(var4 >= 14) {
            return var4;
         } else {
            EnumDirection[] var6 = EnumDirection.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               EnumDirection var9 = var6[var8];
               BlockPosition var10 = var1.shift(var9);
               int var11 = this.b(var2, var10) - var5;
               if(var11 > var4) {
                  var4 = var11;
               }

               if(var4 >= 14) {
                  return var4;
               }
            }

            return var4;
         }
      }
   }

   public boolean c(class_aet var1, BlockPosition var2) {
      if(!this.a(var2, 17, false)) {
         return false;
      } else {
         int var3 = 0;
         int var4 = 0;
         this.B.a("getBrightness");
         int var5 = this.b(var1, var2);
         int var6 = this.a(var2, var1);
         int var7 = var2.getX();
         int var8 = var2.getY();
         int var9 = var2.getZ();
         int var10;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         int var18;
         int var19;
         if(var6 > var5) {
            this.H[var4++] = 133152;
         } else if(var6 < var5) {
            this.H[var4++] = 133152 | var5 << 18;

            label90:
            while(true) {
               int var14;
               do {
                  do {
                     BlockPosition var15;
                     do {
                        if(var3 >= var4) {
                           var3 = 0;
                           break label90;
                        }

                        var10 = this.H[var3++];
                        var11 = (var10 & 63) - 32 + var7;
                        var12 = (var10 >> 6 & 63) - 32 + var8;
                        var13 = (var10 >> 12 & 63) - 32 + var9;
                        var14 = var10 >> 18 & 15;
                        var15 = new BlockPosition(var11, var12, var13);
                        var16 = this.b(var1, var15);
                     } while(var16 != var14);

                     this.a((class_aet)var1, (BlockPosition)var15, 0);
                  } while(var14 <= 0);

                  var17 = MathHelper.abs(var11 - var7);
                  var18 = MathHelper.abs(var12 - var8);
                  var19 = MathHelper.abs(var13 - var9);
               } while(var17 + var18 + var19 >= 17);

               BlockPosition.MutableBlockPosition var20 = new BlockPosition.MutableBlockPosition();
               EnumDirection[] var21 = EnumDirection.values();
               int var22 = var21.length;

               for(int var23 = 0; var23 < var22; ++var23) {
                  EnumDirection var24 = var21[var23];
                  int var25 = var11 + var24.getAdjacentX();
                  int var26 = var12 + var24.getAdjacentY();
                  int var27 = var13 + var24.getAdjacentZ();
                  var20.setPosition(var25, var26, var27);
                  int var28 = Math.max(1, this.getType(var20).getBlock().getLightOpacity());
                  var16 = this.b((class_aet)var1, (BlockPosition)var20);
                  if(var16 == var14 - var28 && var4 < this.H.length) {
                     this.H[var4++] = var25 - var7 + 32 | var26 - var8 + 32 << 6 | var27 - var9 + 32 << 12 | var14 - var28 << 18;
                  }
               }
            }
         }

         this.B.b();
         this.B.a("checkedPosition < toCheckCount");

         while(var3 < var4) {
            var10 = this.H[var3++];
            var11 = (var10 & 63) - 32 + var7;
            var12 = (var10 >> 6 & 63) - 32 + var8;
            var13 = (var10 >> 12 & 63) - 32 + var9;
            BlockPosition var29 = new BlockPosition(var11, var12, var13);
            int var30 = this.b(var1, var29);
            var16 = this.a(var29, var1);
            if(var16 != var30) {
               this.a(var1, var29, var16);
               if(var16 > var30) {
                  var17 = Math.abs(var11 - var7);
                  var18 = Math.abs(var12 - var8);
                  var19 = Math.abs(var13 - var9);
                  boolean var31 = var4 < this.H.length - 6;
                  if(var17 + var18 + var19 < 17 && var31) {
                     if(this.b(var1, var29.west()) < var16) {
                        this.H[var4++] = var11 - 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.east()) < var16) {
                        this.H[var4++] = var11 + 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.down()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.up()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 + 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.north()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - 1 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.south()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 + 1 - var9 + 32 << 12);
                     }
                  }
               }
            }
         }

         this.B.b();
         return true;
      }
   }

   public boolean a(boolean var1) {
      return false;
   }

   public List a(Chunk var1, boolean var2) {
      return null;
   }

   public List a(class_arw var1, boolean var2) {
      return null;
   }

   public List b(Entity var1, AxisAlignedBB var2) {
      return this.a(var1, var2, class_pv.d);
   }

   public List a(Entity var1, AxisAlignedBB var2, Predicate var3) {
      ArrayList var4 = Lists.newArrayList();
      int var5 = MathHelper.floor((var2.xMin - 2.0D) / 16.0D);
      int var6 = MathHelper.floor((var2.xMax + 2.0D) / 16.0D);
      int var7 = MathHelper.floor((var2.zMin - 2.0D) / 16.0D);
      int var8 = MathHelper.floor((var2.zMax + 2.0D) / 16.0D);

      for(int var9 = var5; var9 <= var6; ++var9) {
         for(int var10 = var7; var10 <= var8; ++var10) {
            if(this.a(var9, var10, true)) {
               this.a(var9, var10).a((Entity)var1, var2, var4, var3);
            }
         }
      }

      return var4;
   }

   public List a(Class var1, Predicate var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.f.iterator();

      while(var4.hasNext()) {
         Entity var5 = (Entity)var4.next();
         if(var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List b(Class var1, Predicate var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.players.iterator();

      while(var4.hasNext()) {
         Entity var5 = (Entity)var4.next();
         if(var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public <T> List<T> getEntities(Class<T> entityClass, AxisAlignedBB bb) {
      return this.a(entityClass, bb, class_pv.d);
   }

   public List a(Class var1, AxisAlignedBB var2, Predicate var3) {
      int var4 = MathHelper.floor((var2.xMin - 2.0D) / 16.0D);
      int var5 = MathHelper.floor((var2.xMax + 2.0D) / 16.0D);
      int var6 = MathHelper.floor((var2.zMin - 2.0D) / 16.0D);
      int var7 = MathHelper.floor((var2.zMax + 2.0D) / 16.0D);
      ArrayList var8 = Lists.newArrayList();

      for(int var9 = var4; var9 <= var5; ++var9) {
         for(int var10 = var6; var10 <= var7; ++var10) {
            if(this.a(var9, var10, true)) {
               this.a(var9, var10).a((Class)var1, var2, var8, var3);
            }
         }
      }

      return var8;
   }

   public Entity a(Class var1, AxisAlignedBB var2, Entity var3) {
      List var4 = this.getEntities(var1, var2);
      Entity var5 = null;
      double var6 = Double.MAX_VALUE;

      for(int var8 = 0; var8 < var4.size(); ++var8) {
         Entity var9 = (Entity)var4.get(var8);
         if(var9 != var3 && class_pv.d.apply(var9)) {
            double var10 = var3.h(var9);
            if(var10 <= var6) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   public Entity getEntityById(int var1) {
      return (Entity)this.l.a(var1);
   }

   public void b(BlockPosition var1, TileEntity var2) {
      if(this.e(var1)) {
         this.f(var1).e();
      }

   }

   public int a(Class var1) {
      int var2 = 0;
      Iterator var3 = this.f.iterator();

      while(true) {
         Entity var4;
         do {
            if(!var3.hasNext()) {
               return var2;
            }

            var4 = (Entity)var3.next();
         } while(var4 instanceof class_qb && ((class_qb)var4).cn());

         if(var1.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }
   }

   public void a(Collection var1) {
      this.f.addAll(var1);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Entity var3 = (Entity)var2.next();
         this.b(var3);
      }

   }

   public void c(Collection var1) {
      this.g.addAll(var1);
   }

   public boolean a(Block var1, BlockPosition var2, boolean var3, EnumDirection var4, Entity var5, ItemStack var6) {
      Block var7 = this.getType(var2).getBlock();
      AxisAlignedBB var8 = var3?null:var1.getBoundingBox(this, var2, var1.getBlockData());
      return var8 != null && !this.a(var8, var5)?false:(var7.getMaterial() == Material.ORIENTABLE && var1 == Blocks.ANVIL?true:var7.getMaterial().isReplaceable() && var1.canPlace(this, var2, var4, var6));
   }

   public int G() {
      return this.a;
   }

   public void b(int var1) {
      this.a = var1;
   }

   public int a(BlockPosition var1, EnumDirection var2) {
      IBlockData var3 = this.getType(var1);
      return var3.getBlock().b((IBlockAccess)this, var1, var3, (EnumDirection)var2);
   }

   public class_aes H() {
      return this.x.u();
   }

   public int y(BlockPosition var1) {
      byte var2 = 0;
      int var3 = Math.max(var2, this.a(var1.down(), EnumDirection.DOWN));
      if(var3 >= 15) {
         return var3;
      } else {
         var3 = Math.max(var3, this.a(var1.up(), EnumDirection.UP));
         if(var3 >= 15) {
            return var3;
         } else {
            var3 = Math.max(var3, this.a(var1.north(), EnumDirection.NORTH));
            if(var3 >= 15) {
               return var3;
            } else {
               var3 = Math.max(var3, this.a(var1.south(), EnumDirection.SOUTH));
               if(var3 >= 15) {
                  return var3;
               } else {
                  var3 = Math.max(var3, this.a(var1.west(), EnumDirection.WEST));
                  if(var3 >= 15) {
                     return var3;
                  } else {
                     var3 = Math.max(var3, this.a(var1.east(), EnumDirection.EAST));
                     return var3 >= 15?var3:var3;
                  }
               }
            }
         }
      }
   }

   public boolean b(BlockPosition var1, EnumDirection var2) {
      return this.c(var1, var2) > 0;
   }

   public int c(BlockPosition var1, EnumDirection var2) {
      IBlockData var3 = this.getType(var1);
      Block var4 = var3.getBlock();
      return var4.isOccluding()?this.y(var1):var4.a((IBlockAccess)this, var1, (IBlockData)var3, (EnumDirection)var2);
   }

   public boolean isBlockIndirectlyPowered(BlockPosition var1) {
      return this.c(var1.down(), EnumDirection.DOWN) > 0?true:(this.c(var1.up(), EnumDirection.UP) > 0?true:(this.c(var1.north(), EnumDirection.NORTH) > 0?true:(this.c(var1.south(), EnumDirection.SOUTH) > 0?true:(this.c(var1.west(), EnumDirection.WEST) > 0?true:this.c(var1.east(), EnumDirection.EAST) > 0))));
   }

   public int A(BlockPosition var1) {
      int var2 = 0;
      EnumDirection[] var3 = EnumDirection.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumDirection var6 = var3[var5];
         int var7 = this.c(var1.shift(var6), var6);
         if(var7 >= 15) {
            return 15;
         }

         if(var7 > var2) {
            var2 = var7;
         }
      }

      return var2;
   }

   public EntityHuman a(Entity var1, double var2) {
      return this.a(var1.s, var1.t, var1.u, var2);
   }

   public EntityHuman a(double var1, double var3, double var5, double var7) {
      double var9 = -1.0D;
      EntityHuman var11 = null;

      for(int var12 = 0; var12 < this.players.size(); ++var12) {
         EntityHuman var13 = (EntityHuman)this.players.get(var12);
         if(class_pv.d.apply(var13)) {
            double var14 = var13.e(var1, var3, var5);
            if((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public boolean b(double var1, double var3, double var5, double var7) {
      for(int var9 = 0; var9 < this.players.size(); ++var9) {
         EntityHuman var10 = (EntityHuman)this.players.get(var9);
         if(class_pv.d.apply(var10)) {
            double var11 = var10.e(var1, var3, var5);
            if(var7 < 0.0D || var11 < var7 * var7) {
               return true;
            }
         }
      }

      return false;
   }

   public EntityHuman a(Entity var1, double var2, double var4) {
      return this.a(var1.s, var1.t, var1.u, var2, var4);
   }

   public EntityHuman a(BlockPosition var1, double var2, double var4) {
      return this.a((double)((float)var1.getX() + 0.5F), (double)((float)var1.getY() + 0.5F), (double)((float)var1.getZ() + 0.5F), var2, var4);
   }

   public EntityHuman a(double var1, double var3, double var5, double var7, double var9) {
      double var11 = -1.0D;
      EntityHuman var13 = null;

      for(int var14 = 0; var14 < this.players.size(); ++var14) {
         EntityHuman var15 = (EntityHuman)this.players.get(var14);
         if(!var15.bH.invulnerable && var15.ai() && !var15.v()) {
            double var16 = var15.e(var1, var15.t, var5);
            double var18 = var7;
            if(var15.ax()) {
               var18 = var7 * 0.800000011920929D;
            }

            if(var15.aA()) {
               float var20 = var15.cc();
               if(var20 < 0.1F) {
                  var20 = 0.1F;
               }

               var18 *= (double)(0.7F * var20);
            }

            if((var9 < 0.0D || Math.abs(var15.t - var3) < var9 * var9) && (var7 < 0.0D || var16 < var18 * var18) && (var11 == -1.0D || var16 < var11)) {
               var11 = var16;
               var13 = var15;
            }
         }
      }

      return var13;
   }

   public EntityHuman a(String var1) {
      for(int var2 = 0; var2 < this.players.size(); ++var2) {
         EntityHuman var3 = (EntityHuman)this.players.get(var2);
         if(var1.equals(var3.getName())) {
            return var3;
         }
      }

      return null;
   }

   public EntityHuman b(UUID var1) {
      for(int var2 = 0; var2 < this.players.size(); ++var2) {
         EntityHuman var3 = (EntityHuman)this.players.get(var2);
         if(var1.equals(var3.aM())) {
            return var3;
         }
      }

      return null;
   }

   public void J() throws class_aeo {
      this.w.c();
   }

   public long K() {
      return this.x.b();
   }

   public long L() {
      return this.x.f();
   }

   public long M() {
      return this.x.g();
   }

   public void b(long var1) {
      this.x.c(var1);
   }

   public BlockPosition N() {
      BlockPosition var1 = new BlockPosition(this.x.c(), this.x.d(), this.x.e());
      if(!this.ag().a(var1)) {
         var1 = this.m(new BlockPosition(this.ag().f(), 0.0D, this.ag().g()));
      }

      return var1;
   }

   public void B(BlockPosition var1) {
      this.x.a(var1);
   }

   public boolean a(EntityHuman var1, BlockPosition var2) {
      return true;
   }

   public void a(Entity var1, byte var2) {
   }

   public class_aoh O() {
      return this.v;
   }

   public void c(BlockPosition var1, Block var2, int var3, int var4) {
      var2.a(this, var1, this.getType(var1), var3, var4);
   }

   public class_avo P() {
      return this.w;
   }

   public class_avn Q() {
      return this.x;
   }

   public class_ael R() {
      return this.x.x();
   }

   public void e() {
   }

   public float h(float var1) {
      return (this.q + (this.r - this.q) * var1) * this.j(var1);
   }

   public float j(float var1) {
      return this.o + (this.p - this.o) * var1;
   }

   public boolean S() {
      return (double)this.h(1.0F) > 0.9D;
   }

   public boolean T() {
      return (double)this.j(1.0F) > 0.2D;
   }

   public boolean C(BlockPosition var1) {
      if(!this.T()) {
         return false;
      } else if(!this.i(var1)) {
         return false;
      } else if(this.q(var1).getY() > var1.getY()) {
         return false;
      } else {
         BiomeBase var2 = this.b(var1);
         return var2.d()?false:(this.f(var1, false)?false:var2.e());
      }
   }

   public boolean D(BlockPosition var1) {
      BiomeBase var2 = this.b(var1);
      return var2.f();
   }

   public class_avz U() {
      return this.z;
   }

   public void a(String var1, class_avd var2) {
      this.z.a(var1, var2);
   }

   public class_avd a(Class var1, String var2) {
      return this.z.a(var1, var2);
   }

   public int b(String var1) {
      return this.z.a(var1);
   }

   public void a(int var1, BlockPosition var2, int var3) {
      for(int var4 = 0; var4 < this.u.size(); ++var4) {
         ((class_aep)this.u.get(var4)).a(var1, var2, var3);
      }

   }

   public void b(int var1, BlockPosition var2, int var3) {
      this.a((EntityHuman)null, var1, var2, var3);
   }

   public void a(EntityHuman var1, int var2, BlockPosition var3, int var4) {
      try {
         for(int var5 = 0; var5 < this.u.size(); ++var5) {
            ((class_aep)this.u.get(var5)).a(var1, var2, var3, var4);
         }

      } catch (Throwable var8) {
         class_b var6 = class_b.a(var8, "Playing level event");
         class_c var7 = var6.a("Level event being played");
         var7.a((String)"Block coordinates", (Object)class_c.a(var3));
         var7.a((String)"Event source", (Object)var1);
         var7.a((String)"Event type", (Object)Integer.valueOf(var2));
         var7.a((String)"Event data", (Object)Integer.valueOf(var4));
         throw new class_e(var6);
      }
   }

   public int V() {
      return 256;
   }

   public int W() {
      return this.worldProvider.m()?128:256;
   }

   public Random a(int var1, int var2, int var3) {
      long var4 = (long)var1 * 341873128712L + (long)var2 * 132897987541L + this.Q().b() + (long)var3;
      this.random.setSeed(var4);
      return this.random;
   }

   public BlockPosition a(String var1, BlockPosition var2) {
      return this.O().a(this, var1, var2);
   }

   public class_c a(class_b var1) {
      class_c var2 = var1.a("Affected level", 1);
      var2.a((String)"Level name", (Object)(this.x == null?"????":this.x.k()));
      var2.a("All players", new Callable() {
         public String a() {
            return World.this.players.size() + " total; " + World.this.players.toString();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var2.a("Chunk stats", new Callable() {
         public String a() {
            return World.this.v.f();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });

      try {
         this.x.a(var2);
      } catch (Throwable var4) {
         var2.a("Level Data Unobtainable", var4);
      }

      return var2;
   }

   public void c(int var1, BlockPosition var2, int var3) {
      for(int var4 = 0; var4 < this.u.size(); ++var4) {
         class_aep var5 = (class_aep)this.u.get(var4);
         var5.b(var1, var2, var3);
      }

   }

   public Calendar Z() {
      if(this.L() % 600L == 0L) {
         this.K.setTimeInMillis(MinecraftServer.az());
      }

      return this.K;
   }

   public class_awn aa() {
      return this.C;
   }

   public void e(BlockPosition var1, Block var2) {
      Iterator var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

      while(var3.hasNext()) {
         EnumDirection var4 = (EnumDirection)var3.next();
         BlockPosition var5 = var1.shift(var4);
         if(this.e(var5)) {
            IBlockData var6 = this.getType(var5);
            if(Blocks.UNPOWERED_COMPARATOR.e(var6.getBlock())) {
               var6.getBlock().doPhysics(this, var5, var6, var2);
            } else if(var6.getBlock().isOccluding()) {
               var5 = var5.shift(var4);
               var6 = this.getType(var5);
               if(Blocks.UNPOWERED_COMPARATOR.e(var6.getBlock())) {
                  var6.getBlock().doPhysics(this, var5, var6, var2);
               }
            }
         }
      }

   }

   public class_on E(BlockPosition var1) {
      long var2 = 0L;
      float var4 = 0.0F;
      if(this.e(var1)) {
         var4 = this.z();
         var2 = this.f(var1).w();
      }

      return new class_on(this.ab(), this.M(), var2, var4);
   }

   public class_om ab() {
      return this.Q().y();
   }

   public int ac() {
      return this.I;
   }

   public void c(int var1) {
      this.I = var1;
   }

   public void d(int var1) {
      this.J = var1;
   }

   public boolean ae() {
      return this.y;
   }

   public class_tr af() {
      return this.A;
   }

   public class_aoe ag() {
      return this.N;
   }

   public boolean c(int var1, int var2) {
      BlockPosition var3 = this.N();
      int var4 = var1 * 16 + 8 - var3.getX();
      int var5 = var2 * 16 + 8 - var3.getZ();
      short var6 = 128;
      return var4 >= -var6 && var4 <= var6 && var5 >= -var6 && var5 <= var6;
   }
}
