package br.unicamp.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListaAlunosAdapter extends ArrayAdapter<Aluno> {
    private Context context;
    private List<Aluno> alunos = null;

    public ListaAlunosAdapter(Context context, List<Aluno> alunos) {
        super(context, 0, alunos);

        this.alunos = alunos;
        this.context = context;
    }

    //Sobrescreve o método getView()
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //Posição do item em meio aos dados do Adapter
        Aluno aluno = alunos.get(position);

        //Infla o xml lista_itens.xml
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.lista_itens, null);

        //Cria uma view de imagem
        ImageView imageViewAluno = (ImageView) view.findViewById(R.id.image_view_aluno); imageViewAluno.setImageResource(aluno.getImagem());

        //Cria uma view de texto
        TextView textViewModeloCarro = (TextView) view.findViewById(R.id.text_view_modelo_aluno);
        textViewModeloCarro.setText(aluno.getNome());

        //Retorna o objeto view
        return view;
    }
}
