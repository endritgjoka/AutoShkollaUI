package com.example.autoshkollaui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

class CustomTitleBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        if (dependency is AppBarLayout) {
            val appBarLayout = dependency
            val collapsingToolbarLayout = findCollapsingToolbarLayout(appBarLayout)
            val toolbar = findToolbar(dependency)
            if (collapsingToolbarLayout != null && toolbar != null) {
                val offset = Math.abs(appBarLayout.totalScrollRange + appBarLayout.top)
                val totalScrollRange = collapsingToolbarLayout.height - toolbar.height
                val percentage = offset.toFloat() / totalScrollRange.toFloat()
                val titleScale = 1.0f - percentage
                child.scaleX = titleScale
                child.scaleY = titleScale
            }
        }
        return true
    }

    private fun findCollapsingToolbarLayout(view: View): CollapsingToolbarLayout? {
        if (view is CollapsingToolbarLayout) {
            return view
        } else if (view is ViewGroup) {
            val count = view.childCount
            for (i in 0 until count) {
                val child = view.getChildAt(i)
                val collapsingToolbarLayout = findCollapsingToolbarLayout(child)
                if (collapsingToolbarLayout != null) {
                    return collapsingToolbarLayout
                }
            }
        }
        return null
    }

    private fun findToolbar(view: View): Toolbar? {
        if (view is Toolbar) {
            return view
        } else if (view is ViewGroup) {
            val count = view.childCount
            for (i in 0 until count) {
                val child = view.getChildAt(i)
                val toolbar = findToolbar(child)
                if (toolbar != null) {
                    return toolbar
                }
            }
        }
        return null
    }
}
