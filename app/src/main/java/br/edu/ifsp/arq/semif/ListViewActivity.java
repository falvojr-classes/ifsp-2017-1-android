package br.edu.ifsp.arq.semif;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
                //TODO (4) Realizar uma chamada telefônica via Intent
                // http://stackoverflow.com/a/13123613/3072570
            }
        });

        // Configura um evento de click LONGO para cada item do ListView:
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO (5) Realizar compartilhamento via Intent
                // https://developer.android.com/training/sharing/send.html
                return false;
            }
        });

        //TODO (3) Dizer "Olá" para o usuário logado (via Toast ou Snackbar)
        // https://developer.android.com/guide/topics/ui/notifiers/toasts.html
        // https://developer.android.com/training/snackbar/action.html
    }
}
