package com.google.sample.cloudvision;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    
    // 비밀번호 정규식
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$");

    // 파이어베이스 인증 객체 생성
    private FirebaseAuth firebaseAuth;

    // 이메일과 비밀번호
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPwcheck;

    private String email = "";
    private String password = "";
    private String pwcheck = "";

    // 장르 체크박스
    private CheckBox s1;    private CheckBox s2;    private CheckBox s3;    private CheckBox s4;
    private CheckBox s5;    private CheckBox s6;    private CheckBox s7;    private CheckBox s8;
    private CheckBox s9;    private CheckBox s10;    private CheckBox s11;    private CheckBox s12;
    private CheckBox s13;    private CheckBox s14;    private CheckBox s15;    private CheckBox s16;
    private CheckBox s17;    private CheckBox s18;    private CheckBox s19;    private CheckBox s20;
    private CheckBox s21;
    private String result = "";

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 파이어베이스 인증 객체 선언
        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.et_eamil);
        editTextPassword = findViewById(R.id.et_password);
        editTextPwcheck = findViewById(R.id.et_password_check);

        s1 = findViewById(R.id.s_1);        s2 = findViewById(R.id.s_2);        s3 = findViewById(R.id.s_3);
        s4 = findViewById(R.id.s_4);        s5 = findViewById(R.id.s_5);        s6 = findViewById(R.id.s_6);
        s7 = findViewById(R.id.s_7);        s8 = findViewById(R.id.s_8);        s9 = findViewById(R.id.s_9);
        s10 = findViewById(R.id.s_10);        s11 = findViewById(R.id.s_11);        s12 = findViewById(R.id.s_12);
        s13 = findViewById(R.id.s_13);        s14 = findViewById(R.id.s_14);        s15 = findViewById(R.id.s_15);
        s16 = findViewById(R.id.s_16);        s17 = findViewById(R.id.s_17);        s18 = findViewById(R.id.s_18);
        s19 = findViewById(R.id.s_19);        s20 = findViewById(R.id.s_20);        s21 = findViewById(R.id.s_21);

    }

    public void singUp(View view) {
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        pwcheck = editTextPwcheck.getText().toString();

        if(isValidEmail() && isValidPasswd()) {
            createUser(email, password);
        }


    }


    // 이메일 유효성 검사
    private boolean isValidEmail() {
        if (email.isEmpty()) {
            // 이메일 공백
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // 이메일 형식 불일치
            return false;
        } else {
            return true;
        }
    }

    // 비밀번호 유효성 검사
    private boolean isValidPasswd() {
        if (password.isEmpty()) {
            // 비밀번호 공백
            Toast.makeText(RegisterActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            // 비밀번호 형식 불일치
            Toast.makeText(RegisterActivity.this, "잘못된 비밀번호 형식입니다.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!password.equals(pwcheck)) {
            // 비밀번호 더블체크
            Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    // 회원가입
    private void createUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공

                            if(s1.isChecked()) result += s1.getText().toString() + ", ";
                            if(s2.isChecked()) result += s2.getText().toString() + ", ";
                            if(s3.isChecked()) result += s3.getText().toString() + ", ";
                            if(s4.isChecked()) result += s4.getText().toString() + ", ";
                            if(s5.isChecked()) result += s5.getText().toString() + ", ";
                            if(s6.isChecked()) result += s6.getText().toString() + ", ";
                            if(s7.isChecked()) result += s7.getText().toString() + ", ";
                            if(s8.isChecked()) result += s8.getText().toString() + ", ";
                            if(s9.isChecked()) result += s9.getText().toString() + ", ";
                            if(s10.isChecked()) result += s10.getText().toString() + ", ";
                            if(s11.isChecked()) result += s11.getText().toString() + ", ";
                            if(s12.isChecked()) result += s12.getText().toString() + ", ";
                            if(s13.isChecked()) result += s13.getText().toString() + ", ";
                            if(s14.isChecked()) result += s14.getText().toString() + ", ";
                            if(s15.isChecked()) result += s15.getText().toString() + ", ";
                            if(s16.isChecked()) result += s16.getText().toString() + ", ";
                            if(s17.isChecked()) result += s17.getText().toString() + ", ";
                            if(s18.isChecked()) result += s18.getText().toString() + ", ";
                            if(s19.isChecked()) result += s19.getText().toString() + ", ";
                            if(s20.isChecked()) result += s20.getText().toString() + ", ";
                            if(s21.isChecked()) result += s21.getText().toString() + ", ";

                            Toast.makeText(RegisterActivity.this, R.string.success_signup, Toast.LENGTH_SHORT).show();

                            //데이터베이스 입력
                            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    User user = new User(email, result);
                                    StringTokenizer st = new StringTokenizer(email, "@");
                                    myRef.child(st.nextToken()).setValue(user);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            // 회원가입 실패
                            Toast.makeText(RegisterActivity.this, R.string.failed_signup, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void back(View view) {
        //Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        //startActivity(intent);
        finish();
    }



}
