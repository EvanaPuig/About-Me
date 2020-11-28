package com.evanamargain.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.evanamargain.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.doneButton.setOnClickListener {
      addNickname(it)
    }
  }

  private fun addNickname(view: View) {
    binding.apply {
      nicknameText.text = nicknameEdit.text
      invalidateAll()
      nicknameEdit.visibility = View.GONE
      view.visibility = View.GONE
      nicknameText.visibility = View.VISIBLE
    }

    // Hide the keyboard
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
  }
}
