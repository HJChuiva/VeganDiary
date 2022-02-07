package com.example.vegandiary.Activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.NestedScrollView
import com.example.vegandiary.R
import com.example.vegandiary.Helper.InputValidation
import com.example.vegandiary.Model.User
import com.example.vegandiary.Helper.DatabaseHelper
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private val activity: AppCompatActivity = this@RegisterActivity
    private var nestedScrollView: NestedScrollView? = null
    private var textInputLayoutName: TextInputLayout? = null
    private var textInputLayoutEmail: TextInputLayout? = null
    private var textInputLayoutPassword: TextInputLayout? = null
    private var textInputLayoutConfirmPassword: TextInputLayout? = null
    private var textInputEditTextName: TextInputEditText? = null
    private var textInputEditTextEmail: TextInputEditText? = null
    private var textInputEditTextPassword: TextInputEditText? = null
    private var textInputEditTextConfirmPassword: TextInputEditText? = null
    private var appCompatButtonRegister: AppCompatButton? = null
    private var appCompatTextViewLoginLink: AppCompatTextView? = null
    private var inputValidation: InputValidation? = null
    private var databaseHelper: DatabaseHelper? = null
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
//        supportActionBar!!.hide()
        initViews()
        initListeners()
        initObjects()
    }

    private fun initViews() {
        nestedScrollView = findViewById<View>(R.id.nestedScrollView) as NestedScrollView
        textInputLayoutName = findViewById<View>(R.id.textInputLayoutName) as TextInputLayout
        textInputLayoutEmail = findViewById<View>(R.id.textInputLayoutEmail) as TextInputLayout
        textInputLayoutPassword = findViewById<View>(R.id.textInputLayoutPassword) as TextInputLayout
        textInputLayoutConfirmPassword = findViewById<View>(R.id.textInputLayoutConfirmPassword) as TextInputLayout
        textInputEditTextName = findViewById<View>(R.id.textInputEditTextName) as TextInputEditText
        textInputEditTextEmail = findViewById<View>(R.id.textInputEditTextEmail) as TextInputEditText
        textInputEditTextPassword = findViewById<View>(R.id.textInputEditTextPassword) as TextInputEditText
        textInputEditTextConfirmPassword = findViewById<View>(R.id.textInputEditTextConfirmPassword) as TextInputEditText
        appCompatButtonRegister = findViewById<View>(R.id.appCompatButtonRegister) as AppCompatButton
        appCompatTextViewLoginLink = findViewById<View>(R.id.appCompatTextViewLoginLink) as AppCompatTextView
    }

    private fun initListeners() {
        appCompatButtonRegister!!.setOnClickListener(this)
        appCompatTextViewLoginLink!!.setOnClickListener(this)
    }

    private fun initObjects() {
        inputValidation = InputValidation(activity)
        databaseHelper = DatabaseHelper(activity)
        user = User()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.appCompatButtonRegister -> postDataToSQLite()
            R.id.appCompatTextViewLoginLink -> finish()
        }
    }

    private fun postDataToSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(
                textInputEditTextName!!,
                textInputLayoutName!!, "Enter Full Name"
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(
                textInputEditTextEmail!!,
                textInputLayoutEmail!!, "Enter Full Name"
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(
                textInputEditTextEmail!!,
                textInputLayoutEmail!!, "Enter Valid Email"
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(
                textInputEditTextPassword!!,
                textInputLayoutPassword!!, "Enter Password"
            )
        ) {
            return
        }
        if (!inputValidation!!.isInputEditTextMatches(
                textInputEditTextPassword!!, textInputEditTextConfirmPassword!!,
                textInputLayoutConfirmPassword!!, "Password Does Not Matches"
            )
        ) {
            return
        }
        if (!databaseHelper!!.checkUser(
                textInputEditTextEmail!!.text.toString().trim { it <= ' ' })
        ) {
            user!!.name = textInputEditTextName!!.text.toString().trim { it <= ' ' }
            user!!.email = textInputEditTextEmail!!.text.toString().trim { it <= ' ' }
            user!!.password = textInputEditTextPassword!!.text.toString().trim { it <= ' ' }
            databaseHelper!!.addUser(user!!)

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(
                nestedScrollView!!,
                "Registration Successful!",
                Snackbar.LENGTH_LONG
            ).show()
            emptyInputEditText()
        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(
                nestedScrollView!!,
                "Email Already Exists!",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun emptyInputEditText() {
        textInputEditTextName!!.text = null
        textInputEditTextEmail!!.text = null
        textInputEditTextPassword!!.text = null
        textInputEditTextConfirmPassword!!.text = null
    }
}