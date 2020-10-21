package com.test.myapplication

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.textfield.TextInputEditText

object BindingAdapter {

    @BindingAdapter("android:textOfSets")
    @JvmStatic
    fun setTextOfSets(view: TextInputEditText, newValue: String?) {
        if(newValue == null) return
        if (view.text.toString() != newValue) view.text = Editable.Factory.getInstance().newEditable(newValue)
    }

    @InverseBindingAdapter(attribute = "android:textOfSets", event = "textOfSetsAttrChanged")
    @JvmStatic
    fun getTextOfSets(view: TextInputEditText): String {
        return view.text.toString()
    }

    @JvmStatic
    @BindingAdapter("textOfSetsAttrChanged")
    fun setTextListeners(view: TextInputEditText, attrChange: InverseBindingListener) {
        view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                attrChange.onChange()
            }
        })
    }
}