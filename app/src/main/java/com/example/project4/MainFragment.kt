package com.example.project4

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.button.MaterialButton


class MainFragment : Fragment() {

    private lateinit var sendButton: MaterialButton
    private lateinit var authButton: MaterialButton
    private lateinit var createButton: MaterialButton
    private lateinit var codeEditText: EditText
    private val apiViewModel: ApiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            sendButton = findViewById(R.id.SendButton)
            authButton = findViewById(R.id.AuthButton)
            createButton = findViewById(R.id.CreateProfileButton)
            codeEditText = findViewById(R.id.EmailCodeEditText)
        }
        sendButton.setOnClickListener(OnSendButtonClickListener)
        sendButton.setOnClickListener(OnAuthButtonClickListener)
        sendButton.setOnClickListener(OnCreateButtonClickListener)
    }

    private val OnSendButtonClickListener = OnClickListener {
        apiViewModel.SendCode("malyshkin_04@bk.ru")
    }

    private val OnAuthButtonClickListener = OnClickListener {
        apiViewModel.AuthProfile("")
    }

    private val OnCreateButtonClickListener = OnClickListener {
        apiViewModel.AuthProfile("")
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}