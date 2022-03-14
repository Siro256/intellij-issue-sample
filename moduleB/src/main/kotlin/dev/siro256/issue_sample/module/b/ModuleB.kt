package dev.siro256.issue_sample.module.b

import dev.siro256.issue_sample.module.a.TestBlockOne
import dev.siro256.issue_sample.module.a.blockList
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod("modId")
class ModuleB {
    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        blockList(
            TestBlockOne,
            TestBlockTwo
        ).forEach {
            event.registry.register(it.setRegistryName(ResourceLocation("modId", it::class.simpleName!!.lowercase())))
        }
    }
}
