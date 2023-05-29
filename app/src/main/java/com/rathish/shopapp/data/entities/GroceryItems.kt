package com.rathish.shopapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GroceryItems")
data class GroceryItems (
  @PrimaryKey(autoGenerate = true) var itemId: Long?,
  @ColumnInfo(name = "shopID") var shopID: Long?,
 @ColumnInfo(name = "shopName") var shopName: String,
  @ColumnInfo(name = "name") var name: String,
  @ColumnInfo(name = "category") var category: String,
  @ColumnInfo(name = "bought") var bought: Boolean,
  @ColumnInfo(name = "itemdescription") var itemDescription: String,
  @ColumnInfo(name = "estimatedprice") var estimatedPrice: String,
)



