package com.example.autoshkollaui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.autoshkollaui.databinding.CustomAlertDialogBinding

class CutomDialog:DialogFragment() {

    private lateinit var customAlertDialogBinding: CustomAlertDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        customAlertDialogBinding = DataBindingUtil.inflate(requireActivity().layoutInflater, R.layout.custom_alert_dialog, null,false)
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(customAlertDialogBinding.root)


        val yesButton = customAlertDialogBinding.yes
        yesButton.setOnClickListener{
            requireActivity().finish()
            dialog?.cancel()
        }

        val noButton = customAlertDialogBinding.no
        noButton.setOnClickListener{
            dialog?.cancel()
        }

        return builder.create()
    }
}