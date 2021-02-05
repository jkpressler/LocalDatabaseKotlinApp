package com.example.firstkotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)                      //set the main_activity xml with frame layout

        replaceFragment(HomeFragment.newInstance(),false)   //pass in the home_fragment into the frame layout

    }

    /**
     * function to pass in new fragment to the frame layout
     * @input: a fragment, in transition boolean
     */
    fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.add(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments        //count of fragments
        if (fragments.size == 0){                               //if there are no fragments
            finish()                                            //finish activity
        }
    }
}