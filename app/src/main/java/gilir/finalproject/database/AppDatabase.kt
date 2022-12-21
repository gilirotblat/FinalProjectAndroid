package gilir.finalproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gilir.finalproject.database.dao.PeopleDAO
import gilir.finalproject.models.Person

const val DB_NAME = "AppDatabase"
const val DB_VERSION = 1

@Database(entities = [Person::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    //expose the dao's:

    abstract fun peopleDao(): PeopleDAO

    companion object {
        fun create(context: Context): AppDatabase =
            Room
                .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                //if a new version of the app is installed AND db structure was upgraded => delete the db and re-create it
                .fallbackToDestructiveMigration()
                .build()
    }
}
