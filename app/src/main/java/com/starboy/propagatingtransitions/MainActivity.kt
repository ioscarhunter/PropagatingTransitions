package com.starboy.propagatingtransitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fadeAndSlide = TransitionSet()
            .addTransition(Fade(Fade.IN)
                    .setInterpolator { (it - 0.5f) * 2 })
            .addTransition(Slide(Gravity.BOTTOM))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        PropagatingTransition(rootView = scrollView,
                startingView = null,
                transition = fadeAndSlide,
                duration = 2000
        )
                .start()
    }
}
