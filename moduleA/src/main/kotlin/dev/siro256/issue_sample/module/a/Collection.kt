package dev.siro256.issue_sample.module.a

import net.minecraft.world.level.block.Block

fun <T> blockList(vararg elements: T): List<T>
        where T: Block
        = if (elements.isNotEmpty()) elements.toList() else emptyList()
