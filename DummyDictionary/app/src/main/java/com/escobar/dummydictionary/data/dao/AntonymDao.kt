package com.escobar.dummydictionary.data.dao

import androidx.room.Dao

@Dao
interface AntonymDao {
/*
    @Query("SELECT w.term, w.definition, w.is_fav FROM antonym_table as at INNER JOIN word_table as w ON w.term == at.antonym_term WHERE at.term = :term")
    fun getAllAntonym(term: String): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Antonym)

    @Update
    suspend fun updateWord(word: Antonym)

    @Delete
    suspend fun deleteWord(word: Antonym)


 */

}