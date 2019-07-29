package com.bhatt.vishal.ignou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TextInputLayout;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

import static com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Prompt.SIGN_IN;

public class Login extends Activity implements TextToSpeech.OnInitListener {
    Button log;
    private Vibrator vib;
    Animation animShake;
    EditText e1, e2;
    String s1,s2;
    CheckBox ck;
    TextToSpeech tts;
    String msg = "Welcome to Your Home Page";
    private boolean mohan = false;
    SignInButton signInButton;
    TextInputLayout signupInputLayoutName, signupInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.float_edit_animated);

        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        tts = new TextToSpeech(this, this);
        signupInputLayoutName = (TextInputLayout) findViewById(R.id.signup_input_layout_name);
        signupInputPassword = (TextInputLayout) findViewById(R.id.signup_input_layout_email);
        log = (Button) findViewById(R.id.loginn);
        e1 = (EditText) findViewById(R.id.useredit);
        e2 = (EditText) findViewById(R.id.userpass);
        ck = (CheckBox) findViewById(R.id.checkBox);
        animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    // Start sign in/sign up activity
                    startActivityForResult(
                            AuthUI.getInstance().createSignInIntentBuilder().build(),
                            SIGN_IN);
                } else {
                    // User is already signed in. Therefore, display
                    // a welcome Toast
                    Intent i = new Intent(Login.this, Years.class);
                    startActivity(i);
                    Toast.makeText(Login.this,
                            "Welcome " + FirebaseAuth.getInstance()
                                    .getCurrentUser()
                                    .getDisplayName(),
                            Toast.LENGTH_LONG)
                            .show();

                    // Load chat room contents
                    //displayChatMessages();
                }

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                //String email = e2.getText().toString().trim();
                if (s1.contentEquals("admin") && s2.contentEquals("123")) {
                    //Toast.makeText(Login.this, "Welcome Administrator", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Years.class);
                    e1.setText(" ");
                    e2.setText(" ");
                    startActivity(i);
                    tts.speak(msg, TextToSpeech.QUEUE_ADD, null);

                } else {
                    submitForm();
                }
            }
        });
        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean vishal) {
                if (!vishal) {
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        //.............other stuff in my onResume ....
        this.mohan = false;
    }
    @Override
    public void onBackPressed() {
        if (mohan) {
            super.onBackPressed();
            return;
        } else {
            this.mohan = true;
            Toast.makeText(this, "Press twice to exit", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.ENGLISH);
        tts.setSpeechRate(0.8f);
    }

    public void submitForm() {

        if (!checkName()) {
            e1.setAnimation(animShake);
            e1.startAnimation(animShake);
            vib.vibrate(120);
            return;
        } else if (!checkPassword()) {
            e2.setAnimation(animShake);
            e2.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        signupInputLayoutName.setErrorEnabled(false);
        signupInputPassword.setErrorEnabled(false);

        // Toast.makeText(getApplicationContext(), "You are successfully Registered !!", Toast.LENGTH_SHORT).show();
    }

    private boolean checkName() {
        if (e1.getText().toString().trim().isEmpty() || s1.contentEquals("admin") == false) {

            signupInputLayoutName.setErrorEnabled(true);
            signupInputLayoutName.setError(getString(R.string.err_msg_name));
            e1.setError(getString(R.string.err_msg_required));
            return false;
        }
        signupInputLayoutName.setErrorEnabled(false);
        return true;
    }

    private boolean checkPassword() {
        if (e2.getText().toString().trim().isEmpty() || s2.contentEquals("123") == false) {

            e2.setError(getString(R.string.err_msg_password));
            requestFocus(signupInputPassword);
            return false;
        }
        signupInputPassword.setErrorEnabled(false);
        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Intent i = new Intent(Login.this, Years.class);
                startActivity(i);
                Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();
                //displayChatMessages();
            } else {
                Toast.makeText(this,
                        "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG)
                        .show();

                // Close the app
                finish();
            }
        }

    }
}