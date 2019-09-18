package com.create.nfraggle.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


/**
 * Created by Nicholas Fragiskatos on 9/11/2019.
 */
class MainViewModel : ViewModel() {

    val currentRollValue: LiveData<Int>
        get() = FakeRepository.currentRollValue

    fun onRollDice() = FakeRepository.rollDice()
}