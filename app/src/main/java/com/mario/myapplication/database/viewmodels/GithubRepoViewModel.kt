package com.mario.myapplication.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mario.myapplication.database.RoomDB
import com.mario.myapplication.database.entities.GithubRepo
import com.mario.myapplication.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: GithubRepoRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDAO()
        repository = GithubRepoRepository(repoDAO)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }

}