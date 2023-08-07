package com.example.autoshkollaui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.autoshkollaui.databinding.BottomSheetCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetCategoryFragment : BottomSheetDialogFragment() {

    private lateinit var bottomSheetBinding: BottomSheetCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBinding = BottomSheetCategoryBinding.bind(view)

        bottomSheetBinding.closeBottomSheet.setOnClickListener{
            dismiss()
        }

        var cardView1 = bottomSheetBinding.cardView1
        var imageView1 = bottomSheetBinding.imageView1

        var cardView2 = bottomSheetBinding.cardView2
        var imageView2 = bottomSheetBinding.imageView2

        var cardView3 = bottomSheetBinding.cardView3
        var imageView3 = bottomSheetBinding.imageView3

       setListener(cardView1, imageView1)
        setListener(cardView2, imageView2)
        setListener(cardView3, imageView3)


    }
//
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val heightInPixels = 1500
        dialog.behavior.peekHeight = heightInPixels
        return dialog
    }

    private fun setListener(cardView: CardView, imageView: ImageView){
        cardView.setOnClickListener{
            bottomSheetBinding.closeBottomSheet.text = "Ndrysho"
            if(imageView.tag == "unchecked"){
                imageView.setImageResource(R.drawable.checked)
                imageView.tag = "checked"
            }else{
                imageView.setImageResource(R.drawable.unchecked)
                imageView.tag = "unchecked"
            }
        }
    }
}