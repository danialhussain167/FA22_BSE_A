package com.example.fa22_bse_a.app_local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {

    // select * from tableName
    @Query("select * from login_table")
    fun getAllLogins(): List<LoginEntity>

    @Query("select * from login_table")
    fun getAllLoginsAsFLow(): Flow<List<LoginEntity>>

    @Query("select * from login_table where email=:email Limit 1")
    fun getLoginEntity(email: String): LoginEntity?

    @Insert
    fun insertLoginEntity(loginEntity: LoginEntity)

    @Insert
    fun insertAllLoginEntity(loginEntity: List<LoginEntity>)


}