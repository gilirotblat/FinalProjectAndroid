package gilir.finalproject.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "people")
data class Person (
    val name : String,
    @PrimaryKey
    val personId :String=UUID.randomUUID().toString(),
)

fun demo(){

    val p =Person("")
}