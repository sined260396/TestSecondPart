package com.sinelnikov;

public class ShopInventoryManager {
    private Item[] items;

    public ShopInventoryManager(Item[] items) {
        this.items = items;
    }

    private static void increaseQuality(final Item item) {
        final int quality = item.getQuality();
        if (quality < 50) {
            item.setQuality(quality + 1);
        }
    }

    private static void decreaseQuality(final Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.getName().toLowerCase().contains("sulfuras")) {
                continue;
            }
            item.setSellIn(item.getSellIn() - 1);
            if (item.getName().toLowerCase().contains("aged brie")) {
                increaseQuality(item);
            } else if (item.getName().toLowerCase().contains("backstage passes")) {
                increaseQuality(item);
                if (item.getSellIn() <= 10) {
                    increaseQuality(item);
                }
                if (item.getSellIn() <= 5) {
                    increaseQuality(item);
                }
                if (item.getSellIn() <= 0) {
                    item.setQuality(0);
                }
            } else {
                if (item.getSellIn() < 0) {
                    decreaseQuality(item);
                    if (item.getName().toLowerCase().contains("conjured")) {
                        decreaseQuality(item);
                    }
                }
                decreaseQuality(item);
                if (item.getName().toLowerCase().contains("conjured")) {
                    decreaseQuality(item);
                }
            }
            if (item.getQuality() < 0) {
                item.setQuality(0);
            }
        }
    }
}
