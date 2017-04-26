package br.edu.ifsp.arq.semif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifsp.arq.semif.entity.User;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind (ligação) dos componentes da interface visual com os nossos atributos Java:
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtPassword = (EditText) findViewById(R.id.etSenha);
        mBtLogin = (Button) findViewById(R.id.btEntrar);

        //TODO (6) Utilizar o conceito de label flutuante (Material Design)
        // http://stackoverflow.com/a/30571825/3072570

        // Configura um evento de click para o nosso botão:
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO (7) Ajustar as validações (usando TextInputLayout)
                // http://stackoverflow.com/q/30953449/3072570

                // Valida os campos Email e Senha:
                boolean isValid = true;
                if (TextUtils.isEmpty(mEtEmail.getText())) {
                    mEtEmail.setError(getString(R.string.msg_required));
                    isValid = false;
                } else {
                    mEtEmail.setError(null);
                }
                if (TextUtils.isEmpty(mEtPassword.getText())) {
                    mEtPassword.setError(getString(R.string.msg_required));
                    isValid = false;
                } else {
                    mEtPassword.setError(null);
                }
                if (isValid) {
                    // Caso os campos sejam válidos, criamos um objeto "User":
                    final User user = new User();
                    user.setEmail(mEtEmail.getText().toString());

                    //TODO (1) Redirecionar para a ListViewActivity via Intent (falar sobre Parcelable)
                    // https://developer.android.com/training/basics/firstapp/starting-activity.html

                    //TODO (2) Registrar a ListViewActivity no AndroidManifest.xml
                }
            }
        });
    }
}
