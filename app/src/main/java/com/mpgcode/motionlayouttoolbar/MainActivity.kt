package com.mpgcode.motionlayouttoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mpgcode.motionlayouttoolbar.databinding.ActivityMainBinding
import com.mpgcode.motionlayouttoolbar.databinding.ContentHeaderBinding
import com.mpgcode.motionlayouttoolbar.databinding.ContentScrollableBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var headerBinding: ContentHeaderBinding
    private lateinit var scrollingBinding: ContentScrollableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        headerBinding = ContentHeaderBinding.bind(binding.root)
        scrollingBinding = ContentScrollableBinding.bind(binding.root)
        setContentView(binding.root)
        setupToolbar()
    }

    private fun setupToolbar() = with(headerBinding) {
        setSupportActionBar(innerToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Modify value to display back button
        setDisplayHomeAsUpEnabled(true)
    }

    private fun setDisplayHomeAsUpEnabled(isEnabled: Boolean) {
        val initialPadding = headerBinding.collapsedTitle.paddingStart
        val homeAsUpPadding = resources.getDimensionPixelSize(R.dimen.toolbar_home_as_up_padding)

        supportActionBar?.setDisplayHomeAsUpEnabled(isEnabled)

        if (isEnabled) {
            headerBinding.collapsedTitle.setPadding(homeAsUpPadding, 0, initialPadding, 0)
        }
        else {
            headerBinding.collapsedTitle.setPadding(initialPadding, 0, initialPadding, 0)
        }
    }
}
