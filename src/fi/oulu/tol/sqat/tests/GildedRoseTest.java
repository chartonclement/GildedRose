package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));
	
	
 // bug: the brie (as the rule say) need to increase 3 by day like backstage tickets.
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_13() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(13, itemBrie.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_Dexterity_Vest_quality_10_20() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(19, itemVest.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_Dexterity_Vest_quality_0_20() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(18, itemVest.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_Dexterity_Vest_sellin_10_20() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(9, itemVest.getSellIn());
	}
	@Test
	public void testUpdateEndOfDay_Sulfura_quality_0_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemSulfura = items.get(0);
		assertEquals(80, itemSulfura.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_Sulfura_sellin_0_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemSulfura = items.get(0);
		assertEquals(0, itemSulfura.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_concert_quality_0_20() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemConcert = items.get(0);
		assertEquals(23, itemConcert.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_elexir_quality_0_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 0, 1) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElexir = items.get(0);
		assertEquals(0, itemElexir.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_mana_cake_quality_3_6() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 0, 6) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(4, itemCake.getQuality());
	}
}
