package com.jty.dandelion.register.ui


import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.jty.dandelion.R
import com.jty.dandelion.dialog.DatePickerFragmentDialog
import kotlinx.android.synthetic.main.fragment_register.*


/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView(){
        register_aet_birthday.inputType = InputType.TYPE_NULL
        register_aet_birthday.setOnFocusChangeListener { view, b ->
            if (b) {
                val dialog = DatePickerFragmentDialog { year, month, day ->
                    (view as? TextInputEditText)?.setText(
                        String.format(
                            resources.getString(R.string.birthday),
                            year,
                            month,
                            day
                        )
                    )
                }
                dialog.show(parentFragmentManager, "DatePickerFragmentDialog")
            }
        }
        register_aet_birthday.setOnClickListener {
            var dialog = parentFragmentManager.findFragmentByTag("DatePickerFragmentDialog") as? DatePickerFragmentDialog
            if (dialog == null) {
                dialog = DatePickerFragmentDialog { year, month, day ->
                    (it as? TextInputEditText)?.setText(
                        String.format(
                            resources.getString(R.string.birthday),
                            year,
                            month,
                            day
                        )
                    )
                }
            }
            dialog.show(parentFragmentManager, "DatePickerFragmentDialog")
        }
    }

}
