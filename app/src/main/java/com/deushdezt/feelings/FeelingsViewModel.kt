package com.deushdezt.feelings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeelingsViewModel: ViewModel() {
    private var _current = MutableLiveData<Int>()
    val current: LiveData<Int>
        get() = _current

    private val emojiList: List<FeelingInfo> = listOf(
        FeelingInfo(R.string.feeling_happy, R.drawable.happy),
        FeelingInfo(R.string.feeling_angry, R.drawable.angry),
        FeelingInfo(R.string.feeling_confused, R.drawable.confused),
        FeelingInfo(R.string.feeling_crying, R.drawable.crying),
        FeelingInfo(R.string.feeling_inlove, R.drawable.inlove),
        FeelingInfo(R.string.feeling_pain, R.drawable.pain),
        FeelingInfo(R.string.feeling_sad, R.drawable.sad),
        FeelingInfo(R.string.feeling_scared, R.drawable.scared),
        FeelingInfo(R.string.feeling_shocked, R.drawable.shocked),
        FeelingInfo(R.string.feeling_smiling, R.drawable.smiling),
    )

    init {
        _current.value= 0
    }

    fun onNext () {
        _current.apply {
            value = value?.plus(1)?.coerceIn(0, emojiList.lastIndex)
        }
    }

    fun onPrevious () {
        _current.apply {
            value = value?.minus(1)?.coerceIn(0, emojiList.lastIndex)
        }
    }

    fun getFeelingInfo(index: Int) = emojiList[index.coerceIn(0, emojiList.lastIndex)]
    fun getListLI() = emojiList.lastIndex

    data class FeelingInfo (val title: Int, val image: Int)
}