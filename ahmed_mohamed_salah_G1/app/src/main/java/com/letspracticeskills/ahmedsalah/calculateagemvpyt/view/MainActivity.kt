package com.letspracticeskills.ahmedsalah.calculateagemvpyt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.letspracticeskills.ahmedsalah.calculateagemvpyt.R
import com.letspracticeskills.ahmedsalah.calculateagemvpyt.model.Person
import com.letspracticeskills.ahmedsalah.calculateagemvpyt.presenter.CalculateAgePresenter
import com.letspracticeskills.ahmedsalah.calculateagemvpyt.presenter.ICalculateAgePresenter

class MainActivity : AppCompatActivity(), CalculateAgePresenter.View {

    lateinit var calculateAgePresenter: ICalculateAgePresenter

    lateinit var textViewInfo: TextView
    lateinit var editTextAge: EditText
    lateinit var editTextName: EditText
    lateinit var buttonCalculateAge: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateAgePresenter = CalculateAgePresenter(this)

        textViewInfo = findViewById(R.id.textView_your_age)
        editTextName = findViewById(R.id.editText_name)
        editTextAge = findViewById(R.id.editText_age)
        buttonCalculateAge = findViewById(R.id.button_calculate_age)

        buttonCalculateAge.setOnClickListener {

            val name = editTextName.text.trim().toString()
            val age = editTextAge.text.trim().toString()

            calculateAgePresenter.calculateYourAge(name, age)
        }

    }

    override fun getInfo(person: Person) {
        textViewInfo.text = "${person.name} your age: ${person.age}"
    }
}