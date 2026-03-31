package br.edu.satc.todolistcompose.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY id ASC")
    fun getAllTasks(): Flow<List<TaskData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: TaskData)

    @Update
    suspend fun update(task: TaskData)

    @Query("DELETE FROM tasks WHERE id = :id")
    suspend fun delete(id: Int)
}
