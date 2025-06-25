package me.nycto.ecotech;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class EcoTech extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        /*
         * 1. Creating a new Category
         * This Category will use the following ItemStack
         */
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmJhZGUxYmNlM2E3ZTRjNmI5YzU4ZGE4YzkyNWMzMjQxNjkzZGUyYzRhNjdiYzMxOWQ0NDk1Y2I3MDM3MjhhMiJ9fX0=";
        ItemStack head = SlimefunUtils.getCustomHead(base64);
        ItemStack categoryItem = new CustomItemStack(head, "&4EcoTech");

        // Give your Category a unique id.
        NamespacedKey itemGroupId = new NamespacedKey(this, "ecotech");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, categoryItem);

        /*
         * 2. Create a new SlimefunItemStack
         * This class has many constructors, it is very important
         * that you give each item a unique id.
         */
        SlimefunItemStack slimefunItem = new SlimefunItemStack("ONION_SEEDS", Material.WHEAT_SEEDS, "&4Onion Seeds", "&c+20% Smell");

        /*
         * 3. Creating a Recipe
         * The Recipe is an ItemStack Array with a length of 9.
         * It represents a Shaped Recipe in a 3x3 crafting grid.
         * The machine in which this recipe is crafted in is specified
         * further down as the RecipeType.
         */
        ItemStack[] recipe = { new ItemStack(Material.WATER_BUCKET), null, new ItemStack(Material.WATER_BUCKET), null, new ItemStack(Material.GRASS), null, new ItemStack(Material.BONE_MEAL), null, new ItemStack(Material.BONE_MEAL) };

        /*
         * 4. Registering the Item
         * Now you just have to register the item.
         * RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in
         * which this item is crafted in.
         * Recipe Types from Slimefun itself will automatically add the recipe to that machine.
         */
        SlimefunItem item = new SlimefunItem(itemGroup, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(this);

        // Custom console output
        PluginDescriptionFile pdf = getDescription();
        String version = pdf.getVersion();
        getLogger().info("========================================");
        getLogger().info("EcoTech v" + version + " - Loaded Successfully!");
        getLogger().info("Constructed by Nycto");
        getLogger().info("Successfully loaded custom items and categories.");
        getLogger().info("Want to contribute?: https://github.com/nycto/EcoTech");
        getLogger().info("§6========================================");
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
