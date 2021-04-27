package com.deushdezt.feelings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class EmojiFragment: Fragment() {

    private var feelingTitle = ""
    private var feelingImgId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            feelingTitle = it.getString(TITLE_KEY)?: getString(R.string.no_feeling_text)
            feelingImgId = it.getInt(IMAGE_KEY)?: R.drawable.angry
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.emoji_fragment, container, false).let {
            it.findViewById<TextView>(R.id.emoji_title_text).text = feelingTitle
            it.findViewById<ImageView>(R.id.emoji_image).setBackgroundResource(feelingImgId)
            it
        }
    }

    companion object {
        private const val TITLE_KEY = "title_key"
        private const val IMAGE_KEY = "image_key"

        fun newInstance(feelingTitle: String, feelingImgId: Int) = EmojiFragment().apply {
            arguments = Bundle().apply {
                putString(TITLE_KEY, feelingTitle)
                putInt(IMAGE_KEY, feelingImgId)
            }
        }
    }
}