package com.jty.dandelion.dialog


import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigator
import com.jty.dandelion.R
import kotlinx.android.synthetic.main.fragment_date_picker_fragment_dialog.*

/**
 * A simple [Fragment] subclass.
 *
 */
@Navigator.Name("dialog")
class DatePickerFragmentDialog(val onDateSet : (year:Int, month: Int ,day: Int) -> Unit) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_date_picker_fragment_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isCancelable = true
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
        val window =dialog?.window
        window?.setGravity(Gravity.BOTTOM)
        window?.decorView?.setPadding(0,0,0,0)
        window?.setWindowAnimations(R.style.BottomDialogAnimation)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCancel(dialog: DialogInterface) {
        onDateSet(date_picker.year, date_picker.month, date_picker.dayOfMonth)
    }

}
