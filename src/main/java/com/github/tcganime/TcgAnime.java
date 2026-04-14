package com.github.tcganime;

import com.github.tcganime.item.BinderItem;
import com.github.tcganime.item.BoosterItem;
import com.github.tcganime.item.CardItem;
import com.github.tcganime.services.CardServices;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(TcgAnime.MODID)
public class TcgAnime {
    // The value here should match an entry in the META-INF/neoforge.mods.toml file
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tcganime";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "tcganime" namespace but we don't have blocks for the moment
    // public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "tcganime" namespace


    //Registering items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Cards
    // Slime dataken
    /*
    public static final DeferredItem<CardItem> LIMULE_SLIME = ITEMS.register("limule_slime",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> RIMURU = ITEMS.register("rimuru",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> RIMURU_ROI = ITEMS.register("rimuru_roi",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> RENGA = ITEMS.register("renga",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> BENIMARU = ITEMS.register("benimaru",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> SHION = ITEMS.register("shion",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> SHUNA = ITEMS.register("shuna",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> VELDRA = ITEMS.register("veldra",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> DIABLO = ITEMS.register("diablo",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> GOBUTA = ITEMS.register("gobuta",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> GABIRU = ITEMS.register("gabiru",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> SHIZU = ITEMS.register("shizu",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> SOUEI = ITEMS.register("souei",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> HAKUROU = ITEMS.register("hakurou",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> KUROBE = ITEMS.register("kurobe",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> MILIM = ITEMS.register("milim",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> RIGURUD = ITEMS.register("rigurud",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> GERUDO = ITEMS.register("gerudo",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> ROUGE = ITEMS.register("rouge",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> CLAYMAN = ITEMS.register("clayman",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> VALENTINA = ITEMS.register("valentina",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> LAMIRIS = ITEMS.register("lamiris",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> LEON = ITEMS.register("leon",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> KARION = ITEMS.register("karion",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> FREY = ITEMS.register("frey",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));
    public static final DeferredItem<CardItem> DINO = ITEMS.register("dino",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.SLIME_DATAKEN));

    // One piece
    public static final DeferredItem<CardItem> LUFFY = ITEMS.register("luffy",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> ZORO = ITEMS.register("zoro",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> SANJI = ITEMS.register("sanji",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> FRANKY = ITEMS.register("franky",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> BROOK = ITEMS.register("brook",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> NAMI = ITEMS.register("nami",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> ROBIN = ITEMS.register("robin",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> JIMBE = ITEMS.register("jimbe",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.COMMON, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> CHOPPER = ITEMS.register("chopper",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> LUFFY_GEAR_5 = ITEMS.register("luffy_gear_5",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> SHANKS = ITEMS.register("shanks",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> BARBE_BLANCHE = ITEMS.register("barbe_blanche",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> BAGGY = ITEMS.register("baggy",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.RARE, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> BARBE_NOIRE = ITEMS.register("barbe_noire",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.LEGENDARY, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> KAIDO = ITEMS.register("kaido",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
    public static final DeferredItem<CardItem> BIG_MOM = ITEMS.register("big_mom",
            () -> new CardItem(new Item.Properties(), CardServices.RarityTier.EPIC, MobEffects.MOVEMENT_SPEED,1, Universe.ONE_PIECE));
*/

















    // Binders
    public static final DeferredItem<BinderItem> CLASSIC_BINDER = ITEMS.register("perona_binder",
            () -> new BinderItem(new Item.Properties()));

    // Booster
    public static final DeferredItem<BoosterItem> CLASSIC_BOOSTER = ITEMS.register("classic_booster",
            () -> new BoosterItem(new Item.Properties()));

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "tcganime" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);




    public TcgAnime(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        // BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }


    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) { // ajout dans la catégorie ingrédient
            // event.accept(Item); nom de l'item
            for (var itemEntry : ITEMS.getEntries()) {
                event.accept(itemEntry.get());
            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}






