package com.example.tccapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun setUpHomeToolbar(toolbar: Toolbar, title: String) {
        setSupportActionBar(toolbar)
        supportActionBar.let {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            mToolbar = toolbar
            setTitleToolbar(title)
        }
    }

    protected fun setUpToolbar(toolbar: Toolbar, title: String) {
        setSupportActionBar(toolbar)
        supportActionBar.let {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
//            toolbar.setNavigationIcon(R.drawable.ic_back)
            toolbar.setNavigationOnClickListener { onBackPressed() }
            mToolbar = toolbar
            setTitleToolbar(title)
        }
    }

    fun setTitleToolbar(title: String) {
        try {
//            (mToolbar.findViewById(R.id.toolbar_title) as TextView).text = title
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
