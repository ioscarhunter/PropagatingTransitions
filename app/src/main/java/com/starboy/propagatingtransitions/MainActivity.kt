package com.starboy.propagatingtransitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionSet
import android.view.Gravity
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            ItemModel(R.drawable.animal, "A Pink Background", "Dog"),
            ItemModel(R.drawable.barbeque, "Grill Time!", "Jordan"),
            ItemModel(R.drawable.beach, "Happy Woman", "Sarah"),
            ItemModel(R.drawable.book, "Open Book", "清水翔太"),
            ItemModel(R.drawable.chlorophyll, "Green Tea", "Jerry"),
            ItemModel(R.drawable.coffee, "----", "Max")
    )

    private val fade = Fade(Fade.IN).setInterpolator(AccelerateDecelerateInterpolator())

    private val slide = Slide(Gravity.BOTTOM)

    private val fadeAndSlide = TransitionSet()
            .addTransition(Fade(Fade.IN)
                    .setInterpolator(AccelerateDecelerateInterpolator()))
            .addTransition(Slide(Gravity.BOTTOM))

    private val explode = Explode()

    private val explodeAndFade = TransitionSet()
            .addTransition(Explode())
            .addTransition(Fade(Fade.IN)
                    .setInterpolator(AccelerateDecelerateInterpolator()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fadeButton.setOnClickListener { animateAllThings(fade) }
        fadeAndSlideButton.setOnClickListener { animateAllThings(fadeAndSlide) }
        slideButton.setOnClickListener { animateAllThings(slide) }
        explodeButton.setOnClickListener { animateAllThings(explode) }
        explodeAndFadeButton.setOnClickListener { animateAllThings(explodeAndFade) }

        recyclerView.adapter = ItemAdapter(items)
    }

    override fun onResume() {
        super.onResume()
        PropagatingTransition(rootView = rootView,
                startingView = null,
                transition = fadeAndSlide,
                duration = 2000
        )
                .start()
    }

    private fun animateAllThings(transition: Transition) {
        val duration = durationEditText.text.takeIf { it.isNotBlank() }
                ?.toString()?.toLong()
                ?: 500
        PropagatingTransition(rootView = recyclerView,
                startingView = null,
                transition = transition,
                duration = duration
        )
                .start()
    }
}
