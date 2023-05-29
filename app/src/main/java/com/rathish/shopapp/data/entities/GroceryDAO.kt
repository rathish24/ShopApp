package com.rathish.shopapp.data.entities

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface GroceryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: GroceryItems)

    @Delete
    fun delete(item: GroceryItems)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<GroceryItems>>
}