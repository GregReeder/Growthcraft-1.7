/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 IceDragon200
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package growthcraft.hops.integration.mfr;

import java.util.Map;

import growthcraft.core.integration.mfr.AbstractFactoryHarvestable;
import growthcraft.hops.common.block.BlockHops;
import growthcraft.hops.GrowthCraftHops;

import powercrystals.minefactoryreloaded.api.HarvestType;

import net.minecraft.world.World;

public class HopFactoryHarvester extends AbstractFactoryHarvestable<BlockHops>
{
	public HopFactoryHarvester()
	{
		super();
		setPlant(GrowthCraftHops.hopVine.getBlock());
		setHarvestType(HarvestType.TreeLeaf);
	}

	@Override
	public boolean breakBlock()
	{
		return false;
	}

	@Override
	public boolean canBeHarvested(World world, Map<String, Boolean> harvesterSettings, int x, int y, int z)
	{
		return plantBlock.isMature(world, x, y, z);
	}

	@Override
	public void postHarvest(World world, int x, int y, int z)
	{
		if (plantBlock != null)
			plantBlock.removeFruit(world, x, y, z);
	}
}
