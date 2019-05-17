package com.mario.myapplication.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.mario.myapplication.database.daos.GithubRepoDAO
import com.mario.myapplication.database.entities.GithubRepo

class GithubRepoRepository(private val repoDAO: GithubRepoDAO) {

    fun getAll(): LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GithubRepo) = repoDAO.insert(repo)

}