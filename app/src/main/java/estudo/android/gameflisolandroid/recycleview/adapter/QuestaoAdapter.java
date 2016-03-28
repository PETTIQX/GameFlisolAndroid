package estudo.android.gameflisolandroid.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import estudo.android.gameflisolandroid.R;
import estudo.android.gameflisolandroid.models.Questao;

/**
 * Created by jordy on 26/03/16.
 */
public class QuestaoAdapter extends RecyclerView.Adapter<QuestaoAdapter.QuestaoViewHolder> {

    private Context context;
    private List<Questao> questoes;

    public QuestaoAdapter(Context context,List<Questao> questoes)
    {
        this.context = context;
        this.questoes = questoes;
    }

    @Override
    public QuestaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_pergunta,parent);
        QuestaoViewHolder vholder = new QuestaoViewHolder(view);
        return vholder;
    }

    @Override
    public void onBindViewHolder(QuestaoViewHolder holder, int position) {
        Questao q = questoes.get(position);
        //TODO os models nao batem com a minha descricao visual do app. falar com SANDRO

    }


    @Override
    public int getItemCount() {
        return questoes.size();
    }

    class QuestaoViewHolder extends RecyclerView.ViewHolder
    {
        private TextView titulo;
        private TextView descricao;
        private ImageView imgView;

        public QuestaoViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.txtTitulo);
            descricao = (TextView) itemView.findViewById(R.id.txtDescricao);
            imgView = (ImageView) itemView.findViewById(R.id.imgStatusDaQuestao);

        }
    }
}
