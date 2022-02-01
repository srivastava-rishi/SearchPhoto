package com.example.sunbasetask.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.sunbasetask.R
import com.example.sunbasetask.databinding.ActivityBaseBinding


class BaseActivity : AppCompatActivity() {

    private lateinit var baseBinding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
    }

    fun attachFragment(fragmentHolderLayoutId: Int, fragment: Fragment?, tag: String?) {
        val manager: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = manager.beginTransaction()

        //Hide other fragments
        for (frag in manager.fragments) {
            ft.hide(frag)
        }

        if (manager.findFragmentByTag(tag) == null) { // No fragment in backStack with same tag..
            ft.add(fragmentHolderLayoutId, fragment!!, tag)
            //ft.addToBackStack(tag)
            ft.commit()
        } else {
            //Shows the selected fragment.
            ft.show(manager.findFragmentByTag(tag)!!).commit()
        }

    }
}