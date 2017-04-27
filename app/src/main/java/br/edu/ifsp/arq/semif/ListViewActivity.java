package br.edu.ifsp.arq.semif;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.edu.ifsp.arq.semif.entity.User;

public class ListViewActivity extends AppCompatActivity {

    public static final String KEY_USER = "MY_USER_KEY";

    private static final String[] PHONES = {
            "+55 16 111111111",
            "+55 16 222222222",
            "+55 16 333333333",
            "+55 16 444444444",
            "+55 16 555555555",
            "+55 16 666666666",
            "+55 16 777777777",
            "+55 16 888888888",
            "+55 16 999999999"
    };

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView = (ListView) findViewById(R.id.lvTelefones);

        // Cria um adaptador simples para os itens do ListView
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, PHONES);
        mListView.setAdapter(mAdapter);

        // Configura um evento de click para cada item do ListView:
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //FEITO (4) Realizar uma chamada telefônica via Intent
                // http://stackoverflow.com/a/13123613/3072570
                Uri tel = Uri.parse("tel:" + PHONES[position]);
                Intent i = new Intent(Intent.ACTION_DIAL, tel);
                startActivity(i);
            }
        });

        // Configura um evento de click LONGO para cada item do ListView:
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //FEITO (5) Realizar compartilhamento via Intent
                // https://developer.android.com/training/sharing/send.html
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, mUser.getEmail());
                i.setType("text/plain");
                startActivity(i);
                return true;
            }
        });

        //FEITO (3) Dizer "Olá" para o usuário logado (via Toast ou Snackbar)
        // https://developer.android.com/guide/topics/ui/notifiers/toasts.html
        // https://developer.android.com/training/snackbar/action.html
        mUser = getIntent().getParcelableExtra(KEY_USER);
        String msg = getString(R.string.msg_hello, mUser.getEmail());
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}
