package io.github.sefiraat.slimetinker.items.parts;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class AxeHead extends AbstractPart {

    public static String getName(String material) {
        return ThemeUtils.ITEM_PART + ThemeUtils.toTitleCase(material) + " Axe Head";
    }

    public static List<String> getLore(String material) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ThemeUtils.PASSIVE + "An axe head. Useless by itself, can be");
        list.add(ThemeUtils.PASSIVE + "made into an axe at the Tinker's table.");
        list.add("");
        list.add(ThemeUtils.CLICK_INFO + "Material : " + ChatColor.WHITE + ThemeUtils.toTitleCase(material));
        return list;
    }

    public ItemStack getStack(String material) {
        ItemStack itemStack = this.getItem().clone();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        im.setLore(getLore(material));
        im.setDisplayName(getName(material));
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Material"), PersistentDataType.STRING, material);
        itemStack.setItemMeta(im);
        return itemStack;
    }

    public static final SlimefunItemStack STACK =
            ThemeUtils.themedItemStack(
                    "PART_AXE_HEAD",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    "Error",
                    ThemeUtils.PASSIVE + "Error"
            );


    public AxeHead(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(SlimeTinker.inst());
    }

}
