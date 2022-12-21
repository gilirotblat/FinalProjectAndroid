package gilir.finalproject.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gilir.finalproject.models.Person

@Dao
interface PeopleDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(person: Person)

    @Query ("SELECT*FROM people")
    fun getAll(): LiveData<List<Person>>
}