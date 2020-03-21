package com.jty.dandelion.register.ui


import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.google.android.material.textfield.TextInputEditText
import com.jty.dandelion.R
import com.jty.dandelion.application.DandelionApplication
import com.jty.dandelion.dialog.DatePickerFragmentDialog
import com.jty.dandelion.register.bean.User
import com.jty.dandelion.register.viewmodel.RegisterViewModel
import com.jty.expand.emptyHint
import com.jty.expand.getViewModel
import com.jty.expand.showToast
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

    private fun initView() {
        register_aet_birthday.inputType = InputType.TYPE_NULL
        register_aet_birthday.setOnFocusChangeListener { view, b ->
            if (b) {
                val dialog = getDatePickerFragmentDialog(view)
                dialog.show(parentFragmentManager, "DatePickerFragmentDialog")
            }
        }
        register_aet_birthday.setOnClickListener {
            var dialog =
                parentFragmentManager.findFragmentByTag("DatePickerFragmentDialog") as? DatePickerFragmentDialog
            if (dialog == null) {
                dialog = getDatePickerFragmentDialog(it)
            }
            dialog.show(parentFragmentManager, "DatePickerFragmentDialog")
        }
        initRegisterButton()
    }

    private fun getData(): User? {
        var isEmpty: Boolean
        val emptyErrorText = resources.getString(R.string.empty_error_text)
        val name = register_aet_name.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_name) }
        val email = register_aet_email.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_email) }
        val password = register_aet_password.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_password) }
        val re_password = register_aet_re_password.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_re_password) }
        val birthday = register_aet_birthday.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_birthday) }
        val phone = register_aet_phone.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_phone) }
        val school = register_aet_school.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_school) }
        val college = register_aet_college.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_college) }
        val classId = register_aet_class.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_class) }
        val studentId = register_aet_student_id.text.toString().trim()
            .apply { isEmpty = emptyHint(emptyErrorText, register_til_student_id) }
        val sex = when (rg_sex.checkedRadioButtonId) {
            rb_male.id -> resources.getString(R.string.male)
            else -> resources.getString(R.string.female)
        }
        val createtime = System.currentTimeMillis()
        if (isEmpty || !checkPasswordSame(password, re_password)) {
            return null
        }
        return User(
            name = name,
            email = email,
            password = password,
            sex = sex,
            birthday = birthday,
            phone = phone,
            school = school,
            college = college,
            classId = classId,
            createtime = createtime,
            lastonlinetime = createtime,
            studentId = studentId
        )
    }

    private fun initRegisterButton() {
        val viewModel = getViewModel<RegisterViewModel>()
        viewModel.registerResult.observe(this){
            activity?.showToast(it.message)
        }
        tv_register.setOnClickListener {
            val user = getData() ?: return@setOnClickListener
            getViewModel<RegisterViewModel>().registerUser(user)
        }
    }

    private fun checkPasswordSame(password: String, re_password: String): Boolean {
        if (password != re_password) {
            val notSameText = resources.getString(R.string.un_same_error_text)
            register_til_password.error = notSameText
            register_til_re_password.error = notSameText
            return false
        }
        return true
    }

    private fun getDatePickerFragmentDialog(view: View): DatePickerFragmentDialog{
       return DatePickerFragmentDialog { year, month, day ->
            (view as? TextInputEditText)?.setText(
                String.format(
                    resources.getString(R.string.birthday),
                    year,
                    month,
                    day
                )
            )
        }
    }
}
