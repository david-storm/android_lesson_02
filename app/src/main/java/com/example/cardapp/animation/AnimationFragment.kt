package com.example.cardapp.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.cardapp.R
import com.example.cardapp.customization.CustomizationViewModel
import com.example.cardapp.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment() {


    private val viewModel: CustomizationViewModel by activityViewModels()
    private lateinit var binding: FragmentAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_animation,container,false)

        binding.customizationViewModel = viewModel

//        binding.item.setImageResource(viewModel.item.value!!)

        animation()
        return binding.root
    }

    private fun animation(){
        fadeBackground()
        rotateItem()
        translateAvatar()
    }

    private fun fadeBackground() {
//        binding.background.setBackgroundResource(viewModel.background.value!!)
//        val animator = ObjectAnimator.ofFloat(binding.background, View.ALPHA, 0f, 1f)
//        animator.duration = 2000
//        animator.addListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: Animator?) {
//                fadeTitle()
//                translateText()
//            }
//        })
//        animator.start()
    }

    private fun rotateItem(){
        val animator = ObjectAnimator.ofFloat(binding.item, View.ROTATION, 0f, 360f)
        animator.interpolator = LinearInterpolator()
        animator.duration = 1000
        animator.repeatCount = INFINITE
        animator.start()
    }

    private fun fadeTitle(){
        val animator = ObjectAnimator.ofFloat(binding.title, View.ALPHA, 0f)
        animator.repeatCount = 15
        animator.duration = 100
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    private fun translateAvatar() {
        val animator = ObjectAnimator.ofFloat(binding.avatar, View.TRANSLATION_Y, 500f)
        animator.repeatCount = 1
        animator.duration = 5000
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun translateText() {
        binding.text.visibility = VISIBLE
        val width = binding.background.width
        val animator = ObjectAnimator.ofFloat(binding.text, View.TRANSLATION_X, (width).toFloat(), (-binding.text.width - width).toFloat())
        animator.duration = 5000
        animator.start()
    }
}