package com.farez.gamehub_compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farez.gamehub_compose.data.model.Game
import com.farez.gamehub_compose.data.repository.GameRepository
import kotlinx.coroutines.flow.Flow

class AppViewModel(private val gameRepository: GameRepository) : ViewModel() {

    var cpu: String = ""
        private set
    var ram: String = ""
        private set
    var hdd: String = ""
        private set
    var vga: String = ""
        private set

    fun getGames(): Flow<List<Game>> = gameRepository.getAllGames()

    fun setSpekData(cpu: String, ram: String, hdd: String, vga: String) {
        this.cpu = cpu
        this.ram = ram
        this.hdd = hdd
        this.vga = vga
    }

}


class ViewModelFactory(val gameRepository: GameRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) return AppViewModel(
            gameRepository
        ) as T
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}