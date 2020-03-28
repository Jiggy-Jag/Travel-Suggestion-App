package android.example.travelsuggestion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.example.travelsuggestion.Retrofit.INodeJS;
import android.example.travelsuggestion.Retrofit.RetrofitClient;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LoginScreen<LoginDialogFragment> extends AppCompatActivity {

    INodeJS myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    EditText edt_email, edt_password;
    Button btn_login, btn_register;

    @Override
    protected void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //INIT API
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INodeJS.class);

        //View
        btn_login = (Button)findViewById(R.id.login);
        btn_register = (Button)findViewById(R.id.register);

        edt_email = (EditText)findViewById(R.id.LoginUsername);
        edt_password = (EditText)findViewById(R.id.LoginPassword);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });
        

    }

    private void registerUser(String email, String password) {

        View register_user_view = LayoutInflater.from(this).inflate(R.layout.register_user, null);

        new AlertDialog.Builder(this)
                .setTitle("Register")
                .setMessage("Please enter your details below to register")
                .setView(register_user_view)
                .setIcon(R.drawable.icon_padlock)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .setPositiveButton(R.string.register, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked Register button
                EditText edt_name = (EditText)register_user_view.findViewById(R.id.edt_name);
                        EditText new_email = (EditText)register_user_view.findViewById(R.id.new_email);
                        EditText new_password = (EditText)register_user_view.findViewById(R.id.new_password);

                        compositeDisposable.add(myAPI.registerUser(new_email.getText().toString(),edt_name.getText().toString(),new_password.getText().toString())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<String>() {
                                    @Override
                                    public void accept(String s) throws Exception {
                                Toast.makeText(LoginScreen.this, ""+s, Toast.LENGTH_SHORT).show();
                                    }
                                }));

            }
        }).show();
    }

    private void loginUser(String email, String password) {
        compositeDisposable.add(myAPI.loginUser(email, password)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                    if(s.contains("encrypted_password")){
                        Toast.makeText(LoginScreen.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(LoginScreen.this, ""+s, Toast.LENGTH_SHORT).show();
                    }
                })
        );
        }
        }


    /*public void Login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

