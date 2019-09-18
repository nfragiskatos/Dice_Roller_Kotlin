package com.create.nfraggle.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

/**
 * Created by Nicholas Fragiskatos on 9/11/2019.
 */
object FakeRepository {

    private val _currentRollValue = MutableLiveData<Int>()
    val currentRollValue: LiveData<Int>
        get() = _currentRollValue

    init {
        _currentRollValue.value = 1
    }

    private fun getRandomDiceRoll(): Int = Random.nextInt(6) + 1

    fun rollDice() {
        _currentRollValue.value = getRandomDiceRoll()
    }
}